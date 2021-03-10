package com.dealership.ui;

import com.dealership.db.DaoFactory;
import com.dealership.model.Offer;
import com.dealership.model.User;
import com.dealership.service.OfferService;

import java.util.Scanner;

public class CustomerMenu {

        private User u;

        public CustomerMenu(User u) {
        this.u = u;
    }

        public void showMenu(Scanner scan) {

            OfferService os = new OfferService(DaoFactory.daoFactory(Offer.class));
            System.out.println("CustomerMENU");

            System.out.println("1. View Cars On Lot");
            System.out.println("2. Make an Offer");
            System.out.println("3. Your Owned Cars");
            System.out.println("4. Logout");

            //TODO: Implement the cases in the switch statement
            switch (scan.nextLine()){
                case "1":
                    new UserLotMenu(u).showMenu(scan);
                    //new CheckInMenu(u).showMenu(scan);
                    break;
                case "2":
                    System.out.println("Enter VIN: ");
                    int vin = scan.nextInt();
                    System.out.println("Enter offer $: ");
                    int offer = scan.nextInt();
                    System.out.println("Call to Service to Make an offer on car with ID num of " + vin + "and offer of $" + offer );
                    os.makeOffer(u.getUsername(), vin, offer);
                    showMenu(scan);
                    break;
                case "3":
                    new UserOwnedCarMenu(u).showMenu(scan);
                    //showMenu(scan);
                    break;
                case "4":
                    System.out.println("Logout");
                    break;

                default:
                    showMenu(scan);
                    return;
            }
        }


}
