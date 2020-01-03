layui.use(['table', 'jquery', 'form', 'laydate'], function () {
    var table = layui.table;
    var laydate = layui.laydate;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var opID = '';// 需要操作的 数据id
    var key = '';
    var opNumber = 0;
    var followTable = "";
    var checkStaff = '';
    var recordTable = "";
    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();

    // 获取表格数据
    var saleTable = table.render({
        elem: '#sale',
        url: 'saleOrder/findAllSale?staff_id='+ staff_id + "&campus_id=" + campus_id,
        toolbar: '#toolBar1',
        title: '销售列表',
        cols: [[{
            type: 'checkbox',
            fixed: 'left'
        },{
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
        }, {
            field: 'relation',
            title: '亲属关系',
            minWidth: 100,
            sort: true
        }, {
            field: 'stu_name',
            title: '学生姓名',
            minWidth: 100,
            sort: true
        }, {
            field: 'stu_age',
            title: '学生年龄',
            minWidth: 100,
            hide: true,
            sort: true
        }, {
            field: 'stu_grade',
            title: '学生年级',
            minWidth: 100,
            hide: true,
            sort: true
        }, {
            field: 'stu_school',
            title: '学生学校',
            minWidth: 100,
            hide: true,
            sort: true
        }, {
            field: 'address',
            title: '家庭住址',
            minWidth: 100,
            hide: true,
            sort: true
        }, {
            field: 'referrer',
            title: '推荐人',
            minWidth: 100,
            hide: true,
            sort: true
        }, {
            field: 'assign_staff_name',
            title: '顾问老师',
            minWidth: 100,
            sort: true
        }, {
            field: 'sale_stage',
            title: '销售阶段',
            minWidth: 100,
            sort: true
        }, {
            field: 'course_need',
            title: '课程需求',
            minWidth: 100,
            hide: true,
            sort: true
        }, {
            field: 'next_time_str',
            title: '下次联系时间',
            minWidth: 200,
            templet: '#stateTp2'
        }, {
            field: 'false_reason',
            title: '未成功原因',
            minWidth: 100,
            hide: true,
            sort: true
        }]],
        page: true
    });

    // 排序事件
    table.on('sort(sale)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
        table.reload('sale', {
            initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
            , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                field: obj.field // 排序字段
                , order: obj.type
                // 排序方式
            }
        });
    });



    $.ajax({
        url: "staff/findAllSaleStaff?staff_id=" + staff_id + "&campus_id=" + campus_id,
        type: "get",
        success: function (data) {
            var jsonData = JSON.parse(data);
            var op = "<option value=''>全部销售人员</option>";
            for (var x in jsonData.data) {
                op += "<option value='" + jsonData.data[x].staff_id + "'>" + jsonData.data[x].staff_id + '-' + jsonData.data[x].staff_name + "</option>";
            }
            $("#staff_id").html(op);
            form.render("select");
        }
    });







    // 头工具栏事件
    table.on('toolbar(sale)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'transformChecked':
                var data = checkStatus.data;
                var ids = new Array();
                if(data.length === 0){
                    layer.msg("请选择转换销售单");
                }else{
                    for (var x in data) {
                        ids[x] = data[x].order_init_id;
                    }
                    checkStaff = $("#staff_id").val();
                    if (checkStaff != '') {
                        transformOrder(ids);
                    } else {
                        layer.msg("请选择转换的销售人员");
                    }
                }
                break;
            case 'transformRecord':
                transRecord();
                opNumber=3;
                break;
        };
    });

    function transRecord(){
        recordTable = table.render({
            elem: '#transformRecord',
            url: 'transRecord/findAllTransRecordSecond',
            toolbar: '#toolBar',
            title: '转换记录',
            cols: [[{
                title: '编号',
                type: 'numbers',
                fixed: 'left',
                width: 60
            }, {
                field: 'customer_name',
                title: '客户姓名',
                minWidth: 100,
                sort: true
            }, {
                field: 'customer_contact',
                title: '联系方式',
                minWidth: 100
            },{
                field: 'trans_time_str',
                title: '转单时间',
                minWidth: 100
            }, {
                field: 'out_staff_name',
                title: '被转单员工',
                minWidth: 100,
                sort: true
            }, {
                field: 'in_staff_name',
                title: '转单给',
                minWidth: 100,
                sort: true
            }]],
            page: true
        });
        $("#table").slideUp('', function () {
            $('#examine-search-div').hide();
            $('#back').parent().show();
            $("#record").slideDown();
        });
        form.render(); // 更新全部000
    }

    // 批量转换
    function transformOrder(ids) {
        layer.confirm('您确定要这样转换吗？', {
            title: '确定转换', btn: ['确定', '取消']
        }, function () {
            $.ajax({
                type: "get",
                url: "orderinit/transformSale?ids=" + ids + "&staff_id=" + checkStaff,
                async: true,
                success: function (data) {
                    var jsonData = JSON.parse(data);
                    if (jsonData.code == '100') {
                        layer.msg('已完成,转换给了' + $("#staff_id").find("option:selected").text() +jsonData.count + '个', {
                            icon: 1,
                            time: 2000
                        }, function () {
                            window.location.reload();
                        });
                    } else if (jsonData.code == 101) {
                        layer.msg('选择了未分配过的毛单,转换给了' + $("#staff_id").find("option:selected").text() +jsonData.count + '个', {
                            icon: 1,
                            time: 2000
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


    // 搜索工具 start
    var filter = new Set();// 需要查询的字段
    filter.add("customer_name");
    filter.add("customer_contact");
    filter.add("relation")
    filter.add("stu_name");
    filter.add("stu_age");
    filter.add("stu_grade");
    filter.add("stu_school");
    filter.add("address");
    filter.add("assign_staff_name");
    filter.add("referrer");
    filter.add("sale_stage");
    filter.add("course_need");
    filter.add("next_time");
    filter.add("false_reason");
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
        table.reload('sale', {
            url: 'saleOrder/findAllSale?key=' + key + '&filter=' + Array.from(filter) + '&staff_id='+ staff_id + "&campus_id=" + campus_id
        });
    }
    // 搜索工具 end



    // 重载表格 防止拉伸
    window.reloadTable = function () {
        saleTable.reload();
        if (followTable != '') {
            followTable.reload();
        }
        if (recordTable != '') {
            recordTable.reload();
        }
    };

});