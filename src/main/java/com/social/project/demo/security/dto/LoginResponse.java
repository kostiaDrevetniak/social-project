package com.social.project.demo.security.dto;

import com.social.project.demo.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private Role role;
}
