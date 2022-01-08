package MailClient.View;

import MailClient.Mail.Mail;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JSplitPane {

    private MainPanel parentPane;

    private MailListPanel mailListPanel;
    private ReadMailPanel readMailPanel;

    public CenterPanel(MainPanel parentPane) {
        this.parentPane = parentPane;

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.setOrientation(JSplitPane.VERTICAL_SPLIT);

        this.mailListPanel = new MailListPanel(this);
        this.setTopComponent(this.mailListPanel);

        this.readMailPanel = new ReadMailPanel();
        this.setBottomComponent(this.readMailPanel);

        this.setResizeWeight(0.5);
    }

    public ReadMailPanel getReadMailPanel() {
        return readMailPanel;
    }

    public MainPanel getParentPane() {
        return parentPane;
    }
}
