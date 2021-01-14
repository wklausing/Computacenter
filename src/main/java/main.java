import database.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class main {

    public static void main(String[] args) {
        DatabaseConnector db = new DatabaseConnector();
        db.testMethod("main");
    }

    public void testDB() {
        DatabaseConnector db = new DatabaseConnector();

        String sql = "SELECT * FROM contact";
        ArrayList result = db.executeQuery(sql);


        ListIterator li = result.listIterator();
        for(int i = 0; li.hasNext(); i++) {
            HashMap<String, String> hs = (HashMap<String, String>) li.next();
            System.out.println(hs.get("ID") + " " + hs.get("firstname") + " " + hs.get("lastname") + " " + hs.get("email"));
        }

        sql = "INSERT INTO `contact` (`ID`, `firstname`, `lastname`, `email`) VALUES ('3', 'Peter', 'Thiele', 'pe.th@gmail.com')";
        db.executeUpdate(sql);

        sql = "DELETE FROM contact WHERE ID = 3";
        db.executeUpdate(sql);
    }
}
