package com.rg.usuariosapi.domain.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User implements UserDetails {

    /**
     * Atributo de Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Atributo de Username
     */
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * Atributo de Email
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * Atributo de Password
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Atributo de LastName
     */
    @Column(name = "lastname", nullable = false)
    private String lastName;
    /**
     * Atributo de FirstName
     */
    @Column(name = "firstname", nullable = false)
    private String firstName;

    /**
     * Atributo de Country
     */
    @Column(name = "country")
    private String country;

    /**
     * Atributo de Role
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

