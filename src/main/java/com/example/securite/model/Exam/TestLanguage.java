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
@Table(name = "test_language")
public class TestLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;
    
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name = "language_id")
    private Language lang_test;
    
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name = "test")
    private Test test;



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }







    @Override
    public String toString() {
        return "TestLanguage [id=" + id + ", lang_test=" + lang_test + ", test=" + test + "]";
    }



    public Language getLang_test() {
        return lang_test;
    }



    public void setLang_test(Language lang_test) {
        this.lang_test = lang_test;
    }



    public Test getTest() {
        return test;
    }



    public void setTest(Test test) {
        this.test = test;
    }




    
    

    public TestLanguage() {
        super();
        // TODO Auto-generated constructor stub
    }

    

}