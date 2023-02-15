package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "supplierInventories")
public class SupplierInventory {
    @NonNull
    @PrimaryKey
    private String supplierInventoryID;

    private int totalQtySuppliedToDate;
    private String firstItemSuppliedDate;
    private String lastItemSuppliedDate;
    private String deliveryLeadTime;
    private double standardPrice;
    private double discountPercentage;
    private int minOrderQty;
    private int maxOrderQty;
    private String otherDetails;

    @Ignore
    SupplierInventory() {setSupplierInventoryID("Unknown supplier-inventory ID");}
    SupplierInventory(String supplierInventoryID){
        this.supplierInventoryID = supplierInventoryID;
    }

    public String getSupplierInventoryID() {
        return supplierInventoryID;
    }

    public void setSupplierInventoryID(String supplierInventoryID) {
        this.supplierInventoryID = supplierInventoryID;
    }

    public int getTotalQtySuppliedToDate() {
        return totalQtySuppliedToDate;
    }

    public void setTotalQtySuppliedToDate(int totalQtySuppliedToDate) {
        this.totalQtySuppliedToDate = totalQtySuppliedToDate;
    }

    public String getFirstItemSuppliedDate() {
        return firstItemSuppliedDate;
    }

    public void setFirstItemSuppliedDate(String firstItemSuppliedDate) {
        this.firstItemSuppliedDate = firstItemSuppliedDate;
    }

    public String getLastItemSuppliedDate() {
        return lastItemSuppliedDate;
    }

    public void setLastItemSuppliedDate(String lastItemSuppliedDate) {
        this.lastItemSuppliedDate = lastItemSuppliedDate;
    }

    public String getDeliveryLeadTime() {
        return deliveryLeadTime;
    }

    public void setDeliveryLeadTime(String deliveryLeadTime) {
        this.deliveryLeadTime = deliveryLeadTime;
    }

    public double getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(double standardPrice) {
        this.standardPrice = standardPrice;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getMinOrderQty() {
        return minOrderQty;
    }

    public void setMinOrderQty(int minOrderQty) {
        this.minOrderQty = minOrderQty;
    }

    public int getMaxOrderQty() {
        return maxOrderQty;
    }

    public void setMaxOrderQty(int maxOrderQty) {
        this.maxOrderQty = maxOrderQty;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }


    @Override
    public String toString() {
        return "SupplierInventory{" +
                "supplierInventoryID='" + supplierInventoryID + '\'' +
                ", totalQtySuppliedToDate=" + totalQtySuppliedToDate +
                ", firstItemSuppliedDate='" + firstItemSuppliedDate + '\'' +
                ", lastItemSuppliedDate='" + lastItemSuppliedDate + '\'' +
                ", deliveryLeadTime='" + deliveryLeadTime + '\'' +
                ", standardPrice=" + standardPrice +
                ", discountPercentage=" + discountPercentage +
                ", minOrderQty=" + minOrderQty +
                ", maxOrderQty=" + maxOrderQty +
                ", otherDetails='" + otherDetails + '\'' +
                '}';
    }
}
