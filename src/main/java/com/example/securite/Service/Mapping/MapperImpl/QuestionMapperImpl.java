package com.example.securite.Service.Mapping.MapperImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securite.Service.Mapping.IQuestionMapper;
import com.example.securite.model.Exam.Choix;
import com.example.securite.model.Exam.Question;
import com.example.securite.model.dto.ChoixDto;
import com.example.securite.model.dto.QuestionDto;

@Service
public class QuestionMapperImpl implements IQuestionMapper {
    
    @Autowired
    LangageMapperImpl langMapp;
    
    @Autowired 
    ChoixMapperImpl  choixMapp;

   
    
    @Override
    public Question toEntity(QuestionDto questionDto) {
        Question question = new Question();

        question.setQuestion(questionDto.getQuestion());
        question.setId(questionDto.getId());
        List<Choix> list= new ArrayList<Choix>();
        for (ChoixDto  chDto : questionDto.getChoix()) {
            Choix ch = new Choix();
            ch.setDescription(chDto.getDescription());
            ch.setCorrectResponse(chDto.getCorrectResponse());
            list.add(ch);
            ch.setQuestion(question);
        }
        question.setChoix(list);
        return question;
    }


 
    

    @Override
    public QuestionDto toDto(Question question) {
        QuestionDto questionDto = new QuestionDto();

        questionDto.setQuestion(question.getQuestion());
        questionDto.setId(question.getId());
        questionDto.setLanguage(langMapp.toDto(question.getLanguage()));
        questionDto.setChoix(choixMapp.toDtos(question.getChoix()));
        

        return questionDto;
    }

    
    
  
    
    
    @Override
    public List<QuestionDto> toDtos(List<Question> questions) {
        List<QuestionDto> questionDtos = new ArrayList<QuestionDto>();
        for (Question question : questions) {
            questionDtos.add(toDto(question));
        }
        return questionDtos;
    }

   

}



