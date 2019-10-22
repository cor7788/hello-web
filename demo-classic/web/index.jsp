<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录页面</title>
    <%-- normalize.css--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="width: 400px;">
    <div class="page-header">
        <h1>登录页面</h1>
    </div>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="username">用户名：</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
        </div>
        <div class="form-inline">
            <label for="checkCode">验证码：</label>
            <input type="text" class="form-control" id="checkCode" name="checkCode">
            <img id="img_checkCode" src="${pageContext.request.contextPath}/checkCode" alt="checkCode">
        </div>
        <hr>
        <div class="form-group">
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </form>

    <c:if test="${not empty requestScope.err}">
        <div class="alert alert-danger" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
                ${requestScope.err}
        </div>
    </c:if>

    <c:if test="false">不会显示</c:if>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script>
    window.onload = function () {
        document.getElementById("img_checkCode").onclick = function () {
            this.setAttribute("src", "${pageContext.request.contextPath}/checkCode?t=" + new Date().getTime());
        }
    }
</script>
</body>
</html>
