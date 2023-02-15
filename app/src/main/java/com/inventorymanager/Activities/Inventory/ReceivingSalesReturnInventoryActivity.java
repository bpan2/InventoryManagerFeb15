package com.inventorymanager.Activities.Inventory;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.inventorymanager.Helpers.Adapters.ProductAdapter;
import com.inventorymanager.Models.DAOs.ProductDAO;
import com.inventorymanager.Models.Entities.Product;
import com.inventorymanager.Models.MyDBS;
import com.inventorymanager.R;
import com.inventorymanager.ViewModels.InventoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class ReceivingSalesReturnInventoryActivity extends AppCompatActivity {
    public static final String EXTRA_PRODUCTID = "EXTRA_PRODUCTID";
    public static final String EXTRA_UPC = "EXTRA_UPC";
    public static final String EXTRA_SKU = "EXTRA_SKU";
    public static final String EXTRA_PRICE = "EXTRA_PRICE";
    public static final String EXTRA_ONHANDQTY = "EXTRA_ONHANDQTY";
    public static final String EXTRA_BRAND = "EXTRA_BRAND";
    public static final String EXTRA_MODEL = "EXTRA_MODEL";
    public static final String EXTRA_UNITOFMEASUREMENTID = "EXTRA_UNITOFMEASUREMENTID";
    public static final String EXTRA_PRODUCTCATEGORYID = "EXTRA_PRODUCTCATEGORYID";
    public static final String EXTRA_PRODUCTDESC = "EXTRA_PRODUCTDESC";
    public static final String EXTRA_INTRODUCTIONDATEID = "EXTRA_INTRODUCTIONDATEID";
    public static final String EXTRA_SALESDISCONTINUATIONDATEID = "EXTRA_SALESDISCONTINUATIONDATEID";
    public static final String EXTRA_EXPIRATIONDATEID = "EXTRA_EXPIRATIONDATEID";
    public static final String EXTRA_MANUFACTURERID = "EXTRA_MANUFACTURERID";
    public static final String EXTRA_SUPPLIERID = "EXTRA_SUPPLIERID";
    public static final String EXTRA_ACTION = "EXTRA_ACTION";
    public static final String EXTRA_PRODUCTFOUND = "EXTRA_PRODUCTFOUND";


    public TextInputEditText productIDInventoryTextInputEditText;
    public TextInputEditText upcInventoryTextInputEditText;
    public TextInputEditText skuInventoryTextInputEditText;
    public TextInputEditText priceInventoryTextInputEditText;
    public TextInputEditText onHandQtyInventoryTextInputEditText;
    public TextInputEditText brandInventoryTextInputEditText;
    public TextInputEditText modelInventoryTextInputEditText;
    public TextInputEditText unitOfMeasurementIDInventoryTextInputEditText;
    public TextInputEditText productCategoryIDInventoryTextInputEditText;
    public TextInputEditText productDescInventoryTextInputEditText;
    public TextInputEditText introductionDateIDInventoryTextInputEditText;
    public TextInputEditText salesDiscontinuationDateIDInventoryTextInputEditText;
    public TextInputEditText expirationDateIDInventoryTextInputEditText;
    public TextInputEditText manufacturerIDInventoryTextInputEditText;
    public TextInputEditText supplierIDInventoryTextInputEditText;

    String productID;
    String upc;
    String sku;
    String price;
    String onHandQty;
    String brand;
    String model;
    String unitOfMeasurementID;
    String productCategoryID;
    String productDesc;
    String introductionDateID;
    String salesDiscontinuationDateID;
    String expirationDateID;
    String manufacturerID;
    String supplierID;
    String action;
    String productFound;

    public InventoryViewModel inventoryViewModel;
    public List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving_sales_return);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        upc = intent.getStringExtra(EXTRA_UPC);



        action = intent.getStringExtra(EXTRA_ACTION);

        Toast.makeText(this, "upc : " + upc + "   & action: " + action, Toast.LENGTH_LONG).show();

        

       // inventoryRecyclerView.setAdapter(productAdapter);

        inventoryViewModel = ViewModelProviders.of(this).get(InventoryViewModel.class);
        inventoryViewModel.findProductByUPC(upc);

        observerSetup();
        //products = inventoryViewModel.findProductByUPC(upc);
        /*ProductDAO productDAO = MyDBS.getInstance(getApplication()).ProductDAO();
        List<Product> products = productDAO.findProductByUPC(upc);*/

        /*if(products != null){
            productFound = "yes";
            Toast.makeText(getApplicationContext(), "productFound: " + productFound, Toast.LENGTH_LONG).show();
        }
        else{
            productFound = "no";

            Toast.makeText(getApplicationContext(), "productFound: " + productFound, Toast.LENGTH_LONG).show();
        }*/


     /*   inventoryViewModel.getAllProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                productAdapter.setProducts(products);

                products = inventoryViewModel.findProductByUPC(upc);
        *//*ProductDAO productDAO = MyDBS.getInstance(getApplication()).ProductDAO();
        List<Product> products = productDAO.findProductByUPC(upc);*//*

                if(products != null){
                    productFound = "yes";
                    Toast.makeText(getApplicationContext(), "productFound: " + productFound, Toast.LENGTH_LONG).show();
                }
                else{
                    productFound = "no";

                    Toast.makeText(getApplicationContext(), "productFound: " + productFound, Toast.LENGTH_LONG).show();
                }
            }
        });*/



        //productFound =intent.getStringExtra(EXTRA_PRODUCTFOUND) ;

        productIDInventoryTextInputEditText = findViewById(R.id.productIDInventoryTextInputEditText);
        upcInventoryTextInputEditText = findViewById(R.id.upcInventoryTextInputEditText);
        skuInventoryTextInputEditText = findViewById(R.id.skuInventoryTextInputEditText);
        priceInventoryTextInputEditText = findViewById(R.id.priceInventoryTextInputEditText);
        onHandQtyInventoryTextInputEditText = findViewById(R.id.onHandQtyInventoryTextInputEditText);
        brandInventoryTextInputEditText = findViewById(R.id.brandInventoryTextInputEditText);
        modelInventoryTextInputEditText = findViewById(R.id.modelInventoryTextInputEditText);
        unitOfMeasurementIDInventoryTextInputEditText = findViewById(R.id.unitOfMeasurementIDInventoryTextInputEditText);
        productCategoryIDInventoryTextInputEditText = findViewById(R.id.productCategoryIDInventoryTextInputEditText);
        productDescInventoryTextInputEditText = findViewById(R.id.productDescInventoryTextInputEditText);
        introductionDateIDInventoryTextInputEditText = findViewById(R.id.introductionDateIDInventoryTextInputEditText);
        salesDiscontinuationDateIDInventoryTextInputEditText = findViewById(R.id.salesDiscontinuationDateIDInventoryTextInputEditText);
        expirationDateIDInventoryTextInputEditText = findViewById(R.id.expirationDateIDInventoryTextInputEditText);
        manufacturerIDInventoryTextInputEditText = findViewById(R.id.manufacturerIDInventoryTextInputEditText);
        supplierIDInventoryTextInputEditText = findViewById(R.id.supplierIDInventoryTextInputEditText);













        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_24dp);

        if(productFound == "yes"){
            if (action == "edit") {
                setTitle("Edit Product");
                productIDInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_PRODUCTID));
                upcInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_UPC));
                skuInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_SKU));
                priceInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_PRICE));
                onHandQtyInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_ONHANDQTY));
                brandInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_BRAND));
                modelInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_MODEL));
                unitOfMeasurementIDInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_UNITOFMEASUREMENTID));
                productCategoryIDInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_PRODUCTCATEGORYID));
                productDescInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_PRODUCTDESC));
                introductionDateIDInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_INTRODUCTIONDATEID));
                salesDiscontinuationDateIDInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_SALESDISCONTINUATIONDATEID));
                expirationDateIDInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_EXPIRATIONDATEID));
                manufacturerIDInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_MANUFACTURERID));
                supplierIDInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_SUPPLIERID));

            } else if(action == "receiving"){
                setTitle("Receive Product");
            }else if(action == "sales"){
                setTitle("Sell Product");
            }else if(action == "returns"){
                setTitle("Return Product");
            }
        }else{
            setTitle("Receive Product");
            upcInventoryTextInputEditText.setText(intent.getStringExtra(EXTRA_UPC));
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    private void observerSetup() {
        final ProductAdapter productAdapter = new ProductAdapter();
        inventoryViewModel.getAllProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable final List<Product> products) {
                productAdapter.setProducts(products);
            }
        });

        inventoryViewModel.getSearchResults().observe(this,
                new Observer<List<Product>>() {
                    @Override
                    public void onChanged(@Nullable final List<Product> products) {

                        if (products.size() > 0) {

                            productIDInventoryTextInputEditText.setText(products.get(0).getProductID());

                            upcInventoryTextInputEditText.setText(products.get(0).getUpc());
                            skuInventoryTextInputEditText.setText(products.get(0).getSku());
                            priceInventoryTextInputEditText.setText(products.get(0).getPrice());
                            onHandQtyInventoryTextInputEditText.setText(products.get(0).getOnHandQty());
                            brandInventoryTextInputEditText.setText(products.get(0).getBrand());
                            modelInventoryTextInputEditText.setText(products.get(0).getModel());
                            unitOfMeasurementIDInventoryTextInputEditText.setText(products.get(0).getUnitOfMeasurementID());
                            productCategoryIDInventoryTextInputEditText.setText(products.get(0).getProductCategoryID());
                            productDescInventoryTextInputEditText.setText(products.get(0).getProductDesc());
                            introductionDateIDInventoryTextInputEditText.setText(products.get(0).getIntroductionDateID());
                            salesDiscontinuationDateIDInventoryTextInputEditText.setText(products.get(0).getSalesDiscontinuationDateID());
                            expirationDateIDInventoryTextInputEditText.setText(products.get(0).getExpirationDateID());
                            manufacturerIDInventoryTextInputEditText.setText(products.get(0).getManufacturerID());
                            supplierIDInventoryTextInputEditText.setText(products.get(0).getSupplierID());

                        } else {
                            Toast.makeText(ReceivingSalesReturnInventoryActivity.this, "No Match", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }



    private void saveProduct() {
        productID = productIDInventoryTextInputEditText.getText().toString();
        upc = upcInventoryTextInputEditText.getText().toString();
        sku = skuInventoryTextInputEditText.getText().toString();
        price = priceInventoryTextInputEditText.getText().toString();
        onHandQty = onHandQtyInventoryTextInputEditText.getText().toString();
        brand = brandInventoryTextInputEditText.getText().toString();
        model = modelInventoryTextInputEditText.getText().toString();
        unitOfMeasurementID = unitOfMeasurementIDInventoryTextInputEditText.getText().toString();
        productCategoryID = productCategoryIDInventoryTextInputEditText.getText().toString();
        productDesc = productDescInventoryTextInputEditText.getText().toString();
        introductionDateID = introductionDateIDInventoryTextInputEditText.getText().toString();
        salesDiscontinuationDateID = salesDiscontinuationDateIDInventoryTextInputEditText.getText().toString();
        expirationDateID = expirationDateIDInventoryTextInputEditText.getText().toString();
        manufacturerID = manufacturerIDInventoryTextInputEditText.getText().toString();
        supplierID = supplierIDInventoryTextInputEditText.getText().toString();

        if (productID.trim().isEmpty() ||
                upc.trim().isEmpty() ||
                sku.trim().isEmpty() ||
                price.trim().isEmpty() ||
                onHandQty.trim().isEmpty() ||
                brand.trim().isEmpty() ||
                model.trim().isEmpty() ||
                unitOfMeasurementID.trim().isEmpty() ||
                productCategoryID.trim().isEmpty() ||
                productDesc.trim().isEmpty() ||
                introductionDateID.trim().isEmpty() ||
                salesDiscontinuationDateID.trim().isEmpty() ||
                expirationDateID.trim().isEmpty() ||
                manufacturerID.trim().isEmpty() ||
                supplierID.trim().isEmpty()) {

            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show();
            return;

        } else {
            Intent data = new Intent();

            data.putExtra(EXTRA_PRODUCTID, productID);
            data.putExtra(EXTRA_UPC, upc);
            data.putExtra(EXTRA_SKU, sku);
            data.putExtra(EXTRA_PRICE, price);
            data.putExtra(EXTRA_ONHANDQTY, onHandQty);
            data.putExtra(EXTRA_BRAND, brand);
            data.putExtra(EXTRA_MODEL, model);
            data.putExtra(EXTRA_UNITOFMEASUREMENTID, unitOfMeasurementID);
            data.putExtra(EXTRA_PRODUCTCATEGORYID, productCategoryID);
            data.putExtra(EXTRA_PRODUCTDESC, productDesc);
            data.putExtra(EXTRA_INTRODUCTIONDATEID, introductionDateID);
            data.putExtra(EXTRA_SALESDISCONTINUATIONDATEID, salesDiscontinuationDateID);
            data.putExtra(EXTRA_EXPIRATIONDATEID, expirationDateID);
            data.putExtra(EXTRA_MANUFACTURERID, manufacturerID);
            data.putExtra(EXTRA_SUPPLIERID, supplierID);

            setResult(RESULT_OK, data);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.receivingsalesreturninventory, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_product:
                saveProduct();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
