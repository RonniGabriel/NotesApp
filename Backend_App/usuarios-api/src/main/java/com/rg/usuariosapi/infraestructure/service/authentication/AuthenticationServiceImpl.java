package com.rg.usuariosapi.infraestructure.service.authentication;


import com.rg.usuariosapi.application.messages.Messages;
import com.rg.usuariosapi.domain.model.authentication.AuthenticationResponseDto;
import com.rg.usuariosapi.domain.model.authentication.LoginRequestDto;
import com.rg.usuariosapi.domain.model.authentication.RegisterRequestDto;
import com.rg.usuariosapi.domain.model.user.User;
import com.rg.usuariosapi.domain.model.user.UserRole;
import com.rg.usuariosapi.infraestructure.repository.UserRepository;
import com.rg.usuariosapi.infraestructure.service.jwt.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;


    /**
     * Metodo que se encarga de permitir el acceso a la aplicacion
     *
     * @param loginRequestDto
     */
    @Override
    public AuthenticationResponseDto login(LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));

        UserDetails userExists = userRepository.findByUsername(loginRequestDto.getUsername()).orElseThrow();
        String token = jwtService.getToken(userExists);
        return AuthenticationResponseDto.builder().token(token).build();
    }

    /**
     * Metodo que se encarga de realizar el registro de un nuevo usuario en la aplicación
     *
     * @param registerRequestDto
     */
    @Override
    public AuthenticationResponseDto register(RegisterRequestDto registerRequestDto) {
        Optional<User> userExits = userRepository.findByEmail(registerRequestDto.getEmail());
        if (userExits.isPresent()) {
           throw new IllegalArgumentException(Messages.MSG_USUARIO_EXISTS);
        }


        User newUser = User.builder()
                .username(registerRequestDto.getUsername())
                .email(registerRequestDto.getEmail())
                .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                .firstName(registerRequestDto.getFirstName())
                .lastName(registerRequestDto.getLastName())
                .country(registerRequestDto.getCountry())
                .role(UserRole.USER)
                .build();
        userRepository.save(newUser);
        return AuthenticationResponseDto.builder().token(jwtService.getToken(newUser)).build();
    }


}
