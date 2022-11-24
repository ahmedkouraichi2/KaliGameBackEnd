package com.example.securite.model.Exam;



import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "test")
public class Test {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;
    

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;
    
    @Column(name = "date_expiration")
    private LocalDateTime dateExpiration; 
    
    
    @Column(name="passed")
    private Boolean  passed  = false;
    
    
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    private Candidat candidats;
    */
    
    public Boolean getPassed() {
        return passed;
    }


    public void setPassed(Boolean passed) {
        this.passed = passed;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidiat_id")
    private Candidat candidats;

    
    


    @OneToMany(mappedBy = "test",cascade = { CascadeType.ALL })
    private List<TestLanguage> languages;
    

    @OneToMany(mappedBy = "test",cascade = { CascadeType.ALL})
    private List<TestQuestion> questions;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
    private Result result;

    
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public LocalDateTime getDateCreation() {
        return dateCreation;
    }


    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }




    public LocalDateTime getDateExpiration() {
        return dateExpiration;
    }


    public void setDateExpiration(LocalDateTime dateExpiration) {
        this.dateExpiration = dateExpiration;
    }


    public Candidat getCandidats() {
        return candidats;
    }


    public void setCandidat(Candidat candidats) {
        this.candidats = candidats;
    }


    public Result getResult() {
        return result;
    }


    public void setResult(Result result) {
        this.result = result;
    }


    public List<TestLanguage> getLanguages() {
        return languages;
    }


    public void setLanguages(List<TestLanguage> languages) {
        this.languages = languages;
    }
    
    







    public List<TestQuestion> getQuestions() {
        return questions;
    }


    public void setQuestions(List<TestQuestion> questions) {
        this.questions = questions;
    }


    public void setCandidats(Candidat candidats) {
        this.candidats = candidats;
    }
}
