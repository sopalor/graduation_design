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

		<link rel="stylesheet" href="./welcome/css/home_page.css" />
		<link rel="stylesheet" href="./welcome/css/user login.css" />
		<link rel="stylesheet" href="./welcome/css/my_ticket.css" />
		<link rel="stylesheet" href="./welcome/css/check_my_ticket.css" />
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
							<h2>改签机票</h2>
							<div class="back">
								<a href="../user_ticket/myticket?id=${sessionScope.id}" class="a2" >返回</a>
							</div>
							<form onsubmit="" name="form4">
							<table class="table_3">
								<thead>
									<tr>
										<th>路线</th>
										<th>日期</th>
										<th>价格</th>
										<th>出发</th>
										<th>到达</th>
										<th>航班</th>
										<th>预定</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item"   items="${requestScope.list}"   varStatus="status"  >
										<tr>
											<td>${item.CCfd}-${item.CMdd}</td>
											<td>${item.DRq}</td>
											<td class="price">¥${item.NJg}</td>
											<td>${item.DCfsj}</td>
											<td>${item.DDdsj}</td>
											<td>${item.CHkgs}</td>
											<td>
												<a href="../user_ticket/change?id=${item.CId}&u_t_id=${requestScope.u_t_id}" class="reserve1">改签</a>
											</td>
										</tr>
									</c:forEach>
									
								</tbody>
								
							</table>
							</form>
						</div>
					</div>
		
				</div>
			

		</div>
	</body>
</html>
