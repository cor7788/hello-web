<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>demo</title>
</head>
<body>
<h3>test demo filter</h3>
<form action="${pageContext.request.contextPath}/demo" method="post">
    <label for="username">用户名</label>
    <input type="text" id="username" name="username"><br>
    <label for="text">介绍</label>
    <input type="text" id="text" name="text"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
