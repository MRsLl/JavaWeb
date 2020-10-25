<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--静态包含 head，head中有css路径,jquery路径,base标签--%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            // 给清空购物车按钮绑定单击事件
            $("#clearCart").click(function () {
                return confirm("你确定要清空购物车么");
            });
            
            //给删除绑定单击事件
            $("a.deleteItem").click(function () {
                var name = $(this).parent().parent().find("td:first").text();
                return confirm("你确定要删除*" + name + "*吗");
            });
            
            //给输入框绑定内容改变事件
            $("input.updateCount").change(function () {
                //获取商品名称
                var name = $(this).parent().parent().find("td:first").text();
                //获取商品数量
                var count = this.value;
                //获取图书编号
                var bookId = $(this).attr("bookId");

                if (confirm("你确定要将【" + name + "】商品的数量修改为" + count + "吗？")){
                    location.href="${basePath}cartServlet?action=updateCount&id=" + bookId + "&count="+count;
                } else {
                    this.value = this.defaultValue;
                }
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>

    <%--静态包含 登录成功菜单--%>
    <%@include file="/pages/common/login_success_menu.jsp" %>

</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <%--购物车非空的时候输出--%>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td><input type="text" bookId="${entry.value.id}"class="updateCount" style="width: 100px;" value="${entry.value.count}"></td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class=" deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>

        <%--购物车空的时候输出--%>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">亲,当前购物车为空,赶快浏览商品吧!</a></td>
            </tr>
        </c:if>
    </table>

    <%--购物车非空的时候输出--%>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="client/orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>