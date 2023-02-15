package com.inventorymanager.Activities.Account;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.inventorymanager.Activities.Inventory.InventoryActivity;
import com.inventorymanager.Activities.MainActivity;
import com.inventorymanager.Activities.Report.ReportActivity;
import com.inventorymanager.Activities.Search.SearchActivity;
import com.inventorymanager.Activities.SettingsActivity;
import com.inventorymanager.Helpers.Adapters.AccountAdapter;
import com.inventorymanager.Helpers.Alert;
import com.inventorymanager.Helpers.SwipeController.SwipeController;
import com.inventorymanager.Models.Entities.User;
import com.inventorymanager.R;
import com.inventorymanager.ViewModels.AccountViewModel;

import java.util.List;

public class AccountActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final int CREATE_USER_REQUEST = 1;
    public static final int EDIT_USER_REQUEST = 2;

    SwipeController swipeController = null;
    RecyclerView accountRecyclerView;
    private AccountViewModel accountViewModel;
    private FloatingActionButton addAccountFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        addAccountFab = findViewById(R.id.addAccountFab);
        addAccountFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(AccountActivity.this, CreateEditAccountActivity.class));
                Intent intent = new Intent(AccountActivity.this, CreateEditAccountActivity.class);
                startActivityForResult(intent, CREATE_USER_REQUEST);
            }
        });

        /*
        editFab = findViewById(R.id.editFab);
        editFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountActivity.this, EditAccountActivity.class));
                }
        });
        */

        initRecyclerView();
        initViewModel();

        /* this block is commented out if Observer LiveData<> is used instead of the ViewModel
        //to use without AndroidViewModel
        //usersData.addAll(SampleData.getUsers());

        //to use with AndroidViewModel
        usersData.addAll(accountViewModel.users);

        for(User user : usersData){
            Log.i("InventoryManager", user.toString());
        }*/

    }

    private void initViewModel() {

        final AccountAdapter accountAdapter = new AccountAdapter();
        accountRecyclerView.setAdapter(accountAdapter);

        accountViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);
        accountViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                accountAdapter.setUsers(users);
            }
        });

        //ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT for removing at both directions
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
                accountViewModel.delete(accountAdapter.getUserAt(viewHolder.getAdapterPosition()));
                Toast.makeText(AccountActivity.this, "User Deleted", Toast.LENGTH_LONG).show();
            }
        }).attachToRecyclerView(accountRecyclerView);

        accountAdapter.setOnItemClickListener(new AccountAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User user) {
                Intent intent = new Intent(AccountActivity.this, CreateEditAccountActivity.class);

                intent.putExtra(CreateEditAccountActivity.EXTRA_EMPLOYEEID, user.getEmployeeID());
                intent.putExtra(CreateEditAccountActivity.EXTRA_USERNAME, user.getUserName());
                intent.putExtra(CreateEditAccountActivity.EXTRA_LASTNAME, user.getLastName());
                intent.putExtra(CreateEditAccountActivity.EXTRA_FIRSTNAME, user.getFirstName());
                intent.putExtra(CreateEditAccountActivity.EXTRA_PASSWORD, user.getPassword());
                intent.putExtra(CreateEditAccountActivity.EXTRA_PHONENUMBER, user.getPhoneNumber());
                intent.putExtra(CreateEditAccountActivity.EXTRA_EMAIL, user.getEmail());
                intent.putExtra(CreateEditAccountActivity.EXTRA_ORGANIZATIONNAME, user.getOrganizationName());
                intent.putExtra(CreateEditAccountActivity.EXTRA_REGISTRATIONDATEID, user.getRegistrationDateID());
                intent.putExtra(CreateEditAccountActivity.EXTRA_STARTINGDATEID, user.getStartingDateID());
                intent.putExtra(CreateEditAccountActivity.EXTRA_USERADDRESSID, user.getUserAddressID());
                intent.putExtra(CreateEditAccountActivity.EXTRA_POSTALCODEID, user.getPostalCodeID());
                intent.putExtra(CreateEditAccountActivity.EXTRA_ADMINISTRATIONFLAG, user.getAdministratorFlag());
                intent.putExtra(CreateEditAccountActivity.EXTRA_RETURNASSOCIATEFLAG, user.getReturnAssociateFlag());
                intent.putExtra(CreateEditAccountActivity.EXTRA_SALESASSOCIATEFLAG, user.getSalesAssociateFlag());
                intent.putExtra(CreateEditAccountActivity.EXTRA_RECEIVINGASSOCIATEFLAG, user.getReceivingAssociateFlag());
                intent.putExtra(CreateEditAccountActivity.EXTRA_OWNERFLAG, user.getOwnerFlag());

                startActivityForResult(intent, EDIT_USER_REQUEST);
            }
        });
    }

    public void confirmPassword() {
        DialogFragment alert = new Alert();
        Bundle arguments = new Bundle();
        /*arguments.putString("password", password);*/
        alert.setArguments(arguments);
        alert.show(getSupportFragmentManager(), "password");
    }

    //@Override
    public void onDialogPositiveClick(DialogFragment dialog) {
           /* User user = new User(employeeID, userName, lastName, firstName, password,administratorFlag, returnAssociateFlag, salesAssociateFlag, receivingAssociateFlag, ownerFlag,organizationName,phoneNumber,email);
            myDAO.updateUser(user);*/

    }

    //@Override
    public void onDialogNegativeClick(DialogFragment dialog) {
         /*   User user = new User(employeeID, userName, lastName, firstName, originalPassword,administratorFlag, returnAssociateFlag, salesAssociateFlag, receivingAssociateFlag, ownerFlag,organizationName,phoneNumber,email);
            myDAO.updateUser(user);
            finish();*/
    }


    private void initRecyclerView() {
        accountRecyclerView = findViewById(R.id.accountRecyclerView);
        accountRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        accountRecyclerView.setHasFixedSize(true);
    }

        /*final Observer<List<User>> usersObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                usersData.clear();
                usersData.addAll(users);

                if (accountAdapter == null) {
                    accountAdapter = new AccountAdapter(usersData, AccountActivity.this);
                    accountRecyclerView.setAdapter(accountAdapter);
                } else {
                    accountAdapter.notifyDataSetChanged();
                }
            }
        };*/



    /*accountViewModel.users.observe(this, usersObserver);*/
    // }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.account, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

        if (id == R.id.action_delete_all) {
            accountViewModel.deleteAllUsers();
            Toast.makeText(getApplicationContext(), "All Accounts Deleted", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void deleteAllUsers() {
        accountViewModel.deleteAllUsers();
    }

    /*private void addSampleData() {
        accountViewModel.addSampleData();
    }*/

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_main:
                Intent intent7 = new Intent(this, MainActivity.class);
                startActivity(intent7);
                break;
            /*case R.id.nav_account:
                Intent intent = new Intent(this, AccountActivity.class);
                startActivity(intent);
                break;*/
            case R.id.nav_inventory:
                Intent intent2 = new Intent(this, InventoryActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_report:
                Intent intent3 = new Intent(this, ReportActivity.class);
                startActivity(intent3);
                break;
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

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Toast.makeText(this, "In AccountActivity onAcitivityResult(), requestCode" + requestCode + " resultCode: " + resultCode, Toast.LENGTH_LONG).show();

        if (requestCode == CREATE_USER_REQUEST && resultCode == RESULT_OK) {
            String employeeID = data.getStringExtra(CreateEditAccountActivity.EXTRA_EMPLOYEEID);
            String userName = data.getStringExtra(CreateEditAccountActivity.EXTRA_USERNAME);
            String lastName = data.getStringExtra(CreateEditAccountActivity.EXTRA_LASTNAME);
            String firstName = data.getStringExtra(CreateEditAccountActivity.EXTRA_FIRSTNAME);
            String password = data.getStringExtra(CreateEditAccountActivity.EXTRA_PASSWORD);
            String phoneNumber = data.getStringExtra(CreateEditAccountActivity.EXTRA_PHONENUMBER);
            String email = data.getStringExtra(CreateEditAccountActivity.EXTRA_EMAIL);
            String organizationName = data.getStringExtra(CreateEditAccountActivity.EXTRA_ORGANIZATIONNAME);
            String registrationDateID = data.getStringExtra(CreateEditAccountActivity.EXTRA_REGISTRATIONDATEID);
            String startingDateID = data.getStringExtra(CreateEditAccountActivity.EXTRA_STARTINGDATEID);
            String userAddressID = data.getStringExtra(CreateEditAccountActivity.EXTRA_USERADDRESSID);
            String postalCodeID = data.getStringExtra(CreateEditAccountActivity.EXTRA_POSTALCODEID);
            String administratorFlag = data.getStringExtra(CreateEditAccountActivity.EXTRA_ADMINISTRATIONFLAG);
            String returnAssociateFlag = data.getStringExtra(CreateEditAccountActivity.EXTRA_RETURNASSOCIATEFLAG);
            String salesAssociateFlag = data.getStringExtra(CreateEditAccountActivity.EXTRA_SALESASSOCIATEFLAG);
            String receivingAssociateFlag = data.getStringExtra(CreateEditAccountActivity.EXTRA_RECEIVINGASSOCIATEFLAG);
            String ownerFlag = data.getStringExtra(CreateEditAccountActivity.EXTRA_OWNERFLAG);

            User user = new User(
                    employeeID,
                    userName,
                    lastName,
                    firstName,
                    password,
                    phoneNumber,
                    email,
                    organizationName,
                    registrationDateID,
                    startingDateID,
                    userAddressID,
                    postalCodeID,
                    administratorFlag,
                    returnAssociateFlag,
                    salesAssociateFlag,
                    receivingAssociateFlag,
                    ownerFlag
            );
            accountViewModel.insert(user);
            Toast.makeText(getApplicationContext(), "Account Saved", Toast.LENGTH_LONG).show();

        } else if (requestCode == EDIT_USER_REQUEST && resultCode == RESULT_OK) {
            String employeeID = data.getStringExtra(CreateEditAccountActivity.EXTRA_EMPLOYEEID);
            String userName = data.getStringExtra(CreateEditAccountActivity.EXTRA_USERNAME);
            String lastName = data.getStringExtra(CreateEditAccountActivity.EXTRA_LASTNAME);
            String firstName = data.getStringExtra(CreateEditAccountActivity.EXTRA_FIRSTNAME);
            String password = data.getStringExtra(CreateEditAccountActivity.EXTRA_PASSWORD);
            String phoneNumber = data.getStringExtra(CreateEditAccountActivity.EXTRA_PHONENUMBER);
            String email = data.getStringExtra(CreateEditAccountActivity.EXTRA_EMAIL);
            String organizationName = data.getStringExtra(CreateEditAccountActivity.EXTRA_ORGANIZATIONNAME);
            String registrationDateID = data.getStringExtra(CreateEditAccountActivity.EXTRA_REGISTRATIONDATEID);
            String startingDateID = data.getStringExtra(CreateEditAccountActivity.EXTRA_STARTINGDATEID);
            String userAddressID = data.getStringExtra(CreateEditAccountActivity.EXTRA_USERADDRESSID);
            String postalCodeID = data.getStringExtra(CreateEditAccountActivity.EXTRA_POSTALCODEID);
            String administratorFlag = data.getStringExtra(CreateEditAccountActivity.EXTRA_ADMINISTRATIONFLAG);
            String returnAssociateFlag = data.getStringExtra(CreateEditAccountActivity.EXTRA_RETURNASSOCIATEFLAG);
            String salesAssociateFlag = data.getStringExtra(CreateEditAccountActivity.EXTRA_SALESASSOCIATEFLAG);
            String receivingAssociateFlag = data.getStringExtra(CreateEditAccountActivity.EXTRA_RECEIVINGASSOCIATEFLAG);
            String ownerFlag = data.getStringExtra(CreateEditAccountActivity.EXTRA_OWNERFLAG);

            User user = new User(
                    employeeID,
                    userName,
                    lastName,
                    firstName,
                    password,
                    phoneNumber,
                    email,
                    organizationName,
                    registrationDateID,
                    startingDateID,
                    userAddressID,
                    postalCodeID,
                    administratorFlag,
                    returnAssociateFlag,
                    salesAssociateFlag,
                    receivingAssociateFlag,
                    ownerFlag
            );

            user.setEmployeeID(employeeID);
            accountViewModel.update(user);
            Toast.makeText(getApplicationContext(), "Account Updated", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Account Not Saved", Toast.LENGTH_LONG).show();
        }
    }
}
