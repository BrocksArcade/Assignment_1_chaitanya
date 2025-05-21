package com.questionairepro.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "RESULTTB")
@Table(name = "RESULTB")

public class UserResultModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long resultid;
    
    Long UID;
    long marksobtained;
    int rankobtained;
    boolean isPassed;
    
    
    public UserResultModel(long resultid, Long uID, long marksobtained, int rankobtained, boolean isPassed) {
        this.resultid = resultid;
        UID = uID;
        this.marksobtained = marksobtained;
        this.rankobtained = rankobtained;
        this.isPassed = isPassed;
    }
    public UserResultModel(long resultid, Long uID, long marksobtained, int rankobtained) {
        this.resultid = resultid;
        UID = uID;
        this.marksobtained = marksobtained;
        this.rankobtained = rankobtained;
    }
    public UserResultModel() {
    }
    public UserResultModel(long resultid, Long UID, long marksobtained) {
        this.resultid = resultid;
        this.UID = UID;
        this.marksobtained = marksobtained;
    }
    public long getResultid() {
        return resultid;
    }
    public void setResultid(long resultid) {
        this.resultid = resultid;
    }
    
    public long getMarksobtained() {
        return marksobtained;
    }
    public void setMarksobtained(long marksobtained) {
        this.marksobtained = marksobtained;
    }
    public Long getUID() {
        return UID;
    }
    public void setUID(Long uID) {
        UID = uID;
    }
    public int getRankobtained() {
        return rankobtained;
    }
    public void setRankobtained(int rankobtained) {
        this.rankobtained = rankobtained;
    }
    public boolean isPassed() {
        return isPassed;
    }
    public void setPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }
    
    


}
