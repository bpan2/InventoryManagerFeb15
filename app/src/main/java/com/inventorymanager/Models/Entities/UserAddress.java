package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(foreignKeys = {
        @ForeignKey(entity = User.class,
                parentColumns = "employeeID",
                childColumns = "userID"),

        @ForeignKey(entity = Address.class,
                parentColumns = "addressID",
                childColumns = "addressID"),
}, tableName = "useraddresses")

public class UserAddress {
    @NonNull
    @PrimaryKey
    private String userAddressID;
    private String userID;
    private String addressID;

    @Ignore
    public UserAddress() {
        setUserAddressID("unknown UserAddressID");
    }

    public UserAddress(String userAddressID) {
        if (userAddressID.isEmpty()) {
            setUserAddressID("unknown UserAddressID");
        } else {
            this.userAddressID = userAddressID;
        }
    }

    @NonNull
    public String getUserAddressID() {
        return userAddressID;
    }

    public void setUserAddressID(@NonNull String userAddressID) {
        this.userAddressID = userAddressID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "userAddressID='" + userAddressID + '\'' +
                ", userID='" + userID + '\'' +
                ", addressID='" + addressID + '\'' +
                '}';
    }
}