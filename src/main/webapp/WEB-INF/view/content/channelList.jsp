<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">

<div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card-header"><h2 class="div-title">渠道列表管理</h2></div>
        <div class="layui-card-body"></div>
        <div id='table'>
            <!-- 顶部工具栏 -->
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="map-tools">


                            <button class="layui-btn layui-btn-sm layui-btn-normal" id='add-channel'>
                                <i class="layui-icon">&#xe608;</i> 添加
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
                                            <li><input type="checkbox" value="OnOffline"
                                                       title="线上线下" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="channel_id"
                                                       title="渠道ID" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="channel_type"
                                                       title="渠道类型" lay-skin="primary" lay-filter='filter' checked></li>
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
            <!--  顶部工具栏 end -->
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <table class="layui-hide" id="channel" lay-filter="channel"></table>
                    </div>
                </div>
            </div>
        </div>





        <div id='add-channel-content' style="display: none;">
            <div class="map-tools">
                <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                    <i class="layui-icon">&#xe65c;</i> 返回
                </button>
            </div>

            <div class="layui-card-body">
                <form class="layui-form" action="" id="add-channel-form">
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>所属校区</label>
                            <div class="layui-input-block">
                                <select name="campus_id" id="campus_id" lay-verify="required">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>线上线下</label>
                            <div class="layui-input-block">
                                <select name="onOffline" id="onOffline" lay-verify="required">
                                    <option value="">请选择</option>
                                    <option value="线上">线上</option>
                                    <option value="线下">线下</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>渠道类型</label>
                            <div class="layui-input-block">
                                <input type="text" id="channel_type" name="channel_type" required
                                       lay-verify="required" placeholder="请输入名称" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" id='addChannel-change' lay-submit
                                    lay-filter="addChannel">添加
                            </button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看/编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript" src="res/js/admin/channelList.js"></script>

</html>