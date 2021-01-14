<%@ page import="database.DatabaseConnector" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.HashMap" %>
<%--TODO If table gets too big, split into several sites.--%>
<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Kontakte
    </h1>

    <table>
        <tr>
            <th>ID</th>
            <th>Vorname</th>
            <th>Nachname</th>
            <th>Email</th>
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
        </tr>
        <%
                }
            }
        %>
    </table>
    <form method="get" action="DetailViewer">
        <button type="submit">Detailansicht</button>
    </form>
</center>
</body>
</html>