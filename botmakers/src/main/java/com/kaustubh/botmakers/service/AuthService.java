package com.kaustubh.botmakers.service;

import com.kaustubh.botmakers.dto.AuthResponse;
import com.kaustubh.botmakers.dto.LoginRequest;
import com.kaustubh.botmakers.dto.RegisterRequest;
import jakarta.validation.Valid;

public interface AuthService {
    AuthResponse register(@Valid RegisterRequest registerRequest);

    AuthResponse login(@Valid LoginRequest loginRequest);
}
