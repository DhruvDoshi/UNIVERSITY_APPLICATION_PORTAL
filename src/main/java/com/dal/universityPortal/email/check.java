package com.dal.universityPortal.email;

import javax.mail.MessagingException;

public class check {

    public static void main(String[] args) {
        String email="arungauda27@gmail.com";
        String subject = "Checking Sendmail";
        String body = "Hello, This is message body";
        String path = "G:/ASD/hello.txt";
        Sendmail sendmail = new Sendmail(email,subject,body,path);
        try {
            sendmail.mail();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
