layui.use(['form', 'layer', 'jquery'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
    $ = layui.jquery;

    $(".loginBody .seraph").click(function () {
        layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样登录的？还是老老实实的找管理员去注册吧", {
            time: 5000
        });
    })
    // //表单验证
    // form.verify({
    //     required: function (value) {
    //         if (value === '') {
    //             return '用户名不能为空';
    //         }
    //     }
    // })
    //登录按钮
    // form.on("submit(login)", function (formdata) {

    //     return false;
    // })

    //表单输入效果
    $(".loginBody .input-item").click(function (e) {
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function () {
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function () {
        $(this).parent().removeClass("layui-input-focus");
        if ($(this).val() != '') {
            $(this).parent().addClass("layui-input-active");
        } else {
            $(this).parent().removeClass("layui-input-active");
        }
    })
})

function login() {
    $(".layui-form").validate({
        submitHandler: function (form) {
            var userName = $("#userName").val();
            var password = $("#password").val();
            var verifyCode = $("#verifyCode").val();
            var rememberMe = $("input[type='checkbox']").is(':checked');
            console.log("remember", rememberMe);
            $.ajax({
                url: '/login',
                type: 'POST',
                data: {userName: userName, password: password, verifyCode: verifyCode, rememberMe: rememberMe},
                dataType: 'json',
                success: function (data) {
                    if (data.code !== '0') {
                        layer.msg(data.msg);
                        $("#verifyImg").click();
                    } else {
                        window.location.href = "/";
                    }
                },
                error: function (e) {
                    console.log(e);
                }
            })
        }
    });

}
