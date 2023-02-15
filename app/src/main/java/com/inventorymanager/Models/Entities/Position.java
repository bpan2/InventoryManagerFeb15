package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "positions")
public class Position {
    @NonNull
    @PrimaryKey
    private String positionID;
    private String positionType;
    private String partyID;
    private String estimatedFromDate;
    private String actualFromDate;
    private String thruDate;
    private String stdWeeklyHrs;
    private String salaryID;
    private boolean fullTimeFlag;
    private boolean partTimeFlag;
    private boolean tempFlag;

    @Ignore
    public Position(){
        setPositionID("position notYetAssigned");
    }

    public Position(String positionID, String positionType, String actualFromDate, String stdWeeklyHrs,  String salaryID){
        if(positionID.isEmpty()){setPositionID("position notYetAssigned");}
        else{this.positionID = positionID;}

        this.positionType = positionType;
        this.actualFromDate = actualFromDate;
        this.stdWeeklyHrs = stdWeeklyHrs;
        this.salaryID = salaryID;
    }

    @NonNull
    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(@NonNull String positionID) {
        this.positionID = positionID;
    }

    public String getEstimatedFromDate() {
        return estimatedFromDate;
    }

    public void setEstimatedFromDate(String estimatedFromDate) {
        this.estimatedFromDate = estimatedFromDate;
    }

    public String getActualFromDate() {
        return actualFromDate;
    }

    public void setActualFromDate(String actualFromDate) {
        this.actualFromDate = actualFromDate;
    }

    public String getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(String salaryID) {
        this.salaryID = salaryID;
    }

    public boolean getFullTimeFlag() {
        return fullTimeFlag;
    }

    public void setFullTimeFlag(boolean fullTimeFlag) {
        this.fullTimeFlag = fullTimeFlag;
    }

    public boolean getPartTimeFlag() {
        return partTimeFlag;
    }

    public void setPartTimeFlag(boolean partTimeFlag) {
        this.partTimeFlag = partTimeFlag;
    }

    public boolean getTempFlag() {
        return tempFlag;
    }

    public void setTempFlag(boolean tempFlag) {
        this.tempFlag = tempFlag;
    }


    public String getThruDate() {
        return thruDate;
    }

    public void setThruDate(String thruDate) {
        this.thruDate = thruDate;
    }

    public String getStdWeeklyHrs() {
        return stdWeeklyHrs;
    }

    public void setStdWeeklyHrs(String stdWeeklyHrs) {
        this.stdWeeklyHrs = stdWeeklyHrs;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getPartyID() {
        return partyID;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }


    @Override
    public String toString() {
        return "Position{" +
                "positionID='" + positionID + '\'' +
                ", positionType='" + positionType + '\'' +
                ", partyID='" + partyID + '\'' +
                ", estimatedFromDate='" + estimatedFromDate + '\'' +
                ", actualFromDate='" + actualFromDate + '\'' +
                ", thruDate='" + thruDate + '\'' +
                ", stdWeeklyHrs='" + stdWeeklyHrs + '\'' +
                ", salaryID='" + salaryID + '\'' +
                ", fullTimeFlag=" + fullTimeFlag +
                ", partTimeFlag=" + partTimeFlag +
                ", tempFlag=" + tempFlag +
                '}';
    }
}