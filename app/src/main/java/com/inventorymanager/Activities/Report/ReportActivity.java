package com.inventorymanager.Activities.Report;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.inventorymanager.Activities.Account.AccountActivity;
import com.inventorymanager.Activities.Account.LogoutActivity;
import com.inventorymanager.Activities.Inventory.InventoryActivity;
import com.inventorymanager.Activities.MainActivity;
import com.inventorymanager.Activities.Search.SearchActivity;
import com.inventorymanager.Activities.SettingsActivity;
import com.inventorymanager.R;

public class ReportActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.salesInventoryFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        getMenuInflater().inflate(R.menu.report, menu);
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
            case R.id.nav_inventory:
                Intent intent2 = new Intent(this, InventoryActivity.class);
                startActivity(intent2);
                break;
           /* case R.id.nav_report:
                Intent intent3 = new Intent(this, ReportActivity.class);
                startActivity(intent3);
                break;*/
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
