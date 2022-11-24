package com.example.securite.model.Exam;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_question")
public class TestQuestion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
    
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    
    /**
     * 
     */
    public TestQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }


    public Question getQuestion() {
        return question;
    }


    public void setQuestion(Question question) {
        this.question = question;
    }


    @Override
    public String toString() {
        return "TestQuestion [id=" + id + ", test=" + test + ", question=" + question + "]";
    }


 





    

}