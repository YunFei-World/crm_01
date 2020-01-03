<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="res/css/my.css">

    <link rel="stylesheet" media="screen and (min-width:1200px)"
          href="res/css/max.css">
    <link rel="stylesheet"
          media="screen and (min-width:800px) and (max-width:1200px)"
          href="res/css/mid.css">
    <link rel="stylesheet" media="screen and (max-width:800px)"
          href="res/css/min.css">
    <link rel="stylesheet" href="res/css/login.css">
</head>


<body class="layui-layout-body">

<div id='bg-one'
     style="width: 100%; height: 100%;; position: absolute; background-image: url('/res/image/1.jpg'); background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">

</div>
<div class="layui-layout layui-layout-admin">

    <div class="layui-header">
        <div class="layui-logo">
            <div class="logo-icon">
                <img src='res/image/sun.png'/>
            </div>
            <div class="cmpany-name">优创智合</div>
        </div>

    </div>


    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div
                class="layui-card layui-col-xs8 layui-col-sm5 layui-col-md3 layui-col-lg2"
                style="box-shadow: 1px 0px 20px black;">
            <div id='login-div'>
                <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                    <ul class="layui-tab-title">
                        <li class="layui-this" style="padding: 0; margin: 0; width: 33%;" id="marketing-login">营销职员</li>
                        <li style="padding: 0; margin: 0; width: 33%;" id="sale-login">销售职员</li>
                        <li style="padding: 0; margin: 0; width: 34%;" id="admin-login">管理员</li>
                    </ul>
                </div>

                <div class="layui-card-body">
                    <form class="layui-form layui-form-pane" id='login_form'>
                        <div class="layui-form-item">
                            <label class="layui-form-label">账号</label>
                            <div class="layui-input-inline">
                                <input required lay-verify="required" type="text" id="staff_id"
                                       name="staff_id" placeholder="请输入工号" autocomplete="off"
                                       class="layui-input" maxlength="21">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-inline">
                                <input required lay-verify="required" type="password"
                                       id="password" name="password" placeholder="请输入密码"
                                       autocomplete="off" class="layui-input" maxlength="16">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn layui-btn-fluid" lay-submit id="login"
                                    lay-filter="login"><i id='login-load'
                                                          class="layui-icon layui-anim layui-anim-rotate layui-anim-loop"
                                                          style="display: none;">&#xe63d;</i> 登录
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="layui/layui.js"></script>
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="res/js/vidbg.js"></script>
<script>
    jQuery(function ($) {
        $('#bg-one').vidbg({
            'mp4': 'res/vbg.mp4',
            'poster': 'res/image/1.jpg',
        }, {
            muted: true,
            loop: true,
            overlay: false,
        });
    });
    //JavaScript代码区
    layui.use(['element', 'jquery', 'form', 'layer'], function () {
        var element = layui.element;
        var $ = jQuery = layui.jquery;
        var form = layui.form;
        var layer = layui.layer;
        var type = '0';

        //监听提交
        form.on('submit(login)', function (data) {
            $('#login-load').fadeIn();
            $('#login').prop("disabled", true);
            $.ajax({
                type: "get",
                url: "login?" + $("#login_form").serialize() + "&type=" + type,
                async: true,
                success: function (data) {
                    $('#login-load').fadeOut();
                    $('#login').prop("disabled", false);
                    var jsonData = JSON.parse(data);
                    if (jsonData.code === 100) {
                        window.location.href = "gotoJsp?jsp=staff/orderInit/firstManage"+"&con=myOrderinit";
                    } else if (jsonData.code === 101) {
                        window.location.href = "gotoJsp?jsp=staff/myInitSale";
                    } else if (jsonData.code === 102) {
                        window.location.href = "gotoJsp?jsp=marketManage";
                    } else {
                        layer.msg(jsonData.msg);
                    }
                },
                error: function (jqObj) {
                }
            });
            return false;
        });

        $('#marketing-login').on('click', function () {
            if (type != '0') {
                type = '0';
                var that = this;
                layer.tips('已切换营销职员登录', that);
            }

        });

        $('#sale-login').on('click', function () {
            if (type != '1') {
                type = '1';
                var that = this;
                layer.tips('已切换销售职员登录', that);
            }
        });

        $('#admin-login').on('click', function () {
            if (type != '2') {
                type = '2';
                var that = this;
                layer.tips('已切换管理员登录', that);
            }

        });
    });
</script>
</body>
</html>