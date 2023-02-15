package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "inventories")
public class Inventory {
    @NonNull
    @PrimaryKey
    private String inventoryID;

    private String sku;
    private String supplierInventoryID;
    private int onHandQty;
    private int onOrderQty;
    private String shelftLocation;
    private String storageLocation;
    private int averageMonthlySalesQty;
    private String reorderGuideLineID;
    private int shrinkage;
    private String otherDetails;


    public Inventory(){setInventoryID("Unknown inventory ID");}

    @Ignore
    public Inventory(String inventoryID, String sku, String supplierInventoryID, int ohQty, int oQty, String shelfLoc, String storageLoc){
        this.inventoryID = inventoryID;
        this.sku = sku;
        this.supplierInventoryID = supplierInventoryID;
        this.onHandQty = ohQty;
        this.onOrderQty = oQty;
        this.shelftLocation = shelfLoc;
        this.storageLocation = storageLoc;
    }

    public String getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(String inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSupplierInventoryID() {
        return supplierInventoryID;
    }

    public void setSupplierInventoryID(String supplierInventoryID) {
        this.supplierInventoryID = supplierInventoryID;
    }

    public int getOnHandQty() {
        return onHandQty;
    }

    public void setOnHandQty(int onHandQty) {
        this.onHandQty = onHandQty;
    }

    public int getOnOrderQty() {
        return onOrderQty;
    }

    public void setOnOrderQty(int onOrderQty) {
        this.onOrderQty = onOrderQty;
    }

    public String getShelftLocation() {
        return shelftLocation;
    }

    public void setShelftLocation(String shelftLocation) {
        this.shelftLocation = shelftLocation;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public int getAverageMonthlySalesQty() {
        return averageMonthlySalesQty;
    }

    public void setAverageMonthlySalesQty(int averageMonthlySalesQty) {
        this.averageMonthlySalesQty = averageMonthlySalesQty;
    }

    public String getReorderGuideLineID() {
        return reorderGuideLineID;
    }

    public void setReorderGuideLineID(String reorderGuideLineID) {
        this.reorderGuideLineID = reorderGuideLineID;
    }

    public int getShrinkage() {
        return shrinkage;
    }

    public void setShrinkage(int shrinkage) {
        this.shrinkage = shrinkage;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID='" + inventoryID + '\'' +
                ", sku='" + sku + '\'' +
                ", supplierInventoryID='" + supplierInventoryID + '\'' +
                ", onHandQty=" + onHandQty +
                ", onOrderQty=" + onOrderQty +
                ", shelftLocation='" + shelftLocation + '\'' +
                ", storageLocation='" + storageLocation + '\'' +
                ", averageMonthlySalesQty=" + averageMonthlySalesQty +
                ", reorderGuideLineID='" + reorderGuideLineID + '\'' +
                ", shrinkage=" + shrinkage +
                ", otherDetails='" + otherDetails + '\'' +
                '}';
    }
}