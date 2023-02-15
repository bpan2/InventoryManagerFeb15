package com.inventorymanager.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.inventorymanager.Models.DAOs.ProductDAO;
import com.inventorymanager.Models.Entities.Product;
import com.inventorymanager.Models.MyDBS;

import java.util.List;

public class ProductRepository {
    private ProductDAO productDAO;
    private LiveData<List<Product>> allProducts;
    private MutableLiveData<List<Product>> searchResults = new MutableLiveData<>();

    public ProductRepository(Application application) {
        //link the dbs to this repo
        MyDBS myDBS = MyDBS.getInstance(application);
        productDAO = myDBS.ProductDAO();
        allProducts = productDAO.loadAllProducts();
    }

    public void insert(Product product) {
        new ProductRepository.InsertProductAsyncTask(productDAO).execute(product);
    }

    public void update(Product product) {
        new ProductRepository.UpdateProductAsyncTask(productDAO).execute(product);
    }

    public void delete(Product product) {
        new ProductRepository.DeleteProductAsyncTask(productDAO).execute(product);
    }

    public void deleteAllProducts() {
        new ProductRepository.DeleteAllProductsAsyncTask(productDAO).execute();
    }

    public LiveData<List<Product>> loadAllProducts() {
        return allProducts;
    }

    public MutableLiveData<List<Product>> getSearchResults() {
        return searchResults;
    }


    //==============================================================================
    //for query's AsyncTask
    private void asyncFinished(List<Product> results) {
        searchResults.setValue(results);
    }

    private static class QueryAsyncTask extends AsyncTask<String, Void, List<Product>> {

        private ProductDAO asyncTaskDao;
        private ProductRepository delegate = null;

        QueryAsyncTask(ProductDAO productDAO) {
            asyncTaskDao = productDAO;
        }

        @Override
        protected List<Product> doInBackground(final String... params) {
            return asyncTaskDao.findProductByID(params[0]);
        }

        @Override
        protected void onPostExecute(List<Product> result) {
            delegate.asyncFinished(result);
        }
    }


    private static class UPCQueryAsyncTask extends AsyncTask<String, Void, List<Product>> {

        private ProductDAO asyncTaskDao;
        private ProductRepository delegate = null;

        UPCQueryAsyncTask(ProductDAO productDAO) {
            asyncTaskDao = productDAO;
        }

        @Override
        protected List<Product> doInBackground(final String... params) {
            return asyncTaskDao.findProductByUPC(params[0]);
        }

        @Override
        protected void onPostExecute(List<Product> result) {
            delegate.asyncFinished(result);
        }
    }


    private static class SKUQueryAsyncTask extends AsyncTask<String, Void, List<Product>> {

        private ProductDAO asyncTaskDao;
        private ProductRepository delegate = null;

        SKUQueryAsyncTask(ProductDAO productDAO) {
            asyncTaskDao = productDAO;
        }

        @Override
        protected List<Product> doInBackground(final String... params) {
            return asyncTaskDao.findProductBySKU(params[0]);
        }

        @Override
        protected void onPostExecute(List<Product> result) {
            delegate.asyncFinished(result);
        }
    }



    public void deleteProduct(String productID) {
        ProductRepository.QueryAsyncTask task = new ProductRepository.QueryAsyncTask(productDAO);
        task.execute(productID);
    }

    public void findProductByID(String productID){
        ProductRepository.QueryAsyncTask task = new ProductRepository.QueryAsyncTask(productDAO);
        task.delegate = this;
        task.execute(productID);
    }

     public void findProductByUPC(String upc){
        ProductRepository.UPCQueryAsyncTask task = new ProductRepository.UPCQueryAsyncTask(productDAO);
        task.delegate = this;
        task.execute(upc);
    }

    public void findProductBySKU(String sku){
        ProductRepository.SKUQueryAsyncTask task = new ProductRepository.SKUQueryAsyncTask(productDAO);
        task.delegate = this;
        task.execute(sku);
    }


    //==============================================================================


    private static class InsertProductAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDAO productDAO;

        private InsertProductAsyncTask(ProductDAO productDAO){
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDAO.addProduct(products[0]);
            return null;
        }
    }

    private static class UpdateProductAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDAO productDAO;

        private UpdateProductAsyncTask(ProductDAO productDAO){
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDAO.updateProduct(products[0]);
            return null;
        }
    }

    private static class DeleteProductAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDAO productDAO;

        private DeleteProductAsyncTask(ProductDAO productDAO){
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDAO.deleteProduct(products[0]);
            return null;
        }
    }

    private static class DeleteAllProductsAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProductDAO productDAO;

        private DeleteAllProductsAsyncTask(ProductDAO productDAO){
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            productDAO.deleteAllProducts();
            return null;
        }
    }
}
