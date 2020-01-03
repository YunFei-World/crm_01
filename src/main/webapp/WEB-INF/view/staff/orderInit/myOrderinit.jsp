<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

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



<div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <div class="layui-card-header">
            <h2 class="div-title">毛单列表</h2>
        </div>
        <div class="layui-card-body">
            <div id='table'>
                <!-- 顶部工具栏 -->
                <div class="map-tools">
                    <button class="layui-btn layui-btn-sm layui-btn-normal"
                            id='add-orderinit'>
                        <i class="layui-icon">&#xe608;</i> 添加
                    </button>
                    <button class="layui-btn layui-btn-sm layui-btn-warm"
                            id='down-format'>
                        <i class="layui-icon">&#xe601;</i> 模板下载
                    </button>
                    <button class="layui-btn layui-btn-sm layui-btn-warm"
                            id='add-article'>
                        <i class="layui-icon"></i> 毛单导入
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
                                    <li><input type="checkbox" value="customer_name"
                                               title="家长姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="customer_contact"
                                               title="联系方式" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="channel_type"
                                               title="所属渠道" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="marketing_name"
                                               title="活动名称" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="collect_name"
                                               title="收集人姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="collect_tel"
                                               title="收集人电话" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="stu_name"
                                               title="学生姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="stu_age"
                                               title="学生年龄" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="stu_school"
                                               title="学生学校" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="address"
                                               title="学生住址" lay-skin="primary" lay-filter='filter' checked></li>

                                    <li><input type="checkbox" value="entry_real"
                                               title="录入日期" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="assign_staff_name"
                                               title="分配给" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="effective"
                                               title="有效性" lay-skin="primary" lay-filter='filter' checked></li>


                                    <hr>
                                    <li id='close-filter' style="cursor: pointer;"><i
                                            class="layui-icon">&#x1006;</i>关闭
                                    </li>
                                </ul>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- 顶部工具栏 end-->

                <table class="layui-hide" id="initorder" lay-filter="initorder"></table>


            </div>


            <div id='orderinit-content' style="display: none">
                <!-- 顶部工具栏 -->
                <div class="map-tools">
                    <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                        <i class="layui-icon">&#xe65c;</i> 返回
                    </button>
                </div>



                <div class="layui-card-body">
                    <form class="layui-form" id='update-orderinit-form' accept-charset="UTF-8">
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item">
                                <label class="layui-form-label"><a style="color: red;">*
                                </a>家长姓名</label>
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
                                </a>学生姓名 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="stu_name" id="stu_name" required
                                           lay-verify="required" placeholder="请输入"
                                           autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">学生年龄 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="stu_age" id="stu_age"  placeholder="请输入"
                                           autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">学生学校 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="stu_school" id="stu_school"  placeholder="请输入"
                                           autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">学生住址 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="address" id="address"  placeholder="请输入"
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
                                    <select name="marketing_id" id="marketing_id" lay-filter="marketing_id"
                                            lay-verify="required">
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item">
                                <label class="layui-form-label"><a style="color: red;">*
                                </a>收集人姓名 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="collect_name" id='collect_name' required
                                           lay-verify="required" placeholder="请输入"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label"><a style="color: red;">*
                                </a>收集人电话 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="collect_tel" id="collect_tel" required
                                           lay-verify="required" placeholder="请输入"
                                           autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                        </div>


                        <div class="layui-form-item my-form-item" id="submit-button">
                            <div class="layui-btn-group">
                                <button class="layui-btn my-button" lay-submit
                                        lay-filter="updateOrderinit" id="add-change">修改
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

<script type="text/html" id="stateTp2">
    {{#  if(d.effective === 'd.未接通'){ }}
    <span style="color: #d82b2b;">{{ d.effective }}</span>
    {{#  } else if(d.effective === 'a.接通-有意到店') { }}
    <span style="color: #20c12e;">{{ d.effective}}</span>
    {{#  } else if(d.effective === 'b.接通-待定') { }}
    <span style="color: #FFB800;">{{ d.effective}}</span>
    {{#  } else if(d.effective === 'c.接通-拒绝') { }}
    <span style="color: #d82b2b;">{{ d.effective}}</span>
    {{#  } }}
</script>

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看/编辑</a>
</script>


<script>
    layui.use(['table', 'jquery', 'form', 'laydate', 'upload'], function () {
        var table = layui.table;
        var laydate = layui.laydate;
        var $ = jQuery = layui.jquery;
        var form = layui.form;
        var upload = layui.upload;


        var opID = '';// 需要操作的 数据id
        var key = '';
        var type = 0;
        var staff_id = '${staff.staff_id}';
        var campus_id = '${staff.campus_id}';



        //录入日期
        laydate.render({
            elem: '#entry_date',
            theme: 'date'
        });

        // 获取表格数据
        var initorderTable = table.render({
            elem: '#initorder',
            url: 'orderinit/findAllOrderById?staff_id=' + staff_id,
            toolbar: '#toolBar',
            title: '毛单列表',
            cols: [[{
                title: '编号',
                type: 'numbers',
                width: 70
            }, {
                field: 'customer_name',
                title: '家长姓名',
                minWidth: 100,
                sort: true
            }, {
                field: 'customer_contact',
                title: '联系方式',
                minWidth: 120,
                sort: true
            }, {
                field: 'stu_name',
                title: '学生姓名',
                minWidth: 100,
                sort: true
            }, {
                field: 'stu_age',
                title: '学生年龄',
                minWidth: 100,
                hide:true,
                sort: true
            }, {
                field: 'stu_school',
                title: '学生学校',
                minWidth: 100,
                hide:true,
                sort: true
            }, {
                field: 'address',
                title: '学生住址',
                minWidth: 100,
                hide:true,
                sort: true
            }, {
                field: 'channel_type',
                title: '渠道类型',
                minWidth: 100,
                sort: true
            }, {
                field: 'marketing_name',
                title: '活动名称',
                minWidth: 100,
                sort: true
            }, {
                field: 'collect_name',
                title: '收集人姓名',
                minWidth: 100,
                sort: true
            }, {
                field: 'collect_tel',
                title: '收集人电话',
                hide:true,
                minWidth: 120,
                sort: true
            }, {
                field: 'entry_real_str',
                title: '录入日期',
                minWidth: 120
            },{
                field: 'assign_staff_name',
                title: '分配给',
                minWidth: 100,
                sort: true
            },{
                field: 'effective',
                title: '状态',
                minWidth: 100,
                templet: '#stateTp2',
                sort: true
            }, {
                title: '操作',
                toolbar: '#opreationBar',
                width: 120,
                fixed: 'right'
            }]],
            page: true
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








        // 排序事件
        table.on('sort(initorder)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
            table.reload('initorder', {
                initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
                , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                    field: obj.field // 排序字段
                    , order: obj.type
                    // 排序方式
                }
            });
        });

        // 监听提交
        form.on('submit(updateOrderinit)', function (data) {
            var url = "";
            if (type == 1) {
                url = "orderinit/updateOrderinitByMark?"
                    + $("#update-orderinit-form").serialize() + "&order_init_id="
                    + opID;
            } else {
                url = "orderinit/addOrderinit?"
                    + $("#update-orderinit-form").serialize() + "&order_staff_id=" + staff_id;
            }
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
                            window.location.href =  window.location.href ;
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

        // 监听行工具事件
        table.on('tool(initorder)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                type = 1;
                opID = data.order_init_id;// 操作数据id
                $('#customer_name').val(data.customer_name);
                $('#customer_contact').val(data.customer_contact);
                $('#stu_name').val(data.stu_name);
                $('#stu_age').val(data.stu_age);
                $('#stu_school').val(data.stu_school);
                $('#address').val(data.address);
                $('#channel_id').val(data.channel_id);

                $("#marketing_id").html("<option value='" + data.marketing_id + "'>" + data.marketing_name + "</option>");

                $('#collect_name').val(data.collect_name);
                $('#collect_tel').val(data.collect_tel);
                $('#add-change').html('修改');
                $("#table").slideUp('', function () {
                    $("#orderinit-content").slideDown();
                });
                form.render(); // 更新全部000
            }
        });

        // 搜索工具 start
        var filter = new Set();// 需要查询的字段
        filter.add("customer_name");
        filter.add("customer_contact");
        filter.add("channel_type");
        filter.add("marketing_name");
        filter.add("collect_name");
        filter.add("collect_tel");
        filter.add("stu_name");
        filter.add("stu_age");
        filter.add("stu_school");
        filter.add("address");
        filter.add("entry_real");
        filter.add("assign_staff_name");
        filter.add("effective");
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
            table.reload('initorder', {
                url: 'orderinit/findAllOrderById?key=' + key + '&filter=' + Array.from(filter) + '&staff_id=' + staff_id,
            });
        }

        // 搜索工具 end

        // 添加按钮点击事件
        $('#add-orderinit').on('click', function () {
            // 添加方法
            type = 0;
            $('#customer_name').val("");
            $('#customer_contact').val("");
            $('#stu_name').val("");
            $('#stu_age').val("");
            $('#stu_school').val("");
            $('#address').val("");
            $('#channel_id').val("");
            $('#channel_name').val("");
            $('#collect_name').val("");
            $('#collect_tel').val("");
            $('#add-change').html('添加');
            $("#table").slideUp('', function () {
                $("#orderinit-content").slideDown();
            });
            form.render(); // 更新全部000
        });

        //上传Excel文件
        upload.render({
            elem: '#add-article'
            , url: 'orderinit/importOrderinit?order_staff_id=' + staff_id
            , accept: 'file'
            , exts: 'xlsx|xls'
            , auto: true
            , done: function (res) {
                //如果上传成功
                if (res.code == 100) {
                    layer.confirm('已完成，成功导入 '+res.num+' 个毛单，去除了 '+res.num_have+' 个重复毛单', {
                        icon: 1,
                        title: '提示'
                    }, function (index) {
                        layer.close(index);
                        window.location.href = window.location.href;
                    });
                    return false;
                } else {
                    layer.confirm('文件导入失败，请重新上传！', {
                        icon: 2,
                        title: '提示'
                    }, function (index) {
                        layer.close(index);
                        window.location.href = window.location.href;
                    });
                    return false;
                }
            }
        });

        //下载模板
        $('#down-format').on('click', function () {
            window.location.href = "file/downLoadFile?path=" + "D:/crm/format/毛单模板.xlsx";
        });

        // 返回按按钮点击事件
        $('#back').on('click', function () {
            $("#orderinit-content").slideUp('', function () {
                $("#table").slideDown();
            });
        });



        // 重载表格 防止拉伸
        window.reloadTable = function () {
            initorderTable.reload();
        };
    });
</script>
</html>