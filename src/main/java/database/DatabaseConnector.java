package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseConnector {

    /**
     *
     * @param sql
     * @return
     */
    public ArrayList executeQuery(String sql) {
        ArrayList result = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/computacenter","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            result = rsToArrayList(rs);
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }

    /**
     *
     * @param sql
     * @return true if sql was successful and false if not.
     */
    public boolean executeUpdate(String sql) {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/computacenter", "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     *
     * @param rs is result of executed sql querie.
     * @return ResultSet as List
     */
    private ArrayList rsToArrayList(ResultSet rs) throws SQLException{
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList list = new ArrayList(50);
        while (rs.next()){
            HashMap row = new HashMap(columns);
            for(int i=1; i<=columns; ++i){
                row.put(md.getColumnName(i),rs.getObject(i));
            }
            list.add(row);
        }
        return list;
    }

    /**
     * For me only to test if method got executed. TODO Delete this.
     * @param executedFrom
     * @return
     */
    public boolean testMethod (String executedFrom) {
        String sql = "INSERT INTO `contact` (`ID`, `firstname`, `lastname`, `email`) VALUES ('" + executedFrom + "', 'testMethodFirstname', 'testMethodLastname', 'testMethod.th@gmail.com')";
        return executeUpdate(sql);
    }

    public boolean testMethod2 (String executedFrom, String req) {
        String sql = "INSERT INTO `contact` (`ID`, `firstname`, `lastname`, `email`) VALUES ('" + executedFrom + "', '" + req + "', 'testMethodLastname', 'testMethod.th@gmail.com')";
        return executeUpdate(sql);
    }

    public boolean testMethod3 (String executedFrom, String[] req) {
        String sql = null;
        if (req == null) {
            sql = "INSERT INTO `contact` (`ID`, `firstname`, `lastname`, `email`) VALUES ('" + executedFrom + "', '" + req + "', 'testMethodLastname', 'testMethod.th@gmail.com')";
        } else {
            sql = "INSERT INTO `contact` (`ID`, `firstname`, `lastname`, `email`) VALUES ('" + executedFrom + "', '" + req[0] + "', 'testMethodLastname', 'testMethod.th@gmail.com')";
        }
        return executeUpdate(sql);

    }
}
