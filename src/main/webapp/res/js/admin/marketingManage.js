layui.use(['table', 'jquery', 'form', 'laydate', 'upload'], function () {
    var table = layui.table;
    var laydate = layui.laydate;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var type = 0;// 操作类型 0新增地点 1查看修改
    var opID = '';// 需要操作的 数据id
    var key = '';
    var upload = layui.upload;
    var one = '';
    var two = '';
    var filePath1 = "";
    var filePath2 = "";
    var staff_id = $("#staffId").val();
    var campusId = $("#campusId").val();


    //起始日期
    laydate.render({
        elem: '#marketing_date',
        theme: '#0078d7'
    });

    // 获取表格数据
    var marketingTable = table.render({
        elem: '#marketing',
        url: 'marketing/findAllMarketingList?staff_id='+staff_id+'&campus_id='+campusId,
        toolbar: '#toolBar',
        title: '市场营销活动',
        cols: [[{
            type: 'checkbox',
            fixed: 'left'
        }, {
            field: 'marketing_id',
            title: '活动ID',
            minWidth: 100,
            sort: true
        },{
            field: 'channel_type' ,
            title: '渠道名称',
            minWidth: 150,
            sort: true
        },{
            field: 'marketing_name',
            title: '活动名称',
            minWidth: 100,
            sort: true
        }, {
            field: 'marketing_place',
            title: '地点',
            minWidth: 100,
            sort: true
        }, {
            field: 'marketing_staff',
            title: '参与人员',
            minWidth: 100,
            sort: true
        }, {
            field: 'marketing_date_str',
            title: '时间',
            minWidth: 100
        }, {
            field: 'marketing_fee',
            title: '费用',
            minWidth: 100,
            sort: true
        }, {
            title: '操作',
            toolbar: '#opreationBar',
            width: 150,
            fixed: 'right'
        }]],
        page: true
    });



    //获取渠道
    $.ajax({
        url: "channel/findAllChannelName?staff_id=" + staff_id + "&campus_id=" + campusId,
        type: "get",
        success: function (data) {
            var jsonData = JSON.parse(data);
            var op = "<option value=''>全部渠道类型</option>";
            for (var a in jsonData.data) {
                op += "<option value='" + jsonData.data[a].channel_id + "'>" + jsonData.data[a].channel_type + "</option>";
            }
            $("#channel_id").html(op);
            form.render("select");
        }
    });



    // 排序事件
    table.on('sort(marketing)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
        table.reload('marketing', {
            initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
            , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                field: obj.field // 排序字段
                , order: obj.type
                // 排序方式
            }
        });
    });

    //上传备用文件一
    var option_first = upload.render({
        elem: '#option_first'
        , url: 'marketing/uploadOption?name=option_first'
        , accept: 'file'
        , exts: 'doc|docx|pdf'
        , auto: false
        , before: function (obj) {
            this.data = {
                "marketing_id": opID
            }
        }
        , choose: function (obj) {
            one = "yes";
            obj.preview(function (index, file, result) {
                $('#option_first').html('<i class="layui-icon">&#xe605</i><p >已选择文件：' + file.name + "</p>");
            });
        }
        , done: function (res) {
            console.log(res)
        }
    });

    //上传备用文件二
    var option_second = upload.render({
        elem: '#option_second'
        , url: 'marketing/uploadOption?name=option_second'
        , accept: 'file'
        , exts: 'doc|docx|pdf'
        , auto: false
        , before: function (obj) {
            this.data = {
                "marketing_id": opID
            }
        }
        , choose: function (obj) {
            obj.preview(function (index, file, result) {
                two = 'yes'
                $('#option_second').html('<i class="layui-icon">&#xe605</i><p >已选择文件：' + file.name + "</p>");
            });
        }
        , done: function (res) {
        }
    });

    // 监听提交
    form.on('submit(addMarketing)', function (data) {
        var url = "";
        if (type == 1) {
            url = "marketing/updateMarketing?"
                + $("#add-marketing-form").serialize() + "&marketing_id="
                + opID;
        } else {
            url = "marketing/addMarketing?"
                + $("#add-marketing-form").serialize();
        }
        $.ajax({
            type: "post",
            url: url,
            async: true,
            success: function (data) {
                var jsonData = JSON.parse(data);
                if (jsonData.code == 100) {
                    opID = jsonData.marketing_id;
                    if (one != '') {
                        option_first.upload();
                    }
                    if (two != '') {
                        option_second.upload();
                    }
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

    // 头工具栏事件
    table.on('toolbar(marketing)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'delChecked':
                var data = checkStatus.data;
                var ids = new Array();
                for (var x in data) {
                    ids[x] = data[x].marketing_id;
                }
                delAdds(ids);
                break;
        }
        ;
    });

    // 监听行工具事件
    table.on('tool(marketing)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            delAdds(data.marketing_id);
        } else if (obj.event === 'edit') {
            type = 1;// 查看与编辑
            filePath1 = data.url_first;
            filePath2 = data.url_second;
            opID = data.marketing_id;// 操作数据id
            $('#marketing_name').val(data.marketing_name);
            $('#marketing_place').val(data.marketing_place);
            $('#marketing_date').val(data.marketing_date);
            $('#marketing_staff').val(data.marketing_staff);
            $('#marketing_content').val(data.marketing_content);
            $('#marketing_fee').val(data.marketing_fee);
            $('#marketing_node').val(data.marketing_node);
            $('#channel_id').val(data.channel_id);
            $('#remark_first').val(data.remark_first);
            $('#remark_second').val(data.remark_second);

            $('#url_first').val(filePath1);
            $('#url_second').val(filePath2);

            if (filePath1 != "") {
                $('#option_first').html('<i class="layui-icon">&#xe605</i><p >已上传文件，可下载' + "</p>");
                $("#option-first-show").show();
            }
            if (filePath2 != "") {
                $('#option_second').html('<i class="layui-icon">&#xe605</i><p >已上传文件，可下载' + "</p>");
                $("#option-second-show").show();
            }
            $('#add-change').html('修改');
            $("#table").slideUp('', function () {
                $("#addMarketing-content").slideDown();
                $("#option_remark").show();
            });
            form.render(); // 更新全部000
        }
    });

    //下载文件
    $('#option-first-show').on('click', function () {
        if (filePath1 != '') {
            window.location.href = "file/downLoadFile?path=" + filePath1 + "&fileName=" + $('#marketing_name').val() + "&remark=" + $('#remark_first').val();
        } else {
            layer.msg("没有上传备用文件一");
            return false;
        }

    });

    //下载文件
    $('#option-second-show').on('click', function () {
        if (filePath2 != '') {
            window.location.href = "file/downLoadFile?path=" + filePath2 + "&fileName=" + $('#marketing_name').val() + "&remark=" + $('#remark_second').val();
        } else {
            layer.msg("没有上传备用文件二");
            return false;
        }
    });

    // 批量删除
    function delAdds(ids) {
        layer.confirm('您确定要删除吗？', {
            title: '确定删除', btn: ['确定', '取消']
        }, function () {
            $.ajax({
                type: "post",
                url: "marketing/delMarketing?ids=" + ids,
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

    // 搜索工具 start
    var filter = new Set();// 需要查询的字段
    filter.add("marketing_id");
    filter.add("channel_type");
    filter.add("marketing_name");
    filter.add("marketing_place");
    filter.add("marketing_date");
    filter.add("marketing_staff");
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
        table.reload('marketing', {
            url: 'marketing/findAllMarketingList?staff_id='+staff_id+'&campus_id='+campusId+'&key=' + key + '&filter=' + Array.from(filter)
        });
    }

    // 搜索工具 end


    // 添加按钮点击事件
    $('#add-marketing').on('click', function () {
        // 添加方法



        type = 0;
        $('#marketing_name').val("");
        $('#marketing_place').val("");
        $('#marketing_date').val("");
        $('#marketing_staff').val("");
        $('#marketing_content').val("");
        $('#marketing_fee').val("");
        $('#marketing_node').val("");
        $('#remark_first').val("");
        $('#remark_second').val("");
        $('#option_first').html('<i class="layui-icon"></i><p>点击上传，或将文件拖拽到此处</p>');
        $('#option_second').html('<i class="layui-icon"></i><p>点击上传，或将文件拖拽到此处</p>');
        $('#add-change').html('添加');
        $("#option-first-show").hide();
        $("#option-second-show").hide();
        $("#table").slideUp('', function () {
            $("#addMarketing-content").slideDown();
            $("#option_remark").hide();
        });
        form.render(); // 更新全部000
    });

    // 返回按按钮点击事件
    $('#back').on('click', function () {
        $("#addMarketing-content").slideUp('', function () {
            $("#option-first-show").hide();
            $("#option-second-show").hide();
            $('#option_first').html('<i class="layui-icon"></i><p>点击上传，或将文件拖拽到此处</p>');
            $('#option_second').html('<i class="layui-icon"></i><p>点击上传，或将文件拖拽到此处</p>');
            $("#table").slideDown();
        });
    });



    //上传Excel文件
    upload.render({
        elem: '#add-article'
        , url: 'marketing/importMarketing?order_staff_id=' + staff_id
        , accept: 'file'
        , exts: 'xlsx|xls'
        , auto: true
        , done: function (res) {
            //如果上传成功
            if (res.code == 100) {
                layer.confirm('已完成', {
                    icon: 1,
                    title: '提示'
                }, function (index) {
                    layer.close(index);
                    window.location.href = window.location.href;
                });
                return false;
            } else {
                layer.confirm('文件导入失败，请重新上传！', {
                    icon: 2,
                    title: '提示'
                }, function (index) {
                    layer.close(index);
                    window.location.href = window.location.href;
                });
                return false;
            }
        }
    });

    //下载模板
    $('#down-format').on('click', function () {
        window.location.href = "file/downLoadFile?path=" + "D:/crm/format/活动模板.xlsx";
    });

    // 重载表格 防止拉伸
    window.reloadTable = function () {
        marketingTable.reload();
    };
});