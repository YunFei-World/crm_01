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
                    <h2 class="div-title">初始单（毛单）列表</h2>
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
                                        <li><input type="checkbox" value="assign_time"
                                                   title="分配时间" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="weixin"
                                                   title="是否加入微信" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="tel_time"
                                                   title="打电话时间" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="effective"
                                                   title="有/无效单" lay-skin="primary" lay-filter='filter' checked></li>


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

                    <div id='table'>
                        <table class="layui-hide" id="sale" lay-filter="sale"></table>
                    </div>

                    <div class="map-tools" style="margin-bottom: 10px; display: none;">
                        <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                            <i class="layui-icon">&#xe65c;</i> 返回
                        </button>
                    </div>


                    <div id='orderinit-content' style="display: none">
                        <div class="layui-card-body">
                            <form class="layui-form" id='add-marketing-form' accept-charset="UTF-8">
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
                                                   autocomplete="off" class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <%--<div--%>
                                        <%--class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">--%>
                                    <%--<div class="layui-form-item layui-form-text">--%>
                                        <%--<label class="layui-form-label"><a style="color: red;">*--%>
                                        <%--</a>毛单状态 </label>--%>
                                        <%--<div class="layui-input-block">--%>
                                            <%--<select name="effective" id="effective" lay-verify="required">--%>
                                                <%--<option value="">请选择</option>--%>
                                                <%--<option value="有效单">有效单</option>--%>
                                                <%--<option value="无效单">无效单</option>--%>
                                            <%--</select>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>毛单状态 </label>
                                        <div class="layui-input-block">
                                            <select name="effective" id="effective" lay-filter="effective" lay-verify="required">
                                                <option value="">请选择</option>
                                                <option value="a.接通-有意到店">a.接通-有意到店</option>
                                                <option value="b.接通-待定">b.接通-待定</option>
                                                <option value="c.接通-拒绝">c.接通-拒绝</option>
                                                <option value="d.未接通">d.未接通</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label"><a style="color: red;">*
                                        </a>是否入群 </label>
                                        <div class="layui-input-block">
                                            <select name="weixin" id="weixin" lay-filter="weixin" lay-verify="required">
                                                <option value="">请选择</option>
                                                <option value="加入微信群">加入微信群</option>
                                                <option value="未加入微信群">未加入微信群</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-form-item my-form-item" id="submit-button">
                                    <div class="layui-btn-group">
                                        <button class="layui-btn my-button" lay-submit
                                                lay-filter="change" id="change">修改
                                        </button>
                                        </div>
                                </div>
                            </form>
                        </div>
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
                                                    <td id='form_customer_name'></td>
                                                    <td id='form_customer_contact'></td>
                                                    <td id='form_relation'></td>
                                                    <td id='form_stu_name'></td>
                                                    <td id='form_stu_age'></td>
                                                    <td id='form_stu_grade'></td>
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
                                                    <td id='form_assign_staff_name'></td>
                                                    <td id='form_sale_stage'></td>
                                                    <td id='form_course_need'></td>
                                                    <td id='form_false_reason'></td>
                                                    <td id='form_is_coming'></td>
                                                    <td id='form_arrive_time_str'></td>
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



                       <%-- <fieldset class="layui-elem-field layui-field-title"
                                  style="margin-top: 20px;margin-bottom: 0px;">
                            <legend>回访历史记录</legend>
                        </fieldset>
                        &lt;%&ndash;回访记录列表&ndash;%&gt;
                        <table class="layui-hide" id="follow_table" lay-filter="follow_table">
                        </table>--%>

                    </div>
                    <%--sale-content end--%>


                  <%--  <div id='follow_up' style="display: none">
                        <div class="layui-card-body">
                            <form class="layui-form" id='follow-form' accept-charset="UTF-8">
                                <div class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
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
                                        <label class="layui-form-label">此次回访是否有效</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="is_effective" id='is_effective' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>


                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">联系方式</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="contact_style" id='contact_style' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>

                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">联系号码</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="contact_number" id='contact_number' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>

                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">销售阶段</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="sale_stage_up" id='sale_stage_up' required
                                                   lay-verify="required" placeholder="请输入"
                                                   autocomplete="off" class="layui-input" readonly="readonly">
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">未报名原因</label>
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

                                <div class="layui-form-item my-form-item" id="submit">
                                    <div class="layui-btn-group">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>--%>


                </div>
            </div>
        </div>
    </div>
</div>







<%--sale--%>

<script type="text/html" id="stateTp1">
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


<script type="text/html" id="stateTp2">
    {{# if(d.tel_time == null) {        }}
    <span style="color: #FFB800;" >{{ d.assign_time_str }}</span>
    {{# }else{ }}
    {{ d.assign_time_str }}
    {{#  } }}
</script>

<script type="text/html" id="stateTp3">
    {{# if(d.tel_time == null) {        }}
    <span style="color: #FFB800;" >{{ d.customer_contact }}</span>
    {{# }else{ }}
    {{ d.customer_contact }}
    {{#  } }}
</script>
<script type="text/html" id="stateTp4">
    {{# if(d.tel_time == null) {        }}
    <span style="color: #FFB800;" >{{ d.customer_name }}</span>
    {{# }else{ }}
    {{ d.customer_name }}
    {{#  } }}
</script>
<script type="text/html" id="stateTp5">
    {{# if(d.tel_time == null) {        }}
    <span style="color: #FFB800;" >{{ d.stu_name }}</span>
    {{# }else{ }}
    {{ d.stu_name }}
    {{#  } }}
</script>
<script type="text/html" id="stateTp6">
    {{# if(d.tel_time == null) {        }}
    <span style="color: #FFB800;" >{{ d.stu_age }}</span>
    {{# }else{ }}
    {{ d.stu_age }}
    {{#  } }}
</script>
<script type="text/html" id="stateTp7">
    {{# if(d.tel_time == null) {        }}
    <span style="color: #FFB800;" >{{ d.stu_school }}</span>
    {{# }else{ }}
    {{ d.stu_school }}
    {{#  } }}
</script>









<script type="text/html" id="toolBar1">
    <span class="layui-badge layui-bg-orange">未打电话的毛单</span>
    <span class="layui-badge layui-bg-cyan">打过电话的毛单</span>
</script>

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看/编辑</a>
</script>



<%--两表内部工具分界限--%>

<%--follow-up--%>


<%--


<script type="text/html" id="followstateTpl">
    {{#  if(d.is_effective === '无效') { }}
    <span style="color: #d82b2b;">{{ d.is_effective }}</span>
    {{#  } else if(d.is_effective === '有效') { }}
    <span style="color: #20c12e;">{{ d.is_effective }}</span>
    {{#  } }}
</script>



<script type="text/html" id="toolBars">
    <button class="layui-btn layui-btn-xs" lay-event="follow">回访/访问登记</button>
</script>





<script type="text/html" id="opreationBarFollow">
    <a class="layui-btn layui-btn-xs" lay-event="edit" style="right: 0px">查看详情</a>
</script>

--%>










<script src="layui/layui.js"></script>
<script src="res/js/header.js"></script>



</body>



<script>

    layui.use(['table', 'jquery', 'form', 'laydate'], function () {
        var table = layui.table;
        var laydate = layui.laydate;
        var $ = jQuery = layui.jquery;
        var form = layui.form;

        var key = '';
        var staff_id = '${staff.staff_id}';
        var orderinit_state=$('#effective').val();
        var weixin=$('#weixin').val();

        // var followTable = "";

        var order_ID = '';// 需要操作的 数据id
        var sale_ID = '';// 需要操作的 sale单id

        var opNumber='';

        // 获取表格数据
        var saleTable = table.render({
            elem: '#sale',
            url: 'orderinit/findAllOrderByAssginId?staff_id=' + staff_id,
            toolbar: '#toolBar1',
            title: '销售列表',
            cols: [[{
                title: '编号',
                type: 'numbers',
                fixed: 'left',
                width: 70
            }, {
                field: 'customer_name',
                title: '家长姓名',
                minWidth: 100,
                templet: '#stateTp4',
                sort: true
            }, {
                field: 'customer_contact',
                title: '联系方式',
                minWidth: 100,
                templet: '#stateTp3',
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
                minWidth: 100,
                hide: true,
                templet: '#stateTp7',
                sort: true
            },{
                field: 'assign_time_str',
                title: '分配时间',
                minWidth: 100,
                templet: '#stateTp2'
            },{
                field: 'weixin',
                title: '是否加入微信',
                minWidth: 100,
                hide:true,
                sort: true
            },{
                field: 'tel_time_str',
                title: '打电话时间',
                minWidth: 100,
                hide:true
            }, {
                field: 'effective',
                title: '状态',
                minWidth: 100,
                templet: '#stateTp1',
                sort: true
            },{
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





        // 监听提交
        form.on('submit(change)', function () {
            orderinit_state = $("#effective").val();
            weixin=$('#weixin').val();
            var url = "orderinit/updateOrderinitByEffecitve?"
                + $("#add-marketing-form").serialize() + "&order_init_id="
                + order_ID;
            $.ajax({
                type: "post",
                url: url,
                async: true,
                success: function (data) {//data为生成对应的sale单
                    var jsonData = JSON.parse(data);

                    if (jsonData.code == 100) {
                        sale_ID=jsonData.getsale;//提交  生成sale_id
                        layer.confirm('信息更新完毕', {
                            icon: 1,
                            title: '提示'
                        }, function () {//此时 刚刚生成新的sale单 sale-content和follow-up还没有数据
                            if (sale_ID=='havingsale'){
                                layer.msg("此毛单已经生成过对应销售数据，请不要重复操作！",function () {
                                    
                                });
                            } else if (sale_ID=='nohaving'){
                                layer.msg("此毛单为无效毛单！");
                            } else if(sale_ID=='havingweixin'){
                                layer.msg("此毛单客户已经加入微信群！");
                            }else{
                                layer.msg("请填写此毛单后续信息！");
                                $("#sale-content").slideDown('',op3(sale_ID));
                               /* if ((orderinit_state!='未接通'||orderinit_state!='接通-拒绝')&&(weixin=='未加入微信群')){
                                    $("#sale-content").slideDown();
                                }else{  //为未接通和拒绝就只显示按钮
                                    $("#sale-content").slideUp();
                                }*/
                            }

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










        // sale
        // 监听行工具事件
        table.on('tool(sale)', function (obj) {
            var data = obj.data;

            if (obj.event === 'edit') {
                order_ID = data.order_init_id;// 操作数据id
                $('#customer_name').val(data.customer_name);
                $('#customer_contact').val(data.customer_contact);
                $('#effective').val(data.effective);
                $('#weixin').val(data.weixin);

                form.render("select");


                $("#table").slideUp('', function () {
                    $('#examine-search-div').hide();
                    $('#back').parent().show();
                    $("#orderinit-content").slideDown();
                });

                form.render(); // 更新全部000

                op1(data);
                opNumber = 1;
            }


        });

       /* // 监听行工具事件
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
                $("#orderinit-content").slideUp();
                $("#follow_up").slideDown();
            });
            form.render(); // 更新全部000
        }
        */

        //查看/编辑按钮后界面信息详情
        function op1(data) {
            // 操作数据id
            $.ajax({
                url: "orderinit/findSaleByOrderinit?order_init_id=" + data.order_init_id,
                type: "get",
                success: function (data) {
                    var jsonData = JSON.parse(data);

                    var code=jsonData.code;

                    if (code==100) {
                        sale_ID = jsonData.data.sale_id;
                        $('#form_customer_name').html(jsonData.data.customer_name);
                        $('#form_customer_contact').html(jsonData.data.customer_contact);
                        $('#form_relation').html(jsonData.data.relation);
                        $('#form_stu_name').html(jsonData.data.stu_name);
                        $('#form_stu_age').html(jsonData.data.stu_age);
                        $('#form_stu_grade').html(jsonData.data.stu_grade);



                        $('#form_assign_staff_name').html(jsonData.data.assign_staff_name);
                        $('#form_sale_stage').html(jsonData.data.sale_stage);
                        $('#form_course_need').html(jsonData.data.course_need);
                        $('#form_false_reason').html(jsonData.data.false_reason);
                        $('#form_is_coming').html(jsonData.data.is_coming);
                        $('#form_arrive_time_str').html(jsonData.data.arrive_time_str);

                        /*followTable = table.render({
                            elem: '#follow_table',
                            url: 'saleOrder/findAllFollow?sale_id=' + sale_ID,
                            title: '回访记录',
                            toolbar: '#toolBars',
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
                                templet: '#followstateTpl',
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
                                minWidth: 200
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
                        */

                        $("#sale-content").slideDown();
                    }else if (code==101) {

                        $("#sale-content").slideUp();

                    }else{
                        layer.msg("未知错误", {
                            icon: 2
                        });
                    }
                }
            });



        }



        //查看/编辑按钮后界面信息详情
        function op3(saleid) {
            // data 操作数据id
            $.ajax({
                url: "saleOrder/findSaleBySaleId?sale_id=" + saleid,
                type: "get",
                success: function (data) {
                    var jsonData = JSON.parse(data);

                    var data=jsonData.sale;
                    $('#form_customer_name').html(data.customer_name);
                    $('#form_customer_contact').html(data.customer_contact);
                    $('#form_relation').html(data.relation);
                    $('#form_stu_name').html(data.stu_name);
                    $('#form_stu_age').html(data.stu_age);
                    $('#form_stu_grade').html(data.stu_grade);



                    $('#form_assign_staff_name').html(data.assign_staff_name);
                    $('#form_sale_stage').html(data.sale_stage);
                    $('#form_course_need').html(data.course_need);
                    $('#form_false_reason').html(data.false_reason);
                    $('#form_is_coming').html(data.is_coming);
                    $('#form_arrive_time_str').html(data.arrive_time_str);
                   /* followTable = table.render({
                        elem: '#follow_table',
                        url: 'saleOrder/findAllFollow?sale_id=' + saleid,
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
                    });*/
                    form.render(); // 更新全部000
                }
            });
        }



        // 编辑客户信息
        $('#change-follow').on('click', function () {
            layer.open({
                type: 2,
                title: '修改客户信息',
                shadeClose: true,
                shade: 0.8,
                area: ['80%', '80%'],
                content: 'saleOrder/gotoJsp?sale_id=' + sale_ID + "&jsp=changeFollowPage"
            });
        });


      /*  // 头工具栏事件
        table.on('toolbar(follow_table)', function (obj) {
            switch (obj.event) {
                case 'follow':
                    layer.open({
                        type: 2,
                        title: '回访信息登记',
                        shadeClose: true,
                        shade: 0.8,
                        area: ['80%', '80%'],
                        content: 'saleOrder/gotoFollow?sale_id=' + sale_ID + "&jsp=followPage"
                    });
                    break;
            };


        });*/



        // 返回按按钮点击事件
        $('#back').on('click', function () {
            if (opNumber == 2) {
                $("#follow_up").slideUp('', function () {
                    $("#orderinit-content").slideDown();
                    $("#sale-content").slideDown();
                });
                opNumber = 1;

            } else if (opNumber == 1) {
                $('#back').parent().hide();
                $("#orderinit-content").slideUp();
                $('#examine-search-div').show();
                $("#sale-content").slideUp('', function () {
                    $("#table").slideDown();
                });
                opNumber = 0;
                table.reload('sale', {
                    url: 'orderinit/findAllOrderByAssginId?key=' + key + '&filter=' + Array.from(filter) + '&staff_id=' + staff_id
                });
            }
        });

        // 搜索工具 start
        var filter = new Set();// 需要查询的字段
        filter.add("customer_name");
        filter.add("customer_contact");
        filter.add("assign_time");
        filter.add("weixin");
        filter.add("tel_time");
        filter.add("effective");

        filter.add("stu_name");
        filter.add("stu_age");
        filter.add("stu_school");


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
                url: 'orderinit/findAllOrderByAssginId?key=' + key + '&filter=' + Array.from(filter) + '&staff_id=' + staff_id
            });
        }
        // 搜索工具 end


        // 重载表格 防止拉伸
        window.reloadTable = function () {
            saleTable.reload();
            /*if (followTable != '') {
                followTable.reload();
            }*/
        };

    });

</script>
</html>