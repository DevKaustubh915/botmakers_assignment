package com.kaustubh.botmakers.service;

import com.kaustubh.botmakers.dto.UserResponse;

public interface UserService {
    UserResponse gerProfile(String email);
}
