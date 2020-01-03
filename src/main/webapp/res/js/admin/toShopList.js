layui.use(['table', 'jquery', 'form', 'laydate'], function () {
    var table = layui.table;
    var laydate = layui.laydate;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var opID = '';// 需要操作的 数据id
    var key = '';
    var type = 0;
    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();

    //预约日期
    laydate.render({
        elem: '#reserve_date'
        , type: 'datetime'
    });

    //实际日期
    laydate.render({
        elem: '#actual_date'
        , type: 'datetime'
    });

    // 获取表格数据
    var toShopTable = table.render({
        elem: '#toShop',
        url: 'toShop/findAllShops?staff_id=' + staff_id + "&campus_id=" + campus_id,
        toolbar: '#toolBar',
        title: '毛单列表',
        cols: [[{
            title: '编号',
            type: 'numbers',
            width: 70
        }, {
            field: 'campus_name',
            title: '所属校区',
            minWidth: 100,
            sort: true
        }, {
            field: 'customer_name',
            title: '客户姓名',
            minWidth: 100,
            sort: true
        }, {
            field: 'customer_contact',
            title: '联系方式',
            minWidth: 100,
            sort: true
        },{
            field: 'staff_name',
            title: '顾问老师',
            minWidth: 100,
            sort: true
        }, {
            field: 'to_shop',
            title: '到店方式',
            minWidth: 100,
            sort: true
        }, {
            field: 'invitation_date_str',
            title: '邀约日期',
            minWidth: 100,
            sort: true
        },{
            field: 'reserve_date_str',
            title: '预约到店时间',
            minWidth: 100,
            templet: '#stateTp1',
            sort: true
        }, {
            field: 'is_to_shop',
            title: '是否到店',
            minWidth: 100,
            sort: true
        }, {
            field: 'actual_date_str',
            title: '实际到店时间',
            minWidth: 100,
            sort: true
        }, {
            title: '操作',
            toolbar: '#opreationBar',
            width: 120,
            fixed: 'right'
        }]],
        page: true
    });

    // 排序事件
    table.on('sort(toShop)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
        table.reload('toShop', {
            initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
            , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                field: obj.field // 排序字段
                , order: obj.type
                // 排序方式
            }
        });
    });

    // 监听提交
    form.on('submit(updateToShop)', function (data) {
        var url = "";
        if (type == 1) {

        } else {
            $("#submit-button").show();
            url = "toShop/addToShop?"
                + $("#update-toShop-form").serialize() + "&staff_id=" + staff_id;
        }
        $.ajax({
            type: "post",
            url: url,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                if (jsonData.code == 100) {
                    layer.confirm('已完成', {
                        icon: 1,
                        title: '提示'
                    }, function (index) {
                        layer.close(index);
                        window.location.href = window.location.href;
                    });
                } else if (jsonData.code == 101) {
                    layer.confirm('身份已过期，请重新登录', {
                        icon: 2,
                        title: '提示'
                    }, function (index) {
                        layer.close(index);
                        window.location.href = "gotoLogin";
                    });
                } else if (jsonData.code == 102) {
                    layer.msg("访问受限，权限不足");
                } else {
                    layer.msg("未知错误");
                }
            },
            error: function (jqObj) {
            }
        });
        return false;
    });

    // 监听行工具事件
    table.on('tool(toShop)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            type = 1;
            opID = data.to_shop_id;// 操作数据id
            $('#customer_name').val(data.customer_name);
            $('#customer_contact').val(data.customer_contact);
            $('#to_shop').val(data.to_shop);
            $('#reserve_date').val(data.reserve_date);
            $('#actual_date').val(data.actual_date);
            $('#is_to_shop').val(data.is_to_shop);
            $('#add-change').html('修改');
            $("#table").slideUp('', function () {
                $("#submit-button").hide();
                $("#toShop-content").slideDown();
            });
            form.render(); // 更新全部000
        }
    });

    // 搜索工具 start
    var filter = new Set();// 需要查询的字段
    filter.add("staff_name");
    filter.add("customer_name");
    filter.add("customer_contact");
    filter.add("to_shop");
    filter.add("reserve_date");
    filter.add("is_to_shop");
    filter.add("actual_date");
    form.render();
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
        table.reload('toShop', {
            url: 'toShop/findAllShops?key=' + key + '&filter=' + Array.from(filter) + '&staff_id=' + staff_id + "&campus_id=" + campus_id
        });
    }

    // 搜索工具 end

    // 添加按钮点击事件
    $('#add-toShop').on('click', function () {
        // 添加方法
        type = 0;
        $('#customer_name').val("");
        $('#customer_contact').val("");
        $('#to_shop').val("");
        $('#reserve_date').val("");
        $('#is_to_shop').val("");
        $('#actual_date').val("");
        $('#add-change').html('添加');
        $("#table").slideUp('', function () {
            $("#submit-button").show();
            $("#toShop-content").slideDown();
        });
        form.render(); // 更新全部000
    });

    // 返回按按钮点击事件
    $('#back').on('click', function () {
        $("#toShop-content").slideUp('', function () {
            $("#table").slideDown();
        });
    });

    // 重载表格 防止拉伸
    window.reloadTable = function () {
        toShopTable.reload();
    };
});