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
                            </a>员工姓名</label>
                            <div class="layui-input-block">
                                <select name="all_staff" xm-select="all_staff"
                                        lay-filter="all_staff" lay-verify="required" lay-search>
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
                            <label class="layui-form-label "><a style="color: red;">*
                            </a>月任务 </label>
                            <div class="layui-input-block">
                                <input type="text" name="month_task" id="month_task" required
                                       lay-verify="required" placeholder="请输入"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>第一周 </label>
                            <div class="layui-input-block">
                                <input type="text" name="week_one" id="week_one" required
                                       lay-verify="required" placeholder="请输入"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>第二周 </label>
                            <div class="layui-input-block">
                                <input type="text" name="week_two" id="week_two" required
                                       lay-verify="required" placeholder="请输入"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>第三周 </label>
                            <div class="layui-input-block">
                                <input type="text" name="week_three" id="week_three" required
                                       lay-verify="required" placeholder="请输入"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>第四周 </label>
                            <div class="layui-input-block">
                                <input type="text" name="week_four" id="week_four" required
                                       lay-verify="required" placeholder="请输入"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">第五周 </label>
                            <div class="layui-input-block">
                                <input type="text" name="week_five" id="week_five"
                                       placeholder="请注意该月是否有第五周" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">第六周 </label>
                            <div class="layui-input-block">
                                <input type="text" name="week_six" id="week_six"
                                       placeholder="请注意该月是否有第六周" autocomplete="off" class="layui-input">
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
    layui.use(['element', 'jquery', 'form', 'formSelects','laydate'], function () {
        var element = layui.element;
        var $ = jQuery = layui.jquery;
        var form = layui.form;
        var formSelects = layui.formSelects;
        var laydate = layui.laydate;
        var keys = [];
        var ids = [];
        var staff_id = $("#staffId").val();
        var campus_id = '${task_campus_id}';

        // 选择日期
        laydate.render({
            elem: '#month',
            type: 'month'
        });

        $.ajax({
            url: 'findAllSaleStaff?staff_id=' + staff_id + "&campus_id=" + campus_id,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function (data) {
                for (var i = 0; i < data.data.length; i++) {
                    var a = data.data[i].staff_id + ' ' + data.data[i].staff_name + ' ' + data.data[i].campus_name;
                    var temp = {"name": a, "value": data.data[i].staff_id};
                    keys.push(temp);
                }
            }
        });

        //local模式 本地数据
        formSelects.data('all_staff', 'local', {
            arr: keys
        });

        formSelects.on('all_staff', function (id, vals, val, isAdd, isDisabled) {
            for(var i = 0; i < vals.length; i++){
                ids[i] = vals[i].value;
            }
        }, true);

        // 监听提交
        form.on('submit(add-staff)', function (data) {
            $.ajax({
                type: "get",
                url: "addSaleTask?" + $("#add-form").serialize(),
                async: false,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == 100) {
                        layer.confirm('已完成', {
                            icon: 1,
                            title: '提示'
                        }, function (index) {
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                            parent.location.reload();
                        });
                    } else if (jsonData.code == 101) {
                        layer.confirm('员工 '+jsonData.staff_name + ' 已经分配过任务了', {
                            time: 2500,
                            title: '提示'
                        }, function (index) {
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                            parent.location.reload();
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