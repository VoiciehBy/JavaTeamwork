<%--
  Created by IntelliJ IDEA.
  User: voiciehb
  Date: 17.06.2021
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>

<form action="login" method="post">
    <label for="loginTxt">Login:</label>
    <input type="text" name="loginTxt" id="loginTxt" placeholder="Podaj login" autocomplete="on" required="required">
    <label for="passTxt">Hasło:</label>
    <input type="password" name="passTxt" id="passTxt" placeholder="Podaj hasło" required="required">
    <input type="submit" value="wpisz się">
</form>
<%
    HttpSession s = request.getSession(false);
    if (s.getAttribute("username") != null)
        request.getRequestDispatcher("DBDataShow.jsp").forward(request, response);
%>
<p style="color:red">${error}</p>
</body>
</html>
