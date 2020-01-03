<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">

<div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12" >
	<div class="layui-card">
		<input type="hidden" value="${staff.staff_id}" id="staffId"/>
		<div class="layui-card-header">
			<h2 class="div-title">添加职员</h2>
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
								lay-verify="required" placeholder="请输入" autocomplete="off"
								class="layui-input">
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
								   lay-verify="required" placeholder="请输入" autocomplete="off"
								   class="layui-input" value="666666" readonly = "readonly">
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
							lay-filter="add-staff" id="add-staff">提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript" src="res/js/admin/addStaff.js"></script>
</html>