<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl标签库--%>
<%@include file="/views/include/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="登陆页面" />
    <link href="/statics/css/aboutUs.css" rel="stylesheet" />
    <link href="/statics/css/tabStyle.css" rel="stylesheet" />
    <link href="/dist/css/button-style.css" rel="stylesheet" />

    <link rel="icon" type="image/x-icon" href="/statics/img/logo01.png" />
    <link href="/dist/bookstrap/css/bootstrap.css" rel="stylesheet">
    <script src="/dist/js/jquery-3.3.1.js"></script>
    <script src="/dist/js/button-style.js"></script>
    <script src="/dist/bookstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="/statics/js/translation.js"></script>

    <title>微助贷-关于我们</title>
</head>
<body>
<div class="bg">
    <img src="/statics/img/loginBg.png" />
</div>
<nav class="navbar navbar-inverse" role="navigation">

    <div class="navbar-header">
        <img src="/statics/img/logo01.png" />
        <p class="navbar-brand">微助贷</p>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="li-item ">
                <a href="login.html"><p class="main-style">登录/注册</p></a>
            </li>
            <li class="li-item active">
                <a href="#"><p class="main-style">关于我们</p></a>
            </li>
            <li class="li-item">
                <a href="/frontend/center/contactUs"><p class="main-style">联系我们</p></a>
            </li>

            <li class="line"></li>
            <li class="language chinese" id="language">
                <img class="rkmd-btn btn-fab-mini btn-pink ripple-effect" src="/statics/img/english.png" />
            </li>
        </ul>
    </div>
</nav>
<div class="main-container">
    <div class="inner">
        <p class="title">我们做了什么</p>
        <p>以一省为范围，所有银行注册为节点。当某银行向某小微企业贷款时，该银行向整个网络发送包括贷款对象、资金量、期限、利率等内容的信息，且该信息将在各个节点备份。此后，系统将持续跟踪该小微企业的运营状况和贷出资金的运用状况，作为智能合约部分记录。</p>
        <p>在该小微企业还款或违约时，再次向网络发送消息，并在各个节点备份。从而该系统包含了所有小微企业与银行的资金借贷往来信息。</p>
        <p>通过关键词索引，系统内成员（所有银行）可获得任一家银行或任一家小微企业在该内容下的资金借贷情况，从而为信用评估等目的服务。</p>
        <p class="title">我们是谁</p>
        <p>以一省为范围，所有银行注册为节点。当某银行向某小微企业贷款时，该银行向整个网络发送包括贷款对象、资金量、期限、利率等内容的信息，且该信息将在各个节点备份。此后，系统将持续跟踪该小微企业的运营状况和贷出资金的运用状况，作为智能合约部分记录。在该小微企业还款或违约时，再次向网络发送消息，并在各个节点备份。从而该系统包含了所有小微企业与银行的资金借贷往来信息。</p>
        <p>通过关键词索引，系统内成员（所有银行）可获得任一家银行或任一家小微企业在该内容下的资金借贷情况，从而为信用评估等目的服务</p>
    </div>
</div>
</body>
<script>
    //		切换语言
    $("#language").on("click", function() {
        translate();
    });
</script>
</html>
