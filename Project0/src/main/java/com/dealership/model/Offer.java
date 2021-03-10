package com.dealership.model;

import com.dealership.service.OfferService;

import javax.sound.midi.Soundbank;
import java.util.Objects;

public class Offer {
    private int id;
    private String username;
    private Integer vin;

    private User user;
    private Car car;

    private Integer amount;
    private OfferStatus status;

    //TODO: implement status enum of offers
    //private OfferStatus NotChecked;


    public Offer() {
    }

    public Offer(String username, Integer vin, OfferStatus status) {
        this.username = username;
        this.vin = vin;
        this.status = status;
        this.id = this.hashCode();
    }

    public Offer(String username, Integer vin, Integer amount) {
        this.username = username;
        this.vin = vin;
        this.amount = amount;
        this.status = OfferStatus.NOT_VIEWED;
        this.id = this.hashCode();
    }

    public Offer (String username, Integer vin, int amount, OfferStatus status){
        this.username = username;
        this.vin = vin;
        this.amount = amount;
        this.status = status;
        this.id = this.hashCode();
    }

    public Offer (int id, String username, Integer vin, int amount, OfferStatus status){
        this.id = id;
        this.username = username;
        this.vin = vin;
        this.amount = amount;
        this.status = status;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getVin() {
        return vin;
    }

    public void setVin(Integer vin) {
        this.vin = vin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public OfferStatus getStatus() {
        return status;
    }

    public void setStatus(OfferStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id+
                ", username=" + username +
                ", vin=" + vin +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return username.equals(offer.username) && vin.equals(offer.vin) && amount.equals(offer.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, vin, amount);
    }

    public int getId() {
        return this.id;
    }
}
