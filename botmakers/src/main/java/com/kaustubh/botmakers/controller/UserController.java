package com.kaustubh.botmakers.controller;

import com.kaustubh.botmakers.dto.UserResponse;
import com.kaustubh.botmakers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getProfile(Authentication authentication){
        UserResponse response = userService.gerProfile(authentication.getName());
        return ResponseEntity.ok(response);
    }


}
