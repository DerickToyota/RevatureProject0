package com.dealership.service;

import com.dealership.db.GenericDao;
import com.dealership.model.Car;

public class LotService {
    GenericDao<Car, Integer> cj;

    public LotService(GenericDao<Car, Integer> cj) {
        this.cj = cj;
        this.lot = lot;
    }


    //----------------------------------------------------
    //lot for testing logic. purposes not connected to db

    private Car[] lot = new Car[2];

    Car c1 = new Car(1000, "make", "Model", 10, "blue", 2000);
    Car c2 = new Car(2, "toyota", "corolla", 1200, "green", 4000);
    // --------------------------------------------------

    //Using the CarDao it gets all cars on the lot and prints the results to the console
    public void getCarsOnLot() {
        cj.getAll();
//        System.out.println("made it to getCarsOnLot");
//        lot[0] = c1;
//        lot[1] = c2;

//        for (Car c: lot) {
//            System.out.println(c.toString());
//        }

    }

    public boolean doesVinExist(int vin){

        System.out.println("Does ID Exist: " + cj.doesIDExist(vin));
        return cj.doesIDExist(vin);
    }

    public boolean addCarToLot(int vin, String make, String model, int miles, String color, int price) {
        System.out.println("does vin exist: " + !doesVinExist(vin));
        if(!doesVinExist(vin)){
            System.out.println("DId we get in here");
            if(1 == cj.save(new Car(vin, make,model,miles,color,price))){
                return true;
            }
        }
        System.out.println("A car with this vin already exists on the lot.");
        return false;
    }

    public boolean removeCarFromLot(int vin){
        if(doesVinExist(vin)){
            if(cj.remove(vin)){
                return true;
            }
        }
        return false;
    }

    public Car getCar(int vin) {
       return cj.getbyId(vin);
    }


    public void updateCar(Car c) {
        cj.update(c);
    }
}

