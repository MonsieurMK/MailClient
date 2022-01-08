package MailClient.Controller;

import MailClient.Mail.Mail;
import MailClient.Model.CurrentUser;
import MailClient.Model.POP;
import MailClient.Model.UserManager;
import MailClient.View.MainFrame;
import MailClient.View.MainPanel;

import java.util.List;

public class MainController {

    private CurrentUser currentUser;
    private UserManager userManager;

    private MainPanel mainPanel;

    public MainController() {
        this.currentUser = new CurrentUser("mailclienttestjava@gmail.com", "test", "pop.gmail.com", "azertyui1.", new POP());
        this.userManager = new UserManager(currentUser);

        this.mainPanel = new MainPanel(this);
        new MainFrame(this.mainPanel);
    }

    public List<Mail> receive() {
        return this.userManager.receive();
    }
}
