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
								<a href="" class="a2" >返回</a>
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
									<tr>
										<td>北京-成都</td>
										<td>10-15</td>
										<td class="price">¥745</td>
										<td>07:00</td>
										<td>09:00</td>
										<td>春秋航空</td>
										<td>

											<a href="###" class="reserve1">改签</a>
										</td>
									</tr>
									<tr>
										<td>北京-上海</td>
										<td>10-15</td>
										<td class="price">¥479</td>
										<td>07:00</td>
										<td>09:00</td>
										<td>南方航空</td>
										<td >

											<a href="###" class="reserve1">改签</a>
										</td>
									</tr>
									<tr>
										<td>北京-深圳</td>
										<td>10-15</td>
										<td class="price">¥561</td>
										<td>07:00</td>
										<td>09:00</td>
										<td>西部航空</td>
										<td>

											<a href="###" class="reserve1">改签</a>
										</td>
									</tr>
									<tr>
										<td>北京-杭州</td>
										<td>10-15</td>
										<td class="price">¥378</td>
										<td>07:00</td>
										<td>09:00</td>
										<td>天津航空</td>
										<td>

											<a href="###" class="reserve1">改签</a>
										</td>
									</tr>
									<tr>
										<td>北京-广州</td>
										<td>10-15</td>
										<td class="price">¥612</td>
										<td>07:00</td>
										<td>09:00</td>
										<td>首都航空</td>
										<td>

											<a href="###" class="reserve1">改签</a>
										</td>
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
