package com.dal.universityPortal.model;

import java.util.Date;

public class Payment {
    private String application_id;
    private int amount;
    private String email;
    private String name;
    private String cardNumber;
    private String expiryDate;
    private String CVV;

    public Payment(){}
    public Payment (String application_id, int amount, String email, String name, String cardNumber, String expiryDate, String CVV){
        this.application_id = application_id;
        this.amount = amount;
        this.email = email;
        this.name = name;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.CVV = CVV;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
