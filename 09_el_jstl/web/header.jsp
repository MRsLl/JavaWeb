<%--
  Created by IntelliJ IDEA.
  User: 刘磊
  Date: 2020/9/1
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
获取请求头 Accept 的值 :${header.Accept}<br>
获取请求头 User-Agent的值: ${header["User-Agent"]};
</body>
</html>
