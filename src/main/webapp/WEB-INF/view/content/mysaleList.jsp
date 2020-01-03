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
        <div class="layui-card-header"><h2 class="div-title">销售列表</h2></div>
        <div class="layui-card-body">
            <div class="map-tools" style="margin-bottom: 10px; display: none;">
                <button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
                    <i class="layui-icon">&#xe65c;</i> 返回
                </button>



                <div id='sale-content' style="display: none;">
                    <div class="content-form">
                        <fieldset class="layui-elem-field layui-field-title"
                                  style="margin: 0px;">
                            <legend>客户信息</legend>
                        </fieldset>
                        <div style="display: flex;">
                            <div style="flex: 1">

                                <fieldset class="layui-elem-field">
                                    <legend>学生信息</legend>
                                    <div class="layui-field-box">
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
                                                <th>客户姓名</th>
                                                <th>联系电话</th>
                                                <th>亲属关系</th>
                                                <th>学生姓名</th>
                                                <th>学生年龄</th>
                                                <th>学生年级</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td id='customer_name'></td>
                                                <td id='customer_contact'></td>
                                                <td id='relation'></td>
                                                <td id='stu_name'></td>
                                                <td id='stu_age'></td>
                                                <td id='stu_grade'></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </fieldset>


                                <fieldset class="layui-elem-field">
                                    <legend>购课信息</legend>
                                    <div class="layui-field-box">
                                        <table class="layui-table">
                                            <colgroup>
                                                <col>
                                                <col>
                                                <col>
                                                <col>
                                            </colgroup>
                                            <thead>
                                            <tr>
                                                <th>顾问老师</th>
                                                <th>销售阶段</th>
                                                <th>课程需求</th>
                                                <th>未报名原因</th>
                                                <th>是否到店上访</th>
                                                <th>上访时间</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td id='assign_staff_name'></td>
                                                <td id='sale_stage'></td>
                                                <td id='course_need'></td>
                                                <td id='false_reason'></td>
                                                <td id='is_coming'></td>
                                                <td id='arrive_time_str'></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </fieldset>

                            </div>

                        </div>
                    </div>

                    <br>
                    <br>

                    <fieldset class="layui-elem-field layui-field-title"
                              style="margin-top: 20px;margin-bottom: 0px;">
                        <legend>回访记录</legend>
                    </fieldset>
                    <div class="map-tools" style="margin-bottom: 10px; display: none;">
                        <button class="layui-btn layui-btn-sm layui-btn-normal" id='follow'>
                            <i class="layui-icon">&#xe65c;</i> 访问/回访登记
                        </button>
                    </div>
                    <table class="layui-hide" id="follow_table" lay-filter="follow_table"></table>
                </div>

                <div id='record' style="display: none">
                    <table class="layui-hide" id="transformRecord" lay-filter="transformRecord"></table>
                </div>
                <div id='follow_up' style="display: none">
                    <div class="layui-card-body">
                        <form class="layui-form" id='add-marketing-form' accept-charset="UTF-8">
                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">顾问老师</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="staff_name" id='staff_name' required
                                               lay-verify="required" placeholder="请输入"
                                               autocomplete="off" class="layui-input" readonly="readonly">
                                    </div>
                                </div>
                            </div>
                           <%-- <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">记录方式</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="save_way" id='save_way' required
                                               lay-verify="required" placeholder="请输入"
                                               autocomplete="off" class="layui-input" readonly="readonly">
                                    </div>
                                </div>
                            </div>--%>
                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">此次访问是否有效</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="is_effective" id='is_effective' required
                                               lay-verify="required" placeholder="请输入"
                                               autocomplete="off" class="layui-input" readonly="readonly">
                                    </div>
                                </div>
                            </div>


                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">联系方式</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="contact_style" id='contact_style' required
                                               lay-verify="required" placeholder="请输入"
                                               autocomplete="off" class="layui-input" readonly="readonly">
                                    </div>
                                </div>
                            </div>

                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">联系号码</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="contact_number" id='contact_number' required
                                               lay-verify="required" placeholder="请输入"
                                               autocomplete="off" class="layui-input" readonly="readonly">
                                    </div>
                                </div>
                            </div>

                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">销售阶段</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="sale_stage_up" id='sale_stage_up' required
                                               lay-verify="required" placeholder="请输入"
                                               autocomplete="off" class="layui-input" readonly="readonly">
                                    </div>
                                </div>
                            </div>
                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">未报名原因</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="false_reason_follow" id='false_reason_follow' required
                                               lay-verify="required" placeholder="请输入"
                                               autocomplete="off" class="layui-input" readonly="readonly">
                                    </div>
                                </div>
                            </div>
                            <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6" id="other_reason_all" style="display: none">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">其它因素 </label>
                                    <div class="layui-input-block">
                                        <input type="text" name="other_reason" id='other_reason' lay-filter="other_reason" class="layui-input"
                                               placeholder="(注：其它因素说明)"  autocomplete="off"  >
                                    </div>
                                </div>
                            </div>

                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">下次联系</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="next_time_up_str" id='next_time_up_str'  placeholder="请输入"
                                               autocomplete="off" class="layui-input" readonly="readonly">
                                    </div>
                                </div>
                            </div>
                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">约访时间</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="arrive_time" id='arrive_time'  placeholder="请输入"
                                               autocomplete="off" class="layui-input" readonly="readonly">
                                    </div>
                                </div>
                            </div>
                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">其它备注 </label>
                                    <div class="layui-input-block">
                                        <textarea type="text" name="other_remark" id="other_remark"
                                                  placeholder=" " class="layui-textarea" readonly="readonly">
                                        </textarea>
                                    </div>
                                </div>
                            </div>
                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">联系结果</label>
                                    <div class="layui-input-block">
                                        <textarea name="result" id='result' required lay-verify="required"
                                                  placeholder="请输入" class="layui-textarea" readonly="readonly">
                                        </textarea>
                                    </div>
                                </div>
                            </div>
                            <div
                                    class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">联系截图 </label>
                                    <div class="layui-input-block">
                                        <div style="display: flex;">
                                            <div id="layer-photos-demo" class="layer-photos-demo"
                                                 style="flex: 1"></div>
                                            <div id='screen_image'
                                                 style="padding-left: 25px; padding-right: 25px; cursor: pointer; padding-top: 75px; text-align: center;">
                                                <div>
                                                    <img alt="" src="res/image/add.png" width="30"
                                                         height="30">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-form-item my-form-item" id="submit-button">
                                <div class="layui-btn-group">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
        <!-- 顶部工具栏 -->
        <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="map-tools" id="examine-search-div" style="display: flex;">
                        <div class="search-filter-main">
                           <i id='filter' class="layui-icon">&#xe6b2;</i>
                           <div id='filter-ul-div' class="filter-ul-div">
                               <form class="layui-form">
                                   <ul id='filter-ul'>
                                       <li><input type="checkbox" value="customer_name"
                                                  title="客户姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="customer_contact"
                                                  title="联系方式" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="relation"
                                                  title="亲属关系" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="stu_name"
                                                  title="学生姓名" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="stu_age"
                                                  title="学生年龄" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="stu_grade"
                                                  title="学生年级" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="stu_school"
                                                  title="学生学校" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="address"
                                                  title="家庭住址" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="assign_staff_name"
                                                  title="顾问老师" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="referrer"
                                                  title="推荐人" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="course_need"
                                                  title="课程需求" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="sale_stage"
                                                  title="销售阶段" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="next_time"
                                                  title="下次联系时间" lay-skin="primary" lay-filter='filter' checked></li>
                                       <li><input type="checkbox" value="false_reason"
                                                  title="未报名原因" lay-skin="primary" lay-filter='filter' checked></li>
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


        <div class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
            <div class="layui-card">
                <div class="layui-card-body">


                    <div id='table'>
                        <table class="layui-hide" id="sale" lay-filter="sale"></table>
                    </div>
                </div>
            </div>
        </div>




    </div>
</div>

<script type="text/html" id="stateTpl">
    {{#  if(d.is_effective === '无效') { }}
    <span style="color: #d82b2b;">{{ d.is_effective }}</span>
    {{#  } else if(d.is_effective === '有效') { }}
    <span style="color: #20c12e;">{{ d.is_effective }}</span>
    {{#  } }}
</script>

<script type="text/html" id="stateTp2">
    {{#  var myDate = new Date(); }}
    {{#  if(d.next_time != null) { }}
    {{#  if(d.sale_stage == 'Y'){ }}
    <span>{{ d.next_time_str }}</span>
    {{#  } else { }}
    {{#  if((d.next_time.time - myDate.getTime()) < 86400000) { }}
    <span style="color: #d82b2b;">{{ d.next_time_str }}</span>
    {{#  } else if((d.next_time.time - myDate.getTime()) < 172800000) { }}
    <span style="color: #FFB800;">{{ d.next_time_str }}</span>
    {{#  } else { }}
    <span style="color: #20c12e;">{{ d.next_time_str }}</span>
    {{#  }  }}
    {{#  }  }}
    {{#  }  }}
</script>





<%--<script type="text/html" id="toolBar">
    <a class="layui-btn layui-btn-xs" lay-event="follow">回访/访问登记</a>
</script>--%>

<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详情</a>
</script>

<script type="text/html" id="opreationBarFollow">
    <a class="layui-btn layui-btn-xs" lay-event="edit" style="right: 0px">查看详情</a>
</script>

<script type="text/javascript" src="res/js/admin/mysaleList.js"></script>
</html>