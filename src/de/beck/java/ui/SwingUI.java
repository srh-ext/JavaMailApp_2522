package de.beck.java.ui;

import de.beck.java.mail.Mail;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUI {
    private JPanel panel1;
    private JLabel emailAddressLabel;
    private JTextField emailAddressTextField;
    private JLabel subjectLabel;
    private JTextField subjectTextFile;
    private JLabel messageLabel;
    private JTextArea messageTextArea;
    private JButton sendButton;
    private JButton clearButton;

    public SwingUI() {
        this.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emailAddressTextField.setText("example@domain.ltd");
                subjectTextFile.setText("");
                messageTextArea.setText("Message");
            }
        });
        this.sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "E-Mail-Address: " + emailAddressTextField.getText()
                        + "\nSubject: " + subjectTextFile.getText()
                        + "\n Message: \n" + messageTextArea.getText();
                JOptionPane.showMessageDialog(null, message);
            }
        });

        JFrame frame = new JFrame("Mail App");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
