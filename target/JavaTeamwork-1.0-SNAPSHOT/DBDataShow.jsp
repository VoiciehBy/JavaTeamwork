<%@ page import="java.util.ArrayList" %>
<%@ page import="dbclass.Employee" %>
<%@ page import="servlets.DBDataShow" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: voiciehb
  Date: 10.06.2021
  Time: 00:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tabela Osób</title>
</head>
<body>
<%
    ArrayList<Employee> list = new ArrayList<>();
    list = DBDataShow.getDataFromDB();
%>
<table border="1">
    <tcap>
        <align middle>Osoby:</align>
    </tcap>
    <%for (int i = 0; i < list.size(); i++) {%>
    <tr>
        <td>
            <%=list.get(i).getId()%>
        </td>
        <td>
            <%=list.get(i).getFirstName()%>
        </td>
        <td>
            <%=list.get(i).getSecondName()%>
        </td>
        <td>
            <%=list.get(i).getSurname()%>
        </td>
        <td>
            <%=list.get(i).getBirthDate()%>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
