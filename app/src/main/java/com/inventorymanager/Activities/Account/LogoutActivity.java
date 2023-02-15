package com.inventorymanager.Activities.Account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent logout = new Intent(this, LoginActivity.class);
        logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(logout);
        onBackPressed();
    }
}
