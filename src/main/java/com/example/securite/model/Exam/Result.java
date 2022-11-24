package com.example.securite.model.Exam;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "nb_quest_correct")
    private int nbQuestCorrect;

    @Column(name = "nb_quest_incorrect")
    private int nbQuestIncorrect;
    
    @Column(name = "score")
    private int score;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private Test test;


    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

    

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



    public Test getTest() {
        return test;
    }



    public void setTest(Test test) {
        this.test = test;
    }



    @Override
    public String toString() {
        return "Result [id=" + id + ", nbQuestCorrect=" + nbQuestCorrect + ", nbQuestIncorrect=" + nbQuestIncorrect
                + ", score=" + score + ", test=" + test + "]";
    }



    
}
