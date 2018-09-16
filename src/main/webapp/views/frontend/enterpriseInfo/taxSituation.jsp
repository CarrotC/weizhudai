<%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2018/9/15
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="行业分类" />
    <link href="/dist/css/button-style.css" rel="stylesheet" />
    <link href="/statics/css/taxSituation.css" rel="stylesheet" />
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
                <a href="/frontend/center/industryCategory"><p class="main-style">行业分类</p></a>
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
        <p class="big-title">xxx公司纳税情况</p>
        <p class="small-title">————XXX行业</p>
    </div>
    <section class="nav-box">
        <div id="nav">
            <ul class="nav-menu clearfix unstyled">
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/index" class="three-d "> 企业资料 <span class="three-d-box"><span class="front">企业资料</span><span class="back">企业资料</span></span>
                    </a>
                    <ul class="clearfix unstyled drop-menu">
                        <li>
                            <a href="/frontend/enterpriseInfo/index" class="three-d"> 基本信息 <span class="three-d-box"><span class="front">基本信息</span><span class="back">基本信息</span></span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="three-d"> 纳税情况 <span class="three-d-box"><span class="front">纳税情况</span><span class="back">纳税情况</span></span>
                            </a>
                        </li>
                        <li>
                            <a href="/frontend/enterpriseInfo/complaint" class="three-d"> 涉诉情况 <span class="three-d-box"><span class="front">涉诉情况</span><span class="back">涉诉情况</span></span>
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/companyFlow" class="three-d"> 企业流水 <span class="three-d-box"><span class="front">企业流水</span><span class="back">企业流水</span></span>
                    </a>

                </li>
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/companyLoan" class="three-d "> 企业信用 <span class="three-d-box"><span class="front"> 企业信用</span><span class="back">企业信用</span></span>
                    </a>
                </li>
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/companyFinance?companyId=${companyType.companyId}" class="three-d "> 财务信息<span class="three-d-box"><span class="front">财务信息</span><span class="back">财务信息</span></span>
                    </a>
                </li>
            </ul>
        </div>
    </section>
    <div class="main-box">
        <!------------>
        <!--纳税信息-->
        <!------------>
        <div id="taxInformation showing">
            <p class="tab-title">纳税情况</p>
            <ul class="nav nav-tabs">
                <li id="data" class="active">
                    <a href="#data-box" data-toggle="tab" class="aTab">
                        <p style="margin: 0;">数据</p>
                    </a>
                </li>
                <li id="invariantRecord">
                    <a href="#invariantRecord-box" data-toggle="tab" class="aTab"><p style="margin: 0;">不变记录</p></a>
                </li>

            </ul>
            <div class="tab-content">
                <div class="tab-pane fade in active" id="data-box">
                    <div class="filter-box">
                        <div class="all choosed" id="all">
                            <div class="filter-item" id="all-button"></div>
                            <p>全部</p>
                        </div>
                        <div class="filter-choose" id="filter-choose">
                            <div class="filter-item" id="filter-button"></div>
                            <p>筛选</p>
                        </div>
                        <div class="filter" id="filter">
                            <div class="cover"></div>
                            <form class="coverd">
                                <div class="time">
                                    <p>时间：&nbsp;最近</p>
                                    <select class="form-control" id="time-select" style="background-color: rgb(100,100,100);border: rgb(55,55,55);color: rgb(240,240,240);">
                                        <option>1</option>
                                        <option>3</option>
                                        <option>6</option>
                                        <option>12</option>
                                        <option>24</option>
                                        <option>全部</option>
                                    </select>
                                    <p style="width: auto;margin-left: 3px !important;">月</p>
                                </div>
                                <div class="type">
                                    <p>税种：</p>
                                    <select class="form-control" id="type-select" style="background-color: rgb(100,100,100);border: rgb(55,55,55);color: rgb(240,240,240);">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>

                            </form>

                        </div>
                    </div>
                    <div class="split"></div>
                    <div class="tax-inner">
                        <div class="tax-item">
                            <div class="content">
                                <p class="tax-time">时间：2016年</p>
                                <p class="tax-should">应缴：${taxToPay1}</p>
                                <p class="tax-pay">实缴：${taxPaid1}</p>
                                <p class="tax-state">状态：${status1}</p>
                                <img src="/statics/img/down.png">
                            </div>
                            <div class="detail" style="display: none;">
                                <img src="/statics/img/up-arrow.png" />
                                <c:forEach items="${compTaxList1}" var="item" varStatus="status">
                                    <div class="detail-item">
                                        <p class="detail-time">时间：${item.dt}</p>
                                        <p class="tax-type">税种：${item.type}</p>
                                        <p class="detail-should">应缴：${item.taxShouldPay}</p>
                                        <p class="detail-pay">实缴：${item.taxPaid}</p>
                                        <p class="detail-state">状态：${item.status}</p>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="tax-item">
                                <div class="content">
                                    <p class="tax-time">时间：2017年</p>
                                    <p class="tax-should">应缴：${taxToPay2}</p>
                                    <p class="tax-pay">实缴：${taxPaid2}</p>
                                    <p class="tax-state">状态：${status2}</p>
                                    <img src="/statics/img/down.png">
                                </div>
                                <div class="detail" style="display: none;">
                                    <img src="/statics/img/up-arrow.png" />
                                    <c:forEach items="${compTaxList2}" var="item" varStatus="status">
                                        <div class="detail-item">
                                            <p class="detail-time">时间：${item.dt}</p>
                                            <p class="tax-type">税种：${item.type}</p>
                                            <p class="detail-should">应缴：${item.taxShouldPay}</p>
                                            <p class="detail-pay">实缴：${item.taxPaid}</p>
                                            <p class="detail-state">状态：${item.status}</p>
                                        </div>
                                    </c:forEach>
                                </div>

                        <%--</div>--%>
                        <%--<div class="tax-item unpaid">--%>
                            <%--<div class="content">--%>
                                <%--<p class="tax-time">时间：2018年</p>--%>
                                <%--<p class="tax-type">税种：个人所得税</p>--%>
                                <%--<p class="tax-should">应缴：2，000，000</p>--%>
                                <%--<p class="tax-pay">实缴：1，000，000</p>--%>
                                <%--<p class="tax-state">状态：欠费</p>--%>
                                <%--<img src="/statics/img/down.png">--%>
                            <%--</div>--%>
                            <%--<div class="detail" style="display: none;">--%>
                                <%--<img src="/statics/img/up-arrow.png" />--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="tax-item">--%>
                            <%--<div class="content">--%>
                                <%--<p class="tax-time">时间：2018年</p>--%>
                                <%--<p class="tax-type">税种：个人所得税</p>--%>
                                <%--<p class="tax-should">应缴：2，000，000</p>--%>
                                <%--<p class="tax-pay">实缴：2，000，000</p>--%>
                                <%--<p class="tax-state">状态：已缴清</p>--%>
                                <%--<img src="/statics/img/down.png">--%>
                            <%--</div>--%>
                            <%--<div class="detail" style="display: none;">--%>
                                <%--<img src="/statics/img/up-arrow.png" />--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="tax-item">--%>
                            <%--<div class="content">--%>
                                <%--<p class="tax-time">时间：2018年</p>--%>
                                <%--<p class="tax-type">税种：个人所得税</p>--%>
                                <%--<p class="tax-should">应缴：2，000，000</p>--%>
                                <%--<p class="tax-pay">实缴：2，000，000</p>--%>
                                <%--<p class="tax-state">状态：已缴清</p>--%>
                                <%--<img src="/statics/img/down.png">--%>
                            <%--</div>--%>
                            <%--<div class="detail" style="display: none;">--%>
                                <%--<img src="/statics/img/up-arrow.png" />--%>
                                <%--<div class="detail-item">--%>
                                    <%--<p class="detail-time">时间：2018年</p>--%>
                                    <%--<p class="detail-should">应缴：2，000，000</p>--%>
                                    <%--<p class="detail-pay">实缴：2，000，000</p>--%>
                                    <%--<p class="detail-state">状态：已缴清</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    </div>
                </div>
                <div class="tab-pane fade" id="invariantRecord-box">
                </div>

            </div>

        </div>
    </div>
</div>

</body>
<script>
    $(".content").on("click", function() {
        $(this).siblings(".detail").fadeToggle(500);
        if($(this).find("img").attr("src") == "/statics/img/down.png") {
            $(this).find("img").attr("src", "/statics/img/up.png");
        } else {
            $(this).find("img").attr("src", "/statics/img/down.png");
        };
    })
    $(".language").on("click", function() {
        translate();
    })

    //切换筛选条件
    $("#filter-choose").on("click", function() {
        $("#all").removeClass("choosed");
        $(this).addClass("choosed");
        $("form").removeClass("coverd");
        $(".cover").hide();
    })
    $("#all").on("click", function() {
        $(this).addClass("choosed");
        $("#filter-choose").removeClass("choosed");
        $("form").addClass("coverd");
        $(".cover").show();
    })
</script>
