package com.example.securite.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securite.Repository.CandidatRepository;
import com.example.securite.Service.EmailSenderService1;
import com.example.securite.model.Exam.Candidat;




@RestController
@CrossOrigin("*")
@RequestMapping("api/ca")
public class CandidatController {
    
    @Autowired 
    CandidatRepository candidatRepository ;
    /*
    @Autowired
    
    EmailSenderService1 emailSenderService;
    
    */
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Candidat> getCandidiat(@PathVariable("") Long id) throws Exception {
        System.out.println("canidiature  avec  "+id);
        Candidat candidat =this.candidatRepository.getById(id);
        if(candidat==null) 
            throw new Exception("candidat not found exception");
        
    
        return ResponseEntity.ok(candidat);
    }
    
 
    
    @GetMapping("/allCandidature")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Candidat>> getAllUsers() {
        return ResponseEntity.ok(candidatRepository.findAll());
    }
    
 
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean>deleteCandidatuere(@PathVariable("id") Long id) throws Exception {
        System.out.println("c to be deleted with request Candiature  id is: "+id);
        Candidat candidat=this.candidatRepository.getById(id);
        if(candidat==null) {
            return ResponseEntity.ok(true);
            
        }
        this.candidatRepository.delete(candidat);
        
        return ResponseEntity.ok(true);
    }
    
      /*
    
    @GetMapping("/accepte/{id}")
    public ResponseEntity<Boolean>accpte(@PathVariable("id") Long id) throws Exception {
        System.out.println("c accpter  id is: "+id);
        Candidat candidat=this.candidatRepository.getById(id);
        if(candidat==null) {
            return ResponseEntity.ok(true);
            
        }
        
         SimpleMailMessage mailMessage = new SimpleMailMessage();
         mailMessage.setTo(candidat.getEmail());
         mailMessage.setSubject(" Féliciation " + candidat.getFirst_name() );
         mailMessage.setFrom("kouraichiahmed2@gmail.com");
         mailMessage.setText("Vous avez passer un tres bon test   " +
                
                 "candidate email: "+candidat.getEmail()+"\n\n"+
                 "candidate Candidiat:" +
                 "https://kalisoft.fr/");

               emailSenderService.sendEmail(mailMessage);     
        
                       return ResponseEntity.ok(true);
    }


    */
    

}
