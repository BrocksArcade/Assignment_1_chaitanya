package com.questionairepro.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.questionairepro.demo.models.UserModel;
import com.questionairepro.demo.repositoyes.UsermodelService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

  
    UsermodelService usermodelService;
  
    
    public AuthController(@Autowired UsermodelService usermodelService) {
    this.usermodelService = usermodelService;
}


 

    @GetMapping("/")
    public String showRegisterpage() {
        return "Registertation.html";
    }

    @PostMapping("/register")
    public String fetchUserDetails(HttpSession session, Model model, @RequestParam(name = "uname") String uname,
            @RequestParam(name = "emails")  String emails) {
                
                
                
        // test cases as defined in world
        // if( uname==null ||uname.isEmpty())
        // {
        // model.addAttribute("errors", "UserName Cannot be empty");
        // return "Registertation.html";
        // }
      

        if ((emails.contains("@") && emails.contains(".") && emails.length() > 3)) {
            
            // Store this data to session
            UserModel userModel= usermodelService.doRegister(emails, uname);
            session.setAttribute("UserModel_c", userModel);
       
            model.addAttribute("errors", "Success");
            return "redirect:/questionspage";
        } else {
            model.addAttribute("errors", "Enter Valid Email");
            return "Registertation.html";
        }

    }

    public UsermodelService getUsermodelService() {
        return usermodelService;
    }

    public void setUsermodelService(UsermodelService usermodelService) {
        this.usermodelService = usermodelService;
    }

}
