package com.example.securite.model.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {

    private String token;
    private String type="Bearer";
    private String id;
    private String username;
    private String email;
    private List<String> role;

    public JwtResponse(String accessToken, String id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = roles;
    }


}
