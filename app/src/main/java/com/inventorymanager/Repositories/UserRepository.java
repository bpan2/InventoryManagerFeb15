package com.inventorymanager.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.inventorymanager.Helpers.Utilities.SampleData;
import com.inventorymanager.Models.DAOs.UserDAO;
import com.inventorymanager.Models.Entities.User;
import com.inventorymanager.Models.MyDBS;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UserRepository {
    private UserDAO userDAO;
    private LiveData<List<User>> allUsers;
    private MutableLiveData<List<User>> searchResults = new MutableLiveData<>();

    public UserRepository(Application application) {
        //link the dbs to this repo
        MyDBS myDBS = MyDBS.getInstance(application);
        userDAO = myDBS.UserDAO();
        allUsers = userDAO.loadAllUsers();
    }

    public void insert(User user) {
        new InsertUserAsyncTask(userDAO).execute(user);
    }

    public void update(User user) {
        new UpdateUserAsyncTask(userDAO).execute(user);
    }

    public void delete(User user) {
        new DeleteUserAsyncTask(userDAO).execute(user);
    }

    public void deleteAllUsers() {
        new DeleteAllUsersAsyncTask(userDAO).execute();
    }

    public LiveData<List<User>> loadAllUsers() {
        return allUsers;
    }

    public MutableLiveData<List<User>> getSearchResults() {
        return searchResults;
    }


    //==============================================================================
    //for query's AsyncTask
    private void asyncFinished(List<User> results) {
        searchResults.setValue(results);
    }

    private static class QueryAsyncTask extends AsyncTask<String, Void, List<User>> {

        private UserDAO asyncTaskDao;
        private UserRepository delegate = null;

        QueryAsyncTask(UserDAO userDAO) {
            asyncTaskDao = userDAO;
        }

        @Override
        protected List<User> doInBackground(final String... params) {
            return asyncTaskDao.findUserByID(params[0]);
        }

        @Override
        protected void onPostExecute(List<User> result) {
            delegate.asyncFinished(result);
        }
    }

    public void deleteUser(String empID) {
        QueryAsyncTask task = new QueryAsyncTask(userDAO);
        task.execute(empID);
    }

    public void findUserByID(String empID){
        QueryAsyncTask task = new QueryAsyncTask(userDAO);
        task.delegate = this;
        task.execute(empID);
    }

    public void findUserByUserName(String userName){
        QueryAsyncTask task = new QueryAsyncTask(userDAO);
        task.delegate = this;
        task.execute(userName);
    }


    //==============================================================================


    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDAO;

        private InsertUserAsyncTask(UserDAO userDAO){
           this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDAO.addUser(users[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDAO;

        private UpdateUserAsyncTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDAO.updateUser(users[0]);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDAO;

        private DeleteUserAsyncTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDAO.deleteUser(users[0]);
            return null;
        }
    }

    private static class DeleteAllUsersAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDAO userDAO;

        private DeleteAllUsersAsyncTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDAO.deleteAllUsers();
            return null;
        }
    }
}
