package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "users")
public class User {
    @NonNull
    @PrimaryKey
    //@ColumnInfo(name = "employeeID")
    private String employeeID;
    private String userName;
    private String lastName;
    private String firstName;
    private String password;
    private String phoneNumber;
    private String email;
    private String organizationName;
    private String registrationDateID;
    private String startingDateID;
    private String userAddressID;
    private String postalCodeID;
    private String administratorFlag;
    private String returnAssociateFlag;
    private String salesAssociateFlag;
    private String receivingAssociateFlag;
    private String ownerFlag;


    public User(
            String employeeID,
            String userName,
            String lastName,
            String firstName,
            String password,
            String phoneNumber,
            String email,
            String organizationName,
            String registrationDateID,
            String startingDateID,
            String userAddressID,
            String postalCodeID,
            String administratorFlag,
            String returnAssociateFlag,
            String salesAssociateFlag,
            String receivingAssociateFlag,
            String ownerFlag
    ) {
        if (employeeID.isEmpty()) {
            setEmployeeID("999");
        } else {
            this.employeeID = employeeID;
        }
        if (userName.isEmpty()) {
            setUserName("999");
        } else {
            this.userName = userName;
        }
        this.lastName = lastName;
        this.firstName = firstName;
        if (password.trim().isEmpty()) {
            setPassword("999");
        } else {
            this.password = password;
        }
        this.phoneNumber = phoneNumber;
        this.email = email;

        if (organizationName.isEmpty()) {
            setOrganizationName("unknown");
        } else {
            this.organizationName = organizationName;
        }
        this.registrationDateID = registrationDateID;
        this.startingDateID = startingDateID;
        this.userAddressID = userAddressID;
        this.postalCodeID = postalCodeID;
        this.administratorFlag = administratorFlag;
        this.returnAssociateFlag = returnAssociateFlag;
        this.salesAssociateFlag = salesAssociateFlag;
        this.receivingAssociateFlag = receivingAssociateFlag;
        this.ownerFlag = ownerFlag;
    }

    @Ignore
    public User(String employeeID,
                String userName,
                String lastName,
                String firstName,
                String password,
                String administratorFlag,
                String returnAssociateFlag,
                String salesAssociateFlag,
                String receivingAssociateFlag,
                String ownerFlag,
                String organizationName,
                String phoneNumber,
                String email) {

        if (employeeID.isEmpty()) {
            setEmployeeID("999");
        } else {
            this.employeeID = employeeID;
        }
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;

       /* if(administratorFlag != null) {
            if (!administratorFlag.isEmpty()) {
                if (administratorFlag.toLowerCase().equals("yes") || administratorFlag.toLowerCase().equals("no")) {
                    this.administratorFlag = administratorFlag;
                }
            }
        }*/
        this.administratorFlag = administratorFlag;
        this.returnAssociateFlag = returnAssociateFlag;
        this.salesAssociateFlag = salesAssociateFlag;
        this.receivingAssociateFlag = receivingAssociateFlag;
        this.ownerFlag = ownerFlag;
        this.organizationName = organizationName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    @NonNull
    public String getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(@NonNull String employeeID) {
        this.employeeID = employeeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationDateID() {
        return registrationDateID;
    }

    public void setRegistrationDateID(String registrationDateID) {
        this.registrationDateID = registrationDateID;
    }

    public String getStartingDateID() {
        return startingDateID;
    }

    public void setStartingDateID(String startingDateID) {
        this.startingDateID = startingDateID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostalCodeID() {
        return postalCodeID;
    }

    public void setPostalCodeID(String postalCodeID) {
        this.postalCodeID = postalCodeID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getUserAddressID() {
        return userAddressID;
    }

    public void setUserAddressID(String userAddressID) {
        this.userAddressID = userAddressID;
    }

    public String getAdministratorFlag() {
        return administratorFlag;
    }

    public String getReturnAssociateFlag() {
        return returnAssociateFlag;
    }

    public void setReturnAssociateFlag(String returnAssociateFlag) {
        this.returnAssociateFlag = returnAssociateFlag;
    }

    public String getSalesAssociateFlag() {
        return salesAssociateFlag;
    }

    public void setSalesAssociateFlag(String salesAssociateFlag) {
        this.salesAssociateFlag = salesAssociateFlag;
    }

    public String getReceivingAssociateFlag() {
        return receivingAssociateFlag;
    }

    public void setReceivingAssociateFlag(String receivingAssociateFlag) {
        this.receivingAssociateFlag = receivingAssociateFlag;
    }

    public String getOwnerFlag() {
        return ownerFlag;
    }

    public void setOwnerFlag(String ownerFlag) {
        this.ownerFlag = ownerFlag;
    }

    public void setAdministratorFlag(String administratorFlag) {
        this.administratorFlag = administratorFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "employeeID='" + employeeID + '\'' +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", registrationDateID='" + registrationDateID + '\'' +
                ", startingDateID='" + startingDateID + '\'' +
                ", userAddressID='" + userAddressID + '\'' +
                ", postalCodeID='" + postalCodeID + '\'' +
                ", administratorFlag='" + administratorFlag + '\'' +
                ", returnAssociateFlag='" + returnAssociateFlag + '\'' +
                ", salesAssociateFlag='" + salesAssociateFlag + '\'' +
                ", receivingAssociateFlag='" + receivingAssociateFlag + '\'' +
                ", ownerFlag='" + ownerFlag + '\'' +
                '}';
    }
}
