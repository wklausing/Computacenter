<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="database.DatabaseConnector" %>
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
            ResultSet rs = db.getContacts();
            if (rs == null) {
                out.println("Keine Daten oder keine Verbindug zur Db.");
            } else {
                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString(1) %>
            </td>
            <td><%= rs.getString(2) %>
            </td>
            <td><%= rs.getString(3) %>
            </td>
            <td><%= rs.getString(4) %>
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