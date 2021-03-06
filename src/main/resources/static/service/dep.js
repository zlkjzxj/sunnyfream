layui.config({
    base: '../../static/layui/'
}).extend({
    treetable: 'treetable-lay/treetable'
}).use(['table', 'treetable'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var treetable = layui.treetable;
    console.log(treetable)

    // 渲染表格
    // layer.load(2);
    treetable.render({
        treeColIndex: 1,
        treeSpid: -1,
        treeIdName: 'bmbh',
        treePidName: 'pid',
        elem: '#auth-table',
        url: '/dep',
        page: false,
        cols: [[
            {type: 'numbers'},
            {field: 'bmmc', minWidth: 200, title: '部门名称'},
            {field: 'bmbh', minWidth: 200, title: '成员数'},
            {field: 'bmjb', minWidth: 200, title: '主管'},
            // {field: 'bmjb', title: '部门级别'},
            // {field: 'orderNumber', width: 80, align: 'center', title: '排序号'},
            // {
            //     field: 'isMenu', width: 80, align: 'center', templet: function (d) {
            //         if (d.isMenu == 1) {
            //             return '<span class="layui-badge layui-bg-gray">按钮</span>';
            //         }
            //         if (d.parentId == -1) {
            //             return '<span class="layui-badge layui-bg-blue">目录</span>';
            //         } else {
            //             return '<span class="layui-badge-rim">菜单</span>';
            //         }
            //     }, title: '类型'
            // },
            {templet: '#auth-state', width: 120, align: 'center', title: '操作'}
        ]],
        done: function () {
            layer.closeAll('loading');
        }
    });

    $('#btn-expand').click(function () {
        treetable.expandAll('#auth-table');
    });

    $('#btn-fold').click(function () {
        treetable.foldAll('#auth-table');
    });
});

/*layui.use(['form', 'tree', 'layer'], function () {
    var $ = layui.jquery;
    layui.tree({
        elem: '#depTree',
        nodes: createTree(),
        click: function (node) {
            editDep(node);
        }
    })
    ;

    function createTree() {
        var nodes = "";
        $.ajax({
            url: '/dep',
            method: 'GET',
            dataType: 'json',
            async: false,
            success: function (data) {
                console.log(data.data)
                nodes = data.data;
            },
            error: function (e) {
                // top.layer.close(index);
                top.layer.msg("用户添加失败！");
            }
        })
        return nodes;
    }

    function editDep(node) {
        $("#bmmc").val(node.name);
        $("#bmbh").val(node.bmbh);
        $("#bmjb").val(node.bmjb);
    }
});*/


