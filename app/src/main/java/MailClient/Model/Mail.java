package MailClient.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("08889c4b-bce6-4c0b-b6f2-d50ac204a8f8")
public class Mail {
    @objid ("cb240680-9f25-40a0-9b27-de12f16cc77c")
    private String mailObject;

    @objid ("484e438d-76d2-4ccf-ac66-da714f11f56b")
    private String content;

    @objid ("5c80d3a9-b3d5-463c-a6a8-3c4df5d900be")
    private Date date;

    @objid ("ff466057-5a76-4fa3-8ec7-01325e993e68")
    private List<Attachment> attachements = new ArrayList<Attachment> ();

    @objid ("10b2ba67-a589-4d47-8a82-19d300f8ad95")
    private User sender;

    @objid ("2ba3319e-386e-4852-a1a6-9c71eee3b75a")
    private List<User> recipient = new ArrayList<User> ();

    @objid ("01d895c8-5aea-417e-a15d-2c58549f7124")
    public Mail(String mailObject, String content, User sender, User recipient) {
    }

    @objid ("7c1506e2-9e34-4eb8-a72e-fd1f9bb3a21f")
    public String getMailObject() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.mailObject;
    }

    @objid ("7fdaf35c-3e18-4a00-858d-45d20c7eef67")
    public String getContent() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.content;
    }

    @objid ("41a75e96-7dd8-413b-b3c3-ac022e72f988")
    public Date getDate() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.date;
    }

    @objid ("e15f2765-a10f-44de-9d02-6ee3a7f83d80")
    public void addAttachment(Attachment attachment) {
    }

    @objid ("03e8ea5c-f629-4026-9e60-168e6a0cb882")
    public void addRecipient(User recipient) {
    }

}
