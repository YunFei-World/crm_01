<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<a id='headerUrl' style="display: none; height: 0px; width: 0px;">${url}</a>
<a style="display: none " id='con'>${con}</a>
<div class="layui-header">
	<div class="layui-logo">
		<div class="logo-icon">
			<img src='res/image/sun.png' />
		</div>
		<div class="cmpany-name">优创智合</div>
		<i id='menue-i' class="layui-icon layui-icon-shrink-right"
		   style="width: 40px;"></i>
	</div>
	<!-- 头部区域（可配合layui已有的水平导航） -->
	<ul class="layui-nav layui-layout-left nav-max">
		<li class="layui-nav-item"><a href="gotoJsp?jsp=staff/orderInit/firstManage&con=myOrderinit"
									  id="staff-myOrderinit">操作</a></li>
		<li class="layui-nav-item"><a href="gotoJsp?jsp=staff/orderInit/secondManage&con=OrderinitFollow"
									  id="staff-myMarketing">后续</a></li>

	</ul>


	<ul class="layui-nav layui-layout-left nav-mid"  >

		<li class="layui-nav-item">功能</input>
			<dl class="layui-nav-child">
				<dd>
					<a href="gotoJsp?jsp=staff/orderInit/firstManage&con=myOrderinit"
					   id="staff-myOrderinit-mid">操作</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/orderInit/secondManage&con=OrderinitFollow"
					   id="staff-myMarketing-mid">后续</a>
				</dd>

			</dl>
		</li>
	</ul>


	<ul class="layui-nav layui-layout-right">
		<li class="layui-nav-item" style="margin-left: 10px;">
			<a href="javascript:;">
				<img src="res/image/sun.png" class="layui-nav-img" <%--style="font-size: 20px;"--%>>
					${staff.staff_name}
			</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="loginOut">注销</a>
				</dd>

			</dl>
		</li>
	</ul>
</div>
