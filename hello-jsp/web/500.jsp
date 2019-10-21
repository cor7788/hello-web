<%--
  Created by IntelliJ IDEA.
  User: xu879
  Date: 2019/10/19
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>errorPage</title>
</head>
<body>
<%
    String message = exception.getMessage();
    out.print(message);
%>
</body>
</html>
