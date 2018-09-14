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
    <p>hhhhhhhhhh</p>
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
    <input id="companyName" type="text" placeholder="企业名称">&nbsp&nbsp&nbsp<button onclick=searchCompany()>搜索</button>
    <div id="testDiv1"></div>
    <div id="testDiv2"></div>
</center>

<script>
    function searchCompany() {
        var input = $("#companyName").val();
        $.ajax({
            url: '/frontend/center/search',
            data: JSON.stringify({
                input: input
            }),
            contentType: 'application/json',
            dataType: 'json',
            method: 'post',
            async: false,
            success: function (res) {
                $("#testDiv2").html("???");
                $("#testDiv1").html(${companyTypeList});
            },
            error: function (res) {
                alert(res.toString())

            }
        })
    }
</script>
</body>
</html>
