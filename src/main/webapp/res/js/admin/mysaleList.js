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
        title: '销售列表',
        toolbar: '#toolBar',
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
            hide: true,
            sort: true
        },  {
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
        },{
            field: 'arrive_time_str',
            title: '预计上访时间',
            minWidth: 100,
            hide: true
        }, {
            title: '操作',
            toolbar: '#opreationBar',
            width: 120,
            fixed: 'right'
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

    // 监听行工具事件
    table.on('tool(sale)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            op1(data);
            opNumber = 1;
        }
    });

    // 监听行工具事件
    table.on('tool(follow_table)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            op2(data);
            opNumber = 2;
        }
    });









    function op2(data) {

        var other_reason=data.other_reason;
        var false_reason=data.false_reason;

        if (false_reason=='F.其它因素'){
            $("#other_reason").val(other_reason);
            $("#other_reason_all").slideDown();
        }else{//如果没有使用其它因素 则赋为”“
            $("#other_reason_all").slideUp();

        }


        $('#staff_name').val(data.staff_name);
        $('#save_way').val(data.is_coming);
        $('#is_effective').val(data.is_effective);

        $('#contact_style').val(data.contact_style);
        $('#contact_number').val(data.contact_number);


        $('#sale_stage_up').val(data.sale_stage_up);
        $('#false_reason_follow').val(data.false_reason);

        $('#next_time_up_str').val(data.next_time_up_str);
        $('#arrive_time').val(data.arrive_time_str);

        $('#other_remark').val(data.other_remark);
        $('#result').val(data.result);

        var text='	<img layer-pid="" layer-src="file/getFile?path='+data.screen_image+'" src="file/getFile?path='+data.screen_image+'" height="200" width="450">';
        $('#layer-photos-demo').html(text);
        layer.photos({
            photos: '#layer-photos-demo'
            ,anim: 5 // 0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
        });

        $("#sale-content").slideUp('', function () {
            $("#follow_up").slideDown();
        });
        form.render(); // 更新全部000
    }

    function op1(data) {
        opID = data.sale_id;// 操作数据id
        $('#customer_name').html(data.customer_name);
        $('#customer_contact').html(data.customer_contact);
        $('#assign_staff_name').html(data.assign_staff_name);
        $('#relation').html(data.relation);
        $('#stu_name').html(data.stu_name);
        $('#stu_age').html(data.stu_age);
        $('#stu_grade').html(data.stu_grade);
        $('#stu_school').html(data.stu_school);
        $('#address').html(data.address);
        $('#referrer').html(data.referrer);
        $('#sale_stage').html(data.sale_stage);
        $('#course_need').html(data.course_need);
        $('#false_reason').html(data.false_reason);
        $('#is_coming').html(data.is_coming);
        $('#arrive_time_str').html(data.arrive_time_str);
        followTable = table.render({
            elem: '#follow_table',
            url: 'saleOrder/findAllFollow?sale_id=' + opID,
            title: '回访记录',
            toolbar: '#toolBar',
            cols: [[{
                title: '编号',
                type: 'numbers',
                fixed: 'left',
                width: 60
            }, {
                field: 'staff_name',
                title: '顾问老师',
                minWidth: 100
            }, {
                field: 'is_effective',
                title: '回访是否有效',
                templet: '#stateTpl',
                minWidth: 100
            }, {
                field: 'contact_style',
                title: '联系方式',
                minWidth: 100
            }, {
                field: 'sale_stage_up',
                title: '销售阶段',
                minWidth: 100
            }, {
                field: 'next_time_up_str',
                title: '下次联系时间',
                minWidth: 200
            }, {
                field: 'result',
                title: '联系结果',
                minWidth: 200
            }, {
                title: '操作',
                toolbar: '#opreationBarFollow',
                width: 120,
                fixed: 'right'
            }]],
            page: true
        });
        $("#table").slideUp('', function () {
            $('#examine-search-div').hide();
            $('#back').parent().show();
            $("#sale-content").slideDown();
        });
        form.render(); // 更新全部000

        // 排序事件
        table.on('sort(follow_table)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
            table.reload('follow_table', {
                initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
                , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                    field: obj.field // 排序字段
                    , order: obj.type
                    // 排序方式
                }
            });
        });
    }








    // 编辑客户基本信息
    $('#change-follow').on('click', function () {
        layer.open({
            type: 2,
            title: '修改客户信息',
            shadeClose: true,
            shade: 0.8,
            area: ['80%', '80%'],
            content: 'saleOrder/gotoJsp?sale_id=' + opID + "&jsp=changeFollowPage"
        });
    });



    /*// 头工具栏事件
    table.on('toolbar(follow_table)', function (obj) {
        layer.open({
            type: 2,
            title: '回访信息登记',
            shadeClose: true,
            shade: 0.8,
            area: ['80%', '80%'],
            content: 'saleOrder/gotoFollow?sale_id=' + opID + "&jsp=followPage"
        });

    });*/



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

    filter.add("course_need");
    filter.add("sale_stage");
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

    // 返回按按钮点击事件
    $('#back').on('click', function () {
        if (opNumber == 2) {
            $("#follow_up").slideUp('', function () {
                $("#sale-content").slideDown();
            });
            opNumber = 1;
        } else if (opNumber == 1) {
            $("#sale-content").slideUp('', function () {
                $('#back').parent().hide();
                $('#examine-search-div').show();
                $("#table").slideDown();
            });
            opNumber = 0;
        } else if (opNumber == 3){
            $("#record").slideUp('', function () {
                $('#back').parent().hide();
                $('#examine-search-div').show();
                $("#table").slideDown();
            });
            opNumber = 0;
        }
    });

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