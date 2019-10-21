<%@ page import="com.example.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(20);
    user.setBirthday(new Date());
    request.setAttribute("u", user);

    ArrayList list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(user);
    request.setAttribute("list", list);

    HashMap<String, String> map = new HashMap<>();
    map.put("year", "2019");
    map.put("month", "10");
    request.setAttribute("map", map);
%>

<h3>EL表达式获取对象</h3>
${u.name}<br>
${u.birthday}<br>
${u.birStr}<br>

<h3>EL表达式获取list</h3>
${list[0]}<br>
${list[2]}<br>
${list[2].name}<br>

<h3>EL表达式获取map</h3>
${map.year}<br>
${map["month"]}<br>
</body>
</html>
