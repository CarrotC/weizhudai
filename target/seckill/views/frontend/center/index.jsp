<%--
  Created by IntelliJ IDEA.
  User: coldilock
  Date: 2018/9/5
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <a href="/frontend/center/index">首页</a>
    |
    <a href="/frontend/center/industryCategory?index=0">行业分类</a>
    |
    <a href="/frontend/center/aboutUs">关于我们</a>
    |
    <a href="/frontend/logout">退出登录</a>
    <br>
    <br><br>
    <br>
    <input type="text" placeholder="企业名称">&nbsp&nbsp&nbsp<button onclick="window.location.href='/frontend/enterpriseInfo/index'">搜索</button>
</center>
</body>
</html>
