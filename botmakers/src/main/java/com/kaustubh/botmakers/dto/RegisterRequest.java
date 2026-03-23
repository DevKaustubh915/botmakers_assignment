package com.kaustubh.botmakers.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "name is required")
    @Size(min = 2, max = 50, message = "name must be between 2-50 characters")
    private String name;

    @NotBlank(message = "email is required")
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 8, max = 20 , message = "password must between 8-20 characters")
    private String password;
}
