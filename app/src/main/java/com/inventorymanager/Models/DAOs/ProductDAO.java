package com.inventorymanager.Models.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import com.inventorymanager.Models.Entities.Product;

import java.util.List;

@Dao
public interface ProductDAO {

   /*
   https://developer.android.com/training/data-storage/room/accessing-data#java

    @Query("SELECT * FROM user WHERE age > :minAge LIMIT 5")
    public Cursor loadRawUsersOlderThan(int minAge);

   */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addProduct(Product product);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addProducts(List<Product> products);

    @Update
    public void updateProduct(Product... product);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateProduct(Product product);

    @Query("SELECT * FROM products WHERE productID = :productID")
    List<Product> updateProductByID(String productID);

    @Delete
    public void deleteProduct(Product product);

    @Query("DELETE FROM products WHERE productID = :productID")
    void deleteProductByID(String productID);

    @Query("DELETE FROM products")
    int deleteAllProducts();

    @Query("SELECT * FROM products WHERE upc = :upc")
    List<Product> getExistingUPC(String upc);

    @Query("SELECT * FROM products ORDER BY productID DESC")
    LiveData<List<Product>> loadAllProducts();

    @Query("SELECT * FROM products WHERE productID = :productID")
    List<Product> findProductByID(String productID);

    @Query("SELECT * FROM products WHERE upc = :upc")
    List<Product> findProductByUPC(String upc);

    @Query("SELECT * FROM products WHERE sku = :sku")
    List<Product> findProductBySKU(String sku);

    @Query("SELECT COUNT(*) FROM products")
    int getCount();
}
