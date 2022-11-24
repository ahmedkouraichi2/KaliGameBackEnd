package com.example.securite.Repository;

import com.example.securite.model.Reglage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReglageRepository extends JpaRepository<Reglage,Long> {
}
