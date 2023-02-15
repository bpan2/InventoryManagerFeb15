package com.inventorymanager.Activities.Inventory;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.inventorymanager.Activities.Account.AccountActivity;
import com.inventorymanager.Activities.Account.LogoutActivity;
import com.inventorymanager.Activities.MainActivity;
import com.inventorymanager.Activities.Report.ReportActivity;
import com.inventorymanager.Activities.Search.SearchActivity;
import com.inventorymanager.Activities.SettingsActivity;
import com.inventorymanager.Helpers.Adapters.ProductAdapter;
import com.inventorymanager.Models.DAOs.ProductDAO;
import com.inventorymanager.Models.Entities.Product;
import com.inventorymanager.Models.Entities.User;
import com.inventorymanager.Models.MyDBS;
import com.inventorymanager.R;
import com.inventorymanager.ViewModels.InventoryViewModel;

import java.util.List;

import static com.inventorymanager.Activities.Inventory.ReceivingSalesReturnInventoryActivity.EXTRA_ACTION;
import static com.inventorymanager.Activities.Inventory.ReceivingSalesReturnInventoryActivity.EXTRA_PRODUCTFOUND;
import static com.inventorymanager.Activities.Inventory.ReceivingSalesReturnInventoryActivity.EXTRA_UPC;


public class InventoryActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final int RECEIVE_PRODUCT_REQUEST = 1;
    public static final int SALES_PRODUCT_REQUEST = 2;
    public static final int RETURN_PRODUCT_REQUEST = 3;
    public static final int EDIT_PRODUCT_REQUEST = 4;
    public static final int CUSTOMIZED_REQUEST_CODE = 0x0000ffff;//for barcode scanner

    String action;
    boolean upcCodeObtained = false;
    RecyclerView inventoryRecyclerView;
    private InventoryViewModel inventoryViewModel;
    List<Product> product;

    private String productID;
    private String upc;
    private String upcCode; // to hold the returned value by barcode scanner
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

    final ProductAdapter productAdapter = new ProductAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

       /* RecyclerView recyclerView = findViewById(R.id.inventoryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
*/
        inventoryRecyclerView = findViewById(R.id.inventoryRecyclerView);
        inventoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        inventoryRecyclerView.setHasFixedSize(true);

        final ProductAdapter productAdapter = new ProductAdapter();
        inventoryRecyclerView.setAdapter(productAdapter);

        inventoryViewModel = ViewModelProviders.of(this).get(InventoryViewModel.class);
        inventoryViewModel.getAllProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                productAdapter.setProducts(products);
            }
        });

        //initRecyclerView();
        initViewModel();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.actionInventoryFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                PopupMenu popup = new PopupMenu(InventoryActivity.this, fab);
                popup.getMenuInflater().inflate(R.menu.actioninventory, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.receiving:
                                getUPC(view);
                                action = "receiving";
                                return true;

                            case R.id.sales:
                                getUPC(view);
                                action = "sales";
                                return true;

                            case R.id.returns:
                                getUPC(view);
                                action = "returns";
                                return true;

                            case R.id.edit:
                                getUPC(view);
                                action = "edit";
                                return true;

                            default:
                                return false;
                        }
                    }
                });
                popup.show();//showing popup menu
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initRecyclerView() {
        inventoryRecyclerView = findViewById(R.id.inventoryRecyclerView);
        inventoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        inventoryRecyclerView.setHasFixedSize(true);
    }

    private void startAction(String action) {
        switch (action) {
            case "receiving":
                Intent intent = new Intent(InventoryActivity.this, ReceivingSalesReturnInventoryActivity.class);
                intent.putExtra(EXTRA_UPC, upc);
                intent.putExtra(EXTRA_ACTION, action);
                startActivityForResult(intent, RECEIVE_PRODUCT_REQUEST);
                break;
            case "sales":
                Intent intent2 = new Intent(InventoryActivity.this, ReceivingSalesReturnInventoryActivity.class);
                intent2.putExtra(EXTRA_UPC, upc);
                intent2.putExtra(EXTRA_ACTION, action);
                startActivityForResult(intent2, EDIT_PRODUCT_REQUEST);
                break;
            case "returns":
                Intent intent3 = new Intent(InventoryActivity.this, ReceivingSalesReturnInventoryActivity.class);
                intent3.putExtra(EXTRA_UPC, upc);
                intent3.putExtra(EXTRA_ACTION, action);
                startActivityForResult(intent3, EDIT_PRODUCT_REQUEST);
                break;
            case "edit":
                Intent intent4 = new Intent(InventoryActivity.this, ReceivingSalesReturnInventoryActivity.class);
                intent4.putExtra(EXTRA_UPC, upc);
                intent4.putExtra(EXTRA_ACTION, action);
                //intent4.putExtra(EXTRA_PRODUCTFOUND, productFound);
                startActivityForResult(intent4, EDIT_PRODUCT_REQUEST);
                break;
        }
    }

    private void getUPC(View view) {
        scanBarcodeWithCustomizedRequestCode(view);
    }

    public void scanBarcodeWithCustomizedRequestCode(View view) {
        new IntentIntegrator(this).setRequestCode(CUSTOMIZED_REQUEST_CODE).initiateScan();
    }

    private void initViewModel() {
        final ProductAdapter productAdapter = new ProductAdapter();
        inventoryRecyclerView.setAdapter(productAdapter);

        inventoryViewModel = ViewModelProviders.of(this).get(InventoryViewModel.class);
        inventoryViewModel.getAllProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                productAdapter.setProducts(products);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
                inventoryViewModel.delete(productAdapter.getProductAt(viewHolder.getAdapterPosition()));
                Toast.makeText(InventoryActivity.this, "User Deleted", Toast.LENGTH_LONG).show();
            }
        }).attachToRecyclerView(inventoryRecyclerView);

        productAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                Intent intent = new Intent(InventoryActivity.this, ReceivingSalesReturnInventoryActivity.class);

                //crt EXTRA const
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_PRODUCTID, product.getProductID());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_PRODUCTID, product.getProductID());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_UPC, product.getUpc());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_SKU, product.getSku());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_PRICE, product.getPrice());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_ONHANDQTY, product.getOnHandQty());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_BRAND, product.getBrand());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_MODEL, product.getModel());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_UNITOFMEASUREMENTID, product.getUnitOfMeasurementID());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_PRODUCTCATEGORYID, product.getProductCategoryID());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_PRODUCTDESC, product.getProductDesc());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_INTRODUCTIONDATEID, product.getIntroductionDateID());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_SALESDISCONTINUATIONDATEID, product.getSalesDiscontinuationDateID());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_EXPIRATIONDATEID, product.getExpirationDateID());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_MANUFACTURERID, product.getManufacturerID());
                intent.putExtra(ReceivingSalesReturnInventoryActivity.EXTRA_SUPPLIERID, product.getSupplierID());

                startActivityForResult(intent, EDIT_PRODUCT_REQUEST);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CUSTOMIZED_REQUEST_CODE) {
            switch (requestCode) {
                case CUSTOMIZED_REQUEST_CODE: {
                    Toast.makeText(this, "REQUEST_CODE = " + requestCode, Toast.LENGTH_LONG).show();
                    break;
                }
                default:
                    break;
            }

            IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);

            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                upcCode = result.getContents();
                upc = upcCode;
                upcCodeObtained = true;
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                startAction(action);
            }
        }

        if (requestCode != CUSTOMIZED_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                productID = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_PRODUCTID);
                //upc = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_UPC);
                upc = upcCode;
                sku = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_SKU);
                price = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_PRICE);
                onHandQty = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_ONHANDQTY);
                brand = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_BRAND);
                model = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_MODEL);
                unitOfMeasurementID = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_UNITOFMEASUREMENTID);
                productCategoryID = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_PRODUCTCATEGORYID);
                productDesc = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_PRODUCTDESC);
                introductionDateID = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_INTRODUCTIONDATEID);
                salesDiscontinuationDateID = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_SALESDISCONTINUATIONDATEID);
                expirationDateID = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_EXPIRATIONDATEID);
                manufacturerID = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_MANUFACTURERID);
                supplierID = data.getStringExtra(ReceivingSalesReturnInventoryActivity.EXTRA_SUPPLIERID);

                Product product = new Product(productID,
                        upc,
                        sku,
                        price,
                        onHandQty,
                        brand,
                        model,
                        unitOfMeasurementID,
                        productCategoryID,
                        productDesc,
                        introductionDateID,
                        salesDiscontinuationDateID,
                        expirationDateID,
                        manufacturerID,
                        supplierID
                );

                if (requestCode == RECEIVE_PRODUCT_REQUEST) {
                    inventoryViewModel.insert(product);
                    Toast.makeText(getApplicationContext(), "Product Received", Toast.LENGTH_LONG).show();

                } else if (requestCode == SALES_PRODUCT_REQUEST && resultCode == RESULT_OK) {

                } else if (requestCode == RETURN_PRODUCT_REQUEST && resultCode == RESULT_OK) {

                } else if (requestCode == EDIT_PRODUCT_REQUEST && resultCode == RESULT_OK) {
                    product.setProductID(productID);
                    inventoryViewModel.update(product);
                    Toast.makeText(getApplicationContext(), "Product Updated", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Product Not Saved", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inventory, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent5 = new Intent(this, SettingsActivity.class);
            startActivity(intent5);
            return true;
        }

        if (id == R.id.action_search) {
            Intent intent4 = new Intent(this, SearchActivity.class);
            startActivity(intent4);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_main:
                Intent intent7 = new Intent(this, MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_account:
                Intent intent = new Intent(this, AccountActivity.class);
                startActivity(intent);
                break;
           /* case R.id.nav_inventory:
                Intent intent2 = new Intent(this, InventoryActivity.class);
                startActivity(intent2);
                break;*/
            case R.id.nav_report:
                Intent intent3 = new Intent(this, ReportActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_search:
                Intent intent4 = new Intent(this, SearchActivity.class);
                startActivity(intent4);
                break;

            case R.id.nav_settings:
                Intent intent5 = new Intent(this, SettingsActivity.class);
                startActivity(intent5);
                break;

            case R.id.action_logout:
                Intent intent6 = new Intent(this, LogoutActivity.class);
                startActivity(intent6);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
