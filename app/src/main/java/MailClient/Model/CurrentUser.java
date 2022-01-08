package MailClient.Model;

import MailClient.Mail.Mail;
import MailClient.Mail.User;

import java.util.ArrayList;
import java.util.List;

public class CurrentUser extends User {
    private List<User> contacts = new ArrayList<User> ();

    private ReceiveProtocol protocol;

    private List<Category> categories = new ArrayList<Category> ();

    private SMTP sendProtocol;

    private Category sent;

    private Category mailbox;

    private String host;

    // TODO protect, unsafe
    private String password;

    public CurrentUser(String mailAddress, String name, String host, String password, ReceiveProtocol protocol) {
        super(mailAddress, name);
        this.host = host;
        this.password = password;
        this.protocol = protocol;
    }

    public void addCategory(Category category) {
    }

    public void addMailToCategory(Mail mail, Category category) {
    }

    public void send(Mail mail, List<User> recipients) {
    }

    public List<Mail> receive() {
        return this.protocol.receive(this.host, this.getMailAddress(), this.password);
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
