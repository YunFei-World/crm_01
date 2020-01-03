layui.use(['table', 'jquery', 'form', 'element', 'laydate'], function () {
    var table = layui.table;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var element = layui.element;
    var laydate = layui.laydate;

    var opID = '';
    var student_id='';
    var course_id='';
    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();




    var postTable = table.render({
        elem: '#post',
        url: 'saleOrder/findAllStudentRefund?&campus_id=' + campus_id +'&staff_id='+staff_id,
        toolbar: '#toolBar',
        title: '退课and转校',
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
                field: 'course_name',
                title: '处理课程',
                minWidth: 100,
                sort: true
            },{
                field: 'remain_course_num',
                title: '课程剩余次数',
                minWidth: 100,
                sort: true
            }, {
                field: 'deal_unit_price',
                title: '课程成交单价',
                minWidth: 100,
                sort: true
            }, {
                field: 'real_balance',
                title: '课程余额',
                minWidth: 100,
                sort: true
            }, {
                field: 'update_loadtime_str',
                title: '退课时间',
                minWidth: 100
        }, {
                title: '操作',
                toolbar: '#getMoreMessage',
                minWidth: 100,
                fixed:  'right'
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
            course_id=data.course_id;
            student_id=data.student_id;//学生主键
            $('#student_name').val(data.student_name);
            $('#campus_name').val(data.campus_name);
            $('#course_name').val(data.course_name);
            $('#actual_price').val(data.actual_price);
            $('#deal_price').val(data.deal_price);
            $('#order_course_num').val(data.order_course_num);
            $('#remain_course_num').val(data.remain_course_num);
            $('#deal_unit_price').val(data.deal_unit_price);
            $('#real_balance').val(data.real_balance);

            $("#table").slideUp('', function () {
                $("#orderinit-content").slideDown();
            });
            form.render(); // 更新全部000
        }
    });


    // 监听提交
    form.on('submit(finishRefund)', function (data) {
        var url = "saleOrder/finishStudentRefund?id="
            + opID+"&student_id="+student_id+"&course_id="+course_id;
        $.ajax({
            type: "post",
            url: url,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                if (jsonData.code == 100) {
                    layer.confirm('完成退款', {
                        icon: 1,
                        title: '提示'
                    }, function (index) {
                        layer.close(index);
                        window.location.href = window.location.href;
                    });
                } else {
                    layer.msg("未知错误");
                }
            },
            error: function (jqObj) {
            }
        });
        return false;
    });





    $('#back').on('click', function () {
        $("#orderinit-content").slideUp('', function () {
            $("#table").slideDown();
        });
    });



    // 搜索工具 start
    var filter = new Set();// 需要查询的字段
    filter.add("student_name");
    filter.add("course_name");
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
            url: 'saleOrder/findAllStudentRefund?key=' + key + '&filter=' + Array.from(filter) + '&campus_id=' + campus_id +'&staff_id='+staff_id
        });
    }

    // 搜索工具 end



    // 重载表格 防止拉伸
    window.reloadTable = function () {
        postTable.reload();
    };
    form.render();
});
