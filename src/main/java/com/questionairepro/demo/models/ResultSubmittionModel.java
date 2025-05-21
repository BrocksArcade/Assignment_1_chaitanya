package com.questionairepro.demo.models;

import java.util.LinkedHashMap;

public class ResultSubmittionModel {
    LinkedHashMap<Long,String> answermap=new LinkedHashMap<>();

    public LinkedHashMap<Long, String> getAnswermap() {
        return answermap;
    }

    public void setAnswermap(LinkedHashMap<Long, String> answerObject) {
        this.answermap = answerObject;
    }
    

    public ResultSubmittionModel() {
    }

    public ResultSubmittionModel(LinkedHashMap<Long, String> answerObject) {
        this.answermap = answerObject;
    }
    

}
