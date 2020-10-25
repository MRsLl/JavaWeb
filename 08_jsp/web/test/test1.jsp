<%--
  Created by IntelliJ IDEA.
  User: 刘磊
  Date: 2020/8/31
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">九九乘法口诀表</h1>
<table align="center">
    <% for (int i = 1; i < 10; i++) {%>
    <tr>
        <% for (int j = 1;j <= i;j++){%>
        <td><%=i + "x" + j + "=" + i*j%></td>
        <%}%>
    </tr>
<% } %>
</table>
</body>
</html>
