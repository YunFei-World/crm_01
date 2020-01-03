<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">
<link rel="stylesheet" href="res/css/admin/recConfiguration.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">
<link rel="stylesheet" href="res/css/admin/staffStatisticsWeek.css">



<div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card-header"><h2 class="div-title">毛单列表</h2></div>
        <div class="layui-card-body">

            <div id='orderinit-content' style="display: none">
                <!-- 顶部工具栏 -->
                <div class="map-tools">
                    <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                        <i class="layui-icon">&#xe65c;</i> 返回
                    </button>
                </div>
                <form class="layui-form" id='update-orderinit-form' accept-charset="UTF-8" >
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>客户姓名</label>
                            <div class="layui-input-block">
                                <input type="text" name="customer_name" id='customer_name' required
                                       lay-verify="required" placeholder="请输入" readonly="readonly"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>联系方式 </label>
                            <div class="layui-input-block">
                                <input type="text" name="customer_contact" id="customer_contact" required
                                       lay-verify="required" placeholder="请输入" readonly="readonly"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>录入人员 </label>
                            <div class="layui-input-block">
                                <input type="text" name="order_staff_name" id="order_staff_name" required
                                       readonly="readonly" lay-verify="required" placeholder="请输入"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>所属渠道 </label>
                            <div class="layui-input-block">
                                <input type="text" name="channel_name" id="channel_name" required
                                       readonly="readonly" lay-verify="required" placeholder="请输入"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>收集人姓名</label>
                            <div class="layui-input-block">
                                <input type="text" name="collect_name" id='collect_name' required
                                       lay-verify="required" placeholder="请输入" readonly="readonly"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>收集人电话 </label>
                            <div class="layui-input-block">
                                <input type="text" name="collect_tel" id="collect_tel" required
                                       lay-verify="required" placeholder="请输入" readonly="readonly"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>录入时间 </label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" id="entry_date"
                                       name="entry_date" lay-verify="required"
                                       placeholder="yyyy-MM-dd" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>实际日期 </label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" id="entry_real"
                                       name="entry_real" lay-verify="required"
                                       placeholder="yyyy-MM-dd HH:mm:ss" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>是否分配 </label>
                            <div class="layui-input-block">
                                <input type="text" name="state" id="state" required
                                       disabled="disabled" lay-verify="required" placeholder="请输入" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6" id = "assign">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label" ><a style="color: red;">*
                            </a>被分配给 </label>
                            <div class="layui-input-block">
                                <input type="text" name="assign_staff_name" id="assign_staff_name" required
                                       disabled="disabled" lay-verify="required" placeholder="请输入" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6" id = "e-effective">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label" ><a style="color: red;">*
                            </a>是否有效 </label>
                            <div class="layui-input-block">
                                <input type="text" name="effective" id="effective" required
                                       disabled="disabled" lay-verify="required" placeholder="请输入" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item my-form-item" id="submit-button">
                        <div class="layui-btn-group">
                            <%--<button class="layui-btn my-button" lay-submit
                                    lay-filter="updateOrderinit" id="change">修改
                            </button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div id='table'>
            <!-- 顶部工具栏 -->
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="map-tools">
                            <div class="layui-form" style="display: inline-block;">
                                <div class="layui-form-item layui-form-text" style="margin-bottom: 0px;display: inline-block;">
                                    <label class="layui-form-label">毛单分配给</label>
                                    <div class="layui-input-inline" >
                                        <select name="staff_id" id="staff_id"
                                                lay-filter="staff_id" lay-verify="required" lay-search>
                                            <option value="">请选择</option>
                                        </select>
                                    </div>
                                </div>
                            </div>


                            <div class="map-search" >
                                <div id="r-result">
                                    <input type="text" id="serach-address-key" size="18"
                                           placeholder="搜索"/><i id='search-i' class="layui-icon"
                                                                style="color: #fff;">&#xe615;</i>
                                </div>
                                <div id="searchResultPanel"></div>
                            </div>

                            <div class="search-filter-main" >
                                <i id='filter' class="layui-icon">&#xe6b2;</i>
                                <div id='filter-ul-div' class="filter-ul-div">
                                    <form class="layui-form">
                                        <ul id='filter-ul'>
                                            <li><input type="checkbox" value="customer_name"
                                                       title="客户姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="customer_contact"
                                                       title="联系方式" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="collect_name"
                                                       title="收集人姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="collect_tel"
                                                       title="收集人电话" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="order_staff_name"
                                                       title="录入人员" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="campus_name"
                                                       title="所属校区" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="channel_type"
                                                       title="所属渠道" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="marketing_name"
                                                       title="所属活动" lay-skin="primary" lay-filter='filter' checked></li>

                                            <li><input type="checkbox" value="entry_date"
                                                       title="录入日期" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="entry_real"
                                                       title="实际日期" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="state"
                                                       title="是否分配" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="assign_staff_name"
                                                       title="被分配给" lay-skin="primary" lay-filter='filter' checked></li>
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
                        <table class="layui-hide" id="initorder" lay-filter="initorder"></table>
                    </div>
                </div>
            </div>
        </div>



    </div>
</div>







<script type="text/html" id="stateTpl">
    {{#  if(d.state === '未分配'){ }}
    <span style="color: #d82b2b;">{{ d.state }}</span>
    {{#  } else if(d.state === '已分配') { }}
    <span style="color: #20c12e;">{{ d.state}}</span>
    {{#  } }}
</script>

<script type="text/html" id="stateTp2">
    {{#  if(d.effective === '无效单'){ }}
    <span style="color: #d82b2b;">{{ d.effective }}</span>
    {{#  } else if(d.effective === '有效单') { }}
    <span style="color: #20c12e;">{{ d.effective}}</span>
    {{#  } }}
</script>

<script type="text/html" id="toolBar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="assignChecked">毛单分配</button>
    </div>
</script>

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详情</a>
</script>

<script type="text/javascript" src="res/js/admin/orderinitAssign.js"></script>
</html>