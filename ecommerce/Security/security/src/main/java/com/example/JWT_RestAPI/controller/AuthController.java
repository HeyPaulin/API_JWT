package com.example.JWT_RestAPI.controller;

import com.example.JWT_RestAPI.model.LoginRequest;
import com.example.JWT_RestAPI.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {


        String token = authService.generateToken(request.getUsername());
        return token;
    }


    @GetMapping("/username/{token}")
    public String extractUsername(@PathVariable String token) {

        String username = authService.extractUsername(token);
        return username;
    }

    @GetMapping("/user")
    public String getUser(Authentication authentication) {
        return "User: " + authentication.getName();
    }


    @Secured("ADMIN")
    @GetMapping("/admin/users")
    public String onlyAdmin(Authentication authentication) {
        return "Admin: " + authentication.getName();
    }

    @Secured("GERENTE")
    @GetMapping("/manager/products")
    public String onlyGerente(Authentication authentication) {
        return "Gerente: " + authentication.getName();
    }


    @GetMapping("/seller/orders")
    public String onlyVendedorCliente(Authentication authentication) {
        return "VendedorCliente: " + authentication.getName();
    }

    @GetMapping("/customer/products")
    public String onlyCliente(Authentication authentication) {
        return "Cliente: " + authentication.getName();
    }
}