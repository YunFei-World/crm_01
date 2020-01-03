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

                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md10 layui-col-lg10">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>到店访问是否有效</label>
                            <div class="layui-input-block">
                                <select name="is_effective" id="is_effective" lay-verify="required">
                                    <option value="">请选择</option>
                                    <option value="有效">有效</option>
                                    <option value="无效">无效</option>
                                </select>
                            </div>
                        </div>
                    </div>




                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label "><a style="color: red;">*
                            </a>联系方式 </label>
                            <div class="layui-input-block">
                                <select name="contact_style" id="contact_style" lay-verify="required">
                                    <option value="面谈" >面谈</option>
                                    <option value="电话">电话</option>
                                    <option value="QQ">QQ</option>
                                    <option value="微信">微信</option>
                                </select>
                            </div>
                        </div>
                    </div>


                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6" >
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">联系号码 </label>
                            <div class="layui-input-block">
                                <input type="text" name="contact_number" id='contact_number'
                                        placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>






                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>销售阶段 </label>
                            <div class="layui-input-block">
                                <select name="sale_stage_up" id="sale_stage_up" lay-verify="required">
                                    <option value="">请选择</option>
                                    <option value="A-待定">A-待定</option>
                                    <option value="B-接受">B-接受</option>
                                    <option value="C-拒绝">C-拒绝</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">未报名原因 </label>
                            <div class="layui-input-block">
                                <select name="false_reason" id="false_reason"  lay-filter="false_reason" >
                                    <option value="">请选择</option>
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
                                       placeholder="(注：其它因素说明)"  autocomplete="off"  >
                            </div>
                        </div>
                    </div>



                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">下次电话 </label>
                            <div class="layui-input-block">
                                <input type="text" name="next_time_up" id='next_time_up' class="layui-input"
                                       placeholder="(注：上访后下次邀约电话)" autocomplete="off" readonly="readonly" >
                            </div>
                        </div>
                    </div>


                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">下次约访 </label>

                            <div class="layui-input-block">
                                <input type="text" name="arrive_time" id='arrive_time' class="layui-input"
                                       placeholder="(注：上访后再次约访时间)" autocomplete="off" readonly="readonly" >
                            </div>
                        </div>
                    </div>


                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">其它备注 </label>

                            <div class="layui-input-block">
                                <textarea type="text" name="other_remark" id="other_remark"  placeholder="请输入"
                                          class="layui-textarea"></textarea>
                            </div>
                        </div>
                    </div>

                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label"><a style="color: red;">*
                            </a>联系结果 </label>
                            <div class="layui-input-block">
                                <textarea type="text" name="result" id="result" lay-verify="required"
                                          placeholder="请输入内容" class="layui-textarea"></textarea>
                            </div>
                        </div>
                    </div>
                    <div
                            class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">联系截图 </label>
                            <div class="layui-input-block">
                                <div style="margin: 5px; float: left;">
                                    <div
                                            style="background-color: #fff; height: 200px; width: 200px; border-radius: 3px; border: 1px solid #b9b9b9; display: flex;"
                                            align="center">
                                        <img class="layui-upload-img" id="screen_image"
                                             src="/res/image/add.png"
                                             style="width: auto; height: auto; max-width: 100%; max-height: 100%; margin: auto;">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item my-form-item" id="submit-button">
                        <div class="layui-btn-group ">
                            <button class="layui-btn my-button" lay-submit
                                    lay-filter="add-staff" id="add-staff">提交
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


    layui.use(['element', 'jquery', 'form', 'laydate','upload'], function () {
        var element = layui.element;
        var $ = jQuery = layui.jquery;
        var form = layui.form;
        var laydate = layui.laydate;
        var upload = layui.upload;
        var image='';
        var op='';
        var op1='';
        var staff_name = '${staff.staff_name}';
        var assign_staff_id = '${staff.staff_id}';
        <%--var judge_up = '${follow.judge_up}';--%>
        var sale_stage_up = '${follow.sale_stage_up}';
        var sale_id = '${follow.sale_id}';
        var follow_up_id='';

        // if(judge_up==='接受'){
        //     op+="<option value='"+'接受'+"'>"+'接受'+"</option>";
        //     $("#judge_up").html(op);
        // } else if(judge_up != '接受'){
        //     $("#sale_stage_up").removeAttr("lay-verify");
        // }
        //
        // if(judge_up==='接受' && sale_stage_up==='Y'){
        //     op1+="<option value='"+'Y'+"'>"+'Y'+"</option>";
        //     $("#sale_stage_up").html(op1);
        // }


        $("#sale_stage_up").val(sale_stage_up);

        //监听是否选中其它因素
        form.on('select(false_reason)',function () {
            var false_reason=$("#false_reason").val();
            if (false_reason=='F.其它因素'){
                $("#other_reason_all").slideDown();
            }else{//如果没有使用其它因素 则赋为”“
                $("#other_reason_all").slideUp();

            }
        });


        laydate.render({
            elem : '#next_time_up',
            type : 'datetime',
            theme : '#0078d7'
        });

        laydate.render({
            elem : '#arrive_time',
            type : 'datetime',
            theme : '#0078d7'
        });

        form.render("select");

        //上传截图
        var screenImage=upload.render({
            elem: '#screen_image'
            ,url: 'upload?name=screen_image'
            ,auto: false
            ,before: function(obj){
                this.data={"follow_up_id":follow_up_id}
            }
            ,choose: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    image="yes";
                    $('#screen_image').attr('src', result); //图片链接（base64）
                });
            },done: function(res){
                //如果上传失败
                if(res.code != 100){
                    return layer.msg('上传失败');
                }
                //上传成功
            }
            ,error: function(){
            }
        });

        // 监听提交
        form.on('submit(add-staff)', function (data) {

            $.ajax({
                type: "post",
                url: "addComeToShopFollow?" + $("#add-form").serialize()
                    + "&sale_id=" + sale_id + "&staff_name=" + staff_name + "&assign_staff_id=" + assign_staff_id,
                async: false,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == 100) {
                        follow_up_id = jsonData.id;

                        if (image!='') {
                            screenImage.upload();
                        }

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