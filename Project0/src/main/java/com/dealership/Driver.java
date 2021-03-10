package com.dealership;

import com.dealership.ui.UserLoginMenu;
import com.dealership.ui.EmployeeLoginMenu;
import com.dealership.ui.RegisterCustomerMenu;

import java.util.Locale;
import java.util.Scanner;

    public class Driver {


        public static final Scanner scan = new Scanner(System.in);

        public static void main(String[] args) {

            RegisterCustomerMenu rcm = new RegisterCustomerMenu();
            UserLoginMenu clm = new UserLoginMenu();
            EmployeeLoginMenu elm = new EmployeeLoginMenu();
            boolean continueLoop = true;
            do {

                System.out.println("DRIVER");


                System.out.println("register, login, employee or exit?");
                String answer = scan.nextLine();
                if(answer.equalsIgnoreCase("exit")){
                    System.out.println("Successfully Exited");
                    continueLoop = false;
                } else if(answer.equalsIgnoreCase("register")) {
                    rcm.showMenu(scan);
                } else if(answer.equalsIgnoreCase("login")) {
                   clm.showMenu(scan);
                } else if(answer.equalsIgnoreCase("employee")){
                    elm.showMenu(scan);
                }
            } while(continueLoop);

        }


    }


