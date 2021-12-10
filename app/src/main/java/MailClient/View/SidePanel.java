package MailClient.View;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {

    private MailBoxPanel mailBoxes;
    private OptionPanel optionPanel;

    public SidePanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.mailBoxes = new MailBoxPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 3.0;
        this.add(this.mailBoxes, gbc);

        this.optionPanel = new OptionPanel();
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        this.add(this.optionPanel, gbc);
    }
}
