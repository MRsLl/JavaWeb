<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%--静态包含 head，head中有css路径,jquery路径,base标签--%>
	<%@include file="/pages/common/head.jsp"%>

    <script type="text/javascript">
        $(function () {
            // 给删除的a标签绑定单击事件
            $("a.deleteClass").click(function () {
                // 在事件响应的function函数中,有一个this对象.这个this对象是当前正在响应事件的dom对象
                var name = $(this).parent().parent().find("td:first").text();
                /**
                 * confirm方法是javaScript语言提供的一个确认提示框函数 <br/>
                 * 它的参数就是提示框的文字信息 <br/>
                 * 它有一个确认和取消按钮
                 * 点击了确认返回true,点击取消返回false
                 */
                return confirm("你确认要删除 [ " + name + " ] 吗");
                // 可以阻止元素的默认行为
                // return false;
            });
        });
    </script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>

		<%--静态包含 管理菜单--%>
		<%@ include file="/pages/common/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
                <c:forEach items="${requestScope.page.items}" var="book">
                    <tr>
                        <td>${book.name}</td>
                        <td>${book.price}</td>
                        <td>${book.author}</td>
                        <td>${book.sales}</td>
                        <td>${book.stock}</td>
                        <td><a href="manager/bookServlet?action=getBookById&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                        <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
                    </tr>
                </c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageNo}">添加图书</a></td>
			</tr>	
		</table>
		<%--静态包含分页条内容--%>
		<%@include file="/pages/common/page_nav.jsp"%>
	</div>
	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>