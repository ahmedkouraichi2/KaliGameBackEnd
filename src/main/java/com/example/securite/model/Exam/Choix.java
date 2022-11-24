package com.example.securite.model.Exam;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "choix")
public class Choix {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;
    
    @Column(name = "description")
    private String description;
    
    
    @Column(name = "correct_response")
    private Boolean correctResponse;
    
    public Boolean getCorrectResponse() {
        return correctResponse;
    }



    public void setCorrectResponse(Boolean correctResponse) {
        this.correctResponse = correctResponse;
    }



    @Override
    public String toString() {
        return "Choix [id=" + id + ", descriprtion=" + description + ", correctResponse=" + correctResponse
                + ", questions=" + questions + "]";
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question questions;

    public Choix() {
        super();
        // TODO Auto-generated constructor stub
    }

    

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


    public Question getQuestions() {
        return questions;
    }

    public void setQuestion(Question questions) {
        this.questions = questions;
    }
    

    
}