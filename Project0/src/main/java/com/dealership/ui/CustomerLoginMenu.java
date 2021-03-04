package com.dealership.ui;

import com.dealership.model.Customer;
import com.dealership.model.User;
import com.dealership.service.UserService;

import java.util.Scanner;

public class CustomerLoginMenu extends AbstractMenu{

       @Override
        public void showMenu(Scanner scan){
           System.out.println("CUSTOMERLOGINMENU");
            for(int i =0; i <= 2; i++) {
                System.out.println("username: ");
                String username = scan.nextLine();
                System.out.println("password: ");
                String password = scan.nextLine();
                Customer c = new UserService().findCustomerByUsername(username);
                if (c == null || !c.getPassword().equals(password)) {
                    System.out.println("login failed");
                } else {
                    System.out.println("Welcome" + c.getUsername());
                    CustomerMenu cm = new CustomerMenu(c);
                    cm.showMenu(scan);
                    break;
                }
            }

        }
    }

