package MailClient.Model;

import MailClient.Mail.Attachment;
import MailClient.Mail.Mail;
import MailClient.Mail.User;
import net.harawata.appdirs.AppDirs;
import net.harawata.appdirs.AppDirsFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class POP extends ReceiveProtocol {

    @Override
    public List<Mail> receive(String host, String mailAddress, String password) {
        AppDirs appDirs = AppDirsFactory.getInstance();
        String dataFolder = appDirs.getUserDataDir("MailClient", "1.0", "MonsieurSinge");
        //noinspection ResultOfMethodCallIgnored
        (new File(dataFolder)).mkdirs();

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
                for (InternetAddress address:
                        (InternetAddress[]) message.getFrom()) {
                    senders.add(new User(address.getAddress(), address.getPersonal()));
                }
                recipients = new ArrayList<>();
                for (InternetAddress address :
                        (InternetAddress[]) message.getAllRecipients()) {
                    recipients.add(new User(address.toString()));
                }

                if (message.getContentType().contains("text")) {
                    mails.add(new Mail(message.getSubject(),
                            senders,
                            recipients,
                            message.getReceivedDate(),
                            message.getContent().toString()));
                } else if (message.getContentType().contains("multipart")) {
                    StringBuilder body = new StringBuilder();
                    ArrayList<Attachment> attachments = new ArrayList<>();
                    Multipart multipart = (Multipart) message.getContent();
                    for (int i = 0; i < multipart.getCount(); i++) {
                        MimeBodyPart part = (MimeBodyPart) multipart.getBodyPart(i);
                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            // instead use user defined path or save in local data
                            //File file = new File("C:\\Users\\momop\\Documents\\Travail\\Informatique\\Projects\\MailClient\\AttachmentTests" + File.separator + part.getFileName());
                            File file = new File(dataFolder + File.separator + part.getFileName());
                            part.saveFile(file);
                            attachments.add(new Attachment(part.getFileName(), part.getSize(), file));
                        } else {
                            body.append(part.getContent().toString());
                        }
                    }
                    mails.add(new Mail(message.getSubject(), senders, recipients, message.getReceivedDate(), body.toString(), attachments));
                } else {
                    mails.add(new Mail(message.getSubject(), senders, recipients, message.getReceivedDate(), "content type not text"));
                }
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
