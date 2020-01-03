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
                    <h2 class="div-title">到店登记</h2>
                </div>
                <div class="layui-card-body">
                    <%--<div id='table'>--%>
                        <%--<!-- 顶部工具栏 -->--%>
                        <%--<div class="map-tools">--%>
                            <%--<button class="layui-btn layui-btn-sm layui-btn-normal"--%>
                                    <%--id='add-toShop'>--%>
                                <%--<i class="layui-icon">&#xe608;</i> 添加--%>
                            <%--</button>--%>
                            <%--<div class="map-search">--%>
                                <%--<div id="r-result">--%>
                                    <%--<input type="text" id="serach-address-key" size="18"--%>
                                           <%--placeholder="搜索"/><i id='search-i' class="layui-icon"--%>
                                                                <%--style="color: #fff;">&#xe615;</i>--%>
                                <%--</div>--%>
                                <%--<div id="searchResultPanel"></div>--%>
                            <%--</div>--%>
                            <%--<div class="search-filter-main">--%>
                                <%--<i id='filter' class="layui-icon">&#xe6b2;</i>--%>
                                <%--<div id='filter-ul-div' class="filter-ul-div">--%>
                                    <%--<form class="layui-form">--%>
                                        <%--<ul id='filter-ul'>--%>
                                            <%--<li><input type="checkbox" value="customer_name"--%>
                                                       <%--title="客户姓名" lay-skin="primary" lay-filter='filter' checked></li>--%>
                                            <%--<li><input type="checkbox" value="customer_contact"--%>
                                                       <%--title="联系方式" lay-skin="primary" lay-filter='filter' checked></li>--%>
                                            <%--<li><input type="checkbox" value="to_shop"--%>
                                                       <%--title="到店方式" lay-skin="primary" lay-filter='filter' checked></li>--%>
                                            <%--<li><input type="checkbox" value="is_to_shop"--%>
                                                       <%--title="是否到店" lay-skin="primary" lay-filter='filter' checked></li>--%>
                                            <%--<li><input type="checkbox" value="reserve_date"--%>
                                                       <%--title="预约到店时间" lay-skin="primary" lay-filter='filter' checked>--%>
                                            <%--</li>--%>
                                            <%--<li><input type="checkbox" value="actual_date"--%>
                                                       <%--title="实际到店时间" lay-skin="primary" lay-filter='filter' checked>--%>
                                            <%--</li>--%>
                                            <%--<hr>--%>
                                            <%--<li id='close-filter' style="cursor: pointer;"><i--%>
                                                    <%--class="layui-icon">&#x1006;</i>关闭--%>
                                            <%--</li>--%>
                                        <%--</ul>--%>
                                    <%--</form>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<!-- 顶部工具栏 end-->--%>
                        <%--<table class="layui-hide" id="toShop" lay-filter="toShop"></table>--%>
                    <%--</div>--%>
                    <div id='toShop-content'>
                        <!-- 顶部工具栏 -->
                        <%--<div class="map-tools">--%>
                            <%--<button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>--%>
                                <%--<i class="layui-icon">&#xe65c;</i> 返回--%>
                            <%--</button>--%>
                        <%--</div>--%>

                        <div class="layui-card-body">
                            <form class="layui-form" id='update-toShop-form' accept-charset="UTF-8">
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>客户姓名</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="customer_name" id='customer_name' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>联系方式 </label>
                                        <div class="layui-input-block">
                                            <input type="text" name="customer_contact" id="customer_contact" required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>所属渠道 </label>
                                        <div class="layui-input-block">
                                            <select name="channel_id" id="channel_id" lay-filter="channel_id"
                                                    lay-verify="required">
                                                <option value="">请选择</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>所属活动 </label>
                                        <div class="layui-input-block">
                                            <select name="marketing_id" id="marketing_id"
                                                    lay-verify="required">
                                                <option value="">请选择</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>



                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>到店时间 </label>
                                        <div class="layui-input-block">
                                            <input type="text" name="tel_time" id="tel_time" lay-verify="required"
                                                   placeholder="yyyy-MM-dd HH:mm:ss"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>录入日期 </label>
                                        <div class="layui-input-block">
                                            <input type="text" class="layui-input" id="entry_date"
                                                   name="entry_date" lay-verify="required"
                                                   placeholder="yyyy-MM-dd" readonly="readonly">
                                        </div>
                                    </div>
                                </div>

                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>到店方式 </label>
                                        <div class="layui-input-block">
                                            <select name="to_shop" id="to_shop" lay-verify="required"
                                                    readonly="readonly">
                                                <option value="">请选择</option>
                                                <option value="带到访">带到访</option>
                                                <option value="直接上门">直接上门</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <%--<div--%>
                                        <%--class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">--%>
                                    <%--<div class="layui-form-item layui-form-text">--%>
                                        <%--<label class="layui-form-label">&nbsp;&nbsp;预约到店 </label>--%>
                                        <%--<div class="layui-input-block">--%>
                                            <%--<input type="text" name="reserve_date" id="reserve_date"--%>
                                                   <%--placeholder="yyyy-MM-dd HH:mm:ss"--%>
                                                   <%--autocomplete="off" class="layui-input" readonly="readonly">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <%--<div--%>
                                        <%--class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">--%>
                                    <%--<div class="layui-form-item">--%>
                                        <%--<label class="layui-form-label">&nbsp;&nbsp;是否到店 </label>--%>
                                        <%--<div class="layui-input-block">--%>
                                            <%--<select name="is_to_shop" id="is_to_shop" readonly="readonly">--%>
                                                <%--<option value="">请选择</option>--%>
                                                <%--<option value="是">是</option>--%>
                                                <%--<option value="否">否</option>--%>
                                            <%--</select>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <%--<div--%>
                                        <%--class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">--%>
                                    <%--<div class="layui-form-item layui-form-text">--%>
                                        <%--<label class="layui-form-label">&nbsp;&nbsp;实际到店 </label>--%>
                                        <%--<div class="layui-input-block">--%>
                                            <%--<input type="text" class="layui-input" id="actual_date"--%>
                                                   <%--name="actual_date" placeholder="yyyy-MM-dd HH:mm:ss" readonly="readonly">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <div class="layui-form-item my-form-item" id="submit-button">
                                    <div class="layui-btn-group">
                                        <button class="layui-btn my-button" lay-submit
                                                lay-filter="updateToShop" id="add-change">添加
                                        </button>
                                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看/编辑</a>
</script>--%>

<%--<script type="text/html" id="stateTp1">
    {{#  var myDate = new Date(); }}
    {{#  if(d.reserve_date != null) { }}
    {{#  if(d.is_to_shop === null || d.is_to_shop==='') { }}
    {{#  if((d.reserve_date.time - myDate.getTime()) < 0) { }}
    <span style="color: #d82b2b;">{{ d.reserve_date_str }}</span>
    {{#  } else if((d.reserve_date.time - myDate.getTime()) < 86400000) { }}
    <span style="color: #FFB800;">{{ d.reserve_date_str }}</span>
    {{#  } else { }}
    <span style="color: #20c12e;">{{ d.reserve_date_str }}</span>
    {{#  }  }}
    {{#  } else { }}
    <span>{{ d.reserve_date_str }}</span>
    {{#  }  }}
    {{#  }  }}
</script>--%>

<%--<script type="text/html" id="toolBar">
    <span class="layui-badge layui-bg-red">过时未约见</span>
    <span class="layui-badge layui-bg-orange">不足24小时</span>
    <span class="layui-badge layui-bg-green">超过24小时</span>
</script>--%>

<script src="layui/layui.js"></script>
<script src="res/js/header.js"></script>
</body>
<script>
    layui.use(['table', 'jquery', 'form', 'laydate'], function () {
        var table = layui.table;
        var laydate = layui.laydate;
        var $ = jQuery = layui.jquery;
        var form = layui.form;
        var opID = '';// 需要操作的 数据id
        var key = '';
        var type = 0;
        var staff_id = '${staff.staff_id}';
        var staff_name='${staff.staff_name}';
        var campus_id = '${staff.campus_id}';

        //到店时间
        laydate.render({
            elem: '#tel_time'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#entry_date'
            ,type: 'datetime'
        });



        // 监听提交
        form.on('submit(updateToShop)', function (data) {
            var url = "";

            url = "saleOrder/addInitAndSaleByComeToShop?"
                    + $("#update-toShop-form").serialize() + "&order_staff_id=" + staff_id+"&collect_name="+staff_name+
                                                          "&collect_tel="+"11111";

            $.ajax({
                type: "post",
                url: url,
                async: true,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == 100) {
                        layer.confirm('已完成', {
                            icon: 1,
                            title: '提示'
                        }, function (index) {
                            layer.close(index);
                            window.location.href = "gotoSale";
                        });
                    } else if (jsonData.code == 101) {
                        layer.confirm('身份已过期，请重新登录', {
                            icon: 2,
                            title: '提示'
                        }, function (index) {
                            layer.close(index);
                            window.location.href = "gotoLogin";
                        });
                    } else if (jsonData.code == 102) {
                        layer.msg("访问受限，权限不足");
                    } else {
                        layer.msg("未知错误");
                    }
                },
                error: function (jqObj) {
                }
            });

            return false;
        });

        var channel_id='';
        // 获取所有市场活动
        $.ajax({
            url: "channel/findAllChannelNameByStaff?campus_id=" + campus_id,
            type: "get",
            success: function (data) {
                var jsonData = JSON.parse(data);
                var op = "<option value='' selected>全部渠道类型</option>";
                for (var x in jsonData.data) {
                    op += "<option value='" + jsonData.data[x].channel_id + "'>" + jsonData.data[x].channel_type + "</option>";
                }
                $("#channel_id").html(op);
                form.render("select");

            }
        });


        form.on('select(channel_id)', function () {
            channel_id = $("#channel_id").val();
            $.ajax({
                url: "marketing/findAllMarketingNameByChannel?channel_id=" + channel_id,
                type: "get",
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    var op = "<option value=''>对应市场活动</option>";
                    for (var x in jsonData.data) {
                        op += "<option value='" + jsonData.data[x].marketing_id + "'>" + jsonData.data[x].marketing_name + "</option>";
                    }
                    $("#marketing_id").html(op);
                    form.render("select");
                }
            })
        });
/*
        // 搜索工具 start
        var filter = new Set();// 需要查询的字段
        filter.add("customer_name");
        filter.add("customer_contact");
        filter.add("to_shop");
        filter.add("reserve_date");
        filter.add("is_to_shop");
        filter.add("actual_date");
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
            table.reload('toShop', {
                url: 'toShop/findAllShopsById?key=' + key + '&filter=' + Array.from(filter) + '&staff_id=' + staff_id,
            });
        }

        // 搜索工具 end

        // 添加按钮点击事件
        $('#add-toShop').on('click', function () {
            // 添加方法
            type = 0;
            $('#customer_name').val("");
            $('#customer_contact').val("");
            $('#to_shop').val("");
            $('#reserve_date').val("");
            $('#is_to_shop').val("");
            $('#actual_date').val("");
            $('#add-change').html('添加');
            $("#table").slideUp('', function () {
                $("#toShop-content").slideDown();
            });
            form.render(); // 更新全部000
        });

        // 返回按按钮点击事件
        $('#back').on('click', function () {
            $("#toShop-content").slideUp('', function () {
                $("#table").slideDown();
            });
        });
    */
        // 重载表格 防止拉伸
        window.reloadTable = function () {
            toShopTable.reload();
        };
    });
</script>
</html>