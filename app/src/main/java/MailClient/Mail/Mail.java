package MailClient.Mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mail {

    // TODO implement senders and recipients display
    private final String mailSubject;
    private final Date sentDate;
    private final List<User> senders;
    private final List<User> recipients;
    private final String content;
    // maybe use a Hashmap ?
    private List<Attachment> attachements;

    public Mail(String mailSubject, List<User> senders, List<User> recipients, Date sentdate, String content) {
        this.mailSubject = mailSubject;
        this.senders = new ArrayList<>(senders);
        this.recipients = new ArrayList<>(recipients);
        this.sentDate = sentdate;
        this.content = content;
    }

    public Mail(String mailSubject, List<User> senders, List<User> recipients, Date sentDate, String content, List<Attachment> attachements) {
        this.mailSubject = mailSubject;
        this.sentDate = sentDate;
        this.senders = new ArrayList<>(senders);
        this.recipients = new ArrayList<>(recipients);
        this.content = content;
        this.attachements = new ArrayList<>(attachements);
    }

    public String getMailSubject() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.mailSubject;
    }

    public String getContent() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.content;
    }

    public Date getSentDate() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.sentDate;
    }

    public void addAttachment(Attachment attachment) {
        this.attachements.add(attachment);
    }

    public void addRecipient(User recipient) {
        this.recipients.add(recipient);
    }

    public List<Attachment> getAttachements() {
        return attachements;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "mailSubject='" + mailSubject + '\'' +
                ", content='" + content + '\'' +
                ", sentDate=" + sentDate +
                ", sender=" + senders +
                ", recipient=" + recipients +
                '}';
    }
}
