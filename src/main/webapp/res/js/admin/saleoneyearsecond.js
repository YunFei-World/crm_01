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
        url: 'saleoneyear/findAllSaleOneYearSecondList?campus_id=' + campus_id +'&staff_id='+staff_id,
        toolbar: '#toolBar',
        title: '全年销售统计',
        cols: [[{
            align:'center',
            title:'',
            colspan: 3
        },{
            align:'center',
            title:'1月',
            colspan: 2
        },{
            align:'center',
            title:'2月',
            colspan: 2
        },{
            align:'center',
            title:'3月',
            colspan: 2
        },{
            align:'center',
            title:'4月',
            colspan: 2
        },{
            align:'center',
            title:'5月',
            colspan: 2
        },{
            align:'center',
            title:'6月',
            colspan: 2
        },{
            align:'center',
            title:'7月',
            colspan: 2
        },{
            align:'center',
            title:'8月',
            colspan: 2
        },{
            align:'center',
            title:'9月',
            colspan: 2
        },{
            align:'center',
            title:'10月',
            colspan: 2
        },{
            align:'center',
            title:'11月',
            colspan: 2
        },{
            align:'center',
            title:'12月',
            colspan: 2
        }], [{
                title: '编号',
                type: 'numbers',
                fixed: 'left',
                width: 70
            }, {
                field: 'subject_name',
                title: '课程科目',
                minWidth: 200,
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
                field: 'january_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'january_subject_sale_money',
                title: '销售金额',
                minWidth: 100,
                sort: true
            },{
                field: 'february_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'february_subject_sale_money',
                title: '销售金额',
                minWidth: 100,
                sort: true
            },{
                field: 'march_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'march_subject_sale_money',
                title: '销售金额',
                minWidth: 100,
                sort: true
            },{
                field: 'april_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'april_subject_sale_money',
                title: '销售金额',
                minWidth: 100,
                sort: true
            },{
                field: 'may_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'may_subject_sale_money',
                title: '销售金额',
                minWidth: 100,
                sort: true
            },{
                field: 'june_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'june_subject_sale_money',
                title: '销售金额',
                minWidth: 100,
                sort: true
            },{
                field: 'july_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'july_subject_sale_money',
                title: '销售金额',
                minWidth: 100,
                sort: true
            },{
                field: 'august_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'august_subject_sale_money',
                title: '销售金额',
                minWidth: 100,
                sort: true
            },{
                field: 'september_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'september_subject_sale_money',
                title: '销售金额',
                minWidth: 100,
                sort: true
            },{
                field: 'october_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'october_subject_sale_money',
                title: '销售金额',
                minWidth: 100,
                sort: true
            },{
                field: 'november_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'november_subject_sale_money',
                title: '销售金额',
                minWidth: 100,
                sort: true
            },{
                field: 'december_subject_sale_num',
                title: '销售量',
                minWidth: 100,
                sort: true
            }, {
                field: 'december_subject_sale_money',
                title: '销售金额',
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
                url: 'saleoneyear/updateSaleOneYearSecond?&campus_id=' + campus_id + '&year='+year ,
                async: true,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == 100) {
                        layer.msg(year+'年全年销售数据统计完成', {
                            icon: 1,
                            time: 1500
                        }, function () {
                            table.reload('post', {
                                url: 'saleoneyear/findAllSaleOneYearSecondList?&campus_id=' + campus_id +'&staff_id='+staff_id
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
    filter.add("subject_name");

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
            url: 'saleoneyear/findAllSaleOneYearSecondList?key=' + key + '&filter=' + Array.from(filter) + '&campus_id=' + campus_id +'&staff_id='+staff_id
        });
    }

    // 搜索工具 end



    // 重载表格 防止拉伸
    window.reloadTable = function () {
        postTable.reload();
    };
    form.render();
});
