<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>个人信息管理管理</title>
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
                    <h2 class="div-title">个人中心</h2>
                </div>
                <div class="layui-card-body">

                    <form class="layui-form" id='add-form' style="text-align: center;">

                        <fieldset class="layui-elem-field layui-field-title"
                                  style="margin: 0px;">
                            <legend>信息更新</legend>
                        </fieldset>
                        <br>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">姓名</label>
                                <div class="layui-input-block">
                                    <input type="text" name="staff_name" id='staff_name' required
                                           value="${staff.staff_name}" lay-verify="required" readonly="readonly"
                                           placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">工号</label>
                                <div class="layui-input-block">
                                    <input type="text" name="staff_id" id='staff_id' required
                                           value="${staff.staff_id}" lay-verify="required" readonly="readonly"
                                           placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>

                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">所属部门</label>
                                <div class="layui-input-block">
                                    <input type="text" name="staff_depart" id='staff_depart'
                                           value="${staff.staff_depart}"  readonly="readonly"
                                           placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>

                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">所属岗位</label>
                                <div class="layui-input-block">
                                    <input type="text" name="staff_post" id='staff_post'
                                           value="${staff.staff_post}"  readonly="readonly"
                                           placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>


                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label ">联系电话 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="staff_contact" id='staff_contact' required
                                           value="${staff.staff_contact}" lay-verify="required"
                                           placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label ">微信 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="staff_weixin" id='staff_weixin'
                                           value="${staff.staff_weixin}" lay-verify="required"
                                           placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label ">email </label>
                                <div class="layui-input-block">
                                    <input type="text" name="staff_email" id='staff_email'
                                           value="${staff.staff_email}"
                                           placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>





                        <div class="layui-form-item my-form-item" id="submit-button">
                            <div class="layui-btn-group ">
                                <button class="layui-btn my-button" lay-submit
                                        lay-filter="update-staff" id="update-staff">更新
                                </button>

                            </div>
                        </div>
                    </form>








                </div>
            </div>
        </div>
    </div>
</div>



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
        var staff_id = '${staff.staff_id}';

        // 监听提交
        form.on('submit(update-staff)', function () {
            $.ajax({
                type: "get",
                url: "staff/updateStaffByMyself?" + $("#add-form").serialize(),
                async: true,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == 100) {

                        layer.confirm('已完成', {
                            icon: 1,
                            title: '提示'
                        },function (index) {
                            layer.close(index);
                            window.location.reload(true);
                        });

                    } else if (jsonData.code == 102) {
                        layer.msg("访问受限,权限不足");
                    }
                },
                error: function (jqObj) {

                }
            });
            return false;
        });

    });
</script>
</html>