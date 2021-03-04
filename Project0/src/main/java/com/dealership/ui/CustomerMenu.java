package com.dealership.ui;

import com.dealership.model.Customer;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class CustomerMenu {

        private Customer c;

        public void showMenu(Scanner scan) {
            System.out.println("CustomerMENU");

            System.out.println("1. View Cars On Lot");
            System.out.println("2. Make an Offer");
            System.out.println("3. Your Owned Cars");

            //TODO: Implement the cases in the switch statement
            switch (scan.nextLine()){
                case "1":
                    System.out.println("Call to Service to Pull Cars from Database");
                    //new CheckInMenu(u).showMenu(scan);
                    break;
                case "2":
                    System.out.println("Enter Car ID Number: ");
                    int carID = scan.nextInt();
                    System.out.println("Enter offer $: ");
                    float offer = scan.nextFloat();
                    System.out.println("Call to Service to Make an offer on car with ID num of " + carID + "and offer of $" + offer );
                    break;
                case "3":
                    System.out.println("New Menu to show customers cars/payments");
                    break;
                default:
                    showMenu(scan);
                    return;
            }
        }

        public CustomerMenu(Customer c) {
            this.c = c;
        }
}
