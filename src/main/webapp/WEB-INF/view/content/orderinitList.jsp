<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">
<div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card-header"><h2 class="div-title">初始单列表</h2></div>
        <div class="layui-card-body"></div>
        <!-- 顶部工具栏 -->
        <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-body">
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
                                        <li><input type="checkbox" value="campus_name"
                                                   title="校区" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="assign_staff_name"
                                                   title="销售人员" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="customer_name"
                                                   title="客户姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="customer_contact"
                                                   title="客户联系方式" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="order_staff_name"
                                                   title="营销员工" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="collect_name"
                                                   title="收集人姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="collect_tel"
                                                   title="收集人电话" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="entry_real"
                                                   title="录入时间" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="channel_type"
                                                   title="来自渠道" lay-skin="primary" lay-filter='filter' checked></li>
                                        <li><input type="checkbox" value="marketing_name"
                                                   title="来自活动" lay-skin="primary" lay-filter='filter' checked></li>
                                        <hr>
                                        <li id='close-filter' style="cursor: pointer;"><i
                                                class="layui-icon">&#x1006;</i>关闭
                                        </li>
                                    </ul>
                                </form>
                            </div>
                        </div>
                        <div class="layui-form" style="display: inline-block;">
                            <div class="layui-form-item layui-form-text"
                                 style="margin-bottom: 0px;">
                                <label class="layui-form-label" id="assign-label">选择的初始单分配给</label>
                                <div class="layui-input-inline">
                                    <select name="staff_id" id="staff_id"
                                            lay-filter="staff_id" lay-verify="required" lay-search>
                                        <option value="">请选择</option>
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

                    <div id='record' style="display: none">
                        <table class="layui-hide" id="transformRecord" lay-filter="transformRecord"></table>
                    </div>

                    <div id='table'>
                        <table class="layui-hide" id="orderinit" lay-filter="orderinit"></table>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>



<script type="text/html" id="stateTp2">
    {{#  var myDate = new Date(); }}
    {{#  if(d.entry_real != null) { }}

    {{#  if((d.entry_real.time - myDate.getTime()) < 86400000) { }}
    <span style="color: #20c12e;">{{ d.entry_real_str }}</span>
    {{#  } else if((d.entry_real.time - myDate.getTime()) < 172800000) { }}
    <span style="color: #FFB800;">{{ d.entry_real_str }}</span>
    {{#  } else { }}
    <span style="color: #d82b2b">{{ d.entry_real_str }}</span>
    {{#  }  }}
    {{#  }  }}

</script>

<script type="text/html" id="toolBar1">
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="transformChecked">批量转换</button>
    <button class="layui-btn layui-btn-sm layui-bg-cyan" style="margin-right: 50px; " lay-event="transformRecord">转换记录</button>
    <span class="layui-badge layui-bg-green">未过24小时</span>
    <span class="layui-badge layui-bg-orange">未过48小时</span>
    <span class="layui-badge layui-bg-red">超过48小时</span>
    <span class="layui-badge layui-bg-cyan">已成功报名</span>
</script>

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看/编辑</a>
</script>

<script type="text/html" id="opreationBarFollow">
    <a class="layui-btn layui-btn-xs" lay-event="edit" style="right: 0px">查看详情</a>
</script>

<script type="text/javascript" src="res/js/admin/orderinitList.js"></script>
</html>