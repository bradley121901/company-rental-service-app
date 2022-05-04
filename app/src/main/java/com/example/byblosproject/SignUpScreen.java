package com.example.byblosproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
    }

    public void SignUpCustomer(View view)  {
        SignUp("Customer");
    }

    public void SignUpEmployee(View view)  {
        SignUp("Employee");
    }

    public void SignUp(String type)  {
        dbHandler db = new dbHandler(this);
        String email;
        String firstName;
        String lastName;
        String username;
        String password;
        String confirmation;
        EditText temp;

        temp = (EditText)findViewById(R.id.editTextTextPersonName3);
        firstName = temp.getText().toString();

        temp = (EditText)findViewById(R.id.editTextTextPersonName4);
        lastName = temp.getText().toString();

        temp = (EditText)findViewById(R.id.editTextTextPersonName5);
        username = temp.getText().toString();

        temp = (EditText)findViewById(R.id.editTextTextPersonName6);
        email = temp.getText().toString();

        temp = (EditText)findViewById(R.id.editTextTextPersonName7);
        password = temp.getText().toString();

        temp = (EditText)findViewById(R.id.editTextTextPersonName8);
        confirmation = temp.getText().toString();

        if(!match(firstName) && !match(lastName)){
            //add textbox that says invalid input
           return;
        }

        if(!password.equals(confirmation)){
            //add textbox that says passwords do not match
            return;
        }
        if(!(email.contains("@"))){
            //add textbox that says invalid input
            return;
        }
//        if(db.customerExists(username) || db.branchExists(username)){
//            //add textbox that says username already exists
//            return ;
//        }
        if(type == "Customer"){
            db.addCustomer(new Customer(email, firstName, lastName, username, password));
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivityForResult(intent, 0);
        }

        if(type == "Employee"){
            db.addEmployee(new BranchEmployee(email, firstName, lastName, username, password));
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivityForResult(intent, 0);
        }
    }

    public boolean match(String input){
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
}