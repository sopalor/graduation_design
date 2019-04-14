<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>

		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="./css/ad registration.css" />
		<link rel="stylesheet" href="./css/user_login.css" />
		<script src="./js/jquery-1.4.2.min.js"></script>
		<script src="./js/ad_registration.js"></script>
	</head>
	<body>
		<div id="div01-1">
		    <div id="search">
					<div class="center">
						<figcaption>管理员注册<font class="change">/<a href="user_registration.jsp" class="a1">用户注册</a></font></figcaption>
						
					    
					    	<table class="table">
					    		<tr>
					    			<td>用户名</td>
					    			<td>
					    				<input id="name" type="text" class="table_1" placeholder="请输入用户名">
					    			</td>
					    		</tr>
					    		<tr>
					    			<td>密&nbsp;&nbsp;&nbsp;码</td>
					    			<td><input id="password" type="password" class="table_1" placeholder="请输入密码"></td>
					    		</tr>
					    	</table>
					    	<button class="button" id="registration">注&nbsp;&nbsp;册</button>
					    	
					    <figcaption class="register"><a href="ad_login.jsp" class="a1">返回</a></figcaption>
					</div> 
		    </div>
		</div>
	</body>
</html>
