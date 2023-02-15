package com.inventorymanager.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.inventorymanager.Models.Entities.Product;
import com.inventorymanager.Repositories.ProductRepository;

import java.util.List;

public class InventoryViewModel extends AndroidViewModel {
    private ProductRepository productRepository;
    public LiveData<List<Product>> allProducts;
    public MutableLiveData<List<Product>> searchResults;

    public InventoryViewModel(@NonNull Application application) {
        super(application);

        productRepository = new ProductRepository(application);
        allProducts = productRepository.loadAllProducts();
        searchResults = productRepository.getSearchResults();
    }

    public void insert(Product product){
        productRepository.insert(product);
    }

    public void findProductByID(String productID){productRepository.findProductByID(productID);}

    public void findProductByUPC(String upc){
         productRepository.findProductByUPC(upc);

    }

    public void findProductBySKU(String sku){productRepository.findProductBySKU(sku);}

    public void update(Product product){
        productRepository.update(product);
    }

    public  void delete(Product product){
        productRepository.delete(product);
    }

    public void deleteAllProducts(){
        productRepository.deleteAllProducts();
    }

    public LiveData<List<Product>> getAllProducts(){
        return allProducts;
    }

    public MutableLiveData<List<Product>> getSearchResults() {
        return searchResults;
    }
}
