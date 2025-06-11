package com.pramodvaddiraju.jobpulse.dto;

// Simple DTO for JWT Token response
public class AuthResponse {

    private String token;

    // Constructors
    public AuthResponse(){

    }

    public AuthResponse(String token){
        this.token = token;
    }

    // Getters and Setterse
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
