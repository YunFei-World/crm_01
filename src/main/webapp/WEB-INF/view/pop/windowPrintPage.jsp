<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>优创智合</title>
  <%--  <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../res/css/my.css">--%>


    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/AdminLTE/css/AdminLTE.min.css">





    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>



</head>



<body>


<div class="wrapper">
    <!-- Main content -->
    <section class="invoice">
        <!-- title row -->
        <div class="row">
            <div class="col-xs-12">
                <h2 class="page-header">
                    <i class="fa fa-globe"></i> ${sign.student_name}-${sign.student_id}
                    <small class="pull-right">Date:${sign.load_time_str2}  </small>
                </h2>
            </div>
            <!-- /.col -->
        </div>
        <!-- info row -->
        <div class="row invoice-info">
            <div class="col-xs-4 invoice-col">
                顾问老师
                <address>
                    <strong>${sign.assign_staff_name}.</strong><br>
                    工号：${sign.assign_staff_id}<br>
                    微信：${staff.staff_weixin}<br>
                    联系电话: ${staff.staff_contact}<br>
                    Email: ${staff.staff_email}
                </address>
            </div>
            <!-- /.col -->
            <div class="col-xs-4 invoice-col">
                优创智合
                <address>
                    <strong>${sign.campus_name}</strong><br>
                    地址：${campus.campus_addr}<br>
                    联系电话: ${campus.tel}<br>

                </address>
            </div>
            <!-- /.col -->
            <div class="col-xs-4 invoice-col">
                <b>发票信息</b><br>
                <br>
                <b>订单号:</b> ${sign.sign_id}<br>
                <b>订单日期:</b> ${sign.load_time_str}<br>
                <b>付款学生账户:</b> ${sign.student_id}
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
        <br>
        <br>

        <!-- Table row -->
        <div class="row">
            <div class="col-xs-12 table-responsive">
                <p class="lead">所购课程</p>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>课程</th>
                        <th>原价</th>
                        <th>优惠</th>
                        <th>成交时间</th>
                        <th>小计</th>
                    </tr>
                    </thead>
                    <tbody id="lineDrop">
                    <tr ></tr>

                    </tbody>
                </table>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->



        <br>
        <br>
        <div class="row">

            <!-- /.col -->
            <div class="col-xs-12">
                <p class="lead">订单总计</p>

                <div class="table-responsive">
                    <table class="table">
                        <tr>
                            <th style="width:50%">原价:</th>
                            <td>${sign.order_course_num} 元</td>
                        </tr>
                        <tr>
                            <th>优惠金额</th>
                            <td>${sign.reward_balance} 元</td>
                        </tr>
                        <tr>
                            <th>总计:</th>
                            <td>${sign.final_price} 元</td>
                        </tr>
                    </table>
                </div>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

        <div class="row">

            <div class="col-xs-4">
                <strong>客户签字:</strong>
            </div>
            <div class="col-xs-4">
                <strong>盖章处：</strong>
            </div>
            <div class="col-xs-4">
                <strong>时间：</strong>
            </div>

        </div>




    </section>
    <!-- /.content -->
</div>





<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script>
    $(document).ready(function() {

        // 延迟1秒打印，等待图片载入
        setTimeout(function() {
            window.print();
        }, 1000);
    });






</script>

<%--<script src="../layui/layui.js"></script>--%>
<script>
   //JavaScript代码区域
    /*layui.use([ 'jquery'], function () {
        var $ = jQuery = layui.jquery;

*/

        var sign_id='${sign.sign_id}';
        $.ajax({
            url: "findAllSignCourseBySignId?sign_id=" + sign_id,
            type: "get",
            success: function (data) {
                var jsonData = JSON.parse(data);
                var op = "";
                for (var a in jsonData.data) {
                    op += "<tr> " +
                        "<th>"+jsonData.data[a].course_name +" </th> " +
                        "<th>"+jsonData.data[a].totalPrice +" 元</th> " +
                        "<th>"+jsonData.data[a].reward_balance +" 元</th> " +
                        "<th>"+jsonData.data[a].create_time_str +" </th> " +
                        "<th>"+jsonData.data[a].deal_price +" 元</th>" +
                        "</tr>";
                }
                $("#lineDrop").html(op);
            }
        });
        /*window.onload = function() {
            var show = document.getElementById("show");
            setInterval(function () {
                var time = new Date();   // 程序计时的月从0开始取值后+1
                var m = time.getMonth() + 1;
                var t = time.getFullYear() + "-" + m + "-"
                    + time.getDate() /!*+ " " + time.getHours() + ":"
                    + time.getMinutes() + ":" + time.getSeconds()*!/;
                show.innerHTML = t;
            }, 1000);
        };*/

   /* });*/
</script>
</body>
</html>