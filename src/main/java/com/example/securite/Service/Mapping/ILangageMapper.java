package com.example.securite.Service.Mapping;

import java.util.List;

import com.example.securite.model.Exam.Language;
import com.example.securite.model.dto.LangageDto;

public interface ILangageMapper {
    
    Language toEntity(LangageDto langageDto);

    LangageDto toDto(Language langage);

    List<LangageDto> toDtos(List<Language> languages);

}
