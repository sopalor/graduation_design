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

		<link rel="stylesheet" href="welcome/css/home_page.css" />
		<link rel="stylesheet" href="welcome/css/user login.css" />
		<link rel="stylesheet" href="welcome/css/my_ticket.css" />

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
							<h2>我的机票</h2>
							<form name="form2" onsubmit="">
							<table class="table_3">
								<thead>
									<tr>
										<th>路线</th>
										<th>日期</th>
										<th>价格</th>
										<th>出发</th>
										<th>到达</th>
										<th>航班</th>
										<th style="width: 250px;">预定</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item"   items="${requestScope.list}"   varStatus="status"  >
										<tr>
											<td>${item.TTicket.CCfd}-${item.TTicket.CMdd}</td>
											<td>${item.TTicket.DRq}</td>
											<td class="price">¥${item.TTicket.FZk}<font style="text-decoration: line-through;font-size:12px;color: #666666;" class="discount">¥${item.TTicket.NJg}</font></td>
									 		<td>${item.TTicket.DCfsj}</td>
											<td>${item.TTicket.DDdsj}</td>
											<td>${item.TTicket.CHkgs}</td>
											<td>
												<a href="../user_ticket/ticketinfo?id=${item.CId}" class="reserve1">查看</a>
												<a href="../user_ticket/deleteticket?id=${item.CId}" class="reserve1">退订</a>
												<a href="../user_ticket/changeticket?id=${item.TTicket.CId}&u_t_id=${item.CId}" class="reserve1">改签</a>
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
