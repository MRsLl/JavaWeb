<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘磊
  Date: 2020/9/1
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("height",169);
%>
<c:choose>
    <c:when test="${requestScope.height > 190}">巨人</c:when>
    <c:when test="${requestScope.height > 180}">高人</c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${requestScope.height > 170}">普通人</c:when>
            <c:when test="${requestScope.height > 160}">有点矮</c:when>
            <c:otherwise>others</c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>
</body>
</html>
