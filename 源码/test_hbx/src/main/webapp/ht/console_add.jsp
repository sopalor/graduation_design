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
		<link rel="stylesheet" href="ht/css/console_add.css" />
		<script src="./ht/js/jquery-1.4.2.min.js"></script>
		<script src="./ht/js/console.js"></script>

	</head>
	<body>
		<div id="div-1">
			<div id="div-2">
					<div id="div-2-1">欢迎管理员：cly，<a href="" class="a1">退出</a></div>
			</div>
			<div id="div-3">
				<div id="div-3-1">
					<div id="div-3-1-2"><button type="button" class="button1" id="init">机票查询\删除</button></div>
					<div id="div-3-1-2"><button type="button"  id="add_ticket">机票添加</button></div>
				</div>
				<div id="div-3-2">
					<form action="./admin/addticket">
					<h3>机票的添加</h3>
					<div id="div-3-2-1">
						<div class="form left">
							<p> <label for="cfd">出发城市</label><!--<br/>--> <input type="text" name="cfd" id="cfd" placeholder="城市名"> </p>
								
						</div>
						<div class="form middle">
								<p> <label for="mdd">返回城市</label><!--<br/>--> <input type="text" name="mdd" id="mdd" placeholder="城市名"> </p>
						</div>
						<div class="form right">
								<p> <label for="rq">出发日期</label><!--<br/>--> <input type="text" name="rq" id="rq" placeholder="日期"> </p>
						</div>
					
				</div>
				<div id="div-3-2-1">

						<div class="form right">
								<p> <label for="hkgs">航 班 号</label><!--<br/>--> <input type="text" name="hkgs" id="hkgs" placeholder="航班号"> </p>
						</div>
						<div class="form right">
								<p> <label for="cfsj">出发时间</label><!--<br/>--> <input type="text" name="cfsj" id="cfsj" placeholder="出发时间"> </p>
						</div>
						<div class="form right">
								<p> <label for="ddsj">到达时间</label><!--<br/>--> <input type="text" name="ddsj" id="ddsj" placeholder="到达时间"> </p>
						</div>
					
				</div>
				<div id="div-3-2-1">
						<div class="form right" style="margin-left: -312px;">
								<p> <label for="sit">座 位 数</label>&nbsp;<input type="text" name="sit" id="sit" placeholder="座位数"> </p>
						</div>
						<div class="form right">
								<p> <label for="jg">价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格</label>&nbsp;<input type="text" name="jg" id="jg" placeholder="价格"> </p>
						</div>
				</div>
				<div class="form button">
					 <button type="submit" class="button2">添加</button> 
				</div>
					</form>
			</div>
		</div>
	</body>
</html>
