package com.example.securite.Service;

import java.util.List;

import com.example.securite.model.dto.LangageDto;

public interface ILangageService {

    public List<LangageDto> getLangages();
    
    public LangageDto saveLangage(LangageDto langageDto); 
    
    public LangageDto updateLangage(LangageDto langageDto);
    
    public Boolean deleteLangage(Long id);
    
    long AllLangage();
    
}
    