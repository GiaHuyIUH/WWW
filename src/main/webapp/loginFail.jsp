<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/24/2024
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fail</title>
</head>
<body>
<%
    String status = request.getParameter("status");

    if ("1".equals(status)) {
        out.println("<h1>Wrong Password</h1>");
    } else if ("2".equals(status)) {
        out.println("<h1>User Not Found</h1>");
    }
%>
<a href="index.html">Back</a>
</body>
</html>
