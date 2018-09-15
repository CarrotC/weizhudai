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
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="description" content="注册页面"/>
    <link href="/dist/css/button-style.css" rel="stylesheet"/>
    <link href="/statics/css/register.css" rel="stylesheet"/>
    <link href="/statics/css/tabStyle.css" rel="stylesheet"/>
    <link rel="icon" type="image/x-icon" href="/statics/img/logo01.png"/>
    <link href="/dist/bookstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/dist/js/jquery-3.3.1.js"></script>
    <script src="/dist/js/button-style.js"></script>
    <script src="/dist/bookstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="/statics/js/translation.js"></script>

    <title>微助贷-企业注册</title>
</head>
<body>
<%--<h3>注册入口</h3>--%>
<%--<div id="companyUserSign">--%>
<%--<h3>企业用户注册</h3><br>--%>
<%--<h4>（测试而已，不需要填）</h4>--%>
<%--账户名:<input name="userName" type="text" placeholder="weizhudai"><br>--%>
<%--密码:<input name="password" type="password" placeholder="123456"><br>--%>
<%--信用代码:<input name="socialCredit" type="text" placeholder="123456"><br>--%>
<%--企业类型:<input name="companyType" type="text" placeholder="123456"><br>--%>
<%--法人姓名:<input name="legalPersonName" type="text" placeholder="123456"><br>--%>
<%--法人证件号:<input name="legalPersonId" type="text" placeholder="123456"><br>--%>
<%--注册资本:<input name="registeredCapital" type="text" placeholder="123456"><br>--%>
<%--营业期限:<input name="operatingPeriod" type="text" placeholder="123456"><br>--%>
<%--企业名称:<input name="companyName" type="text" placeholder="123456"><br>--%>
<%--&lt;%&ndash;企业执照正:<input name="password" placeholder="123456"><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;企业执照反:<input name="password" placeholder="123456"><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;法人证件照正:<input name="password" placeholder="123456"><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;法人证件照反:<input name="password" placeholder="123456"><br>&ndash;%&gt;--%>
<%--<br>--%>
<%--<button onclick="signIn()">注册</button>--%>
<%--<br>--%>
<%--<br>--%>
<%--<br>--%>
<%--<br>--%>
<%--</div>--%>
<div class="bg">
    <img src="/statics/img/loginBg.png"/>
</div>
<nav class="navbar navbar-inverse" role="navigation">

    <div class="navbar-header">
        <img src="/statics/img/logo01.png"/>
        <p class="navbar-brand">微助贷</p>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="li-item active">
                <a href="login.html"><p class="main-style">登录/注册</p></a>
            </li>
            <li class="li-item">
                <a href="/frontend/center/aboutUs"><p class="main-style">关于我们</p></a>
            </li>
            <li class="li-item">
                <a href="/frontend/center/contactUs"><p class="main-style">联系我们</p></a>
            </li>
            <li class="line"></li>
            <li class="language chinese" id="language">
                <img class="rkmd-btn btn-fab-mini btn-pink ripple-effect" src="/statics/img/english.png"/>
            </li>
        </ul>
    </div>
</nav>
<div class="main-container">
    <div class="inner">

        <div class="step-box">
            <div class="dashedLine">
                <div class="dashed1"></div>
                <div class="dashed2"></div>
            </div>
            <div class="first-step">
                <img src="/statics/img/1 (3).png"/>
                <p style="color: white; width: 110.42px;">填写基础信息</p>
            </div>
            <div class="second-step">
                <img src="/statics/img/2.png"/>
                <p style="width: 73.41px;">身份验证</p>
            </div>
            <div class="third-step">
                <img src="/statics/img/3.png"/>
                <p style="width: 73.41px;">完成注册</p>
            </div>
        </div>

        <div class="container1">
            <p class="title">企业注册</p>
            <div class="info-box">
                <div class="username">
                    <p>帐户名：</p>
                    <input id="username" name="username" type="text" />
                </div>
                <div class="password">
                    <p>密码：</p>
                    <input id="password" name="password" type="password" />
                </div>
                <div class="ensurePassword">
                    <p>确认密码：</p>
                    <input id="ensurePassword" name="ensurePassword" type="password" />
                </div>
                <div class="creditCode">
                    <p>企业注册号或统一社会信用代码：</p>
                    <input id="creditCode" name="creditCode" type="text" />
                </div>
                <div class="companyType">
                    <p>企业类型：</p>
                    <input id="companyType" name="companyType" type="text" />
                </div>
                <div class="corporationName">
                    <p>法人姓名：</p>
                    <input id="corporationName" name="corporationName" type="text" />
                </div>
                <div class="corporationId">
                    <p>法人证件号：</p>
                    <input id="corporationId" name="corporationId" type="text" />
                </div>
                <div class="registerCapital">
                    <p>注册资本：</p>
                    <input id="registerCapital" name="registerCapital" type="text" />
                </div>
                <div class="bussinessLimit">
                    <p>营业期限：</p>
                    <input id="bussinessLimit" name="bussinessLimit" type="text" />
                </div>
                <!--<div class="bankAccount">
                    <p>企业银行账户：</p>
                    <input id="bankAccount" name="bankAccount" type="text" />
                </div>-->
            </div>
            <button class="nextstep next rkmd-btn btn-lightBlue ripple-effect "><p style="margin: 0;">下一步</p></button>
        </div>
        <div class="container2" style="display: none;">
            <div class="returnStep">
                <img src="/statics/img/returnStep2.png" />
                <p>上一步</p>
            </div>
            <p class="title">身份验证</p>
            <div class="info-box2">
                <div class="companyName">
                    <p>企业名称:</p>
                    <input id="companyName" type="text" />
                </div>
                <div class="businessLicense">
                    <p>企业营业执照:</p>
                    <div class="LisencePhote">
                        <div class="front">
                            <div>
                                <p>正面</p>
                                <!--此处插入图片-->
                            </div>
                            <button id="LFront" class="uploadBt rkmd-btn btn-lightBlue ripple-effect "><p style="margin: 0;">上传</p></button>
                        </div>
                        <div class="opposite">
                            <div>
                                <p>反面</p>
                                <!--此处插入图片-->
                            </div>
                            <button id="LOpposite" class="uploadBt rkmd-btn btn-lightBlue ripple-effect "><p style="margin: 0;">上传</p></button>
                        </div>
                    </div>
                </div>
                <div class="corporationName">
                    <p>法人姓名:</p>
                    <input id="corporationName2" type="text" />
                </div>
                <div class="corporationId">
                    <p>法人证件号:</p>
                    <input id="corporationId2" type="text" />
                </div>
                <div class="corporationIdPhoto">
                    <p>法人证件照:</p>
                    <div class="IDPhote">
                        <div class="front">
                            <div>
                                <p>正面</p>
                                <!--此处插入图片-->
                            </div>
                            <button id="IDFront" class="uploadBt rkmd-btn btn-lightBlue ripple-effect "><p style="margin: 0;">上传</p></button>
                        </div>
                        <div class="opposite">
                            <div>
                                <p>反面</p>
                                <!--此处插入图片-->
                            </div>
                            <button id="IDOpposite" class="uploadBt rkmd-btn btn-lightBlue ripple-effect "><p style="margin: 0;">上传</p></button>
                        </div>
                    </div>
                </div>
            </div>
            <div style="width: 100%; height: 1px; margin-top: 15px;border-bottom: 1.2px dashed rgb(230,230,230);"></div>
            <button class="nextstep next rkmd-btn btn-lightBlue ripple-effect "><p style="margin: 0;">下一步</p></button>
        </div>
        <div class="container3" style="display: none;">
            <p class="title">等待验证</p>
            <img class="successRegister" src="/statics/img/successsRegister.png">
            <p class="prompt">信息将在24小时内审核完毕！请耐心等待！</p>
            <button id="goLogin" class="next rkmd-btn btn-lightBlue ripple-effect "><p style="margin: 0;">登陆</p></button>
            <p class="return-text"><span id="time"></span>&nbsp;秒后自动返回登陆页面！</p>
        </div>
    </div>
</div>

<script>
    function signIn() {
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
                    alert("no")
                }
            },
            error: function (xhr, err) {
                jQuery("#companyUserSign").html(xhr.responseText);
            }
        })

    }
</script>
</body>

<script>
    //		切换语言
    $("#language").on("click", function () {
        if ($(this).hasClass("chinese")) {
            //换成英文
            $(this).addClass("english");
            $(this).removeClass("chinese");
            $("#language img").attr("src", "/statics/img/english.png");
            translate();
        } else {
            $(this).removeClass("english");
            $(this).addClass("chinese");
            $("#language img").attr("src", "/statics/img/chinese.png")
        }
    });
    var thisStep = 1;
    $(document).ready(function () {

        //上一步
        $(".returnStep").on("click", function () {
            window.scrollTo(0, 0);
            $(window).scrollTop(0);
            $(window).scrollLeft(0);
            $(".container2").hide();
            $(".container1").show();
            thisStep = 1;
            $(".second-step img").attr("src", "/statics/img/2.png");
            $(".second-step p").attr("style", "")
            $(".first-step img").attr("src", "/statics/img/1 (3).png");
            $(".first-step p").attr("style", "color: #F0F0F0;")
        })

        //下一步
        $(".nextstep").on("click", function () {
            window.scrollTo(0, 0);
            if (thisStep == 1) {
                thisStep = 2;
                $(".container1").hide();
                $(".container2").show();
                $(".first-step img").attr("src", "/statics/img/1.png");
                $(".first-step p").attr("style", "")
                $(".second-step img").attr("src", "/statics/img/2 (3).png");
                $(".second-step p").attr("style", "color: white;")
            } else if (thisStep == 2) {
                thisStep = 3;
                $(".container2").hide();
                $(".container3").show();
                $(".second-step img").attr("src", "/statics/img/2.png");
                $(".second-step p").attr("style", "")
                $(".third-step img").attr("src", "/statics/img/3 (3).png");
                $(".third-step p").attr("style", "color: white;");
                //跳轉到登錄界面
                $("#time").text("10"); //首先默认给10s

                var i = 10;
                var Timer = setInterval(function () {
                    i--;
                    $("#time").text(i);
                    if ($("#time").text() == "1") {
                        location.href = "login.html"; //PC网页式跳转
                        clearInterval(Timer);
                    }
                }, 1000)

                $("#goLogin").on("click", function () {
                    location.href = "login.html"; //PC网页式跳转
                })
            }
        })

        $(".return").hover(function () {
            $(".return").css("color", "#64A0D2");
            $(".return img").attr("src", "/statics/img/returnHome.png")
        }, function () {
            $(".return").css("color", "#2D5A82");
            $(".return img").attr("src", "/statics/img/returnHome2.png")
        });
        $(".returnStep").hover(function () {
            $(".returnStep").css("color", "#f0f0f0");
            $(".returnStep img").attr("src", "/statics/img/returnStep1.png")
        }, function () {
            $(".returnStep").css("color", "#707070");
            $(".returnStep img").attr("src", "/statics/img/returnStep2.png")
        });

    })
</script>
</html>
