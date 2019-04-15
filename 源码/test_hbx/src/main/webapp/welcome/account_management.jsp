<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		%>
		<base href="<%=basePath%>">
		<script src="./welcome/js/jquery-1.4.2.min.js"></script>
		<link rel="stylesheet" href="./welcome/css/home_page.css" />
		<link rel="stylesheet" href="./welcome/css/user_login.css" />
		<link rel="stylesheet" href="./welcome/css/account_management.css" />
		<script src="./welcome/js/account_management.js"></script>

	</head>
	<body>
		<div id="div01-1">
			
			<div id="headline">

				<div id="div01-2">
					<div id="div01-2-1">欢迎用户：${sessionScope.nickname}，<a href="" class="a1">退出</a></div>
					<div id="div01-2-2">
						<div id="div01-2-2-1"><a href="../ticket/init?id=${sessionScope.id}" class="a1"><h4>首页</h4></a></div>
						<div id="div01-2-2-1"><a href="../user/change?id=${sessionScope.id}" class="a1"><h4>账号管理</h4></a></div>
						<div id="div01-2-2-1"><a href="../user_ticket/myticket?id=${sessionScope.id}" class="a1"><h4>我的机票</h4></a></div>

						<div id="div01-2-2-1"><a href="aboutme.html" class="a1"><h4>关于我们</h4></a></div>
					</div>

				</div>
				 <div class="center"> 
					<hgroup> 
						<h2>账号管理</h2> 
						<h3>可完善或修改个人资料。</h3> 
					</hgroup> 
				</div> 
			</div>
				<div id="container"> 
						
					<div class="ticket">
						
						<div class="new">
							<h2>个人信息</h2>
							<form  name="form1" action="../user/update">
							<table class="table_2">
								<tr>
									<td class="td1">姓名</td>
									<td><input name="name" type="text" size="40px" placeholder="请输入姓名" value="${requestScope.user.CName}"></td>
								</tr>
								<tr>
									<td class="td1">性别</td>
									<td>
										<input type="radio" name="sex" value="男" checked="checked" >男
										<input type="radio" name="sex" value="女">女
										<input type="hidden" value="${requestScope.user.CSex}" id="hidden_sex" />
									</td>
								</tr>
								<tr>
									<td class="td1">昵称</td>
									<td><input name="nickname" type="text" size="40px" placeholder="请输入昵称" value="${requestScope.user.CNickname}"></td>
								</tr>
								<tr>
									<td class="td1">邮箱</td>
									<td><input name="email" type="text" size="40px" placeholder="请输入邮箱" value="${requestScope.user.CEmail}"></td>
								</tr>
								<tr>
									<td class="td1">身份证</td>
									<td><input name="sfzh" type="text" size="40px" placeholder="请输入身份证" value="${requestScope.user.CSfzh}"></td>
								</tr>
								<tr>
									<td class="td1">手机号</td>
									<td><input name="phone" type="text" size="40px" placeholder="请输入手机号" value="${requestScope.user.CPhone}"></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="提交" name="tijiao" class="submit1"></td>
									
								</tr>
							</table>
							</form>
						</div>
					</div>
		
				</div>
			

		</div>
	</body>
</html>
