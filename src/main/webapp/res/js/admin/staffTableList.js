layui.use(['table', 'jquery', 'form', 'element'], function () {
    var table = layui.table;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var type = 0;// 操作类型 0新增地点 1查看修改
    var opID = '';// 需要操作的 数据id
    var element = layui.element;
    var fileTable = "";
    var key = '';
    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();


    var department_id='';





    var myTable = table.render({
        elem: '#myTable',
        url: 'staff/findAllStaffs?staff_id=' + staff_id + "&campus_id=" + campus_id+"&staff_depart="+department_id,
        title: '员工表',
        toolbar: '#toolBar',
        cols: [[{
            field: 'campus_name',
            title: '校区',
            minWidth: 130,
            sort: true
        }, {
            field: 'staff_id',
            title: '工号',
            minWidth: 110,
            sort: true
        }, {
            field: 'staff_name',
            title: '姓名',
            minWidth: 130,
            sort: true
        }, {
            field: 'password',
            title: '密码',
            minWidth: 130,
            sort: true
        }, {
            field: 'staff_depart',
            title: '部门',
            minWidth: 100,
            sort: true
        }, {
            field: 'staff_post',
            title: '职位',
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

    // 排序事件
    table.on('sort(myTable)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
        table.reload('myTable', {
            initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
            , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                field: obj.field // 排序字段
                , order: obj.type
                // 排序方式
            }
        });
    });

    // 返回按按钮点击事件
    $('#back').on('click', function () {
        $('#examine-search-div').show();
        $('#back').parent().hide();
        if ($("#table").css('display') == 'none') {
            $("#add-post-content").slideUp('', function () {
                $("#table").slideDown();
            });
        }
    });
    //更改部门
    form.on('select(department_id)', function () {
        department_id=$("#department_id").val();

        table.reload('myTable', {
            url: 'staff/findAllStaffs?staff_id=' + staff_id + "&campus_id=" + campus_id+"&staff_depart="+department_id
        });

    });








    // 搜索工具 start
    var filter = new Set();// 需要查询的字段
    filter.add("staff_id");
    filter.add("staff_name");
    filter.add("staff_depart");
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
        key = $("#serach-address-key").val();
        searchAdd();
    });
    // 输入框回车事件
    $('#serach-address-key').bind('keypress', function (event) {
        if (event.keyCode == "13") {
            key = $("#serach-address-key").val();
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
        table.reload('myTable', {
            url: 'staff/findAllStaffs?key=' + key + '&filter=' + Array.from(filter) + "&staff_id=" + staff_id + "&campus_id=" + campus_id+"&staff_depart="+department_id,
        });
    }

    // 搜索工具 end

    // 监听行工具事件
    table.on('tool(myTable)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            type = 1;// 查看与编辑
            opID = data.staff_id;// 被操作员工的id
            $('#campus_name').html(data.campus_name);
            $('#staff_id').html(data.staff_id);
            $('#staff_name').html(data.staff_name);
            $('#password').html(data.password);
            $('#staff_depart').html(data.staff_depart);
            $('#staff_post').html(data.staff_post);
            form.render(); // 更新全部000
            $("#table").slideUp('', function () {
                $("#add-post-content").slideDown();
            });
            $('#examine-search-div').hide();
            $('#back').parent().show();
        }else if (obj.event === 'delete') {
            delAdds(data.staff_id);
        }
    });



    function delAdds(id) {
        layer.confirm('您确定要删除吗？', {
            title: '确定删除', btn: ['确定', '取消']
        }, function () {
            $.ajax({
                type: "post",
                url: "staff/deleteStaff?staff_id=" + id,
                async: true,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == '100') {
                        layer.msg('删除完成', {
                            icon: 1,
                            time: 2500
                        }, function () {
                            window.location.reload();
                        });
                    } else if (jsonData.code == 102) {
                        layer.msg("访问受限，权限不足");
                    } else{
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

    // 编辑职员基本信息
    $('#change-staff-base').on('click', function () {
        layer.open({
            type: 2,
            title: '修改职员' + opID + '信息',
            shadeClose: true,
            shade: 0.8,
            area: ['70%', '60%'],
            content: 'staff/gotoJsp?id=' + opID + "&jsp=changeStaffBasePage" + "&campus_id=" + campus_id
        });
    });

    // 重载表格 防止拉伸
    window.reloadTable = function () {
        myTable.reload();
        if (fileTable != '') {
            fileTable.reload();
        }
    };
    form.render();

});
