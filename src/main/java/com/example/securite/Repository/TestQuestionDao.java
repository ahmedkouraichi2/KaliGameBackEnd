package com.example.securite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.securite.model.Exam.*;
@Repository
public interface TestQuestionDao extends JpaRepository<TestQuestion, Long> { 

}
