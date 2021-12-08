package MailClient.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mail {
    private String mailObject;

    private String content;

    private Date date;

    private List<Attachment> attachements = new ArrayList<Attachment> ();

    private User sender;

    private List<User> recipient = new ArrayList<User> ();

    public Mail(String mailObject, String content, User sender, User recipient) {
    }

    public String getMailObject() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.mailObject;
    }

    public String getContent() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.content;
    }

    public Date getDate() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.date;
    }

    public void addAttachment(Attachment attachment) {
    }

    public void addRecipient(User recipient) {
    }

}
