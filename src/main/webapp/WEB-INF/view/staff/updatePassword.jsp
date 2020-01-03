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
                            <legend>修改密码</legend>
                        </fieldset>
                        <br>
                        <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12" >
                            <div class="layui-form-item" style="margin-left: 40%">
                                <label class="layui-form-label"><a style="color: red;">*
                                </a>旧密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="password" required lay-verify="required"
                                           name="oldpwd" id="oldpwd"
                                           placeholder="请输入旧密码" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux"><span id="oldpwd2" ></span></div>
                            </div>
                        </div>

                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                            <div class="layui-form-item" style="margin-left: 40%">
                                <label class="layui-form-label"><a style="color: red;">*
                                </a>新密码</label>
                                <div class="layui-input-inline" >
                                    <input type="password" name="password" required lay-verify="required"
                                           name="newpwd" id="newpwd"
                                           placeholder="请输入新密码" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux"><span id="newpwd2"></span></div>
                            </div>
                        </div>

                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                        <div class="layui-form-item " style="margin-left: 40%">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>确认密码</label>
                            <div class="layui-input-inline">
                                <input type="password" name="password" required lay-verify="required"
                                       name="newpwdtwo" id="newpwdtwo"
                                       placeholder="请确认密码" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux"><span id="newpwdtwo2"></span></div>
                        </div>
                        </div>










                        <div class="layui-form-item my-form-item" id="submit-button">
                            <div class="layui-btn-group ">
                                <button class="layui-btn my-button" lay-submit
                                        lay-filter="update-pwd" id="update-pwd">确定
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




        var temp='';
        //先写一个鼠标移开的事件
        $('#oldpwd').blur(function(){
            var oldpwd = $('#oldpwd').val();//获取文本框的值
            //部分路径
            $.ajax({
                type : 'post',//post的提交方式
                url : 'staff/checkOldPwd?oldpwd='+oldpwd+'&staff_id='+staff_id,//完整的路径
                dataType: 'json',
                async : false,
                success : function(data) {//成功的话判断密码是否为数据库中的密码
                    temp=data.code;
                    if (data.code == 1) {//如果为true则输入正确

                        $('#oldpwd2').text('密码输入正确');
                    } else {//判断是否为空
                        if (oldpwd == "" || oldpwd == null) {
                            $('#oldpwd2').text('旧密码不能为空');
                        } else {
                            $('#oldpwd2').text('密码输入不正确');
                        }
                    }
                },
                error : function() {
                    alert("请求错误，请退出重新登陆");
                }
            });
        });


        var newpwd=$('#newpwd').val();
        var newpwdtwo=$('#newpwdtwo').val();

        // 监听提交
        form.on('submit(update-pwd)', function () {

            if (oldpwd == "" || oldpwd == null) {
                $('#oldpwd2').text('旧密码不能为空');
            }


            newpwd=$('#newpwd').val();
            newpwdtwo=$('#newpwdtwo').val();


            if (newpwd!=newpwdtwo) {
                $('#newpwd2').text('新密码两次不一致');
                $('#newpwdtwo2').text('新密码两次不一致');
            }else{
                $.ajax({
                    type: "get",
                    url: "staff/updateStaffOwnPassword?staff_id=" +staff_id+"&newpwd="+newpwd,
                    async: true,
                    success: function (data) {
                        var jsonData = JSON.parse(data);
                        if (jsonData.code == 100) {
                            layer.confirm('修改完成', {
                                icon: 1,
                                title: '提示'
                            },function () {
                                window.location.href = window.location.href;
                            });

                        } else if (jsonData.code == 102) {
                            layer.msg("访问受限,权限不足");
                        }
                    },
                    error: function (jqObj) {

                    }
                });
            }

            return false;
        });
    });







</script>
</html>