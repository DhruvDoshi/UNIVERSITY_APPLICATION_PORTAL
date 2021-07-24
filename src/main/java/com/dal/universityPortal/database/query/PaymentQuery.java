package com.dal.universityPortal.database.query;

public class PaymentQuery {
    public static final String FOREIGN_KEY_CHECKS = "SET FOREIGN_KEY_CHECKS=OFF;";
    public static final String FETCH_STATUS_APPLICATION_ID = "SELECT status from payment where application_id = ?";
    public static final String UPDATE_STATUS_APPLICATION_ID = "UPDATE payment SET status = 'PAID' WHERE application_id = ?";
    public static final String INSERT_INTO_PAYMENTS = "INSERT INTO payment(application_id, cardNumber)" + "VALUES (?,?)";
}
