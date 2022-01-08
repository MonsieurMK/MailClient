package MailClient.View;

import MailClient.Mail.Mail;

import javax.swing.*;
import java.awt.*;

public class MailListPanel extends JPanel {

    private CenterPanel parentPane;
    private UpperMailPanel upperMailPanel;
    private MailCardPanel mailCardPanel;

    public MailListPanel(CenterPanel parentPane) {
        this.parentPane = parentPane;
        this.setBorder(BorderFactory.createLineBorder(Color.RED));

        this.setLayout(new BorderLayout());

        this.upperMailPanel = new UpperMailPanel(this);
        this.add(this.upperMailPanel, BorderLayout.NORTH);

        this.mailCardPanel = new MailCardPanel(this);
        this.add(this.mailCardPanel, BorderLayout.CENTER);
    }

    public CenterPanel getParentPane() {
        return parentPane;
    }

    public void addMail(Mail mail) {
        this.mailCardPanel.addMail(mail);
    }

    public void clearMail() {
        this.mailCardPanel.clearMail();
    }
}
