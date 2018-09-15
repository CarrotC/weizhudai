<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl标签库--%>
<%@include file="/views/include/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="description" content="行业分类" />
    <link href="/dist/css/button-style.css" rel="stylesheet" />
    <link href="/statics/css/classification.css" rel="stylesheet" />
    <link href="/statics/css/tabStyle.css" rel="stylesheet" />
    <link rel="icon" type="image/x-icon" href="/statics/img/logo01.png" />
    <link href="/dist/bookstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/dist/js/jquery-3.3.1.js"></script>
    <script src="/dist/js/button-style.js"></script>
    <script src="/dist/bookstrap/js/bootstrap.min.js"></script>

    <title>微助贷-行业分类</title>
</head>

<body>
<div class="bg">
    <img src="/statics/img/indexBg.png" />
</div>
<nav class="navbar navbar-inverse" role="navigation">

    <div class="navbar-header">
        <img src="/statics/img/logo01.png" />
        <a class="navbar-brand" href="index.html">微助贷</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="li-item active">
                <a href="#">行业分类</a>
            </li>
            <li class="li-item">
                <a href="#">关于我们</a>
            </li>
            <li class="li-item">
                <a href="login.html">登陆/注册</a>
            </li>
            <li class="line"></li>
            <li class="language chinese">
                <img class="rkmd-btn btn-fab-mini btn-pink ripple-effect" src="/statics/img/chinese.png" />
            </li>
        </ul>
    </div>
</nav>
<div class="main-container">
    <div class="type-box">
        <div class="card">
            <img src="/statics/img/card-img.png" />
            <p>行业类型</p>
        </div>

        <c:forEach items="${companyTypeList}" var="t" varStatus="status">
            <div class="spilt"></div>
            <div class="type-item " id="type1">
                <div onclick="getAllCompanyNameByType(this)" data-index="${status.index}">${t}</div>
                <img src="/statics/img/arrow.png">
            </div>

        </c:forEach>

        <div class="spilt"></div>

    </div>
    <div class="company-box">
        <p class="title">${companyList.get(0).companyType}</p>
        <div class="spilt2"></div>
        <div class="choose-box">
            <div class="choose-item liveItem" id="name">
                <div class="icon"></div>
                <p>按名称</p>
            </div>
            <div class="choose-item" id="time">
                <div class="icon"></div>
                <p>按上市时间</p>
            </div>
            <div class="choose-item" id="grade">
                <div class="icon"></div>
                <p>按信用分数</p>
            </div>
        </div>
        <div class="spilt2"></div>
        <div class="main-box">

            <c:forEach items="${companyList}" var="c" varStatus="status">
                <div class="company-Item" data-id="${c.companyId}" onclick="getCompanyInfo(this)">
                    <img class="quoted" src="/statics/img/star.png">
                    <img class="company-icon" src="/statics/img/test/test.png">
                    <p>${status.index+1}.&nbsp${c.companyName}</p>
                </div>
            </c:forEach>

        </div>
    </div>
</div>
</body>
<script>
    //更换筛选方式
    $(".choose-item").on("click",function(){
        $(".choose-item").removeClass("liveItem");
        $(this).addClass("liveItem");
    })
    //更换行业类型
    $(".type-item").on("click", function() {
        $(".type-item").removeClass("typeClick");
        $(this).addClass("typeClick");
    })
    //		切换语言
    $(".language").on("click", function() {
        if($(this).hasClass("chinese")) {
            //换成英文
            $(this).addClass("english");
            $(this).removeClass("chinese");
            $(".language img").attr("src", "/statics/img/english.png")
        } else {
            $(this).removeClass("english");
            $(this).addClass("chinese");
            $(".language img").attr("src", "/statics/img/chinese.png")
        }
    })
    //查看公司信息
    function getCompanyInfo(e) {
        var companyId = $(e).data('id');
        $.ajax({
            url: '/frontend/enterpriseInfo/companyInfo',
            data: JSON.stringify({
                companyId: companyId
            }),
            contentType: 'application/json',
            dataType: 'json',
            method: 'post',
            async: false,
            success: function (res) {
                if (res.status === 200) {
                    window.location.href = res.data.toString()
                } else {
                    alert("无法查看")
                }
            },
            error: function (res) {
                alert(res.toString())
            }

        })

    }

    function getAllCompanyNameByType(e){
        var companyTypeIndex = $(e).data('index');
        window.location.href = '/frontend/center/industryCategory?index=' + companyTypeIndex;
    }
</script>

</html>