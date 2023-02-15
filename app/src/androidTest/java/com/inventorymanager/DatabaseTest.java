package com.inventorymanager;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.inventorymanager.Helpers.Utilities.SampleData;
import com.inventorymanager.Models.DAOs.UserDAO;
import com.inventorymanager.Models.MyDBS;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/*
@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    public static final String TAG = "Junit";
    private MyDBS mDb;
    private UserDAO mDao;

    @Before
    public void createDB(){
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, MyDBS.class).build();
        mDao = mDb.UserDAO();
        Log.i(TAG, "createDb");
    }

    @After
    public void closeDb(){
        mDb.close();
        Log.i(TAG, "closeDb ");
    }

    @Test
    public void createAndRetrieveUsers(){
        mDao.addUsers(SampleData.getUsers());

        int count = mDao.getCount();
        Log.i(TAG, "createAndRetrieveUsers: count=" + count);
        assertEquals(SampleData.getUsers().size(), count);
    }


}
*/
