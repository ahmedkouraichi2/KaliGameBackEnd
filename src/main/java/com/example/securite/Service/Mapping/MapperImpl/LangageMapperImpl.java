package com.example.securite.Service.Mapping.MapperImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.securite.Service.Mapping.ILangageMapper;
import com.example.securite.model.Exam.Language;
import com.example.securite.model.dto.LangageDto;

@Service
public class LangageMapperImpl implements ILangageMapper{
    
    @Override
    public Language toEntity(LangageDto langageDto) {
        Language langage = new Language();

        langage.setName(langageDto.getName());
        langage.setId(langageDto.getId());
        langage.setDescription(langageDto.getDescription());
        return langage;
    }

    @Override
    public LangageDto toDto(Language langage) {
        LangageDto langageDto = new LangageDto();

        langageDto.setName(langage.getName());
        langageDto.setId(langage.getId());
        langageDto.setDescription(langage.getDescription());

        return langageDto;
    }

    @Override
    public List<LangageDto> toDtos(List<Language> langages) {
        List<LangageDto> langageDtos = new ArrayList<LangageDto>();
        for (Language langage : langages) {
            langageDtos.add(toDto(langage));
        }
        return langageDtos;
    }
    

    

}

