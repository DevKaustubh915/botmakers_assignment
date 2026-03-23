package com.kaustubh.botmakers.serviceimpl;

import com.kaustubh.botmakers.dto.UserResponse;
import com.kaustubh.botmakers.entity.Role;
import com.kaustubh.botmakers.entity.User;
import com.kaustubh.botmakers.repository.UserRepository;
import com.kaustubh.botmakers.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findByRole(Role.USER).stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .collect(Collectors.toList());

    }
}
