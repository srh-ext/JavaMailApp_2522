package de.beck.java.sender;

import de.beck.java.mail.Mail;
import de.beck.java.smtp.SMTPConnection;

import javax.mail.*;
import javax.mail.internet.*;

public class Sender {

    private SMTPConnection connection;
    private Session session;
    public Sender() throws Exception {
        this.connection = new SMTPConnection();
        try {
            this.session = this.connection.getConnection();
        } catch(Exception ex) {
            System.out.println("LOG: " + ex.getMessage());
            throw new Exception("Connection failed!");
        }
    }

    public boolean send(Mail mail) throws Exception {
        Message message = new MimeMessage(this.session);

        message.setFrom(new InternetAddress(this.connection.getFrom()));

        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(mail.getRecipient()));

        message.setSubject(mail.getSubject());

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(mail.getMessage(), "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);
        try {
            Transport.send(message);
        } catch (Exception ex) {
            System.out.println("LOG: " + ex.getMessage());
            throw new Exception("Cannot send the mail. Connection failed!");
        }

        return true;
    }
}
