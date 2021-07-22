package com.dal.universityPortal.database.query;

public class PaymentQuery {
    public static final String FOREIGN_KEY_CHECKS = "SET FOREIGN_KEY_CHECKS=OFF;";
    public static final String INSERT_CARD_DETAILS =  "INSERT INTO allcards(name, cardNumber, expiryDate, CVV)" + "VALUES (?,?,?,?)";
    public static final String FETCH_STATUS_APPLICATION_ID = "SELECT status from application where id = ?";
    public static final String UPDATE_STATUS_APPLICATION_ID = "UPDATE application SET status = 'PAID' WHERE id = ?";
    public static final String INSERT_INTO_PAYMENTS = "INSERT INTO payment(application_id, cardNumber)" + "VALUES (?,?)";
}
