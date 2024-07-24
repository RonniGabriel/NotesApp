package com.rg.usuariosapi.infraestructure.webservice;


import com.rg.usuariosapi.domain.model.user.UserDto;
import com.rg.usuariosapi.domain.model.user.UserResponseDto;
import com.rg.usuariosapi.infraestructure.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserApi {

    @Autowired
    UserService userservice;

    @GetMapping()
    public ResponseEntity<UserResponseDto> getUser(@RequestBody UserDto userDto) {

        UserResponseDto user = userservice.getUser(userDto.getEmail());

        if (user == null) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userservice.updateUser(userDto));
    }
}
