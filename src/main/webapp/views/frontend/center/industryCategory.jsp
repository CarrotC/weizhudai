<%--
  Created by IntelliJ IDEA.
  User: coldilock
  Date: 2018/9/5
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl标签库--%>
<%@include file="/views/include/taglib.jsp" %>

<html>
<head>
    <title>Title</title>
    <script src="<spring:url value="/statics/js/jquery-3.3.1.min.js"/>"></script>
</head>
<body>
<%--<center>--%>
    <%--${compantTypeList.size()}--%>
    <%--<a href="#">农业</a>--%>
    <%--|--%>
    <%--<a href="#">采矿业</a>--%>
    <%--|--%>
    <%--<a href="#">电力</a>--%>
    <%--|--%>
    <%--<a href="#">建筑业</a>--%>
    <%--<br>--%>
    <%--<br><br>--%>
<%--</center>--%>
<center>
    <div class="companyTypeList">
        <c:forEach items="${companyTypeList}" var="t" varStatus="status">
            <%--<div data-company-type="${t}"><a href="/frontend/enterpriseInfo/index">${t}</a></div>--%>
            <button onclick="getAllCompantNameByType(this)" data-index="${status.index}">${t}</button> |
        </c:forEach>
    </div>
    <br>
    <div class="companyList">
        ${companyList.size()}
    </div>
</center>
</body>
<script>
    function getAllCompantNameByType(e){
        var companyTypeIndex = $(e).data('index');
        window.location.href = '/frontend/center/industryCategory?index=' + companyTypeIndex;
        // $.ajax({
        //     url: '/frontend/center/industryCategory?index=' + companyTypeIndex,
        //     method: 'post',
        //     dataType: 'json',
        //     async: true,
        //     success: function () {
        //         location.reload(true);
        //     }
        //
        // })
    }
</script>
</html>
