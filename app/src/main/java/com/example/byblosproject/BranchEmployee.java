package com.example.byblosproject;

import java.util.ArrayList;

public class BranchEmployee extends User {
    ArrayList<String> services;
    public BranchEmployee(String emailAddress, String firstName, String lastName, String userName, String password){
        super(emailAddress, firstName, lastName, userName, password);
    }
    public BranchEmployee(String emailAddress, String firstName, String lastName, String userName, String password, ArrayList<String> services){
        super(emailAddress, firstName, lastName, userName, password);
        this.services = (ArrayList<String>) services.clone();
    }

    public ArrayList<String> getServices(){
        return services;
    }
}
