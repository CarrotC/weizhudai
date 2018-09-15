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
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="description" content="主页" />
        <link href="/dist/css/button-style.css" rel="stylesheet" />
        <link href="/statics/css/index.css" rel="stylesheet" />
        <link href="/statics/css/tabStyle.css" rel="stylesheet" />
        <link rel="icon" type="image/x-icon" href="/statics/img/logo01.png" />
        <link href="/dist/bookstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="/dist/js/jquery-3.3.1.js"></script>
        <script src="/dist/js/button-style.js"></script>
        <script src="/dist/bookstrap/js/bootstrap.min.js"></script>

        <script type="text/javascript" src="/statics/js/translation.js"></script>

        <title>微助贷-主页</title>
    </head>
</head>
<body>

<div style="position: fixed;width: 100%;height: 100%;z-index: -1;background-color: rgba(200,200,200,0.8);">
    <!--<img src="static/img/indexBg.png" />-->
</div>
<nav class="navbar navbar-inverse" role="navigation">

    <div class="navbar-header">
        <img src="/statics/img/logo01.png" />
        <p class="navbar-brand">微助贷</p>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="li-item active">
                <a href="#"><p class="main-style">首页</p></a>
            </li>
            <li class="li-item">
                <a href="/frontend/center/industryCategory?index=0"><p class="main-style">行业分类</p></a>
            </li>
            <li class="li-item">
                <a href="/frontend/logout"><p class="main-style">退出登录</p></a>
            </li>
            <li class="line"></li>
            <li class="language chinese" id="language">
                <img class="rkmd-btn btn-fab-mini btn-pink ripple-effect" src="/statics/img/english.png" />
            </li>
        </ul>
    </div>
</nav>
<!--轮播图-->
<div class="img-box">
    <div class="search-box">
        <form class="search">
            <input id="companyName" class="companyName" type="text" placeholder="请输入要查询的企业名称" />
            <button id="search" class="rkmd-btn btn-lightBlue ripple-effect" onclick=searchCompany()><p style="margin: 0;">查询</p></button>
        </form>
        <div id="searchResult" class="searchResult">
            <div class="search-inner">
                <!--<div class="search-item">
                    <p>红米红米</p>
                </div>
                <div class="search-item">
                    <p>红米红米</p>
                </div>
                <div class="search-item">
                    <p>红米红米</p>
                </div>
                <div class="search-item">
                    <p>红米红米</p>
                </div>
                <div class="search-item">
                    <p>红米红米</p>
                </div>
                <div class="search-item">
                    <p>红米红米</p>
                </div>-->
            </div>
        </div>

    </div>
    <div class="top"></div>
    <div class="banner banner1">
        <img src="/statics/img/bg1.png" />
    </div>
    <div class="banner banner2" style="display: none;">
        <img src="/statics/img/bg6.png" />
    </div>
    <div class="banner banner3" style="display: none;">
        <img src="/statics/img/bg2.png" />
    </div>
    <div class="banner banner4" style="display: none;">
        <img src="static/img/bg3.png" />
    </div>
    <div class="banner banner5" style="display: none;">
        <img src="/statics/img/bg4.png" />
    </div>
    <div class="footer">
        <div class="footer-item footer1 live-footer"></div>
        <div class="footer-item footer2"></div>
        <div class="footer-item footer3"></div>
        <div class="footer-item footer4"></div>
        <div class="footer-item footer5"></div>
        </ul>
    </div>
</div>

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

            },
            error: function (res) {
                alert(res.toString())

            }
        })
    }
    $(".language").on("click", function() {
        translate();
    })

    $(".li-item").on("click", function() {
        $(this).siblings("li").removeClass("active");
        $(this).addClass("active");
        $(".navbar-brand").removeClass("nameActive");
    })
    $(".navbar-brand").on("click", function() {
        $(this).addClass("nameActive");
        $(".li-item").removeClass("active");
    })

    $(document).ready(function() {

        /*********************************/
        /***********轮播图效果*************/
        /*********************************/

        var banner = 1;

        var Timer = setInterval(function() {
            imgBefore = "banner" + banner;
            footerBefore = "footer" + banner;
            banner++;
            changeImg();
        }, 8000);
        $(".footer1").on("click", function() {
            imgBefore = "banner" + banner;
            footerBefore = "footer" + banner;
            if(banner == 1) {} else {
                banner = 1;
                changeImg();
                clearInterval(Timer);
                Timer = setInterval(function() {
                    imgBefore = "banner" + banner;
                    footerBefore = "footer" + banner;
                    banner++;
                    changeImg();
                }, 8000);

            };
        });

        $(".footer2").on("click", function() {
            imgBefore = "banner" + banner;
            footerBefore = "footer" + banner;
            if(banner == 2) {} else {
                banner = 2;
                changeImg();
                clearInterval(Timer);
                Timer = setInterval(function() {
                    imgBefore = "banner" + banner;
                    footerBefore = "footer" + banner;
                    banner++;
                    changeImg();
                }, 8000);

            };
        });
        $(".footer3").on("click", function() {
            imgBefore = "banner" + banner;
            footerBefore = "footer" + banner;
            if(banner == 3) {} else {
                banner = 3;
                changeImg();
                clearInterval(Timer);
                Timer = setInterval(function() {
                    imgBefore = "banner" + banner;
                    footerBefore = "footer" + banner;
                    banner++;
                    changeImg();
                }, 8000);

            };
        });
        $(".footer4").on("click", function() {
            imgBefore = "banner" + banner;
            footerBefore = "footer" + banner;
            if(banner == 4) {} else {
                banner = 4;
                changeImg();
                clearInterval(Timer);
                Timer = setInterval(function() {
                    imgBefore = "banner" + banner;
                    footerBefore = "footer" + banner;
                    banner++;
                    changeImg();
                }, 8000);

            };
        });
        $(".footer5").on("click", function() {
            imgBefore = "banner" + banner;
            footerBefore = "footer" + banner;
            if(banner == 5) {} else {
                banner = 5;
                changeImg();
                clearInterval(Timer);
                Timer = setInterval(function() {
                    imgBefore = "banner" + banner;
                    footerBefore = "footer" + banner;
                    banner++;
                    changeImg();
                }, 8000);

            };
        });

        function changeImg() {

            imgAfter = "banner" + banner;
            footerAfter = "footer" + banner;
            if(banner > 5) {
                banner = 1;
                imgAfter = "banner" + banner;
                footerAfter = "footer" + banner;
            }
            $("." + imgAfter).show();
            $("." + imgBefore).css('animation', 'imgOut 1s forwards');
            $("." + imgAfter).css('animation', 'imgIn 1s forwards');

            $("." + footerBefore).removeClass("live-footer");
            $("." + footerAfter).addClass("live-footer");

            $("." + imgBefore).bind("animationend", function() {
                $("." + imgBefore).hide();
                $("." + imgBefore).css('animation', '');

            });
            $("." + imgAfter).bind("animationend", function() {
                $("." + imgAfter).css('animation', '');

            });
        };
        /*********************************/
        /***********轮播图效果*************/
        /*********************************/

    })
</script>
</body>
</html>
