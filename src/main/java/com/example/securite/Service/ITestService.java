package com.example.securite.Service;

import java.time.LocalDateTime;

import com.example.securite.model.Exam.Test;

public interface ITestService {
    
    LocalDateTime getDateExpiration(Long id);
    Test getTestById(Long id);

}
