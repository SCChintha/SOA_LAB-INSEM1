package com.example.jwtvalidation.controller;

import com.example.jwtvalidation.dto.*;
import com.example.jwtvalidation.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jwt")
public class JwtValidationController {

    private final JwtService service;

    public JwtValidationController(JwtService service) {
        this.service = service;
    }

    @PostMapping("/validate")
    public ResponseEntity<JwtValidationResponse> validate(
            @RequestBody JwtValidationRequest request) {
        try {
            Claims claims = service.validateToken(request.getToken());

            return ResponseEntity.ok(new JwtValidationResponse(
                true, "Token Valid",
                claims.getSubject(),
                claims.get("roles") != null
                    ? claims.get("roles") : claims.get("role")
            ));
        } catch (JwtException | IllegalArgumentException e) {
            return ResponseEntity.status(401).body(
                new JwtValidationResponse(
                    false, "Invalid Token", null, null));
        }
    }
}