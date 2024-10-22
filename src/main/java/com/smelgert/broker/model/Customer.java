package com.smelgert.broker.model;

public class Customer {

    private String name;
    private String street;
    private String houseNumber;
    private String zipcode;
    private String place;
    private String emailAddress;
    private String phoneNumber;

    public Customer(String name, String street, String houseNumber, String zipcode, String place, String emailAddress, String phoneNumber) {
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
        this.place = place;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }
}
