package com.example.securite.Service.Mapping.MapperImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.securite.Service.Mapping.IChoixMapper;
import com.example.securite.model.Exam.Choix;
import com.example.securite.model.dto.ChoixDto;


@Service
public class ChoixMapperImpl implements IChoixMapper{

    @Override
    public ChoixDto toDto(Choix choix) {
        ChoixDto choixDto = new ChoixDto();

        choixDto.setDescription(choix.getDescription());
        choixDto.setId(choix.getId());
        choixDto.setCorrectResponse(choix.getCorrectResponse());
        return choixDto;

       
      

    }

    @Override
    public List<ChoixDto> toDtos(List<Choix> choix) {
        // TODO Auto-generated method stub
        return null;
    }

 
    
}




