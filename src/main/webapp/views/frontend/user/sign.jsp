<%--
  Created by IntelliJ IDEA.
  User: coldilock
  Date: 2018/9/5
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<title>Title</title>--%>
    <%--<script src="/dist/js/jquery-3.3.1.js"></script>--%>

    <meta charset="utf-8" />
    <script src="<spring:url value="/statics/js/jquery-3.3.1.min.js"/>"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="登陆页面" />
    <link href="/statics/css/login.css" rel="stylesheet" />
    <link href="/statics/css/tabStyle.css" rel="stylesheet" />
    <link href="/dist/css/button-style.css" rel="stylesheet" />

    <link rel="icon" type="image/x-icon" href="/statics/img/logo01.png" />
    <link href="/dist/bookstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/dist/js/jquery-3.3.1.js"></script>
    <script src="/dist/js/button-style.js"></script>
    <script src="/dist/bookstrap/js/bootstrap.min.js"></script>
    <script src="/statics/js/changeLanguage.js"></script>

    <title>微助贷-注册</title>
</head>
<body>
<h3>注册入口</h3>
<div id="companyUserSign">
    <h3>企业用户注册</h3><br>
    <h4>（测试而已，不需要填）</h4>
    账户名:<input name="userName" type="text" placeholder="weizhudai"><br>
    密码:<input name="password" type="password" placeholder="123456"><br>
    信用代码:<input name="socialCredit" type="text" placeholder="123456"><br>
    企业类型:<input name="companyType" type="text" placeholder="123456"><br>
    法人姓名:<input name="legalPersonName" type="text" placeholder="123456"><br>
    法人证件号:<input name="legalPersonId" type="text" placeholder="123456"><br>
    注册资本:<input name="registeredCapital" type="text" placeholder="123456"><br>
    营业期限:<input name="operatingPeriod" type="text" placeholder="123456"><br>
    企业名称:<input name="companyName" type="text" placeholder="123456"><br>
    <%--企业执照正:<input name="password" placeholder="123456"><br>--%>
    <%--企业执照反:<input name="password" placeholder="123456"><br>--%>
    <%--法人证件照正:<input name="password" placeholder="123456"><br>--%>
    <%--法人证件照反:<input name="password" placeholder="123456"><br>--%>
    <br>
    <button onclick="signIn()">注册</button>
    <br>
    <br>
    <br>
    <br>
</div>

<script>
    function signIn(){
        var userName = 'lll';
        var password = 'xxxx';
        var companyName = "testCompany";
        var companyType = "testType";

        $.ajax({
            url: '/frontend/signIn',
            data: JSON.stringify({
                userName: userName,
                password: password,
                companyName: companyName,
                companyType: companyType
            }),
            contentType: 'application/json',
            dataType: 'json',
            method: 'post',
            async: false,
            success: function (res) {
                if (res.status === 200) {
                    window.location.href = '/frontend/login/index';
                    alert("yes");
                } else {
                    //window.location.href = '/';
                    alert("no")
                }
            },
            error:  function (xhr, err)
            {
                //console.log(xhr.responseText);
                jQuery("#companyUserSign").html(xhr.responseText);
            }
            // function (res) {
            //     // alert(res.toString())
            //     console.log(res);
            // }
        })

    }
</script>

<%--<button onclick="window.location.href = '/frontend/signIn'">注册</button>--%>
</body>
</html>
