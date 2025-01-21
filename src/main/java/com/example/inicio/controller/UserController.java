package com.example.inicio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.inicio.dto.RegisterUserRequest;
import com.example.inicio.model.User;
import com.example.inicio.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest request) {
        try {
            User user = userService.registerUser(request.getUsername(), request.getPassword(), request.getRole());
            return ResponseEntity.ok("Usuario registrado con éxito: " + user.getUsername());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
