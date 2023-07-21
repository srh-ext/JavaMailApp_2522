import de.beck.java.mail.Mail;
import de.beck.java.sender.Sender;
import de.beck.java.ui.SwingUI;
import de.beck.java.ui.TerminalUI;

public class Main {
    public static void main(String[] args) {
        //test();
        try {
            //TerminalUI.startUI();
            SwingUI ui = new SwingUI();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void test() {
        Mail mail = new Mail();
        mail.setRecipient("yuriy@solovyov.de");
        mail.setSubject("Hallo Yuriy");
        mail.setMessage("Sollen wir ausgehen.");

        try {
            Sender sender = new Sender();
            for (int i = 0; i < 1; i++) {
                sender.send(mail);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}