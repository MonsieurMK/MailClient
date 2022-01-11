package MailClient.Model;

import MailClient.Mail.Mail;
import MailClient.Mail.User;

import java.util.ArrayList;
import java.util.List;

public class CurrentUser extends User {
    private final List<User> contacts = new ArrayList<>();

    private final List<Category> categories = new ArrayList<> ();

    private Category sent;

    private Category mailbox;

    private final String host;

    // TODO protect, unsafe
    private final String password;

    public CurrentUser(String mailAddress, String name, String host, String password) {
        super(mailAddress, name);
        this.host = host;
        this.password = password;
    }

    public void addCategory(Category category) {
    }

    public void addMailToCategory(Mail mail, Category category) {
    }

    public void send(Mail mail, List<User> recipients) {
    }

    public List<Mail> receive(ReceiveProtocol receiveProtocol) {
        return MailManager.receive(this.host, this.getMailAddress(), this.password, receiveProtocol);
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
