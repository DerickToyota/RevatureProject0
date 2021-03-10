package com.dealership.ui;

import com.dealership.db.DaoFactory;
import com.dealership.model.Car;
import com.dealership.model.Employee;
import com.dealership.model.Offer;
import com.dealership.model.Payment;
import com.dealership.service.LotService;
import com.dealership.service.OfferService;
import com.dealership.service.PaymentService;

import java.util.Scanner;

public class EmployeeMenu extends AbstractMenu {

    private Employee e;

    public EmployeeMenu(Employee e) {
        super();
        this.e = e;
    }

    @Override
    public void showMenu(Scanner scan) {

        LotService ls = new LotService(DaoFactory.daoFactory(Car.class));
        OfferService os = new OfferService(DaoFactory.daoFactory(Offer.class));
        PaymentService ps = new PaymentService(DaoFactory.daoFactory(Payment.class));

        System.out.println("EMPLOYEE MENU");

        System.out.println("1. Add a Car to the Lot");
        System.out.println("2. View Current Cars on the Lot");
        System.out.println("3. Remove a Car from the Lot");
        System.out.println("4. View Offers");
        System.out.println("5. Accept/Reject Offers");
        System.out.println("6. View All Payments");
        System.out.println("7. Logout");


        //TODO: Implement the cases in the switch statement
        switch (scan.nextLine()) {
            case "1":
                System.out.println("Enter VIN: ");
                    int vin = Integer.parseInt(scan.nextLine());
                System.out.println("Enter Make: ");
                    String make = scan.nextLine();
                System.out.println("Enter Model: ");
                    String model = scan.nextLine();
                System.out.println("Enter Mileage: ");
                    int miles = Integer.parseInt(scan.nextLine());
                System.out.println("Enter Color: ");
                    String color = scan.nextLine();
                System.out.println("Enter price: ");
                    int price = Integer.parseInt(scan.nextLine());

                System.out.println(ls.addCarToLot(vin, make, model, miles, color, price) ?
                        "successfully Added " + vin : "cancelled registration");
                this.showMenu(scan);
                break;
            case "2":
                System.out.println("-------Current Lot---------");
                ls.getCarsOnLot();
                this.showMenu(scan);
                break;
            case "3":
                System.out.println("Enter VIN to be Removed:");
                vin = Integer.parseInt(scan.nextLine());
                System.out.println(ls.removeCarFromLot(vin) ?
                        "successfully Deleted " + vin : "failed to remove " + vin);
                this.showMenu(scan);
                break;
            case "4":
                os.viewOffers();
                this.showMenu(scan);
                break;
            case "5":
                System.out.println("Accept/Reject Offer");
                System.out.println("Enter Offer ID:");
                int id = Integer.parseInt(scan.nextLine());
                System.out.println("Accept or Reject?");
                String response = scan.nextLine();
                os.offerResponse(id,response);
                this.showMenu(scan);
                break;
            case "6":
                System.out.println("View all Payments");
                ps.getAll();
                this.showMenu(scan);
                break;
            case "7":
                System.out.println("You logged out");
                break;
            default:
                showMenu(scan);
                return;
        }
    }
}
