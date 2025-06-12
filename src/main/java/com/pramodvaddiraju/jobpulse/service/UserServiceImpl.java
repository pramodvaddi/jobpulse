package com.pramodvaddiraju.jobpulse.service;

import com.pramodvaddiraju.jobpulse.dto.AuthRequest;
import com.pramodvaddiraju.jobpulse.dto.AuthResponse;
import com.pramodvaddiraju.jobpulse.entity.User;
import com.pramodvaddiraju.jobpulse.exception.ResourceNotFoundException;
import com.pramodvaddiraju.jobpulse.repository.UserRepository;
import com.pramodvaddiraju.jobpulse.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // Constructor-based injection
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // --------------------------
    // Register a new user
    // --------------------------
    @Override
    public void register(AuthRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            throw new ResourceNotFoundException("User already exists with email: " + request.getEmail());
        }

        // Encode password before saving
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(encodedPassword);
        newUser.setRole("USER");

        userRepository.save(newUser);
    }

    // --------------------------
    // Login and return token
    // --------------------------
    @Override
    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));

        // Check if password matches
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResourceNotFoundException("Invalid email or password");
        }

        // Generate token using JwtUtil
        String token = jwtUtil.generateToken(user);

        return new AuthResponse(token);
    }
}
