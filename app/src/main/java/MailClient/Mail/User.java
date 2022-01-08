package MailClient.Mail;


import javax.mail.Address;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String mailAddress;

    private String name;

    public User(String mailAddress, String name) {
        this.mailAddress = mailAddress;
        this.name = name;
    }

    public User(String mailAddress) {
        this.mailAddress = mailAddress;
        this.name = mailAddress;
    }

    public String getMailAddress() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.mailAddress;
    }

    public String getName() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.name;
    }

    public void setName(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.name = value;
    }

    public static List<User> userFromAdress(List<Address> addresses) {
        ArrayList<User> users = new ArrayList<>();
        for (Address address :
                addresses) {
            users.add(new User(address.toString()));
        }
        return users;
    }

}
