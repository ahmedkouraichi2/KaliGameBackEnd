package com.example.securite.Repository;

import com.example.securite.model.Propriete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprieteRepository extends JpaRepository<Propriete,Long> {
}
