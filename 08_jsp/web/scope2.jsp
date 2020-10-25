<%@ page import="javax.websocket.Session" %><%--
  Created by IntelliJ IDEA.
  User: 刘磊
  Date: 2020/8/31
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%=pageContext.getAttribute("key")%><br/>
<%=request.getAttribute("key")%><br/>
<%=session.getAttribute("key")%><br/>
<%=application.getAttribute("key")%><br/>

</body>
</html>
