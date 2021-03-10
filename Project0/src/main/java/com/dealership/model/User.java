package com.dealership.model;

import java.util.Objects;

public class User extends Object {

    // TODO: Create constraints for the username to abide by
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;



    public User() {}

    public User(String username) {
        this.username = username;
    }

    public User(String username,    String password,
                String firstName,   String lastName,
                String phoneNumber, String email) {


        this.username = username;
        this.password= password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        //list Offers offersMade = new list();
        //list Cars carsOwned = new list();

    }



    public String getUsername() {
        return username;
    }

    // TODO: check for numerical input and properly formatted if necessary
    public void setUsername(String username) {
        System.out.println(username);
        if (username.length() > 0) {
            this.username = username;
        }
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//
//    public String[] getActivities() {
//        return activities;
//    }
//
//    public void setActivities(String[] activities) {
//        this.activities = activities;
//    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Username = " + username;
    }

    //TODO: this implementation may be wrong, look to gym app for correction
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return false;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(username, password, phoneNumber, email);
        return result;
    }
}
