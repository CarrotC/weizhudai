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
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="行业分类" />
    <link href="/dist/css/button-style.css" rel="stylesheet" />
    <link href="/statics/css/enterpriseWater.css" rel="stylesheet" />
    <link href="/statics/css/listStyle.css" rel="stylesheet" />
    <link href="/statics/css/tabStyle.css" rel="stylesheet" />
    <link rel="icon" type="image/x-icon" href="/statics/img/logo01.png" />
    <link href="/dist/bookstrap/css/bootstrap.css" rel="stylesheet">
    <script src="/dist/js/jquery-3.3.1.js"></script>
    <script src="/dist/js/button-style.js"></script>
    <script src="/dist/bookstrap/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="/statics/css/component.css" />

    <script type="text/javascript" src="/statics/js/translation.js"></script>


    <title>微助贷-企业信息</title>
</head>

<body>
<div class="md-modal md-effect-5" id="modal">
    <c:forEach items="${flowList}" var="t" varStatus="status">
        <div class="md-content" data-id="${status.index}">
            <h3>交易明细</h3>
            <div>
                <ul>
                    <li><strong>交易编号：</strong> ${t.flowNo}</li>
                    <li><strong>交易金额：</strong> ￥${t.amount}元</li>
                    <li><strong>金额大写：</strong> 贰万元整</li>
                    <li><strong>交易时间：</strong> 2018年8月28日</li>
                    <li><strong>受理银行：</strong> ${t.bank}</li>
                    <li><strong>收款方：</strong> ${t.firmId}</li>
                    <li><strong>用途：</strong> 无</li>
                    <li><strong>备注：</strong> 无</li>
                </ul>
                <!--<button class="md-close">Close me!</button>-->
            </div>
        </div>
    </c:forEach>
</div>
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
                <a href="index.html">首页</a>
            </li>
            <li class="li-item active">
                <a href="classification.html">行业分类</a>
            </li>

            <li class="li-item">
                <a href="login.html">退出登录</a>
            </li>
            <li class="line"></li>
            <li class="language chinese">
                <img class="rkmd-btn btn-fab-mini btn-pink ripple-effect" src="/statics/img/chinese.png" />
            </li>
        </ul>
    </div>
</nav>
<div class="main-container">
    <div class="title">
        <p class="big-title">${companyType.companyName}近期财务数据</p>
        <p class="small-title">————${companyType.companyType}</p>
    </div>
    <section class="nav-box">
        <div id="nav">
            <ul class="nav-menu clearfix unstyled">
                <li class="firstLayer">
                    <a href="basicInfo.html" class="three-d "> 企业资料 <span class="three-d-box"><span class="front">企业资料</span><span class="back">企业资料</span></span>
                    </a>
                    <ul class="clearfix unstyled drop-menu">
                        <li>
                            <a href="basicInfo.html" class="three-d"> 基本信息 <span class="three-d-box"><span class="front">基本信息</span><span class="back">基本信息</span></span>
                            </a>
                        </li>
                        <li>
                            <a href="taxSituation.html" class="three-d"> 纳税情况 <span class="three-d-box"><span class="front">纳税情况</span><span class="back">纳税情况</span></span>
                            </a>
                        </li>
                        <li>
                            <a href="companyInfo.html" class="three-d"> 涉诉情况 <span class="three-d-box"><span class="front">涉诉情况</span><span class="back">涉诉情况</span></span>
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="firstLayer">
                    <a href="#" class="three-d"> 企业流水 <span class="three-d-box"><span class="front">企业流水</span><span class="back">企业流水</span></span>
                    </a>

                </li>
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/companyLoan?companyId=${companyType.companyId}" class="three-d "> 企业信用 <span class="three-d-box"><span class="front"> 企业信用</span><span class="back">企业信用</span></span>
                    </a>
                </li>
                <li class="firstLayer">
                    <a href="financialInfo.html" class="three-d "> 财务信息<span class="three-d-box"><span class="front">财务信息</span><span class="back">财务信息</span></span>
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
                <div class="type">
                    <p>分类：</p>
                    <div class="all choosed" id="all">
                        <div class="filter-item" id="all-button"></div>
                        <p>全部</p>
                    </div>
                    <div class="mainBusiness" id="mainBusiness">
                        <div class="filter-item" id="main-button"></div>
                        <p>主要业务</p>
                    </div>
                </div>
                <form>
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
                        <p style="width: auto;">月</p>
                    </div>
                </form>
                <div class="order">
                    <p>顺序：</p>
                    <div class="timeUp choosed" id="timeUp">
                        <div class="filter-item" id="timeUp-button"></div>
                        <p>时间升序</p>
                    </div>
                    <div class="timeDown" id="timeDown">
                        <div class="filter-item" id="timeDown-button"></div>
                        <p>时间降序</p>
                    </div>
                </div>
            </div>
            <div class="split"></div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>时间</th>
                    <th>交易方</th>
                    <th>交易金额</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${flowList}" var="t" varStatus="status">
                    <tr>
                            <%--<td>${t.operateTime}</td>--%>
                        <td>2018.09.14</td>
                        <td>${t.firmId}有限公司</td>
                        <td>${t.operateType}：￥${t.amount}元</td>
                        <td><a class="md-trigger" onclick="showDetail(this)" data-id="${status.index}">查看详情</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>
<div class="md-overlay" style="z-index: 999;"></div>
<script src="/statics/js/classie.js"></script>
<script src="/statics/js/modalEffects.js"></script>
</body>
<script>
    //		切换语言
    $(".language").on("click", function() {
        if($(this).hasClass("chinese")) {
            //换成英文
            $(this).addClass("english");
            $(this).removeClass("chinese");
            $(".language img").attr("src", "/statics/img/english.png");
            translate();
        } else {
            $(this).removeClass("english");
            $(this).addClass("chinese");
            $(".language img").attr("src", "/statics/img/chinese.png")
        }
    })

    //切换筛选条件
    $("#mainBusiness").on("click", function() {
        $("#all").removeClass("choosed");
        $(this).addClass("choosed");
    })
    $("#all").on("click", function() {
        $(this).addClass("choosed");
        $("#mainBusiness").removeClass("choosed");
    })
    $("#timeUp").on("click", function() {
        $("#timeDown").removeClass("choosed");
        $(this).addClass("choosed");
    })
    $("#timeDown").on("click", function() {
        $(this).addClass("choosed");
        $("#timeUp").removeClass("choosed");
    })

    function showDetail(e){
        var id = $(e).data("id");
        var $results = $('.md-content')

        $results.each(function () {
            $(this).css('display','block');
            if(!$(this).data("id") == id){
                $(this).css('display','none');
            }
        });
    }
</script>

</html>