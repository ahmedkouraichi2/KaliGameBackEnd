package com.example.securite.Contoller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securite.Service.Impl.ResultServiceImpl;
import com.example.securite.model.dto.ResultDto;

@RestController
@RequestMapping("/api/result")
@CrossOrigin(origins = "${front.url}")
public class ResultController {
    
    @Autowired
    ResultServiceImpl resultService;
    
    
    
    
    @Transactional
    @PostMapping("/{id}")
    public void getDateExpiration(@PathVariable("id") Long id,@RequestBody ResultDto result) throws Exception {
        resultService.getResult(id, result);
        
}
}

