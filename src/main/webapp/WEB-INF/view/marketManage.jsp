<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>优创智合</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="res/css/my.css">
    <link rel="stylesheet" media="screen and (min-width:1200px)"
          href="res/css/max.css">
    <link rel="stylesheet"
          media="screen and (min-width:800px) and (max-width:1200px)"
          href="res/css/mid.css">
    <link rel="stylesheet" media="screen and (max-width:800px)"
          href="res/css/min.css">
    <link href="res/image/icon.png" rel="shortcut icon" type="image/x-icon"/>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <%@ include file="header.jsp" %>

    <div class="layui-side layui-bg-black" id='menue-div'>
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test" id='menue-ul'>
                <li class="layui-nav-item ">
                    <a class="" href="javascript:;" id="orderinitAssign" onclick="changeBody('orderinitAssign')">
                        <img alt="..." src="res/image/icon/organizational_structure.png" width="30" height="30">
                        毛单分配
                    </a>
                </li>

                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">
                        <img alt="..." src="res/image/icon/welfare.png" width="30" height="30">
                        市场活动浏览</a>
                    <dl class="layui-nav-child">
                        <dd id="marketingManage">
                            <a href="javascript:;" onclick="changeBody('marketingManage')">
                                <img alt="..." src="res/image/icon/attendance_configuration.png" width="18" height="18">
                                活动列表</a>
                        </dd>
                        <dd id="channelList">
                            <a href="javascript:;" onclick="changeBody('channelList')">
                                <img alt="..." src="res/image/icon/attendance_configuration.png" width="18" height="18">
                                渠道列表</a>
                        </dd>


                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">
                        <img alt="..." src="res/image/icon/performance_evaluation.png" width="30" height="30">
                        营销工作统计</a>
                    <dl class="layui-nav-child">
                        <dd id="marketingStatistics">
                            <a href="javascript:;" onclick="changeBody('marketingStatistics')">
                                <img alt="..." src="res/image/icon/attendance_configuration.png" width="18" height="18">
                                活动统计</a>
                        </dd>
                        <dd id="channelStatistics">
                            <a href="javascript:;" onclick="changeBody('channelStatistics')">
                                <img alt="..." src="res/image/icon/attendance_configuration.png" width="18" height="18">
                                渠道统计</a>
                        </dd>


                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body" style="padding: 15px;" id='body-div'>
        <div style="padding: 50px; font-size: 28px">管理员管理界面</div>
    </div>
</div>
<script src="layui/layui.js"></script>
<script src="res/js/header.js"></script>
<script src="res/js/admin/content.js"></script>
</body>
</html>