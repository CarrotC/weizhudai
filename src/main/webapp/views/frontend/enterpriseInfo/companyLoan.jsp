<%--
  Created by IntelliJ IDEA.
  User: coldilock
  Date: 2018/9/14
  Time: 01:07
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
    <link href="/statics/css/enterpriseCredit.css" rel="stylesheet" />
    <link href="/statics/css/listStyle.css" rel="stylesheet" />
    <link href="/statics/css/tabStyle.css" rel="stylesheet" />
    <link rel="icon" type="image/x-icon" href="/statics/img/logo01.png" />
    <link href="/dist/bookstrap/css/bootstrap.css" rel="stylesheet">
    <script src="/dist/js/jquery-3.3.1.js"></script>
    <script src="/dist/js/button-style.js"></script>
    <script src="/dist/bookstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/statics/css/component.css" />
    <script type="text/javascript" src="/dist/chart/jqplot.js"></script>
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
                <img class="rkmd-btn btn-fab-mini btn-pink ripple-effect" src="/statics/img/english.png" />
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
                    <a href="/frontend/center/index" class="three-d "> 企业资料 <span class="three-d-box"><span class="front">企业资料</span><span class="back">企业资料</span></span>
                    </a>
                    <ul class="clearfix unstyled drop-menu">
                        <li>
                            <a href="/frontend/center/index" class="three-d"> 基本信息 <span class="three-d-box"><span class="front">基本信息</span><span class="back">基本信息</span></span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="three-d"> 纳税情况 <span class="three-d-box"><span class="front">纳税情况</span><span class="back">纳税情况</span></span>
                            </a>
                        </li>
                        <li>
                            <a href="complaint.html" class="three-d"> 涉诉情况 <span class="three-d-box"><span class="front">涉诉情况</span><span class="back">涉诉情况</span></span>
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/companyFlow?companyId=${companyType.companyId}" class="three-d"> 企业流水 <span class="three-d-box"><span class="front">企业流水</span><span class="back">企业流水</span></span>
                    </a>

                </li>
                <li class="firstLayer">
                    <a href="#" class="three-d "> 企业信用 <span class="three-d-box"><span class="front"> 企业信用</span><span class="back">企业信用</span></span>
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

        <div id="byCondition-box">
            <p class="tab-title">企业信用</p>
            <div class="filter-box">
                <div class="type">
                    <p>分类：</p>
                    <div class="all choosed" id="all">
                        <div class="filter-item" id="all-button"></div>
                        <p>全部</p>
                    </div>
                    <div class="mainBusiness" id="mainBusiness">
                        <div class="filter-item" id="main-button"></div>
                        <p>筛选</p>
                    </div>
                </div>
                <form class="coverd formCover">
                    <div class="cover"></div>
                    <div class="state">
                        <p>还款情况：</p>
                        <select class="form-control" id="type-select" style="background-color: rgb(100,100,100);border: rgb(55,55,55);color: rgb(240,240,240);">
                            <option>负债中</option>
                            <option>按时还款</option>
                            <option>已还清不良记录</option>
                            <option>未还清不良记录</option>
                        </select>
                    </div>
                </form>
                <div class="order">
                    <p>顺序：</p>
                    <div class="timeUp" id="timeUp">
                        <div class="filter-item" id="timeUp-button"></div>
                        <p>时间升序</p>
                    </div>
                    <div class="timeDown  choosed" id="timeDown">
                        <div class="filter-item" id="timeDown-button"></div>
                        <p>时间降序</p>
                    </div>
                </div>



            </div>
            <div class="split"></div>
            <div class="inner">
                <div class="conclusion">
                    <p>还款次数：${payList.size()}次</p>
                    <p>还款金额：¥<fmt:formatNumber value="${payAmount}" pattern="#,#00.0#"/></p>
                    <p>贷款次数：${loanList.size()}次</p>
                    <p>贷款金额：¥<fmt:formatNumber value="${loanAmount}" pattern="#,#00.0#"/></p>
                    <p>拖欠次数：${delayCount}次</p>
                    <p>拖欠金额：¥<fmt:formatNumber value="${delayAmount}" pattern="#,#00.0#"/></p>
                </div>
                <div class="split"></div>
                <div class="credit-down">
                    <c:set var="startIndex" value="${fn:length(loanList)-1 }"></c:set>
                    <c:forEach items="${loanList}" var="t"  varStatus="status">
                        <div class="credit-item credit-status-${loanList[startIndex - status.index].statusIndex}" >
                            <p class="item-title"><strong>借贷记录:</strong></p>
                            <div class="left-box">
                                <p>贷款时间：<fmt:formatDate value='${loanList[startIndex - status.index].operateDate}' pattern='yyyy/MM/dd'/></p>
                                <p>融资利率：${loanList[startIndex - status.index].interestRate*100}%</p>
                                <p>融资金额：¥<fmt:formatNumber value="${loanList[startIndex - status.index].amount}" pattern="#,#00.0#"/></p>
                                <p>融资提供人：${loanList[startIndex - status.index].bank}</p>
                            </div>
                            <p class="credit-state">状态：${loanList[startIndex - status.index].status}</p>
                            <button class="md-trigger detail rkmd-btn btn-flat ripple-effect">查看借贷详情</button>
                            <div class="md-modal md-effect-5">
                                <div class="md-content">
                                    <h3>借贷详情</h3>
                                    <div>
                                        <ul>
                                            <li><strong>贷款时间：</strong> <fmt:formatDate value='${loanList[startIndex - status.index].operateDate}' pattern='yyyy/MM/dd'/></li>
                                            <li><strong>融资金额：</strong> ¥<fmt:formatNumber value="${loanList[startIndex - status.index].amount}" pattern="#,#00.0#"/></li>
                                            <li><strong>融资利率：</strong> ${loanList[startIndex - status.index].interestRate*100}%</li>
                                            <li><strong>融资提供人：</strong> ${loanList[startIndex - status.index].bank}</li>
                                            <li><strong>担保信息：</strong></li>
                                            <li style="text-indent: 50px;"><strong>担保人信用评级：</strong> ${loanList[startIndex - status.index].guarantorCreditRating}</li>
                                            <li style="text-indent: 50px;"><strong>质押抵押品价值：</strong> ¥<fmt:formatNumber value="${loanList[startIndex - status.index].hostagePrice}" pattern="#,#00.0#"/></li>
                                            <li><strong>状态变化：</strong> </li>
                                            <li style="text-indent: 50px;"><strong>贷还款情况：</strong> ${loanList[startIndex - status.index].status}</li>
                                            <li style="text-indent: 50px;"><strong>信用评级：</strong> ${loanList[startIndex - status.index].creditRating}</li>
                                            <li style="text-indent: 50px;"><strong>授信额度：</strong> ¥<fmt:formatNumber value="${loanList[startIndex - status.index].creditLine}" pattern="#,#00.0#"/></li>
                                        </ul>
                                        <!--<button class="md-close">Close me!</button>-->
                                    </div>
                                </div>
                            </div>
                            <div class="md-overlay" style="z-index: 999;"></div>
                        </div>
                        <div class="split"></div>
                    </c:forEach>
                </div>
                <div class="credit-up" style="display: none">
                    <c:forEach items="${loanList}" var="t" varStatus="status">
                        <div class="credit-item" credit-status-${t.statusIndex}>
                            <p class="item-title"><strong>借贷记录:</strong></p>
                            <div class="left-box">
                                <p>贷款时间：<fmt:formatDate value='${t.operateDate}' pattern='yyyy/MM/dd'/></p>
                                <p>融资利率：${t.interestRate*100}%</p>
                                <p>融资金额：¥<fmt:formatNumber value="${t.amount}" pattern="#,#00.0#"/></p>
                                <p>融资提供人：${t.bank}</p>
                            </div>
                            <p class="credit-state">状态：${t.status}</p>
                            <button class="md-trigger detail rkmd-btn btn-flat ripple-effect">查看借贷详情</button>
                            <div class="md-modal md-effect-5">
                                <div class="md-content">
                                    <h3>借贷详情</h3>
                                    <div>
                                        <ul>
                                            <li><strong>贷款时间：</strong> <fmt:formatDate value='${t.operateDate}' pattern='yyyy/MM/dd'/></li>
                                            <li><strong>融资金额：</strong> ¥<fmt:formatNumber value="${t.amount}" pattern="#,#00.0#"/></li>
                                            <li><strong>融资利率：</strong> ${t.interestRate*100}%</li>
                                            <li><strong>融资提供人：</strong> ${t.bank}</li>
                                            <li><strong>担保信息：</strong></li>
                                            <li style="text-indent: 50px;"><strong>担保人信用评级：</strong> ${t.guarantorCreditRating}</li>
                                            <li style="text-indent: 50px;"><strong>质押抵押品价值：</strong> ¥<fmt:formatNumber value="${t.hostagePrice}" pattern="#,#00.0#"/></li>
                                            <li><strong>状态变化：</strong> </li>
                                            <li style="text-indent: 50px;"><strong>贷还款情况：</strong> ${t.status}</li>
                                            <li style="text-indent: 50px;"><strong>信用评级：</strong> ${t.creditRating}</li>
                                            <li style="text-indent: 50px;"><strong>授信额度：</strong> ¥<fmt:formatNumber value="${t.creditLine}" pattern="#,#00.0#"/></li>
                                        </ul>
                                        <!--<button class="md-close">Close me!</button>-->
                                    </div>
                                </div>
                            </div>
                            <div class="md-overlay" style="z-index: 999;"></div>
                        </div>
                        <div class="split"></div>
                    </c:forEach>
                </div>


            </div>
        </div>


    </div>
</div>
<script src="/statics/js/classie.js"></script>
<script src="/statics/js/modalEffects.js"></script>

</body>
<script>
    $(".lineOfCredit a").on("click", function() {
        $("#chart").remove();
        $(".ratingPast").hide();
        $(".linePast").hide();
        $(this).parents(".top-info").siblings(".linePast").find("img").after("<div id='chart' style='width:320px;height:250px;'></div>");
        $(this).parents(".top-info").siblings(".linePast").fadeToggle(500);
        addChart();

    })
    $(".creditRating a").on("click", function() {
        $("#chart").remove();
        $(".ratingPast").hide();
        $(".linePast").hide();
        $(this).parents(".top-info").siblings(".ratingPast").find("img").after("<div id='chart' style='width:320px;height:250px;'></div>");
        $(this).parents(".top-info").siblings(".ratingPast").fadeToggle(500);
        addChart();
//			if($(this).parents(".top-info").siblings(".ratingPast").is(':hidden')) {
//				$(this).parents(".top-info").siblings(".ratingPast").find("img").after("<div id='chart' style='width:320px;height:250px;'></div>")
//			}
//			if($(this).parents(".top-info").siblings(".linePast").is(':hidden')) {
//				$(this).parents(".top-info").siblings(".ratingPast").fadeToggle(500);
//			} else {
//				$(this).parents(".top-info").siblings(".linePast").hide();
//				$(this).parents(".top-info").siblings(".ratingPast").fadeToggle(500);
//			}

    })
    //切换筛选条件
    $("#mainBusiness").on("click", function() {
        $("#all").removeClass("choosed");
        $(this).addClass("choosed");
        $("form").removeClass("coverd");
        $(".cover").hide();
    })
    $("#all").on("click", function() {
        var $allResult = $('.credit-item');
        $allResult.each(function() {
            $(this).show();
        });
        $(this).addClass("choosed");
        $("#mainBusiness").removeClass("choosed");
        $("form").addClass("coverd");
        $(".cover").show();
    })
    $("#timeUp").on("click", function() {
        $("#timeDown").removeClass("choosed");
        $(this).addClass("choosed");
        $(".credit-down").hide();
        $(".credit-up").show();
    })
    $("#timeDown").on("click", function() {
        $(this).addClass("choosed");
        $("#timeUp").removeClass("choosed");
        $(".credit-up").hide();
        $(".credit-down").show();
    })
    //		切换语言
    $(".language").on("click", function() {
        translate();
    })

    function addChart() {
        var data = [
            [37, 60, 82, 91, 51, 42]
        ];
        var data_max = 100; //Y轴最大刻度
        var line_title = ["A", "B"]; //曲线名称
//			var y_label = "授信额度"; //Y轴标题
//			var x_label = "时间"; //X轴标题
        var x = [2013, 2014, 2015, 2016, 2017, 2018]; //定义X轴刻度值
        j.jqplot.diagram.base("chart", data, line_title, "", x, "", "", data_max, 1);

    }

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


    $(document).ready(function(){
        $("#type-select").change(function(){
            var selectOption =$(this).children('option:selected').val();//这就是selected的值

            var $allResult = $('.credit-item');
            $allResult.each(function() {
                $(this).show();
            });

            switch (selectOption){
                case '负债中':
                    var $allResult = $('.credit-item');
                    $allResult.each(function() {
                        $(this).hide();
                    });
                    var $result = $('.credit-status-0');
                    $result.each(function() {
                        $(this).show();
                    });
                    break;
                case '按时还款':
                    var $allResult = $('.credit-item');
                    $allResult.each(function() {
                        $(this).hide();
                    });
                    var $result = $('.credit-status-1');
                    $result.each(function() {
                        $(this).show();
                    });
                    break;
                case '已还清不良记录':
                    var $allResult = $('.credit-item');
                    $allResult.each(function() {
                        $(this).hide();
                    });
                    var $result = $('.credit-status-2');
                    $result.each(function() {
                        $(this).show();
                    });
                    break;
                case '未还清不良记录':
                    var $allResult = $('.credit-item');
                    $allResult.each(function() {
                        $(this).hide();
                    });
                    var $result = $('.credit-status-3');
                    $result.each(function() {
                        $(this).show();
                    });
                    break;
            }
        })
    })


</script>

</html>
