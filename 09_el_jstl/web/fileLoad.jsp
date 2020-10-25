<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/09_el_jstl/loadServlet" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"><br>
    <input type="file" name="photo"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
