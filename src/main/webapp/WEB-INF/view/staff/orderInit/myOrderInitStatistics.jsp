<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">
<link rel="stylesheet" href="res/css/admin/recConfiguration.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">

<div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <div class="layui-card-header"><h2 class="div-title">我的毛单统计</h2></div>
        <div class="layui-card-body"></div>
        <div id='table'>
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="map-tools">


                            <div class="layui-form" style="display: inline-block;">
                                <div class="layui-form-item layui-form-text"
                                     style="margin-bottom: 0px;">
                                    <label class="layui-form-label">统计起始时间</label>
                                    <div class="layui-input-inline" style="margin-top: 5px">
                                        <input type="text" class="layui-input" style="height: 30px"
                                               id="time-start" name="time-start" lay-filter="time-start"
                                               placeholder="yyyy-MM-dd" readonly ="readonly">
                                    </div>
                                </div>
                            </div>

                            <div class="layui-form" style="display: inline-block;">
                                <div class="layui-form-item layui-form-text"
                                     style="margin-bottom: 0px;">
                                    <label class="layui-form-label">统计结束时间</label>
                                    <div class="layui-input-inline" style="margin-top: 5px">
                                        <input type="text" class="layui-input" style="height: 30px"
                                               id="time-end" name="time-end" lay-filter="time-end"
                                               placeholder="yyyy-MM-dd" readonly ="readonly">
                                    </div>
                                </div>
                            </div>
                            <button class="layui-btn layui-btn-sm layui-btn-normal" id='statistics'>
                                <i class="layui-icon">&#xe62a;</i> 统计该时间段
                            </button>


                            <div class="map-search">
                                <div id="r-result">
                                    <input type="text" id="serach-address-key" size="18"
                                           placeholder="搜索"/><i id='search-i' class="layui-icon"
                                                                style="color: #fff;">&#xe615;</i>
                                </div>
                                <div id="searchResultPanel"></div>
                            </div>
                            <div class="search-filter-main">
                                <i id='filter' class="layui-icon">&#xe6b2;</i>
                                <div id='filter-ul-div' class="filter-ul-div">
                                    <form class="layui-form">
                                        <ul id='filter-ul'>
                                            <li><input type="checkbox" value="sum_num"
                                                       title="总毛单数" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="state_num_one"
                                                       title="接通-有意到店" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="state_num_two"
                                                       title="接通-待定" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="state_num_three"
                                                       title="接通-拒绝" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="state_num_four"
                                                       title="未接通" lay-skin="primary" lay-filter='filter' checked></li>

                                            <hr>
                                            <li id='close-filter' style="cursor: pointer;"><i
                                                    class="layui-icon">&#x1006;</i>关闭
                                            </li>
                                        </ul>
                                    </form>
                                </div>
                            </div>

                            <div class="layui-form" style="display: inline-block;float: right;" >
                                <div class="layui-form-item layui-form-text">
                                    <div class="layui-input-block"></div>
                                </div>
                            </div>

                        </div>


                    </div>
                </div>
            </div>
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <table class="layui-hide" id="post" lay-filter="post"></table>
                    </div>
                </div>
            </div>
        </div>

    </div>


</div>

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详细</a>
</script>


<script>
    layui.use(['table', 'jquery', 'form', 'element', 'laydate'], function () {
        var table = layui.table;
        var $ = jQuery = layui.jquery;
        var form = layui.form;
        var element = layui.element;
        var laydate = layui.laydate;
        var month_start = '';
        var month_end = '';
        var staff_id = '${staff.staff_id}';
        var campus_id = '${staff.campus_id}';



        // 选择月份
        laydate.render({
            elem: '#time-start',
            type: 'date'
        });
        laydate.render({
            elem: '#time-end',
            type: 'date'
        });



        var postTable = table.render({
            elem: '#post',
            url: 'orderinit/findAllMyOrderInitStatisticsList?staff_id='+staff_id,
            toolbar: '#toolBar1',
            title: '渠道时间段统计',
            page: true,
            totalRow: true, //开启合计行
            cols: [[{
                title: '编号',
                type: 'numbers',
                fixed: 'left',
                width: 70
            }, {
                field: 'sum_num',
                title: '总毛单数',
                sort: true,
                minWidth: 100
            }, {
                field: 'state_num_one',
                title: '接通-有意到店',
                minWidth: 100,
                sort: true
            }, {
                field: 'state_proportion_one',
                title: '占比',
                sort: true,
                minWidth: 100
            }, {
                field: 'state_num_two',
                title: '接通-待定',
                minWidth: 100,
                sort: true
            }, {
                field: 'state_proportion_two',
                title: '占比',
                sort: true,
                minWidth: 100
            }, {
                field: 'state_num_three',
                title: '接通-拒绝',
                minWidth: 100,
                sort: true
            }, {
                field: 'state_proportion_three',
                title: '占比',
                sort: true,
                minWidth: 100
            }, {
                field: 'state_num_four',
                title: '未接通',
                minWidth: 100,
                sort: true
            }, {
                field: 'state_proportion_four',
                title: '占比',
                sort: true,
                minWidth: 100
            }]],
            success: function (data) {
                console.log(data.time_start);
                console.log(data.time_end);
                $("#time-start").val(data.time_start);
                $("#time-end").val(data.time_end);

            }

        });



        // 排序事件
        table.on('sort(post)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
            table.reload('post', {
                initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
                ,
                where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                    field: obj.field // 排序字段
                    ,
                    order: obj.type
                    // 排序方式
                }
            });
        });

        // 结算当前月份
        $('#statistics').on("click", function () {
            month_start = $("#time-start").val();
            month_end   = $("#time-end").val();


            if (month_start == '') {
                layer.msg("请选择需要统计的开始时间")
                return false;
            }
            if (month_end == '') {
                layer.msg("请选择需要统计的结束时间")
                return false;
            }
            $.ajax({
                type: "get",
                url: "orderinit/updateStatisticsByTime?time_start=" + month_start +"&time_end="+month_end+"&staff_id="+staff_id,
                async: true,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == 100) {

                        table.reload('post', {
                            url: 'orderinit/findAllMyOrderInitStatisticsList?staff_id='+staff_id
                        });


                    }
                },
                error: function (jqObj) {

                }
            });
            return false;
        });





        // 搜索工具 start
        var filter = new Set();// 需要查询的字段
        filter.add("sum_num");
        filter.add("state_num_one");
        filter.add("state_num_two");
        filter.add("state_num_three");
        filter.add("state_num_four");
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
            searchAdd($("#serach-address-key").val());
        });
        // 输入框回车事件
        $('#serach-address-key').bind('keypress', function (event) {
            if (event.keyCode == "13") {
                searchAdd($("#serach-address-key").val());
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
        function searchAdd(key) {
            $("#filter-ul-div").fadeOut();
            table.reload('post', {
                url: 'orderinit/findAllMyOrderInitStatisticsList?key=' + key + '&filter=' + Array.from(filter) +'&staff_id='+staff_id
            });
        }

        // 搜索工具 end





        // 重载表格 防止拉伸
        window.reloadTable = function () {
            postTable.reload();
        };
        form.render();
    });

</script>
</html>