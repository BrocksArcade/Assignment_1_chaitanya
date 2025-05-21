package com.questionairepro.demo.mainlogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.questionairepro.demo.models.UserResultModel;
import com.questionairepro.demo.repositoyes.QuestionService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ExamResultController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/ExamResult")
    public String showExamResult(Model model, HttpSession session) {
        UserResultModel result=(UserResultModel) session.getAttribute("resultmodel");
        model.addAttribute("marks", result.getMarksobtained());
        model.addAttribute("res", result.isPassed()?"Pass":"Fail");
        model.addAttribute("rank", result.getRankobtained());
        
        return "ExamResult";
    }
    
    
}
