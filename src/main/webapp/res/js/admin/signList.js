layui.use(['table', 'jquery', 'form', 'laydate'], function () {
    var table = layui.table;
    var laydate = layui.laydate;
    var $ = jQuery = layui.jquery;
    var form = layui.form;
    var opID = '';// 需要操作的 数据id
    var key = '';
    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId").val();



    // 获取表格数据
    var signTable = table.render({
        elem: '#sign',
        url: 'sign/findAllSign?staff_id=' + staff_id + "&campus_id=" + campus_id,
        toolbar: '#toolBar',
        title: '课程报名表',
        cols: [[{
            title: '编号',
            type: 'numbers',
            fixed: 'left',
            width: 50
        }, {
            field: 'customer_name',
            title: '家长姓名',
            minWidth: 100,
            templet: '#stateTp1',
            sort: true
        }, {
            field: 'customer_contact',
            title: '联系电话',
            minWidth: 120,
            templet: '#stateTp2',
            sort: true
        }, {
            field: 'relation',
            title: '亲属关系',
            minWidth: 50,
            templet: '#stateTp3',
            sort: true
        }, {
            field: 'stu_name',
            title: '学生姓名',
            minWidth: 100,
            templet: '#stateTp4',
            sort: true
        }, {
            field: 'student_sex',
            title: '学生性别',
            minWidth: 100,
            hide: true,
            sort: true
        }, {
            field: 'student_birthday_str',
            title: '学生生日',
            minWidth: 100,
            hide: true
        }, {
            field: 'student_phone',
            title: '学生电话',
            minWidth: 120,
            hide: true,
            sort: true
        }, {
            field: 'assign_staff_name',
            title: '顾问老师',
            minWidth: 100,
            hide: true,
            sort: true
        }, {
            field: 'course_name',
            title: '课程名称',
            minWidth: 200,
            sort: true
        }, {
            field: 'final_price',
            title: '成交价',
            minWidth: 100,
            sort: true
        }, {
            field: 'load_time_str',
            title: '报名日期',
            minWidth: 120
        }]],
        page: true
    });




    // 排序事件
    table.on('sort(sign)', function (obj) { // 注：tool是工具条事件名，test是table原始容器的属性
        table.reload('sign', {
            initSort: obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
            , where: { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                field: obj.field // 排序字段
                , order: obj.type
                // 排序方式
            }
        });
    });






    // 搜索工具 start
    var filter = new Set();// 需要查询的字段
    filter.add("customer_name");
    filter.add("customer_contact");
    filter.add("relation")
    filter.add("stu_name");
    filter.add("assign_staff_name");
    filter.add("course_name");
    filter.add("load_time");
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
        table.reload('sign', {
            url: 'sign/findAllSign?key=' + key + '&filter=' + Array.from(filter) + '&staff_id=' + staff_id + "&campus_id=" + campus_id,
        });
    }
    // 搜索工具 end



    // 重载表格 防止拉伸
    window.reloadTable = function () {
        signTable.reload();
    };

});