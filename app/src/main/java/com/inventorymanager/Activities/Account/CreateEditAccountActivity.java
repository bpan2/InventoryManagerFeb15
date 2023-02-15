package com.inventorymanager.Activities.Account;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.inventorymanager.R;

public class CreateEditAccountActivity extends AppCompatActivity {
    public static final String EXTRA_EMPLOYEEID = "EXTRA_EMPLOYEEID";
    public static final String EXTRA_USERNAME = "EXTRA_USERNAME";
    public static final String EXTRA_LASTNAME = "EXTRA_LASTNAME";
    public static final String EXTRA_FIRSTNAME = "EXTRA_FIRSTNAME";
    public static final String EXTRA_PASSWORD = "EXTRA_PASSWORD";
    public static final String EXTRA_PHONENUMBER = "EXTRA_PHONENUMBER";
    public static final String EXTRA_EMAIL = "EXTRA_EMAIL";
    public static final String EXTRA_ORGANIZATIONNAME = "EXTRA_ORGANIZATIONNAME";
    public static final String EXTRA_REGISTRATIONDATEID = "EXTRA_REGISTRATIONDATEID";
    public static final String EXTRA_STARTINGDATEID = "EXTRA_STARTINGDATEID";
    public static final String EXTRA_USERADDRESSID = "EXTRA_USERADDRESSID";
    public static final String EXTRA_POSTALCODEID = "EXTRA_POSTALCODEID";
    public static final String EXTRA_ADMINISTRATIONFLAG = "EXTRA_ADMINISTRATIONFLAG";
    public static final String EXTRA_RETURNASSOCIATEFLAG = "EXTRA_RETURNASSOCIATEFLAG";
    public static final String EXTRA_SALESASSOCIATEFLAG = "EXTRA_SALESASSOCIATEFLAG";
    public static final String EXTRA_RECEIVINGASSOCIATEFLAG = "EXTRA_RECEIVINGASSOCIATEFLAG";
    public static final String EXTRA_OWNERFLAG = "EXTRA_OWNERFLAG";

    public TextInputEditText employeeIDCreateAccountTextInputEditText;
    public TextInputEditText userNameCreateAccountTextInputEditText;
    public TextInputEditText lastNameCreateAccountTextInputEditText;
    public TextInputEditText firstNameCreateAccountTextInputEditText;
    public TextInputEditText passwordCreateAccountTextInputEditText;
    public TextInputEditText phoneNumberCreateAccountTextInputEditText;
    public TextInputEditText emailCreateAccountTextInputEditText;
    public TextInputEditText organizationNameCreateAccountTextInputEditText;
    public TextInputEditText registrationDateIDCreateAccountTextInputEditText;
    public TextInputEditText startingDateIDCreateAccountTextInputEditText;
    public TextInputEditText userAddressIDCreateAccountTextInputEditText;
    public TextInputEditText postalCodeIDCreateAccountTextInputEditText;
    public TextInputEditText administratorFlagCreateAccountTextInputEditText;
    public TextInputEditText returnAssociateFlagCreateAccountTextInputEditText;
    public TextInputEditText salesAssociateFlagCreateAccountTextInputEditText;
    public TextInputEditText receivingAssociateFlagCreateAccountTextInputEditText;
    public TextInputEditText ownerFlagCreateAccountTextInputEditText;

    String employeeID;
    String userName;
    String lastName;
    String firstName;
    String password;
    String phoneNumber;
    String email;
    String organizationName;
    String registrationDateID;
    String startingDateID;
    String userAddressID;
    String postalCodeID;
    String administratorFlag;
    String returnAssociateFlag;
    String salesAssociateFlag;
    String receivingAssociateFlag;
    String ownerFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        employeeIDCreateAccountTextInputEditText = findViewById(R.id.employeeIDCreateAccountTextInputEditText);
        userNameCreateAccountTextInputEditText = findViewById(R.id.userNameCreateAccountTextInputEditText);
        lastNameCreateAccountTextInputEditText = findViewById(R.id.lastNameCreateAccountTextInputEditText);
        firstNameCreateAccountTextInputEditText = findViewById(R.id.firstNameCreateAccountTextInputEditText);
        passwordCreateAccountTextInputEditText = findViewById(R.id.passwordCreateAccountTextInputEditText);
        phoneNumberCreateAccountTextInputEditText = findViewById(R.id.phoneNumberCreateAccountTextInputEditText);
        emailCreateAccountTextInputEditText = findViewById(R.id.emailCreateAccountTextInputEditText);
        organizationNameCreateAccountTextInputEditText = findViewById(R.id.organizationNameCreateAccountTextInputEditText);
        registrationDateIDCreateAccountTextInputEditText = findViewById(R.id.registrationDateIDCreateAccountTextInputEditText);
        startingDateIDCreateAccountTextInputEditText = findViewById(R.id.startingDateIDCreateAccountTextInputEditText);
        userAddressIDCreateAccountTextInputEditText = findViewById(R.id.userAddressIDCreateAccountTextInputEditText);
        postalCodeIDCreateAccountTextInputEditText = findViewById(R.id.postalCodeIDCreateAccountTextInputEditText);
        administratorFlagCreateAccountTextInputEditText = findViewById(R.id.administratorFlagCreateAccountTextInputEditText);
        returnAssociateFlagCreateAccountTextInputEditText = findViewById(R.id.returnAssociateFlagCreateAccountTextInputEditText);
        salesAssociateFlagCreateAccountTextInputEditText = findViewById(R.id.salesAssociateFlagCreateAccountTextInputEditText);
        receivingAssociateFlagCreateAccountTextInputEditText = findViewById(R.id.receivingAssociateFlagCreateAccountTextInputEditText);
        ownerFlagCreateAccountTextInputEditText = findViewById(R.id.ownerFlagCreateAccountTextInputEditText);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_24dp);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_EMPLOYEEID)) {
            setTitle("Edit User");
            employeeIDCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_EMPLOYEEID));
            userNameCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_USERNAME));
            lastNameCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_LASTNAME));
            firstNameCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_FIRSTNAME));
            passwordCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_PASSWORD));
            phoneNumberCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_PHONENUMBER));
            emailCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_EMAIL));
            organizationNameCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_ORGANIZATIONNAME));
            registrationDateIDCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_REGISTRATIONDATEID));
            startingDateIDCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_STARTINGDATEID));
            userAddressIDCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_USERADDRESSID));
            postalCodeIDCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_POSTALCODEID));
            administratorFlagCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_ADMINISTRATIONFLAG));
            returnAssociateFlagCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_RETURNASSOCIATEFLAG));
            salesAssociateFlagCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_SALESASSOCIATEFLAG));
            receivingAssociateFlagCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_RECEIVINGASSOCIATEFLAG));
            ownerFlagCreateAccountTextInputEditText.setText(intent.getStringExtra(EXTRA_OWNERFLAG));
        } else {
            setTitle("Add User");
        }
    }

    private void saveUser() {
        employeeID = employeeIDCreateAccountTextInputEditText.getText().toString();
        userName = userNameCreateAccountTextInputEditText.getText().toString();
        lastName = lastNameCreateAccountTextInputEditText.getText().toString();
        firstName = firstNameCreateAccountTextInputEditText.getText().toString();
        password = passwordCreateAccountTextInputEditText.getText().toString();
        phoneNumber = phoneNumberCreateAccountTextInputEditText.getText().toString();
        email = emailCreateAccountTextInputEditText.getText().toString();
        organizationName = organizationNameCreateAccountTextInputEditText.getText().toString();
        registrationDateID = registrationDateIDCreateAccountTextInputEditText.getText().toString();
        startingDateID = startingDateIDCreateAccountTextInputEditText.getText().toString();
        userAddressID = userAddressIDCreateAccountTextInputEditText.getText().toString();
        postalCodeID = postalCodeIDCreateAccountTextInputEditText.getText().toString();
        administratorFlag = administratorFlagCreateAccountTextInputEditText.getText().toString();
        returnAssociateFlag = returnAssociateFlagCreateAccountTextInputEditText.getText().toString();
        salesAssociateFlag = salesAssociateFlagCreateAccountTextInputEditText.getText().toString();
        receivingAssociateFlag = receivingAssociateFlagCreateAccountTextInputEditText.getText().toString();
        ownerFlag = ownerFlagCreateAccountTextInputEditText.getText().toString();

        if (employeeID.trim().isEmpty() ||
                userName.trim().isEmpty() ||
                lastName.trim().isEmpty() ||
                firstName.trim().isEmpty() ||
                password.trim().isEmpty() ||
                phoneNumber.trim().isEmpty() ||
                email.trim().isEmpty() ||
                organizationName.trim().isEmpty() ||
                registrationDateID.trim().isEmpty() ||
                startingDateID.trim().isEmpty() ||
                userAddressID.trim().isEmpty() ||
                postalCodeID.trim().isEmpty() ||
                administratorFlag.trim().isEmpty() ||
                returnAssociateFlag.trim().isEmpty() ||
                salesAssociateFlag.trim().isEmpty() ||
                receivingAssociateFlag.trim().isEmpty() ||
                ownerFlag.trim().isEmpty()) {

            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show();
            return;

        } else {
            Intent data = new Intent();

            data.putExtra(EXTRA_EMPLOYEEID, employeeID);
            data.putExtra(EXTRA_USERNAME, userName);
            data.putExtra(EXTRA_LASTNAME, lastName);
            data.putExtra(EXTRA_FIRSTNAME, firstName);
            data.putExtra(EXTRA_PASSWORD, password);
            data.putExtra(EXTRA_PHONENUMBER, phoneNumber);
            data.putExtra(EXTRA_EMAIL, email);
            data.putExtra(EXTRA_ORGANIZATIONNAME, organizationName);
            data.putExtra(EXTRA_REGISTRATIONDATEID, registrationDateID);
            data.putExtra(EXTRA_STARTINGDATEID, startingDateID);
            data.putExtra(EXTRA_USERADDRESSID, userAddressID);
            data.putExtra(EXTRA_POSTALCODEID, postalCodeID);
            data.putExtra(EXTRA_ADMINISTRATIONFLAG, administratorFlag);
            data.putExtra(EXTRA_RETURNASSOCIATEFLAG, returnAssociateFlag);
            data.putExtra(EXTRA_SALESASSOCIATEFLAG, salesAssociateFlag);
            data.putExtra(EXTRA_RECEIVINGASSOCIATEFLAG, receivingAssociateFlag);
            data.putExtra(EXTRA_OWNERFLAG, ownerFlag);

            setResult(RESULT_OK, data);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.create_account_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_account:
                saveUser();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
