package com.rg.usuariosapi.domain.model.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    /**
     * Atributo de Username
     */
    private String username;

    /**
     * Atributo de Email
     */
    private String email;

    /**
     * Atributo de Password
     */
    private String password;

    /**
     * Atributo de First Name
     */
    private String firstName;

    /**
     * Atributo de Last Name
     */
    private String lastName;

    /**
     * Atributo de Country
     */
    private String country;


}
