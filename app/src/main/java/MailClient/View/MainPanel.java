package MailClient.View;

import MailClient.Controller.MainController;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private MainController mc;

    private SidePanel sidePanel;
    private CenterPanel centerPanel;

    public MainPanel(MainController mc) {
        this.mc = mc;

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.sidePanel = new SidePanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(this.sidePanel, gbc);

        this.centerPanel = new CenterPanel(this);
        gbc.gridx = 1;
        gbc.weightx = 3.0;
        this.add(this.centerPanel, gbc);
    }

    public MainController getMc() {
        return mc;
    }
}
