package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Email;
import com.dal.universityPortal.validator.EmailAddressValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileNotFoundException;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService{
    @Value("${email.host}")
    private String host="smtp.gmail.com";

    @Value("{email.user}")
    private String user="university.mail666@gmail.com";

    @Value("{email.password}")
    private String password="Pass@word";

    @Override
    public Properties getMailproperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", user);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }

    @Override
    public Email addDetails(String toAddress, String subject, String messageBody) {
        Email email= new Email();
        if(EmailAddressValidator.isValid(toAddress)){
            email.setToAddress(toAddress);
            email.setSubject(subject);
            email.setMessageBody(messageBody);
            return email;
        }
        else {
            return email;
        }
    }

    @Override
    public Email addDetailsWithAttachment(String toAddress, String subject, String messageBody, String fileName) {
        Email email = new Email();
        if(EmailAddressValidator.isValid(toAddress)){
            email.setToAddress(toAddress);
            email.setSubject(subject);
            email.setMessageBody(messageBody);
            email.setFileName(fileName);
            return email;
        }
        else {
            return email;
        }
    }

    @Override
    public boolean sendMail(Email email) throws MessagingException {
        Properties properties = getMailproperties();
        Authenticator authenticator  = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };
        Session session = Session.getDefaultInstance(properties,authenticator);
        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress(user));
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(email.getToAddress()));
        message.setSubject(email.getSubject());
        message.setText(email.getMessageBody());
        Transport transport = session.getTransport("smtp");
        transport.connect(host,587,user,"");//If Sender has 2 factor verification then App password is needed else keep an empty string
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        return true;
    }

    @Override
    public boolean sendMailWithAttachment(Email email) throws FileNotFoundException, MessagingException {
        Properties props = getMailproperties();
        Authenticator authenticator  = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };
        Session session = Session.getDefaultInstance(props,authenticator);
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(user));
        mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(email.getToAddress()));
        mimeMessage.setSubject(email.getSubject());
        BodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText(email.getMessageBody());
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource dataSource =new FileDataSource(email.getFileName());
        messageBodyPart2.setDataHandler(new DataHandler(dataSource));
        messageBodyPart2.setFileName(email.getFileName());
        Multipart multipart =new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        mimeMessage.setContent(multipart);
        Transport transport = session.getTransport("smtp");
        transport.connect(host,587,user,"");//If Sender has 2 factor verification then App password is needed else keep an empty string
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        transport.close();
        return true;
    }
}
