/**
 * Created by huchao on 2017/6/9.
 */
//全局js，用于控制公共事件监听
(function($){
    function test_phone(phone){
        var mobile_phone = /^1(3[0-9]|4[57]|5[0-35-9]|7[01678]|8[0-9])\d{8}$/
        var fixed_phone = /(^0\d{2,3}|400)-?\d{7,8}$/
        var res = mobile_phone.test(phone)||fixed_phone.test(phone);
        return res;
    }
    $("#requetPhone").click(function(){
        $("#requetPhone").attr("disabled", false);
        var condition = $('#condition').val();
        res = test_phone(condition)
        phone_json = {
            "haoma":condition
        };
        var json_str = JSON.stringify(phone_json);
        var phone_img = $("#phone_image");
        if (res){
            $('.error_info').hide();
            $.ajax({
                type:'post',
                url:'/requestPhone',
                contentType:'application/json;charset=utf-8',
                data:json_str,
                success:function(data){
                    $("#phone_user").attr("src","/resources/images/user.png")
                    var mark_span1 = $("#marker").find("span").get(0)
                    var mark_span2 = $("#marker").find("span").get(1)
                    var mark_span3 = $("#marker").find("span").get(2)

                    if(data.bj_leixing){
                        $(phone_img).attr('src','/resources/images/phone_red.png');
                        $(mark_span1).text(data.bj_leixing);
                        $(mark_span2).text(data.jb_cishu+"人标记");
                        $(mark_span3).text(phone_json['haoma']);
                    }else{
                        $(phone_img).attr('src','/resources/images/phone_blue.png');
                        $(mark_span1).text("正常号码");
                        $(mark_span2).text("0人标记");
                        $(mark_span3).text(phone_json['haoma'])
                    }
                }
            });
        }else{
            $('.error_info').show();
            $("#phone_user").attr("src","")
            $("#marker").find("span").text(" ")
            $(phone_img).attr('src','/resources/images/phone_default.png');
        }
    });
})($)