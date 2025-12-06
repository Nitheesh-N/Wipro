package com.playstore.owner.controller;

import com.playstore.owner.dto.AuthRequest;
import com.playstore.owner.dto.AuthResponse;
import com.playstore.owner.model.Owner;
import com.playstore.owner.security.JwtService;
import com.playstore.owner.service.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owners")
@CrossOrigin(origins = "*")
public class OwnerController {

    private final OwnerService service;
    private final JwtService jwtService;

    public OwnerController(OwnerService service, JwtService jwtService) {
        this.service = service;
        this.jwtService = jwtService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Owner owner) {
        Owner saved = service.register(owner);
        return ResponseEntity.ok("Owner registered with id " + saved.getId());
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Owner existing = service.loginRaw(request.getEmail(), request.getPassword());
        if (existing == null) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
        String token = jwtService.generateToken(existing.getEmail());
        return ResponseEntity.ok(new AuthResponse(token, existing.getId()));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Owner logged out");
    }
    
    @GetMapping
    public ResponseEntity<?> getAllOwners() {
        return ResponseEntity.ok(service.getAllOwners());
    }

}
