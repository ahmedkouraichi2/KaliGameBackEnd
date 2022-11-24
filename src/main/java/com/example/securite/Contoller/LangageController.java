package com.example.securite.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  com.example.securite.model.dto.*;
import com.example.securite.Repository.LangageDao;
import com.example.securite.Service.ImplServices.LangageServiceImpl;

@RestController
@RequestMapping("/api/langage")
@CrossOrigin(origins = "*")
public class LangageController {
    @Autowired
    private LangageServiceImpl langageService;
    
    private LangageDao langageDao;

    @GetMapping("")
    public List<LangageDto> getLangages() {
        List<LangageDto> langages= langageService.getLangages();
        return  langages;
    }
    
    
    @GetMapping("/allLangageNumber")

    long countAll (){
       return this.langageService.AllLangage();
    }
    
    
    
    @PostMapping("")
    public LangageDto saveLangage(@RequestBody LangageDto langageDto) throws Exception {
        LangageDto langage= langageService.saveLangage(langageDto);
        return  langage;
        
}
    
    @PutMapping("")
    public LangageDto updateLangage(@RequestBody LangageDto langageDto) throws Exception {
        LangageDto langage= langageService.updateLangage(langageDto);
        return  langage;
        
}
    
    @DeleteMapping("/{id}")
    public Boolean deleteLangage(@PathVariable("id") Long id) throws Exception {
        return langageService.deleteLangage(id);
        
    }
    
    @GetMapping("get/{id}")
    public ResponseEntity<LangageDto> getLangageById(@PathVariable("id") Long id) throws Exception {
        System.out.println("LangageDto  avec  "+id);
        LangageDto langage = this.langageService.getLangageById(id);
        if(langage==null) 
            throw new Exception("candidat not found exception");
        
    
        return ResponseEntity.ok(langage);
    }
    
    
    
    
    
    
    
    
}
