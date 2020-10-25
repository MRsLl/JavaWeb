<%@ page import="com.atuguigu.servlet.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 500px;
            border: 1px solid red;
            border-collapse: collapse;
        }
        th , td{
            border: 1px solid red;
        }
    </style>

</head>
<body>
<%
    List<Student> studentList = (List<Student>) request.getAttribute("stus");
%>
<table>
    <th>学号</th>
    <th>姓名</th>
    <th>手机</th>
    <th>性别</th>
    <th>操作</th>
<%for (int i = 0; i < studentList.size(); i++) {%>
<%Student student = studentList.get(i);%>
<tr>
    <td><%= student.getId()%></td>
    <td><%= student.getName()%></td>
    <td><%= student.getPhone()%></td>
    <td><%= student.getSex() == 0 ? "女":"男"%></td>
    <td>修改，删除</td>
</tr>
<%}%>
</table>
</body>
</html>
