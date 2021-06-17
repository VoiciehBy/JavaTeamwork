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
    login: <input type="text" name="loginTxt">
    hasło: <input type="password" name="passTxt">
    <input type="submit" value="wpisz się">
</form>
<%
   HttpSession s = request.getSession(false);
  if(s.getAttribute("username") != null)
    request.getRequestDispatcher ("DBDataShow.jsp").forward(request,response);
%>
<p style="color:red">${error}</p>
</body>
</html>
