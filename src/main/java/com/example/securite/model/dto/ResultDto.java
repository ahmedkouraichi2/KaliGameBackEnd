package com.example.securite.model.dto;



public class ResultDto {
    private Long id;
    private int nbQuestCorrect;
    private int nbQuestIncorrect;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getNbQuestCorrect() {
        return nbQuestCorrect;
    }
    public void setNbQuestCorrect(int nbQuestCorrect) {
        this.nbQuestCorrect = nbQuestCorrect;
    }
    public int getNbQuestIncorrect() {
        return nbQuestIncorrect;
    }
    public void setNbQuestIncorrect(int nbQuestIncorrect) {
        this.nbQuestIncorrect = nbQuestIncorrect;
    }

}