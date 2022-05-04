package com.example.byblosproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDeleteServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_service);

        Button deleteServices = findViewById(R.id.button27);

        deleteServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteServiceButton();
            }
        });
    }

    public void deleteServiceButton(){
        dbHandler db = new dbHandler(this);
        EditText temp;
        String serviceName;

        temp = (EditText)findViewById(R.id.editTextTextPersonName12);
        serviceName = temp.getText().toString();

        db.deleteService(serviceName);
    }
}
