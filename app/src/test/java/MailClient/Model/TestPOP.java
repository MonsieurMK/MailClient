package MailClient.Model;

import MailClient.Mail.Mail;
import org.junit.Test;

import java.util.ArrayList;

public class TestPOP {
    @Test
    public void testReceive() {
        POP pop = new POP();
        ArrayList<Mail> mails = (ArrayList<Mail>) pop.receive("pop.gmail.com", "mailclienttestjava@gmail.com", "azertyui1.");

        System.out.println("number of mails : " + mails.size());
        for (Mail mail:
             mails) {
            System.out.println("mail content : " + mail.getContent());
        }
    }
}
