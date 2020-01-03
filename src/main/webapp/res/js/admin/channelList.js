layui.use(['table', 'jquery', 'form', 'element'], function () {
    var table = layui.table;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var type = 0;// 操作类型 0新增地点 1查看修改
    var opID = '';// 需要操作的 数据id
    var element = layui.element;
    var staff_id = $("#staffId").val();
    var campusId = $("#campusId").val();

    $.ajax({
        url: "staff/findAllCampusById?staff_id=" + staff_id + "&campus_id=" + campusId,
        type: "get",
        success: function (data) {
            var jsonData = JSON.parse(data);
            var op = "<option value=''>请选择</option>";
            for (var x in jsonData.data) {
                op += "<option value='" + jsonData.data[x].campus_id + "'>" + jsonData.data[x].campus_name + "</option>";
            }
            $("#campus_id").html(op);
            form.render("select");
        }
    });

    // 获取表格数据 getAddsBySE
    var channelTable = table.render({
        elem: '#channel',
        url: 'channel/findAllChannel?staff_id=' + staff_id + "&campus_id=" + campusId,
        toolbar: '#toolBar',
        title: '职位表',
        cols: [[{
            title: '编号',
            type: 'numbers',
            fixed: 'left',
            width: 70
        },{
            field: 'campus_name',
            title: '所属校区',
            minWidth: 200,
            sort: true
        }, {
            field: 'channel_id',
            title: '渠道ID',
            minWidth: 200,
            sort: true
        }, {
            field: 'onOffline',
            title: '线上线下',
            minWidth: 200,
            sort: true
        }, {
            field: 'channel_type',
            title: '渠道类型',
            minWidth: 200,
            sort: true
        }, {
            title: '操作',
            toolbar: '#opreationBar',
            width: 180,
            fixed: 'right'
        }]],
        page: true
    });






    // 排序事件
    table.on('sort(channel)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
        table.reload('channel', {
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

    // 添加方法
    $('#add-channel').on('click', function () {
        type = 0;
        $("#campus_id").val("");
        $("#onOffline").val("");
        $("#channel_type").val("");
        $('#addChannel-change').html('添加');
        if ($("#table").css('display') == 'block') {
            $("#table").slideUp('', function () {
                $('#add-channel').parent().hide();
                $('#back').parent().show();
                $("#add-channel-content").slideDown();
            });
        };
        form.render(); // 更新全部000
    });

    // 返回按按钮点击事件
    $('#back').on('click', function () {
        if ($("#table").css('display') == 'none') {
            $("#add-channel-content").slideUp('', function () {
                $('#add-channel').parent().show();
                $('#back').parent().hide();
                $("#table").slideDown();
            });
        }
    });

    // 搜索工具 start
    var filter = new Set();// 需要查询的字段
    filter.add("OnOffline");
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
        table.reload('channel', {
            url: 'channel/findAllChannel?key=' + key + '&filter=' + Array.from(filter) + '&staff_id=' + staff_id + "&campus_id=" + campusId
        });
    }

    // 搜索工具 end

    // 监听提交
    form.on('submit(addChannel)', function (data) {
        var url = "";
        if (type == 1) {
            url = "channel/updateChannel?"
                + $("#add-channel-form").serialize() + "&channel_id="
                + opID;
        } else {
            url = "channel/addChannel?"
                + $("#add-channel-form").serialize();
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
                    layer.msg('身份已过期，请重新登录', {
                        icon: 2,
                        time: 2500
                    }, function () {
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
    table.on('tool(channel)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            delAdds(data.channel_id);
        } else if (obj.event === 'edit') {
            type = 1;// 查看与编辑
            opID = data.channel_id;// 操作数据id
            $('#campus_id').val(data.campus_id);
            $('#onOffline').val(data.onOffline);
            $('#channel_type').val(data.channel_type);
            $('#addChannel-change').html('修改');
            form.render(); // 更新全部000
            $("#table").slideUp('', function () {
                $('#add-channel').parent().hide();
                $('#back').parent().show();
                $("#add-channel-content").slideDown();
            });

        }
    });

    // 批量删除地址
    function delAdds(id) {
        layer.confirm('您确定要删除吗？', {
            title: '确定删除', btn: ['确定', '取消']
        }, function () {
            $.ajax({
                type: "post",
                url: "channel/deleteChannel?id=" + id,
                async: true,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == '100') {
                        layer.msg('已完成', {
                            icon: 1,
                            time: 2500
                        }, function () {
                            window.location.reload();
                        });
                    } else if (jsonData.code == 102) {
                        layer.msg("访问受限，权限不足");
                    } else if (jsonData.code == 104) {
                        layer.msg("该渠道下还存在活动，禁止删除",{
                            icon:2,
                            time:2000
                        });
                    }else{
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

    // 重载表格 防止拉伸
    window.reloadTable = function () {
        channelTable.reload();
    };
    form.render();
});