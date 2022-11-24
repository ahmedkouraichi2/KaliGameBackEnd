package com.example.securite.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "planification")
public class Planification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "strategiePlanification")
    private String strategiePlanification;

    @Column(name = "tachesSimultanees")
    private String tachesSimultanees;

    @Column(name = "programmeDExecution")
    private String programmeDExecution;

    @Column(name = "Execution")
    private String Execution;


    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_collecteur", referencedColumnName = "id")
    private Collecteur collecteur;

}
