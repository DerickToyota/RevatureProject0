package com.dealership.db;

public class DaoFactory {

    public static GenericDao daoFactory(Class c){
        switch (c.getName()){
            case "com.dealership.model.User":
                return UserDao.getInstance();
                //TODO: Add case for all obects in the DB (Employees, Cars, Offers?)
            case"com.dealership.model.Car":
                return CarDao.getInstance();
            case "com.dealership.model.Employee":
                return EmployeeDao.getInstance();
            case "com.dealership.model.Offer":
                return OfferDao.getInstance();
            case "com.dealership.model.CarList":
                return CarListDao.getInstance();
            case "com.dealership.model.Payment":
                return PaymentDao.getInstance();
            default:
                throw new IllegalArgumentException("The class provided does not have a corresponding dao object");
        }
    }
}
