<%--
  Created by IntelliJ IDEA.
  User: coldilock
  Date: 2018/9/11
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl标签库--%>
<%@include file="/views/include/taglib.jsp" %>
<html>
<head>
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

    <title>微助贷-登陆</title>
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
            <li class="li-item active">
                <a href="login.html">登陆/注册</a>
            </li>
            <li class="li-item">
                <a href="aboutUs.html">关于我们</a>
            </li>
            <li class="li-item">
                <a href="contactUs.html">联系我们</a>
            </li>
            <li class="li-item">
                <a href="#">反馈投诉</a>
            </li>
            <li class="line"></li>
            <li class="language chinese" id="language">
                <img class="rkmd-btn btn-fab-mini btn-pink ripple-effect" src="static/img/chinese.png" />
            </li>
        </ul>
    </div>
</nav>
<div class="main-container">
    <!--<a href="index.html" class="return">
        <img src="static/img/returnHome2.png" />
        <p>返回首页</p>
    </a>-->
    <p class="title">微&nbsp;助&nbsp;贷</p>
    <p class="prompt">————基于区块链技术的小微企业贷款风险评估系统</p>
    <div class="container">
        <div class="company-box before">
            <div class="inner">
                <div class="before-cg">
                    <p>切换银行入口</p>
                    <img src="/statics/img/change.png" />
                </div>
                <p>企业登录入口</p>
                <div class="input-box">
                    <div class="input-item">
                        <img src="/statics/img/username-icon.png" />
                        <input id="CUsername" name="username" type="text" placeholder="请输入账户名" />
                    </div>
                    <div class="input-item" style="margin-top: 5px;">
                        <img src="/statics/img/password-icon.png" />
                        <input id="CPassword" name="password" type="password" placeholder="请输入密码" />
                    </div>

                </div>
                <div class="btBox">
                    <button onclick="companyLogin()" id="submit-company" class="submit rkmd-btn btn-lightBlue ripple-effect">登录</button>
                    <button id="register" class="register rkmd-btn btn-lightBlue ripple-effect" onclick="turnToSignIn()">前往注册</button>
                </div>
            </div>
        </div>
        <div class="bank-box after">
            <div class="inner" style="display: none;">
                <div class="after-cg">
                    <p>切换企业入口</p>
                    <img src="/statics/img/change.png" />
                </div>
                <p>银行登录入口</p>
                <div class="input-box">
                    <div class="input-item">
                        <img src="/statics/img/username-icon.png" />
                        <input id="BUsername" name="username" type="text" placeholder="请输入账户名" />
                    </div>
                    <div class="input-item" style="margin-top: 5px;">
                        <img src="/statics/img/password-icon.png" />
                        <input id="BPassword" name="password" type="password" placeholder="请输入密码" />
                    </div>

                </div>
                <div class="btBox">
                    <button onclick="bankLogin()" id="submit-bank" style="width: 100%;" class="submit rkmd-btn btn-lightBlue ripple-effect">登录</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    //切换语言
    $("#language").on("click", function() {
        if($(this).hasClass("chinese")) {
            //换成英文
            $(this).addClass("english");
            $(this).removeClass("chinese");
            $("#language img").attr("src", "static/img/english.png")
        } else {
            $(this).removeClass("english");
            $(this).addClass("chinese");
            $("#language img").attr("src", "static/img/chinese.png")
        }
    });

    //企业登陆
    // function companyLogin(){
    //     location.href="companyInfo.html";
    // }

    //银行登陆
    // function bankLogin(){
    //     location.href="index.html";
    // }

    $(document).ready(function() {
        // $("#register").on("click", function() {
        //     location.href = "register.html";
        // });

        $(".before-cg").bind("click", function(event) {
            $(".before .inner").hide();
            $(".after .inner").show();
            $(".before").css('animation', 'cardChange1 1s forwards');
            $(".after").css('animation', 'cardChange2 1s forwards');

            $(".before").on("animationend", function() {
                $(".before").css("z-index", "2");
                $(".before").css("background-color", "rgba(210, 210, 210, 0.45)");
                $(".before").css("transform", "translate(0,-15px)")
                $(".before").css("animation", "");
            });
            $(".after").on("animationend", function() {
                $(".after").css("z-index", "3");
                $(".after").css("background-color", "rgba(60, 105, 150, 0.75)");
                $(".after").css("transform", "translate(-15px,0)")
                $(".after").css("animation", "");
            });
        });
        $(".after-cg").bind("click", function(event) {
            $(".after .inner").hide();
            $(".before .inner").show();
            $(".after").css('animation', 'cardChange1 1s forwards');
            $(".before").css('animation', 'cardChange2 1s forwards');
            $(".after").css("z-index", "2");
            $(".before").bind("animationend", function() {
                $(".before").css("z-index", "3");
                $(".before").css("background-color", "rgba(60, 105, 150, 0.75)");
                $(".before").css("transform", "translate(-15px,0)")
                $(".before").css("animation", "");
            });
            $(".after").on("animationend", function() {
                $(".after").css("z-index", "2");
                $(".after").css("background-color", "rgba(210, 210, 210, 0.45)");
                $(".after").css("transform", "translate(0,-15px)")
                $(".after").css("animation", "");
            });
        });

        $(".return").hover(function() {
            $(".return").css("color", "#64A0D2");
            $(".return img").attr("src", "static/img/returnHome.png")
        }, function() {
            $(".return").css("color", "#2D5A82");
            $(".return img").attr("src", "static/img/returnHome2.png")
        });
    })


    function companyLogin() {
        var userName = $("#CUsername").val();
        var passwd = $('#CPassword').val();
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
                    alert("密码错误")
                }
            },
            error: function (res) {
                alert(res.toString())

            }
        })
    }

    function bankLogin(){
        var userName = $("#BUsername").val();
        var passwd = $('#BPassword').val();
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
                    alert("密码错误")
                }
            },
            error: function (res) {
                alert(res.toString())

            }
        })

    }

    function turnToSignIn() {
        window.location.href = '/frontend/sign/index';
    }
</script>

</body>

</html>
