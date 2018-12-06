package main.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Writer {

    public void insertIntoTable(String sql) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/db/chatbotte.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
