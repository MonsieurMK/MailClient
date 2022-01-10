package MailClient.View;

import MailClient.Mail.Mail;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class MailCardPanel extends JScrollPane {

    private final MailListPanel parentPane;

    private final JList<Mail> mailList;
    private final DefaultListModel<Mail> mails;

    public MailCardPanel(MailListPanel parentPane) {
        this.parentPane = parentPane;

        this.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        this.mails = new DefaultListModel<>();
        //this.mails.addElement(new Mail("Subject", new ArrayList<>(), new ArrayList<>(), new Date(), "Content")); // test
        this.mailList = new JList<>(this.mails);
        this.mailList.setLayoutOrientation(JList.VERTICAL);
        this.mailList.setFont(new Font("Arial", Font.PLAIN, 15));
        this.mailList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.setViewportView(this.mailList);

        this.mailList.setCellRenderer(new MailCellRenderer());
        //noinspection Convert2Lambda
        this.mailList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    MailCardPanel.this.parentPane.getParentPane().getReadMailPanel().showMail(MailCardPanel.this.mailList.getSelectedValue());
                }
            }
        });
    }

    static class MailCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Mail) {
                // need to show sender in mail list display
                this.setText("Subject : " + ((Mail) value).getMailSubject());
                this.setToolTipText("Sent on " + ((Mail) value).getSentDate());
            }
            return this;
        }
    }

    public void clearMail() {
        this.mails.clear();
    }

    public void addMail(Mail mail) {
        this.mails.addElement(mail);
    }
}
