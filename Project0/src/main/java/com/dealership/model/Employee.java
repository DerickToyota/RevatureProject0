package com.dealership.model;

import java.util.Objects;

public class Employee extends Object{

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;


    public Employee(){}

    public Employee(String username, String password, String firstName, String lastName, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return username.equals(employee.username) && password.equals(employee.password) && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && phoneNumber.equals(employee.phoneNumber) && email.equals(employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, phoneNumber, email);
    }
}
