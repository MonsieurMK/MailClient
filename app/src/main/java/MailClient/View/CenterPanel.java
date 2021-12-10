package MailClient.View;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JSplitPane {

    private MailListPanel mailListPanel;
    private ReadMailPanel readMailPanel;

    public CenterPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.setOrientation(JSplitPane.VERTICAL_SPLIT);

        this.mailListPanel = new MailListPanel();
        this.setTopComponent(this.mailListPanel);

        this.readMailPanel = new ReadMailPanel();
        this.setBottomComponent(this.readMailPanel);

        this.setResizeWeight(0.5);
    }
}
