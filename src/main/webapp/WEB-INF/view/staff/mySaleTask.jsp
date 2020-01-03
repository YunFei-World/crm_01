<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>销售管理</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="res/css/my.css">
    <link rel="stylesheet" media="screen and (min-width:1200px)"
          href="res/css/max.css">
    <link rel="stylesheet"
          media="screen and (min-width:800px) and (max-width:1200px)"
          href="res/css/mid.css">
    <link rel="stylesheet" media="screen and (max-width:800px)"
          href="res/css/min.css">
    <link rel="stylesheet" href="res/css/admin/addressManage.css">
    <link rel="stylesheet" href="res/css/admin/departmentManage.css">
    <link rel="stylesheet" href="res/css/admin/addStaff.css">
    <link rel="stylesheet" href="res/css/admin/myMarketing.css">
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <%@ include file="saleHeader.jsp" %>
    <div class="layui-body" id='body-div' style="padding: 20px;">
        <div
                class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-header">
                    <h2 class="div-title">我的销售任务</h2>
                </div>
                <div class="layui-card-body">
                    <div id='table'>
                        <div class="map-tools" style="display: flex">
                            <div class="search-filter-main">
                                <i id='filter' class="layui-icon">&#xe6b2;</i>
                                <div id='filter-ul-div' class="filter-ul-div">
                                    <form class="layui-form">
                                        <ul id='filter-ul'>
                                            <li><input type="checkbox" value="staff_name"
                                                       title="员工姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="month"
                                                       title="分配月份" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="month_task"
                                                       title="月任务" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="load_time"
                                                       title="分配时间" lay-skin="primary" lay-filter='filter' checked></li>
                                            <hr>
                                            <li id='close-filter' style="cursor: pointer;"><i
                                                    class="layui-icon">&#x1006;</i>关闭
                                            </li>
                                        </ul>
                                    </form>
                                </div>
                            </div>
                            <div class="map-search">
                                <div id="r-result">
                                    <input type="text" id="serach-address-key" size="18"
                                           placeholder="搜索"/><i id='search-i' class="layui-icon"
                                                                style="color: #fff;">&#xe615;</i>
                                </div>
                                <div id="searchResultPanel"></div>
                            </div>
                        </div>
                        <table class="layui-hide" id="post" lay-filter="post"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="layui/layui.js"></script>
<script src="res/js/header.js"></script>
</body>
<script>
    layui.use(['table', 'jquery', 'form'], function () {
        var table = layui.table;
        var $ = jQuery = layui.jquery;
        var form = layui.form;
        var key = '';
        var staff_id = '${staff.staff_id}';

        // 获取表格数据
        var saleTaskTable = table.render({
            elem: '#post',
            url: 'staff/getSaleTaskById?staff_id=' + staff_id,
            toolbar: '#toolBar',
            title: '上班地点',
            cols: [[{
                title: '编号',
                type: 'numbers',
                fixed: 'left',
                width: 70
            }, {
                field: 'staff_name',
                title: '员工姓名',
                minWidth: 100,
                sort: true
            },{
                field: 'month',
                title: '统计月份',
                minWidth: 100,
                sort: true
            }, {
                field: 'month_task',
                title: '月任务',
                minWidth: 100,
                sort: true
            }, {
                field: 'week_one',
                title: '第一周',
                minWidth: 100,
                sort: true
            }, {
                field: 'week_two',
                title: '第二周',
                minWidth: 100,
                sort: true
            }, {
                field: 'week_three',
                title: '第三周',
                minWidth: 100,
                sort: true
            }, {
                field: 'week_four',
                title: '第四周',
                minWidth: 100,
                sort: true
            }, {
                field: 'week_five',
                title: '第五周',
                minWidth: 100,
                sort: true
            }, {
                field: 'week_six',
                title: '第六周',
                minWidth: 100,
                sort: true
            },{
                field: 'load_time_str',
                title: '分配时间',
                minWidth: 200
            }]],
            page: true
        });

        // 排序事件
        table.on('sort(post)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
            table.reload('post', {
                initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
                , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                    field: obj.field // 排序字段
                    , order: obj.type
                    // 排序方式
                }
            });
        });

        // 搜索工具 start
        var filter = new Set();// 需要查询的字段
        filter.add("staff_name");
        filter.add("month");
        filter.add("month_task");
        filter.add("load_time");

        form.render();
        // 字段拦截按钮事件
        $('#filter').on('click', function () {
            $("#filter-ul-div").fadeToggle();
        });
        // 字段拦截收起按钮事件
        $('#close-filter').on('click', function () {
            $("#filter-ul-div").fadeToggle();
        });
        // 搜索按钮事件
        $('#search-i').on('click', function () {
            key = $("#serach-address-key").val();
            searchAdd();
        });
        // 输入框回车事件
        $('#serach-address-key').bind('keypress', function (event) {
            key = $("#serach-address-key").val();
            if (event.keyCode == "13") {
                searchAdd();
            }
        });
        // 查询字段修改事件
        form.on('checkbox(filter)', function (data) {
            if (data.elem.checked) {
                filter.add(data.value);
            } else if (filter.size > 1) {
                filter.delete(data.value);
            } else {
                layer.msg("至少选择一个");
                data.elem.checked = true;
                form.render('checkbox');
            }
        });

        // 开始查询
        function searchAdd() {
            $("#filter-ul-div").fadeOut();
            table.reload('post', {
                url: 'staff/getSaleTaskById?key=' + key + '&filter=' + Array.from(filter) + '&staff_id=' + staff_id
            });
        }
        // 搜索工具 end

        // 重载表格 防止拉伸
        window.reloadTable = function () {
            saleTaskTable.reload();
        };
    });
</script>
</html>