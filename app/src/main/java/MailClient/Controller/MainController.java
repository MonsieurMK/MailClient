package MailClient.Controller;

import MailClient.Mail.Mail;
import MailClient.Model.CurrentUser;
import MailClient.Model.MailManager;
import MailClient.Model.ReceiveProtocol;
import MailClient.Model.UserManager;
import MailClient.View.MainFrame;
import MailClient.View.MainPanel;

import java.util.List;

public class MainController {

    @SuppressWarnings("FieldCanBeLocal")
    private final CurrentUser currentUser;
    private final UserManager userManager;

    private final ReceiveProtocol receiveProtocol;

    @SuppressWarnings("FieldCanBeLocal")
    private final MainPanel mainPanel;


    public MainController(String address, String name, String host, String password, ReceiveProtocol receiveProtocol) {
        //this.currentUser = new CurrentUser("mailclienttestjava@gmail.com", "test", "pop.gmail.com", "azertyui1.", new POP());
        this.currentUser = new CurrentUser(address, name, host, password);
        this.userManager = new UserManager(currentUser);

        this.receiveProtocol = receiveProtocol;

        this.mainPanel = new MainPanel(this);
        new MainFrame(this.mainPanel);
    }

    public List<Mail> receive() {
        return this.userManager.receive(this.receiveProtocol);
    }
}
