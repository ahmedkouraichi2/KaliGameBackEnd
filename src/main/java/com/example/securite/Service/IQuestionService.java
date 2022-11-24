package com.example.securite.Service;

import java.util.List;

import com.example.securite.model.Exam.Question;
import com.example.securite.model.dto.QuestionDto;

public interface IQuestionService {
    
    List<QuestionDto> getQuestionsLangages(Long id);
    public List<QuestionDto> getAllQuestionsLangages(Long id) ;
    public QuestionDto saveQuestion(QuestionDto qustionDto, Long id) ;
    public Boolean deleteQuestion(Long id);
    public QuestionDto updateQuestion(QuestionDto qustionDto,Long id);  


    public List<Question> getAllQuestionsKligame();

}
