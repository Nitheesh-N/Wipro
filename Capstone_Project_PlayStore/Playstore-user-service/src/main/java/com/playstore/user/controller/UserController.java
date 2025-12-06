package com.playstore.user.controller;

import com.playstore.user.dto.AuthResponse;
import com.playstore.user.model.User;
import com.playstore.user.security.JwtService;
import com.playstore.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;
    private final JwtService jwtService;

    public UserController(UserService service, JwtService jwtService) {
        this.service = service;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        User saved = service.register(user);
        return ResponseEntity.ok("User registered with id " + saved.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existingUser = service.login(user.getEmail(), user.getPassword());
        if (existingUser == null) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }

        // real JWT with ROLE_USER
        String token = jwtService.generateToken(existingUser.getEmail(), "ROLE_USER");
        return ResponseEntity.ok(new AuthResponse(token, existingUser.getId()));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("User logged out");
    }
}
