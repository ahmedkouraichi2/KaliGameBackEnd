package com.example.securite.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securite.Repository.ChoixDao;
import com.example.securite.Repository.LangageDao;
import com.example.securite.Repository.QuestionDao;
import com.example.securite.Repository.TestQuestionDao;
import com.example.securite.Service.IQuestionService;
import com.example.securite.Service.Mapping.IQuestionMapper;
import com.example.securite.model.Exam.Question;
import com.example.securite.model.Exam.Test;
import com.example.securite.model.Exam.TestLanguage;
import com.example.securite.model.Exam.TestQuestion;
import com.example.securite.model.Exam.Language;
import com.example.securite.model.Exam.Choix;

import com.example.securite.model.dto.*;


@Service

public class QuestionServiceImpl implements IQuestionService {
    
    @Autowired
    QuestionDao questionDao;
    
    @Autowired
    private IQuestionMapper  questionMapper;
    
    @Autowired
    LangageDao langageDao;
    
    @Autowired
    ChoixDao choixDao;
    
    @Autowired
    TestServiceImpl testServices;
    
    @Autowired
    TestQuestionDao testQuestDao;



    @Override
    public List<QuestionDto> getQuestionsLangages(Long id) {
        Random rand = new Random();
        ArrayList<Question> randoms = new ArrayList<>();
        ArrayList<Language> lang = new ArrayList<>();
        Test test=testServices.getTestById(id);
        List<TestLanguage> testLang=test.getLanguages();
        
        for(int i=0;i<testLang.size();i++) {
            lang.add(testLang.get(i).getLang_test());}
        
        
        ArrayList<TestQuestion> testquest = new ArrayList<>();
            int numberOfElements = 20/(lang.size());
            int numberOfRestElements = 20%(lang.size());
            List<Question> questions = null;
            for(int k=0; k<lang.size(); k++) {
             questions =questionDao.findQuestionByLanguages(lang.get(k));
                
                        for (int j = 0; j < numberOfElements; j++) {
                            TestQuestion testQuest=new TestQuestion();
                            int randomIndex = rand.nextInt(questions.size());
                            Question question = questions.get(randomIndex);
                            randoms.add(question);
                            testQuest.setQuestion(question);
                            testQuest.setTest(test);
                            testquest.add(testQuest);
                            questions.remove(randomIndex);
                        } 
                        
                        }
            if(numberOfRestElements != 0) {
                for (int l = 0; l < numberOfRestElements; l++) {
                    TestQuestion testQuest=new TestQuestion();
                    int randomIndex = rand.nextInt(questions.size());
                    Question question = questions.get(randomIndex);
                    randoms.add(question);
                    testQuest.setQuestion(question);
                    testQuest.setTest(test);
                    testquest.add(testQuest);
                    questions.remove(randomIndex);
                } 
                } 
                    test.setQuestions(testquest);
                    testQuestDao.saveAll(testquest);
                    
            
        
    List<QuestionDto> questionDtos = questionMapper.toDtos(randoms);
    
    return questionDtos;
    
    }

    
    @Override
    public List<QuestionDto> getAllQuestionsLangages(Long id) {
    List<Question> questions = null;
    Language  langage= langageDao.getById(id);
    questions =questionDao.findQuestionByLanguages(langage);
    List<QuestionDto> questionDtos = questionMapper.toDtos(questions);
    return questionDtos;
    
    }


    @Override
    public QuestionDto saveQuestion(QuestionDto qustionDto,Long id) {
        // TODO Auto-generated method stub
        Question quest=questionMapper.toEntity(qustionDto);
        Language  langage= langageDao.getById(id);
        quest.setLanguage(langage);
        questionDao.save(quest);
        return qustionDto;
    }
    
    
    @Override
    public QuestionDto updateQuestion(QuestionDto qustionDto,Long id) {
        // TODO Auto-generated method stub
        Question quest=questionMapper.toEntity(qustionDto);
        Question questDB=questionDao.findById(qustionDto.getId()).get();
        questDB.setQuestion(quest.getQuestion());
        
        for (Choix choix : questDB.getChoix()) {
            choixDao.delete(choix);
            
        }
        questDB.setChoix(null);
        questDB=questionDao.save(questDB);
        for (Choix choix : quest.getChoix()) {
            choix.setQuestion(questDB);
                choixDao.save(choix);
        }
////        int size=questDB.getChoix().size();
////        for (int i=0;i<size;i++) {
////            questDB.getChoix().remove(i);
////        }
//      questDB.getChoix().removeAll(questDB.getChoix());
//      for (Choix choix : quest.getChoix()) {
//          choix.setQuestion(questDB);
//              questDB.getChoix().add(choix);
//          
//      }
    
        return qustionDto;
    }
    
    @Override
    public Boolean deleteQuestion(Long id) {
        try {
            questionDao.deleteById(id);
        } catch(Exception e) {
            return false;
        }
        return true;
    }


    @Override
    public List<Question> getAllQuestionsKligame() {
        // TODO Auto-generated method stub
        return this.questionDao.findAll();
    }

    
    }


    
    
    
