package MailClient.Model;


import MailClient.Mail.Mail;

import java.util.List;

public class IMAP extends ReceiveProtocol {
    @Override
    public List<Mail> receive(String host, String user, String password) {
        return null;
    }
}
