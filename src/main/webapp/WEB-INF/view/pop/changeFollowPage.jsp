<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>优创智合</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../res/css/my.css">

    <style>
        .spinner {
            width: 60px;
            height: 60px;

            position: relative;
            margin: 20px;
        }

        .double-bounce1, .double-bounce2 {
            width: 100%;
            height: 100%;
            border-radius: 50%;
            background-color: #67CF22;
            opacity: 0.6;
            position: absolute;
            top: 0;
            left: 0;

            -webkit-animation: bounce 2.0s infinite ease-in-out;
            animation: bounce 2.0s infinite ease-in-out;
        }

        .double-bounce2 {
            -webkit-animation-delay: -1.0s;
            animation-delay: -1.0s;
        }

        @-webkit-keyframes bounce {
            0%, 100% {
                -webkit-transform: scale(0.0)
            }
            50% {
                -webkit-transform: scale(1.0)
            }
        }

        @keyframes bounce {
            0%, 100% {
                transform: scale(0.0);
                -webkit-transform: scale(0.0);
            }
            50% {
                transform: scale(1.0);
                -webkit-transform: scale(1.0);
            }
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <div class="layui-body" id='body-div'
         style="left: 0px; top: 0px; bottom: 0px; padding: 20px;"
         align="center">
        <div class="layui-card">
            <div class="layui-card-body">
                <form class="layui-form" id='add-form'>

                    <fieldset class="layui-elem-field layui-field-title"
                              style="margin: 0px;">
                        <legend>学生信息完善</legend>
                    </fieldset>
                    <br>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>家长姓名</label>
                            <div class="layui-input-block">
                                <input type="text" name="customer_name" id='customer_name' required
                                       value="${sale.customer_name}" lay-verify="required"
                                       placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label "><a style="color: red;">*
                            </a>联系方式 </label>
                            <div class="layui-input-block">
                                <input type="text" name="customer_contact" id='customer_contact' required
                                       value="${sale.customer_contact}" lay-verify="required"
                                       placeholder="请输入" autocomplete="off" class="layui-input">
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
                            </a>学生姓名 </label>
                            <div class="layui-input-block">
                                <input type="text" name="stu_name" id='stu_name'
                                       value="${sale.stu_name}" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="required">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>学生年龄 </label>
                            <div class="layui-input-block">
                                <input type="text" name="stu_age" id='stu_age'
                                       value="${sale.stu_age}" placeholder="(注:请填写数字)" autocomplete="off" class="layui-input" lay-verify="required">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">学生年级 </label>
                            <div class="layui-input-block">
                               <input type="text" name="stu_grade" id='stu_grade' lay-filter="stu_grade"
                                      value="${sale.stu_grade}" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="required">

                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">学生学校 </label>
                            <div class="layui-input-block">
                                <input type="text" name="stu_school" id='stu_school'
                                       value="${sale.stu_school}" placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">家庭住址 </label>
                            <div class="layui-input-block">
                                <input type="text" name="address" id='address'
                                       value="${sale.address}" placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>

                    <fieldset class="layui-elem-field layui-field-title"
                              style="margin: 0px;">
                        <legend>购课信息记录</legend>
                    </fieldset>
                    <br>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">顾问老师 </label>
                            <div class="layui-input-block">
                                <input type="text" name="assign_staff_name" id='assign_staff_name' readonly="readonly"
                                       value="${sale.assign_staff_name}" placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">推荐人 </label>
                            <div class="layui-input-block">
                                <input type="text" name="referrer" id='referrer' value="${sale.referrer}"
                                       placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">课程需求 </label>
                            <div class="layui-input-block">
                                <input type="text" name="course_need" id='course_need'
                                       value="${sale.course_need}" placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>

                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>销售阶段 </label>
                            <div class="layui-input-block">
                                <select name="sale_stage" id="sale_stage" lay-verify="required">
                                    <option value="${sale.sale_stage}">${sale.sale_stage}</option>
                                    <option value="A-待定">A-待定</option>
                                    <option value="B-接受">B-接受</option>
                                    <option value="C-拒绝">C-拒绝</option>

                                </select>
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">下次联系 </label>

                            <div class="layui-input-block">
                                <input type="text" name="next_time" id='next_time' class="layui-input" readonly="readonly"
                                       placeholder="(注：电话回访则填写下次回电时间)" autocomplete="off"  value="${sale.next_time_str}">
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">上访时间 </label>

                            <div class="layui-input-block">
                                <input type="text" name="arrive_time" id='arrive_time' class="layui-input"
                                       placeholder="(注：邀约上访则选择上访时间)" autocomplete="off"  value="${sale.arrive_time_str}" readonly="readonly">
                            </div>
                        </div>
                    </div>

                    <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">未报名原因 </label>
                            <div class="layui-input-block">
                                <select name="false_reason" id="false_reason"  lay-filter="false_reason" >
                                    <option value="${sale.false_reason}">${sale.false_reason}</option>
                                    <option value="A.价格">A.价格</option>
                                    <option value="B.个人课程满">B.个人课程满</option>
                                    <option value="C.距离">C.距离</option>
                                    <option value="D.其他机构在读">D.其他机构在读</option>
                                    <option value="E.对比其它机构">E.对比其它机构</option>
                                    <option value="F.其它因素">F.其它因素</option>
                                </select>
                            </div>

                        </div>
                    </div>



                    <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6" id="other_reason_all" style="display: none">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">其它因素 </label>

                            <div class="layui-input-block">
                                <input type="text" name="other_reason" id='other_reason' lay-filter="other_reason" class="layui-input"
                                       placeholder="(注：其它因素说明)"  autocomplete="off"  value="${sale.other_reason}">
                            </div>
                        </div>
                    </div>





                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">备注 </label>

                            <div class="layui-input-block">
                                <textarea type="text" name="other_remark" id="other_remark"  placeholder="请输入"
                                          class="layui-textarea"></textarea>
                            </div>
                        </div>
                    </div>



                    <div class="layui-form-item my-form-item" id="submit-button">
                        <div class="layui-btn-group ">
                            <button class="layui-btn my-button" lay-submit
                                    lay-filter="add-staff" id="add-staff">更新
                            </button>

                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<script src="../layui/layui.js"></script>
<script>

    //JavaScript代码区域
    layui.use(['element', 'jquery','laydate','form'], function () {
        var laydate = layui.laydate;
        var element = layui.element;
        var $ = jQuery = layui.jquery;
        var form = layui.form;

        var relation = '${sale.relation}';
        var sale_id = '${sale.sale_id}';
        var other_remark='${sale.other_remark}';


        $("#relation").val(relation);
        $("#other_remark").val(other_remark);




        var other_reason='${sale.other_reason}';
        var false_reason='${sale.false_reason}';
        if (false_reason=='F.其它因素'){
            $("#other_reason").val(other_reason);
            $("#other_reason_all").slideDown();
        }else{//如果没有使用其它因素 则赋为”“
            $("#other_reason_all").slideUp();

        }

        laydate.render({
            elem : '#arrive_time',
            type : 'datetime',
            theme : '#0078d7',
            trigger: 'click'
        });
        laydate.render({
            elem : '#next_time',
            type : 'datetime',
            theme : '#0078d7',
            trigger: 'click'
        });


        form.render("select");




        //监听是否选中其它因素
        form.on('select(false_reason)',function () {
            false_reason=$("#false_reason").val();
            if (false_reason=='F.其它因素'){
                $("#other_reason").val(other_reason);
                $("#other_reason_all").slideDown();
            }else{//如果没有使用其它因素 则赋为”“
                $("#other_reason_all").slideUp();

            }
        });


        // 监听提交
        form.on('submit(add-staff)', function () {
            $.ajax({
                type: "get",
                url: "updateSale?" + $("#add-form").serialize()
                    + "&sale_id=" + sale_id,
                async: true,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == 100) {
                        layer.confirm('已完成', {
                            icon: 1,
                            title: '提示'
                        }, function (index) {
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                            parent.location.reload();


                        });

                    } else if (jsonData.code == 102) {
                        layer.msg("访问受限,权限不足");
                    }
                },
                error: function (jqObj) {

                }
            });
            return false;
        });
    });
</script>
</body>
</html>