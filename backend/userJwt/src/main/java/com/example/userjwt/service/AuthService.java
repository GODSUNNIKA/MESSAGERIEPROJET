package com.example.userjwt.service;



import com.example.userjwt.dto.AuthResponse;
import com.example.userjwt.dto.LoginRequest;
import com.example.userjwt.dto.RegisterRequest;
import com.example.userjwt.enums.Role;
import com.example.userjwt.model.User;
import com.example.userjwt.repo.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userjwt.model.User;
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest req) {

        Role role = Role.fromString(req.getRole());

        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .role(role)
                .build();

        userRepo.save(user);

        String token = jwtService.generateToken(
                user.getEmail(),
                user.getRole().name()
        );
        System.out.println("REQ RECEIVED = " + req);
        return new AuthResponse(token);
    }


    public AuthResponse login(LoginRequest req) {
        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail(), user.getRole().name());
        return new AuthResponse(token);
    }
}
