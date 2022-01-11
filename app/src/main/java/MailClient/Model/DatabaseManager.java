package MailClient.Model;


import MailClient.Mail.User;
import net.harawata.appdirs.AppDirs;
import net.harawata.appdirs.AppDirsFactory;

import javax.xml.crypto.Data;
import java.io.File;
import java.sql.*;

@SuppressWarnings({"UnusedReturnValue", "SqlDialectInspection"})
public final class DatabaseManager {
    private static Connection conn;

    private DatabaseManager() {}

    public static boolean connect() {
        // opening/creating local user folder
        AppDirs appDirs = AppDirsFactory.getInstance();
        String datafolder = appDirs.getUserDataDir("MailClient", "1.0", "MonsieurSinge");
        //noinspection ResultOfMethodCallIgnored
        (new File(datafolder)).mkdirs();

        String url = "jdbc:sqlite:" + datafolder + File.separator + "database.db";

        try {
            DatabaseManager.conn = DriverManager.getConnection(url);
            //noinspection RedundantIfStatement
            if (conn != null) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean createTables() {
        String reqUser = """
                CREATE TABLE IF NOT EXISTS user(
                   mail_address VARCHAR(50),
                   name VARCHAR(50),
                   PRIMARY KEY(mail_address)
                );""";

        String reqFolder = """
                CREATE TABLE IF NOT EXISTS folder(
                   name VARCHAR(50),
                   full_name VARCHAR(50),
                   PRIMARY KEY(name)
                );""";

        String reqMail = """
                CREATE TABLE IF NOT EXISTS mail(
                   mail_id COUNTER,
                   subject VARCHAR(50),
                   text TEXT,
                   name VARCHAR(50) NOT NULL,   sent_date DATETIME,
                   PRIMARY KEY(mail_id),
                   FOREIGN KEY(name) REFERENCES folder(name)
                );""";

        String reqAttachment = """
                CREATE TABLE IF NOT EXISTS attachment(
                   attachment_path VARCHAR(50),
                   mail_id INT NOT NULL,
                   PRIMARY KEY(attachment_path),
                   FOREIGN KEY(mail_id) REFERENCES mail(mail_id)
                );""";

        String reqSenders = """
                CREATE TABLE IF NOT EXISTS senders(
                   mail_id INT,
                   mail_address VARCHAR(50),
                   PRIMARY KEY(mail_id, mail_address),
                   FOREIGN KEY(mail_id) REFERENCES mail(mail_id),
                   FOREIGN KEY(mail_address) REFERENCES user(mail_address)
                );""";

        String reqRecipients = """
                CREATE TABLE IF NOT EXISTS recipients(
                   mail_id INT,
                   mail_address VARCHAR(50),
                   PRIMARY KEY(mail_id, mail_address),
                   FOREIGN KEY(mail_id) REFERENCES mail(mail_id),
                   FOREIGN KEY(mail_address) REFERENCES user(mail_address)
                );""";

        String[] reqs = {reqUser, reqFolder, reqMail, reqAttachment, reqSenders, reqRecipients};

        try {
            Statement stmt = DatabaseManager.conn.createStatement();
            for (String req :
                    reqs) {
                stmt.execute(req);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean flushTableData() {
        String[] reqs = {"DELETE FROM user;",
                "DELETE FROM folder;",
                "DELETE FROM mail;",
                "DELETE FROM attachment;",
                "DELETE FROM senders;",
                "DELETE FROM recipients;"
        };

        try {
            Statement stmt = DatabaseManager.conn.createStatement();
            for (String req :
                    reqs) {
                stmt.execute(req);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean addUser(User user) {
        String req = "INSERT INTO user (mail_address, name)" +
                "VALUES(?, ?);";
        try {
            PreparedStatement pstmt = DatabaseManager.conn.prepareStatement(req);
            pstmt.setString(1, user.getMailAddress());
            pstmt.setString(2, user.getName());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean addFolder() {
        // TODO change category to folder class (and implement it)
        return true;
    }
}
