package com.dealership.service;

import com.dealership.db.GenericDao;
import com.dealership.model.Car;
import com.dealership.model.Payment;

public class PaymentService {
    GenericDao<Payment, Integer> pj;
    Payment p;

    public  PaymentService(GenericDao<Payment, Integer> pj){
        this.pj = pj;
    }


    public void createPayment(String username, Integer vin, Integer amount) {
        p = new Payment(username, vin, amount);
        pj.save(p);
    }


    public void getPayment(int vin) {
        System.out.println(pj.getbyId(vin));
    }

    public void getAll() {
        pj.getAll();
    }
}
