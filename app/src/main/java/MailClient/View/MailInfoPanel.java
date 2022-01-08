package MailClient.View;

import MailClient.Mail.User;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class MailInfoPanel extends JPanel {

    private JLabel[][] labels;

    public MailInfoPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;



        labels = new JLabel[3][2];

        labels[0][0] = new JLabel("Subject: ");
        labels[0][0].setFont(new Font("Calibri", Font.BOLD, 15));
        this.add(labels[0][0], gbc);

        gbc.gridx = 1;
        gbc.weightx = 3.0;
        labels[0][1] = new JLabel();
        labels[0][1].setFont(new Font("Calibri", Font.PLAIN, 15));
        this.add(labels[0][1], gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        labels[1][0] = new JLabel("Date: ");
        labels[1][0].setFont(new Font("Calibri", Font.BOLD, 15));
        this.add(labels[1][0], gbc);

        gbc.gridx = 1;
        gbc.weightx = 3.0;
        labels[1][1] = new JLabel();
        labels[1][1].setFont(new Font("Calibri", Font.PLAIN, 15));
        this.add(labels[1][1], gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        labels[2][0] = new JLabel("Sender(s): ");
        labels[2][0].setFont(new Font("Calibri", Font.BOLD, 15));
        this.add(labels[2][0], gbc);

        gbc.gridx = 1;
        gbc.weightx = 3.0;
        labels[2][1] = new JLabel();
        labels[2][1].setFont(new Font("Calibri", Font.PLAIN, 15));
        this.add(labels[2][1], gbc);
    }

    public void setSubject(String subject) {
        this.labels[0][1].setText(subject);
    }

    public void setDate(Date date) {
        if (date != null) {
            this.labels[1][1].setText(date.toString());
        } else {
            this.labels[1][1].setText("no date found");
        }
    }

    public void setSender(List<User> senders) {
        if (senders != null) {
            String s = "";
            for (User user :
                    senders) {
                s += user.getMailAddress() + "; ";
            }
            this.labels[2][1].setText(s);
        } else {
            this.labels[2][1].setText("no senders found");
        }
    }
}
