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
        <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-header">
                    <h2 class="div-title">销售列表</h2>
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
                                                   title="联系电话" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="relation"
                                                   title="亲属关系" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="stu_name"
                                                   title="学生姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="stu_age"
                                                   title="学生年龄" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="stu_grade"
                                                   title="学生年级" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="stu_school"
                                                   title="学生学校" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="address"
                                                   title="家庭住址" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="assign_staff_name"
                                                   title="顾问老师" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="referrer"
                                                   title="推荐人" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="course_need"
                                                   title="课程需求" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="sale_stage"
                                                   title="销售阶段" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="next_time"
                                                   title="下次联系时间" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="false_reason"
                                                   title="未报名原因" lay-skin="primary" lay-filter='filter' checked></li>
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

                    <%--销售总列表--%>
                    <div id='table'>
                        <table class="layui-hide" id="sale" lay-filter="sale"></table>
                    </div>



                    <div class="map-tools" style="margin-bottom: 10px; display: none;">
                        <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                            <i class="layui-icon">&#xe65c;</i> 返回
                        </button>
                    </div>

                    <%--sale-content start--%>
                    <div id='sale-content' style="display: none;">
                        <div class="content-form">
                            <fieldset class="layui-elem-field layui-field-title"
                                      style="margin: 0px;">
                                <legend>客户信息</legend>
                            </fieldset>
                            <div style="display: flex;">
                                <div style="flex: 1">
                                    <fieldset class="layui-elem-field">
                                        <legend>学生信息</legend>
                                        <div class="layui-field-box">
                                            <table class="layui-table">
                                                <colgroup>
                                                    <col>
                                                    <col>
                                                    <col>
                                                    <col>
                                                    <col>
                                                    <col>
                                                    <col>
                                                    <col>
                                                    <col>
                                                </colgroup>
                                                <thead>
                                                <tr>
                                                    <th>家长姓名</th>
                                                    <th>联系电话</th>
                                                    <th>亲属关系</th>
                                                    <th>学生姓名</th>
                                                    <th>学生年龄</th>
                                                    <th>学生年级</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td id='customer_name'></td>
                                                    <td id='customer_contact'></td>
                                                    <td id='relation'></td>
                                                    <td id='stu_name'></td>
                                                    <td id='stu_age'></td>
                                                    <td id='stu_grade'></td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </fieldset>


                                    <fieldset class="layui-elem-field">
                                        <legend>购课信息</legend>
                                        <div class="layui-field-box">
                                            <table class="layui-table">
                                                <colgroup>
                                                    <col>
                                                    <col>
                                                    <col>
                                                    <col>
                                                </colgroup>
                                                <thead>
                                                <tr>
                                                    <th>顾问老师</th>
                                                    <th>销售阶段</th>
                                                    <th>课程需求</th>
                                                    <th>未报名原因</th>
                                                    <th>是否到店上访</th>
                                                    <th>上访时间</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td id='assign_staff_name'></td>
                                                    <td id='sale_stage'></td>
                                                    <td id='course_need'></td>
                                                    <td id='false_reason'></td>
                                                    <td id='is_coming'></td>
                                                    <td id='arrive_time_str'></td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </fieldset>
                                </div>
                                <div style="padding-left: 25px; padding-right: 25px; cursor: pointer; padding-top: 50px; text-align: center;">
                                    <div id='change-follow'>
                                        <img alt="" src="res/image/icon/edit.png" width="30" height="30">
                                        <p>编辑</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr class="layui-bg-black">
                        <fieldset class="layui-elem-field layui-field-title"
                                  style="margin-top: 20px;margin-bottom: 0px;">
                            <legend>回访历史记录</legend>
                        </fieldset>
                        <%--回访记录列表--%>
                        <table class="layui-hide" id="follow_table" lay-filter="follow_table">

                        </table>

                    </div>
                    <%--sale-content end--%>


                    <div id='follow_up' style="display: none">
                        <div class="layui-card-body">
                            <form class="layui-form" id='add-marketing-form' accept-charset="UTF-8">
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">顾问老师</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="staff_name" id='staff_name' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>

                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">此次访问是否有效</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="is_effective" id='is_effective' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>


                                <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">联系方式</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="contact_style" id='contact_style' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>

                                <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">联系号码</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="contact_number" id='contact_number' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>

                                <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">销售阶段</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="sale_stage_up" id='sale_stage_up' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>
                                <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>未报名原因</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="false_reason_follow" id='false_reason_follow' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>
                                <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6" id="other_reason_all" style="display: none">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">其它因素 </label>
                                        <div class="layui-input-block">
                                            <input type="text" name="other_reason" id='other_reason' lay-filter="other_reason" class="layui-input"
                                                   placeholder="(注：其它因素说明)"  autocomplete="off"  >
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">下次联系</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="next_time_up_str" id='next_time_up_str'  placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">约访时间</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="arrive_time" id='arrive_time'  placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">其它备注 </label>
                                        <div class="layui-input-block">
                                        <textarea type="text" name="other_remark" id="other_remark"
                                                  placeholder=" " class="layui-textarea" readonly="readonly">
                                        </textarea>
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">联系结果</label>
                                        <div class="layui-input-block">
                                            <textarea name="result" id='result' required lay-verify="required"
                                                      placeholder="请输入" class="layui-textarea" readonly="readonly">
                                            </textarea>
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">联系截图 </label>
                                        <div class="layui-input-block">
                                            <div style="display: flex;">
                                                <div id="layer-photos-demo" class="layer-photos-demo"
                                                     style="flex: 1"></div>
                                                <div id='screen_image'
                                                     style="padding-left: 25px; padding-right: 25px; cursor: pointer; padding-top: 75px; text-align: center;">
                                                    <div>
                                                        <img alt="" src="res/image/add.png" width="30"
                                                             height="30">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-form-item my-form-item" id="submit-button">
                                    <div class="layui-btn-group">
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

<script type="text/html" id="stateTp3">
    {{# if(d.sale_stage.length == 0) {        }}
    <span style="color: #FFB800;" >{{ d.customer_name }}</span>
    {{# }else{ }}
    {{ d.customer_name }}
    {{#  } }}
</script>


<script type="text/html" id="stateTp4">
    {{# if(d.sale_stage.length == 0) {        }}
    <span style="color: #FFB800;" >{{ d.customer_contact }}</span>
    {{# }else{ }}
    {{ d.customer_contact }}
    {{#  } }}
</script>

<script type="text/html" id="stateTp5">
    {{# if(d.sale_stage.length == 0) {        }}
    <span style="color: #FFB800;" >{{ d.stu_name }}</span>
    {{# }else{ }}
    {{ d.stu_name }}
    {{#  } }}
</script>

<script type="text/html" id="stateTp6">
    {{# if(d.sale_stage.length == 0) {        }}
    <span style="color: #FFB800;" >{{ d.stu_age }}</span>
    {{# }else{ }}
    {{ d.stu_age }}
    {{#  } }}
</script>

<script type="text/html" id="stateTp7">
    {{# if(d.sale_stage.length == 0) {        }}
    <span style="color: #FFB800;" >{{ d.stu_school }}</span>
    {{# }else{ }}
    {{ d.stu_school }}
    {{#  } }}
</script>

<script type="text/html" id="stateTp8">
    {{# if(d.sale_stage.length == 0) {        }}
    <span style="color: #FFB800;" >{{ d.address }}</span>
    {{# }else{ }}
    {{ d.address }}
    {{#  } }}
</script>


<script type="text/html" id="stateTpl">
    {{#  if(d.is_effective === '无效') { }}
    <span style="color: #d82b2b;">{{ d.is_effective }}</span>
    {{#  } else if(d.is_effective === '有效') { }}
    <span style="color: #20c12e;">{{ d.is_effective }}</span>
    {{#  } }}
</script>

<script type="text/html" id="stateTp2">
    {{#  var myDate = new Date(); }}
    {{#  if(d.next_time != null) { }}
    {{#  if(d.sale_stage === 'B-接受'||d.sale_stage === 'C-拒绝'){ }}
    <span>{{ d.next_time_str }}</span>
    {{#  } else { }}
    {{#  if((d.next_time.time - myDate.getTime()) < 0) { }}
    <span style="color: #d82b2b;">{{ d.next_time_str }}</span>
    {{#  } else if((d.next_time.time - myDate.getTime()) < 86400000) { }}
    <span style="color: #FFB800;">{{ d.next_time_str }}</span>
    {{#  } else { }}
    <span style="color: #20c12e;">{{ d.next_time_str }}</span>
    {{#  }  }}
    {{#  }  }}
    {{#  }  }}
</script>

<script type="text/html" id="toolBars">
    <button class="layui-btn layui-btn-xs" lay-event="follow">回访/访问登记</button>
</script>


<script type="text/html" id="toolBar1">
    <span class="layui-badge layui-bg-red">过时未打电话</span>
    <span class="layui-badge layui-bg-orange">不足24小时</span>
    <span class="layui-badge layui-bg-green">尚足24小时</span>
    <span class="layui-badge layui-bg-cyan">已成功报名</span>
</script>

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看/编辑</a>
</script>

<script type="text/html" id="opreationBarFollow">
    <a class="layui-btn layui-btn-xs" lay-event="edit" style="right: 0px">查看详情</a>
</script>
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
        var opNumber = 0;
        var followTable = "";
        var staff_id = '${staff.staff_id}';




        // 获取表格数据
        var saleTable = table.render({
            elem: '#sale',
            url: 'saleOrder/findAllSaleById?staff_id=' + staff_id,
            toolbar: '#toolBar1',
            title: '销售列表',
            cols: [[{
                title: '编号',
                type: 'numbers',
                fixed: 'left',
                width: 70
            }, {
                field: 'customer_name',
                title: '客户姓名',
                minWidth: 100,
                templet: '#stateTp3',
                sort: true
            }, {
                field: 'customer_contact',
                title: '联系方式',
                minWidth: 100,
                templet: '#stateTp4',
                sort: true
            }, {
                field: 'stu_name',
                title: '学生姓名',
                minWidth: 100,
                templet: '#stateTp5',
                sort: true
            }, {
                field: 'stu_age',
                title: '学生年龄',
                minWidth: 100,
                hide: true,
                templet: '#stateTp6',
                sort: true
            }, {
                field: 'stu_school',
                title: '学生学校',
                templet: '#stateTp7',
                minWidth: 100,
                hide: true,
                sort: true
            }, {
                field: 'address',
                title: '家庭住址',
                templet: '#stateTp8',
                minWidth: 100,
                hide: true,
                sort: true
            }, {
                field: 'stu_grade',
                title: '学生年级',
                minWidth: 100,
                hide: true,
                sort: true
            }, {
                field: 'relation',
                title: '亲属关系',
                minWidth: 100,
                sort: true
            }, {
                field: 'referrer',
                title: '推荐人',
                minWidth: 100,
                hide: true,
                sort: true
            }, {
                field: 'assign_staff_name',
                title: '顾问老师',
                minWidth: 100,
                hide: true,
                sort: true
            }, {
                field: 'sale_stage',
                title: '销售阶段',
                minWidth: 100,
                sort: true
            }, {
                field: 'course_need',
                title: '课程需求',
                minWidth: 100,
                hide: true,
                sort: true
            }, {
                field: 'next_time_str',
                title: '下次联系时间',
                minWidth: 100,
                templet: '#stateTp2'
            }, {
                field: 'false_reason',
                title: '未成功原因',
                minWidth: 100,
                hide: true,
                sort: true
            },{
                field: 'arrive_time_str',
                title: '预计上访时间',
                minWidth: 100,
                hide: true
            }, {
                title: '操作',
                toolbar: '#opreationBar',
                width: 120,
                fixed: 'right'
            }]],
            page: true
        });

        // 排序事件
        table.on('sort(sale)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
            table.reload('sale', {
                initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
                , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                    field: obj.field // 排序字段
                    , order: obj.type
                    // 排序方式
                }
            });
        });


        // 排序事件
        table.on('sort(follow_table)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
            table.reload('follow_table', {
                initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
                , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                    field: obj.field // 排序字段
                    , order: obj.type
                    // 排序方式
                }
            });
        });


        // 监听行工具事件
        table.on('tool(sale)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                op1(data);
                opNumber = 1;
            }
        });

        // 监听行工具事件
        table.on('tool(follow_table)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                op2(data);
                opNumber = 2;
            }
        });


        //回访记录详情
        function op2(data) {
            var other_reason=data.other_reason;
            var false_reason=data.false_reason;

            if (false_reason=='F.其它因素'){
                $("#other_reason").val(other_reason);
                $("#other_reason_all").slideDown();
            }else{//如果没有使用其它因素 则赋为”“
                $("#other_reason_all").slideUp();

            }
            $('#staff_name').val(data.staff_name);
            $('#save_way').val(data.is_coming);
            $('#is_effective').val(data.is_effective);

            $('#contact_style').val(data.contact_style);
            $('#contact_number').val(data.contact_number);


            $('#sale_stage_up').val(data.sale_stage_up);
            $('#false_reason_follow').val(data.false_reason);

            $('#next_time_up_str').val(data.next_time_up_str);
            $('#arrive_time').val(data.arrive_time_str);

            $('#other_remark').val(data.other_remark);
            $('#result').val(data.result);

            var text='	<img layer-pid="" layer-src="file/getFile?path='+data.screen_image+'" src="file/getFile?path='+data.screen_image+'" height="200" width="450">';
            $('#layer-photos-demo').html(text);
            layer.photos({
                photos: '#layer-photos-demo'
                ,anim: 5 // 0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
            });

            $("#sale-content").slideUp('', function () {
                $("#follow_up").slideDown();
            });
            form.render(); // 更新全部000
        }


        //查看/编辑按钮后界面信息详情
        function op1(data) {
            opID = data.sale_id;// 操作数据id
            $('#customer_name').html(data.customer_name);
            $('#customer_contact').html(data.customer_contact);
            $('#assign_staff_name').html(data.assign_staff_name);
            $('#relation').html(data.relation);
            $('#stu_name').html(data.stu_name);
            $('#stu_age').html(data.stu_age);
            $('#stu_grade').html(data.stu_grade);
            $('#stu_school').html(data.stu_school);
            $('#address').html(data.address);
            $('#referrer').html(data.referrer);
            $('#sale_stage').html(data.sale_stage);
            $('#course_need').html(data.course_need);
            $('#false_reason').html(data.false_reason);
            $('#is_coming').html(data.is_coming);
            $('#arrive_time_str').html(data.arrive_time_str);
            followTable = table.render({
                elem: '#follow_table',
                url: 'saleOrder/findAllFollow?sale_id=' + opID,
                toolbar: '#toolBars',
                title: '回访记录',
                cols: [[{
                    title: '编号',
                    type: 'numbers',
                    fixed: 'left',
                    width: 60
                }, {
                    field: 'staff_name',
                    title: '顾问老师',
                    minWidth: 100
                }, {
                    field: 'is_effective',
                    title: '是否有效',
                    templet: '#stateTpl',
                    minWidth: 100
                }, {
                    field: 'contact_style',
                    title: '联系方式',
                    minWidth: 100
                }, {
                    field: 'sale_stage_up',
                    title: '销售阶段',
                    minWidth: 100
                }, {
                    field: 'next_time_up_str',
                    title: '下次联系时间',
                    minWidth: 120
                }, {
                    field: 'result',
                    title: '联系结果',
                    minWidth: 200
                }, {
                    title: '操作',
                    toolbar: '#opreationBarFollow',
                    width: 120,
                    fixed: 'right'
                }]],
                page: true
            });
            followTable.reload();
            $("#table").slideUp('', function () {
                $('#examine-search-div').hide();
                $('#back').parent().show();
                $("#sale-content").slideDown();
            });
            form.render(); // 更新全部000
        }

        // 编辑客户信息
        $('#change-follow').on('click', function () {
            layer.open({
                type: 2,
                title: '修改客户信息',
                shadeClose: true,
                shade: 0.8,
                area: ['80%', '80%'],
                content: 'saleOrder/gotoJsp?sale_id=' + opID + "&jsp=changeFollowPage"
            });
        });


        // 头工具栏事件
        table.on('toolbar(follow_table)', function (obj) {
            switch (obj.event) {
                case 'follow':
                    layer.open({
                        type: 2,
                        title: '回访信息登记',
                        shadeClose: true,
                        shade: 0.8,
                        area: ['80%', '80%'],
                        content: 'saleOrder/gotoFollow?sale_id=' + opID + "&jsp=followPage"
                    });
                break;
            };


        });

        // 搜索工具 start
        var filter = new Set();// 需要查询的字段
        filter.add("customer_name");
        filter.add("customer_contact");
        filter.add("relation")
        filter.add("stu_name");
        filter.add("stu_age");
        filter.add("stu_grade");
        filter.add("stu_school");
        filter.add("address");
        filter.add("assign_staff_name");
        filter.add("referrer");
        filter.add("sale_stage");
        filter.add("course_need");
        filter.add("next_time");
        filter.add("false_reason");
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
            table.reload('sale', {
                url: 'saleOrder/findAllSaleById?key=' + key + '&filter=' + Array.from(filter) + '&staff_id=' + staff_id
            });
        }

        // 搜索工具 end

        // 返回按按钮点击事件
        $('#back').on('click', function () {
            if (opNumber == 2) {
                $("#follow_up").slideUp('', function () {
                    $("#sale-content").slideDown();
                });
                opNumber = 1;
            } else if (opNumber == 1) {
                $('#back').parent().hide();
                $('#examine-search-div').show();
                $("#sale-content").slideUp('', function () {
                    $("#table").slideDown();
                });
                opNumber = 0;
            }
        });

        // 重载表格 防止拉伸
        window.reloadTable = function () {
            saleTable.reload();
            if (followTable != '') {
                followTable.reload();
            }
        };

    });
</script>
</html>