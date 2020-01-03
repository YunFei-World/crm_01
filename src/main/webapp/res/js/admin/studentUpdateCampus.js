layui.use(['table', 'jquery', 'form', 'element', 'laydate','formSelects'], function () {
    var table = layui.table;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var element = layui.element;
    var laydate = layui.laydate;
    var formSelects = layui.formSelects;

    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();


    var opID = '';
    var student_id='';
    var real_balance='';
    var transfer_campus_id='';

    var keys = [];
    var ids = [];


    laydate.render({
        elem: '#sign_date',
        type: 'date',
        trigger: 'click'
    });

    form.render("select");

    var postTable = table.render({
        elem: '#post',
        url: 'saleOrder/findAllStudentUpdateCampus?transfer_campus_id=' + campus_id +'&staff_id='+staff_id,
        toolbar: '#toolBar',
        title: '转校',
        cols: [[{
                title: '编号',
                type: 'numbers',
                fixed: 'left',
                width: 70
            }, {
                field: 'student_name',
                title: '学生姓名',
                minWidth: 100,
                sort: true
            }, {
                field: 'campus_name',
                title: '转出校区',
                minWidth: 100,
                sort: true
            }, {
                field: 'transfer_campus_name',
                title: '转入校区',
                minWidth: 100,
                sort: true
            },  {
                field: 'update_loadtime_str',
                title: '换校时间',
                minWidth: 100
            }, {
                title: '操作',
                toolbar: '#opreationBar',
                minWidth: 100,
                fixed: 'right'
            }]],
        page: true
    });

    table.on('sort(post)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
        table.reload('post', {
            initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
            , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                field: obj.field // 排序字段
                , order: obj.type
                // 排序方式
            }
        });
    });






// 监听行工具事件
    table.on('tool(post)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            opID = data.id;// 操作数据 学生-课程id
            student_id=data.student_id;//学生主键
            transfer_campus_id=data.transfer_campus_id;
            $('#student_name').val(data.student_name);
            $('#campus_name').val(data.campus_name);
            $('#transfer_campus_name').val(data.transfer_campus_name);

            //结算该学生原校区所有课程剩余余额
            $.ajax({
                url: "saleOrder/getStudentAllRealBalance?student_id="+student_id,
                type: "get",
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    real_balance=jsonData.allbalance;
                    $('#real_balance').val(real_balance);
                }
            });


            $("#table").slideUp('', function () {
                $("#sign-content").slideDown();
            });
            form.render(); // 更新全部000
        }
    });



    $.ajax({
        url: "sign/findAllCourseNames?campus_id="+campus_id,
        type: 'get',
        dataType: 'json',
        async: false,
        success: function (data) {
            for (var i = 0; i < data.data.length; i++) {
                var a='';
                var temp='';
                if (data.data[i].chargetype==0) {
                    a=data.data[i].COURSE_NAME +' '+ data.data[i].lessonNum + "课次" + ' '+ data.data[i].totalPrice + "(按期)";
                    temp = {"name": a, "value": data.data[i].id };
                }else if (data.data[i].chargetype==1) {
                    a=data.data[i].COURSE_NAME +' '+ "每课次" + ' '+ data.data[i].UNIT_PRICE + "(按次)";
                    temp = {"name": a, "value": data.data[i].id };
                }
                keys.push(temp);
            }

        }
    });


    //local模式 本地数据
    formSelects.data('all_course', 'local', {
        arr: keys
    });

    formSelects.on('all_course', function (id, vals, val, isAdd, isDisabled) {
        for(var i = 0; i < vals.length; i++){
            ids[i] = vals[i].value;
        }
    }, true);



    // 监听提交
    form.on('submit(addNewCourseSign)', function (data) {

        var url = "saleOrder/finishStudentUpdateCampus?"+$("#new-sign-form").serialize()+"&student_id="+student_id+"&transfer_campus_id="+transfer_campus_id+
            "&student_course_id="+ opID;
        $.ajax({
            type: "post",
            url: url,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                if (jsonData.code == 100) {
                    layer.confirm('换校购课成功', {
                        icon: 1,
                        title: '提示'
                    }, function (index) {
                        layer.close(index);
                        window.location.href = window.location.href;
                    });
                }else if (jsonData.code == 101){
                    layer.msg('学生账户余额不足', {
                        time: 2000
                    }, function () {
                        return false;
                    });

                }else{
                    layer.msg("未知错误");
                }
            },
            error: function (jqObj) {
            }
        });
        return false;
    });



    //返回
    $('#back').on('click', function () {
        $("#sign-content").slideUp('', function () {
            $("#table").slideDown();
        });
    });




    // 搜索工具 start
    var filter = new Set();// 需要查询的字段
    filter.add("student_name");
    filter.add("campus_name");
    filter.add("transfer_campus_name");
    filter.add("update_loadtime");
    // 字段拦截按钮事件
    $('#filter').on('click', function () {
        $("#filter-ul-div").fadeToggle();
    });
    // 字段拦截收起按钮事件
    $('#close-filter').on('click', function () {
        $("#filter-ul-div").fadeToggle();
    });
    // 搜索按钮事件
    $('#search-i').on('click', function () {
        searchAdd($("#serach-address-key").val());
    });
    // 输入框回车事件
    $('#serach-address-key').bind('keypress', function (event) {
        if (event.keyCode == "13") {
            searchAdd($("#serach-address-key").val());
        }
    });
    // 查询字段修改事件
    form.on('checkbox(filter)', function (data) {
        if (data.elem.checked) {
            filter.add(data.value);
        } else if (filter.size > 1) {
            filter.delete(data.value);
        } else {
            layer.msg("至少选择一个");
            data.elem.checked = true;
            form.render('checkbox');
        }
    });

    // 开始查询
    function searchAdd(key) {
        $("#filter-ul-div").fadeOut();
        table.reload('post', {
            url: 'saleOrder/findAllStudentUpdateCampus?key=' + key + '&filter=' + Array.from(filter) + '&transfer_campus_id=' + campus_id +'&staff_id='+staff_id
        });
    }

    // 搜索工具 end


    // 重载表格 防止拉伸
    window.reloadTable = function () {
        postTable.reload();
    };
    form.render();
});
