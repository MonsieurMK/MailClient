package MailClient.Model;

import MailClient.Mail.Mail;
import MailClient.Mail.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class POP extends ReceiveProtocol {

    @Override
    public List<Mail> receive(String host, String mailAddress, String password) {
        // properties -> sessions -> store -> folder -> messages
        // properties
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "pop3s");
        props.setProperty("mail.pop3s.user", mailAddress);
        props.setProperty("mail.pop3s.host", host);
        // TODO if working add port to method parameters
        props.setProperty("mail.pop3s.port", "995");
        // may not be needed
        props.setProperty("mail.pop3s.ssl.enable", "true");
        //props.setProperty("mail.debug", "true");

        // session
        Session session = Session.getInstance(props);

        try {
            // store
            Store store = session.getStore("pop3s");
            store.connect(mailAddress, password);

            // folder
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            // messages
            Message[] messages = folder.getMessages();
            ArrayList<Mail> mails = new ArrayList<>();
            ArrayList<User> senders;
            ArrayList<User> recipients;
            for (Message message :
                    messages) {
                senders = new ArrayList<>();
                recipients = new ArrayList<>();
                for (InternetAddress address:
                        (InternetAddress[]) message.getFrom()) {
                    senders.add(new User(address.getAddress(), address.getPersonal()));
                }
                for (InternetAddress address :
                        (InternetAddress[]) message.getAllRecipients()) {
                    recipients.add(new User(address.toString()));
                }

                // TODO only works for text content, must adapt for other contents
                if (message.getContentType().contains("text")) {
                    mails.add(new Mail(message.getSubject(), senders, recipients, message.getReceivedDate(), message.getContent().toString()));
                } else {
                    mails.add(new Mail(message.getSubject(), senders, recipients, message.getReceivedDate(), "content type not text"));
                }

            }
            folder.close();
            store.close();

            return mails;
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
