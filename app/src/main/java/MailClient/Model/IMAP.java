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

public class IMAP extends ReceiveProtocol {
    @Override
    public List<Mail> receive(String host, String user, String password) {
        AppDirs appDirs = AppDirsFactory.getInstance();
        String dataFolder = appDirs.getUserDataDir("MailClient", "1.0", "MonsieurSinge");
        //noinspection ResultOfMethodCallIgnored
        (new File(dataFolder)).mkdirs();

        // properties
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");

        // session
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(false);

        try {
            // store
            Store store = session.getStore("imaps");
            store.connect(host, user, password);

            // folder
            // Folder folder = store.getFolder("Inbox");
            /* Others GMail folders :
             * [Gmail]/All Mail   This folder contains all of your Gmail messages.
             * [Gmail]/Drafts     Your drafts.
             * [Gmail]/Sent Mail  Messages you sent to other people.
             * [Gmail]/Spam       Messages marked as spam.
             * [Gmail]/Starred    Starred messages.
             * [Gmail]/Trash      Messages deleted from Gmail.
             */
            // use read_write if not working ?

            ArrayList<Mail> mails = new ArrayList<>();

            // folder.open(Folder.READ_ONLY);

            Folder[] folders = store.getDefaultFolder().list("*");
            for (Folder folder :
                    folders) {
                if ((folder.getType() & Folder.HOLDS_MESSAGES) != 0) {
                    folder.open(Folder.READ_WRITE);

                    // messages
                    Message[] messages = folder.getMessages();

                    ArrayList<User> senders;
                    ArrayList<User> recipients;

                    for (Message message :
                            messages) {
                        senders = new ArrayList<>();
                        for (InternetAddress address :
                                (InternetAddress[]) message.getFrom()) {
                            senders.add(new User(address.getAddress(), address.getPersonal()));
                        }
                        recipients = new ArrayList<>();
                        for (InternetAddress address :
                                (InternetAddress[]) message.getAllRecipients()) {
                            recipients.add(new User(address.getAddress(), address.getPersonal()));
                        }

                        if (message.getContentType().toLowerCase().contains("text")) {
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
                            System.out.println("content type: " + message.getContentType());
                            mails.add(new Mail(message.getSubject(), senders, recipients, message.getReceivedDate(), "content type not text"));
                        }
                    }

                    folder.close();
                }
                store.close();

                return mails;
            }

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
