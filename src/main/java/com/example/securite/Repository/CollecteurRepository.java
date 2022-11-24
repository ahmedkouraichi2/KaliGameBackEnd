package com.example.securite.Repository;

import com.example.securite.model.Collecteur;
import com.example.securite.model.Status;
import com.example.securite.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CollecteurRepository extends JpaRepository<Collecteur,Long> {

    long countByType (Type type);
    long countByStatus (Status status);
    @Query("SELECT COUNT(u) FROM Collecteur u ")
    long AllCollecteur ();
}
