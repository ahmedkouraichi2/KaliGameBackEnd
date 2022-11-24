package com.example.securite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.securite.model.Exam.Language;
import com.example.securite.model.Exam.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long>{
    
    @Query("SELECT q FROM Question q ")
    List<Question> findQuestions();
  
    List<Question> findQuestionByLanguages(Language lang);

    
    

}