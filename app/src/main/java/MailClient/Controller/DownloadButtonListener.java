package MailClient.Controller;

import MailClient.Mail.Attachment;
import org.apache.commons.io.FileUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class DownloadButtonListener implements ActionListener {

    private final Attachment attachment;

    public DownloadButtonListener(Attachment attachment) {
        this.attachment = attachment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File dest = new File("C:\\Users\\momop\\Documents\\Travail\\Informatique\\Projects\\MailClient\\AttachmentTests\\Downloaded" + File.separator + attachment.getName());
        try {
            FileUtils.copyFile(attachment.getFile(), dest);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
