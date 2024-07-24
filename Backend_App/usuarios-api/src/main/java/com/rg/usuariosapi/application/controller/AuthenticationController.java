package com.rg.usuariosapi.application.controller;


import com.rg.usuariosapi.domain.model.authentication.AuthenticationResponseDto;
import com.rg.usuariosapi.domain.model.authentication.LoginRequestDto;
import com.rg.usuariosapi.domain.model.authentication.RegisterRequestDto;
import com.rg.usuariosapi.infraestructure.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    /**
     * Endpoint para el login de la app
     */
    @PostMapping(value = "login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authenticationService.login(loginRequestDto));
    }

    /**
     * Endpoint para el registro de un nuevo usuario  de la app
     */
    @PostMapping(value = "registro")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
        return ResponseEntity.ok(authenticationService.register(registerRequestDto));
    }
}
