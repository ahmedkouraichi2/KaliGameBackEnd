package com.example.securite.Contoller;



import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.securite.Repository.LangageDao;
import com.example.securite.Repository.TestDao;
import com.example.securite.Service.Impl.EmailServiceImpl;
import com.example.securite.Service.Impl.QuestionServiceImpl;
import com.example.securite.model.Exam.Details;
import com.example.securite.model.Exam.Language;
import com.example.securite.model.Exam.Test;
import com.example.securite.model.Exam.TestLanguage;

import org.thymeleaf.context.Context;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*")
public class EmailSender {
    
     /*
      @Autowired
     SpringTemplateEngine templateEngine;
     */
    
    
    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    private JavaMailSender sender;
    
    

    @Autowired
    private TestDao testDao;
    
    
    @Autowired
    private LangageDao langageDao;
    
    
    @Value("${test.path}")
    private String testPath;
    
    @Autowired
    QuestionServiceImpl questionServiceImpl;
    
  
    
    
    @Transactional
    @RequestMapping("")
    public @ResponseBody Details sendMail(@RequestBody Details details) throws Exception {

        
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
         model.put("name",details.getName());
         model.put("url",testPath);
         
         
         Test test=emailService.createTest();
         test.getCandidats().setEmail(details.getEmail());
         test.getCandidats().setFirst_name(details.getName());
         test.getCandidats().setSecond_name(details.getPrenom());
         ArrayList<String> tab = new ArrayList<>();
         for (int i = 0; i < details.langages.length; i++) {
             tab.add(details.langages[i].getName());
         }
//         model.put("langages",tab);
         
         
         ArrayList<TestLanguage> testLang = new ArrayList<>();
         
         
         for (int i = 0; i < details.langages.length; i++) {
             TestLanguage lgTest= new TestLanguage();
             Language langage= langageDao.findById(details.langages[i].getId()).get();
             lgTest.setLang_test(langage);
             lgTest.setTest(test);
             testLang.add(lgTest);
            
              }
         test.setLanguages(testLang);
         testDao.save(test);
         /*
         Candidat c = new Candidat();
        
        
          c.setTests(test);
         c.setFirst_name(details.getName());
         c.setEmail(details.getEmail());
         candidatRepository.save(c);
        */
         model.put("id",test.getId());  
         Context context = new Context();
         context.setVariables(model);
       
        
        try {
            helper.setTo(details.getEmail());
           // helper.setText(testPath,true);
            helper.setText("http://localhost:4200/dashbordxam/"+Long.toString(test.getId()),true);
            helper.setText(" Bonjour,vous avez  été invité(e) passer un test");
            helper.setText("http://localhost:4200/dashbordxam/"+Long.toString(test.getId()),true);
            
         
            helper.setSubject("KALIGAME votre test d'evaluation ");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);
        
     
        

        return details;

    }


}