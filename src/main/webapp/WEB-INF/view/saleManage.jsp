<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="res/image/icon.png" rel="shortcut icon" type="image/x-icon" />
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<%@ include file="header.jsp"%>
		<div class="layui-side layui-bg-black" id='menue-div'>
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test" id='menue-ul'>


					<li class="layui-nav-item layui-nav-itemed" >
						<a class="" href="javascript:;">
							<img alt="..." src="res/image/icon/application_for_Expense.png" width="30" height="30">
							销售情况浏览</a>
						<dl class="layui-nav-child">
							<dd id="mysaleList">
								<a href="javascript:;" onclick="changeBody('mysaleList')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									销售列表</a>
							</dd>
							<dd id="signList">
								<a href="javascript:;" onclick="changeBody('signList')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									报名列表</a>
							</dd>
						</dl>
					</li>



					<li class="layui-nav-item layui-nav-itemed" >
						<a class="" href="javascript:;">
							<img alt="..." src="res/image/icon/performance_evaluation.png" width="30" height="30">
							销售阶段统计</a>
						<dl class="layui-nav-child">
							<dd id="saleStatistics">
								<a href="javascript:;" onclick="changeBody('saleStatistics')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									销售阶段统计</a>
							</dd>
							<dd id="saleStatisticsUnSign">
								<a href="javascript:;" onclick="changeBody('saleStatisticsUnSign')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									未报名原因统计</a>
							</dd>

						</dl>
					</li>



					<li class="layui-nav-item layui-nav-itemed" >
						<a class="" href="javascript:;">
							<img alt="..." src="res/image/icon/statistical_report.png" width="30" height="30">
							销售工作统计</a>
						<dl class="layui-nav-child">
							<dd id="staffStatisticsTime">
								<a href="javascript:;" onclick="changeBody('staffStatisticsTime')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									时间段统计</a>
							</dd>

							<dd id="staffStatisticsMonth">
								<a href="javascript:;" onclick="changeBody('staffStatisticsMonth')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									月统计</a>
							</dd>

						</dl>
					</li>


					<li class="layui-nav-item layui-nav-itemed" >
						<a class="" href="javascript:;">
							<img alt="..." src="res/image/icon/company_profile.png" width="30" height="30">
							STEAM课程统计</a>
						<dl class="layui-nav-child">
							<dd id="steamStatistics">
								<a href="javascript:;" onclick="changeBody('steamStatistics')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									STEAM课程</a>
							</dd>
						</dl>
					</li>




					<li class="layui-nav-item layui-nav-itemed" >
						<a class="" href="javascript:;">
							<img alt="..." src="res/image/icon/application_for_Quit.png" width="30" height="30">
							销售转换</a>
						<dl class="layui-nav-child">
							<dd id="orderinitList">
								<a href="javascript:;" onclick="changeBody('orderinitList')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									初始单转换</a>
							</dd>
						</dl>
						<dl class="layui-nav-child">
							<dd id="saleList">
								<a href="javascript:;" onclick="changeBody('saleList')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									销售单转换</a>
							</dd>
						</dl>

					</li>




					<li class="layui-nav-item layui-nav-itemed" >
						<a class="" href="javascript:;">
							<img alt="..." src="res/image/icon/organization.png" width="30" height="30">
							全年销售数据分析</a>
						<dl class="layui-nav-child" >
							<dd id="saleoneyearfirst">
								<a href="javascript:;" onclick="changeBody('saleoneyearfirst')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									销售数据</a>
							</dd>
							<dd id="saleoneyearsecond">
								<a href="javascript:;" onclick="changeBody('saleoneyearsecond')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									报名人数及产出</a>
							</dd>
							<dd id="saleoneyearthird">
								<a href="javascript:;" onclick="changeBody('saleoneyearthird')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									年龄层人数及产出</a>
							</dd>

						</dl>
					</li>



					<li class="layui-nav-item layui-nav-itemed" >
						<a class="" href="javascript:;">
							<img alt="..." src="res/image/icon/roster.png" width="30" height="30">
							退课转校处理</a>
						<dl class="layui-nav-child" >
							<dd id="studentRefund">
								<a href="javascript:;" onclick="changeBody('studentRefund')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									退课处理</a>
							</dd>
							<dd id="studentUpdateCampus">
								<a href="javascript:;" onclick="changeBody('studentUpdateCampus')">
									<img alt="..." src="res/image/icon/contract_allocation.png" width="18" height="18">
									转校处理</a>
							</dd>


						</dl>
					</li>



				</ul>
			</div>
		</div>
		<div class="layui-body" style="padding: 15px;" id='body-div'>
			<!-- 内容主体区域 -->
			<%--<div style="padding: 50px; font-size: 28px">销售管理</div>--%>
		</div>
	</div>
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<script src="res/js/admin/content.js"></script>
</body>
</html>