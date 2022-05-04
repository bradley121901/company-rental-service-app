package com.example.byblosproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminDeleteUsersActivity extends AppCompatActivity {
    private ArrayList<BranchEmployee> employees = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_users);
        getNames();
        initRecyclerView();
    }

    private void getNames(){
        dbHandler db = new dbHandler(this);
        employees = db.getEmployees();
        customers = db.getCustomer();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        RecyclerViewAdapterDeleteE adapter = new RecyclerViewAdapterDeleteE(this, employees);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        RecyclerViewAdapterDeleteC adapter2 = new RecyclerViewAdapterDeleteC(this, customers);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
    }

}
