package com.questionairepro.demo.repositoyes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questionairepro.demo.models.QuestionModel;

@Repository
public interface QuestionsRepo extends JpaRepository<QuestionModel,Long>{


   List<QuestionModel> findAll();
   @Override
   Optional<QuestionModel> findById(Long id) ;
   
    
    
}
