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
    <%@ include file="marketingHeader.jsp" %>
    <div class="layui-side layui-bg-black" id='menue-div'>
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test" id='menue-ul'>
                <li class="layui-nav-item selected"  >
                    <a class="" href="javascript:;" id="myOrderinit" onclick="changeBodyOne('myOrderinit')">
                        <img alt="..." src="res/image/icon/organizational_structure.png" width="30" height="30">
                        我的毛单
                    </a>
                </li>
                <li class="layui-nav-item " >
                    <a class="" href="javascript:;" id="myMarketing" onclick="changeBodyOne('myMarketing')">
                        <img alt="..." src="res/image/icon/organizational_structure.png" width="30" height="30">
                        市场营销活动
                    </a>
                </li>
                <li class="layui-nav-item " >
                    <a class="" href="javascript:;" id="myChannel" onclick="changeBodyOne('myChannel')">
                        <img alt="..." src="res/image/icon/organizational_structure.png" width="30" height="30">
                        现有渠道查看
                    </a>
                </li>
            </ul>
        </div>
    </div>


    <div class="layui-body" style="padding: 15px;" id='body-div'>
    </div>
</div>
<script src="layui/layui.js"></script>
<script src="res/js/admin/firstcontent.js"></script>
</body>
</html>