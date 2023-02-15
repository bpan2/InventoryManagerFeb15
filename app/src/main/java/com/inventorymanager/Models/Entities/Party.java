package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "parties")
public class Party {
    @NonNull
    @PrimaryKey
    private String partyID;
    private String creditRating;
    private boolean organizationFlag;
    private boolean personFlag;
    private String federalTaxIDNumber;
    private String SSN;

    @Ignore
    public Party(){
        setPartyID("unknown partyID");
    }

    public Party(String partyID, boolean organizationFlag, boolean personFlag){
        if(partyID.isEmpty()){setPartyID("unknown partyID");}
        else{this.partyID = partyID;}
        this.organizationFlag = organizationFlag;
        this.personFlag = personFlag;
    }

    @NonNull
    public String getPartyID() {
        return partyID;
    }

    public void setPartyID(@NonNull String partyID) {
        this.partyID = partyID;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public boolean isOrganizationFlag() {
        return organizationFlag;
    }

    public void setOrganizationFlag(boolean organizationFlag) {
        this.organizationFlag = organizationFlag;
    }

    public boolean isPersonFlag() {
        return personFlag;
    }

    public void setPersonFlag(boolean personFlag) {
        this.personFlag = personFlag;
    }

    public String getFederalTaxIDNumber() {
        return federalTaxIDNumber;
    }

    public void setFederalTaxIDNumber(String federalTaxIDNumber) {
        this.federalTaxIDNumber = federalTaxIDNumber;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }


    @Override
    public String toString() {
        return "Party{" +
                "partyID='" + partyID + '\'' +
                ", creditRating='" + creditRating + '\'' +
                ", organizationFlag=" + organizationFlag +
                ", personFlag=" + personFlag +
                ", federalTaxIDNumber='" + federalTaxIDNumber + '\'' +
                ", SSN='" + SSN + '\'' +
                '}';
    }
}
