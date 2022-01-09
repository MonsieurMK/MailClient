package MailClient.Controller;

import MailClient.Mail.Attachment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OpenAttachmentListener implements ActionListener {

    private final Attachment attachment;

    public OpenAttachmentListener(Attachment attachment) {
        this.attachment = attachment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Desktop.isDesktopSupported() && this.attachment.getFile().exists()) {
            try {
                Desktop.getDesktop().open(attachment.getFile());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
