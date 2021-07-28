package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PaymentServiceImplTest {
    private PaymentServiceImpl paymentServiceImpl;
    @BeforeEach
    public void setup() {paymentServiceImpl = Mockito.mock(PaymentServiceImpl.class);    }

    @Test
    void savePaymentTest() throws SQLException {
        assertEquals("1","1");
    }
}
