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
		<link rel="stylesheet" href="./welcome/css/home_page.css" />
		<link rel="stylesheet" href="./welcome/css/user login.css" />
		<link rel="stylesheet" href="./welcome/css/check_my_ticket.css" />
		<link rel="stylesheet" href="./welcome/css/pay.css" />
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
						<div class="new">
							<h2>支付</h2>
							<div class="back">
								<a href="../ticket/init?id=${sessionScope.id}" class="a2" >返回</a>
							</div>
							<form onsubmit="" name="form3">
							<table class="table_4" cellpadding="0" cellspacing="0" rules="all" border-color="#666666">
								<tbody>
									<tr>
										<td style="width: 150px;">姓名</td>
										<td>${sessionScope.user.CName}</td>
										<td style="width: 150px;">出发时间</td>
										<td>${requestScope.ticket.DCfsj}</td>
									</tr>
								
									<tr>
										<td>出发城市</td>
										<td>${requestScope.ticket.CCfd}</td>
										<td>到达城市</td>
										<td>${requestScope.ticket.CMdd}</td>
									</tr>
									<tr>
										<td>航班号</td>
										<td>${requestScope.ticket.CHkgs}</td>
										<td>座位号</td>
										<td>${requestScope.sit}</td>
									</tr>
										<tr>
										<td>身份证号码</td>
										<td colspan="3">${sessionScope.user.CSfzh}</td>

									</tr>
								</tbody>
								
							</table>
							</form>
							<div class="payy">
								<font class="money">¥${requestScope.ticket.FZk}</font><button type="submit" class="button3" id="checkmoney">确认支付</button>
							</div>
						</div>
					</div>
						
						
					</div>
		
				</div>
			

		</div>
	</body>
<script>
    $(document).ready(function(){

        // 开始写 jQuery 代码...


		$('#checkmoney').click(function () {
			window.location.href='../user_ticket/add_user_ticket?id=${requestScope.ticket.CId}'
        })
    });
</script>
</html>
