<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>首页</title>
    <%-- normalize.css--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div class="container">
    <h3 class="t-title">用户信息列表</h3>
    <div class="t-header">
        <div class="th-condition fleft">
            <form class="form-inline"
                  action="${pageContext.request.contextPath}/findPage?currentPage=${pageBean.currentPage}&rows=5"
                  method="get"
            >
                <div class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" class="form-control" id="name" name="username" value="${condition.username[0]}"
                           placeholder="请输入姓名">
                </div>
                <div class="form-group">
                    <label for="birthplace">密码</label>
                    <input type="text" class="form-control" id="birthplace" name="password"
                           value="${condition.password[0]}">
                </div>
                <div class="form-group">
                    <label for="address">地址</label>
                    <input type="text" class="form-control" id="address" name="address" value="${condition.address[0]}">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>
        </div>
        <div class="th-action fright">
            <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/addUser.jsp">添加联系人</a>
            <button type="button" class="btn btn-primary" id="btn-del">删除选中</button>
        </div>
    </div>
    <div class="t-body">
        <form id="fm-selected" action="${pageContext.request.contextPath}/delSelected" method="post">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th><input id="ipt-select" type="checkbox"></th>
                    <th>编号</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>生日</th>
                    <th>性别</th>
                    <th>地址</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageBean.list}" var="user">
                    <tr>
                        <td><input type="checkbox" name="ids" value="${user.id}"></td>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.birthStr}</td>
                        <td>
                            <c:if test="${user.gender == '1'}">
                                男
                            </c:if>
                            <c:if test="${user.gender == '0'}">
                                女
                            </c:if>
                        </td>
                        <td>${user.address}</td>
                        <td>
                            <a role="button" class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/findUser?id=${user.id}">修改</a>
                            <a role="button" class="btn btn-default btn-sm" href="javascript:delUser(${user.id})">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
    <div class="t-footer">
        <div class="tf-left fleft">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <c:if test="${pageBean.currentPage == 1}">
                            <a href="${pageContext.request.contextPath}/findPage?currentPage=1&rows=5&username=${condition.username[0]}&password=${condition.password[0]}&address=${condition.address[0]}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </c:if>
                        <c:if test="${pageBean.currentPage > 1}">
                            <a href="${pageContext.request.contextPath}/findPage?currentPage=${pageBean.currentPage - 1}&rows=5&username=${condition.username[0]}&password=${condition.password[0]}&address=${condition.address[0]}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </c:if>
                    </li>
                    <c:forEach begin="1" end="${pageBean.totalPage}" step="1" var="i">
                        <c:if test="${pageBean.currentPage == i}">
                            <li class="active">
                                <a href="${pageContext.request.contextPath}/findPage?currentPage=${i}&rows=5&username=${condition.username[0]}&password=${condition.password[0]}&address=${condition.address[0]}">${i}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageBean.currentPage != i}">
                            <li>
                                <a href="${pageContext.request.contextPath}/findPage?currentPage=${i}&rows=5&username=${condition.username[0]}&password=${condition.password[0]}&address=${condition.address[0]}">${i}</a>
                            </li>
                        </c:if>

                    </c:forEach>
                    <li>
                        <c:if test="${pageBean.currentPage == pageBean.totalPage}">
                            <a href="${pageContext.request.contextPath}/findPage?currentPage=${pageBean.currentPage}&rows=5&username=${condition.username[0]}&password=${condition.password[0]}&address=${condition.address[0]}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </c:if>
                        <c:if test="${pageBean.currentPage < pageBean.totalPage}">
                            <a href="${pageContext.request.contextPath}/findPage?currentPage=${pageBean.currentPage + 1}&rows=5&username=${condition.username[0]}&password=${condition.password[0]}&address=${condition.address[0]}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </c:if>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="tf-right fleft">共${pageBean.totalCount}条记录，共${pageBean.totalPage}页</div>
    </div>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script>
    window.onload = function () {
        document.getElementById("btn-del").onclick = function () {
            if (confirm("确定要删除选中的记录吗？")) {
                document.getElementById("fm-selected").submit();
            }
        };

        document.getElementById("ipt-select").onclick = function () {
            var cbs = document.getElementsByName("ids");
            for (var i = 0; i < cbs.length; i++) {
                cbs[i].checked = this.checked;
            }
        }
    };

    function delUser(id) {
        if (confirm("您确定要删除该条记录码？")) {
            location.href = "${pageContext.request.contextPath}/delUser?id=" + id;
        }
    }
</script>
</body>
</html>
