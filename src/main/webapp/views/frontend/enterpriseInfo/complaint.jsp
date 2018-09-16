<%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2018/9/15
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="行业分类" />
    <link href="/dist/css/button-style.css" rel="stylesheet" />
    <link href="/statics/css/complaint.css" rel="stylesheet" />
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
        <p class="big-title">xxx公司涉诉情况</p>
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
                            <a href="/frontend/enterpriseInfo/taxSituation" class="three-d"> 纳税情况 <span class="three-d-box"><span class="front">纳税情况</span><span class="back">纳税情况</span></span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="three-d"> 涉诉情况 <span class="three-d-box"><span class="front">涉诉情况</span><span class="back">涉诉情况</span></span>
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
        <!--涉诉情况-->
        <!------------>
        <div id="complaint">
            <p class="tab-title">涉诉情况</p>

            <c:forEach items="${compLawsuitList}" var="item" varStatus="status">
                ${item.postingComp}
               刊登日期： ${item.postingDate}
                公告类型：${item.postingType}
                公告人： ${item.postingPeople}
            </c:forEach>
            <%--<div class="complaint-item">--%>
                <%--<p class="time">时间：2016年06月24日</p>--%>
                <%--<p class="state">状态：已解决</p>--%>
                <%--<p class="reason">原因：公司经营不善，拖欠民工工资。公司管理层受贿，在与政府合作的项目中偷工减料。</p>--%>
            <%--</div>--%>
            <%--<div class="split"></div>--%>
            <%--<div class="complaint-item">--%>
                <%--<p class="time">时间：2016年06月24日</p>--%>
                <%--<p class="state">状态：已解决</p>--%>
                <%--<p class="reason">原因：公司经营不善，拖欠民工工资。公司管理层受贿，在与政府合作的项目中偷工减料。</p>--%>
            <%--</div>--%>
            <div class="split"></div>
        </div>
    </div>
</div>

</body>
<script>
    $(".language").on("click", function() {
        translate();
    })

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
