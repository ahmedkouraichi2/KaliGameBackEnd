package com.example.securite.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "reglage")
public class Reglage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "autorise")
    private Boolean autorise;

    @Column(name = "dureePenalite")
    private String dureePenalite;

    @Column(name = "dureeRendement")
    private String dureeRendement;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_collecteur", referencedColumnName = "id")
    private Collecteur collecteur;
}
