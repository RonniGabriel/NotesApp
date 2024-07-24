package com.rg.usuariosapi.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    /**
     * Nombre del Usuario
     */
    private String username;

    /**
     * Información del usuario: Nombre
     */
    private String firstname;

    /**
     * NInformación del usuario: Apellido
     */
    private String lastname;

    /**
     * Información del usuario: Pais
     */
    private String country;

    /**
     * Información del usuario
     */
    private String email;

}
