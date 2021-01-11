<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="DetailViewerServlet" %>
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
    </tr>
    <%
            }
        } catch (Exception e) {
            out.println(e);
        }
    %>
</table>

    <form method="get" action="DetailViewer">
        <button name="contact_id" type="submit">Detailansicht</button>
    </form>

</center>
</body>
</html>