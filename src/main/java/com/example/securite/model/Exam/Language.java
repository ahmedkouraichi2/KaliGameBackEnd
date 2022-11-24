package com.example.securite.model.Exam;





import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;
    




    @Column(name = "name")
    private String name;
    
    @Column( name="description")
    private String description;
    
    

    @OneToMany(mappedBy = "lang_test" ,cascade = { CascadeType.ALL})
    private List<TestLanguage> languages;
    
    
    
    public String getDescription() {
        return description;
    }










    public void setDescription(String description) {
        this.description = description;
    }


    @OneToMany(mappedBy = "languages", cascade = { CascadeType.ALL})
    private List<Question> questions;
    



    public Language() {
        super();
        // TODO Auto-generated constructor stub
    }





    




    @Override
    public String toString() {
        return "Language [id=" + id + ", name=" + name + ", languages=" + languages + ", questions=" + questions + "]";
    }










    public List<TestLanguage> getLanguages() {
        return languages;
    }










    public void setLanguages(List<TestLanguage> languages) {
        this.languages = languages;
    }










    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public List<Question> getQuestions() {
        return questions;
    }


    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}


    
