package com.dealership.ui;

import com.dealership.db.DaoFactory;
import com.dealership.model.Car;
import com.dealership.model.CarList;
import com.dealership.model.Payment;
import com.dealership.model.User;
import com.dealership.service.CarListService;
import com.dealership.service.PaymentService;

import java.util.Scanner;

public class UserOwnedCarMenu extends AbstractMenu{

    private User u;

    public UserOwnedCarMenu(User u) {
        this.u = u;
    }

    @Override
    public void showMenu(Scanner scan) {

        CarListService cls = new CarListService(DaoFactory.daoFactory(CarList.class));

        PaymentService ps = new PaymentService(DaoFactory.daoFactory(Payment.class));

        System.out.println();

        System.out.println("=======USER LOT MENU=======");

        //user service gets the current state of lot and displays to console
        cls.getOwnedCars(u.getUsername());

        System.out.println("1. View Remaining Payments by VIN");
        System.out.println("2. Back");
        System.out.println("3. Logout and Exit");

        //TODO: Implement the cases in the switch statement
        switch (scan.nextLine()) {
            case "1":
                System.out.println("Enter VIN: ");
                int vin = Integer.parseInt(scan.nextLine());
                ps.getPayment(vin);
                new CustomerMenu(u).showMenu(scan);
                break;
            case "2":
                new CustomerMenu(u).showMenu(scan);
                break;
            case "3":
                break;
            default:
                showMenu(scan);
                return;

        }
    }
}
