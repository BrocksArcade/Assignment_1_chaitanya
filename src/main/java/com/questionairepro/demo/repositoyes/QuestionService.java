package com.questionairepro.demo.repositoyes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionairepro.demo.models.QuestionModel;

import jakarta.transaction.Transactional;

@Service
public class QuestionService {

    QuestionsRepo repo;

    public List<QuestionModel> getAllQuestions() {
        return repo.findAll();
    }

    @Transactional()
    void insertQuestions(List<QuestionModel> questions) {

        repo.saveAll(questions);
    }

    public QuestionService(@Autowired QuestionsRepo repo) {
        this.repo = repo;
    }

    public int calculateObtainedMarks(LinkedHashMap<Long, String> result) {
        int marks = 0;
        for (Entry<Long, String> entry_ : result.entrySet()) {
            var question = repo.findById(entry_.getKey());
            if (question.isPresent()) {
                if(question.get().getCorrectOptionText().equalsIgnoreCase(entry_.getValue()))
                 marks += question.get().getMarks();
            } else {
                return -1;
            }
          
        }
        return marks;

    }
      public int getTotalMarks(LinkedHashMap<Long, String> result) {
        int marks = 0;
        for (Entry<Long, String> entry_ : result.entrySet()) {
            var question = repo.findById(entry_.getKey());
            marks+=question.get().getMarks();
           
        }
        return marks;

    }

    // @PostConstruct
    // @Transactional

    public QuestionsRepo getRepo() {
        return repo;
    }

    public void setRepo(QuestionsRepo repo) {
        this.repo = repo;
    }

}
