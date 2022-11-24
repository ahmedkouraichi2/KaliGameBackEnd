package com.example.securite.model.request;

import com.example.securite.model.ERole;
import lombok.Data;

import javax.validation.constraints.NotBlank;


public class ResetRoleRequest {

    @NotBlank
    private  String email;

    @NotBlank
    private ERole oldRole;

    @NotBlank
    private ERole newRole;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ERole getOldRole() {
        return oldRole;
    }

    public void setOldRole(ERole oldRole) {
        this.oldRole = oldRole;
    }

    public ERole getNewRole() {
        return newRole;
    }

    public void setNewRole(ERole newRole) {
        this.newRole = newRole;
    }
    
    
    
}
