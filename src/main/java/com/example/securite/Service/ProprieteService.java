package com.example.securite.Service;

import com.example.securite.model.Propriete;

import java.util.List;

import org.springframework.stereotype.Service;
@Service

public interface ProprieteService {
    Propriete updatePropriete(Propriete propriete, Long id);

    void deletePropriete(Long id);

    List<Propriete> allproProprietes();
}
