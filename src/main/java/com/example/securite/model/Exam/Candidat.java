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
@Table(name = "candidat")
public class Candidat {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", nullable = false, unique = true, updatable = false)
private Long id;

@Column(name = "first_name")
private String first_name;

@Column(name = "second_name")
private String second_name;

@Column(name = "mail")
private String email;

/*
@OneToMany(fetch = FetchType.LAZY)
private List<Test> tests;
*/

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "test_id")
private Test test;


/* 
@OneToOne(fetch = FetchType.LAZY,
cascade =  CascadeType.ALL,
mappedBy = "candidat")
private Commentaire commentaire; */



public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getFirst_name() {
    return first_name;
}

public void setFirst_name(String first_name) {
    this.first_name = first_name;
}

public String getSecond_name() {
    return second_name;
}

public void setSecond_name(String second_name) {
    this.second_name = second_name;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}



@Override
public String toString() {
    return "Candidat [id=" + id + ", first_name=" + first_name + ", second_name=" + second_name + ", email=" + email
            + ", tests=" + test + "]";
}






/*
public void setTests(List<Test> tests) {
    this.tests = tests;
}*/

public Test getTest() {
    return test;
}

public void setTest(Test test) {
    this.test = test;
}

public Candidat() {
    super();
    // TODO Auto-generated constructor stub
}
}

    



