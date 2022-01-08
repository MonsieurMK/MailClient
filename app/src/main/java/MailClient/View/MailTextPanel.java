package MailClient.View;

import MailClient.Mail.Mail;

import javax.swing.*;
import java.awt.*;

public class MailTextPanel extends JTextPane {

    private JLabel mailInfos;
    private JLabel mailBody;

    public MailTextPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.CYAN));

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        this.mailInfos = new JLabel();
        this.add(this.mailInfos, gbc);

        gbc.gridy = 1;
        gbc.weighty = 10.0;
        this.mailBody = new JLabel();
        this.add(this.mailBody, gbc);
        this.mailBody.setVerticalAlignment(JLabel.TOP);
    }

    public void showMailContent(Mail mail) {
        this.mailInfos.setText("Subject: " + mail.getMailSubject() + ", sentDate: " + mail.getSentDate());
        this.mailBody.setText("Content: " + mail.getContent());
    }
}
