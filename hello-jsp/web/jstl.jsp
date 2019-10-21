<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>

<%
    ArrayList<String> list = new ArrayList<>();
    list.add("111");
    list.add("222");
    request.setAttribute("list", list);
%>

<h3>c:if</h3>

<c:if test="${not empty list}">
    列表不为空。
</c:if>
<c:if test="${empty list}">
    列表为空。
</c:if>

<h3>c:choose</h3>
<%
    request.setAttribute("n", 3);
%>
<c:choose>
    <c:when test="${n == 0}">等于零</c:when>
    <c:when test="${n > 0}">大于零</c:when>
    <c:otherwise>小于零</c:otherwise>
</c:choose>

<h3>c:forEach</h3>
<c:forEach begin="1" end="10" step="1" var="i">
    ${i}-
</c:forEach><br>

<c:forEach begin="1" end="10" step="2" var="i" varStatus="vs">
    ${vs.count}-${i}-${vs.index}<br>
</c:forEach>

<c:forEach items="${list}" var="item">
    ${item}-
</c:forEach>
</body>
</html>
