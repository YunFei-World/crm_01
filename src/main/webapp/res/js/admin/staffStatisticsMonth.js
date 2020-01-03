layui.use(['table', 'jquery', 'form', 'element', 'laydate'], function () {
    var table = layui.table;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var element = layui.element;

    var laydate = layui.laydate;
    var month = '';
    var key = '';

    var staffId = $("#staffId").val();
    var campus_id = $("#campusId").val();


    // 选择日期
    laydate.render({
        elem: '#choice-month',
        type: 'month'
    });

    var postTable = table.render({
        elem: '#post',
        url: 'staffStatistics/getStatisticsStaffMonth?staff_id=' + staffId + "&campus_id=" + campus_id,
        toolbar: '#toolBar',
        title: '月统计',
        totalRow: true,
        cols: [[{
            align:'center',
            title:'',
            colspan: 5
        },{
            align:'center',
            title:'',
            colspan: 3
        },{
            align:'center',
            title:'第一周',
            colspan: 2
        },{
            align:'center',
            title:'第二周',
            colspan: 2
        },{
            align:'center',
            title:'第三周',
            colspan: 2
        },{
            align:'center',
            title:'第四周',
            colspan: 2
        },{
            align:'center',
            title:'第五周',
            colspan: 2
        },{
            align:'center',
            title:'',
            colspan: 13
        }],[{
            title: '编号',
            type: 'numbers',
            fixed: 'left',
            width: 70
        }, {
            field: 'campus_name',
            title: '所属校区',
            minWidth: 100,
            hide: true,
            fixed: 'left',
            sort: true
        },{
            field: 'month',
            title: '统计月份',
            minWidth: 100,
            fixed: 'left',
            sort: true,
            totalRowText: '合计：'
        },{
            field: 'staff_name',
            title: '员工姓名',
            minWidth: 100,
            fixed: 'left',
            sort: true
        },{
            field: 'staff_post',
            title: '岗位',
            minWidth: 100,
            fixed: 'left',
            sort: true
        },{
            field: 'month_task',
            title: '本月任务',
            minWidth: 100,
            sort: true,
            totalRow: true
        },{
            field: 'month_actual',
            title: '实际完成',
            minWidth: 100,
            sort: true,
            totalRow: true
        },{
            field: 'month_proportion',
            title: '完成率',
            minWidth: 100,
            sort: true
        }, {
            field: 'week_one',
            title: '任务',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'week_one_actual',
            title: '实际完成',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'week_two',
            title: '任务',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'week_two_actual',
            title: '实际完成',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'week_three',
            title: '任务',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'week_three_actual',
            title: '实际完成',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'week_four',
            title: '任务',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'week_four_actual',
            title: '实际完成',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'week_five',
            title: '任务',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'week_five_actual',
            title: '实际完成',
            minWidth: 100,
            sort: true,
            totalRow: true
        },  {
            field: 'sum_num',
            title: '资源量',
            minWidth: 100,
            sort: true,
            totalRow: true
        },{
            field: 'tel_num',
            title: '呼出电话',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'effective',
            title: '有效量',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'follow_up_effective',
            title: '回访有效量',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'direct_shop',
            title: '直接上门',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'brought_shop',
            title: '带到访人数',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'invitation_shop',
            title: '邀约人数',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'actual_shop',
            title: '实际到访人数',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'sign_up',
            title: '报名人数',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'tel_effective_proportion',
            title: '电话有效率',
            minWidth: 100,
            sort: true
        }, {
            field: 'to_shop_proportion',
            title: '到访率',
            minWidth: 100,
            sort: true
        }, {
            field: 'to_shop_to_sign_proportion',
            title: '到访报名转换率',
            sort: true,
            minWidth: 100
        }, {
            field: 'average_sale',
            title: '平均单价',
            sort: true,
            minWidth: 100
        }]],
        page: true
    });

    // 排序事件
    table.on('sort(post)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
        table.reload('post', {
            initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
            ,
            where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                field: obj.field // 排序字段
                ,
                order: obj.type
                // 排序方式
            }
        });
    });

    // 结算
    $('#statistics').on("click", function () {

        month = $("#choice-month").val();
        if (month == '') {
            layer.msg("请选择需要统计的月份")
            return false;
        }
        $.ajax({
            type: "get",
            url: "staffStatistics/statisticsStaffMonth?month=" + month + "&staff_id=" + staffId + "&campus_id=" + campus_id,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                if (jsonData.code == 100) {
                    layer.msg('已完成', {
                        icon: 1,
                        time: 1000
                    }, function () {
                        table.reload('post', {
                            url: 'staffStatistics/getStatisticsStaffMonth?key=' + month + '&filter=month' + "&staff_id=" + staffId + "&campus_id=" + campus_id
                        });
                    });
                }
                if (jsonData.code == 101) {
                    layer.msg('本月没有该周次', {
                        time: 2000
                    }, function () {
                        return false;
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
    filter.add("staff_name");
    filter.add("month");
    filter.add("staff_post");
    form.render(); // 更新全部000
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
        key = $("#serach-address-key").val();
        searchAdd();
    });
    // 输入框回车事件
    $('#serach-address-key').bind('keypress', function (event) {
        key = $("#serach-address-key").val();
        if (event.keyCode == "13") {
            searchAdd();
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
    function searchAdd() {
        $("#filter-ul-div").fadeOut();
        table.reload('post', {
            url: 'staffStatistics/getStatisticsStaffMonth?key=' + key + '&filter=' + Array.from(filter) + "&staff_id=" + staffId + "&campus_id=" + campus_id,
        });
    }

    // 搜索工具 end

    // 重载表格 防止拉伸
    window.reloadTable = function () {
        postTable.reload();
    };
    form.render();
});
