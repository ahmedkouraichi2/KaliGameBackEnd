package com.example.securite.model;



public enum ERole {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");
    private final String role;

    ERole(String role){
        this.role = role;
    }
    public String getROLE(){
        return this.role;
    }
    public String getRole() {
        return role;
    }
    
    



}
