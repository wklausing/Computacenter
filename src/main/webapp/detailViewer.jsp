<%--
  Created by IntelliJ IDEA.
  User: wilkeprivateaccount
  Date: 11.1.2021
  Time: 14.22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="database.DatabaseConnector" %>
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
            <td>
<%--                <button type="button">Löschen</button>--%>
                <form method="get" action="DetailViewer">
                    <button name="contact_id" type="submit">
                        Löschen
                    </button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <button type="button" name="back" onclick="history.back()">Zurück</button>

</center>
</body>
</html>
