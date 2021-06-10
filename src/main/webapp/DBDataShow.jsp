<%@ page import="java.util.ArrayList" %>
<%@ page import="dbclass.Employee" %>
<%@ page import="servlets.DBDataShow" %>
<%--
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
    ArrayList<Employee> list;
    list = DBDataShow.getDataFromDB();
%>
<table border="1">

    <tr>
        <td>Id</td>
        <td>Imię</td>
        <td>Drugie Imię</td>
        <td>Nazwisko</td>
        <td>Data Urodzenia</td>
    </tr>
    <tcap>
        <align middle>Osoby:</align>
    </tcap>
    <%for (Employee employee : list) {%>
    <tr>
        <td>
            <%=employee.getId()%>
        </td>
        <td>
            <%=employee.getFirstName()%>
        </td>
        <td>
            <%=employee.getSecondName()%>
        </td>
        <td>
            <%=employee.getSurname()%>
        </td>
        <td>
            <%=employee.getBirthDate()%>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
