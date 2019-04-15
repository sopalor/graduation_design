<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		%>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/home_page.css" />
		<link rel="stylesheet" href="css/user login.css" />
		<link rel="stylesheet" href="css/my_ticket.css" />
		<link rel="stylesheet" href="css/check_my_ticket.css" />
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
						<h2>我的机票</h2> 
						<h3>可查看、退订、改签机票。</h3> 
					</hgroup> 
				</div> 
			</div>
				<div id="container"> 
						
					<div class="ticket">
						<div class="new">
							<h2>查看机票</h2>
							<div class="back">
								<a href="" class="a2" >返回</a>
							</div>
							<form onsubmit="" name="form3">
							<table class="table_4" cellpadding="0" cellspacing="0" rules="all" border-color="#666666">
								<tbody>
									<tr>
										<td style="width: 150px;">姓名</td>
										<td>cly</td>
										<td style="width: 150px;">出发时间</td>
										<td>2月12日</td>
									</tr>
								
									<tr>
										<td>出发城市</td>
										<td>上海</td>
										<td>到达城市</td>
										<td>北京</td>
									</tr>
									<tr>
										<td>航班号</td>
										<td>m170</td>
										<td>座位号</td>
										<td>01</td>
									</tr>
										<tr>
										<td>身份证号码</td>
										<td colspan="3">111111111111111111111</td>

									</tr>
								</tbody>
								
							</table>
							</form>
						</div>
					</div>
		
				</div>
			

		</div>
	</body>
</html>
