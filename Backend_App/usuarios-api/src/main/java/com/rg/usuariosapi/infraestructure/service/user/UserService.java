package com.rg.usuariosapi.infraestructure.service.user;


import com.rg.usuariosapi.domain.model.user.UserDto;
import com.rg.usuariosapi.domain.model.user.UserResponseDto;

/**
 * Interfaz para todas las operaciones relacionadas con el Usuario
 */
public interface UserService {

    UserResponseDto getUser(String email);

    String updateUser(UserDto userDto);

    String updatePassword(String newPassword);

    String getPassword(String email);

}
