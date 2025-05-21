package com.questionairepro.demo.mainlogic;

import java.util.Collections;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.questionairepro.demo.models.ResultSubmittionModel;
import com.questionairepro.demo.models.UserModel;
import com.questionairepro.demo.models.UserResultModel;
import com.questionairepro.demo.repositoyes.QuestionService;
import com.questionairepro.demo.repositoyes.ResultService;

import jakarta.servlet.http.HttpSession;

@Controller
public class QuestionsController {

    @Autowired
    QuestionService questionService;

    @Autowired
    ResultService resultservice;

    QuestionsController() {
    }

    @GetMapping("/questionspage")
    public String showQuestionspage(Model model, HttpSession session) {
        if(session.getAttribute("UserModel_c")!=null)
       { var shuffledList = questionService.getAllQuestions();
        Collections.shuffle(shuffledList, new Random(10));

        model.addAttribute("questions", shuffledList);
        model.addAttribute("answerObject", new ResultSubmittionModel());

        return "Questionaire.html";}
        else{
            //unwanted access
            return "ErrorPage";
        }
    }

    @PostMapping("/submitform")
    public String doSubmittion(@ModelAttribute ResultSubmittionModel answerObject, Model model, HttpSession session) {
        int marks = questionService.calculateObtainedMarks(answerObject.getAnswermap());
        if (marks < 0) {
            model.addAttribute("error", "Unable to Caluclate Marks, retry later");
            return "Questionaire";
            // return new ResponseEntity<String>("Failure to Submit Retry",
            // HttpStatusCode.valueOf(401));
        } else {
            UserResultModel resultModel = new UserResultModel();
            resultModel.setMarksobtained(marks);
            long halfmarks = Double
                    .doubleToRawLongBits(questionService.getTotalMarks(answerObject.getAnswermap()) * 0.5);
            resultModel.setPassed(marks > halfmarks);
            resultModel.setUID(((UserModel) session.getAttribute("UserModel_c")).getId());
            // calcualting rank before hand for displaying on webpage next
            resultservice.getresultrepo().save(resultModel);
            resultModel.setRankobtained(
                    (Integer.parseInt(String.valueOf(resultservice.calculateAndReturnRank(resultModel)))));
            // Above is just for showing on next page
            // below is to make bulk rank changes easily since SQL has ranking
            resultservice.saveResult(resultModel);
            // caching for later useage
            session.setAttribute("resultmodel", resultModel);

            return "redirect:/ExamResult";

        }

    }

}
