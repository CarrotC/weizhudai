<%--
  Created by IntelliJ IDEA.
  User: coldilock
  Date: 2018/8/29
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl标签库--%>
<%@include file="/views/include/taglib.jsp" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<center>
    <h3>xxx</h3>
    <a href="/frontend/login/index">
        <div>
            <span>登录/注册</span>
        </div>
    </a>
    <%--<button onclick="hello()"> hello</button>--%>
</center>
</body>
<script>
    // function hello(){
    //     $.ajax({
    //         url: '/frontend/hello',
    //         dataType: 'json',
    //         success: function (res) {
    //             if(res.status == 200){
    //                 alert("success-200")
    //             } else {
    //                 alert("success-500")
    //             }
    //
    //         },
    //         error: function () {
    //             alert("error")
    //         }
    //
    //     })
    // }

</script>
</html>
