<%--
  Created by IntelliJ IDEA.
  User: coldilock
  Date: 2018/9/14
  Time: 00:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl标签库--%>
<%@include file="/views/include/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="description" content="行业分类"/>
    <link href="/dist/css/button-style.css" rel="stylesheet"/>
    <link href="/statics/css/enterpriseWater.css" rel="stylesheet"/>
    <link href="/statics/css/listStyle.css" rel="stylesheet"/>
    <link href="/statics/css/tabStyle.css" rel="stylesheet"/>
    <link rel="icon" type="image/x-icon" href="/statics/img/logo01.png"/>
    <link href="/dist/bookstrap/css/bootstrap.css" rel="stylesheet">
    <script src="/dist/js/jquery-3.3.1.js"></script>
    <script src="/dist/js/button-style.js"></script>
    <script src="/dist/bookstrap/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="/statics/css/component.css"/>

    <script type="text/javascript" src="/statics/js/translation.js"></script>


    <title>微助贷-企业信息</title>
</head>

<body>
<div class="bg">
    <img src="/statics/img/indexBg.png"/>
</div>
<nav class="navbar navbar-inverse" role="navigation">

    <div class="navbar-header">
        <img src="/statics/img/logo01.png"/>
        <P class="navbar-brand" href="index.html">微助贷</P>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="li-item">
                <a href="/frontend/center/index">
                    <p class="main-style">首页</p>
                </a>
            </li>
            <li class="li-item active">
                <a href="/frontend/center/industryCategory">
                    <p class="main-style">行业分类</p>
                </a>
            </li>

            <li class="li-item">
                <a href="/frontend/login/index">
                    <p class="main-style">退出登录</p>
                </a>
            </li>
            <li class="line"></li>
            <li class="language chinese">
                <img class="rkmd-btn btn-fab-mini btn-pink ripple-effect" src="/statics/img/english.png"/>
            </li>
        </ul>
    </div>
</nav>
<div class="main-container">
    <div class="title">
        <p class="big-title">${companyType.companyName}企业流水</p>
        <p class="small-title">————${companyType.companyType}</p>
    </div>
    <section class="nav-box">
        <div id="nav">
            <ul class="nav-menu clearfix unstyled">
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/index?companyId=${companyType.companyId}" class="three-d "> 企业资料 <span class="three-d-box"><span
                            class="front">企业资料</span><span class="back">企业资料</span></span>
                    </a>
                    <ul class="clearfix unstyled drop-menu">
                        <li>
                            <a href="/frontend/enterpriseInfo/index?companyId=${companyType.companyId}" class="three-d"> 基本信息 <span
                                    class="three-d-box"><span class="front">基本信息</span><span
                                    class="back">基本信息</span></span>
                            </a>
                        </li>
                        <li>
                            <a href="/frontend/enterpriseInfo/taxSituation?companyId=${companyType.companyId}" class="three-d"> 纳税情况 <span class="three-d-box"><span
                                    class="front">纳税情况</span><span class="back">纳税情况</span></span>
                            </a>
                        </li>
                        <li>
                            <a href="/frontend/enterpriseInfo/complaint?companyId=${companyType.companyId}" class="three-d"> 涉诉情况 <span class="three-d-box"><span
                                    class="front">涉诉情况</span><span class="back">涉诉情况</span></span>
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="firstLayer">
                    <a href="#" class="three-d"> 企业流水 <span class="three-d-box"><span class="front">企业流水</span><span
                            class="back">企业流水</span></span>
                    </a>

                </li>
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/companyLoan?companyId=${companyType.companyId}" class="three-d "> 企业信用 <span
                            class="three-d-box"><span class="front"> 企业信用</span><span class="back">企业信用</span></span>
                    </a>
                </li>
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/companyFinance?companyId=${companyType.companyId}" class="three-d "> 财务信息<span class="three-d-box"><span class="front">财务信息</span><span
                            class="back">财务信息</span></span>
                    </a>
                </li>
            </ul>
        </div>
    </section>
    <div class="main-box">

        <!------------>
        <!--企业流水-->
        <!------------>
        <div id="waterBill">
            <p class="tab-title">企业流水</p>
            <div class="filter-box">
                <div class="order">
                    <p>顺序：</p>
                    <div class="timeUp " id="timeUp">
                        <div class="filter-item"></div>
                        <p>时间升序</p>
                    </div>
                    <div class="timeDown choosed" id="timeDown">
                        <div class="filter-item"></div>
                        <p>时间降序</p>
                    </div>
                </div>
            </div>
            <div class="split"></div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>
                        <p>时间</p>
                    </th>
                    <th>
                        <p>交易方</p>
                    </th>
                    <th>
                        <p>交易金额</p>
                    </th>
                    <th>
                        <p>&nbsp;</p>
                    </th>
                </tr>
                </thead>
                <tbody id="timedown-item">
                <c:set var="startIndex" value="${fn:length(flowList)-1 }"></c:set>
                <c:forEach items="${flowList}" var="t"  varStatus="status">
                    <tr class="mainPartner-status-${flowList[startIndex - status.index].mainPartner}">
                        <td><p><fmt:formatDate value='${flowList[startIndex - status.index].operateTime}' pattern='yyyy-MM-dd'/></p></td>
                        <td><p>${flowList[startIndex - status.index].transactionPart}有限公司</p></td>
                        <td><p>${flowList[startIndex - status.index].operateType}：¥<fmt:formatNumber value="${flowList[startIndex - status.index].amount}" pattern="#,#00.0#"/> </p></td>
                        <td>
                            <a class="md-trigger"><p>查看详情</p></a>
                            <div class="md-modal md-effect-5">
                                <div class="md-content">
                                    <h3>交易明细</h3>
                                    <div>
                                        <ul>
                                            <li><strong>交易编号：</strong> ${flowList[startIndex - status.index].flowNo}</li>
                                            <li><strong>交易金额：</strong> ¥<fmt:formatNumber value="${flowList[startIndex - status.index].amount}" pattern="#,#00.0#"/></li>
                                            <li><strong>金额大写：</strong> 贰万元整</li>
                                            <li><strong>交易时间：</strong> <fmt:formatDate value='${flowList[startIndex - status.index].operateTime}' pattern='yyyy-MM-dd'/></li>
                                            <li><strong>受理银行：</strong> ${flowList[startIndex - status.index].bank}</li>
                                            <li><strong>收款方：</strong> ${flowList[startIndex - status.index].transactionPart}</li>
                                            <li><strong>用途：</strong> 无</li>
                                            <li><strong>备注：</strong> 无</li>
                                        </ul>
                                        <!--<button class="md-close">Close me!</button>-->
                                    </div>
                                </div>
                            </div>
                            <div class="md-overlay" style="z-index: 999;"></div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tbody id="timeup-item" style="display: none">
                <c:forEach items="${flowList}" var="t" varStatus="status">
                    <tr class="mainPartner-status-${t.mainPartner}">
                        <td><p><fmt:formatDate value='${t.operateTime}' pattern='yyyy-MM-dd'/></p></td>
                        <td><p>${t.transactionPart}有限公司</p></td>
                        <td><p>${t.operateType}：¥<fmt:formatNumber value="${t.amount}" pattern="#,#00.0#"/> </p></td>
                        <td>
                            <a class="md-trigger"><p>查看详情</p></a>
                            <div class="md-modal md-effect-5">
                                <div class="md-content">
                                    <h3>交易明细</h3>
                                    <div>
                                        <ul>
                                            <li><strong>交易编号：</strong> ${t.flowNo}</li>
                                            <li><strong>交易金额：</strong> ¥<fmt:formatNumber value="${t.amount}" pattern="#,#00.0#"/></li>
                                            <li><strong>金额大写：</strong> 贰万元整</li>
                                            <li><strong>交易时间：</strong> <fmt:formatDate value='${t.operateTime}' pattern='yyyy-MM-dd'/></li>
                                            <li><strong>受理银行：</strong> ${t.bank}</li>
                                            <li><strong>收款方：</strong> ${t.transactionPart}</li>
                                            <li><strong>用途：</strong> 无</li>
                                            <li><strong>备注：</strong> 无</li>
                                        </ul>
                                        <!--<button class="md-close">Close me!</button>-->
                                    </div>
                                </div>
                            </div>
                            <div class="md-overlay" style="z-index: 999;"></div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>
<script src="/statics/js/classie.js"></script>
<script src="/statics/js/modalEffects.js"></script>
</body>
<script>
    //		切换语言
    $(".language").on("click", function () {
        translate();
    })

    //切换筛选条件
    $("#mainBusiness").on("click", function () {
        var $mainPartner = $('.mainPartner-status-0');
        $mainPartner.each(function() {
            $(this).hide();
        });
        $("#all").removeClass("choosed");
        $(this).addClass("choosed");
        $(".cover").show();
        $("form").addClass("coverd");
    })
    $("#all").on("click", function () {
        var $mainPartner = $('.mainPartner-status-0');
        $mainPartner.each(function() {
            $(this).show();
        });
        $(this).addClass("choosed");
        $("#mainBusiness").removeClass("choosed");
        $(".cover").hide();
        $("form").removeClass("coverd");
    })
    $("#timeUp").on("click", function () {
        $("#timeDown").removeClass("choosed");
        $(this).addClass("choosed");
        $("#timedown-item").hide();
        $("#timeup-item").show();
    })
    $("#timeDown").on("click", function () {
        $(this).addClass("choosed");
        $("#timeUp").removeClass("choosed");
        $("#timeup-item").hide();
        $("#timedown-item").show();
    })

    // function showDetail(e) {
    //     var id = $(e).data("id");
    //     var $results = $('.md-content')
    //
    //     $results.each(function () {
    //         $(this).css('display', 'block');
    //         if (!$(this).data("id") == id) {
    //             $(this).css('display', 'none');
    //         }
    //     });
    // }
</script>

</html>
