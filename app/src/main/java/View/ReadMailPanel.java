package View;

import javax.swing.*;
import java.awt.*;

public class ReadMailPanel extends JPanel {

    private MailTextPanel mailTextPanel;
    private MailAttachmentPanel mailAttachmentPanel;

    public ReadMailPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.RED));

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.mailTextPanel = new MailTextPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 3.0;
        gbc.weighty = 1.0;
        this.add(this.mailTextPanel, gbc);

        this.mailAttachmentPanel = new MailAttachmentPanel();
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        this.add(this.mailAttachmentPanel, gbc);
    }
}
