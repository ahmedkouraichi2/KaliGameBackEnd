package com.example.securite.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "propriete")
public class Propriete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "inputDirectory")
    private String inputDirectory;

    @Column(name = "fileFilter")
    private String fileFilter;

    @Column(name = "pathFilter")
    private String pathFilter;

    @Column(name = "batchSize")
    private String batchSize;

    @Column(name = "subDirectories")
    private boolean subDirectories;

    @Column(name = "ingnoreHiddenFiles")
    private boolean ingnoreHiddenFiles;

    @Column(name = "minimumFileAge")
    private Integer minimumFileAge;

    @Column(name = "maximunFileAge")
    private Integer maximunFileAge;

    @Column(name = "minimumFileSize")
    private Integer minimumFileSize;

    @Column(name = "maximumFileSize")
    private Integer maximumFileSize;

    @Column(name = "url")
    private String url;

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

    @Column(name = "object")
    private String object;

    @Column(name = "fields")
    private String fields;

    @Column(name = "clause")
    private String clause;

    @Column(name = "deep")
    private Integer deep;

    @Column(name = "siteMap")
    private String siteMap;

    @Column(name = "filter")
    private String filter;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_collecteur", referencedColumnName = "id")
    private Collecteur collecteur;

}
