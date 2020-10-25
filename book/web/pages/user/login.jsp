<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
	<%--静态包含 head，head中有css路径,jquery路径,base标签--%>
	<%@include file="/pages/common/head.jsp"%>
</head>
<script type="text/javascript">
	$(function (){
		$("#sub_btn").click(function (){
			//验证用户名是否符合规范
			//1.获取用户输入的用户名
			var username =  $(":text.itxt").val();

			//2.获取用户名规范的正则表达式
			var usernamePatt = /^\w{5,12}$/;

			//3.通过test()方法比较得出用户名是否符合规范
			if (!(usernamePatt.test(username))){
				//4.提醒用户验证结果
				$("span.errorMsg").text("用户名非法，请重新输入");
				return false;
			}

			//验证密码是否符合规范
			//1.获取输入的密码值
			var password = $(":password.itxt").val();

			//2.获取密码规范的正则表达式
			var passwordPatt = /^\w{5,12}$/;

			//3.通过test()方法比较得出密码是否符合规范
			if (!(passwordPatt.test(password))){
				//4.提醒用户验证结果
				$("span.errorMsg").text("密码非法，请重新输入");
				return false;
			}

			$("span.errorMsg").text("");
		});
	});
</script>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
                                    ${requestScope.msg == null ? "请输入用户名和密码" : requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="login">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
									value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--静态包含页脚内容--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>