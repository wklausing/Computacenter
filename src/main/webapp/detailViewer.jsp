<%--
  Created by IntelliJ IDEA.
  User: wilkeprivateaccount
  Date: 11.1.2021
  Time: 14.22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="database.DatabaseConnector" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
    <title>Detailansicht</title>
</head>
<body>
<center>
    <h1>Detailansicht</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Vorname</th>
            <th>Nachname</th>
            <th>Email</th>
            <th>Löschen</th>
        </tr>
        <%
            DatabaseConnector db = new DatabaseConnector();
            ArrayList rs = db.executeQuery("SELECT * FROM contact");
            Iterator iteratorContacts = rs.listIterator();
            if (rs == null) {
                out.println("Keine Daten oder keine Verbindug zur Datenbank.");
            } else {
                while (iteratorContacts.hasNext()) {
                    HashMap<String, String> contact = (HashMap<String, String>) iteratorContacts.next();
        %>
        <tr>
            <td><%= contact.get("ID") %>
            </td>
            <td><%= contact.get("firstname") %>
            </td>
            <td><%= contact.get("lastname") %>
            </td>
            <td><%= contact.get("email") %>
            </td>
            <td>
                <form method="get" action="DetailViewer">
                    <button name="delete_id" type="submit" value=<%= contact.get("ID") %>>
                        Löschen
                    </button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
        <tr>
            <td><input placeholder="Eindeutige ID" name="create_new_contact">
            </td>
            <td><input placeholder="Vorname" name="create_new_contact">
            </td>
            <td><input placeholder="Nachname" name="create_new_contact">
            </td>
            <td><input placeholder="Email" name="create_new_contact">
            </td>
            <td>
                <form method="get" action="DetailViewer">
                    <button name="delete_id" type="submit" value="0">
                        Erstellen
                    </button>
                </form>
            </td>
        </tr>
    </table>

    <form action="http://localhost:8080/team_manager/">
        <input type="submit" value="Zurück"/>
    </form>


</center>
</body>
</html>
