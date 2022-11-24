package com.example.securite.Repository;
import com.example.securite.model.Exam.Choix;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoixDao extends JpaRepository<Choix, Long>{

}
