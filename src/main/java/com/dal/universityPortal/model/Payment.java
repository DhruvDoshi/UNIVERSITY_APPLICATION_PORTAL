package com.dal.universityPortal.model;

public class Payment {

    private Integer application_id;
    private Integer amount;
    private String name;
    private String cardNumber;
    private String expiryDate;
    private String CVV;
    private Integer student_id;

    public Payment(){}

    public Payment (Integer application_id, Integer amount, String name, String cardNumber, String expiryDate, String CVV, Integer student_id) {
        this.application_id = application_id;
        this.amount = amount;
        this.name = name;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.CVV = CVV;
        this.student_id=student_id;
    }

    public Integer getApplication_id() {
        return application_id;
    }

    public void setApplication_id(Integer application_id) {
        this.application_id = application_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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

    public void setStatus(String status) {
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }
}
