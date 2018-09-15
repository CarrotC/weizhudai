<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl标签库--%>
<%@include file="/views/include/taglib.jsp" %>

<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="登陆页面" />
    <link href="/statics/css/contactUs.css" rel="stylesheet" />
    <link href="/statics/css/tabStyle.css" rel="stylesheet" />
    <link href="/dist/css/button-style.css" rel="stylesheet" />

    <link rel="icon" type="image/x-icon" href="/statics/img/logo01.png" />
    <link href="/dist/bookstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/dist/js/jquery-3.3.1.js"></script>
    <script src="/dist/js/button-style.js"></script>
    <script src="/dist/bookstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="/statics/js/translation.js"></script>

    <title>微助贷-联系我们</title>
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
                <a href="/frontend/login/index"><p class="main-style">登录/注册</p></a>
            </li>
            <li class="li-item">
                <a href="/frontend/center/aboutUs"><p class="main-style">关于我们</p></a>
            </li>
            <li class="li-item active">
                <a href="#"><p class="main-style">联系我们</p></a>
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
        <p class="title">联系我们</p>
        <p>联系电话：15076881327</p>
        <p>固定电话：77825171</p>
        <p>联系邮箱：1172687523@whu.edu.c</p>
        <p>联系地址：湖北省武汉市洪山区珞南街道114号（邮编442000）</p>
    </div>
</div>
</body>
<script>
    $(".language").on("click", function() {
        translate();
    })
</script>
</html>
