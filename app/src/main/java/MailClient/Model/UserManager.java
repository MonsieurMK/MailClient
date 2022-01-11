package MailClient.Model;

import MailClient.Mail.Attachment;
import MailClient.Mail.Mail;
import MailClient.Mail.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    @SuppressWarnings("FieldMayBeFinal")
    private List<User> users = new ArrayList<> ();

    private DatabaseManager databaseManager;

    private final CurrentUser currentUser;

    public UserManager(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public void send(String subject, String content, List<Attachment> attachements, List<User> recipients) {
    }

    public List<Mail> receive(ReceiveProtocol receiveProtocol) {
        return this.currentUser.receive(receiveProtocol);
    }

    public List<Mail> find(String query) {
        // TODO Auto-generated return
        return null;
    }

}
