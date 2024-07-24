package com.rg.usuariosapi.infraestructure.service.authentication;


import com.rg.usuariosapi.domain.model.authentication.AuthenticationResponseDto;
import com.rg.usuariosapi.domain.model.authentication.LoginRequestDto;
import com.rg.usuariosapi.domain.model.authentication.RegisterRequestDto;

/**
 * Interfaz de todas las operacioens relacionadas con el Servicio de Authentication
 */

public interface AuthenticationService {

    /**
     * Metodo que se encarga de permitir el acceso a la aplicacion
     */

    public AuthenticationResponseDto login(LoginRequestDto loginRequestDto);

    /**
     * Metodo que se encarga de realiar el registro de un nuevo usuario en la aplicación
     */
    public AuthenticationResponseDto register(RegisterRequestDto registerRequestDto);

}
