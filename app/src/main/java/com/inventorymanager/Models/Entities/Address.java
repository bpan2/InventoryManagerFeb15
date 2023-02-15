package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "addresses")
public class Address {
    @NonNull
    @PrimaryKey
    private String addressID;
    private String apartmentNumber;
    private String streetNumber;
    private String streetName;
    private String city;
    private String county;
    private String state;
    private String province;
    private String country;
    private String addressTypeID;
    private String postalCodeID;

    @Ignore
    public Address(){
        setAddressID("unknown addressID");
    }

    public Address(String addressID, String addressTypeID, String postalCodeID){
        if(addressID.isEmpty()){ setAddressID("unknown addressID");
        }else{
            this.addressID = addressID;
        }

        this.addressTypeID = addressTypeID;
        this.postalCodeID = postalCodeID;
    }

    @NonNull
    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(@NonNull String addressID) {
        this.addressID = addressID;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressTypeID() {
        return addressTypeID;
    }

    public void setAddressTypeID(String addressTypeID) {
        this.addressTypeID = addressTypeID;
    }

    public String getPostalCodeID() {
        return postalCodeID;
    }

    public void setPostalCodeID(String postalCodeID) {
        this.postalCodeID = postalCodeID;
    }


    @Override
    public String toString() {
        return "Address{" +
                "addressID='" + addressID + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", state='" + state + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", addressTypeID='" + addressTypeID + '\'' +
                ", postalCodeID='" + postalCodeID + '\'' +
                '}';
    }
}