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
		<script src="./welcome/js/jquery-1.4.2.min.js"></script>
		<link rel="stylesheet" href="welcome/css/home_page.css" />
		<link rel="stylesheet" href="welcome/css/user_login.css" />

	</head>
	<body>
		<div id="div01-1">
			
			<div id="headline">
				
				<div id="div01-2">
					<div id="div01-2-1">欢迎用户：${sessionScope.nickname}，<a href="" class="a1">退出</a></div>
					<div id="div01-2-2">
						<div id="div01-2-2-1"><a href="../ticket/init?id=${sessionScope.id}" class="a1"><h4>首页</h4></a></div>
						<div id="div01-2-2-1"><a href="../user/change?id=${sessionScope.id}" class="a1"><h4>账号管理</h4></a></div>
						<div id="div01-2-2-1"><a href="ticket.html" class="a1"><h4>我的机票</h4></a></div>

						<div id="div01-2-2-1"><a href="aboutme.html" class="a1"><h4>关于我们</h4></a></div>
					</div>		
				
				</div>
				 <div class="center"> 
					<hgroup> 
						<h2>机票预订</h2> 
						<h3>可预订机票、查询机票等</h3> 
					</hgroup> 
				</div> 
			</div>
				<div id="container"> 
						
					<div class="ticket">
						<form action="./ticket/TiaoJian">
							<h2>机票预定</h2>

							<div class="form left">
								<p> <label for="cfd">出发城市</label><br/> <input type="text" name="cfd" id="cfd" placeholder="城市名"> </p>
								
							</div>
							<div class="form middle">
								<p> <label for="mdd">返回城市</label><br/> <input type="text" name="mdd" id="mdd" placeholder="城市名"> </p>
							</div>
							<div class="form right">
								<p> <label for="rq">出发时间</label><br/> <input type="text" name="rq" id="rq" placeholder="时间/日期"> </p>
								
							</div>
							<div class="form button">
								<p> <button type="submit" class="submit">查询</button> </p>
							</div>
						</form>
						<div class="new">
							<h2>最新机票</h2>
							
							<table>
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
												<a href="###" class="reserve">预定</a>
											</td>
										</tr>
									</c:forEach>

								</tbody>
								
							</table>
						</div>
					</div>
		
				</div>
			

		</div>
	</body>
</html>
