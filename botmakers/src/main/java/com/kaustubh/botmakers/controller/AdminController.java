package com.kaustubh.botmakers.controller;

import com.kaustubh.botmakers.dto.UserResponse;
import com.kaustubh.botmakers.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/allusers")
    public ResponseEntity<List<UserResponse>> getAllUsers(){

        List<UserResponse> users = adminService.getAllUsers();

        return ResponseEntity.ok(users);

    }
}
