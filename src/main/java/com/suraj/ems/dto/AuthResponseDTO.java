package com.suraj.ems.dto;

import com.suraj.ems.enums.Role;

public class AuthResponseDTO {

    private Long userId;

    private String username;

    private Role role;

    private boolean enabled;

    private String token;

    public AuthResponseDTO() {
    }

    public AuthResponseDTO(
            Long userId,
            String username,
            Role role,
            boolean enabled,
            String token) {

        this.userId = userId;
        this.username = username;
        this.role = role;
        this.enabled = enabled;
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}