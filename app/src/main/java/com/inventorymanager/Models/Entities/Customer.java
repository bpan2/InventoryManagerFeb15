package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "customers")
public class Customer {
    @NonNull
    @PrimaryKey
    private String customerID;

    Customer(String customerID){this.customerID = customerID;};

    @NonNull
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(@NonNull String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                '}';
    }
}
