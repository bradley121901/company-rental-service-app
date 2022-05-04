package com.example.byblosproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AdminAddServiceActivity extends AppCompatActivity {

    private int[] attributes = new int[17];
    private String[] attributeStrings = new String[17];

    private void getAttributeStrings() {
        attributeStrings[0] = "Customer First Name";
        attributeStrings[1] = "Customer Last Name";
        attributeStrings[2] = "Customer Date of Birth";
        attributeStrings[3] = "Customer Address";
        attributeStrings[4] = "Customer Email";
        attributeStrings[5] = "License Type";
        attributeStrings[6] = "Car Type";
        attributeStrings[7] = "Pick Up Date";
        attributeStrings[8] = "Pick Up Time";
        attributeStrings[9] = "Return Date";
        attributeStrings[10] = "Return Time";
        attributeStrings[11] = "Area of Use";
        attributeStrings[12] = "Max Distance";
        attributeStrings[13] = "Start Location";
        attributeStrings[14] = "End Location";
        attributeStrings[15] = "Number of Movers";
        attributeStrings[16] = "Number of Boxes";
    }

    public void addServiceButton(){
        dbHandler db = new dbHandler(this);
        db.addService(addAService());
    }

    public Service addAService(){
        EditText temp;
        String serviceName;
        attributes = RecyclerViewAdapterAddService.getAttributes();

        temp = (EditText)findViewById(R.id.serviceNameAddPage);
        serviceName = temp.getText().toString();

        temp = (EditText)findViewById(R.id.hourlyRateAddPage);
        String rate = temp.getText().toString();
        if(rate == null) { return null;}
        double hourlyRate = Double.parseDouble(rate);
        if(serviceName == null) { return null;}
        Service hold = new Service(serviceName, hourlyRate, attributes[0], attributes[1], attributes[2], attributes[3], attributes[4], attributes[5], attributes[6], attributes[7],
                attributes[8], attributes[9], attributes[10], attributes[11], attributes[12], attributes[13], attributes[14], attributes[15], attributes[16]);

        return hold;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);
        Button addServices = findViewById(R.id.button28);

        addServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addServiceButton();
            }
        });

        getAttributeStrings();
        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView3);
        RecyclerViewAdapterAddService adapter = new RecyclerViewAdapterAddService(this, attributeStrings);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
