package com.example.securite.Service.Mapping;

import com.example.securite.model.Exam.Result;
import com.example.securite.model.dto.ResultDto;

public interface IResultMapper {
    
    
   
        ResultDto toDto(Result result);

        Result toEntity(ResultDto resultDto);

   


}
