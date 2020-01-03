layui.use(['table', 'jquery', 'form', 'element', 'laydate'], function () {
    var table = layui.table;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var element = layui.element;
    var laydate = layui.laydate;
    var month_start = '';
    var month_end = '';
    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();



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
        url: 'chanStatistics/findAllChanStatisticsList?campus_id='+campus_id+'&staff_id='+staff_id,
        toolbar: '#toolBar1',
        title: '渠道时间段统计',
        page: true,
        totalRow: true, //开启合计行
        cols: [[{
            title: '编号',
            type: 'numbers',
            fixed: 'left',
            width: 70
        }, {
            field: 'channel_id',
            title: '渠道ID',
            minWidth: 100,
            sort: true,
            totalRowText: '合计：'
        }, {
            field: 'channel_type',
            title: '渠道类型',
            sort: true,
            minWidth: 100
        }, {
            field: 'count_sumnum',
            title: '收集单总数',
            sort: true,
            minWidth: 100,
            totalRow: true
        }, {
            field: 'count_effective',
            title: '接通-有意到店',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'count_wait',
            title: '接通-待定',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'count_uneffective',
            title: '接通-拒绝',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'count_uncontect',
            title: '未接通',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'count_uncall',
            title: '未打电话数量',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'one_proportion',
            title: '有意占比',
            sort: true,
            minWidth: 100
        }, {
            field: 'two_proportion',
            title: '待定占比',
            sort: true,
            minWidth: 100,
            hide: true
        }, {
            field: 'three_proportion',
            title: '拒绝占比',
            sort: true,
            minWidth: 100,
            hide: true
        }, {
            field: 'four_proportion',
            title: '未接通占比',
            sort: true,
            minWidth: 100,
            hide: true
        }, {
            field: 'five_proportion',
            title: '未打电话占比',
            sort: true,
            minWidth: 100,
            hide: true
        }]]

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
            url: "chanStatistics/updateStatisticsByTime?time_start=" + month_start +"&time_end="+month_end,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                if (jsonData.code == 100) {

                    table.reload('post', {
                        url: 'chanStatistics/findAllChanStatisticsList?campus_id='+campus_id+'&staff_id='+staff_id
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
    filter.add("channel_type");
    filter.add("channel_id");
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
            url: 'chanStatistics/findAllChanStatisticsList?key=' + key + '&filter=' + Array.from(filter) + '&campus_id='+campus_id+'&staff_id='+staff_id
        });
    }

    // 搜索工具 end





    // 重载表格 防止拉伸
    window.reloadTable = function () {
        postTable.reload();
    };
    form.render();
});
