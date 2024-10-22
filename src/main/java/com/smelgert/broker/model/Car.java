package com.smelgert.broker.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

    @Autowired
    private String make;
    private String model;
    private String version;
    private Integer numberOfDoors;
    private String CO2;
    private String grossPrice;
    private String nettPrice;

    public Car(String make, String model, String version, Integer numberOfDoors, String CO2, String grossPrice, String nettPrice) {
        this.make = make;
        this.model = model;
        this.version = version;
        this.numberOfDoors = numberOfDoors;
        this.CO2 = CO2;
        this.grossPrice = grossPrice;
        this.nettPrice = nettPrice;
    }
}

/*

 */