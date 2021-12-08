package View;

import javax.swing.*;
import java.awt.*;

public class MailListPanel extends JPanel {

    private UpperMailPanel upperMailPanel;
    private MailCardPanel mailCardPanel;

    public MailListPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.RED));

        this.setLayout(new BorderLayout());

        this.upperMailPanel = new UpperMailPanel();
        this.add(this.upperMailPanel, BorderLayout.NORTH);

        this.mailCardPanel = new MailCardPanel();
        this.add(this.mailCardPanel, BorderLayout.CENTER);
    }
}
