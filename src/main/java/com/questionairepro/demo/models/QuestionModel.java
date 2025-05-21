package com.questionairepro.demo.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "QUESTIONTB")
@Table(name = "QUESTIONTB")

public class QuestionModel {

    @Id
    @Column(name = "QID")
    @GeneratedValue(strategy = GenerationType.TABLE)
    long id;
    @Column(name = "QTEXT")
    String questionName;
   
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "options_id",nullable = true)
    public List<OptionModel> options = new ArrayList<>();


    @Column(name="CORRECTANSWER")
    String correctOptionText;
    @Column(name="MARKS")
    int marks;

    public QuestionModel(long id, String questionName, List<OptionModel> answerList,String correctoption) {
        this.id = id;
        this.questionName = questionName;
        this.correctOptionText=correctoption;
        options = answerList;
    }

    public QuestionModel() {
    }

  

    public QuestionModel(long id, String questionName, String correctOptionText, int marks) {
        this.id = id;
        this.questionName = questionName;
        this.correctOptionText = correctOptionText;
        this.marks = marks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionName() {
        return questionName;
    }



    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public List<OptionModel> getOptions() {
        return options;
    }

    public void setOptions(List<OptionModel> options) {
        this.options = options;
    }

    public String getCorrectOptionText() {
        return correctOptionText;
    }

    public void setCorrectOptionText(String correctOptionText) {
        this.correctOptionText = correctOptionText;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

}
