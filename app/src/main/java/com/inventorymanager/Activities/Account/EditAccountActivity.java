package com.inventorymanager.Activities.Account;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.inventorymanager.Models.Entities.User;
import com.inventorymanager.R;
import com.inventorymanager.ViewModels.EditAccountViewModel;


public class EditAccountActivity extends AppCompatActivity {

    //3 fields to be displayed
    public TextInputEditText employeeIDTextInputEditText, userNameTextInputEditText, lastNameTextInputEditText;
    private EditAccountViewModel editAccountViewModel;
    private boolean mNewUser, mEditing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_check_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        employeeIDTextInputEditText = findViewById(R.id.employeeIDEditAccountTextInputEditText);
        userNameTextInputEditText = findViewById(R.id.userNameEditAccountTextInputEditText);
        lastNameTextInputEditText = findViewById(R.id.lastNameEditAccountTextInputEditText);

        if (savedInstanceState != null) {
            mEditing = savedInstanceState.getBoolean("editing_key");
        }

        initViewModel();

    }

    private void initViewModel() {
        editAccountViewModel = ViewModelProviders.of(this)
                .get(EditAccountViewModel.class);

        editAccountViewModel.mLiveDataUser.observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null && !mEditing) {
                    employeeIDTextInputEditText.setText(user.getEmployeeID());
                    userNameTextInputEditText.setText(user.getUserName());
                    lastNameTextInputEditText.setText(user.getLastName());
                }
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            setTitle("New user");
            mNewUser = true;
        }else{
            setTitle("Edit user");
            String  EmployeeID = extras.getString("EmployeeID");
            editAccountViewModel.loadData(EmployeeID);
        }
    }




    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            saveAndReturn();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed(){
        saveAndReturn();
    }

    private void saveAndReturn() {
        //6:07
        //editAccountViewModel.saveUser(mTextView.getText().toString());

        editAccountViewModel.saveUser(userNameTextInputEditText.getText().toString());
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("editing_key", true);
        super.onSaveInstanceState(outState);
    }

}
