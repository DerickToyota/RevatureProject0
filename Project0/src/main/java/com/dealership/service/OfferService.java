package com.dealership.service;

import com.dealership.db.DaoFactory;
import com.dealership.db.GenericDao;
import com.dealership.model.Car;
import com.dealership.model.Offer;
import com.dealership.model.OfferStatus;
import com.dealership.model.Payment;

import java.util.Locale;

public class OfferService {

    GenericDao<Offer, Integer> oj;

    public OfferService(GenericDao<Offer, Integer> oj) {
        this.oj = oj;
    }


    public void makeOffer(String username, int vin, int offerAmount) {

        oj.save(new Offer(username, vin, offerAmount));
    }

    public void viewOffers(){
        oj.getAll();
    }


    //TODO:DEBUG the sql statement in regards to updateOwner()
    public void offerResponse(Integer id, String response) {

        String status = response.toUpperCase(Locale.ROOT);
        if(status.equals(OfferStatus.ACCEPTED.toString())){
            Offer o = oj.getbyId(id);
            o.setStatus(OfferStatus.ACCEPTED);

            //Update that offer to accepted
            oj.update(o);

            //Update car.owner to offer.username
            updateOwner(o);

            //Delete other offers associated with the vin
            deleteOtherOffers(o);

            //Creates a new Payment object for the user and stores in the db
            PaymentService ps = new PaymentService(DaoFactory.daoFactory(Payment.class));
            ps.createPayment(o.getUsername(), o.getVin(), o.getAmount());
        }else if(status.equals(OfferStatus.REJECTED.toString())){
            Offer o = oj.getbyId(id);
            o.setStatus(OfferStatus.REJECTED);
            oj.update(o);
        }
        System.out.println("Offer response recorded");
    }


    private void deleteOtherOffers(Offer o) {
        oj.remove(o.getId());
    }

    private void updateOwner(Offer o) {
        //Need a car object to update
        o.getVin();
        Car c = new Car();
        c.setVin(o.getVin());

        LotService ls = new LotService(DaoFactory.daoFactory(Car.class));
        c = ls.getCar(c.getVin());
        c.setOwner(o.getUsername());
        ls.updateCar(c);

    }

    private void rejectOffer(Offer o) {

        oj.update(o);
        System.out.println("rejectedOffer method");
    }

}
