package MailClient.Mail;


import java.io.File;

public class Attachment {

    private final String name;
    private final int size;
    private final File file;

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public File getFile() {
        return file;
    }

    public Attachment(String name, int size, File filePath) {
        this.name = name;
        this.size = size;
        this.file = filePath;
    }
}
