<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!-- 隐藏的取值内容 -->
<a id='headerUrl' style="display: none; height: 0px; width: 0px;">${url}</a>
<a style="display: none " id='con'>${con}</a>
<input type="hidden" value="${staff.staff_id}" id="staffId"/>

<input type="hidden" value="${staff.staff_name}" id="thename"/>
<div class="layui-header" >

    <div class="layui-logo">
        <div class="logo-icon" id="menue_icon"><img src='res/image/sun.png'/></div>

        <div class="cmpany-name" id='menue' style="flex: 1">优创智合</div>

        <i id='menue-i' class="layui-icon layui-icon-shrink-right"
           style="width: 40px;"></i>
    </div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left nav-max" id='header-max'>

        <li class="layui-nav-item"><a href="gotoJsp?jsp=marketManage&con=orderinitAssign"
                                      id="marketManage">营销管理</a></li>
        <li class="layui-nav-item"><a href="gotoJsp?jsp=saleManage&con=mysaleList"
                                      id="saleManage">销售管理</a></li>
        <li class="layui-nav-item"><a href="gotoJsp?jsp=staffManage&con=staffTableList"
                                      id="staffManage">人员任务管理</a></li>
    </ul>


    <ul class="layui-nav layui-layout-left nav-mid" id='header-mid' >

        <li class="layui-nav-item">功能</input>
            <dl class="layui-nav-child">
                <dd>
                    <a href="gotoJsp?jsp=marketManage&con=orderinitAssign"
                       id="marketManage-mid">营销管理</a>
                </dd>
                <dd>
                    <a href="gotoJsp?jsp=saleManage&con=mysaleList"
                       id="saleManage-mid">销售管理</a>
                </dd>
                <dd>
                    <a href="gotoJsp?jsp=staffManage&con=staffTableList"
                       id="staffManage-mid">人员任务管理</a>
                </dd>

            </dl>
        </li>
    </ul>

    <input type="hidden" id="currentCampus" style="display: none" value="${chooseCampusId}">
    <ul class="layui-nav layui-layout-right "   >
        <li class="layui-nav-item" >
            <div class="layui-form" style="display: inline-block;">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">校区选择</label>
                    <div class="layui-input-block" >
                        <select name="campusId" id="campusId"
                                lay-filter="campusId" lay-verify="required" lay-search="" >

                        </select>
                    </div>
                </div>
            </div>
        </li>
        <li   class="layui-nav-item" >
            <a href="javascript:;" id="staffname">
            <i class="layui-icon" style="font-weight: bold;">${staff.staff_name}&#xe66f;</i></a>
            <dl class="layui-nav-child">
                <dd>
                    <a href="loginOut" >注销</a>
                </dd>

            </dl>
        </li>
    </ul>





    <%--<ul class="layui-nav layui-layout-right nav-mid">
        <li class="layui-nav-item">注销</i>
            <dl class="layui-nav-child">
                <dd>
                    <a href="loginOut" >退出</a>
                </dd>
            </dl>
        </li>
    </ul>--%>


</div>
<script type="text/html" id="my-content">
    <div style="width: 100%;padding-top: 20px;text-align: center;">
        <a href="loginOut" class="layui-btn layui-btn-primary">注销</a>
    </div>
</script>
