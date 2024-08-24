<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/24/2024
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
   <%
       String username = request.getParameter("us");
       out.println("Welcome to HELL " + username + "!"); %>
</body>
</html>
