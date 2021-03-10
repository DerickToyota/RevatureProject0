package com.dealership.model;

import java.util.Objects;

public class Car {

    private int    vin;
    private String make;
    private String model;
    private int    miles;
    private String color;
    private String owner;
    private int    price;

    public Car() {
    }

    public Car(int vin, String make, String model, int miles, String color, int price) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.miles = miles;
        this.color = color;
        this.owner = null;
        this.price = price;
    }


    public Car(int vin, String make, String model, int miles, String color, String owner, int price) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.miles = miles;
        this.color = color;
        this.owner = owner;
        this.price = price;
    }



    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() { return owner; }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return vin == car.vin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin, make, model, miles, color, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin=" + vin +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", miles=" + miles +
                ", color='" + color + '\'' +
                ", owner=' "+ owner+ '\'' +
                ", price=" + price +
                '}';
    }
}
