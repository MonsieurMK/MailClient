package MailClient.Model;

import MailClient.Mail.Mail;

import java.util.List;

public abstract class ReceiveProtocol {

    public abstract List<Mail> receive(String host, String user, String password);

}
