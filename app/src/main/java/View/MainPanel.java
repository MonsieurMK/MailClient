package View;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private SidePanel sidePanel;
    private CenterPanel centerPanel;

    public MainPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.sidePanel = new SidePanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(this.sidePanel, gbc);

        this.centerPanel = new CenterPanel();
        gbc.gridx = 1;
        gbc.weightx = 3.0;
        this.add(this.centerPanel, gbc);
    }
}
