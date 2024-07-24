package com.rg.usuariosapi.infraestructure.repository;


import com.rg.usuariosapi.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interface de las operationces del Repository del USER
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Metodo que va a devolver un usuario a partir del email del usuario
     */
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
