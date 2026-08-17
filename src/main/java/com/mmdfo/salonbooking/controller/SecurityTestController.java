package com.mmdfo.salonbooking.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class SecurityTestController {

    @GetMapping("/protected")
    public String protectedEndpoint(Authentication authentication) {

        return "Authenticated user ID: " + authentication.getName();
    }

    @GetMapping("/authenticated")
    public String authenticated() {
        return "You are authenticated";
    }

    @GetMapping("/customer")
    public String customer() {
        return "You are a CUSTOMER";
    }

    @GetMapping("/employee")
    public String employee() {
        return "You are an EMPLOYEE";
    }

    @GetMapping("/admin")
    public String admin() {
        return "You are an ADMIN";
    }
}