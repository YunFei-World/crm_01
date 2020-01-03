<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">

<div
        class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card-header">
            <h2 class="div-title">到店情况</h2>
        </div>
        <div class="layui-card-body">
            <div id='table'>
                <!-- 顶部工具栏 -->
                <div class="map-tools">
                    <button class="layui-btn layui-btn-sm layui-btn-normal"
                            id='add-toShop'>
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
                                    <li><input type="checkbox" value="staff_name"
                                               title="顾问老师" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="customer_name"
                                               title="客户姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="customer_contact"
                                               title="联系方式" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="to_shop"
                                               title="到店方式" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="is_to_shop"
                                               title="是否到店" lay-skin="primary" lay-filter='filter' checked></li>
                                    <li><input type="checkbox" value="reserve_date"
                                               title="预约到店时间" lay-skin="primary" lay-filter='filter' checked>
                                    </li>
                                    <li><input type="checkbox" value="actual_date"
                                               title="实际到店时间" lay-skin="primary" lay-filter='filter' checked>
                                    </li>
                                    <hr>
                                    <li id='close-filter' style="cursor: pointer;"><i
                                            class="layui-icon">&#x1006;</i>关闭
                                    </li>
                                </ul>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- 顶部工具栏 end-->
                <table class="layui-hide" id="toShop" lay-filter="toShop"></table>
            </div>
            <div id='toShop-content' style="display: none">
                <!-- 顶部工具栏 -->
                <div class="map-tools">
                    <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                        <i class="layui-icon">&#xe65c;</i> 返回
                    </button>
                </div>

                <div class="layui-card-body">
                    <form class="layui-form" id='update-toShop-form' accept-charset="UTF-8">
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                            <div class="layui-form-item">
                                <label class="layui-form-label"><a style="color: red;">*
                                </a>客户姓名</label>
                                <div class="layui-input-block">
                                    <input type="text" name="customer_name" id='customer_name' required
                                           lay-verify="required" placeholder="请输入"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label"><a style="color: red;">*
                                </a>联系方式 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="customer_contact" id="customer_contact" required
                                           lay-verify="required" placeholder="请输入"
                                           autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label"><a style="color: red;">*
                                </a>到店方式 </label>
                                <div class="layui-input-block">
                                    <select name="to_shop" id="to_shop" lay-verify="required"
                                            readonly="readonly">
                                        <option value="">请选择</option>
                                        <option value="带到访">带到访</option>
                                        <option value="直接上门">直接上门</option>
                                        <option value="邀请到店">邀请到店</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">&nbsp;&nbsp;预约到店 </label>
                                <div class="layui-input-block">
                                    <input type="text" name="reserve_date" id="reserve_date"
                                           placeholder="yyyy-MM-dd HH:mm:ss"
                                           autocomplete="off" class="layui-input" readonly="readonly">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                            <div class="layui-form-item">
                                <label class="layui-form-label">&nbsp;&nbsp;是否到店 </label>
                                <div class="layui-input-block">
                                    <select name="is_to_shop" id="is_to_shop" readonly="readonly">
                                        <option value="">请选择</option>
                                        <option value="是">是</option>
                                        <option value="否">否</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">&nbsp;&nbsp;实际到店 </label>
                                <div class="layui-input-block">
                                    <input type="text" class="layui-input" id="actual_date"
                                           name="actual_date" placeholder="yyyy-MM-dd HH:mm:ss" readonly="readonly">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item my-form-item" id="submit-button">
                            <div class="layui-btn-group">
                                <button class="layui-btn my-button" lay-submit
                                        lay-filter="updateToShop" id="add-change">修改
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                        <div class="layui-form-item my-form-item">
                            <div class="layui-btn-group">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详情</a>
</script>

<script type="text/html" id="stateTp1">
    {{#  var myDate = new Date(); }}
    {{#  if(d.reserve_date != null) { }}
    {{#  if(d.is_to_shop === null || d.is_to_shop==='') { }}
    {{#  if((d.reserve_date.time - myDate.getTime()) < 0) { }}
    <span style="color: #d82b2b;">{{ d.reserve_date_str }}</span>
    {{#  } else if((d.reserve_date.time - myDate.getTime()) < 86400000) { }}
    <span style="color: #FFB800;">{{ d.reserve_date_str }}</span>
    {{#  } else { }}
    <span style="color: #20c12e;">{{ d.reserve_date_str }}</span>
    {{#  }  }}
    {{#  } else { }}
    <span>{{ d.reserve_date_str }}</span>
    {{#  }  }}
    {{#  }  }}
</script>

<script type="text/html" id="toolBar">
    <span class="layui-badge layui-bg-red">过时未约见</span>
    <span class="layui-badge layui-bg-orange">不足24小时</span>
    <span class="layui-badge layui-bg-green">超过24小时</span>
</script>

<script type="text/javascript" src="res/js/admin/toShopList.js"></script>
</html>