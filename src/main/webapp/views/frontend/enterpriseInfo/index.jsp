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
    <title>Title</title>
</head>
<body>
<center>
    <a href="#">企业资料</a>
    |
    <a href="/frontend/enterpriseInfo/companyFlow">企业流水</a>
    |
    <a href="/frontend/enterpriseInfo/companyLoan">企业信用</a>
    |
    <a href="#">财务信息</a>


    <br>
    ${companyName}
    <c:forEach items="${loanList}" var="t" varStatus="status">
        <div class="type-item " id="type1">
            <div data-index="${status.index}">${t.lenders}</div>
        </div>

    </c:forEach>
</center>
</body>
</html>
