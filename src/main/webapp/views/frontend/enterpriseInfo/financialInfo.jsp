<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2018/9/15
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="行业分类" />
    <link href="/dist/css/button-style.css" rel="stylesheet" />
    <link href="/statics/css/financialInfo.css" rel="stylesheet" />
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

    <title>微助贷-财务信息</title>
</head>

<body>
<div class="bg">
    <img src="/statics/img/indexBg.png" />
</div>
<nav class="navbar navbar-inverse" role="navigation">

    <div class="navbar-header">
        <img src="/statics/img/logo01.png" />
        <P class="navbar-brand">微助贷</P>
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
        <p class="big-title">xxx财务信息</p>
        <p class="small-title">————XXX行业</p>
    </div>
    <section class="nav-box">
        <div id="nav">
            <ul class="nav-menu clearfix unstyled">
                <li class="firstLayer">
                    <a href="/frontend/enterpriseInfo/index?companyId=${}" class="three-d "> 企业资料 <span class="three-d-box"><span class="front">企业资料</span><span class="back">企业资料</span></span>
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
                    <a href="#" class="three-d "> 财务信息<span class="three-d-box"><span class="front">财务信息</span><span class="back">财务信息</span></span>
                    </a>
                </li>
            </ul>
        </div>
    </section>
    <div class="main-box">
        <!------------>
        <!--财务信息-->
        <!------------>
        <div id="finance">
            <p class="tab-title">财务信息</p>
            <ul class="nav nav-tabs">
                <li id="realization" class="active">
                    <a class="aTab" href="#realization-box" data-toggle="tab">
                        <p style="margin: 0;">变现能力</p>
                    </a>
                </li>
                <li id="fundManagement">
                    <a class="aTab" href="#fundManagement-box" data-toggle="tab">
                        <p style="margin: 0;">资产管理比率</p>
                    </a>
                </li>
                <li id="debt">
                    <a class="aTab" href="#debt-box" data-toggle="tab">
                        <p style="margin: 0;">负债比率</p>
                    </a>
                </li>
                <li id="profit">
                    <a class="aTab" href="#profit-box" data-toggle="tab">
                        <p style="margin: 0;">盈利能力比率</p>
                    </a>
                </li>
                <li id="cashFlow">
                    <a class="aTab" href="#cashFlow-box" data-toggle="tab">
                        <p style="margin: 0;">现金流量比率</p>
                    </a>
                </li>
                <li id="obtainCash">
                    <a class="aTab" href="#obtainCash-box" data-toggle="tab">
                        <p style="margin: 0;">获现能力</p>
                    </a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane fade in active" id="realization-box">
                    <div class="inner-item" id="currentRatio">
                        <div class="chart" id='currentRatioChart'></div>
                        <div class="inner-table">
                            <table class="table table-striped">
                                <caption>流动比率</caption>
                                <thead>
                                <tr>
                                    <th>年份</th>
                                    <c:forEach items= "${currentRatios[0]}" var="i" varStatus="status">
                                        <th>${i}</th>
                                    </c:forEach>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>变现能力</td>
                                    <c:forEach items= "${currentRatios[1]}" var="i" varStatus="status">
                                        <td>${i}</td>
                                    </c:forEach>
                                </tr>
                                </tbody>
                            </table>
                            <p>行业平均值：${averCurrentRatio}</p>
                        </div>
                        <button class="md-trigger explain rkmd-btn ripple-effect"><p style="margin:0">查看详细信息</p></button>
                        <div class="md-modal md-effect-5">
                            <div class="md-content">
                                <h3>借贷详情</h3>
                                <div>
                                    <ul>
                                        <li><strong>贷款时间：</strong> 2022年7月26日</li>
                                        <li><strong>融资金额：</strong> 1,000,000元</li>
                                        <li><strong>融资利率：</strong> 0.02%</li>
                                        <li><strong>融资提供人：</strong> xxx银行</li>
                                        <li><strong>担保信息：</strong></li>
                                        <li style="text-indent: 50px;"><strong>担保人信用评级：</strong> 3级</li>
                                        <li style="text-indent: 50px;"><strong>质押抵押品价值：</strong> 2,000,000元</li>
                                        <li><strong>状态变化：</strong> </li>
                                        <li style="text-indent: 50px;"><strong>贷还款情况：</strong> 待还款</li>
                                        <li style="text-indent: 50px;"><strong>信用评级：</strong> 低</li>
                                        <li style="text-indent: 50px;"><strong>授信额度：</strong> 70</li>
                                    </ul>
                                    <!--<button class="md-close">Close me!</button>-->
                                </div>
                            </div>
                        </div>
                        <div class="md-overlay" style="z-index: 999;"></div>
                    </div>
                    <div class="inner-item" id="speedRatio">
                        <div class="chart" id='speedRatioChart'></div>
                        <div class="inner-table">
                            <table class="table table-striped">
                                <caption>速动比率</caption>
                                <thead>
                                <tr>
                                    <th>年份</th>
                                    <c:forEach items= "${quickRatios[0]}" var="i" varStatus="status">
                                        <th>${i}</th>
                                    </c:forEach>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>变现能力</td>
                                    <c:forEach items= "${quickRatios[1]}" var="i" varStatus="status">
                                        <td>${i}</td>
                                    </c:forEach>
                                </tr>
                                </tbody>
                            </table>
                            <p>行业平均值：${averQuickRatio}</p>
                        </div>
                        <button class="md-trigger explain rkmd-btn ripple-effect"><p style="margin:0">查看详细信息</p></button>
                        <div class="md-modal md-effect-5">
                            <div class="md-content">
                                <h3>借贷详情</h3>
                                <div>
                                    <ul>
                                        <li><strong>贷款时间：</strong> 2022年7月26日</li>
                                        <li><strong>融资金额：</strong> 1,000,000元</li>
                                        <li><strong>融资利率：</strong> 0.02%</li>
                                        <li><strong>融资提供人：</strong> xxx银行</li>
                                        <li><strong>担保信息：</strong></li>
                                        <li style="text-indent: 50px;"><strong>担保人信用评级：</strong> 3级</li>
                                        <li style="text-indent: 50px;"><strong>质押抵押品价值：</strong> 2,000,000元</li>
                                        <li><strong>状态变化：</strong> </li>
                                        <li style="text-indent: 50px;"><strong>贷还款情况：</strong> 待还款</li>
                                        <li style="text-indent: 50px;"><strong>信用评级：</strong> 低</li>
                                        <li style="text-indent: 50px;"><strong>授信额度：</strong> 70</li>
                                    </ul>
                                    <!--<button class="md-close">Close me!</button>-->
                                </div>
                            </div>
                        </div>
                        <div class="md-overlay" style="z-index: 999;"></div>
                    </div>
                </div>
                <div class="tab-pane fade" id="fundManagement-box">
                    <div class="inner-item" id="fund">
                        <div class="chart" id='fundChart'></div>
                        <div class="inner-table">
                            <table class="table table-striped">
                                <caption>资产</caption>
                                <thead>
                                <tr>
                                    <th>年份</th>
                                    <th>2015</th>
                                    <th>2016</th>
                                    <th>2017</th>
                                    <th>2018</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>变现能力</td>
                                    <td>1.8</td>
                                    <td>2.3</td>
                                    <td>2.6</td>
                                    <td>2</td>
                                </tr>
                                </tbody>
                            </table>
                            <p>行业平均值：1.8</p>
                        </div>
                        <button class="md-trigger explain rkmd-btn ripple-effect"><p style="margin:0">查看详细信息</p></button>
                        <div class="md-modal md-effect-5">
                            <div class="md-content">
                                <h3>借贷详情</h3>
                                <div>
                                    <ul>
                                        <li><strong>贷款时间：</strong> 2022年7月26日</li>
                                        <li><strong>融资金额：</strong> 1,000,000元</li>
                                        <li><strong>融资利率：</strong> 0.02%</li>
                                        <li><strong>融资提供人：</strong> xxx银行</li>
                                        <li><strong>担保信息：</strong></li>
                                        <li style="text-indent: 50px;"><strong>担保人信用评级：</strong> 3级</li>
                                        <li style="text-indent: 50px;"><strong>质押抵押品价值：</strong> 2,000,000元</li>
                                        <li><strong>状态变化：</strong> </li>
                                        <li style="text-indent: 50px;"><strong>贷还款情况：</strong> 待还款</li>
                                        <li style="text-indent: 50px;"><strong>信用评级：</strong> 低</li>
                                        <li style="text-indent: 50px;"><strong>授信额度：</strong> 70</li>
                                    </ul>
                                    <!--<button class="md-close">Close me!</button>-->
                                </div>
                            </div>
                        </div>
                        <div class="md-overlay" style="z-index: 999;"></div>
                    </div>
                </div>
                <div class="tab-pane fade" id="debt-box">
                    <div class="inner-item" id="inDebt">
                        <div class="chart" id='inDebtChart'></div>
                        <div class="inner-table">
                            <table class="table table-striped">
                                <caption>资产</caption>
                                <thead>
                                <tr>
                                    <th>年份</th>
                                    <th>2015</th>
                                    <th>2016</th>
                                    <th>2017</th>
                                    <th>2018</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>变现能力</td>
                                    <td>1.8</td>
                                    <td>2.3</td>
                                    <td>2.6</td>
                                    <td>2</td>
                                </tr>
                                </tbody>
                            </table>
                            <p>行业平均值：1.8</p>
                        </div>
                        <button class="md-trigger explain rkmd-btn ripple-effect"><p style="margin:0">查看详细信息</p></button>
                        <div class="md-modal md-effect-5">
                            <div class="md-content">
                                <h3>借贷详情</h3>
                                <div>
                                    <ul>
                                        <li><strong>贷款时间：</strong> 2022年7月26日</li>
                                        <li><strong>融资金额：</strong> 1,000,000元</li>
                                        <li><strong>融资利率：</strong> 0.02%</li>
                                        <li><strong>融资提供人：</strong> xxx银行</li>
                                        <li><strong>担保信息：</strong></li>
                                        <li style="text-indent: 50px;"><strong>担保人信用评级：</strong> 3级</li>
                                        <li style="text-indent: 50px;"><strong>质押抵押品价值：</strong> 2,000,000元</li>
                                        <li><strong>状态变化：</strong> </li>
                                        <li style="text-indent: 50px;"><strong>贷还款情况：</strong> 待还款</li>
                                        <li style="text-indent: 50px;"><strong>信用评级：</strong> 低</li>
                                        <li style="text-indent: 50px;"><strong>授信额度：</strong> 70</li>
                                    </ul>
                                    <!--<button class="md-close">Close me!</button>-->
                                </div>
                            </div>
                        </div>
                        <div class="md-overlay" style="z-index: 999;"></div>
                    </div>
                </div>
                <div class="tab-pane fade" id="profit-box">
                </div>
                <div class="tab-pane fade" id="cashFlow-box">
                </div>
                <div class="tab-pane fade" id="obtainCash-box">
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/statics/js/classie.js"></script>
<script src="/statics/js/modalEffects.js"></script>
</body>
<script>
    var id = null;
    $("document").ready(function() {
        var data = [[]];
        <c:forEach items= "${currentRatios[1]}" var="i" varStatus="status">
        data[0].push(${i});
        </c:forEach>
        var data_max = 2; //Y轴最大刻度
        var chartId1 = "currentRatioChart";
        var x = []; //定义X轴刻度值
        <c:forEach items= "${currentRatios[0]}" var="i" varStatus="status">
         x.push("${i}");
        </c:forEach>
        addChart(chartId1, data, x,data_max);

        var data2=[[]];
        <c:forEach items= "${quickRatios[1]}" var="i" varStatus="status">
        data2[0].push(${i});
        </c:forEach>
        var data_max2 = 15; //Y轴最大刻度
        var chartId2 = "speedRatioChart";
        var x2 = []; //定义X轴刻度值
        <c:forEach items= "${quickRatios[0]}" var="i" varStatus="status">
        x2.push("${i}");
        </c:forEach>
        addChart(chartId2, data2, x2,data_max2);
        // var chartId2 = "speedRatioChart";
        // addChart(chartId2, data, line_title);
    })

    $(".aTab").on("click", function() {

        $(".chart").empty();
        var box = $(this).attr("href");
        var item = box + " .chart";
        setTimeout(function() {
            $(item).each(function() {

                 //曲线名称
                var id = $(this).attr("id");
                if(id=="currentRatioChart"){
                    var data = [[]];
                    <c:forEach items= "${currentRatios[1]}" var="i" varStatus="status">
                    data[0].push(${i});
                    </c:forEach>
                    var data_max = 2; //Y轴最大刻度
                    var chartId1 = "currentRatioChart";
                    var x = []; //定义X轴刻度值
                    <c:forEach items= "${currentRatios[0]}" var="i" varStatus="status">
                    x.push("${i}");
                    </c:forEach>
                    addChart(chartId1, data, x,data_max);
                }else if(id=="speedRatioChart"){
                    var data2=[[]];
                    <c:forEach items= "${quickRatios[1]}" var="i" varStatus="status">
                    data2[0].push(${i});
                    </c:forEach>
                    var data_max2 = 15; //Y轴最大刻度
                    var chartId2 = "speedRatioChart";
                    var x2 = []; //定义X轴刻度值
                    <c:forEach items= "${quickRatios[0]}" var="i" varStatus="status">
                    x2.push("${i}");
                    </c:forEach>
                    addChart(chartId2, data2, x2,data_max2);
                }
            })
        }, 200)

    })

    function addChart(chartId, data,x,data_max) {
        var line_title = ["A"];
        //			var y_label = "授信额度"; //Y轴标题
        //			var x_label = "时间"; //X轴标题

        j.jqplot.diagram.base(chartId, data, line_title, "", x, "", "", data_max, 1);

    }
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
</html>
