<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">
<link rel="stylesheet" href="res/css/admin/recConfiguration.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">

<div
        class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card-header"><h2 class="div-title">未成交原因统计</h2></div>
        <div class="layui-card-body"></div>
        <div id='table'>
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="map-tools">

                            <div class="layui-form" style="display: inline-block;float: right;">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">销售阶段 </label>
                                    <div class="layui-input-block">
                                        <select name="sale_stage" id="sale_stage"
                                                lay-filter="sale_stage" lay-verify="required" lay-search>
                                            <option value="">全部阶段</option>
                                            <option value="A-待定">A-待定</option>
                                            <option value="C-拒绝">C-拒绝</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="layui-form" style="display: inline-block;">
                                <div class="layui-form-item layui-form-text"
                                     style="margin-bottom: 0px;">
                                    <label class="layui-form-label">统计起始时间</label>
                                    <div class="layui-input-inline" style="margin-top: 5px">
                                        <input type="text" class="layui-input" style="height: 30px" id="time-start" placeholder="yyyy-MM-dd" readonly ="readonly">
                                    </div>
                                </div>
                            </div>

                            <div class="layui-form" style="display: inline-block;">
                                <div class="layui-form-item layui-form-text"
                                     style="margin-bottom: 0px;">
                                    <label class="layui-form-label">统计结束时间</label>
                                    <div class="layui-input-inline" style="margin-top: 5px">
                                        <input type="text" class="layui-input" style="height: 30px" id="time-end" placeholder="yyyy-MM-dd" readonly ="readonly">
                                    </div>
                                </div>
                            </div>

                            <button class="layui-btn layui-btn-sm layui-btn-normal" id='statistics'>
                                <i class="layui-icon">&#xe62a;</i> 统计该时间段
                            </button>


                        </div>
                    </div>
                </div>
            </div>
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <table class="layui-hide" id="post" lay-filter="post"></table>
                    </div>
                </div>
            </div>
        </div>

    </div>


</div>

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详细</a>
</script>


<script type="text/javascript" src="res/js/admin/saleStatisticsUnSign.js"></script>
</html>