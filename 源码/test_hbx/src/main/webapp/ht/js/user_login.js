$(document).ready(function(){

    // 开始写 jQuery 代码...
    $('#login').click(function(){
        $.ajax({
            url: "user/login",
            dataType : "json",
            type: "post",
            data: {"name":$('#name').val(),"password":$('#password').val()},
            success:function(data){
                alert(data.demo);
            },
            error: function() {
                alert("ajax执行失败");
            }
        });


    })
});