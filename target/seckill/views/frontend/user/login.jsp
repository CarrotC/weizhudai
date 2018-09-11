<%--
  Created by IntelliJ IDEA.
  User: coldilock
  Date: 2018/8/29
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl标签库--%>
<%@include file="/views/include/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
    <script src="<spring:url value="/statics/js/jquery-3.3.1.min.js"/>"></script>
    <%--引入css样式文件--%>
    <%--<link type="text/css" rel="stylesheet" href="/statics/style/******.css">--%>
</head>
<body>
<center>
    <div id="bank">
        <h3>银行用户登录入口</h3><br>
        <h4>（不需要输入用户名和密码）</h4>
        用户名:<input type="text" placeholder="weizhudai"><br>密码:<input type="password" placeholder="123456"><br><br>
        <button onclick="login()">登录</button>
        <br>
        <br>
        <br>
        <br>
    </div>

    <%--<div id="company">--%>
        <%--<h3>企业用户登录入口</h3>--%>
        <%--用户名:<input type="text" placeholder="weizhudai"><br>密码:<input type="text" placeholder="123456"><br><br>--%>
        <%--<button onclick="window.location.href = '/frontend/enterpriseInfo/index'">登录</button>--%>
    <%--</div>--%>

</center>
<script>
    function login(){
        var userName = 'lll'
        var passwd = 'xxxx'
        $.ajax({
            url: '/frontend/login',
            data: JSON.stringify({
                userName: userName,
                passwd: passwd
            }),
            contentType: 'application/json',
            dataType: 'json',
            method: 'post',
            async: false,
            success: function (res) {
                if (res.status === 200) {
                    window.location.href = '/frontend/center/index';
                    alert("登录成功");
                } else {
                    //window.location.href = '/';
                    alert("密码错误")
                }
            },
            error: function (res) {
                alert(res.toString())

            }
        })

    }
</script>
</body>
</html>
