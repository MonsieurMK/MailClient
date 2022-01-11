package MailClient.Model;

import org.junit.After;
import org.junit.Before;

@SuppressWarnings("RedundantThrows")
public class DatabaseManagerTest {

    @Before
    public void setUp() throws Exception {
        // TODO
        DatabaseManager.connect();
        DatabaseManager.createTables();
    }

    @After
    public void tearDown() throws Exception {
        DatabaseManager.flushTableData();
        // TODO
    }
}