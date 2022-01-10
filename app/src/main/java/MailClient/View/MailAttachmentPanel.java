package MailClient.View;

import MailClient.Controller.DownloadButtonListener;
import MailClient.Controller.OpenAttachmentListener;
import MailClient.Mail.Attachment;
import MailClient.Mail.Mail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MailAttachmentPanel extends JPanel {

    public MailAttachmentPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.CYAN));

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(boxLayout);
    }

    public void showMailAttachments(Mail mail)
    throws IllegalAccessException {
        if (mail.getAttachements() != null) {
            for (Attachment attachment :
                    mail.getAttachements()) {

                JButton openButton = new JButton(attachment.getName() + "; size: " + attachment.getSize());
                openButton.addActionListener(new OpenAttachmentListener(attachment));
                this.add(openButton);

                JButton downloadButton = new JButton("Download");
                downloadButton.addActionListener(new DownloadButtonListener(attachment));
                this.add(downloadButton);
            }
        }
    }
}
