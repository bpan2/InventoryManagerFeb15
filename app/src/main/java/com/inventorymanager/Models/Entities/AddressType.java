package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "addressTypes")
public class AddressType {
    @NonNull
    @PrimaryKey
    private String addressTypeID;
    private String addressTypeDesc;

    @Ignore
    public AddressType(){
        setAddressTypeID("unknown addressTypeID");
    }

    public AddressType(String addressTypeID, String addressTypeDesc){
        if(addressTypeID.isEmpty()){setAddressTypeID("unknown addressTypeID");}
        else{this.addressTypeID = addressTypeID;}

        this.addressTypeDesc = addressTypeDesc;
    }

    @NonNull
    public String getAddressTypeID() {
        return addressTypeID;
    }

    public void setAddressTypeID(@NonNull String addressTypeID) {
        this.addressTypeID = addressTypeID;
    }

    public String getAddressTypeDesc() {
        return addressTypeDesc;
    }

    public void setAddressTypeDesc(String addressTypeDesc) {
        this.addressTypeDesc = addressTypeDesc;
    }

    @Override
    public String toString() {
        return "AddressType{" +
                "addressTypeID='" + addressTypeID + '\'' +
                ", addressTypeDesc='" + addressTypeDesc + '\'' +
                '}';
    }
}
