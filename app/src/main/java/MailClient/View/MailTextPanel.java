package MailClient.View;

import MailClient.Mail.Mail;

import javax.swing.*;
import java.awt.*;

public class MailTextPanel extends JTextPane {

    private MailInfoPanel mailInfosPanel;
    private JTextArea mailBody;

    public MailTextPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.CYAN));

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        this.mailInfosPanel = new MailInfoPanel();
        this.add(this.mailInfosPanel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 4.0;
        JPanel mailBodyPanel = new JPanel();
        this.mailBody = new JTextArea();
        this.mailBody.setEditable(false);
        this.mailBody.setAlignmentX(JTextArea.LEFT_ALIGNMENT);
        mailBodyPanel.add(mailBody);
        this.add(mailBodyPanel, gbc);

    }

    public void showMailContent(Mail mail) {
        // mail infos
        this.mailInfosPanel.setSubject(mail.getMailSubject());
        this.mailInfosPanel.setDate(mail.getSentDate());
        // TODO change when senders added to mail
        this.mailInfosPanel.setSender(null);

        // mail body
        this.mailBody.setText(mail.getContent());
    }
}
