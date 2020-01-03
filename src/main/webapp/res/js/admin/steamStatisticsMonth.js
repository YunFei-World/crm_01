layui.use(['table', 'jquery', 'form', 'element', 'laydate'], function () {
    var table = layui.table;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var element = layui.element;
    var laydate = layui.laydate;


    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();

    var subject_id='';
    var month_start = '';
    var month_end = '';


    // 选择日期
    laydate.render({
        elem: '#time-start',
        type: 'month'
    });
    laydate.render({
        elem: '#time-end',
        type: 'month'
    });

    var postTable = table.render({
        elem: '#post',
        url: 'subjectCourse/findAllSubjectStatisticsList?&campus_id=' + campus_id + '&subject_id='+ subject_id+'&staff_id='+staff_id,
        toolbar: '#toolBar',
        title: '课程统计',
        cols: [[{
            title: '编号',
            type: 'numbers',
            fixed: 'left',
            width: 70
        }, {
            field: 'campus_name',
            title: '所属校区',
            minWidth: 100,
            sort: true
        },{
            field: 'subject_name',
            title: '科目类别',
            minWidth: 100,
            sort: true
        }, {
            field: 'subject_task_money',
            title: '科目任务',
            minWidth: 100,
            sort: true
        }, {
            field: 'subject_sale_money',
            title: '科目销售额',
            minWidth: 100,
            sort: true
        }, {
            field: 'subject_signup_num',
            title: '科目报名人数',
            minWidth: 100,
            sort: true
        }, {
            field: 'subject_finish_proportion',
            title: '完成率',
            minWidth: 100,
            sort: true
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



    $.ajax({
        url: 'subjectCourse/findAllSubject',
        type: "get",
        success: function (data) {
            var jsonData = JSON.parse(data);
            var op = "<option value='' selected>全部课程类型</option>";
            for (var x in jsonData.data) {
                op += "<option value='" + jsonData.data[x].id + "'>" + jsonData.data[x].SUBJECT_NAME + "</option>";
            }
            $("#subject_id").html(op);
            form.render("select");

        }
    });

    //选择课程类别
    form.on('select(subject_id)', function () {
        subject_id = $("#subject_id").val();

        table.reload('post', {
            url: 'subjectCourse/findAllSubjectStatisticsList?&campus_id=' + campus_id + '&subject_id='+ subject_id+'&staff_id='+staff_id
        });

    });




    // 结算当前月份
    $('#statistics').on("click", function () {
        month_start = $("#time-start").val();
        month_end   = $("#time-end").val();


        if (month_start == '') {
            layer.msg("请选择需要统计的开始时间")
            return false;
        }
        if (month_end == '') {
            layer.msg("请选择需要统计的结束时间")
            return false;
        }
        $.ajax({
            type: "get",
            url: 'subjectCourse/updateSubjectStatisticsByTime?&campus_id=' + campus_id + '&time_start='+month_start+'&time_end='+month_end ,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                if (jsonData.code == 100) {
                    layer.msg('已完成', {
                        icon: 1,
                        time: 1500
                    }, function () {
                        table.reload('post', {
                            url: 'subjectCourse/findAllSubjectStatisticsList?&campus_id=' + campus_id + '&subject_id='+ subject_id+'&staff_id='+staff_id
                        });

                    });
                }
            },
            error: function (jqObj) {

            }
        });
        return false;
    });


// 搜索工具 start
    var filter = new Set();// 需要查询的字段

    filter.add("subject_name");
    filter.add("subject_task_money");
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
            url: 'subjectCourse/findAllSubjectStatisticsList?key=' + key + '&filter=' + Array.from(filter) + '&campus_id=' + campus_id + '&subject_id='+ subject_id+'&staff_id='+staff_id
        });
    }

    // 搜索工具 end


    // 重载表格 防止拉伸
    window.reloadTable = function () {
        postTable.reload();
    };
    form.render();
});
