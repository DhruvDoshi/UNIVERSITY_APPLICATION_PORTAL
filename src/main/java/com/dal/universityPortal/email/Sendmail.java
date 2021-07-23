package com.dal.universityPortal.email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import java.util.regex.Pattern;

class Sendmail{
    static String host="smtp.gmail.com";//Mail sending server
    static final String user="university.mail666@gmail.com";//Sender mailid
    static final String password="Pass@word";//Sender mailid's password
    static String to_address;//Receiver mailid
    static String subject;
    static String message_body;
    static String filename;

    public Sendmail() {
    }

    public Sendmail(String to_address,String subject, String message_body, String filename){
        this.to_address = to_address;
        this.subject = subject;
        this.message_body=message_body;
        this.filename=filename;
    }

    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +  //part before @
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public void Set_Attachment(String path){
        this.filename=path;
    }

    public void Set_Message_Body(String message_Body){
        this.message_body=message_Body;
    }

    public String Set_to_Address(String str){
        if(isValid(str)) {
            this.to_address = str;
            return to_address;
        }
        else {
            return "Invalid mail_id";

        }
    }

    public boolean mail() throws MessagingException {
        //1) get the session object
        Properties props = System.getProperties();
        props.put("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", user);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");

        Authenticator authenticator  = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };
        Session session = Session.getDefaultInstance(props,authenticator);

        //2) compose message
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(user));
        mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(to_address));
        mimeMessage.setSubject(subject);

        //3) create MimeBodyPart object and set your message content
        BodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText(message_body);

        //4) create new MimeBodyPart object and set DataHandler object to this object
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();

        //change accordingly
        DataSource dataSource =new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(dataSource));
        messageBodyPart2.setFileName(filename);

        //5) create Multipart object and add MimeBodyPart objects to this object
        Multipart multipart =new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        //6) set the multipart object to the message object
        mimeMessage.setContent(multipart);

        //7) send message
        Transport transport = session.getTransport("smtp");
        transport.connect(host,587,user,"");//If Sender has 2 factor verification then App password is needed else keep an empty string
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        transport.close();

        System.out.println("message sent....");

        return true;
    }
}