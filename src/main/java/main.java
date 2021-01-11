import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.sql.*;

public class main {

    public static void main(String[] args) {

//        Map test = new HashMap();
//        test = getAllContacts();
//        printMap(test);

        if(connectToDB()) {
            System.out.println("DB works!");
        }
    }


    private static Map getAllContacts () {
        HashMap<String, Contact> contacts = new HashMap <String, Contact>();

        //TODO Just for testing
        for (int i = 1; i <= 3; i++) {
            String id = String.valueOf(i);
            Contact contact = new Contact(id);
            contacts.put(id, contact);
        }
        return contacts;
    }

    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Contact contact = (Contact) pair.getValue();
            System.out.println(contact.getFirstname() + " " + contact.getLastname() + " " + contact.getEmail() );
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    public static boolean connectToDB() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/computacenter","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from contact");
            while(rs.next()) {
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            }

            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
}
