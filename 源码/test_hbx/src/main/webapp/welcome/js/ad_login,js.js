$(document).ready(function(){

    // 开始写 jQuery 代码...
    $('#login').click(function(){
        $.ajax({
            url: "../user/login",
            dataType : "json",
            type: "post",
            data: {"name":$('#name').val(),"password":$('#password').val()},
            success:function(data){
                if(data.flag=='success')
                    window.location.href="./ticket/init?id="+data.id;
                else
                    if(data.flag=='admin')
                        window.location.href="./admin/init";
                    else
                    alert("登陆失败");
            },
            error: function() {
                alert("ajax执行失败");
            }
        });


    })
});