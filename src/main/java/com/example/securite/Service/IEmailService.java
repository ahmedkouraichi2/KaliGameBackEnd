package com.example.securite.Service;

import com.example.securite.model.Exam.Candidat;
import com.example.securite.model.Exam.Test;

public interface IEmailService {
    
    public Test createTest();
    
    public Candidat createCandidat();

}
