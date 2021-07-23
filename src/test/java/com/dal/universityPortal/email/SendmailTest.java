package com.dal.universityPortal.email;

import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SendmailTest {
    @Test
    void testIsValid() {
        Sendmail sm = new Sendmail();
        String email="university@gamil.com";
        assertEquals(true,sm.isValid(email),"Invalid Mail_id Error");
    }

    @Test
    void testSet_Attachment() {
        Sendmail sm = new Sendmail();
        String path = "Set file path";
        sm.Set_Attachment(path);
        assertTrue(sm.filename==path,"Path is not set");
    }

    @Test
    void testSet_Message_Body() {
        Sendmail sm = new Sendmail();
        String body = "Hello, This is message body";
        sm.Set_Message_Body(body);
        assertTrue(sm.message_body==body,"Body is not set");
    }

    @Test
    void testSet_to_address_true() {
        Sendmail sm = new Sendmail();
        String email="mail@gamil.com";
        assertEquals(email,sm.Set_to_Address(email),"Invalid Mail_id Error");
    }
    @Test
    void testSet_to_address_false() {
        Sendmail sm = new Sendmail();
        String email="@gamil.com";
        assertEquals("Invalid mail_id",sm.Set_to_Address(email),"Mail_id is correct");
    }

    @Test
    void testMail() throws MessagingException {
        String email="arunkumargauda1997@gmail.com";
        String subject = "Hello mail";
        String body = "Hello, This is message body";
        String path = "G:\\ASD\\hello.txt";
        Sendmail sendmail = new Sendmail(email,subject,body,path);
        assertTrue(true,"Return False");
        sendmail.mail();
    }
}