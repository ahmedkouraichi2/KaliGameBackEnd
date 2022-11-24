package com.example.securite.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "FileInfo")
public class FileInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

  /*  @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_User", referencedColumnName = "id")
    private User user;*/

    public FileInfo(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
