package com.kaustubh.botmakers.serviceimpl;

import com.kaustubh.botmakers.dto.UserResponse;
import com.kaustubh.botmakers.entity.User;
import com.kaustubh.botmakers.repository.UserRepository;
import com.kaustubh.botmakers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse gerProfile(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
