package com.questionairepro.demo.models;

import org.hibernate.annotations.NamedNativeQuery;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity(name = "RESULTTB")
@Table(name = "RESULTB")
@SqlResultSetMapping(name = "RankMapper", classes = @ConstructorResult(targetClass = UserResultModel.class, columns = {
        @ColumnResult(name = "RESULTID", type = Long.class),
        @ColumnResult(name = "UID", type = Long.class),
        @ColumnResult(name = "marksobtained", type = Integer.class),
        @ColumnResult(name = "isPassed", type = Boolean.class),
        @ColumnResult(name = "rankobtained", type = Integer.class)

}))
@NamedNativeQuery(name = "getDenseRanks", resultSetMapping = "RankMapper", query = "SELECT RESULTID, UID, MARKSOBTAINED,ISPASSED,DENSE_RANK() OVER (ORDER BY MARKSOBTAINED DESC) AS RANKOBTAINED  FROM RESULTB ORDER BY(RANKOBTAINED)")
public class UserResultModel {
    @Id
    @Column(nullable = false, name = "RESULTID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long RESULTID;

    Long UID;
    long marksobtained;
    int rankobtained;
    @Column(nullable = false, name = "ISPASSED")
    boolean isPassed = false;
    @Transient
    public String resultstring=isPassed?"PASS":"FAIL";
    public void setupResString(){
        this.resultstring=isPassed?"PASS":"FAIL";
    }

    public UserResultModel(long RESULTID, Long uID, long marksobtained, int rankobtained, boolean isPassed) {
        this.RESULTID = RESULTID;
        UID = uID;
        this.marksobtained = marksobtained;
        this.rankobtained = rankobtained;
        this.isPassed = isPassed;
        this.resultstring=isPassed?"PASS":"FAIL";
    }


    public UserResultModel() {
    }

   

    public long getRESULTID() {
        return RESULTID;
    }

    public void setResultid(long resultid) {
        this.RESULTID = resultid;
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


    public void setRESULTID(Long rESULTID) {
        RESULTID = rESULTID;
    }


    public String getResultstring() {
        return resultstring;
    }


    public void setResultstring(String resultstring) {
        this.resultstring = resultstring;
    }

}
