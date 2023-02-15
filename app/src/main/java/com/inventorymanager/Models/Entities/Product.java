package com.inventorymanager.Models.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "products")
public class Product {
    @NonNull
    @PrimaryKey
    private String productID;

    private String upc;
    private String sku;
    private String price;
    private String onHandQty;
    private String brand;
    private String model;
    private String unitOfMeasurementID;
    private String productCategoryID;
    private String productDesc;
    private String introductionDateID;
    private String salesDiscontinuationDateID;
    private String expirationDateID;
    private String manufacturerID;
    private String supplierID;


    @Ignore
    public Product(){setProductID("Unknown product ID");}

    public Product(String productID,
                   String upc,
                   String sku,
                   String price,
                   String onHandQty,
                   String brand,
                   String model,
                   String unitOfMeasurementID,
                   String productCategoryID,
                   String productDesc,
                   String introductionDateID,
                   String salesDiscontinuationDateID,
                   String expirationDateID,
                   String manufacturerID,
                   String supplierID)
    {
        if(productID.trim().isEmpty()){
            this.productID = "999999";
        }else{
            this.productID = productID;
        }
        this.upc = upc;
        this.sku = sku;
        this.price = price;
        this.onHandQty = onHandQty;
        this.brand = brand;
        this.model = model;
        this.unitOfMeasurementID = unitOfMeasurementID;
        this.productCategoryID = productCategoryID;
        this.productDesc = productDesc;
        this.introductionDateID = introductionDateID;
        this.salesDiscontinuationDateID = salesDiscontinuationDateID;
        this.expirationDateID = expirationDateID;
        this.manufacturerID = manufacturerID;
        this.supplierID = supplierID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getUnitOfMeasurementID() {
        return unitOfMeasurementID;
    }

    public void setUnitOfMeasurementID(String unitOfMeasurementID) {
        this.unitOfMeasurementID = unitOfMeasurementID;
    }

    public String getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(String manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setPrice(String price){this.price = price;}

    public String getPrice(){return  price;}

    public String getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(String productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOnHandQty() {
        return onHandQty;
    }

    public void setOnHandQty(String onHandQty) {
        this.onHandQty = onHandQty;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIntroductionDateID() {
        return introductionDateID;
    }

    public void setIntroductionDateID(String introductionDateID) {
        this.introductionDateID = introductionDateID;
    }

    public String getSalesDiscontinuationDateID() {
        return salesDiscontinuationDateID;
    }

    public void setSalesDiscontinuationDateID(String salesDiscontinuationDateID) {
        this.salesDiscontinuationDateID = salesDiscontinuationDateID;
    }

    public String getExpirationDateID() {
        return expirationDateID;
    }

    public void setExpirationDateID(String expirationDateID) {
        this.expirationDateID = expirationDateID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", upc='" + upc + '\'' +
                ", sku='" + sku + '\'' +
                ", price='" + price + '\'' +
                ", onHandQty='" + onHandQty + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", unitOfMeasurementID='" + unitOfMeasurementID + '\'' +
                ", productCategoryID='" + productCategoryID + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", introductionDateID='" + introductionDateID + '\'' +
                ", salesDiscontinuationDateID='" + salesDiscontinuationDateID + '\'' +
                ", expirationDateID='" + expirationDateID + '\'' +
                ", manufacturerID='" + manufacturerID + '\'' +
                ", supplierID='" + supplierID + '\'' +
                '}';
    }
}