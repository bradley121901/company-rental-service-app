package com.example.byblosproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.common.collect.Lists;

import java.util.ArrayList;


public class dbHandler extends SQLiteOpenHelper {
    private final static String TABLE_ADMIN = "admin";
    private final static String TABLE_EMPLOYEE = "employee";
    private final static String TABLE_CUSTOMER = "customer";

    private final static String USER_TABLE_USERNAME = "userName";
    private final static String USER_TABLE_EMAIL = "emailAddress";
    private final static String USER_TABLE_FIRSTNAME = "firstName";
    private final static String USER_TABLE_LASTNAME = "lastName";
    private final static String USER_TABLE_PASSWORD = "password";

    private final static String SERVICE_ID = "ID";
    private final static String SERVICE_TITLE = "serviceTitle";
    private final static String SERVICE_RATE = "hourlyRate";
    private final static String SERVICE_USER = "customerUserName";
    private final static String SERVICE_BRANCH = "employee";
    private final static String SERVICE_FIRSTNAME = "firstName";
    private final static String SERVICE_LASTNAME = "lastName";
    private final static String SERVICE_DATEOFBIRTH = "dateOfBirth";
    private final static String SERVICE_ADDRESS = "address";
    private final static String SERVICE_EMAIL = "emailAddress";
    private final static String USER_TABLE_SERVICES = "services";

    private final static String SERVICE_LICENSE = "license";
    private final static String SERVICE_PICKUPDATE = "pickUpDate";
    private final static String SERVICE_PICKUPTIME = "pickUpTime";
    private final static String SERVICE_RETURNDATE = "returnDate";
    private final static String SERVICE_RETURNTIME = "returnTime";

    private final static String SERVICE_CAR_TYPE = "carType";

    private String SERVICE_AREAOFUSE = "areaOfUse";
    private String SERVICE_MAXDISTANCE = "maxDistance";

    private String SERVICE_STARTLOCATION ="startLocation";
    private String SERVICE_ENDLOCATION = "endLocation";
    private String SERVICE_NUMOFMOVERS = "numOfMovers";
    private String SERVICE_NUMOFBOXES = "numOfBoxes";

    private final static String TABLE_SERVICES= "services";


    public final static int version = 1;
    public final static String name = "database";


    public dbHandler(Context context) {
        super(context, name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ADMIN_TABLE = "create table " + TABLE_ADMIN + "("
                + USER_TABLE_USERNAME + " TEXT primary key," +
                USER_TABLE_PASSWORD + " TEXT," +
                USER_TABLE_EMAIL + " TEXT," +
                USER_TABLE_FIRSTNAME + " TEXT," +
                USER_TABLE_LASTNAME + " TEXT" + ")";
        db.execSQL(CREATE_ADMIN_TABLE);

        String CREATE_EMPLOYEE_TABLE= "create table " + TABLE_EMPLOYEE + "("
                + USER_TABLE_USERNAME + " TEXT primary key," +
                USER_TABLE_PASSWORD + " TEXT," +
                USER_TABLE_EMAIL + " TEXT," +
                USER_TABLE_FIRSTNAME + " TEXT," +
                USER_TABLE_LASTNAME + " TEXT," +
                USER_TABLE_SERVICES + " TEXT" +")";
        db.execSQL(CREATE_EMPLOYEE_TABLE);

        String CREATE_CUSTOMER_TABLE = "create table " + TABLE_CUSTOMER + "("
                + USER_TABLE_USERNAME + " TEXT primary key," +
                USER_TABLE_PASSWORD + " TEXT," +
                USER_TABLE_EMAIL + " TEXT," +
                USER_TABLE_FIRSTNAME + " TEXT," +
                USER_TABLE_LASTNAME + " TEXT" + ")";
        db.execSQL(CREATE_CUSTOMER_TABLE);

        String CREATE_TABLE_SERVICES= "create table " + TABLE_SERVICES + "(" +
                SERVICE_TITLE + " TEXT primary key not null," +
                SERVICE_RATE + " DOUBLE," +
                SERVICE_FIRSTNAME + " INT," +
                SERVICE_LASTNAME + " INT," +
                SERVICE_DATEOFBIRTH + " INT," +
                SERVICE_ADDRESS + " INT," +
                SERVICE_EMAIL + " INT," +
                SERVICE_LICENSE + " INT," +
                SERVICE_CAR_TYPE + " INT," +
                SERVICE_PICKUPDATE + " INT," +
                SERVICE_PICKUPTIME + " INT," +
                SERVICE_RETURNDATE + " INT," +
                SERVICE_RETURNTIME + " INT," +
                SERVICE_AREAOFUSE + " INT," +
                SERVICE_MAXDISTANCE + " INT," +
                SERVICE_STARTLOCATION + " INT," +
                SERVICE_ENDLOCATION + " INT," +
                SERVICE_NUMOFMOVERS + " INT," +
                SERVICE_NUMOFBOXES + " INT" +
                ")";
        db.execSQL(CREATE_TABLE_SERVICES);
        String employee = "insert into "+ TABLE_EMPLOYEE + " values('" + "employee" + "', '" + "employee" +"', '" + "employee" + "', '" + "employee" + "', '" + "employee" + "')";
        db.execSQL(employee);

        String bigboi = "insert into "+ TABLE_SERVICES + " values('" + "Car Rental" + "', 420.69," +
                "1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0)";
        db.execSQL(bigboi);
        String biggerboi = "insert into "+ TABLE_SERVICES + " values('" + "Truck Rental" + "', 420.69," +
                "1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0)";
        db.execSQL(biggerboi);
        String biggestboi = "insert into "+ TABLE_SERVICES + " values('" + "Moving Assistance" + "', 420.69," +
                "1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1)";
        db.execSQL(biggestboi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_ADMIN);
        db.execSQL("drop table if exists " + TABLE_EMPLOYEE);
        db.execSQL("drop table if exists " + TABLE_CUSTOMER);
        db.execSQL("drop table if exists " + TABLE_SERVICES);

        onCreate(db);
    }
    //adds employee to db
    public void addEmployee(BranchEmployee employee){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_TABLE_USERNAME,employee.getUserName());
        values.put(USER_TABLE_PASSWORD, employee.getPassword());
        values.put(USER_TABLE_FIRSTNAME,employee.getFirstName());
        values.put(USER_TABLE_LASTNAME,employee.getLastName());
        values.put(USER_TABLE_EMAIL, employee.getEmailAddress());
        db.insert(TABLE_EMPLOYEE,null,values);
        db.close();
    }
    //adds customer to db
    public void addCustomer(Customer customer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_TABLE_USERNAME,customer.getUserName());
        values.put(USER_TABLE_PASSWORD, customer.getPassword());
        values.put(USER_TABLE_FIRSTNAME,customer.getFirstName());
        values.put(USER_TABLE_LASTNAME,customer.getLastName());
        values.put(USER_TABLE_EMAIL, customer.getEmailAddress());
        db.insert(TABLE_CUSTOMER,null,values);
        db.close();
    }
    //allows admin to add service to possible services table
    public void addService(Service service){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SERVICE_TITLE, service.getServiceName());
        values.put(SERVICE_RATE, service.getHourlyRate());
        values.put(SERVICE_FIRSTNAME, service.getCustomerFirstName());
        values.put(SERVICE_LASTNAME, service.getCustomerLastName());
        values.put(SERVICE_DATEOFBIRTH, service.getCustomerDateOfBirth());
        values.put(SERVICE_ADDRESS, service.getCustomerAddress());
        values.put(SERVICE_EMAIL, service.getCustomerEmail());
        values.put(SERVICE_LICENSE, service.getLicenseType());
        values.put(SERVICE_CAR_TYPE, service.getCarType());
        values.put(SERVICE_PICKUPDATE, service.getPickUpDate());
        values.put(SERVICE_PICKUPTIME, service.getPickUpTime());
        values.put(SERVICE_RETURNDATE, service.getReturnDate());
        values.put(SERVICE_RETURNTIME, service.getReturnTime());
        values.put(SERVICE_AREAOFUSE, service.getAreaOfUse());
        values.put(SERVICE_MAXDISTANCE, service.getMaxDistance());
        values.put(SERVICE_STARTLOCATION, service.getStartLocation());
        values.put(SERVICE_ENDLOCATION, service.getEndLocation());
        values.put(SERVICE_NUMOFMOVERS, service.getNumOfMOvers());
        values.put(SERVICE_NUMOFBOXES, service.getNumOfBoxes());
        db.insert(TABLE_SERVICES,null,values);
        db.close();
    }
    //allows branch to add service TESTING NEEDED
    public boolean addServiceBranch(String branch, String service){
        SQLiteDatabase db = this.getWritableDatabase();
        String services = getServices(branch);
        if(!branchExists(branch)){ return false;}
        if(services == null) {
            db.execSQL("UPDATE " + TABLE_EMPLOYEE + " SET " + USER_TABLE_SERVICES + " = " + service + " WHERE " + USER_TABLE_USERNAME + " = '" + branch + "'");
        }
        else{
            services = services + "," + service;
            db.execSQL("UPDATE " + TABLE_EMPLOYEE + " SET " + USER_TABLE_SERVICES + " = " + services + " WHERE " + USER_TABLE_USERNAME + " = '" + branch + "'");
        }
        db.close();
        return true;
    }
    //Provides services in string form given branch
    public String getServices(String branch){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EMPLOYEE + " WHERE " + USER_TABLE_USERNAME + " = '" + branch + "'";
        String services;
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            return null;
        }
        services = cursor.getString(5);
        cursor.close();
        db.close();
        return services;
    }
    //gives arraylist of employees TESTING NEEDED
    public ArrayList<BranchEmployee> getEmployees(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EMPLOYEE;
        boolean[] temp = new boolean[3];
        ArrayList<BranchEmployee> employees = new ArrayList<>();
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            return employees;
        }
        do{
            employees.add(new BranchEmployee(cursor.getString(4),
                    cursor.getString(2), cursor.getString(3),
                    cursor.getString(0), cursor.getString(1), Lists.newArrayList((cursor.getString(5).split(",")))));
        }while(cursor.moveToNext());
        cursor.close();
        db.close();
        return employees;
    }
    //gives array list of customers
    public ArrayList<Customer> getCustomer(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CUSTOMER;
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            return customers;
        }
        do{
            customers.add(new Customer(cursor.getString(4),
                    cursor.getString(2), cursor.getString(3),
                    cursor.getString(0), cursor.getString(1)));
        }while(cursor.moveToNext());
        cursor.close();
        db.close();
        return customers;
    }
    //finds singular employee TESTINGREQUIRED
    public BranchEmployee findEmployee(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EMPLOYEE + " WHERE " + USER_TABLE_USERNAME + " = '" + username + "'";
        BranchEmployee employee;
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            return null;
        }
        employee = new BranchEmployee(cursor.getString(4),
                cursor.getString(2), cursor.getString(3),
                cursor.getString(0), cursor.getString(1),Lists.newArrayList((cursor.getString(5).split(","))));
        cursor.close();
        db.close();
        return employee;
    }
    //finds singular customer
    public Customer findCustomer(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CUSTOMER + " WHERE " + USER_TABLE_USERNAME + " = '" + username + "'";
        Customer customer;
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            return null;
        }
        customer = new Customer(cursor.getString(4),
                cursor.getString(2), cursor.getString(3),
                cursor.getString(0), cursor.getString(1));
        cursor.close();
        db.close();
        return customer;
    }
    //deletes employee
    public boolean deleteEmployee(String username){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EMPLOYEE + " WHERE " + USER_TABLE_USERNAME + " = '" + username + "'";
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            return false;
        }

        db.delete(TABLE_EMPLOYEE, USER_TABLE_USERNAME + " = '" + username + "'", null);
        cursor.close();
        db.close();
        return true;
    }
    //deletes services TESTINGREQUIRED
    public boolean deleteService(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_SERVICES + " WHERE " + SERVICE_TITLE + " = '" + name + "'";
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            return false;
        }
        deleteBranchService(name);
        db.delete(TABLE_SERVICES, SERVICE_TITLE + " = '" + name + "'", null);
        cursor.close();
        db.close();
        return true;
    }
    //deletes a branch service from one branch
    public boolean deleteBranchService(String service, String branch){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EMPLOYEE + " WHERE " + USER_TABLE_USERNAME + " = '" + name + "' AND " + USER_TABLE_SERVICES + " LIKE '%" + service + "%'";
        Cursor cursor = db.rawQuery(query, null);
        String replaced;
        if(!cursor.moveToFirst()){
            return false;
        }
        replaced = cursor.getString(5).replace(service, "");
        db.execSQL("UPDATE " + TABLE_EMPLOYEE + " SET " + USER_TABLE_SERVICES + " = '" + replaced + "' WHERE " + USER_TABLE_USERNAME + " = '" + cursor.getString(0) + "'");
        cursor.close();
        db.close();
        return true;
    }
    //helper function for deleting services deleting a service from all the branches
    private void deleteBranchService(String service){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EMPLOYEE + " WHERE " + USER_TABLE_SERVICES + " LIKE '%" + service + "%'";
        Cursor cursor = db.rawQuery(query, null);
        String replaced;
        if(!cursor.moveToFirst()){
            return;
        }
        do{
            replaced = cursor.getString(5).replace(service, "");
            db.execSQL("UPDATE " + TABLE_EMPLOYEE + " SET " + USER_TABLE_SERVICES + " = '" + replaced + "' WHERE " + USER_TABLE_USERNAME + " = '" + cursor.getString(0) + "'");
        }while(cursor.moveToNext());
        cursor.close();
        db.close();
    }
    //helper function for delete
    private boolean deleteEditService(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_SERVICES + " WHERE " + SERVICE_TITLE + " = '" + name + "'";
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            return false;
        }
        db.delete(TABLE_SERVICES, SERVICE_TITLE + " = '" + name + "'", null);
        cursor.close();
        db.close();
        return true;
    }
    //edits a service
    public boolean editServices(Service service){
        if(!deleteEditService(service.getServiceName())){ return false;}
        addService(service);
        return true;
    }

    //deletes a customer
    public boolean deleteCustomer(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CUSTOMER + " WHERE " + USER_TABLE_USERNAME + " = '" + username + "'";
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            return false;
        }
        db.delete(TABLE_CUSTOMER, USER_TABLE_USERNAME + " = '" + username + "'", null);
        cursor.close();
        db.close();
        return true;
    }

    //finds if customer exists
    public boolean customerExists(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CUSTOMER + " WHERE " + USER_TABLE_USERNAME + " = '" + username + "'";
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            return false;
        }
        return true;
    }
    //finds if branch exists
    public boolean branchExists(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EMPLOYEE + " WHERE " + USER_TABLE_USERNAME + " = '" + username + "'";
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            return false;
        }
        return true;
    }

}
