<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--静态包含 head，head中有css路径,jquery路径,base标签--%>
    <%@include file="/pages/common/head.jsp"%>

    很抱歉 , 您访问程序出现了异常.程序猿小哥正在努力为您抢修!!   <br>
    <a href="index.jsp">跳转首页</a>  , <a href="#"> 联系客服</a>

    <%--静态包含页脚内容--%>
    <%@include file="/pages/common/footer.jsp"%>
</body>
</html>
