package com.example.userjwt.controller;



import com.example.userjwt.dto.AuthResponse;
import com.example.userjwt.dto.LoginRequest;
import com.example.userjwt.dto.RegisterRequest;
import com.example.userjwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest req) {
        return authService.register(req);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {
        return authService.login(req);
    }

    @GetMapping("/test")
    public String test(Authentication auth) {
        System.out.println("AUTH = " + auth);
        return "OK";
    }
    @GetMapping("/me")
    public Object me(Authentication auth) {
        return auth;
    }

}
