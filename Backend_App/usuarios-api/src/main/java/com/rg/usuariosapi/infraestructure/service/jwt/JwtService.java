package com.rg.usuariosapi.infraestructure.service.jwt;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Interfaz de las operaciones relacionadas con el Token del Usuario
 */
public interface JwtService {

    /**
     * Método que devuelve el token relacionado al  usuario
     *
     * @param userDetails
     * @return String token
     */
    String getToken(UserDetails userDetails);

    String getUsernameFromToken(String token);

    boolean checkToken(String token, UserDetails userDetails);
}
