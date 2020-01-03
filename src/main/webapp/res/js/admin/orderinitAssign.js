layui.use(['table', 'jquery', 'form', 'laydate'], function () {
    var table = layui.table;
    var laydate = layui.laydate;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var opID = '';// 需要操作的 数据id
    var key = '';
    var checkStaff = '';
    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();

    //录入日期
    laydate.render({
        elem: '#entry_date',
        theme: '#0078d7'
    });



    // 获取表格数据
    var initorderTable = table.render({
        elem: '#initorder',
        url: 'orderinit/findAllOrder?staff_id=' + staff_id + "&campus_id="+campus_id ,
        toolbar: '#toolBar',
        title: '毛单列表',
        cols: [[{
            type: 'checkbox',
            fixed: 'left'
        }, {
            title: '编号',
            type: 'numbers',
            width: 70
        },{
            field: 'campus_name',
            title: '所属校区',
            minWidth: 100,
            hide: true,
            sort: true
        }, {
            field: 'customer_name',
            title: '客户姓名',
            minWidth: 100,
            sort: true
        }, {
            field: 'customer_contact',
            title: '联系方式',
            hide: true,
            minWidth: 140,
            sort: true
        }, {
            field: 'order_staff_name',
            title: '录入人员',
            minWidth: 100,
            sort: true
        }, {
            field: 'channel_type',
            title: '所属渠道',
            minWidth: 100,
            sort: true
        }, {
            field: 'marketing_name',
            title: '活动名称',
            minWidth: 100,
            sort: true
        }, {
            field: 'collect_name',
            title: '收集人姓名',
            minWidth: 100,
            hide: true,
            sort: true
        }, {
            field: 'collect_tel',
            title: '收集人电话',
            hide: true,
            minWidth: 140,
            sort: true
        }, {
            field: 'entry_real_str',
            title: '录入时间',
            minWidth: 100,
            sort: true
        }, {
            field: 'state',
            title: '是否分配',
            minWidth: 100,
            templet: '#stateTpl',
            sort: true
        }, {
            title: '操作',
            toolbar: '#opreationBar',
            width: 120,
            fixed: 'right'
        }]],
        page: true

    });





    // 获取销售人员
    $.ajax({
        url: "staff/findAllSaleStaff?staff_id=" + staff_id + "&campus_id=" + campus_id,
        type: "get",
        success: function (data) {
            var jsonData = JSON.parse(data);
            var op = "<option value=''>全部销售人员</option>";
            for (var x in jsonData.data) {
                op += "<option value='" + jsonData.data[x].staff_id + "'>" + jsonData.data[x].staff_id + '-' + jsonData.data[x].staff_name + '-' + jsonData.data[x].campus_name + "</option>";
            }
            $("#staff_id").html(op);
            form.render("select");
        }
    });

    // 获取所有渠道
    $.ajax({
        url: "channel/findAllChannelName?staff_id=" + staff_id + "&campus_id=" + campus_id,
        type: "get",
        success: function (data) {
            var jsonData = JSON.parse(data);
            var op = "<option value=''>全部渠道类型</option>";
            for (var x in jsonData.data) {
                op += "<option value='" + jsonData.data[x].channel_id + "'>" + jsonData.data[x].channel_type + "</option>";
            }
            $("#channel_id").html(op);
            form.render("select");
        }
    });

    // 头工具栏事件
    table.on('toolbar(initorder)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'assignChecked':
                var data = checkStatus.data;
                var ids = new Array();
                if(data.length === 0){
                    layer.msg("请选择需要分配的销售单");
                }else {
                    for (var x in data) {
                        ids[x] = data[x].order_init_id;
                    }
                    checkStaff = $("#staff_id").val();
                    if (checkStaff != '') {
                        assignOrder(ids);
                    } else {
                        layer.msg("请选择被分配的销售人员");
                    }
                }
                break;
        };
    });

    // 批量分配
    function assignOrder(ids) {
        layer.confirm('您确定要这样分配吗？', {
            title: '确定分配', btn: ['确定', '取消']
        }, function () {
            $.ajax({
                type: "post",
                url: "orderinit/assignOrder?ids=" + ids + "&staff_id=" + checkStaff,
                async: true,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == '100') {
                        layer.msg('已完成,分配了' + jsonData.count + '个', {
                            icon: 1,
                            time: 2500
                        }, function () {
                            window.location.reload();
                        });
                    } else if (jsonData.code == 101) {
                        layer.msg('选择了已经分配过的毛单,分配了' + jsonData.count + '个', {
                            icon: 1,
                            time: 2500
                        }, function () {
                            window.location.reload();
                        });
                    } else {
                        layer.msg("未知错误", {
                            icon: 2
                        });
                    }
                },
                error: function (jqObj) {
                }
            });
        });
        return false;
    }

    // 排序事件
    table.on('sort(initorder)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
        table.reload('initorder', {
            initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
            , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                field: obj.field // 排序字段
                , order: obj.type
                // 排序方式
            }
        });
    });


    // 监听行工具事件
    table.on('tool(initorder)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            opID = data.order_init_id;// 操作数据id
            $('#customer_name').val(data.customer_name);
            $('#customer_contact').val(data.customer_contact);
            $('#collect_name').val(data.collect_name);
            $('#collect_tel').val(data.collect_tel);
            $('#entry_date').val(data.entry_date);
            $('#entry_real').val(data.entry_real_str);
            $('#channel_id').val(data.channel_id);
            $('#channel_name').val(data.channel_type);
            $('#order_staff_name').val(data.order_staff_name);
            $('#state').val(data.state);
            if(data.state === '未分配'){
                $('#assign').hide();
                $('#e-effective').hide();
            }else {
                $('#assign').show();
                $('#e-effective').show();
                $('#effective').val(data.effetive);
                $('#assign_staff_name').val(data.assign_staff_name);
            }
            $("#table").slideUp('', function () {
                $("#orderinit-content").slideDown();
            });
            form.render(); // 更新全部000
        }
    });

    // 搜索工具 start
    var filter = new Set();// 需要查询的字段

    filter.add("customer_name");
    filter.add("customer_contact");
    filter.add("collect_name");
    filter.add("collect_tel");
    filter.add("order_staff_name");
    filter.add("campus_name");
    filter.add("channel_type");
    filter.add("marketing_name");
    filter.add("entry_date");
    filter.add("entry_real");
    filter.add("state");
    filter.add("assign_staff_name");
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
        table.reload('initorder', {
            url: 'orderinit/findAllOrder?key=' + key + '&filter=' + Array.from(filter) + "&staff_id=" + staff_id + "&campus_id=" + campus_id,
        });
    }
    // 搜索工具 end

    // 返回按按钮点击事件
    $('#back').on('click', function () {
        $("#orderinit-content").slideUp('', function () {
            $("#table").slideDown();
        });
    });



    // 搜索工具 end


    // 重载表格 防止拉伸
    window.reloadTable = function () {
        initorderTable.reload();
    };
});