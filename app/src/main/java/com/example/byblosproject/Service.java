package com.example.byblosproject;

public class Service {
    private String serviceName;
    private double hourlyRate;
    private int customerFirstName;
    private int customerLastName;
    private int customerDateOfBirth;
    private int customerAddress;
    private int customerEmail;
    private int licenseType;
    private int carType;
    private int pickUpDate;
    private int pickUpTime;
    private int returnDate;
    private int returnTime;
    private int areaOfUse;
    private int maxDistance;
    private int startLocation;
    private int endLocation;
    private int numOfMovers;
    private int numOfBoxes;

    public Service(String serviceName, double hourlyRate, int customerFirstName, int customerLastName,
                   int customerDateOfBirth, int customerAddress, int customerEmail, int licenseType,
                   int carType, int pickUpDate, int pickUpTime, int returnDate, int returnTime,
                   int areaOfUse, int maxDistance, int startLocation, int endLocation, int numOfMovers,
                   int numOfBoxes){
        this.serviceName = serviceName;
        this.hourlyRate = hourlyRate;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.licenseType = licenseType;
        this.carType = carType;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.areaOfUse = areaOfUse;
        this.maxDistance = maxDistance;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.numOfMovers = numOfMovers;
        this.numOfBoxes = numOfBoxes;
    }
/*
    public void setCustomerFirstName(String firstName){
        customerFirstName = firstName;
    }
    public void setCustomerLastName(String lastName){
        customerLastName = lastName;
    }
    public void setCustomerDateOfBirth(String dateOfBirth){
        customerDateOfBirth = dateOfBirth;
    }
    public void setCustomerAddress(String address){
        customerAddress = address;
    }
    public void setCustomerFirstName(String email){
        customerEmail = email;
    }
*/
    public String getServiceName(){ return serviceName; }
    public double getHourlyRate(){ return hourlyRate; }
    public int getCustomerFirstName() {return customerFirstName;}
    public int getCustomerLastName() {return customerLastName;}
    public int getCustomerDateOfBirth() {return customerDateOfBirth;}
    public int getCustomerAddress() {return customerAddress;}
    public int getCustomerEmail() {return customerEmail;}
    public int getLicenseType() {return licenseType;}
    public int getCarType() {return carType;}
    public int getPickUpDate(){ return pickUpDate; }
    public int getPickUpTime(){return pickUpTime;}
    public int getReturnDate(){return returnDate;}
    public int getReturnTime(){return returnTime;}
    public int getAreaOfUse() { return areaOfUse;}
    public int getMaxDistance() {return maxDistance;}
    public int getStartLocation() {return startLocation;}
    public int getEndLocation() {return endLocation;}
    public int getNumOfMOvers() {return numOfMovers;}
    public int getNumOfBoxes() {return numOfBoxes;}

}