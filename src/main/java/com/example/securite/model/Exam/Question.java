package com.example.securite.model.Exam;







import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


    
@Entity
@Table(name = "question")
public class Question{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;
    
    @Column(name = "question")
    private String question;
    
    
    
    @OneToMany( mappedBy = "question",cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<TestQuestion> test;
    

    @OneToMany(mappedBy = "questions", cascade = { CascadeType.ALL}, orphanRemoval = true)
    private List<Choix> choix;
    
 
    
    @ManyToOne()
    @JoinColumn(name = "language_id")
    private Language languages;
    
    
    
    public List<Choix> getChoix() {
        return choix;
    }
    
    



    public void setChoix(List<Choix> choix) {
        this.choix = choix;
    }

    
    
    public Question() {
        super();
        // TODO Auto-generated constructor stub
    }





    public List<TestQuestion> getTest() {
        return test;
    }





    public void setTests(List<TestQuestion> test) {
        this.test = test;
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




    public Language getLanguage() {
        return languages;
    }


    public void setLanguage(Language languages) {
        this.languages = languages;
    }



    @Override
    public String toString() {
        return "Question [id=" + id + ", question=" + question + ", test=" + test + ", choix=" + choix + ", languages="
                + languages + "]";
    }




   

    
    
}
