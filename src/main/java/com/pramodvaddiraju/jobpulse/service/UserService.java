package com.pramodvaddiraju.jobpulse.service;

import com.pramodvaddiraju.jobpulse.dto.AuthRequest;
import com.pramodvaddiraju.jobpulse.dto.AuthResponse;

public interface UserService {

    void register(AuthRequest request);

    AuthResponse login(AuthRequest request);
}
