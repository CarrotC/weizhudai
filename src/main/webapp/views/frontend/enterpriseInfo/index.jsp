<%--
  Created by IntelliJ IDEA.
  User: coldilock
  Date: 2018/9/5
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="行业分类" />

    <link href="/dist/css/button-style.css" rel="stylesheet" />
    <link href="/statics/css/basicInfo.css" rel="stylesheet" />
    <link href="/statics/css/listStyle.css" rel="stylesheet" />
    <link href="/statics/css/tabStyle.css" rel="stylesheet" />

    <link rel="icon" type="image/x-icon" href="/statics/img/logo01.png" />
    <link href="/dist/bookstrap/css/bootstrap.css" rel="stylesheet">
    <script src="/dist/js/jquery-3.3.1.js"></script>
    <script src="/dist/js/button-style.js"></script>
    <script src="/dist/bookstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="/statics/js/translation.js"></script>

    <title>微助贷-企业信息</title>
</head>
<body>
<div class="bg">
    <img src="/statics/img/indexBg.png" />
</div>
<nav class="navbar navbar-inverse" role="navigation">

    <div class="navbar-header">
        <img src="/statics/img/logo01.png" />
        <P class="navbar-brand" href="index.html">微助贷</P>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="li-item">
                <a href="/frontend/center/index"><p class="main-style">首页</p></a>
            </li>
            <li class="li-item active">
                <a href="/frontend/center/industryCategory?index=0"><p class="main-style">行业分类</p></a>
            </li>

            <li class="li-item">
                <a href="/frontend/login/index"><p class="main-style">退出登录</p></a>
            </li>
            <li class="line"></li>
            <li class="language chinese">
                <img class="rkmd-btn btn-fab-mini btn-pink ripple-effect" src="/statics/img/english.png" />
            </li>
        </ul>
    </div>
</nav>

<div class="main-container">
    <div class="title">
        <p class="big-title">${companyName}</p>
        <p class="small-title">————XXX行业</p>
    </div>
    <section class="nav-box">
        <div id="nav">
            <ul class="nav-menu clearfix unstyled">
                <li class="firstLayer">
                    <a href="#" class="three-d "> 企业资料 <span class="three-d-box"><span class="front">企业资料</span><span class="back">企业资料</span></span>
                    </a>
                    <ul class="clearfix unstyled drop-menu">
                        <li>
                            <a href="#" class="three-d"> 基本信息 <span class="three-d-box"><span class="front">基本信息</span><span class="back">基本信息</span></span>
                            </a>
                        </li>
                        <li>
                            <a href="/frontend/enterpriseInfo/taxSituation" class="three-d"> 纳税情况 <span class="three-d-box"><span class="front">纳税情况</span><span class="back">纳税情况</span></span>
                            </a>
                        </li>
                        <li>
                            <a href="/frontend/enterpriseInfo/complaint" class="three-d"> 涉诉情况 <span class="three-d-box"><span class="front">涉诉情况</span><span class="back">涉诉情况</span></span>
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/companyFlow?companyId=${companyId}" class="three-d"> 企业流水 <span class="three-d-box"><span class="front">企业流水</span><span class="back">企业流水</span></span>
                    </a>

                </li>
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/companyLoan?companyId=${companyId}" class="three-d "> 企业信用 <span class="three-d-box"><span class="front"> 企业信用</span><span class="back">企业信用</span></span>
                    </a>
                </li>
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/companyFinance" class="three-d "> 财务信息<span class="three-d-box"><span class="front">财务信息</span><span class="back">财务信息</span></span>
                    </a>
                </li>
            </ul>
        </div>
    </section>
    <div class="main-box">

        <!------------>
        <!--基本信息-->
        <!------------>
        <div id="essentialInfo" class="showing">
            <p class="tab-title">基本信息</p>
            <ul class="nav nav-tabs">
                <li id="datum" class="active">
                    <a href="#datum-box" data-toggle="tab" class="aTab">
                        <p style="margin: 0;">资料</p>
                    </a>
                </li>
                <li id="appendix">
                    <a href="#appendix-box" data-toggle="tab" class="aTab"><p style="margin: 0;">附件</p></a>
                </li>

            </ul>
            <div class="tab-content">
                <div class="tab-pane fade in active" id="datum-box">
                    <div class="split"></div>
                    <div id="industryAndC">
                        <p class="title2">工商信息</p>
                        <p class="content">
                            <!--插入内容-->
                        </p>
                    </div>
                    <div class="split"></div>
                    <div id="corporation">
                        <p class="title2">法人信息</p>
                        <p class="content">
                            <!--插入内容-->
                        </p>
                    </div>
                    <div class="split"></div>
                    <div id="mainMember">
                        <p class="title2">公司主要成员</p>
                        <p class="content">
                            <!--插入内容-->
                        </p>
                    </div>
                    <div class="split"></div>
                    <div id="stockRight">
                        <p class="title2">公司股权结构</p>
                        <p class="content">
                            <!--插入内容-->
                        </p>
                    </div>
                    <div class="split"></div>
                    <div id="history">
                        <p class="title2">历史变更记录</p>
                        <p class="content">
                            <!--插入内容-->
                        </p>
                    </div>
                    <div class="split"></div>
                </div>
                <div class="tab-pane fade" id="appendix-box">
                    <div class="appendix-item">
                        <p>法人证件照（正）.jpg</p>
                        <a><p style="margin:0;">下载</p></a>
                    </div>
                    <div class="appendix-item">
                        <p>法人证件照（反）.jpg</p>
                        <a><p style="margin:0;">下载</p></a>
                    </div>
                    <div class="appendix-item">
                        <p>法人信息导出.pdf</p>
                        <a><p style="margin:0;">下载</p></a>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>

<%----%>
<%--<c:forEach items="${loanList}" var="t" varStatus="status">--%>
<%--<div class="type-item " id="type1">--%>
<%--<div data-index="${status.index}">${t.lenders}</div>--%>
<%--</div>--%>

<%--</c:forEach>--%>
</body>
<script>
    //		切换语言
    $(".language").on("click", function() {
        translate();
    });

    //切换筛选条件
    $("#filter-choose").on("click",function(){
        $("#all").removeClass("choosed");
        $(this).addClass("choosed");
        $("form").removeClass("coverd");
        $(".cover").hide();
    })
    $("#all").on("click",function(){
        $(this).addClass("choosed");
        $("#filter-choose").removeClass("choosed");
        $("form").addClass("coverd");
        $(".cover").show();
    })
</script>
</html>
