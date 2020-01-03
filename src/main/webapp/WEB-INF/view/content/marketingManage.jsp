<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">

<div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card-header"><h2 class="div-title">市场营销活动管理</h2></div>
        <div class="layui-card-body"></div>
        <div id='table'>
            <!-- 顶部工具栏 -->
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="map-tools">
                            <button class="layui-btn layui-btn-sm layui-btn-normal"
                                    id='add-marketing'>
                                <i class="layui-icon">&#xe608;</i> 添加
                            </button>
                            <button class="layui-btn layui-btn-sm layui-btn-warm"
                                    id='down-format'>
                                <i class="layui-icon">&#xe601;</i> 模板下载
                            </button>
                            <button class="layui-btn layui-btn-sm layui-btn-warm"
                                    id='add-article'>
                                <i class="layui-icon"></i> 活动导入
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
                                        <input type="hidden" id="qqqq" value="${staff.campus_id}">
                                        <ul id='filter-ul'>

                                            <li><input type="checkbox" value="marketing_id"
                                                       title="活动ID" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="channel_type"
                                                       title="渠道名称" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="marketing_name"
                                                       title="活动名称" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="marketing_place"
                                                       title="活动地点" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="marketing_staff"
                                                       title="参与人员" lay-skin="primary" lay-filter='filter' checked></li>
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
            <!-- 顶部工具栏 end-->
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                         <table class="layui-hide" id="marketing" lay-filter="marketing"></table>
                    </div>
                </div>
            </div>
        </div>
        <div id='addMarketing-content' style="display: none">
            <!-- 顶部工具栏 -->
            <div class="map-tools">
                <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                    <i class="layui-icon">&#xe65c;</i> 返回
                </button>
            </div>

            <div class="layui-card-body">
                <form class="layui-form" id='add-marketing-form' accept-charset="UTF-8">
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>活动名称</label>
                            <div class="layui-input-block">
                                <input type="text" name="marketing_name" id='marketing_name' required
                                       lay-verify="required" placeholder="请输入"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>活动地点 </label>
                            <div class="layui-input-block">
                                <input type="text" name="marketing_place" id="marketing_place" required
                                       lay-verify="required" placeholder="请输入"
                                       autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>参与人员 </label>
                            <div class="layui-input-block">
                                <input type="text" name="marketing_staff" id="marketing_staff" required
                                       lay-verify="required" placeholder="请输入"
                                       autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>活动时间 </label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" id="marketing_date"
                                       name="marketing_date" lay-verify="required"
                                       placeholder="yyyy-MM-dd" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>活动费用 </label>
                            <div class="layui-input-block">
                                <input type="text" name="marketing_fee" id="marketing_fee" required
                                       lay-verify="required" placeholder="请输入" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                    </div>

                    <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>所属渠道 </label>
                            <div class="layui-input-block">
                                <select name="channel_id" id="channel_id"
                                        lay-verify="required">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </div>
                    </div>


                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">活动内容 </label>
                            <div class="layui-input-block">
                                <textarea name="marketing_content" id='marketing_content' placeholder="请输入内容"
                                          class="layui-textarea"></textarea>
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">活动节点 </label>
                            <div class="layui-input-block">
                                <textarea name="marketing_node" id='marketing_node' placeholder="请输入内容"
                                          class="layui-textarea"></textarea>
                            </div>
                        </div>
                    </div>
                    <div id="option_remark"
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                        <fieldset class="layui-elem-field">
                            <legend>备用方案</legend>
                            <div class="layui-field-box">
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">方案一</label>
                                        <div class="layui-input-block">
                                            <input type="text" id="url_first" name="url_first" style="display: none">
                                            <div class="layui-upload-drag" id="option_first">
                                                <i class="layui-icon"></i>
                                                <p>点击上传，或将文件拖拽到此处</p>
                                            </div>
                                            <button class="layui-btn" type="button" id="option-first-show"
                                                    style="display: none;">下载方案一</button>
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">方案二</label>
                                        <div class="layui-input-block">
                                            <input type="text" id="url_second" name="url_second" style="display: none">
                                            <div class="layui-upload-drag" id="option_second">
                                                <i class="layui-icon"></i>
                                                <p>点击上传，或将文件拖拽到此处</p>
                                            </div>
                                            <button class="layui-btn" type="button" id="option-second-show"
                                                    style="display: none;">下载方案二</button>
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">方案一备注 </label>
                                        <div class="layui-input-block">
                                            <input type="text" name="remark_first" id="remark_first"
                                                   placeholder="请输入" autocomplete="off"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>

                                <div
                                        class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">方案二备注 </label>
                                        <div class="layui-input-block">
                                            <input type="text" name="remark_second" id="remark_second"
                                                   placeholder="请输入" autocomplete="off"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </fieldset>
                    </div>
                    <div class="layui-form-item my-form-item" id="submit-button">
                        <div class="layui-btn-group">
                            <button class="layui-btn my-button" lay-submit
                                    lay-filter="addMarketing" id="add-change">提交
                            </button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>

    </div>
</div>




<script type="text/html" id="toolBar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delChecked">删除所选</button>
    </div>
</script>

<script type="text/html" id="opreationBar" >
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看/编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/javascript" src="res/js/admin/marketingManage.js"></script>
</html>