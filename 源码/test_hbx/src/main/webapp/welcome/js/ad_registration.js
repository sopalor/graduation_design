$(document).ready(function(){

    // 开始写 jQuery 代码...
    $('#registration').click(function(){
        $.ajax({
            url: "../user/registration",
            dataType : "json",
            type: "post",
            data: {"name":$('#name').val(),"password":$('#password').val()},
            success:function(data){
                if(data.flag=='success') {
                    alert("注册成功");
                    window.location.href = "./user_login.jsp";
                }
                else
                    alert("注册失败");
            },
            error: function() {
                alert("ajax执行失败");
            }
        });


    })
});