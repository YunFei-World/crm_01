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
            <div class="layui-card-header">
                <h2 class="div-title">修改职员：${staff1.staff_name} 基本信息</h2>
            </div>
            <div class="layui-card-body">
                <form class="layui-form" id='add-form'>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>姓名</label>
                            <div class="layui-input-block">
                                <input type="text" name="staff_name" id='staff_name' required
                                       value="${staff1.staff_name}" lay-verify="required"
                                       placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>密码</label>
                            <div class="layui-input-block">
                                <input type="text" name="password" id='password' required
                                       value="${staff1.password}" lay-verify="required"
                                       placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>校区 </label>
                            <div class="layui-input-block">
                                <select name="campus_id" id="campus_id" lay-verify="required">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>部门 </label>
                            <div class="layui-input-block">
                                <select name="staff_depart" id="staff_depart" lay-filter="staff_depart" lay-verify="required">
                                    <option value="">请选择</option>
                                    <option value="营销部">营销部</option>
                                    <option value="销售部">销售部</option>
                                    <option value="管理员">管理员</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>职位 </label>
                            <div class="layui-input-block">
                                <select name="staff_post" id="staff_post" lay-filter="staff_post" lay-verify="required">
                                    <option value="">请选择</option>
                                    <option value="部门职员">部门职员</option>
                                    <option value="管理员">管理员</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item my-form-item" id="submit-button">
                        <div class="layui-btn-group">
                            <button class="layui-btn my-button" lay-submit
                                    lay-filter="add-staff" id="add-staff">更新
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
<script>
    //JavaScript代码区域
    layui.use(['element', 'jquery', 'form'], function () {
        var element = layui.element;
        var $ = jQuery = layui.jquery;
        var form = layui.form;
        var staff_id = '${staff1.staff_id}';//被操作员工 id
        var campus_id = '${staff1.campus_id}';
        var staff_depart = '${staff1.staff_depart}';
        var staff_post = '${staff1.staff_post}';

        var staffId = $("#staffId").val();//操作管理员 id
        <%--var campusId = '${campus_id}';//页面所显示校区--%>
        $("#staff_depart").val(staff_depart);
        $("#staff_post").val(staff_post);
        $("#campus_id").val(campus_id);
        form.render("select");


        var opp='';
        form.on('select(staff_depart)', function () {
            staff_depart = $("#staff_depart").val();
            if (staff_depart=='管理员'){
                opp= "<option value='管理员'>管理员</option>";
            }else if(staff_depart=='销售部'||staff_depart=='营销部') {
                opp= "<option value='部门职员'>部门职员</option>";
            }
            $("#staff_post").html(opp);
            form.render("select");


        });


        // 获取校区
        $.ajax({
            url: "findAllCampusById?staff_id=" + staffId ,
            type: "get",
            success: function (data) {
                var jsonData = JSON.parse(data);
                var op = "<option value=''>请选择</option>";
                for (var x in jsonData.data) {
                    op += "<option value='" + jsonData.data[x].campus_id + "'>" + jsonData.data[x].campus_name + "</option>";
                }
                $("#campus_id").html(op);
                $("#campus_id").val(campus_id);
                form.render("select");
            }
        });






        // 监听提交
        form.on('submit(add-staff)', function (data) {
            $.ajax({
                type: "post",
                url: "updateStaff?" + $("#add-form").serialize()
                    + "&staff_id=" + staff_id,
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
                    } else if (jsonData.code == 102) {
                        layer.msg("访问受限,权限不足");
                    }
                },
                error: function (jqObj) {
                    layer.close(load);
                }
            });
            return false;
        });
    });
</script>
</body>
</html>