package com.questionairepro.demo.repositoyes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.questionairepro.demo.models.OptionModel;

@Repository
public interface OptionsRepo extends CrudRepository<OptionModel,Long> {


    
}
