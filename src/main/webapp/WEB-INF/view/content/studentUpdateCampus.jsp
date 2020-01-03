<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="gb2312" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/recConfiguration.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">
<link rel="stylesheet" href="layui/formSelects-v4.css">

<div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
    <div class="layui-card">
        <input type="hidden" value="${staff.staff_id}" id="staffId"/>
        <div class="layui-card-header"><h2 class="div-title">学生转校</h2></div>
        <div class="layui-card-body">

            <div id='sign-content' style="display: none;">
                <div class="map-tools" style="margin-bottom: 10px; ">
                    <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                        <i class="layui-icon">&#xe65c;</i> 返回
                    </button>
                </div>

                <div class="layui-card-body">


                    <form class="layui-form"  accept-charset="UTF-8">

                        <fieldset class="layui-elem-field layui-field-title"
                                  style="margin: 0px;">
                            <legend>转校学生信息</legend>
                        </fieldset>
                        <br>


                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item">
                                <label class="layui-form-label">学生姓名</label>
                                <div class="layui-input-block">
                                    <input type="text" name="student_name" id='student_name' required
                                           lay-verify="required" placeholder="请输入" readonly="readonly"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>


                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">学生余额</label>
                                <div class="layui-input-block">
                                    <input type="text" name="real_balance" id="real_balance" required
                                           lay-verify="required" placeholder="请输入" readonly="readonly"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>

                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item">
                                <label class="layui-form-label">转出校区</label>
                                <div class="layui-input-block">
                                    <input type="text" name="campus_name" id='campus_name' required
                                           lay-verify="required" placeholder="请输入" readonly="readonly"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div
                                class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                            <div class="layui-form-item">
                                <label class="layui-form-label">转入校区</label>
                                <div class="layui-input-block">
                                    <input type="text" name="transfer_campus_name" id='transfer_campus_name' required
                                           lay-verify="required" placeholder="请输入" readonly="readonly"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>


                    </form>
                    <br>
                    <br>
                    <form class="layui-form" id='new-sign-form' accept-charset="UTF-8">

                        <fieldset class="layui-elem-field layui-field-title"
                                  style="margin: 0px;">
                            <legend>新校区购课记录</legend>
                        </fieldset>




                        <br>
                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item">
                                    <label class="layui-form-label"><a style="color: red;">*
                                    </a>家长姓名</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="customer_name" id='customer_name' required
                                               lay-verify="required" placeholder="请输入"
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
                                               lay-verify="required" placeholder="请输入"
                                               autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                            </div>
                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label"><a style="color: red;">*
                                    </a>亲属关系 </label>
                                    <div class="layui-input-block">
                                        <select name="relation" id="relation"  lay-verify="required">
                                            <option value="">请选择</option>
                                            <option value="父亲">父亲</option>
                                            <option value="母亲">母亲</option>
                                            <option value="爷爷">爷爷</option>
                                            <option value="奶奶">奶奶</option>
                                            <option value="监护人">监护人</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label"><a style="color: red;">*
                                    </a>产品选择</label>
                                    <div class="layui-input-block">
                                        <select name="all_course" xm-select="all_course"
                                                lay-filter="all_course" lay-verify="required" lay-search>
                                            <option value="">请选择</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                       <%--     <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label"> 优惠卷</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="reward_balance" id='reward_balance'  placeholder="请输入优惠金额"
                                               autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                            </div>--%>
                           <%-- <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">购买课次 </label>
                                    <div class="layui-input-block">
                                        <input type="text" name="order_course_num" id='order_course_num'  placeholder="课次收费课程时填写"
                                               autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                            </div>--%>
                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label"><a style="color: red;">*
                                    </a>成交价格</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="final_price" id='final_price' required
                                               lay-verify="required" placeholder="请输入"
                                               autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                            </div>

                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">余额付款 </label>
                                    <div class="layui-input-block">
                                        <input type="text" name="real_balance_buy" id='real_balance_buy'  placeholder="请输入"
                                               autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                            </div>
                          <%--  <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label"><a style="color: red;">*
                                    </a>购课日期</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="sign_date" id='sign_date' required
                                               lay-verify="required" placeholder="yyyy-MM-dd"
                                               autocomplete="off" class="layui-input" readonly="readonly">
                                    </div>
                                </div>
                            </div>--%>


                            <div class="layui-form-item my-form-item" id="submit-button">
                                <div class="layui-btn-group">
                                    <button class="layui-btn my-button" lay-submit
                                            lay-filter="addNewCourseSign" id="addNewCourseSign">完成
                                    </button>
                                </div>
                            </div>

                    </form>

                </div>
            </div>

        </div>


        <div id='table'>
            <!-- 顶部工具栏 -->
            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="map-tools" style="display: flex;">

                            <div class="search-filter-main">
                                <i id='filter' class="layui-icon">&#xe6b2;</i>
                                <div id='filter-ul-div' class="filter-ul-div">
                                    <form class="layui-form">
                                        <ul id='filter-ul'>
                                            <li><input type="checkbox" value="student_name"
                                                       title="学生姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="campus_name"
                                                       title="转出校区" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="transfer_campus_name"
                                                       title="转入校区" lay-skin="primary" lay-filter='filter' checked></li>
                                            <li><input type="checkbox" value="update_loadtime"
                                                       title="转校时间" lay-skin="primary" lay-filter='filter' checked></li>
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
            <!--  顶部工具栏 end -->


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
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看/编辑</a>
</script>





<script type="text/javascript">
    //全局定义一次, 加载formSelects
    layui.config({
        base: 'layui/' //此处路径请自行处理, 可以使用绝对路径
    }).extend({
        formSelects: 'formSelects-v4'
    });
</script>
<script type="text/javascript" src="res/js/admin/studentUpdateCampus.js"></script>
</html>