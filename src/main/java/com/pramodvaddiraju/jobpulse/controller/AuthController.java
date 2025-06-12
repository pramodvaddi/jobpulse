package com.pramodvaddiraju.jobpulse.controller;

import com.pramodvaddiraju.jobpulse.dto.AuthRequest;
import com.pramodvaddiraju.jobpulse.dto.AuthResponse;
import com.pramodvaddiraju.jobpulse.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;


    public AuthController(UserService userService){
        this.userService = userService;
    }

    // -------------------------
    // Register Endpoint
    // -------------------------
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AuthRequest request){
        userService.register(request);
        return ResponseEntity.ok("User Registered Successfully");
    }

    // -------------------------
    // Login Endpoint
    // -------------------------
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody AuthRequest request) {
        AuthResponse response = userService.login(request); // Login & return token
        return ResponseEntity.ok(response);
    }





}
