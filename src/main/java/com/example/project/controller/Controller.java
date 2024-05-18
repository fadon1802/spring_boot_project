package com.example.project.controller;

import com.example.project.dto.UserDTO;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/public/api")
    public String publicApi() {
        return "This is a public API";
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/admin/api")
    public ResponseEntity<UserDTO> adminApi(Authentication userAuthentication) {
        return ResponseEntity.ok().body(new UserDTO(userAuthentication.getName(), userAuthentication.getAuthorities().toString()));
    }

    @RolesAllowed("SUPPORT")
    @GetMapping("/support/api")
    public ResponseEntity<UserDTO> supportApi(Authentication userAuthentication) {
        return ResponseEntity.ok().body(new UserDTO(userAuthentication.getName(), userAuthentication.getAuthorities().toString()));
    }
}
