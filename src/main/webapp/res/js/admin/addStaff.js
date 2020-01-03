layui.use(['table', 'jquery', 'form'], function () {
    var table = layui.table;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();
    form.render("select");


    var staff_depart='';




    //更改部门
    var opp='';
    form.on('select(staff_depart)', function () {
        staff_depart = $("#staff_depart").val();
        if (staff_depart=='管理员'){
            opp= "<option value='管理员'>管理员</option>";
        }else if(staff_depart=='销售部'||staff_depart=='营销部') {
            opp= "<option value='部门职员'>部门职员</option>";
        }
        $("#staff_post").html(opp);
        form.render("select");


    });

    $.ajax({
        url: "staff/findAllCampusById?staff_id=" + staff_id,
        type: "get",
        success: function (data) {
            var jsonData = JSON.parse(data);
            var op = "<option value=''>请选择</option>";
            for (var x in jsonData.data) {
                op += "<option value='" + jsonData.data[x].campus_id + "'>" + jsonData.data[x].campus_name + "</option>";
            }
            $("#campus_id").html(op);
            form.render("select");
        }
    });






   /* //选择校区刷新
    form.on('select(campusId)', function () {
        campusId = $("#campusId").val();

        $.ajax({
            url: "staff/findAllCampusById?staff_id=" + staff_id,
            type: "get",
            success: function (data) {
                var jsonData = JSON.parse(data);
                var op = "<option value=''>请选择</option>";
                for (var x in jsonData.data) {
                    op += "<option value='" + jsonData.data[x].campus_id + "'>" + jsonData.data[x].campus_name + "</option>";
                }
                $("#campus_id").html(op);
                form.render("select");
            }
        });

    });*/





    form.on('submit(add-staff)', function (data) {
        addStaff();
        return false;

        //添加方法
        function addStaff() {
            $.ajax({
                type: "post",
                url: "staff/addStaff?" + $("#add-form").serialize(),
                async: true,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == 100) {
                        if (jsonData.id != '') {
                            layer.confirm('已完成', {
                                icon: 1,
                                title: '提示'
                            }, function (index) {
                                layer.close(index);
                                window.location.href = window.location.href;
                            });
                        } else {
                            layer.confirm('添加出错！', {
                                icon: 2,
                                title: '提示'
                            }, function (index) {
                                layer.close(index);
                                window.location.href = window.location.href;
                            });
                        }
                    } else if (jsonData.code == 101) {
                        layer.msg('身份已过期，请重新登录', {
                            icon: 2,
                            time: 2500
                        }, function () {
                            window.location.href = "gotoLogin";
                        });
                    } else if (jsonData.code == 102) {
                        layer.msg("访问受限,权限不足");
                    } else if (jsonData.code == 103) {
                        layer.msg("工号已被占用");
                    } else {
                        layer.msg("未知错误");
                    }
                    layer.close(load);
                },
                error: function (jqObj) {
                    layer.close(load);
                }
            });
        }
    });
});