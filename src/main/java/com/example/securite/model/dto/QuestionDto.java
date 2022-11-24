package com.example.securite.model.dto;



import java.util.List;

public class QuestionDto {
    
    private Long id;
    private String question;
    private LangageDto language;
    private List<ChoixDto> choix;
    
    public List<ChoixDto> getChoix() {
        return choix;
    }
    public void setChoix(List<ChoixDto> choix) {
        this.choix = choix;
    }
    public LangageDto getLanguage() {
        return language;
    }
    public void setLanguage(LangageDto language) {
        this.language = language;
    }
    public QuestionDto() {
        super();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    
    
    
    
    

}
