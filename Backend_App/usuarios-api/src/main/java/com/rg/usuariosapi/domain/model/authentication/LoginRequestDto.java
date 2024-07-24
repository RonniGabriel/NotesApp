package com.rg.usuariosapi.domain.model.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

    /**
     * Atributo de Username
     */
    private String username;

    /**
     * Atributo de Password
     */
    private String password;
}
