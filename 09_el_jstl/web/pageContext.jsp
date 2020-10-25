<%--
  Created by IntelliJ IDEA.
  User: 刘磊
  Date: 2020/9/1
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    request.getScheme() 表示获取请求的协议
    request.getServerName() 获取服务器的ip
    request.getServerPort() 获取服务器的端口号
    request.getContextPath() 获取工程路径
    request.getMethod() 获取请求的方式GET或POST
    request.getRemoteHost() 获取客户端的ip
    session.getId() 获取会话的唯一标识( 编号 )
--%>
<%
    pageContext.setAttribute("req",request);
%>
1.协议 ${req.scheme}<br/>
2.服务器ip ${req.serverName}<br/>
3.服务器端口号 ${req.serverPort}<br/>
4.获取工程路径 ${req.contextPath}<br/>
5.获取请求方法 ${req.method}<br>
6.获取客户端ip地址 ${req.remoteHost}<br>
7.获取会话的ip编号 ${pageContext.session.id}<br>
</body>
</html>
