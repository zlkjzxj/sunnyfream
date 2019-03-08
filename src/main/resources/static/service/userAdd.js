layui.use(['form', 'layer', 'laydate'], function () {
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    form.on("submit(addUser)", function (data) {
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});

        $.ajax({
            url: '/user',
            method: 'POST',
            data: data.field,
            dataType: 'json',
            success: function (data) {
                console.log(data);
                top.layer.close(index);
                top.layer.msg("用户添加成功！");
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            },
            error: function (e) {
                top.layer.close(index);
                top.layer.msg("用户添加失败！");
                layer.closeAll("iframe");
            }
        })

        return false;
    })
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#yhyxq'
    });
    laydate.render({
        elem: '#mmyxy'
    });
    laydate.render({
        elem: '#csrq'
    });

    //格式化时间
    function filterTime(val) {
        if (val < 10) {
            return "0" + val;
        } else {
            return val;
        }
    }

    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear() + '-' + filterTime(time.getMonth() + 1) + '-' + filterTime(time.getDate()) + ' ' + filterTime(time.getHours()) + ':' + filterTime(time.getMinutes()) + ':' + filterTime(time.getSeconds());

})