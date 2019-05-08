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
		<script src="./welcome/js/home_page.js"></script>
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" >
		<link rel="stylesheet" href="welcome/css/home_page.css" />
		<link rel="stylesheet" href="welcome/css/user_login.css" />

	</head>
	<body>
		<div id="div01-1">
			
			<div id="headline">

				<div id="div01-2">
					<div id="div01-2-1">欢迎用户：${sessionScope.nickname}，<a href="" class="a1">退出</a></div>
					<div id="div01-2-2">
						<div id="div01-2-2-1"><a href="../ticket/init?id=${sessionScope.id}" class="a1" id="shouye"><h4>首页</h4></a></div>
						<div id="div01-2-2-1"><a href="../user/change?id=${sessionScope.id}" class="a1"><h4>账号管理</h4></a></div>
						<div id="div01-2-2-1"><a href="../user_ticket/myticket?id=${sessionScope.id}" class="a1"><h4>我的机票</h4></a></div>

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
								<p> <label for="cfd">出发城市</label><!--<br/>-->
									<SELECT  name="cfd" id="cfd" class="form-control" >
										<c:forEach var="item"   items="${requestScope.cfdlist}"   varStatus="status"  >
											<option value="${item}">${item} </option>
										</c:forEach>
										<option value="">任意</option>
									</SELECT>
									</SELECT>  </p>

							</div>
							<div class="form middle">
								<p> <label for="mdd">返回城市</label><!--<br/>-->
									<SELECT  name="mdd" id="mdd"  class="form-control">
										<c:forEach var="item"   items="${requestScope.mddlist}"   varStatus="status"  >
											<option value="${item}">${item} </option>
										</c:forEach>
										<option value="">任意</option>
									</SELECT>

								</p>
							</div>
							<div class="form right">
								<p> <label for="rq">出发时间</label><!--<br/>-->
									<SELECT  name="rq" id="rq" class="form-control">
										<c:forEach var="item"   items="${requestScope.rqlist}"   varStatus="status"  >
											<option value="${item}">${item} </option>
										</c:forEach>
										<option value="">任意</option>
									</SELECT>
								</p>

							</div>
							<div class="form button">
								<p> <button type="submit" class="submit">查询</button> </p>
							</div>
						</form>
						<div class="new">
							<h2 ><button type="submit" class="button3" id="thenew">最新机票</button><button  class="button4" id="discount1">折扣机票</button></h2>
							
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
												<a href="../ticket/yuding?id=${item.CId}" class="reserve">预定</a>
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
