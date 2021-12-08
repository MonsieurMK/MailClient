package MailClient.Model;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3ff3ab1a-5afc-457e-82ae-fc7b1d29226a")
public class CurrentUser extends User {
    @objid ("f065c36e-2fdf-4673-8a74-0f4e2a772326")
    private List<Mail> sentMails = new ArrayList<Mail> ();

    @objid ("5227d654-163a-4353-a802-0bec92b96b7c")
    private List<User> contacts = new ArrayList<User> ();

    @objid ("00d0cb6a-512b-454e-9376-e737102354a6")
    private ReceiveProtocol protocol;

    @objid ("0b95b59a-3bad-4814-9e03-bf9b38da7a45")
    private List<Category> categories = new ArrayList<Category> ();

    @objid ("00aa4de4-9974-4756-98e1-db2744cd06c3")
    private SMTP sendProtocol;

    @objid ("475b2a5c-0e2c-4891-979d-4543f72251a0")
    public CurrentUser(String mailAddress, String name, ReceiveProtocol protocol) {
        super(mailAddress, name);
        this.protocol = protocol;
    }

    @objid ("55595dbc-2009-43a9-ab0e-f6ed35baebba")
    public void addCategory(Category category) {
    }

    @objid ("ff4f593b-88bc-4549-89ec-f0ac4fb188d5")
    public void addMailToCategory(Mail mail, Category category) {
    }

    @objid ("b21c9bf2-83cd-4a71-a068-81f1ad02d007")
    public void send(Mail mail, List<User> recipients) {
    }

    @objid ("f3084ab6-bfe4-4857-ac45-af91a7e5ef50")
    public void receive() {
    }

    @objid ("f6d21c89-d75a-4217-a4eb-ceccbba8b750")
    public void addContact(User contact) {
    }

    @objid ("103ba558-9a02-4b33-bd12-5882f7775a41")
    public void removeContact(User contact) {
    }

    @objid ("aec4a58e-7054-48a2-9c98-bbddb8e1248f")
    public List<Mail> find(String query) {
        return null;
    }

}
