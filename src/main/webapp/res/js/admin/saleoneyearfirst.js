layui.use(['table', 'jquery', 'form', 'element', 'laydate'], function () {
    var table = layui.table;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var element = layui.element;
    var laydate = layui.laydate;


    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();


    var year = '';


    var postTable = table.render({
        elem: '#post',
        url: 'saleoneyear/findAllSaleOneYearFirstList?campus_id=' + campus_id +'&staff_id='+staff_id,
        toolbar: '#toolBar',
        limit:12,
        limits:[12,24,36],
        title: '全年销售统计',
        cols: [[{
            align:'center',
            title:'销售金额',
            colspan: 6
        },{
            align:'center',
            title:'咨询-报名',
            colspan: 5
        },{
            align:'center',
            title:'退费',
            colspan: 3
        }],

            [{
                title: '编号',
                type: 'numbers',
                fixed: 'left',
                width: 70
            }, {
                field: 'month_str',
                title: '月份',
                minWidth: 100,
                fixed: 'left',
                sort: true
            }, {
                field: 'campus_name',
                title: '所属校区',
                minWidth: 100,
                fixed: 'left',
                hide: true,
                sort: true
            },{
                field: 'target_sale_money',
                title: '计划目标',
                minWidth: 100,
                fixed: 'left',
                sort: true
            }, {
                field: 'actual_sale_money',
                title: '实际销售',
                minWidth: 100,
                fixed: 'left',
                sort: true
            }, {
                field: 'proportion_sale_money',
                title: '完成比例',
                minWidth: 100,
                fixed: 'left',
                sort: true
            }, {
                field: 'target_initorder_num',
                title: '计划咨询量',
                minWidth: 100,
                sort: true
            }, {
                field: 'actual_initorder_num',
                title: '实际咨询量',
                minWidth: 100,
                sort: true
            }, {
                field: 'sign_up_num',
                title: '报名人数',
                minWidth: 100,
                sort: true
            }, {
                field: 'proportion_sign_up',
                title: '总成功率',
                minWidth: 100,
                sort: true
            }, {
                field: 'average_sale_money',
                title: '平均单价',
                minWidth: 100,
                sort: true
            }, {
                field: 'refund_num',
                title: '退费人数',
                minWidth: 100,
                sort: true
            }, {
                field: 'refund_money',
                title: '退费金额',
                minWidth: 100,
                sort: true
            }, {
                field: 'proportion_refund',
                title: '退费率',
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


    // 选择日期
    laydate.render({
        elem: '#choice_year',
        type: 'year',
        done:function (value,date) {
            year=date.year;
            $.ajax({
                type: "get",
                url: 'saleoneyear/updateSaleOneYearFirst?&campus_id=' + campus_id + '&year='+year ,
                async: true,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == 100) {
                        layer.msg(year+'年全年销售数据统计完成', {
                            icon: 1,
                            time: 1500
                        }, function () {
                            table.reload('post', {
                                url: 'saleoneyear/findAllSaleOneYearFirstList?&campus_id=' + campus_id +'&staff_id='+staff_id
                            });

                        });
                    }
                },
                error: function (jqObj) {
                }
            });
        }
    });






    // 搜索工具 start
    var filter = new Set();// 需要查询的字段
    filter.add("month");
    filter.add("target_sale_money");
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
            url: 'saleoneyear/findAllSaleOneYearFirstList?key=' + key + '&filter=' + Array.from(filter) + '&campus_id=' + campus_id +'&staff_id='+staff_id
        });
    }

    // 搜索工具 end



    // 重载表格 防止拉伸
    window.reloadTable = function () {
        postTable.reload();
    };
    form.render();
});
