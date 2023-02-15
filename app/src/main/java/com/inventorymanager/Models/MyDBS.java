package com.inventorymanager.Models;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.inventorymanager.Models.Converters.DateConverter;
import com.inventorymanager.Models.DAOs.AddressDAO;
import com.inventorymanager.Models.DAOs.CustomerDAO;
import com.inventorymanager.Models.DAOs.InventoryDAO;
import com.inventorymanager.Models.DAOs.PriceDAO;
import com.inventorymanager.Models.DAOs.ProductDAO;
import com.inventorymanager.Models.DAOs.PurchaseOrderDAO;
import com.inventorymanager.Models.DAOs.ReportDAO;
import com.inventorymanager.Models.DAOs.SalesOrderDAO;
import com.inventorymanager.Models.DAOs.SupplierDAO;
import com.inventorymanager.Models.DAOs.UserDAO;
import com.inventorymanager.Models.Entities.Address;
import com.inventorymanager.Models.Entities.AddressType;
import com.inventorymanager.Models.Entities.Customer;
import com.inventorymanager.Models.Entities.Inventory;
import com.inventorymanager.Models.Entities.Party;
import com.inventorymanager.Models.Entities.Position;
import com.inventorymanager.Models.Entities.PositionType;
import com.inventorymanager.Models.Entities.Product;
import com.inventorymanager.Models.Entities.Salary;
import com.inventorymanager.Models.Entities.Supplier;
import com.inventorymanager.Models.Entities.SupplierInventory;
import com.inventorymanager.Models.Entities.User;
import com.inventorymanager.Models.Entities.UserAddress;
import com.inventorymanager.Models.Entities.UserPosition;

/*
 *  https://stackoverflow.com/questions/44322178/room-schema-export-directory-is-not-provided-to-the-annotation-processor-so-we
 * disabled exportSchema just to get rid of warning. If needed, need to solve the issue

 * Refer to the tutorial book's Chapter 68 for Room
 * */
@Database(entities = {Address.class, AddressType.class, Customer.class, Inventory.class, Party.class, Position.class, PositionType.class, Product.class, Supplier.class,
        SupplierInventory.class, User.class, UserAddress.class, UserPosition.class}, version = 3) //, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class MyDBS extends RoomDatabase {

    public static final String DATABASE_NAME = "MyDBS";
    private static volatile MyDBS INSTANCE;
    private static final Object LOCK = new Object();

    public abstract AddressDAO AddressDAO();
    public abstract CustomerDAO CustomerDAO();
    public abstract InventoryDAO InventoryDAO();
    public abstract PriceDAO PriceDAO();
    public abstract ProductDAO ProductDAO();
    public abstract PurchaseOrderDAO PurchaseOrderDAO();
    public abstract ReportDAO ReportDAO();
    public abstract SalesOrderDAO SalesOrderDAO();
    public abstract SupplierDAO SupplierDAO();
    public abstract UserDAO UserDAO();

    public static MyDBS getInstance(Context context){
        if(INSTANCE == null){
            synchronized (LOCK){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyDBS.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    /*
    public static MyDBS getInstance(Context context){
        if(INSTANCE == null){
            synchronized (LOCK){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyDBS.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(rclk)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    */
   /* private static RoomDatabase.Callback rclk = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(INSTANCE).execute();
        }
    };*/

    /*public static void destroyInstance() {
        INSTANCE = null;
    }*/

    /*private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void>{
        private UserDAO userDAO;

        private PopulateDBAsyncTask(MyDBS myDBS){
            userDAO = myDBS.UserDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDAO.addUser(new User(
                    "0001",
                    "first",
                    "Smith",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""));

            userDAO.addUser(new User(
                    "0002",
                    "second",
                    "Brown",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""));

            userDAO.addUser(new User(
                    "0003",
                    "third",
                    "Green",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""));
            return null;
        }
    }*/


   /* public static MyDBS getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (MyDBS.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyDBS.class, "MyDBS").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }*/
}
