package MailClient.Model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("14c7fe47-8eca-4feb-b63d-e15d00a2f171")
public class User {
    @objid ("ed36fea9-ead2-44d7-84a4-05b702b062ef")
    private String mailAddress;

    @objid ("af011f77-4ccf-4880-a93a-5755853a2109")
    private String name;

    @objid ("b69baf17-fb88-481f-ae59-43bfc04ff89e")
    public User(String mailAddress, String name) {
    }

    @objid ("84b690ea-f94f-4660-9c99-0912acc7491c")
    public String getMailAddress() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.mailAddress;
    }

    @objid ("998e3002-4c2b-484e-81fe-69fe333b7448")
    public String getName() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.name;
    }

    @objid ("0dd11e40-7cba-45e4-834f-99f3ddbb7a2f")
    public void setName(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.name = value;
    }

}
