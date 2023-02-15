package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "salaries")
public class Salary {
    @NonNull
    @PrimaryKey
    private String salaryID;
    private double biWeeklyAmount;
    private String salaryDesc;

    @Ignore
    public Salary(){
        setSalaryID("unknown salaryID");
    }

    public Salary(String salaryID, double biWeeklyAmount){
        if(salaryID.isEmpty()){setSalaryID("unknown salaryID");}
        else{this.salaryID = salaryID;}
        this.biWeeklyAmount = biWeeklyAmount;
    }

    @NonNull
    public String getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(@NonNull String salaryID) {
        this.salaryID = salaryID;
    }

    public double getBiWeeklyAmount() {
        return biWeeklyAmount;
    }

    public void setBiWeeklyAmount(double biWeeklyAmount) {
        this.biWeeklyAmount = biWeeklyAmount;
    }

    public String getSalaryDesc() {
        return salaryDesc;
    }

    public void setSalaryDesc(String salaryDesc) {
        this.salaryDesc = salaryDesc;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryID='" + salaryID + '\'' +
                ", biWeeklyAmount=" + biWeeklyAmount +
                ", salaryDesc='" + salaryDesc + '\'' +
                '}';
    }
}
