<%--
  Created by IntelliJ IDEA.
  User: xu879
  Date: 2019/10/18
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    验证码：<input type="text" name="checkCode"><br>
    <img id="checkCode" src="${pageContext.request.contextPath}/checkCode1"><br>
    <input type="submit" value="登录">
</form>

<div><%=request.getAttribute("error")%></div>
<div><%=request.getAttribute("ccerror")%></div>
<script>
    window.onload = function() {
        document.getElementById("checkCode").onclick = function() {
            this.src = "/jsp/checkCode1?t=" + new Date().getTime();
        }
    }
</script>
</body>
</html>
