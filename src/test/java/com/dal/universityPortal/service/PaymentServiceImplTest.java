package com.dal.universityPortal.service;

import com.dal.universityPortal.database.PaymentDao;
import com.dal.universityPortal.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {
    @InjectMocks
    private PaymentServiceImpl paymentServiceImpl;

    @Mock
    private PaymentDao paymentDao;

    private Payment payment = new Payment(34,100,"Dhruv","5425233430109903","07/25", "132", 26);
    private Payment payment1 = new Payment(35,100,"Dhruv","5425233430109903","07/25", "132", 26);

    @BeforeEach
    public void setUp()  {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void savePaymentPassTest() throws SQLException {
        paymentServiceImpl.savePayment(payment);
        Mockito.verify(paymentDao).update(payment);
        Mockito.verify(paymentDao).insert(payment);
    }

    @Test
    void savePaymentFailTest() throws SQLException {
        paymentServiceImpl.savePayment(payment1);
        Mockito.verify(paymentDao).update(payment1);
        Mockito.verify(paymentDao).update(payment1);
    }

    @Test
    void paymentCheck() throws SQLException {
        Payment payment = new Payment(1,100,"Dhruv","5425233430109903","07/25", "132", 7);
        Payment payment1 = new Payment();
        payment1.setApplication_id(1);
        payment1.setAmount(100);
        payment1.setName("Dhruv");
        payment1.setCardNumber("5425233430109903");
        payment1.setExpiryDate("07/25");
        payment1.setCVV("132");
        payment1.setStudent_id(7);
        Payment payment2 = payment1;
        assertEquals(payment2, payment1);
    }
}
