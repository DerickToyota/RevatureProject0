package com.dealership.model;

public class CarList {
    //Meant to represent the list of Cars Owned by a User
    //Could store a list of cars in this object, the implementation
    //    currently prints to console.

    private String username;

    public CarList(){}

    public CarList(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
