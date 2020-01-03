<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>优创智合</title>
<link rel="stylesheet" href="layui/css/layui.css"/>
<link rel="stylesheet" href="res/css/my.css"/>
<link rel="stylesheet" media="screen and (min-width:1200px)"
	href="res/css/max.css">
<link rel="stylesheet"
	media="screen and (min-width:800px) and (max-width:1200px)"
	href="res/css/mid.css">
<link rel="stylesheet" media="screen and (max-width:800px)"
	href="res/css/min.css">
<link href="res/image/icon.png" rel="shortcut icon" type="image/x-icon" />
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<%@ include file="header.jsp"%>
		<div class="layui-side layui-bg-black" id='menue-div'>
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test" id='menue-ul'>
					<li class="layui-nav-item layui-nav-itemed" id="addStaff" onclick="changeBody('addStaff')">
                        <a class="" href="javascript:;">
							<img alt="..." src="res/image/icon/add_staff.png" width="30" height="30">
							   添加职员
                        </a>
                    </li>
					<li class="layui-nav-item ">
                        <a class="" href="javascript:;" id="staffTableList" onclick="changeBody('staffTableList')">
                            <img alt="..." src="res/image/icon/employee_list.png" width="30" height="30">
							    职员列表
                        </a>
                    </li>
					<li class="layui-nav-item layui-nav-itemed">
						<a class="" href="javascript:;">
							<img alt="..." src="res/image/icon/company_account.png" width="30" height="30">
							销售任务</a>
						<dl class="layui-nav-child">
							<dd id="saleTaskStaff">
								<a href="javascript:;" onclick="changeBody('saleTaskStaff')">
									<img alt="..." src="res/image/icon/jobmanagement.png" width="18" height="18">
									员工销售任务</a>
							</dd>
							<dd id="saleTaskCampus">
								<a href="javascript:;" onclick="changeBody('saleTaskCampus')">
									<img alt="..." src="res/image/icon/organization.png" width="18" height="18">
									校区销售任务</a>
							</dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>

		<div class="layui-body" style="padding: 15px;" id='body-div'>
			<!-- 内容主体区域 -->
			<%--<div style="padding: 50px; font-size: 28px">人员管理</div>--%>
		</div>
	</div>
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<script src="res/js/admin/content.js"></script>
</body>
</html>