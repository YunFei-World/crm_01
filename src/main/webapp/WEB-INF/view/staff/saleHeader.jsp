<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<a id='headerUrl' style="display: none; height: 0px; width: 0px;">${url}</a>
<div class="layui-header">
	<div class="layui-logo">
		<div class="logo-icon">
			<img src='res/image/sun.png' />
		</div>
		<div class="cmpany-name">优创智合</div>
	</div>
	<!-- 头部区域（可配合layui已有的水平导航） -->
	<ul class="layui-nav layui-layout-left nav-max">
		<li class="layui-nav-item"><a href="gotoJsp?jsp=staff/myInitSale"
			id="staff-myInitSale">初始单</a></li>
		<li class="layui-nav-item"><a href="gotoJsp?jsp=staff/mySale"
			id="staff-mySale">销售总单</a></li>

		<li class="layui-nav-item"><a href="gotoJsp?jsp=staff/mySign" id="staff-mySign">报名单</a></li>

		<li class="layui-nav-item"><a href="gotoJsp?jsp=staff/mySaleTask" id="staff-mySaleTask">我的任务</a></li>


		<li class="layui-nav-item"><a href="javascript:;">到店登记</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="gotoJsp?jsp=staff/myToShop"
					   id="staff-myToShop">带到/直接</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/myInvitationToShop"
					   id="staff-myInvitationToShop">邀约到店</a>
				</dd>


			</dl>
		</li>
	</ul>



	<ul class="layui-nav layui-layout-left nav-mid"  >

		<li class="layui-nav-item">功能</input>
			<dl class="layui-nav-child">
				<dd>
					<a href="gotoJsp?jsp=staff/myInitSale"
					   id="staff-myInitSale-mid">初始单</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/mySale"
					   id="staff-mySale-mid">销售总单</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/mySign"
					   id="staff-mySign-mid">报名单</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/mySaleTask"
					   id="staff-mySaleTask-mid">我的任务</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/myToShop"
					   id="staff-myToShop-mid">带到/直接</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/myInvitationToShop"
					   id="staff-myInvitationToShop-mid">邀约到店</a>
				</dd>

			</dl>
		</li>
	</ul>


	<ul class="layui-nav layui-layout-right">
		<li class="layui-nav-item" style="margin-left: 10px;">
			<a href="javascript:;">
				<img src="res/image/sun.png" class="layui-nav-img">
					${staff.staff_name}
			</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="loginOut">注销</a>

				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/myOwnMessage">个人信息</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/updatePassword">修改密码</a>
				</dd>
			</dl>
		</li>
	</ul>
</div>
