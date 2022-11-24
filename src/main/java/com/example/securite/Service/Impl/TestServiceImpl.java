package com.example.securite.Service.Impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securite.Repository.TestDao;
import com.example.securite.Service.ITestService;
import com.example.securite.model.Exam.Test;

@Service
public class TestServiceImpl implements ITestService {
    
    @Autowired
    TestDao testDao;

    @Override
    public LocalDateTime getDateExpiration(Long id) {
        LocalDateTime date=testDao.findDateExpiration(id);
        return date;
        
    }
    

    @Override
    public Test getTestById(Long id) {
        Test test=testDao.findTestById(id);
        return test;
    }

}