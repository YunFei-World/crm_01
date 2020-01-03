<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>优创智合</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../res/css/my.css">
    <link rel="stylesheet" href="../layui/formSelects-v4.css"/>

    <style>
        .spinner {
            width: 60px;
            height: 60px;

            position: relative;
            margin: 20px;
        }

        .double-bounce1, .double-bounce2 {
            width: 100%;
            height: 100%;
            border-radius: 50%;
            background-color: #67CF22;
            opacity: 0.6;
            position: absolute;
            top: 0;
            left: 0;

            -webkit-animation: bounce 2.0s infinite ease-in-out;
            animation: bounce 2.0s infinite ease-in-out;
        }

        .double-bounce2 {
            -webkit-animation-delay: -1.0s;
            animation-delay: -1.0s;
        }

        @-webkit-keyframes bounce {
            0%, 100% {
                -webkit-transform: scale(0.0)
            }
            50% {
                -webkit-transform: scale(1.0)
            }
        }

        @keyframes bounce {
            0%, 100% {
                transform: scale(0.0);
                -webkit-transform: scale(0.0);
            }
            50% {
                transform: scale(1.0);
                -webkit-transform: scale(1.0);
            }
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <div class="layui-body" id='body-div'
         style="left: 0px; top: 0px; bottom: 0px; padding: 20px;"
         align="center">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card">
            <div class="layui-card-body">
                <form class="layui-form" id='add-form'>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>校区名称</label>
                            <div class="layui-input-block">
                                <select name="campusId" xm-select="campusId"
                                        lay-filter="campusId" lay-verify="required" lay-search>
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label "><a style="color: red;">*
                            </a>分配月份 </label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" id="month"
                                       name="month" lay-verify="required"
                                       placeholder="yyyy-MM" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>课程科目 </label>
                            <div class="layui-input-block">
                                <select name="subject_id" id="subject_id"
                                        lay-filter="subject_id" lay-verify="required" lay-search>
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <%--<div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>课程名称 </label>
                            <div class="layui-input-block">
                                <select name="course_id" id="course_id"
                                        lay-filter="course_id" lay-verify="required" lay-search>
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>--%>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label "><a style="color: red;">*
                            </a>月任务 </label>
                            <div class="layui-input-block">
                                <input type="text" name="subject_task" id="subject_task" required
                                       lay-verify="required" placeholder="请输入"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item my-form-item" id="submit-button">
                        <div class="layui-btn-group ">
                            <button class="layui-btn my-button" lay-submit
                                    lay-filter="add-staff" id="add-staff">分配
                            </button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<script src="../layui/layui.js"></script>
<script type="text/javascript">
    //全局定义一次, 加载formSelects
    layui.config({
        base: '../layui/' //此处路径请自行处理, 可以使用绝对路径
    }).extend({
        formSelects: 'formSelects-v4'
    });
</script>

<script>
    //JavaScript代码区域
    layui.use(['element', 'jquery', 'form', 'formSelects', 'laydate'], function () {
        var element = layui.element;
        var $ = jQuery = layui.jquery;
        var form = layui.form;
        var formSelects = layui.formSelects;
        var laydate = layui.laydate;
        var keys = [];
        var ids = [];
        var staff_id = $("#staffId").val();
        //后台传值
        var campus_id = '${campus_task_campus_id}';
        var subject_id = '';

        // 选择日期
        laydate.render({
            elem: '#month',
            type: 'month'
        });

        $.ajax({
            url: 'findAllCampusById?staff_id=' + staff_id + "&campus_id=" + campus_id,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function (data) {
                for (var i = 0; i < data.data.length; i++) {
                    var a = data.data[i].campus_name;
                    var temp = {"name": a, "value": data.data[i].campus_id};
                    keys.push(temp);
                }
            }
        });

        //local模式 本地数据
        formSelects.data('campusId', 'local', {
            arr: keys
        });

        formSelects.on('campusId', function (id, vals, val, isAdd, isDisabled) {
            for (var i = 0; i < vals.length; i++) {
                ids[i] = vals[i].value;
            }
        }, true);

        // 获取全部科目
        $.ajax({
            url: "findAllSubject",
            type: "get",
            success: function (data) {
                var jsonData = JSON.parse(data);
                var op = "<option value=''>请选择课程类型</option>";
                for (var x in jsonData.data) {
                    op += "<option value='" + jsonData.data[x].id + "'>" + jsonData.data[x].SUBJECT_NAME + "</option>";
                }
                $("#subject_id").html(op);
                form.render("select");
            }
        });

        /*form.on('select(subject_id)', function (data) {
            subject_id = $("#subject_id").val();
            $.ajax({
                url: "findAllCourse?subject_id=" + subject_id+'&campus_id='+campus_id,
                type: "get",
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    var op = "<option value=''>请选择课程</option>";
                    for (var x in jsonData.data) {
                        op += "<option value='" + jsonData.data[x].course_id + "'>" + jsonData.data[x].course_name + "</option>";
                    }
                    $("#course_id").html(op);
                    form.render("select");
                }
            })
        });*/

        // 监听提交
        form.on('submit(add-staff)', function (data) {
            $.ajax({
                type: "get",
                url: "insertSaleTaskSubject?" + $("#add-form").serialize()
                    + "&ids=" + ids,
                async: false,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == 100) {
                        layer.confirm('已完成', {
                            icon: 1,
                            title: '提示'
                        }, function (index) {
                            window.parent.location.reload();
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                        });
                    } else if (jsonData.code == 101) {
                        layer.confirm( ' 已经分配' , {
                            icon: 0,
                            title: '提示'
                        }, function (index) {
                            window.parent.location.reload();
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭

                        });
                    }else if (jsonData.code == 102) {
                        layer.confirm('该校区不存在，请重新添加', {
                            icon: 2,
                            title: '提示'
                        }, function (index) {
                            window.parent.location.reload();
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭

                        });
                    }
                },
                error: function (jqObj) {

                }
            });
            return false;
        });
    });
</script>
</body>
</html>