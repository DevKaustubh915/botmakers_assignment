package com.kaustubh.botmakers.dto;

import com.kaustubh.botmakers.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String email;
}


