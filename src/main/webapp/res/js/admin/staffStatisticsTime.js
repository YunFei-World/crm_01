layui.use(['table', 'jquery', 'form', 'element', 'laydate'], function () {
    var table = layui.table;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var element = layui.element;
    var laydate = layui.laydate;

    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();

    var month_start = '';
    var month_end = '';

    var sale_stage='';
    // 选择月份
    laydate.render({
        elem: '#time-start',
        type: 'date'
    });
    laydate.render({
        elem: '#time-end',
        type: 'date'
    });

    var postTable = table.render({
        elem: '#post',
        url: 'staffStatistics/findAllStaffTimeStatisticsList?&campus_id='+ campus_id,
        toolbar: '#toolBar',
        title: '阶段统计',
        totalRow: true, //开启合计行
        cols: [[{
            title: '编号',
            type: 'numbers',
            fixed: 'left',
            width: 70
        }, {
            field: 'campus_name',
            title: '所属校区',
            minWidth: 100,
            fixed: 'left',
            sort: true,
            hide: true
        },{
            field: 'staff_name',
            title: '姓名',
            minWidth: 100,
            fixed: 'left',
            sort: true,
            totalRowText: '合计：'
        },{
            field: 'staff_post',
            title: '岗位',
            minWidth: 100,
            fixed: 'left',
            sort: true
        },{
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
        },{
            field: 'effective',
            title: '有效量',
            minWidth: 100,
            sort: true,
            totalRow: true
        },{
            field: 'follow_up_effective',
            title: '回访有效量',
            minWidth: 100,
            sort: true,
            totalRow: true
        },{
            field: 'direct_shop',
            title: '直接上门',
            minWidth: 100,
            sort: true,
            totalRow: true
        },{
            field: 'brought_shop',
            title: '带到访人数',
            minWidth: 100,
            sort: true,
            totalRow: true
        },{
            field: 'invitation_shop',
            title: '邀约人数',
            minWidth: 100,
            sort: true,
            totalRow: true
        },{
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
            url: 'staffStatistics/updateStatisticsByTime?&campus_id='+ campus_id+'&time_start='+month_start+'&time_end='+month_end+'&staff_id='+staff_id,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                if (jsonData.code == 100) {
                    layer.msg('已完成', {
                        icon: 1,
                        time: 1500
                    }, function () {
                        table.reload('post', {
                            url: 'staffStatistics/findAllStaffTimeStatisticsList?&campus_id='+ campus_id
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

    filter.add("staff_name");
    filter.add("staff_post");
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
            url: 'staffStatistics/findAllStaffTimeStatisticsList?key=' + key + '&filter=' + Array.from(filter) + "&campus_id=" + campus_id
        });
    }

    // 搜索工具 end



    // 重载表格 防止拉伸
    window.reloadTable = function () {
        postTable.reload();
    };
    form.render();
});
