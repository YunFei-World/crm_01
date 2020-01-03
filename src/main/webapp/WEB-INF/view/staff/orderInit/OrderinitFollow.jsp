<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">
<div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card-header"><h2 class="div-title">毛单后续销售情况</h2></div>
        <div class="layui-card-body">
            <div class="map-tools" style="margin-bottom: 10px; display: none;">
                <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                    <i class="layui-icon">&#xe65c;</i> 返回
                </button>



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
                                                <th>客户姓名</th>
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

                        </div>
                    </div>

                    <br>
                    <br>

                    <fieldset class="layui-elem-field layui-field-title"
                              style="margin-top: 20px;margin-bottom: 0px;">
                        <legend>回访记录</legend>
                    </fieldset>


                    <table class="layui-hide" id="follow_table" lay-filter="follow_table"></table>


                </div>


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
                                    <label class="layui-form-label">回访是否有效</label>
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



        <!-- 顶部工具栏 -->
        <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-body">
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
                                       <li><input type="checkbox" value="channel_type"
                                                  title="所属渠道" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="marketing_name"
                                                  title="所属活动" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="collect_name"
                                                  title="收集人" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="collect_tel"
                                                  title="收集人电话" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="entry_real"
                                                  title="录入时间" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="assign_staff_name"
                                                  title="分配销售" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="effective"
                                                  title="毛单状态" lay-skin="primary" lay-filter='filter' checked></li>

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

                </div>
            </div>
        </div>


        <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div id='table'>
                        <table class="layui-hide" id="initorder" lay-filter="initorder"></table>
                    </div>
                </div>
            </div>
        </div>




    </div>
</div>

<script type="text/html" id="stateTpl">
    {{#  if(d.is_effective === '无效') { }}
    <span style="color: #d82b2b;">{{ d.is_effective }}</span>
    {{#  } else if(d.is_effective === '有效') { }}
    <span style="color: #20c12e;">{{ d.is_effective }}</span>
    {{#  } }}
</script>



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
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详情</a>
</script>



<script type="text/html" id="opreationBarFollow">
    <a class="layui-btn layui-btn-xs" lay-event="edit" style="right: 0px">查看详情</a>
</script>






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
        var checkStaff = '';

        var staff_id = $("#staffId").val();
        var campus_id = $("#campusId").val();

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
                minWidth: 100,
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
                hide:true,
                sort: true
            }, {
                field: 'collect_tel',
                title: '收集人电话',
                minWidth: 100,
                hide:true,
                sort: true
            }, {
                field: 'entry_real_str',
                title: '录入日期',
                minWidth: 100
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






        // 监听行工具事件
        table.on('tool(initorder)', function (obj) {
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









        function op2(data) {


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

        function op1(data) {
            // 操作数据id

            $.ajax({
                url: "orderinit/findSaleByOrderinit?order_init_id=" + data.order_init_id,
                type: "get",
                success: function (data) {
                    var jsonData = JSON.parse(data);

                    var code=jsonData.code;

                    if (code==100) {
                        opID = jsonData.data.sale_id;
                        $('#customer_name').html(jsonData.data.customer_name);
                        $('#customer_contact').html(jsonData.data.customer_contact);
                        $('#assign_staff_name').html(jsonData.data.assign_staff_name);
                        $('#relation').html(jsonData.data.relation);
                        $('#stu_name').html(jsonData.data.stu_name);
                        $('#stu_age').html(jsonData.data.stu_age);
                        $('#stu_grade').html(jsonData.data.stu_grade);
                        $('#stu_school').html(jsonData.data.stu_school);
                        $('#address').html(jsonData.data.address);
                        $('#referrer').html(jsonData.data.referrer);
                        $('#sale_stage').html(jsonData.data.sale_stage);
                        $('#course_need').html(jsonData.data.course_need);
                        $('#false_reason').html(jsonData.data.false_reason);
                        $('#is_coming').html(jsonData.data.is_coming);
                        $('#arrive_time_str').html(jsonData.data.arrive_time_str);
                        followTable = table.render({
                            elem: '#follow_table',
                            url: 'saleOrder/findAllFollow?sale_id=' + opID,
                            title: '回访记录',
                            toolbar: '#toolBar',
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
                                title: '回访是否有效',
                                templet: '#stateTpl',
                                minWidth: 120
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
                        $("#table").slideUp('', function () {
                            $('#examine-search-div').hide();
                            $('#back').parent().show();
                            $("#sale-content").slideDown();
                        });
                        form.render(); // 更新全部000

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
                    }else if (code==101) {
                        layer.msg("这个毛单还没有后续进展！！");
                    }else{
                        layer.msg("未知错误", {
                            icon: 2
                        });
                    }
                }
            });



        }





        // 搜索工具 start
        var filter = new Set();// 需要查询的字段
        filter.add("customer_name");
        filter.add("customer_contact");
        filter.add("stu_name");
        filter.add("stu_age");
        filter.add("stu_school");
        filter.add("address");
        filter.add("channel_type");
        filter.add("marketing_name");
        filter.add("collect_name");

        filter.add("collect_tel");
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
                url: 'orderinit/findAllOrderById?key=' + key + '&filter=' + Array.from(filter) + '&staff_id=' + staff_id
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
                $("#sale-content").slideUp('', function () {
                    $('#back').parent().hide();
                    $('#examine-search-div').show();
                    $("#table").slideDown();
                });
                opNumber = 0;
            } else if (opNumber == 3){
                $("#record").slideUp('', function () {
                    $('#back').parent().hide();
                    $('#examine-search-div').show();
                    $("#table").slideDown();
                });
                opNumber = 0;
            }
        });

        // 重载表格 防止拉伸
        window.reloadTable = function () {
            initorderTable.reload();
            if (followTable != '') {
                followTable.reload();
            }

        };

    });
</script>
</html>