package com.example.securite.Contoller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securite.Repository.TestDao;
import com.example.securite.Service.Impl.TestServiceImpl;
import com.example.securite.model.Exam.Test;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "${front.url}")
public class TestController {
    @Autowired
    private TestServiceImpl testService;
    
    @Autowired
    private TestDao testDao;
    

    @GetMapping("/{id}")
    public LocalDateTime getDateExpiration(@PathVariable("id") Long id) {
        LocalDateTime date= testService.getDateExpiration(id);
        return  date;
   }
    
    @GetMapping("passed/{id}")
    public Boolean getPassed(@PathVariable("id") Long id) {
        
        
        
        return false;
        
    
    }
    
    /*  update To passed        */
    @GetMapping("passedoui/{id}")
    public Boolean getPassedoui(@PathVariable("id") Long id) {
        
        
        
        return false;
    
        
    }
    
    
     
    
    
    @GetMapping("/allTest")
    public List<Test>getAllUsers() {
        return testDao.findAll();
    }
    
    
    

    
    
    
    
    
    
    
}