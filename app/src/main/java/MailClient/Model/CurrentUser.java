package MailClient.Model;

import java.util.ArrayList;
import java.util.List;

public class CurrentUser extends User {
    private List<User> contacts = new ArrayList<User> ();

    private ReceiveProtocol protocol;

    private List<Category> categories = new ArrayList<Category> ();

    private SMTP sendProtocol;

    private Category sent;

    private Category mailbox;

    public CurrentUser(String mailAddress, String name, ReceiveProtocol protocol) {
        super(mailAddress, name);
    }

    public void addCategory(Category category) {
    }

    public void addMailToCategory(Mail mail, Category category) {
    }

    public void send(Mail mail, List<User> recipients) {
    }

    public void receive() {
    }

    public void addContact(User contact) {
    }

    public void removeContact(User contact) {
    }

    public List<Mail> find(String query) {
        // TODO Auto-generated return
        return null;
    }

}
