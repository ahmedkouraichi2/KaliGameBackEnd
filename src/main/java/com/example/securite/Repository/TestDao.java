package com.example.securite.Repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.securite.model.Exam.Test;

@Repository
public interface TestDao extends JpaRepository<Test, Long> {
    
     Test findTestById(Long id);
     
     
     @Query("SELECT t.dateExpiration FROM Test t WHERE t.id=:id")
        LocalDateTime findDateExpiration(@Param("id") Long id);

}