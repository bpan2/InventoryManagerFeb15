package com.inventorymanager.Models.Repoes;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.inventorymanager.Models.DAOs.UserDAO;
import com.inventorymanager.Models.Entities.User;
import com.inventorymanager.Models.MyDBS;

import java.util.List;

public class UserRepo {/*
    private MutableLiveData<List<User>> searchResults =   new MutableLiveData<>();
    private LiveData<List<User>> allUsers;

    private UserDAO userDAO;

    public UserRepo(Application application) {
        MyDBS db;
        db = (MyDBS) MyDBS.getInstance(application);
        userDAO = db.UserDAO();
        allUsers = userDAO.loadAllUsers();
    }

    private void asyncFinished(List<User> results) {
        searchResults.setValue(results);
    }

    private static class QueryAsyncTask extends AsyncTask<String, Void, List<User>> {

        private UserDAO asyncTaskDao;
        private UserRepo delegate = null;

        QueryAsyncTask(UserDAO dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected List<User> doInBackground(final String... params) {
            return asyncTaskDao.findUser(params[0]);
        }

        @Override
        protected void onPostExecute(List<User> result) {
            delegate.asyncFinished(result);
        }
    }

    private static class InsertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDAO asyncTaskDao;

        InsertAsyncTask(UserDAO dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            asyncTaskDao.addUser(params[0]);
            return null;
        }
    }

    public void addUser(User newuser) {
        InsertAsyncTask task = new InsertAsyncTask(userDAO);
        task.execute(newuser);
    }

    public void updateUser(User newuser) {
        InsertAsyncTask task = new InsertAsyncTask(userDAO);
        task.execute(newuser);
    }

    public void deleteUser(String empID) {
        DeleteAsyncTask task = new DeleteAsyncTask(userDAO);
        task.execute(empID);
    }

    public void findUser(String empID){
        QueryAsyncTask task = new QueryAsyncTask(userDAO);
        task.delegate = this;
        task.execute(empID);
    }

    public void findUserByUserName(String userName){
        QueryAsyncTask task = new QueryAsyncTask(userDAO);
        task.delegate = this;
        task.execute(userName);
    }


    public LiveData<List<User>> loadAllUsers() {
        return allUsers;
    }

    public MutableLiveData<List<User>> getSearchResults() {
        return searchResults;
    }

    private static class DeleteAsyncTask extends AsyncTask<String, Void, Void> {

        private UserDAO asyncTaskDao;

        DeleteAsyncTask(UserDAO dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final String... params) {
            asyncTaskDao.deleteUser(params[0]);
            return null;
        }
    }*/
}
