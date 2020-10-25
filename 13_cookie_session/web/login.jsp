<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="userServlet" method="get">
    <input type="hidden" name="action" value="login">
    用户名:<input type="text" name="username" value="${cookie.username.value}"> <br>
    密码: <input type="password" name="password" > <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
