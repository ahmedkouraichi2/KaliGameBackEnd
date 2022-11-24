package com.example.securite.Service.Impl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.securite.Repository.IResultDao;
import com.example.securite.Repository.TestDao;
import com.example.securite.Service.IResultService;
import com.example.securite.Service.Mapping.MapperImpl.ResultMapperImpl;
import com.example.securite.model.Exam.Candidat;
import com.example.securite.model.Exam.Language;
import com.example.securite.model.Exam.Result;
import com.example.securite.model.Exam.Test;
import com.example.securite.model.Exam.TestLanguage;
import com.example.securite.model.dto.ResultDto;

@Service
public class ResultServiceImpl implements IResultService {
 
    
    
    @Autowired
    TestDao testDao;
    
    @Autowired
    IResultDao resultDao;
    
    @Autowired
    ResultMapperImpl resultMapper;
    

    
    @Autowired
    private JavaMailSender sender;
    
    @Override
    public void getResult(Long id, ResultDto resultDto) throws Exception {
        
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        
        Result res=resultMapper.toEntity(resultDto);
        int nbCorrect=res.getNbQuestCorrect();
        int score=(nbCorrect*100)/20;     
        res.setScore(score);
        Test test=testDao.findTestById(id);
        
        ArrayList<Test> testesCaniddat = new ArrayList<Test>(); // listede test
          Candidat candidats = new Candidat();
         
        
        String candidat=test.getCandidats().getFirst_name()+"  "+test.getCandidats().getSecond_name() +
                // Integer.toString(test.getResult().getScore())
                Integer.toString(score) + "%" ;
            
                
       
                
        
        ArrayList<Language> langages = new ArrayList<Language>(); 
        List<TestLanguage> langagesTest=test.getLanguages();
        ArrayList<String> nameLangages = new ArrayList<String>(); 
        
        for(int i=0;i<langagesTest.size();i++) {
        Language lang = langagesTest.get(i).getLang_test();
        langages.add(lang);
        nameLangages.add(langages.get(i).getName());
        
        
        
          
        }
        
        
           model.put("langages",nameLangages);
    
         
        
        res.setTest(test);
        resultDao.save(res);
        test.setResult(res);
        
        
        testDao.save(test);
        
        
        
        
         
         model.put("score",score);
         model.put("candidat",candidat);
        
         
       
        
         
        /*
        
        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("result-template", context);
         
        
        */
        try {
            helper.setTo("kouraichiahmed2@gmail.com");
             helper.setText(candidat,true);
            helper.setSubject("Resultat du Test");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        

        
    }


}


