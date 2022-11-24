package com.example.securite.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;


@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "erole")
    private ERole  name;

    @JsonBackReference
    @OneToOne(mappedBy = "role")
    private User user;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role(Long id, ERole name, User user) {
        super();
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Role() {
     
    }
    
    
   
    
    
    
    
    
    
    
  

}
