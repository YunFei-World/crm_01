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

    //获取所有渠道
    var channel_id='';


    var postTable = table.render({
        elem: '#marketingStatisticTable',
        url: 'marketing/findAllMarketingStatisticsList?channel_id='+channel_id+'&staff_id='+staff_id+'&campus_id='+campus_id,
        title: '渠道时间段统计',
        page: true,
        toolbar: '#toolBar',
        totalRow: true, //开启合计行
        cols: [[{
            title: '编号',
            type: 'numbers',
            fixed: 'left',
            width: 70
        },{
            field: 'channel_type',
            title: '活动所属渠道',
            sort: true,
            minWidth: 100,
            totalRowText: '合计：'
        },{
            field: 'marketing_id',
            title: '活动id',
            minWidth: 100,
            sort: true,
            hide: true
        },{
            field: 'marketing_name',
            title: '活动名称',
            minWidth: 100,
            sort: true
        },{
            field: 'marketing_date_str',
            title: '活动时间',
            minWidth: 100
        },{
            field: 'order_num',
            title: '收集单总数',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'order_effective',
            title: '接通-有意到店',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'order_wait',
            title: '接通-待定',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'order_uneffective',
            title: '接通-拒绝',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'order_uncontect',
            title: '未接通',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'order_uncall',
            title: '未打电话数量',
            minWidth: 100,
            sort: true,
            totalRow: true
        }, {
            field: 'proportion',
            title: '有意到店占比',
            sort: true,
            minWidth: 100
        }, {
            field: 'proportion_two',
            title: '待定占比',
            sort: true,
            minWidth: 100
        }, {
            field: 'proportion_three',
            title: '拒绝占比',
            sort: true,
            minWidth: 100
        }, {
            field: 'proportion_four',
            title: '未接通占比',
            sort: true,
            minWidth: 100
        }, {
            field: 'proportion_five',
            title: '未打电话占比',
            sort: true,
            minWidth: 100
        }]]

    });

    // 排序事件
    table.on('sort(marketingStatisticTable)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
        table.reload('marketingStatisticTable', {
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



    $.ajax({
        url: "channel/findAllChannelNameByStaff?campus_id=" + campus_id,
        type: "get",
        success: function (data) {
            var jsonData = JSON.parse(data);
            var op = "<option value='' selected>全部渠道类型</option>";
            for (var x in jsonData.data) {
                op += "<option value='" + jsonData.data[x].channel_id + "'>" + jsonData.data[x].channel_type + "</option>";
            }
            $("#channel_id").html(op);
            form.render("select");

        }
    });

    //选择渠道
    form.on('select(channel_id)', function () {
        channel_id = $("#channel_id").val();

        table.reload('marketingStatisticTable', {
            url: 'marketing/findAllMarketingStatisticsList?channel_id='+channel_id+'&staff_id='+staff_id+'&campus_id='+campus_id
        });

    });


    /*//选择校区刷新
    form.on('select(campusId)', function () {
        campus_id = $("#campusId").val();
        channel_id='';
        $.ajax({
            type: "get",
            url: "channel/findAllChannelNameByStaff?campus_id=" + campus_id,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                var op = "<option value='' selected>全部渠道类型</option>";
                for (var x in jsonData.data) {
                    op += "<option value='" + jsonData.data[x].channel_id + "'>" + jsonData.data[x].channel_type + "</option>";
                }
                $("#channel_id").html(op);
                form.render("select");

                table.reload('marketingStatisticTable', {
                    url: 'marketing/findAllMarketingStatisticsList?channel_id='+channel_id+'&staff_id='+staff_id+'&campus_id='+campus_id
                });

            },
            error: function (jqObj) {

            }
        });


    });*/



    // 搜索工具 start
    var filter = new Set();// 需要查询的字段
    filter.add("channel_type");

    filter.add("channel_id");
    filter.add("marketing_name");
    filter.add("marketing_date");
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
        table.reload('marketingStatisticTable', {
            url: 'marketing/findAllMarketingStatisticsList?key=' + key + '&filter=' + Array.from(filter) + '&channel_id='+channel_id+'&staff_id='+staff_id+'&campus_id='+campus_id
        });
    }

    // 搜索工具 end





    // 重载表格 防止拉伸
    window.reloadTable = function () {
        postTable.reload();
    };
    form.render();
});
