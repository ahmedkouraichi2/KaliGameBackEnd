package com.example.securite.Service.ImplServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securite.Repository.LangageDao;
import com.example.securite.Service.ILangageService;
import com.example.securite.Service.Mapping.ILangageMapper;
import com.example.securite.model.Exam.Language;
import com.example.securite.model.dto.LangageDto;



@Service
public class LangageServiceImpl implements ILangageService {
    
    @Autowired
    private LangageDao  langageDao;
    
    @Autowired
    private ILangageMapper langagemapper;

    @Override
    public List<LangageDto> getLangages() {
        List<Language> langages = langageDao.findAll();
        List<LangageDto> langageDtos = langagemapper.toDtos(langages);
        return langageDtos;

    }
    
    
    public LangageDto getLangageById(Long id) {

            Language lg=langageDao.getById(id);
        
            return langagemapper.toDto(lg);
        }
         
    
    

    @Override
    public LangageDto saveLangage(LangageDto langageDto) {
        Language lg=langageDao.save(langagemapper.toEntity(langageDto));
        return langagemapper.toDto(lg);
    }
    
    @Override
    public LangageDto updateLangage(LangageDto langageDto) {        
        Language lg=langageDao.getById(langageDto.getId());
        lg.setName(langageDto.getName());
        Language lgFinal=langageDao.save(langagemapper.toEntity(langageDto));
        return langagemapper.toDto(lgFinal);
    }


    @Override
    public Boolean deleteLangage(Long id) {
        try {
            langageDao.deleteById(id);
        } catch(Exception e) {
            return false;
        }
        return true;
    }


    @Override
    public long AllLangage() {
        // TODO Auto-generated method stub
        
        return langageDao.AllLangage();
       
    }
}



