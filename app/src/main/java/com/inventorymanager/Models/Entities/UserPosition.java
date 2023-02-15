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

        @ForeignKey(entity = Position.class,
                parentColumns = "positionID",
                childColumns = "positionID"),
}, tableName = "userpositions")
public class UserPosition {
    @NonNull
    @PrimaryKey
    private String userPositionID;
    private String userID;
    private String positionID;

    @Ignore
    public UserPosition(){
        setUserPositionID("unknown userPositionID");
    }

    public UserPosition(String userPositionID){
        if(userPositionID.isEmpty()){
            setUserPositionID("unknown userPositionID");
        }
        else{
            this.userPositionID = userPositionID;
        }
    }

    @NonNull
    public String getUserPositionID() {
        return userPositionID;
    }

    public void setUserPositionID(@NonNull String userPositionID) {
        this.userPositionID = userPositionID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }

    @Override
    public String toString() {
        return "UserPosition{" +
                "userPositionID='" + userPositionID + '\'' +
                ", userID='" + userID + '\'' +
                ", positionID='" + positionID + '\'' +
                '}';
    }
}
