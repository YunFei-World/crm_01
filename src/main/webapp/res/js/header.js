layui.config({
    base: "layui/lay/mymodules/"
}).use([ 'element', 'jquery', 'layer' /*,'notice'*/,'form'], function() {
	var element = layui.element;
	var $ = jQuery = layui.jquery;
	var layer = layui.layer;
    var form = layui.form;
	var urlF = $('#headerUrl').html();
	$("#" + urlF).addClass("layui-this");
	$("#" + urlF + "-mini").addClass("layui-this");
    var staff_id = $("#staffId").val();
    var campus_id = $("#campusId option:selected").val();
    // 获取校区
    $.ajax({
        url: "staff/findAllCampusById?staff_id=" + staff_id,
        type: "get",
        success: function (data) {
            var jsonData = JSON.parse(data);
            var op = "";
            for (var x in jsonData.data) {
                if (((jsonData.data[x].campus_id).toString())==($('#currentCampus').val())){
                    op += "<option value='" + jsonData.data[x].campus_id + "' selected='selected'>" + jsonData.data[x].campus_name + "</option>";
                }else{
                    op += "<option value='" + jsonData.data[x].campus_id + "' >" + jsonData.data[x].campus_name + "</option>";
                }
           }
            $("#campusId").html(op);
            form.render("select");
        }
    });


    form.on('select(campusId)', function () {
        campus_id = $("#campusId").val();
        //更改校区
        $.ajax({
            url: "keepCampus?campus_id=" + campus_id,
            type: "get",
            success:function () {

                window.location.href=window.location.href;
            }
        });




    });

	/*$('#show-my').on('click', function() {
		layer.open({
			type : 1,
			title : false,
			shadeClose : true, // 开启遮罩关闭
			closeBtn : 0, // 不显示关闭按钮
			shade : [ 0.2 ],
			area : [ '340px', ($(window).height() - 50) + 'px' ],
			offset : [ '50px', ($(window).width() - 340) + "px" ],
			anim : 5,
			content : $('#my-content').html(),
			end : function() { // 此处用于演示

			}
		});
	});*/


	
});