package MailClient.Model;

import com.sun.mail.pop3.POP3Folder;
import com.sun.mail.pop3.POP3Message;
import com.sun.mail.pop3.POP3Store;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class POP extends ReceiveProtocol {

    @Override
    public List<Mail> receive(String host, String storeType, String user, String password) {
        // properties
        Properties props = new Properties();
        props.put("mail.pop3.host", host);
        System.out.println("Prop ok");

        // sessions
        Session session = Session.getDefaultInstance(props);
        System.out.println("Session ok");

        POP3Store store = null;
        POP3Folder folder = null;
        ArrayList<Mail> mails = new ArrayList<>();
        POP3Message message = null;
        // store
        try {
            store = (POP3Store) session.getStore();
            System.out.println("Store ok");
            folder = (POP3Folder) store.getFolder("INBOX");
            System.out.println("Folder ok");
            for (int i = 0; i < folder.getMessageCount(); i++) {
                message = (POP3Message) folder.getMessage(i);
                mails.add(new Mail(message.getSubject(), User.userFromAdress(List.of(message.getFrom())), User.userFromAdress(List.of(message.getAllRecipients())), message.getSentDate(), (String) message.getContent()));
                System.out.println("Mail added");
            }
            store.close();
            folder.close();

            System.out.println("return mails");
            return mails;
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
