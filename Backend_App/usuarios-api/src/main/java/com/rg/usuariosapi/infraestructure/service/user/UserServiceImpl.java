package com.rg.usuariosapi.infraestructure.service.user;


import com.rg.usuariosapi.application.messages.Messages;
import com.rg.usuariosapi.domain.model.user.User;
import com.rg.usuariosapi.domain.model.user.UserDto;
import com.rg.usuariosapi.domain.model.user.UserResponseDto;
import com.rg.usuariosapi.domain.model.user.UserRole;
import com.rg.usuariosapi.infraestructure.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementación del UserService
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDto getUser(String email) {

        User user = userRepository.findByEmail(email).orElseThrow(null);
        if (user != null) {
            return UserResponseDto.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .firstname(user.getFirstName())
                    .lastname(user.getLastName())
                    .country(user.getCountry())
                    .email(user.getEmail()).build();
        }
        return null;
    }

    @Override
    public String updateUser(UserDto userDto) {
        User user = new User();
        Optional<User> idUser = userRepository.findByEmail(userDto.getEmail());
        if (idUser.isPresent()) {
            user.setId(idUser.get().getId());
            user.setFirstName(userDto.getFirstname());
            user.setLastName(userDto.getLastname());
            user.setUsername(userDto.getUsername());
            user.setCountry(userDto.getCountry());
            user.setRole(UserRole.USER);
            user.setEmail(userDto.getEmail());
            user.setPassword(getPassword(userDto.getEmail()));
            userRepository.save(user);

            return Messages.MSG_USER_UPDATE;
        }
        return Messages.MSG_USER_UPDATE_NOT_FOUND;

    }

    @Override
    public String updatePassword(String newPassword) {
        return null;
    }

    @Override
    public String getPassword(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            return userOptional.get().getPassword();
        }
        return Messages.MSG_USUARIO_NOT_EXISTS;
    }


}
