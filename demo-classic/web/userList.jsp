<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
                </div>
                <div class="form-group">
                    <label for="birthplace">籍贯</label>
                    <input type="text" class="form-control" id="birthplace" name="birthplace" placeholder="请输入籍贯">
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>
        </div>
        <div class="th-action fright">
            <button type="button" class="btn btn-primary">添加联系人</button>
            <button type="button" class="btn btn-primary">删除联系人</button>
        </div>
    </div>
    <div class="t-body">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>qq</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td></td>
                <td>1</td>
                <td>张三</td>
                <td>男</td>
                <td>39</td>
                <td>山东</td>
                <td>147258369</td>
                <td>147258369@qq.com</td>
                <td>
                    <button type="button" class="btn btn-default btn-sm">修改</button>
                    <button type="button" class="btn btn-default btn-sm">删除</button>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>1</td>
                <td>张三</td>
                <td>男</td>
                <td>39</td>
                <td>山东</td>
                <td>147258369</td>
                <td>147258369@qq.com</td>
                <td>
                    <button type="button" class="btn btn-sm">修改</button>
                    <button type="button" class="btn btn-sm">删除</button>
                </td>
            </tr>
            </tbody>

        </table>
    </div>
    <div class="t-footer">
        <div class="tf-left fleft">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="tf-right fleft">共16条记录，共4页</div>
    </div>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
