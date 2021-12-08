package MailClient.Model;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a3f03cc9-9967-4bac-8631-29a62fe1ffbc")
public class UserManager {
    @objid ("f08b5c39-9ee6-49a3-8d30-3995b77d9e4c")
    private List<User> users = new ArrayList<User> ();

    @objid ("24e5d6db-6f89-45c4-b295-0888463d93fb")
    private DatabaseManager databaseManager;

    @objid ("4e715b9c-c142-4490-979b-7c3aaa8bfb60")
    private CurrentUser currentUser;

    @objid ("6a259fda-ccd6-4821-9585-445212bbbbbe")
    public void send(String subject, String content, List<Attachment> attachements, List<User> recipients) {
    }

    @objid ("df8d7875-e82c-4c58-8b72-98564765a3f7")
    public void receive() {
    }

    @objid ("7c542f93-7c71-445e-8f8f-93ba388692f4")
    public List<Mail> find(String query) {
        return null;
    }

}
