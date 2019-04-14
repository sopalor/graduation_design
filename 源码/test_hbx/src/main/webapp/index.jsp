<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019/4/13
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>

<head>
    <meta charset="utf-8" />
    <title></title>
    <link rel="stylesheet" href="welcome/css/user_login.css" />
    <script src="welcome/js/jquery-1.4.2.min.js"></script>
</head>
<body>
<div id="div01-1">
    <div id="search">
        <div class="center">
            <figcaption>用户登录<font class="change">/<a href="welcome/ad_login.html" class="a1">管理员登录</a></font></figcaption>


            <table class="table">
                <tr>
                    <td>用户名</td>
                    <td>
                        <input type="text" id="name" class="table_1" placeholder="请输入用户名">
                    </td>
                </tr>
                <tr>
                    <td>密&nbsp;&nbsp;&nbsp;码</td>
                    <td><input type="password" id="password" class="table_1" placeholder="请输入密码"></td>
                </tr>
            </table>
            <button class="button" id="login">登录</button>

            <figcaption class="register"><a href="welcome/user_registration.jsp" class="a1">点击注册</a></figcaption>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){

        // 开始写 jQuery 代码...
        $('#login').click(function(){
            $.ajax({
                url: "user/login",
                dataType : "json",
                type: "post",
                data: {"name":$('#name').val(),"password":$('#password').val()},
                success:function(data){

                    if(data.flag=='success')
                        window.location.href="./ticket/init?id="+data.id;
                    else
                        alert("登陆失败");
                },
                error: function() {
                    alert("ajax执行失败");
                }
            });


        })
    });
</script>
</body>
</html>
