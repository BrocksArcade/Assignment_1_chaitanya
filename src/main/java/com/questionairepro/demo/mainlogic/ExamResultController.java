package com.questionairepro.demo.mainlogic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.questionairepro.demo.models.UserModel;
import com.questionairepro.demo.models.UserResultModel;
import com.questionairepro.demo.repositoyes.QuestionService;
import com.questionairepro.demo.repositoyes.ResultService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ExamResultController {
    @Autowired
    QuestionService questionService;
    @Autowired
    ResultService resultService;

    @GetMapping("/ExamResult")
    public String showExamResult(Model model, HttpSession session) {
        UserResultModel result = (UserResultModel) session.getAttribute("resultmodel");
        model.addAttribute("marks", result.getMarksobtained());
        model.addAttribute("res", result.isPassed() ? "Pass" : "Fail");
        model.addAttribute("rank", result.getRankobtained());

        return "ExamResult";
    }

    @GetMapping("/allresults")
    public String showAllResults(Model model) {
        List<UserResultModel> allresults = resultService.getAllResultsByRank();
        if (allresults.size() > 0) {
            List<UserModel> allusers = resultService.getAllUsersByResult(allresults);
            model.addAttribute("results", allresults);
            model.addAttribute("myuser", allusers);

        } else {
            model.addAttribute("msg", "No Other Records Found");
        }

        return "LeaderBoard";
    }

    // @PostMapping("/allresults")
    // public String showAllResultWQuery(@RequestBody String qry, Model model) {

    //     List<UserResultModel> allresults = resultService.getAllResultsByRank();
    //     if (allresults.size() > 0) {
    //         List<UserModel> allusers = resultService.getAllUsersByResult(allresults);
            
    //         model.addAttribute("results", allresults);
    //         model.addAttribute("myuser", allusers);

    //     } else {
    //         model.addAttribute("msg", "No Other Records Found");
    //     }
    //     return "LeaderBoard";
    // }

}
