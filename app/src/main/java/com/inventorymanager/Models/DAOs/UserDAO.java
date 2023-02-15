package com.inventorymanager.Models.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.inventorymanager.Models.Entities.User;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDAO {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    void addUser(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addUsers(List<User> users);

    @Update
    public void updateUser(User... user);

    @Update(onConflict =  OnConflictStrategy.REPLACE)
    void updateUser(User user);

    @Query("SELECT * FROM users WHERE employeeID = :empID")
    List<User> updateUserByID(String empID);

    @Delete
    public void deleteUser(User user);

    @Query("DELETE FROM users WHERE employeeID = :empID")
    void deleteUserByID(String empID);

    @Query("DELETE FROM users")
    int deleteAllUsers();

    @Query("SELECT * FROM users ORDER BY employeeID DESC")
    LiveData<List<User>> loadAllUsers();

    @Query("SELECT * FROM users WHERE employeeID = :empID")
    List<User> findUserByID(String empID);

    @Query("SELECT * FROM users WHERE employeeID = :empID")
    User findUserById(String empID);

    @Query("SELECT * FROM users WHERE userName = :userName")
    List<User> findUserByUserName(String userName);

    @Query("SELECT COUNT(*) FROM users")
    int getCount();
}

