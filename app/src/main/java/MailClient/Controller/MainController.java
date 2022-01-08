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

    public MainController(String address, String name, String host, String password) {
        //this.currentUser = new CurrentUser("mailclienttestjava@gmail.com", "test", "pop.gmail.com", "azertyui1.", new POP());
        this.currentUser = new CurrentUser(address, name, host, password, new POP());
        this.userManager = new UserManager(currentUser);

        this.mainPanel = new MainPanel(this);
        new MainFrame(this.mainPanel);
    }

    public List<Mail> receive() {
        return this.userManager.receive();
    }
}
