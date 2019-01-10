package DAO;

import java.sql.*;

public class Check {

    public static void testIfInitialized(){

        Table.checkAllTables();
    }

    public static Boolean isTablePresente(String tableToCheck){
        Connection c = null;
        Statement stmt = null;
        String result = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:db/chatbotte.db");

            stmt = c.createStatement();
            String sql = String.format("SELECT * FROM sqlite_master WHERE type='table' AND name='%s'", tableToCheck);
            //System.out.println(sql);
            resultSet = stmt.executeQuery(sql);
            result = resultSet.getString("name");
            stmt.close();
            c.close();


        } catch (SQLException e) {
            //e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tableToCheck.equals(result);
    }
}
