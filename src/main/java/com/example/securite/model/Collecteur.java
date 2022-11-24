package com.example.securite.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Data

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Entity
@Table(name = "collecteur")
public class Collecteur implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private Type type;

    @Column(name = "status")
    private Status status;

//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @CreatedDate
    @Column(name = "dateCreation", nullable = false,updatable = false)
    private  Instant  dateCreation ;

//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    private Instant  lastModifiedDate;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "collecteur")
    private  Commentaire commentaire;


    @JsonManagedReference
    @OneToOne(optional = false,cascade = CascadeType.ALL,mappedBy = "collecteur")
    private  Planification planification;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "collecteur")
    private  Propriete Propriete;


    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "collecteur")
    private  Reglage reglage;

}
