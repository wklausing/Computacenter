package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnector {

    /**
     * Get contacts from database.
     * @return ResultSet rs includes all contacts or NULL.
     */
    public ResultSet getContacts() {
        ResultSet rs = null;
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/computacenter", "root", "");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM contact");

        } catch (Exception e) {
            System.out.println(e);
        }
//        finally {
//        try { rs.close(); } catch (Exception e) { /* ignored */ }
//        try { con.close(); } catch (Exception e) { /* ignored */ }
//    }
        return rs;
    }

    /**
     * Detele contact by ID
     * @param id of contact
     * @return true if deletion was succesful and false if not.
     */
    public void deleteContact (String id) {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/computacenter", "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM contact WHERE ID = 3");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
