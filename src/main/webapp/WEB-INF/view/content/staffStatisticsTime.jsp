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
        <div class="layui-card-header"><h2 class="div-title">工作月统计</h2></div>
        <div class="layui-card-body"></div>
        <div id='table'>
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="map-tools">

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


                            <div class="map-search">
                                <div id="r-result">
                                    <input type="text" id="serach-address-key" size="18"
                                           placeholder="搜索"/><i id='search-i' class="layui-icon"
                                                                style="color: #fff;">&#xe615;</i>
                                </div>
                                <div id="searchResultPanel"></div>
                            </div>
                            <div class="search-filter-main">
                                <i id='filter' class="layui-icon">&#xe6b2;</i>
                                <div id='filter-ul-div' class="filter-ul-div">
                                    <form class="layui-form">
                                        <ul id='filter-ul'>
                                            <li><input type="checkbox" value="staff_name"
                                                       title="员工姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="staff_post"
                                                       title="员工岗位" lay-skin="primary" lay-filter='filter' checked></li>

                                            <hr>
                                            <li id='close-filter' style="cursor: pointer;"><i
                                                    class="layui-icon">&#x1006;</i>关闭
                                            </li>
                                        </ul>
                                    </form>
                                </div>
                            </div>


                            <div class="layui-form" style="display: inline-block;float: right;" >
                                <div class="layui-form-item layui-form-text">
                                    <div class="layui-input-block"></div>
                                </div>
                            </div>

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

<script type="text/javascript" src="res/js/admin/staffStatisticsTime.js"></script>
</html>