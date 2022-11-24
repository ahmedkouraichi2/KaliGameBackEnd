package com.example.securite.Service.Impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.securite.Service.IEmailService;
import com.example.securite.model.Exam.Candidat;
import com.example.securite.model.Exam.Test;

@Service
public class EmailServiceImpl implements IEmailService {

    @Override
  
     
        
        public Test createTest() {
//  
          
          LocalDateTime dateStart=LocalDateTime.now();
          LocalDateTime dateExpiration = dateStart.plusHours(48);
          Candidat candidat=new Candidat();
          Test test=new Test();
          test.setCandidat(candidat);
          test.setDateCreation(dateStart);
          test.setDateExpiration(dateExpiration);
          test.setPassed(false);
            return test;
    }

    @Override
    public Candidat createCandidat() {
        // TODO Auto-generated method stub
        return null;
    }

}
