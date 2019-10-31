<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <%-- normalize.css--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3 class="text-center">添加用户</h3>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/addUser" method="post">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">用户名：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" placeholder="请输入用户名" name="username">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码：</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
            </div>
        </div>
        <div class="form-group">
            <label for="birthday" class="col-sm-2 control-label">生日：</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="birthday" name="birthday">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">性别：</label>
            <div class="col-sm-10">
                <label class="radio-inline">
                    <input type="radio" name="gender" id="gender_man" value="1"> 男
                </label>
                <label class="radio-inline">
                    <input type="radio" name="gender" id="gender_woman" value="0"> 女
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-sm-2 control-label">地址：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="address" name="address" placeholder="请输入地址">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
                <button type="submit" class="btn btn-default">提交</button>
            </div>
        </div>
    </form>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
