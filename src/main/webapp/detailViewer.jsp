<%--
  Created by IntelliJ IDEA.
  User: wilkeprivateaccount
  Date: 11.1.2021
  Time: 14.22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
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
            String id = request.getParameter("contact_id");
            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/computacenter", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from contact");
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
            <td> <button type="button">Löschen</button>
            </td>
        </tr>
        <%
                }
            } catch (Exception e) {
                out.println(e);
            }
        %>
    </table>

    <button type="button" name="back" onclick="history.back()">Zurück</button>

</center>
</body>
</html>
