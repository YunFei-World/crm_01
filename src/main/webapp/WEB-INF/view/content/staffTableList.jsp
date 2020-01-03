<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="gb2312" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/recConfiguration.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">
<div
        class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card-header"><h2 class="div-title">职员列表</h2></div>
        <div class="layui-card-body">
            <div class="map-tools" style="margin-bottom: 10px; display: none;">
                <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                    <i class="layui-icon">&#xe65c;</i> 返回
                </button>
            </div>
        </div>
        <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <!-- 顶部工具栏 -->
                    <div class="map-tools" id="examine-search-div">
                        <div class="layui-form" style="display: inline-block;float: right;" >
                            <div class="layui-form-item layui-form-text">
                                <div class="layui-input-block"></div>
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

                        <div class="search-filter-main">
                            <i id='filter' class="layui-icon">&#xe6b2;</i>
                            <div id='filter-ul-div' class="filter-ul-div">
                                <form class="layui-form">
                                    <ul id='filter-ul'>
                                        <li><input type="checkbox" value="staff_id" title="工号"
                                                   lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="staff_name" title="姓名"
                                                   lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="staff_depart" title="部门"
                                                   lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="staff_post" title="职位"
                                                   lay-skin="primary" lay-filter='filter' checked></li>
                                        <hr>
                                        <li id='close-filter' style="cursor: pointer;">
                                            <i class="layui-icon">&#x1006;</i>关闭
                                        </li>
                                    </ul>
                                </form>
                            </div>
                        </div>

                        <div class="layui-form" style="display: inline-block;" >
                            <div class="layui-form-item layui-form-text"
                                 style="margin-bottom: 0px;">
                                <label class="layui-form-label">按部门浏览&nbsp;&nbsp;</label>
                                <div class="layui-input-inline">
                                    <select name="department_id" id="department_id"
                                            lay-filter="department_id" lay-verify="required" lay-search>
                                        <option value="">请选择</option>
                                        <option value="营销部">营销部</option>
                                        <option value="销售部">销售部</option>
                                        <option value="管理员">管理员</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                    </div>


                </div>
            </div>
        </div>

        <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div id='table'>
                        <table class="layui-hide" id="myTable" lay-filter="myTable"></table>
                    </div>
                </div>
            </div>
        </div>

        <div id='add-post-content' style="display: none;">
            <div class="content-form">
                <fieldset class="layui-elem-field layui-field-title"
                          style="margin: 0px;">
                    <legend>基本信息</legend>
                </fieldset>
                <div style="display: flex;">
                    <div style="flex: 1">
                        <table class="layui-table">
                            <colgroup>
                                <col>
                                <col>
                                <col>
                                <col>
                                <col>
                                <col>
                                <col>
                                <col>
                                <col>
                            </colgroup>
                            <thead>
                            <tr>
                                <th>校区</th>
                                <th>工号</th>
                                <th>姓名</th>
                                <th>密码</th>
                                <th>部门</th>
                                <th>职位</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td id='campus_name'></td>
                                <td id='staff_id'></td>
                                <td id='staff_name'></td>
                                <td id='password'></td>
                                <td id='staff_depart'></td>
                                <td id='staff_post'></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div style="padding-left: 25px; padding-right: 25px; cursor: pointer; padding-top: 20px; text-align: center;">
                        <div id='change-staff-base'>
                            <img alt="" src="res/image/icon/edit.png" width="30" height="30">
                            <p>编辑</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</div>

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看/编辑</a>
    <a class="layui-btn layui-btn-xs" lay-event="delete">删除</a>
</script>

<script type="text/javascript" src="res/js/admin/staffTableList.js"></script>
</html>