package com.inventorymanager.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import com.inventorymanager.Models.Entities.User;
import com.inventorymanager.Repositories.UserRepository;
import java.util.List;

public class AccountViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    public LiveData<List<User>> allUsers;
    private MutableLiveData<List<User>> searchResults;

    public AccountViewModel(@NonNull Application application) {
        super(application);

        userRepository = new UserRepository(application);
        allUsers = userRepository.loadAllUsers();
        searchResults = userRepository.getSearchResults();
    }

    public void insert(User user){
        userRepository.insert(user);
    }

    public void update(User user){
        userRepository.update(user);
    }

    public  void delete(User user){
        userRepository.delete(user);
    }

    public void deleteAllUsers(){
        userRepository.deleteAllUsers();
    }

    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    MutableLiveData<List<User>> getSearchResults() {
        return searchResults;
    }

}
