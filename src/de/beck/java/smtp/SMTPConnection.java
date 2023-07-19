package de.beck.java.smtp;

import javax.mail.*;
import java.util.Properties;

public class SMTPConnection {

    private Session connection;
    private Properties prop;

    private static final String FROM = "java-mail@beck-homes.com";
    private static final String USERNAME = "java-mail@beck-homes.com";
    private static final String PASSWORD = "srh_mail_2023";
    private static final String HOST = "mail.beck-homes.com";
    private static final int PORT = 465;

    public SMTPConnection() {
        this.prop = new Properties();
        this.prop.put("mail.smtp.auth", true);
        this.prop.put("mail.smtp.starttls.enable", "true");
        this.prop.put("mail.smtp.host", HOST);
        this.prop.put("mail.smtp.port", PORT);
        this.prop.put("mail.smtp.ssl.trust", HOST);
        this.prop.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
    }

    public Session getConnection() throws Exception {
        if (this.prop == null) {
            throw new NullPointerException("Configuration not found!");
        }
        try {
            this.connection = Session.getInstance(this.prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
        } catch (Exception ex) {
            throw new Exception("Authentication failed. Username or password is incorrect!");
        }

        return this.connection;
    }

    public String getFrom() {
        return FROM;
    }
}
