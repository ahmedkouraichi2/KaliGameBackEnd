package com.example.securite.Service.Mapping.MapperImpl;

import org.springframework.stereotype.Service;

import com.example.securite.Service.Mapping.IResultMapper;
import com.example.securite.model.Exam.Result;
import com.example.securite.model.dto.ResultDto;

@Service
public class ResultMapperImpl implements IResultMapper{


    @Override
    public ResultDto toDto(Result result) {
        ResultDto resultDto = new ResultDto();

        resultDto.setNbQuestCorrect(result.getNbQuestCorrect());
        resultDto.setNbQuestIncorrect(result.getNbQuestIncorrect());

        return resultDto;
    }
    
    @Override
    public Result toEntity(ResultDto resultDto) {
        Result result = new Result();

        result.setNbQuestCorrect(resultDto.getNbQuestCorrect());
        result.setNbQuestIncorrect(resultDto.getNbQuestIncorrect());
        
        

        return result;
    }



    

}