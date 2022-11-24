package com.example.securite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securite.model.Exam.TestLanguage;

@Repository
public interface TestLanguageDao extends JpaRepository<TestLanguage, Long> {

}


