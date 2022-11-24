package com.example.securite.Service.Mapping;

import java.util.List;

import com.example.securite.model.Exam.Choix;
import com.example.securite.model.dto.ChoixDto;

public interface IChoixMapper {
    
    
    ChoixDto toDto(Choix choix);

    List<ChoixDto> toDtos(List<Choix> choix);


}
