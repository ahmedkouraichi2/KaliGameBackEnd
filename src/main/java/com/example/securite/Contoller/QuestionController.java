package com.example.securite.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securite.Service.Impl.QuestionServiceImpl;
import com.example.securite.model.Exam.Question;
import com.example.securite.model.dto.QuestionDto;



@RestController
@RequestMapping("/api/quest")
@CrossOrigin(origins = "*")
public class QuestionController {
    
    
    @Autowired
    QuestionServiceImpl questionServiceImpl;
    
    
    @GetMapping("/all")
    public List<Question> getQuestionAll(){
        
        List <Question> questionDto= questionServiceImpl.getAllQuestionsKligame();
        return questionDto;
    }
    
    @GetMapping("/{id}")
    public List<QuestionDto> getQuestionById(@PathVariable("id") Long id) {
        
        List<QuestionDto> questionDto= questionServiceImpl.getAllQuestionsLangages(id);
        return questionDto;
    }
    
    @PostMapping("/{id}")
    public QuestionDto saveLangage(@RequestBody QuestionDto questionDto,@PathVariable("id") Long id) throws Exception {
        QuestionDto questionDt= questionServiceImpl.saveQuestion(questionDto,id);
        return  questionDt;
        
}
    
    @DeleteMapping("/{id}")
    public Boolean deleteQuestion(@PathVariable("id") Long id) throws Exception {
        return questionServiceImpl.deleteQuestion(id);
        
}
    
    @PutMapping("/{id}")
    public QuestionDto updateQuestion(@RequestBody QuestionDto questionDto,@PathVariable("id") Long id)  throws Exception {
        QuestionDto langage= questionServiceImpl.updateQuestion(questionDto,id);
        return  langage;
        
}

}

