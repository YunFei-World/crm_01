<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/recConfiguration.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">

<div
        class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card-header"><h2 class="div-title">销售任务分配</h2></div>
        <div class="layui-card-body">
            <div id='post-detailed-div' style="display: none;">
                <div class="map-tools" >
                    <button class="layui-btn layui-btn-sm layui-btn-normal"  id='back'>
                        <i class="layui-icon">&#xe65c;</i> 返回
                    </button>
                </div>
                <div class="layui-card-body" >
                    <form class="layui-form" id='update-orderinit-form' accept-charset="UTF-8" >
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label"><a style="color: red;">*
                                </a>校区名称</label>
                                <div class="layui-input-block">
                                    <input type="text" name="campus_name" id="campus_name" required
                                           lay-verify="required" placeholder="请输入"
                                           autocomplete="off" class="layui-input" readonly="readonly">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label "><a style="color: red;">*
                                </a>分配月份 </label>
                                <div class="layui-input-block">
                                    <input type="text" class="layui-input" id="month"
                                           name="month" lay-verify="required"
                                           placeholder="请输入" class="layui-input" readonly="readonly">
                                </div>
                            </div>
                        </div>

                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label"><a style="color: red;">*
                                </a>课程科目 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="subject_name" id="subject_name" required
                                           lay-verify="required" placeholder="请输入"
                                           autocomplete="off" class="layui-input" readonly="readonly">
                                </div>
                            </div>
                        </div>

                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label "><a style="color: red;">*
                                </a>月任务 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="subject_task" id="subject_task" required
                                           lay-verify="required" placeholder="请输入"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6"  style="display: none">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label "><a style="color: red;">*
                                </a>科目id </label>
                                <div class="layui-input-block">
                                    <input type="text" name="subject_id" id="subject_id" required
                                           lay-verify="required" placeholder="请输入"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item my-form-item" id="submit-button">
                            <div class="layui-btn-group">
                                <button class="layui-btn my-button" lay-submit
                                        lay-filter="updateOrderinit" id="change">修改
                                </button>
                                <%--<button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>

        <div id='table'>
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="map-tools">
                            <div class="layui-form" style="display: inline-block;float: right;" >
                                <div class="layui-form-item layui-form-text">
                                    <div class="layui-input-block"></div>
                                </div>
                            </div>
                            <button class="layui-btn layui-btn-sm layui-btn-normal" id='statistics'>
                                <i class="layui-icon">&#xe62a;</i> 任务分配
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
                                            <li><input type="checkbox" value="subject_name"
                                                       title="科目名称" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="month"
                                                       title="分配月份" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="load_time"
                                                       title="分配时间" lay-skin="primary" lay-filter='filter' checked></li>
                                            <hr>
                                            <li id='close-filter' style="cursor: pointer;"><i
                                                    class="layui-icon">&#x1006;</i>关闭
                                            </li>
                                        </ul>
                                    </form>
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

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改/查看</a>
</script>

<script type="text/javascript" src="res/js/admin/saleTaskCampus.js"></script>
</html>