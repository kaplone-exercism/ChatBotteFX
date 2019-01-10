package DAO;

import java.sql.*;

public class Reader {

    public <T> T getElement(String clause, Mapper<T> mapper) {

        Connection c = null;
        Statement stmt = null;
        T element = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:db/chatbotte.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery(" SELECT * FROM " + mapper.getTable() + " WHERE " + clause + ";");
            element = mapper.mapping(rs);

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return element;
    }

}
