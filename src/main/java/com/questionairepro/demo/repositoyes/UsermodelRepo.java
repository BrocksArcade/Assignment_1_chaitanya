package com.questionairepro.demo.repositoyes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questionairepro.demo.models.UserModel;
import java.util.List;


@Repository
public interface  UsermodelRepo extends JpaRepository<UserModel,Long> {
    
     List<UserModel> findByEmailString(String emailString);
    
}
