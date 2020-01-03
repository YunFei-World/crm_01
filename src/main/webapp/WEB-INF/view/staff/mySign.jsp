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
    <link rel="stylesheet" href="layui/formSelects-v4.css">
</head>

<body class="layui-layout-body">



<style>
    .printonly{
        display:none
    }
    @media print{
        input,.noprint{
            display:none
        }
        .printonly{
            display:block;
            width:50%
        }
    }

</style>




<div class="layui-layout layui-layout-admin">
    <%@ include file="saleHeader.jsp" %>
    <div class="layui-body" id='body-div' style="padding: 20px;">
        <div
                class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-header">
                    <h2 class="div-title">课程报名</h2>
                </div>
                <div class="layui-card-body">
                    <!-- 顶部工具栏 -->
                    <div class="map-tools" id="examine-search-div" style="display: flex;">
                        <div class="search-filter-main">
                            <i id='filter' class="layui-icon">&#xe6b2;</i>
                            <div id='filter-ul-div' class="filter-ul-div">
                                <form class="layui-form">
                                    <ul id='filter-ul'>
                                        <li><input type="checkbox" value="customer_name"
                                                   title="客户姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="customer_contact"
                                                   title="联系方式" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="relation"
                                                   title="亲属关系" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="stu_name"
                                                   title="学生姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="student_birthday"
                                                   title="学生生日" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="student_phone"
                                                   title="学生电话" lay-skin="primary" lay-filter='filter' checked></li>

                                        <li><input type="checkbox" value="assign_staff_name"
                                                   title="顾问老师" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="course_name"
                                                   title="课程名称" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="final_price"
                                                   title="成交价" lay-skin="primary" lay-filter='filter' checked></li>

                                        <li><input type="checkbox" value="load_time"
                                                   title="报名日期" lay-skin="primary" lay-filter='filter' checked></li>
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

                    <div class="map-tools" style="margin-bottom: 10px; display: none;">
                        <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                            <i class="layui-icon">&#xe65c;</i> 返回
                        </button>
                    </div>

                    <div id='table'>
                        <table class="layui-hide" id="sign" lay-filter="sign"></table>
                    </div>

                    <div id='sign-content' style="display: none;">
                        <div class="layui-card-body">
                            <form class="layui-form" id='add-marketing-form' accept-charset="UTF-8">
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
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
                                        </a>联系方式</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="customer_contact" id='customer_contact' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>亲属关系</label>
                                        <div class="layui-input-block">
                                            <select name="relation" id="relation" lay-verify="required">
                                                <option value="">请选择</option>
                                                <option value="父亲">父亲</option>
                                                <option value="母亲">母亲</option>
                                                <option value="爷爷">爷爷</option>
                                                <option value="奶奶">奶奶</option>
                                                <option value="监护人">监护人</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>顾问老师</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="assign_staff_name" id='assign_staff_name' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly = "readonly">
                                        </div>
                                    </div>
                                </div>


                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>学生姓名</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="stu_name" id='stu_name' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>学生性别</label>
                                        <div class="layui-input-block">
                                            <select name="student_sex" id="student_sex" lay-verify="required">
                                                <option value="">请选择</option>
                                                <option value="男">男</option>
                                                <option value="女">女</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>学生生日</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="student_birthday" id='student_birthday' required
                                                   lay-verify="required" placeholder="yyyy-MM-dd"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">学生电话</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="student_phone" id='student_phone'  placeholder="请输入"
                                                   autocomplete="off" class="layui-input">
                                        </div>
                                    </div>
                                </div>

                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>产品选择</label>
                                        <div class="layui-input-block">
                                            <select name="all_course" xm-select="all_course"
                                                    lay-filter="all_course" lay-verify="required" lay-search>
                                                <option value="">请选择</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>成交价格</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="final_price" id='final_price' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input">
                                        </div>
                                    </div>
                                </div>

                                <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">备注</label>
                                        <div class="layui-input-block">
                                             <textarea type="text" name="remark" id="remark"  placeholder="请输入"
                                                      class="layui-textarea"></textarea>
                                        </div>
                                    </div>
                                </div>

                                <%--<div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>报名日期</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="sign_date" id='sign_date' required
                                                   lay-verify="required" placeholder="yyyy-MM-dd"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>--%>

                                <div class="layui-form-item my-form-item" id="submit-button">
                                    <div class="layui-btn-group">
                                        <button class="layui-btn my-button" lay-submit
                                                lay-filter="changeSign" id="change">提交
                                        </button>
                                        <%--<button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                   <%-- <div id='sign-detail' style="display: none;">
                        <div class="layui-card-body">

                            <div  class="noprint">
                                <a  href="javascript:window.print()" id="print" name="print" lay-filter="print">打印</a>
                            </div>




                            <div id="printBox" >

                                <blockquote class="layui-elem-quote">
                                    订单课程信息   <a id="sign_time" name="sign_time" lay-filter="sign_time" style="color: #00d771" class="right" ></a>
                                </blockquote>

                                <div id='sign_course_table'>
                                    <table class="layui-hide" id="sign_course" lay-filter="sign"></table>
                                </div>

                                <blockquote class="layui-elem-quote">
                                    订单结算
                                </blockquote>

                                <form class="layui-form layui-form-pane"  accept-charset="UTF-8">
                                    <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">订单号</label>
                                            <div class="layui-input-inline" >
                                                <input type="text" name="detail_sign_id" id='detail_sign_id'
                                                       autocomplete="off"  class="layui-input" readonly="readonly">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">顾问老师</label>
                                            <div class="layui-input-inline">
                                                <input type="text" name="detail_assign_staff_name" id='detail_assign_staff_name'
                                                       autocomplete="off" class="layui-input" readonly = "readonly">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">学生姓名</label>
                                            <div class="layui-input-inline">
                                                <input type="text" name="detail_student_name" id='detail_student_name'
                                                       autocomplete="off" class="layui-input" readonly="readonly">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">学生学号</label>
                                            <div class="layui-input-inline">
                                                <input type="text" name="detail_student_id" id='detail_student_id'
                                                       autocomplete="off" class="layui-input" readonly="readonly">
                                            </div>
                                        </div>
                                    </div>




                                    <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">订单总价</label>
                                            <div class="layui-input-inline">
                                                <input type="text" name="detail_all_price" id='detail_all_price'
                                                       autocomplete="off" class="layui-input" readonly="readonly">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">优惠金额</label>
                                            <div class="layui-input-inline">
                                                <input type="text" name="detail_reward_balance" id='detail_reward_balance'
                                                       autocomplete="off" class="layui-input" readonly="readonly">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">实际价格</label>
                                            <div class="layui-input-inline">
                                                <input type="text" name="detail_final_price" id='detail_final_price'
                                                       autocomplete="off" class="layui-input" readonly="readonly">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="layui-form-item my-form-item" id="submit">
                                        <div class="layui-btn-group">
                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>--%>


                </div>
            </div>
        </div>
    </div>
</div>







<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">课程报名</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">打印</a>
</script>




<script type="text/html" id="stateTp1">
    {{# if(d.load_time==null) {        }}
    <span style="color: #FFB800;" >{{ d.customer_name }}</span>
    {{# }else{ }}
    {{ d.customer_name }}
    {{#  } }}
</script>
<script type="text/html" id="stateTp2">
    {{# if(d.load_time==null) {        }}
    <span style="color: #FFB800;" >{{ d.customer_contact }}</span>
    {{# }else{ }}
    {{ d.customer_contact }}
    {{#  } }}
</script>
<script type="text/html" id="stateTp3">
    {{# if(d.load_time==null) {        }}
    <span style="color: #FFB800;" >{{ d.relation }}</span>
    {{# }else{ }}
    {{ d.relation }}
    {{#  } }}
</script>
<script type="text/html" id="stateTp4">
    {{# if(d.load_time==null) {        }}
    <span style="color: #FFB800;" >{{ d.stu_name }}</span>
    {{# }else{ }}
    {{ d.stu_name }}
    {{#  } }}
</script>



<script src="layui/layui.js"></script>
<script src="res/js/header.js"></script>










<script type="text/javascript">
    //全局定义一次, 加载formSelects
    layui.config({
        base: 'layui/' //此处路径请自行处理, 可以使用绝对路径
    }).extend({
        formSelects: 'formSelects-v4'
    });
</script>
</body>
<script>
    layui.use(['table', 'jquery', 'form', 'laydate','formSelects'], function () {
        var table = layui.table;
        var laydate = layui.laydate;
        var $ = jQuery = layui.jquery;
        var form = layui.form;
        var formSelects = layui.formSelects;
        var opID = '';// 需要操作的 数据id
        var key = '';
        var staff_id = '${staff.staff_id}';
        var campus_id='${staff.campus_id}';

        var signCourseTable='';


        var keys = [];
        var ids = [];

        //报名日期
        laydate.render({
            elem: '#sign_date'
        });

        laydate.render({
            elem: '#student_birthday'
        });





        // 获取表格数据
        var signTable = table.render({
            elem: '#sign',
            url: 'sign/findSignById?staff_id=' + staff_id,
            toolbar: '#toolBar',
            title: '课程报名表',
            cols: [[{
                title: '编号',
                type: 'numbers',
                fixed: 'left',
                width: 50
            }, {
                field: 'customer_name',
                title: '家长姓名',
                minWidth: 100,
                templet: '#stateTp1',
                sort: true
            }, {
                field: 'customer_contact',
                title: '联系电话',
                minWidth: 120,
                templet: '#stateTp2',
                sort: true
            }, {
                field: 'relation',
                title: '亲属关系',
                minWidth: 50,
                templet: '#stateTp3',
                sort: true
            }, {
                field: 'stu_name',
                title: '学生姓名',
                minWidth: 100,
                templet: '#stateTp4',
                sort: true
            }, {
                field: 'student_sex',
                title: '学生性别',
                minWidth: 100,
                hide: true,
                sort: true
            }, {
                field: 'student_birthday_str',
                title: '学生生日',
                minWidth: 100,
                hide: true
            }, {
                field: 'student_phone',
                title: '学生电话',
                minWidth: 120,
                hide: true,
                sort: true
            }, {
                field: 'assign_staff_name',
                title: '顾问老师',
                minWidth: 100,
                hide: true,
                sort: true
            }, {
                field: 'course_name',
                title: '课程名称',
                minWidth: 200,
                sort: true
            }, {
                field: 'final_price',
                title: '成交价',
                minWidth: 100,
                sort: true
            }, {
                field: 'load_time_str',
                title: '报名日期',
                minWidth: 120
            }, {
                title: '操作',
                toolbar: '#opreationBar',
                width: 160,
                fixed: 'right'
            }]],
            page: true
        });

        // 排序事件
        table.on('sort(sign)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
            table.reload('sign', {
                initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
                , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                    field: obj.field // 排序字段
                    , order: obj.type
                    // 排序方式
                }
            });
        });



        $.ajax({
            url: "sign/findAllCourseNames?campus_id="+campus_id,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function (data) {
                for (var i = 0; i < data.data.length; i++) {
                    var a='';
                    var temp='';
                    if (data.data[i].chargetype==0) {
                        a=data.data[i].COURSE_NAME +' '+ data.data[i].lessonNum + "课次" + ' '+ data.data[i].totalPrice + "(按期)";
                        temp = {"name": a, "value": data.data[i].id };
                    }else if (data.data[i].chargetype==1) {
                        a=data.data[i].COURSE_NAME +' '+ "每课次" + ' '+ data.data[i].UNIT_PRICE + "(按次)";
                        temp = {"name": a, "value": data.data[i].id };
                    }
                    keys.push(temp);
                }

            }
        });


        //local模式 本地数据
        formSelects.data('all_course', 'local', {
            arr: keys
        });

        formSelects.on('all_course', function (id, vals, val, isAdd, isDisabled) {
            for(var i = 0; i < vals.length; i++){
                ids[i] = vals[i].value;
            }
        }, true);






        // 监听提交
        form.on('submit(changeSign)', function (data) {
            var url = "sign/updateSign?"
                + $("#add-marketing-form").serialize() + "&sign_id="
                + opID;
            $.ajax({
                type: "get",
                url: url,
                async: false,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == 100) {
                        layer.confirm('已完成', {
                            icon: 1,
                            title: '提示'
                        }, function (index) {
                            layer.close(index);
                            window.location.href = window.location.href;
                        });
                    } else if (jsonData.code == 101) {
                        layer.confirm('该学生已经选过'+jsonData.course_name+'课程', {
                            icon: 2,
                            title: '提示'
                        }, function (index) {
                            layer.close(index);
                            window.location.href = window.location.href;
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

        // 监听行工具事件   obj为前端 输入框中的数据  这里取出方便填充
        table.on('tool(sign)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                opID = data.sign_id;// 操作数据id
                $('#customer_name').val(data.customer_name);
                $('#customer_contact').val(data.customer_contact);
                $('#relation').val(data.relation);
                $('#stu_name').val(data.stu_name);

                $('#assign_staff_name').val(data.assign_staff_name);

                $('#student_phone').val(data.student_phone);
                $('#student_sex').val(data.student_sex);
                $('#student_birthday').val(data.student_birthday_str);
                $('#all_course').val(data.course_id);
                $('#reward_balance').val(data.reward_balance);
                $('#final_price').val(data.final_price);
                $('#remark').val(data.remark);

                $("#table").slideUp('', function () {
                    $('#examine-search-div').hide();
                    $('#back').parent().show();
                    $("#sign-content").slideDown();
                });
                form.render(); // 更新全部000
            }else if (obj.event == 'detail') {
                opID = data.sign_id;// 操作数据id
                layer.open({
                    type: 2,
                    title: '订单信息',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['90%', '90%'],
                    content: 'sign/gotoJsp?sign_id=' + opID + "&jsp=windowPrintPage"+"&staff_id="+staff_id+"&campus_id="+campus_id
                });





            }
        });
















        // 搜索工具 start
        var filter = new Set();// 需要查询的字段
        filter.add("customer_name");
        filter.add("customer_contact");
        filter.add("relation");
        filter.add("stu_name");
        filter.add("student_birthday");
        filter.add("student_phone");

        filter.add("assign_staff_name");
        filter.add("course_name");

        filter.add("final_price");

        filter.add("load_time");
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
            table.reload('sign', {
                url: 'sign/findSignById?key=' + key + '&filter=' + Array.from(filter) + '&staff_id=' + staff_id
            });
        }
        // 搜索工具 end

        // 返回按按钮点击事件
        $('#back').on('click', function () {
            $("#sign-content").slideUp();
            $("#sign-detail").slideUp();
            $('#back').parent().hide();
            $('#examine-search-div').show();
            $("#table").slideDown();

        });

        // 重载表格 防止拉伸
        window.reloadTable = function () {
            signTable.reload();
        };

    });
</script>
</html>