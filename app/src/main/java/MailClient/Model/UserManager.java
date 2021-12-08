package MailClient.Model;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<User> ();

    private DatabaseManager databaseManager;

    private CurrentUser currentUser;

    public void send(String subject, String content, List<Attachment> attachements, List<User> recipients) {
    }

    public void receive() {
    }

    public List<Mail> find(String query) {
        // TODO Auto-generated return
        return null;
    }

}
