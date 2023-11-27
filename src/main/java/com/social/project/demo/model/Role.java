package com.social.project.demo.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    SUPER_ADMIN, ADMIN;


    @Override
    public String getAuthority() {
        return "ROLE_" + toString();
    }
}
