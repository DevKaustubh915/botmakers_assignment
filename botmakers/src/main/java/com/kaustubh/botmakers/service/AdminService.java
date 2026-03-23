package com.kaustubh.botmakers.service;

import com.kaustubh.botmakers.dto.UserResponse;
import com.kaustubh.botmakers.entity.User;

import java.util.List;

public interface AdminService {
    List<UserResponse> getAllUsers();
}
