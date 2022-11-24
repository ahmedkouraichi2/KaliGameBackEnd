package com.example.securite.Service;

import com.example.securite.model.Reglage;

import java.util.List;

import org.springframework.stereotype.Service;
@Service

public interface ReglageService {

    Reglage updateReglage(Reglage reglage, Long id);

    void deleteReglage( Long id);

    List<Reglage> allReglages();
}
