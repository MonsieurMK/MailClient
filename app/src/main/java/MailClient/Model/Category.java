package MailClient.Model;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("ff670199-b02d-4523-82f1-91c7b347c935")
public class Category {
    @objid ("5c993b02-2b31-4898-9a6d-3e922b7fa9ef")
    private String name;

    @objid ("51a57ba7-6903-415a-b5a3-6264eb68534a")
    private List<Mail> receivedMails = new ArrayList<Mail> ();

    @objid ("9190f769-bde5-484a-b02c-d4beb913b573")
    public Category(String name) {
    }

    @objid ("40dc39c1-f914-489b-b626-e8e342e7d298")
    public void addMail(Mail mail) {
    }

    @objid ("a8902dab-1b20-47cf-af5e-89a743e21911")
    public void removeMail(Mail mail) {
    }

    @objid ("11e5d424-0562-46f3-a287-efbc56f872e0")
    public void getMails() {
    }

}
