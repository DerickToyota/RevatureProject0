package com.dealership.ui;

import com.dealership.db.DaoFactory;
import com.dealership.model.User;
import com.dealership.service.UserService;

import java.util.Scanner;

public class RegisterCustomerMenu {

    public void showMenu(Scanner scan) {
        UserService us = new UserService(DaoFactory.daoFactory(User.class));
        System.out.println("====Welcome to the Dealership====");
        String username = "";
        // hey something is wrong
        do {
            System.out.println("provide username");
            username = scan.nextLine();
        } while (us.doesUsernameExist(username));
        System.out.println("provide password");
        String password = scan.nextLine();

        System.out.println("provide first name");
        String firstName = scan.nextLine();

        System.out.println("provide last name");
        String lastName = scan.nextLine();

        // TODO: check phone number
        System.out.println("provide phone number");
        // TODO: check email
        String phoneNumber = scan.nextLine();
        System.out.println("provide email");
        String email = scan.nextLine();

        //TODO: Make Customer instead of a User
        System.out.println(us.makeUser(username, password, firstName, lastName, phoneNumber, email) ?
                "successfully Registered " + username : "cancelled registration");

    }
}
