package com.example.byblosproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminLoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        Button deleteUsers = findViewById(R.id.button6);
        Button addServices = findViewById(R.id.button7);
        Button editServices = findViewById(R.id.button8);
        Button deleteServices = findViewById(R.id.button9);

        deleteUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUsersButton();
            }
        });

        addServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addServicesButton();
            }
        });

        editServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editServicesButton();
            }
        });

        deleteServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteServicesButton();
            }
        });
    }

    public void deleteUsersButton(){
        Intent intent = new Intent(this, AdminDeleteUsersActivity.class);
        startActivity(intent);
    }

    public void addServicesButton(){
        Intent intent = new Intent(this, AdminAddServiceActivity.class);
        startActivity(intent);
    }

    public void editServicesButton(){
        Intent intent = new Intent(this, AdminEditServiceActivity.class);
        startActivity(intent);
    }

    public void deleteServicesButton(){
        Intent intent = new Intent(this, AdminDeleteServiceActivity.class);
        startActivity(intent);
    }
}
