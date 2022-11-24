package com.example.securite.model.dto;

public class ChoixDto {
    private Long id;
    private String description;
    private Boolean correctResponse;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getCorrectResponse() {
        return correctResponse;
    }
    public void setCorrectResponse(Boolean correctResponse) {
        this.correctResponse = correctResponse;
    }
}