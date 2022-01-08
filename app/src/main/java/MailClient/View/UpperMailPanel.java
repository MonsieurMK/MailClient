package MailClient.View;

import MailClient.Controller.MailReceiverListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpperMailPanel extends JPanel {

    private MailListPanel parentPane;

    public UpperMailPanel(MailListPanel parentPane) {
        this.parentPane = parentPane;
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        JButton getMail = new JButton("Get mails");

        getMail.addActionListener(new MailReceiverListener(this, this.parentPane.getParentPane().getParentPane().getMc()));

        this.add(getMail);
    }

    public MailListPanel getParentPane() {
        return parentPane;
    }
}
