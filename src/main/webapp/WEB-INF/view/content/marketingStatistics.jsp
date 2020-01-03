<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">
<div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <div class="layui-card-header"><h2 class="div-title">活动统计</h2></div>
        <div class="layui-card-body"></div>

        <div id='table'>
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="map-tools">


                            <div class="layui-form" style="display: inline-block;">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">渠道选择 </label>
                                    <div class="layui-input-block">
                                        <select name="channel_id" id="channel_id"
                                                lay-filter="channel_id" lay-verify="required" lay-search>
                                            <option value="">请选择</option>
                                        </select>
                                    </div>
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
                                            <li><input type="checkbox" value="channel_type"
                                                       title="所属渠道" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="channel_id"
                                                       title="渠道ID" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="marketing_name"
                                                       title="活动名称" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="marketing_date"
                                                       title="活动时间" lay-skin="primary" lay-filter='filter' checked></li>

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
                        <table class="layui-hide" id="marketingStatisticTable" lay-filter="marketingStatisticTable"></table>
                    </div>
                </div>
            </div>
        </div>

    </div>


</div>

<%--<script type="text/html" id="opreationBar">--%>
    <%--<a class="layui-btn layui-btn-xs" lay-event="edit">查看详细</a>--%>
<%--</script>--%>


<script type="text/javascript" src="res/js/admin/marketingStatistics.js"></script>
</html>