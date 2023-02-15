package com.inventorymanager.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.inventorymanager.Models.Entities.User;
import com.inventorymanager.Repositories.UserRepository;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EditAccountViewModel extends AndroidViewModel {

    public MutableLiveData<User> mLiveDataUser = new MutableLiveData<>();
    private UserRepository userRepository;
    private Executor executor = Executors.newSingleThreadExecutor();

    public EditAccountViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);

    }


    public void loadData(final String employeeID) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
            //??????????????????????????????????????????????????????????????
           /*     List<User> user = userRepository.findUserByID(employeeID);
                mLiveDataUser.postValue(user);*/
            }
        });

    }


    public void saveUser(String userName) {
        User user = mLiveDataUser.getValue();

        if (user == null) {
            if(TextUtils.isEmpty(user.getEmployeeID())){
                return;
            }
            //user = new User(employeeID, "newuser", "Dolittle", "John", "999", "yes", "", "", "", "", "", "", "");
        }else{
            user.setUserName(userName);
        }
        userRepository.insert(user);
    }
}
