package MailClient.Model;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class POP extends ReceiveProtocol {

    @Override
    public List<Mail> receive(String host, String user, String password) {
        // properties -> sessions -> store -> folder -> messages
        // properties
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "pop3s");
        props.setProperty("mail.pop3s.user", user);
        props.setProperty("mail.pop3s.host", host);
        // TODO if working add port to mathod parameters
        props.setProperty("mail.pop3s.port", "995");
        // may not be needed
        props.setProperty("mail.pop3s.ssl.enable", "true");
        //props.setProperty("mail.debug", "true");

        // session
        Session session = Session.getInstance(props);

        try {
            // store
            Store store = session.getStore("pop3s");
            store.connect(user, password);

            // folder
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            // messages
            System.out.println(folder.getMessageCount() + " messages");
            Message[] messages = folder.getMessages();
            ArrayList<Mail> mails = new ArrayList<>();
            ArrayList<User> senders = new ArrayList<>();
            ArrayList<User> recipients = new ArrayList<>();
            for (Message message :
                    messages) {
                for (Address address:
                     message.getFrom()) {
                    senders.add(new User(address.toString()));
                }
                for (Address address :
                        message.getAllRecipients()) {
                    recipients.add(new User(address.toString()));
                }
                System.out.println("subject : " + message.getSubject());
                MimeMultipart multipart = (MimeMultipart) message.getContent();
                mails.add(new Mail(message.getSubject(),
                        senders,
                        recipients,
                        null,
                        (String) multipart.getBodyPart(0).getContent()));
            }
            folder.close();
            store.close();
            return mails;
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
