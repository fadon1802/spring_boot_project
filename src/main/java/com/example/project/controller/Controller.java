package com.example.project.controller;

import com.example.project.dto.UserDTO;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/public/api")
    public UserDTO publicApi(Authentication userAuthentication) {
        return new UserDTO(userAuthentication.getName(), userAuthentication.getAuthorities().toString());
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/admin/api")
    public UserDTO adminApi(Authentication userAuthentication) {
        return new UserDTO(userAuthentication.getName(), userAuthentication.getAuthorities().toString());
    }

    @RolesAllowed("SUPPORT")
    @GetMapping("/support/api")
    public UserDTO supportApi(Authentication userAuthentication) {
        return new UserDTO(userAuthentication.getName(), userAuthentication.getAuthorities().toString());
    }
}
