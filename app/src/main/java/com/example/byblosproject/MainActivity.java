package com.example.byblosproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Byblos Project";

    private Admin admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin = new Admin();
    }

    public void LogInButton(View view) {
        dbHandler db = new dbHandler(this);
        db.addCustomer(new Customer("t", "t", "t", "t", "t"));
        db.deleteCustomer("t");
        String username, password;
        EditText temp, temp1;

        temp = (EditText) findViewById(R.id.editTextTextPersonName);
        username = temp.getText().toString();

        temp1 = (EditText) findViewById(R.id.editTextTextPersonName2);
        password = temp1.getText().toString();
        if (username.equals("admin") && password.equals("admin")) {
            Intent intent = new Intent(this, AdminLoginActivity.class);
            startActivity(intent);
            return;
        }
        Customer customerTemp = db.findCustomer(username);
        BranchEmployee branchTemp = db.findEmployee(username);
        if (customerTemp != null && customerTemp.getPassword().equals(password)) {
            setContentView(R.layout.activity_welcome_screen);
            EditText eText = (EditText) findViewById(R.id.editTextTextPersonName9);
            eText.setText("Welcome " + customerTemp.getFirstName() + "!\nYou are logged in as Customer");
        } else if (branchTemp != null && branchTemp.getPassword().equals(password)) {
            setContentView(R.layout.activity_welcome_screen);
            EditText eText = (EditText) findViewById(R.id.editTextTextPersonName9);
            eText.setText("Welcome " + branchTemp.getFirstName() + "!\nYou are logged in as Employee");
        }
    }

    public void SignUpButton(View view) {
        Intent intent = new Intent(this, SignUpScreen.class);
        startActivity(intent);
    }
}