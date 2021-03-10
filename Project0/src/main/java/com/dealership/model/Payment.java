package com.dealership.model;

public class Payment {
    String username;
    int vin;
    int startPrice;
    double balanceRemaining;
    int months;
    double nextPayment;

    public double getNextPayment() {
        return nextPayment;
    }

    public void setNextPayment(double nextPayment) {
        this.nextPayment = nextPayment;
    }


    public Payment(String username, int vin, int startPrice, double balanceRemaining, int months, double nextPayment) {
        this.username = username;
        this.vin = vin;
        this.startPrice = startPrice;
        this.balanceRemaining = balanceRemaining;
        this.months = months;
        this.nextPayment = nextPayment;
    }

    public Payment(String username, int vin, int startPrice, double balanceRemaining, int months) {
        this.username = username;
        this.vin = vin;
        this.startPrice = startPrice;
        this.balanceRemaining = startPrice;
        this.months = 60;
        this.nextPayment = doMath();
    }

    public double doMath() {
       return this.balanceRemaining/this.months;
    }

    public Payment(String username, Integer vin, Integer startPrice) {
        this.username = username;
        this.vin = vin;
        this.startPrice = startPrice;
        this.balanceRemaining = startPrice;
        this.months = 60;
        this.nextPayment = doMath();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public double getBalanceRemaining() {
        return balanceRemaining;
    }

    public void setBalanceRemaining(double balanceRemaining) {
        this.balanceRemaining = balanceRemaining;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "username='" + username + '\'' +
                ", vin=" + vin +
                ", startPrice=" + startPrice +
                ", balanceRemaining=" + balanceRemaining +
                ", months=" + months +
                ", nextPayment=" + nextPayment +
                '}';
    }
}
