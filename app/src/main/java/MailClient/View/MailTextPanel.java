package MailClient.View;

import MailClient.Mail.Mail;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.io.IOException;

public class MailTextPanel extends JTextPane {

    private final MailInfoPanel mailInfosPanel;
    private final JTextPane mailBody;

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
        this.mailBody = new JTextPane();
        this.mailBody.setContentType("text/html");
        this.mailBody.setEditable(false);
        this.mailBody.setAlignmentX(JTextArea.LEFT_ALIGNMENT);
        mailBodyPanel.add(mailBody);
        JScrollPane bodyScrollPane = new JScrollPane(this.mailBody, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(bodyScrollPane, gbc);
    }

    public void showMailContent(Mail mail) {
        // mail infos
        this.mailInfosPanel.setSubject(mail.getMailSubject());
        this.mailInfosPanel.setDate(mail.getSentDate());
        // TODO change when senders added to mail
        this.mailInfosPanel.setSender(null);

        // mail body
        HTMLDocument doc = (HTMLDocument) this.mailBody.getStyledDocument();
        try {
            doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()), mail.getContent());
        } catch (BadLocationException | IOException e) {
            e.printStackTrace();
        }
    }
}
