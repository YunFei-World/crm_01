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
        url: 'saleReasonStatistics/findAllSaleReasonStatisticsList?&campus_id='+ campus_id+"&sale_stage="+sale_stage,
        toolbar: '#toolBar',
        title: '阶段统计',
        limit:12,
        limits:[12,24,36,48,60],
        cols: [[{
            title: '编号',
            type: 'numbers',
            fixed: 'left',
            width: 70
        }, {
            field: 'campus_name',
            title: '所属校区',
            minWidth: 100,
            sort: true,
        },{
            field: 'sale_stage',
            title: '销售阶段',
            minWidth: 100,
            sort: true
        }, {
            field: 'false_reason',
            title: '未订原因',
            minWidth: 100,
            sort: true
        }, {
            field: 'reason_count',
            title: '此原因数',
            minWidth: 100,
            sort: true
        }, {
            field: 'reason_sum_count',
            title: '此校此阶段总量',
            minWidth: 100,
            sort: true
        }, {
            field: 'proportion',
            title: '占比',
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
            url: "saleReasonStatistics/updateStatisticsByTime?time_start=" + month_start +"&time_end="+month_end+"&campus_id="+campus_id+"&sale_stage="+sale_stage,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                if (jsonData.code == 100) {
                    layer.msg('已完成', {
                        icon: 1,
                        time: 1500
                    }, function () {
                        table.reload('post', {
                            url: 'saleReasonStatistics/findAllSaleReasonStatisticsList?&campus_id='+ campus_id+"&sale_stage="+sale_stage
                        });

                    });
                }
            },
            error: function (jqObj) {

            }
        });
        return false;
    });



    //选择阶段刷新
    form.on('select(sale_stage)', function () {
        sale_stage = $("#sale_stage").val();

        table.reload('post', {
            url: "saleReasonStatistics/findAllSaleReasonStatisticsList?&campus_id="+ campus_id+"&sale_stage="+sale_stage
        });

    });








    // 重载表格 防止拉伸
    window.reloadTable = function () {
        postTable.reload();
    };
    form.render();
});
