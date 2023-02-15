package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "suppliers")
public class Supplier {
    @NonNull
    @PrimaryKey
    private String supplierID;

    private String supplierInventoryID;
    private String companyName;
    private String contactPersonFullName;
    private String companyAddress;
    private String businessAccountNumber;
    private String postalCode;
    private String preferenceType;
    private String ratingType;

    @Ignore
    Supplier(){setSupplierID("Unknown supplier ID");}

    Supplier(String supplierID, String supplierInventoryID, String companyName){
        this.supplierID =  supplierID;
        this.supplierInventoryID = supplierInventoryID;
        this.companyName = companyName;
    }


    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierInventoryID() {
        return supplierInventoryID;
    }

    public void setSupplierInventoryID(String supplierInventoryID) {
        this.supplierInventoryID = supplierInventoryID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPersonFullName() {
        return contactPersonFullName;
    }

    public void setContactPersonFullName(String contactPersonFullName) {
        this.contactPersonFullName = contactPersonFullName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getBusinessAccountNumber() {
        return businessAccountNumber;
    }

    public void setBusinessAccountNumber(String businessAccountNumber) {
        this.businessAccountNumber = businessAccountNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPreferenceType() {
        return preferenceType;
    }

    public void setPreferenceType(String preferenceType) {
        this.preferenceType = preferenceType;
    }

    public String getRatingType() {
        return ratingType;
    }

    public void setRatingType(String ratingType) {
        this.ratingType = ratingType;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID='" + supplierID + '\'' +
                ", supplierInventoryID='" + supplierInventoryID + '\'' +
                ", companyName='" + companyName + '\'' +
                ", contactPersonFullName='" + contactPersonFullName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", businessAccountNumber='" + businessAccountNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", preferenceType='" + preferenceType + '\'' +
                ", ratingType='" + ratingType + '\'' +
                '}';
    }
}
