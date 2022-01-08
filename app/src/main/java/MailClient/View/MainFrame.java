package MailClient.View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(MainPanel pan) throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(pan);
        this.pack();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
