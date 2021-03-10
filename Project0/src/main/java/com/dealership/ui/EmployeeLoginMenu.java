package com.dealership.ui;

import com.dealership.db.DaoFactory;
import com.dealership.model.Employee;
import com.dealership.service.EmployeeService;

import java.util.Scanner;

public class EmployeeLoginMenu extends AbstractMenu{

    //TODO: Reflect the CustomerLoginMenu but with employee Data Structure INstead of Customers
    //TODO: "MaYbE" Abstract these methods to base LOGIN MENU class and just have these classes extend USER LOGIN
    @Override
    public void showMenu(Scanner scan){
        System.out.println("EMPLOYEE LOGIN MENU");
        for(int i =0; i <= 2; i++) {

            System.out.println("username: ");
            String username = scan.nextLine();
            System.out.println("password: ");
            String password = scan.nextLine();

            Employee e = new EmployeeService(DaoFactory.daoFactory(Employee.class)).findEmployeeByUsername(username);

            if (e == null || !e.getPassword().equals(password)) {
                System.out.println("login failed");
            } else {
                System.out.println("Welcome " + e.getUsername());
                EmployeeMenu em = new EmployeeMenu(e);
                em.showMenu(scan);
                //CustomerMenu cm = new CustomerMenu(e);
                //cm.showMenu(scan);
                break;
            }
        }

    }
}
