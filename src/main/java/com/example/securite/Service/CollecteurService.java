package com.example.securite.Service;

import com.example.securite.model.Collecteur;
import com.example.securite.model.Status;
import com.example.securite.model.Type;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CollecteurService {
    ResponseEntity<Collecteur> addCollecteur(Collecteur collecteur);

    Collecteur updateCollecteur(Collecteur collecteur,Long id);

    Optional<Collecteur> getCollecteur (Long id);

    void deleteCollecteur(Long id);

    List<Collecteur> allCollecteurs();

    long countByStatus (Status status);

    long countByType(Type type);
    long AllCollecteur();
}
