package com.example.securite.Repository;

import org.springframework.stereotype.Repository;

import com.example.securite.model.Exam.Language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface LangageDao extends JpaRepository<Language, Long> {
   
    

    
    @Query("SELECT COUNT(u) FROM Language u ")
    long AllLangage();
}
