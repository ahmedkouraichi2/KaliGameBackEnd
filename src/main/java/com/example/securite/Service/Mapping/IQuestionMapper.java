package com.example.securite.Service.Mapping;

import java.util.List;

import com.example.securite.model.Exam.Question;
import com.example.securite.model.dto.QuestionDto;

public interface IQuestionMapper {
    
    Question toEntity(QuestionDto questionDto);

    QuestionDto toDto(Question question);

    List<QuestionDto> toDtos(List<Question> questions);

}
