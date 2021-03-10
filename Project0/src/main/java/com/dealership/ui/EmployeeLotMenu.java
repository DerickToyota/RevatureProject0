package com.dealership.ui;

import com.dealership.db.DaoFactory;
import com.dealership.model.Car;
import com.dealership.model.Offer;
import com.dealership.model.Employee;
import com.dealership.service.LotService;
import com.dealership.service.OfferService;

import java.util.Scanner;

public class EmployeeLotMenu extends AbstractMenu{

    private Employee e;

    public EmployeeLotMenu(Employee e) {
        this.e = e;
    }


    @Override
    public void showMenu(Scanner scan) {

        // UserService us = new UserService(JDBCFactory.daoFactory(User.class));

        //Change back to CAR class after test
        LotService ls = new LotService(DaoFactory.daoFactory(Car.class));
        OfferService os = new OfferService(DaoFactory.daoFactory(Offer.class));


        System.out.println("-------Current Lot---------");

        //user service gets the current state of lot and displays to console
        ls.getCarsOnLot();

        new EmployeeMenu(e).showMenu(scan);

//        System.out.println("1. Add a Car to the Lot");
//        System.out.println("2. View Offers for Car by VIN");
//        System.out.println("3. Remove Car from Lot");
//        System.out.println("4. View All Payments");

        //TODO: Implement the cases in the switch statement
//        switch (scan.nextLine()) {
//            case "1":
////                System.out.println("Enter VIN: ");
////                int vin = Integer.parseInt(scan.nextLine());
////                System.out.println("Enter Make: ");
////                String make = scan.nextLine();
////                System.out.println("Enter Model: ");
////                String model = scan.nextLine();
////                System.out.println("Enter Mileage: ");
////                int miles = Integer.parseInt(scan.nextLine());
////                System.out.println("Enter Color: ");
////                String color = scan.nextLine();
////                System.out.println("Enter price: ");
////                int price = Integer.parseInt(scan.nextLine());
////
////                System.out.println(ls.addCarToLot(vin, make, model, miles, color, price) ?
////                        "successfully Registered " + vin : "cancelled registration");
//
//                new EmployeeMenu(e).showMenu(scan);
//                break;
//            case "2":
//                new EmployeeMenu(e).showMenu(scan);
//                break;
//            case "3":
//                break;
//            default:
//                showMenu(scan);
//                return;
//
//        }
    }
}
