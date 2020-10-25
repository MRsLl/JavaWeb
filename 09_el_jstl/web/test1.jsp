<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 刘磊
  Date: 2020/9/1
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();

    person.setId(100);
    person.setPhones(new String[]{"18688886666","13966668888","18610541354"});

    List<String> cities = new ArrayList<>();
    cities.add("北京");
    cities.add("上海");
    cities.add("深圳");
    cities.add("广州");
    person.setCities(cities);

    Map<String,Object> map = new HashMap<>();
    map.put("k1","v1");
    map.put("k2","v2");
    map.put("k3","v3");
    person.setMap(map);

    request.setAttribute("p",person);
%>
${p}<br/>
${p.id}<br/>
${p.phones}<br/>
输出 person.phones[0] 的值${p.phones[0]}<br/>
输出 person.phones[1] 的值${p.phones[1]}<br/>
输出 person.phones[2] 的值${p.phones[2]}<br/>
${p.cities}<br/>
${p.cities[0]}<br/>
${p.cities[2]}<br/>
${p.map}<br/>
${p.map.k1}<br/>
${p.map.k2}<br/>
${p.map.k3}<br/>
</body>
</html>
