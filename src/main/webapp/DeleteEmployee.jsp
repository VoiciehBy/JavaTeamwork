<%--
  Created by IntelliJ IDEA.
  User: voiciehb
  Date: 19.06.2021
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel Usuwania Pracowników</title>
</head>
<body>
<form action="deleteEmployee" method="post">
    <label for="idTxt">Id:</label>
    <input type="number" placeholder="Podaj id" name="idTxt" id="idTxt"><br>
    <label for="nameTxt">Imię:</label>
    <input type="text" placeholder="Podaj imię" name="nameTxt" id="nameTxt"><br>
    <label for="name2Txt">Drugie Imię:</label>
    <input type="text" placeholder="Podaj drugie imię" name="name2Txt" id="name2Txt"><br>
    <label for="surnameTxt">Nazwisko:</label>
    <input type="text" placeholder="Podaj nazwisko" name="surnameTxt" id="surnameTxt"><br>
    <label for="birthDateTxt">Data Urodzenia:</label>
    <input type="date" placeholder="Podaj datę urodzenia" name="birthDateTxt" id="birthDateTxt"><br>
    <input type="submit"><br>
</form>
<%
    HttpSession s = request.getSession(false);
    if(s.getAttribute("username") != null)
        request.getRequestDispatcher ("DBDataShow.jsp").forward(request,response);
%>
</body>
</html>
