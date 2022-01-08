package MailClient.Controller;

import MailClient.Mail.Mail;
import MailClient.View.MailListPanel;
import MailClient.View.UpperMailPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MailReceiverListener implements ActionListener {

    private UpperMailPanel ump;
    private MainController mc;

    public MailReceiverListener(UpperMailPanel ump, MainController mc) {
        this.ump = ump;
        this.mc = mc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((MailListPanel) this.ump.getParentPane()).clearMail();
        List<Mail> mails = this.mc.receive();
        for (Mail mail :
                mails) {
            ((MailListPanel) this.ump.getParentPane()).addMail(mail);
        }
    }
}
