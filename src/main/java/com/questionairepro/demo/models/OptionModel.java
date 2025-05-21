package com.questionairepro.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "OPTIONTB")
@Table(name = "OPTIONTB")
public class OptionModel {
    @Id
    @Column(name = "AID")
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long OptionID;

    @Column(name = "QID")
    String QID;

    // @ManyToOne
    // @JoinColumn(name = "question_id")
    // Long question;

    @Column(name = "ATEXT")
    String optionText;

    public OptionModel(Long optionID, String qID, String optionText) {
        OptionID = optionID;
        QID = qID;
        this.optionText = optionText;
    }

    public OptionModel() {
    }

    public OptionModel(Long optid, String optionText) {
        this.OptionID = optid;
        this.optionText = optionText;
    }

    public String getQID() {
        return QID;
    }

    public void setQID(String qID) {
        QID = qID;
    }

    public Long getOptionID() {
        return OptionID;
    }

    public void setOptionID(Long optid) {
        this.OptionID = optid;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

}
