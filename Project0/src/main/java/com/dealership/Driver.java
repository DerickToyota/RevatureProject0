package com.dealership;

//import com.crunch.ui.LoginMenu;
import com.dealership.ui.CustomerLoginMenu;
import com.dealership.ui.EmployeeLoginMenu;
import com.dealership.ui.RegisterCustomerMenu;

import java.util.Scanner;

    public class Driver {

        public static void main(String[] args) {
//        System.out.println("we are in crunch");

            //we want to create a User object
            // calling the constructor, Java does provide a default constructor
//        User newUser = new User("fred");
//        System.out.println(newUser.getUsername());
//        newUser.setUsername("harry");
//        System.out.println(newUser.getUsername());
//
//        System.out.println(newUser);
//
//        System.out.println("finished");

            RegisterCustomerMenu rcm = new RegisterCustomerMenu();
            CustomerLoginMenu clm = new CustomerLoginMenu();
            EmployeeLoginMenu elm = new EmployeeLoginMenu();
            Scanner scan = new Scanner(System.in);
            boolean continueLoop = true;
            do {

                System.out.println("DRIVER");

                System.out.println("register, login, employee or exit?");
                String answer = scan.nextLine();
                if(answer.equalsIgnoreCase("exit")){
                    continueLoop = false;
                } else if(answer.equalsIgnoreCase("register")) {
                    rcm.showMenu(scan);
                } else if(answer.equalsIgnoreCase("customer login")) {
                   clm.showMenu(scan);
                } else if(answer.equalsIgnoreCase("employee")){
                    elm.showMenu(scan);
                }
            } while(continueLoop);

        }


    }


