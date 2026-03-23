package com.kaustubh.botmakers.serviceimpl;

import com.kaustubh.botmakers.dto.AuthResponse;
import com.kaustubh.botmakers.dto.LoginRequest;
import com.kaustubh.botmakers.dto.RegisterRequest;
import com.kaustubh.botmakers.entity.Role;
import com.kaustubh.botmakers.entity.User;
import com.kaustubh.botmakers.repository.UserRepository;
import com.kaustubh.botmakers.service.AuthService;
import com.kaustubh.botmakers.util.Jwtutil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Jwtutil jwtutil;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {

        if (userRepository.existsByEmail(registerRequest.getEmail())){
            throw new RuntimeException("user already exists with this email");
        }

        User newUser = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        User existingUser = userRepository.save(newUser);

        return AuthResponse.builder()
                .id(existingUser.getId())
                .name(existingUser.getName())
                .email(existingUser.getEmail())
                .role(existingUser.getRole())
                .token("")
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new RuntimeException("user not found with this email"));

        if (!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        String jwtToken = jwtutil.generateToken(user.getEmail());

        return AuthResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .token(jwtToken)
                .build();
    }
}
