package com.questionairepro.demo.repositoyes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionairepro.demo.models.UserModel;

@Service
public class UsermodelService {
    @Autowired
    UsermodelRepo usermodelRepo ;
    
    
    public UsermodelService(UsermodelRepo usermodelRepo) {
        this.usermodelRepo = usermodelRepo;
    }

    public UsermodelRepo getUsermodelRepo() {
        return usermodelRepo;
    }

    public void setUsermodelRepo(UsermodelRepo usermodelRepo) {
        this.usermodelRepo = usermodelRepo;
    }

    public UserModel doRegister(String email, String name)
    {
        boolean isPresent= usermodelRepo.findByEmailString(email).size()>0;
        if(isPresent)
        {
            return  usermodelRepo.findByEmailString(email).get(0) ;
        }
        else { return usermodelRepo.save(new UserModel(name,email));}
    }
    
}
