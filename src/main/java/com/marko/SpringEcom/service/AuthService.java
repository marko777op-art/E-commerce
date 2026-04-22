package com.marko.SpringEcom.service;

import com.marko.SpringEcom.model.Role;
import com.marko.SpringEcom.model.User;
import com.marko.SpringEcom.model.dto.*;
import com.marko.SpringEcom.repository.UserRepository;
import com.marko.SpringEcom.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthResponse register(RegisterRequest request) {

        if (userRepo.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setEmail(request.email());
        user.setPassword(encoder.encode(request.password()));
        user.setRole(Role.USER);

        userRepo.save(user);

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepo.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponse(token);
    }
}