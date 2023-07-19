package de.beck.java.ui;

import de.beck.java.helper.Validator;
import de.beck.java.mail.Mail;

import java.util.Scanner;

public class TerminalUI {

    public static Mail startUI() {
        Mail mail = new Mail();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.print("Please enter recipient > ");
                String recipient = scanner.nextLine();

                if (Validator.isValid(recipient)) {
                    mail.setRecipient(recipient);
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        while(true) {
            try {
                System.out.print("Please enter subject > ");
                String subject = scanner.nextLine();

                if (Validator.isTextValid(subject)) {
                    mail.setSubject(subject);
                    break;
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        while(true) {
            try {
                System.out.print("Please enter message > ");
                String message = scanner.nextLine();

                if (Validator.isTextValid(message)) {
                    mail.setMessage(message);
                    break;
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return mail;
    }
}
