package com.company.Candies;

import java.util.logging.Logger;

public abstract class Candies {
    private int weight;
    private double price;
    private String name;
    private String manufacturer;


    Candies(){
        weight = 0;
        price = 0;
        name = "";
        manufacturer = "";
    }

    Candies(int weight, double price, String name, String manufacturer){
        this.weight = weight;
        this.price = price;
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription(){
        return "Weight = "+weight+", Price = "+price+", Name = "+name+", Manufacturer = "+manufacturer;
    }
}
