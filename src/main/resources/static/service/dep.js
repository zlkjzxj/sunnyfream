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
            {field: 'bmbh', minWidth: 200, title: '部门编号'},
            {field: 'bmjb', title: '部门级别'},
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
            // layer.closeAll('loading');
        }
    });

    $('#btn-expand').click(function () {
        treetable.expandAll('#auth-table');
    });

    $('#btn-fold').click(function () {
        treetable.foldAll('#auth-table');
    });
});