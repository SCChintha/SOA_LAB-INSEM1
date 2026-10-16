package com.example.jwtvalidation.dto;

public class JwtValidationResponse {
    private boolean valid;
    private String message;
    private String username;
    private Object roles;

    public JwtValidationResponse(boolean valid, String message,
                                 String username, Object roles) {
        this.valid = valid;
        this.message = message;
        this.username = username;
        this.roles = roles;
    }

    public boolean isValid() { return valid; }
    public String getMessage() { return message; }
    public String getUsername() { return username; }
    public Object getRoles() { return roles; }
}