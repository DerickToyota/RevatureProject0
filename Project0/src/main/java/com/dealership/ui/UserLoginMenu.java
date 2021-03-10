package com.dealership.ui;

import com.dealership.db.DaoFactory;
import com.dealership.model.User;
import com.dealership.service.UserService;

import java.util.Scanner;

public class UserLoginMenu extends AbstractMenu{

       @Override
        public void showMenu(Scanner scan){
           System.out.println("USERLOGINMENU");
            for(int i =0; i <= 2; i++) {
                System.out.println("username: ");
                String username = scan.nextLine();
                System.out.println("password: ");
                String password = scan.nextLine();

                //User u = new UserService().findUserByUsername(username);

                User u = new UserService(DaoFactory.daoFactory(User.class)).findUserByUsername(username);
                if (u == null || !u.getPassword().equals(password)) {
                    System.out.println("login failed");
                } else {
                    System.out.println("Welcome" + u.getUsername());
                    CustomerMenu cm = new CustomerMenu(u);
                    cm.showMenu(scan);
                    break;
                }
            }

        }
    }

