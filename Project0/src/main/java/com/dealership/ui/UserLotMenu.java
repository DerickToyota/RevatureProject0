package com.dealership.ui;

import com.dealership.db.DaoFactory;
import com.dealership.model.Car;
import com.dealership.model.Offer;
import com.dealership.model.User;
import com.dealership.service.LotService;
import com.dealership.service.OfferService;

import java.util.Scanner;

public class UserLotMenu extends AbstractMenu{

    private User u;

    public UserLotMenu(User u) {
        this.u = u;
    }


    @Override
    public void showMenu(Scanner scan) {

       // UserService us = new UserService(JDBCFactory.daoFactory(User.class));

        //Change back to CAR class after test
        LotService ls = new LotService(DaoFactory.daoFactory(Car.class));
        OfferService os = new OfferService(DaoFactory.daoFactory(Offer.class));


        System.out.println("=======USER LOT MENU=======");
        System.out.println("-------Current Lot---------");

        //user service gets the current state of lot and displays to console
        ls.getCarsOnLot();

        System.out.println("1. Make an Offer");
        System.out.println("2. Back");
        System.out.println("3. Exit");

        //TODO: Implement the cases in the switch statement
        switch (scan.nextLine()) {
            case "1":
                System.out.println("Enter VIN: ");
                int vin = Integer.parseInt(scan.nextLine());
                System.out.println("Enter offer $: ");
                int offer = Integer.parseInt(scan.nextLine());
                System.out.println("Call to Service to Make an offer on car with vin: " + vin + "and offer of $" + offer);
                os.makeOffer(u.getUsername(), vin, offer);
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
