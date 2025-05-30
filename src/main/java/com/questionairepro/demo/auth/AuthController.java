package com.questionairepro.demo.auth;

import java.util.regex.Pattern;

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
            @RequestParam(name = "emails") String emails) {
        if (uname.trim().length() < 2) {
            model.addAttribute("errors", "Enter Length should be greater than one");
            return "Registertation.html";
        }

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9.]+@{1}[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", Pattern.CASE_INSENSITIVE);
        // (emails.contains("@") && emails.contains(".") && emails.length() > 3)

        if (Pattern.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", emails.trim())) {
            if (usermodelService.getUsermodelRepo().findByEmailString(emails).size() > 0) {
                // Store this data to
                // email is present now check uname

                if (usermodelService.checkUserNameAndEmail(emails, uname)) {
                    UserModel userModel = usermodelService.doRegister(emails, uname);
                    session.setAttribute("UserModel_c", userModel);

                    model.addAttribute("errors", "Success");
                    return "redirect:/questionspage";
                } else {
                    model.addAttribute("errors", "Username not matched with regitered email, try again");
                    return "Registertation.html";
                }
            } else {
                // email doesnt exists means its new
                UserModel userModel = usermodelService.doRegister(emails, uname);
                session.setAttribute("UserModel_c", userModel);

                return "redirect:/questionspage";

            }
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
