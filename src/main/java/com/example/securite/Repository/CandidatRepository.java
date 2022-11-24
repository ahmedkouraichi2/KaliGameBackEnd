package com.example.securite.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securite.model.Exam.Candidat;


public interface CandidatRepository extends JpaRepository<Candidat,Long> {
    Optional<Candidat> findByEmail(String email);
    Boolean existsByEmail(String email);
}



