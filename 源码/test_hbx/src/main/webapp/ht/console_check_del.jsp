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
		<link rel="stylesheet" href="ht/css/console_check_del.css" />
		<script src="./ht/js/jquery-1.4.2.min.js"></script>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" >
		<script src="./ht/js/console.js"></script>

	</head>
	<body>
		<div id="div-1">
			<div id="div-2">
					<div id="div-2-1">欢迎,超级管理员。<a href="" class="a1">退出</a></div>
			</div>
			<div id="div-3">
				<div id="div-3-1">
					<div id="div-3-1-2"><button type="button" class="button1"  id="init">机票查询\删除</button></div>
					<div id="div-3-1-2"><button type="button">机票修改</button></div>
					<div id="div-3-1-2"><button type="button" id="add_ticket">机票添加</button></div>
				</div>
				<div id="div-3-2">
					<h3>机票的查询与删除</h3>
					<div id="div-3-2-1">
						<form action="./admin/TiaoJian">
						<div class="form left">
							<p> <label for="cfd">出发城市</label><!--<br/>-->
								<SELECT  name="cfd" id="cfd" class="form-control">
									<c:forEach var="item"   items="${requestScope.cfdlist}"   varStatus="status"  >
									<option value="${item}">${item} </option>
									</c:forEach>
									<option value="">任意</option>
							</SELECT>
								</SELECT>  </p>
								
							</div>
							<div class="form middle">
								<p> <label for="mdd">返回城市</label><!--<br/>-->
									<SELECT  name="mdd" id="mdd" class="form-control">
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
							<br />
							<div class="form button">
								 <button type="submit" class="button2" id="">查询</button>
							</div>
						</form>
					</div>
					<div id="div-3-2-2">
					<table class="table01" cellpadding="0" cellspacing="0" rules="rows" frame="hsides">
						<tr>
							<td>航班</td>
							<td>出发城市</td>
							<td>目的城市</td>
							<td>出发时间</td>
							<td>到达时间</td>
							<td>日期</td>
							<td>价格</td>
							<td>座位数</td>
							<td>删除</td>
							<td>修改</td>
						</tr>
						<c:forEach var="item"   items="${requestScope.list}"   varStatus="status"  >
							<tr>
								<td>${item.CHkgs}</td>
								<td>${item.CCfd}</td>
								<td>${item.CMdd}</td>
								<td>${item.DCfsj}</td>
								<td>${item.DDdsj}</td>
								<td>${item.DRq}</td>
								<td class="price">¥${item.NJg}</td>
								<td>${item.NZwzs}</td>
									<td><a href="../admin/deleteticket?id=${item.CId}" class="reserve">删除</a></td>
								<td><a href="../admin/changeticket?id=${item.CId}" class="reserve">修改</a></td>
							</tr>
						</c:forEach>
					</table>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
