<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--1.遍历1到10，输出
           begin 属性设置遍历的开始索引
           end 属性设置遍历的结束索引( 包含结束值 )
           var 是当前正在遍历到的数据
--%>
<c:forEach begin="1" end="10" var="i">
    ${i}
</c:forEach>
<hr>
<%--遍历Objct数组--%>
<%
    String[] arr = new String[]{"18688886666","13988886666","18610541354"};
    request.setAttribute("phones",arr);
%>
<c:forEach items="${requestScope.phones}" var="phone">
    ${phone}
</c:forEach>
<hr>
<%--遍历Map集合--%>
<%
    Map<String,Object> map = new HashMap<>();
    map.put("k1","v1");
    map.put("k2","v2");
    map.put("k3","v3");

    pageContext.setAttribute("map",map);
%>
<c:forEach items="${pageScope.map}" var="item">
    ${item.key}--${item.value}<br>
</c:forEach>
<hr>
<%--4.	遍历List集合---list中存放 Student类，有属性：编号，姓名，性别，年龄，电话信息--%>
<%
    List<Student> students = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        students.add(new Student(i,"name" + i,i % 2,"phone" + i));
    }
    request.setAttribute("stus",students);
%>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>电话</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.stus}" var="student" begin="0" end="7">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.sex == 0 ? "女" : "男"}</td>
            <td>${student.phone}</td>
            <td>删除，修改</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
