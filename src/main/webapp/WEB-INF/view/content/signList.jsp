<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">

<div
        class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card-header"><h2 class="div-title">课程报名</h2></div>
        <div class="layui-card-body"></div>
        <!-- 顶部工具栏 -->
        <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-body">


                    <div class="map-tools" id="examine-search-div" style="display: flex;">

                        <div class="search-filter-main">
                            <i id='filter' class="layui-icon">&#xe6b2;</i>
                            <div id='filter-ul-div' class="filter-ul-div">
                                <form class="layui-form">
                                    <ul id='filter-ul'>
                                        <li><input type="checkbox" value="customer_name"
                                                   title="客户姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="customer_contact"
                                                   title="联系方式" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="relation"
                                                   title="亲属关系" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="stu_name"
                                                   title="学生姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="assign_staff_name"
                                                   title="顾问老师" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="course_name"
                                                   title="课程名称" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="load_time"
                                                   title="报名日期" lay-skin="primary" lay-filter='filter' checked></li>
                                        <hr>
                                        <li id='close-filter' style="cursor: pointer;"><i
                                                class="layui-icon">&#x1006;</i>关闭
                                        </li>
                                    </ul>
                                </form>
                            </div>
                        </div>
                        <div class="map-search">
                            <div id="r-result">
                                <input type="text" id="serach-address-key" size="18"
                                       placeholder="搜索"/><i id='search-i' class="layui-icon"
                                                            style="color: #fff;">&#xe615;</i>
                            </div>
                            <div id="searchResultPanel"></div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
        <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div id='table'>
                        <table class="layui-hide" id="sign" lay-filter="sign"></table>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</div>
</div>



<script type="text/javascript" src="res/js/admin/signList.js"></script>

</html>