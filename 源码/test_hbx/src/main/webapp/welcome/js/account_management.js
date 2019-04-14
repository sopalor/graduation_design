$(document).ready(function(){
    var sex=$('hidden_sex').val();
    if(sex=='男')
    $("input[name='sex']").eq(0).attr('checked',true);
    else
        $("input[name='sex']").eq(1).attr('checked',true);

});