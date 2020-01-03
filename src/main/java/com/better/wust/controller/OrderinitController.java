package com.better.wust.controller;

import com.better.wust.entity.ChanStatistics;
import com.better.wust.entity.Orderinit;
import com.better.wust.entity.Sale;
import com.better.wust.entity.TransRecord;
import com.better.wust.service.OrderinitService;
import com.better.wust.tools.JsonUtils;
import com.better.wust.tools.entity.SelectEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SoundbankResource;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("orderinit")
public class OrderinitController {

    @Autowired
    private OrderinitService orderinitService;

    @RequestMapping(value = "findAllOrder", method = RequestMethod.GET)
    public void findAllOrder(HttpServletRequest request, HttpServletResponse response, int page, int limit, String field,
                             String order, String key, String[] filter, String campus_id,String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(campus_id,'')";
        }
        if (campus_id == "") {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')" +"and state='未分配'";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')"+"and state='未分配'";
            }
        } else {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "'"+"and state='未分配'";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "'"+"and state='未分配'";
            }
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "entry_real  asc, customer_name ASC, order_staff_name ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<Orderinit> list = orderinitService.findAllOrder(selectEntity);
        int num = orderinitService.findOrderNum(selectEntity);
        JSONObject json = new JSONObject();
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", 0);
        json.put("count", num);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加一个新毛单
     *
     * @param response
     * @param request
     * @param orderinit
     */
    @RequestMapping(value = "addOrderinit", method = RequestMethod.POST)
    public void addMarketing(HttpServletResponse response, HttpServletRequest request, Orderinit orderinit) {
        JSONObject json = new JSONObject();
        int code = 100;
        orderinitService.addOrderinit(orderinit);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 更新毛单
     *
     * @param response
     * @param request
     * @param orderinit
     */
    @RequestMapping(value = "updateOrderinitByMark", method = RequestMethod.POST)
    public void updateOrderinitByMark(HttpServletResponse response, HttpServletRequest request, Orderinit orderinit) {
        JSONObject json = new JSONObject();
        int code = 100;
        orderinitService.modifyOrderinitByMark(orderinit);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "updateOrderinitByAdmin", method = RequestMethod.POST)
    public void updateOrderinitByAdmin(HttpServletResponse response, HttpServletRequest request, Orderinit orderinit) {
        JSONObject json = new JSONObject();
        int code = 100;
        orderinitService.modifyOrderinitByAdmin(orderinit);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "updateOrderinitByEffecitve", method = RequestMethod.POST)
    public void updateOrderinitByEffecitve(HttpServletResponse response, HttpServletRequest request, Orderinit orderinit) {
        JSONObject json = new JSONObject();
        int code = 100;
        String getsale=orderinitService.modifyOrderinitByEffecitve(orderinit);//'sale_id'  or   nosale
        json.put("code", code);
        json.put("getsale",getsale);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 分配毛单
     *
     * @param response
     * @param request
     * @param ids
     */
    @RequestMapping(value = "assignOrder", method = RequestMethod.POST)
    public void assignOrder(HttpServletResponse response, HttpServletRequest request, String[] ids, String staff_id) {
        JSONObject json = new JSONObject();
        int count = 0;
        int code = 100;
        for (String id : ids) {
            if (orderinitService.checkedOrderState(id).compareTo("未分配") == 0) {
                orderinitService.assignOrders(id, staff_id);
                count++;
            } else {
                code = 101;
                break;
            }
        }
        json.put("code", code);
        json.put("count", count);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }












    //营销人员根据自己id查找自己的毛单
    @RequestMapping(value = "findAllOrderById", method = RequestMethod.GET)
    public void findAllOrderById(HttpServletRequest request, HttpServletResponse response, int page, int limit, String field, String order, String key, String[] filter, String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(order_init_id,'')";
        }
        if (key == null) {
            key = "concat(concat('%%'))" + " and order_staff_id = " + "'" + staff_id + "'";
        } else {
            key = "concat(concat('%" + key + "%'))" + " and order_staff_id = " + "'" + staff_id + "'";
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "effective asc,assign_staff_name asc , entry_real";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<Orderinit> list = orderinitService.findAllOrderById(selectEntity);
        int num = orderinitService.findOrderNumById(selectEntity);
        JSONObject json = new JSONObject();
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", 0);
        json.put("count", num);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 销售人员查询被分配的毛单
     * @param request
     * @param response
     * @param page
     * @param limit
     * @param field
     * @param order
     * @param key
     * @param filter
     * @param staff_id
     */
    @RequestMapping(value = "findAllOrderByAssginId", method = RequestMethod.GET)
    public void findAllOrderByAssginId(HttpServletRequest request, HttpServletResponse response, int page, int limit, String field, String order, String key, String[] filter, String staff_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(order_init_id,'')";
        }
        if (key == null) {
            key = "concat(concat('%%'))" + " and assign_staff_id = " + "'" + staff_id + "'";
        } else {
            key = "concat(concat('%" + key + "%'))" + " and assign_staff_id = " + "'" + staff_id + "'";
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "effective asc,assign_time";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<Orderinit> list = orderinitService.findAllOrderByAssginId(selectEntity);
        int num = orderinitService.findOrderNumByAssginId(selectEntity);
        JSONObject json = new JSONObject();
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", 0);
        json.put("count", num);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 管理员根据校区查找初始单（分配了但是没有打电话---有效性没有确定的毛单）
     * @param request
     * @param response
     * @param page
     * @param limit
     * @param field
     * @param order
     * @param key
     * @param filter
     * @param staff_id
     * @param campus_id
     */
    @RequestMapping(value = "findAllOrderinit", method = RequestMethod.GET)
    public void findAllOrderinit(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                            String field, String order, String key, String[] filter,String staff_id, String campus_id) {
        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(order_init_id,'')";
        }
        if (campus_id == "") {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and effective is null and state='已分配'  ";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "')and effective is null and state='已分配' ";
            }
        } else {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and effective is null and state='已分配' ";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and effective is null and state='已分配' ";
            }
        }
        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "assign_staff_name ASC, entry_real ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<Orderinit> list = orderinitService.findAllOrderinit(selectEntity);
        int num = orderinitService.getAllOrderinitNumber(selectEntity);
        JSONObject json = new JSONObject();
        JsonConfig jsonConfig = JsonUtils.jsonIntAndDouble();
        JSONArray data = JSONArray.fromObject(list,jsonConfig);
        json.put("code", 0);
        json.put("count",num);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    /**
     * 转换销售单
     *
     * @param response
     * @param request
     * @param ids
     */
    @RequestMapping(value = "transformSale", method = RequestMethod.GET)
    public void transformSale(HttpServletResponse response, HttpServletRequest request, String[] ids, TransRecord transRecord) {
        JSONObject json = new JSONObject();
        int count = 0;
        int code = 100;
        for (String id : ids) {
            transRecord.setOrder_init_id(id);
            orderinitService.transformSales(transRecord);
            count++;
        }
        json.put("code", code);
        json.put("count", count);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 转换初始单
     *
     * @param response
     * @param request
     * @param ids
     */
    @RequestMapping(value = "transformOrder", method = RequestMethod.GET)
    public void transformOrder(HttpServletResponse response, HttpServletRequest request, String[] ids, TransRecord transRecord) {
        JSONObject json = new JSONObject();
        int count = 0;
        int code = 100;
        for (String id : ids) {
            transRecord.setOrder_init_id(id);
            orderinitService.transformOrders(transRecord);
            count++;
        }
        json.put("code", code);
        json.put("count", count);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//-------营销 毛单跟踪


    @RequestMapping(value = "findSaleByOrderinit", method = RequestMethod.GET)
    public void findSaleByOrderinit(HttpServletResponse response, HttpServletRequest request, String order_init_id) {
        response.setCharacterEncoding("UTF-8");

        int code ;
        Sale sale = orderinitService.findSaleByOrderinit(order_init_id);
        if (sale!=null){
            code = 100;//这个毛单有对应的sale单
        }else{
            code=101;//这个毛单没有对应的sale单
        }


        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("data", sale);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//-----营销  我的毛单统计

    @RequestMapping(value = "findAllMyOrderInitStatisticsList", method = RequestMethod.GET)
    public void findAllMyOrderInitStatisticsList(HttpServletResponse response, int page, int limit, String field, String order, String key,
                                          String[] filter, String staff_id ) {

        String sql = "";
        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(orderinit_state_one,'')";
        }

        if (key == null) {
            key = "concat(concat('%%'))" + " and staff_id  = '" + staff_id + "'";
        } else {
            key = "concat(concat('%" + key + "%'))" + " and staff_id  = '" + staff_id + "'";
        }

        sql = "CONCAT(" + sql + ")";
        response.setCharacterEncoding("UTF-8");
        SelectEntity selectEntity = new SelectEntity();
        selectEntity.setStart((page - 1) * limit);
        selectEntity.setLimit(limit);
        selectEntity.setKey(key);
        selectEntity.setSql(sql);
        if (field == null) {
            field = "orderinit_state_one";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        List<ChanStatistics> list =orderinitService.findAllMyOrderInitStatisticsList(selectEntity);
        int num = orderinitService.getAllMyOrderInitStatisticsNumber(selectEntity);
        JSONObject json = new JSONObject();
        JsonConfig jsonConfig = JsonUtils.jsonIntAndDouble();
        JSONArray data = JSONArray.fromObject(list,jsonConfig);
        json.put("code", 0);
        json.put("count",num);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "updateStatisticsByTime", method = RequestMethod.GET)
    public void updateStatisticsByTime(HttpServletResponse response,String time_start,String time_end,String staff_id ) {
        response.setCharacterEncoding("UTF-8");
        int code = 100;
        JSONObject json = new JSONObject();
        orderinitService.updateStatisticsByTime(time_start,time_end,staff_id);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






















    //毛单批量导入
    @RequestMapping(value = "importOrderinit", method = RequestMethod.POST)
    public void importOrderinit(HttpServletResponse response, HttpServletRequest request, String order_staff_id) throws Exception {
        XSSFWorkbook workbook = null;
        JSONObject json = new JSONObject();
        response.setCharacterEncoding("UTF-8");

        //记录导入毛单个数
        int num=0;
        int num_have=0;
        //数字格式设计1.325->13256856464
        DataFormatter dataFormatter = new DataFormatter();
        dataFormatter.addFormat("###########", null);

        Orderinit orderinit= new Orderinit();
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {

                    //把MultipartFile转化为File
                    CommonsMultipartFile cmf = (CommonsMultipartFile) file;
                    DiskFileItem dfi = (DiskFileItem) cmf.getFileItem();
                    File fo = dfi.getStoreLocation();
                    //创建Excel，读取文件内容
                    workbook = new XSSFWorkbook(FileUtils.openInputStream(fo));
                    //获取第一个工作表
                    XSSFSheet sheet = workbook.getSheet("毛单");
                    //获取sheet中第一行行号
                    int firstRowNum = sheet.getFirstRowNum();
                    //获取sheet中最后一行行号
                    int lastRowNum = sheet.getLastRowNum();


                    try {

                        for (int i = firstRowNum + 5; i <= lastRowNum; i++) {
                            orderinit=new Orderinit();

                            orderinit.setOrder_staff_id(order_staff_id);

                            XSSFRow row = sheet.getRow(i);

                            XSSFCell customer_name = row.getCell(1);//家长姓名
                            if (customer_name != null) {
                                customer_name.setCellType(Cell.CELL_TYPE_STRING);
                                orderinit.setCustomer_name(customer_name.getStringCellValue());
                            }

                            XSSFCell contact = row.getCell(2);//客户联系方式
                            if (contact != null) {
                                String customer_contact = dataFormatter.formatCellValue(contact);
                                orderinit.setCustomer_contact(customer_contact);
                            }

                            XSSFCell student_name = row.getCell(3);//学生姓名
                            if (student_name != null) {
                                student_name.setCellType(Cell.CELL_TYPE_STRING);
                                orderinit.setStu_name(student_name.getStringCellValue());
                            }

                            XSSFCell student_age = row.getCell(4);//学生年龄
                            if (student_age != null) {
                                student_age.setCellType(Cell.CELL_TYPE_STRING);
                                orderinit.setStu_age(Integer.parseInt(student_age.getStringCellValue()));
                            }

                            XSSFCell student_school = row.getCell(5);//学生学校
                            if (student_school != null) {
                                student_school.setCellType(Cell.CELL_TYPE_STRING);
                                orderinit.setStu_school(student_school.getStringCellValue());
                            }

                            XSSFCell student_address = row.getCell(6);//学生住址
                            if (student_address != null) {
                                student_address.setCellType(Cell.CELL_TYPE_STRING);
                                orderinit.setAddress(student_address.getStringCellValue());
                            }


                            XSSFCell cell_channel_id = row.getCell(7);//渠道id
                            if (cell_channel_id != null) {
                                cell_channel_id.setCellType(Cell.CELL_TYPE_STRING);
                                String channel_id = cell_channel_id.getStringCellValue();
                                orderinit.setChannel_id(channel_id);
                            }

                            XSSFCell cell_marketing_id = row.getCell(8);//活动id
                            if (cell_marketing_id != null) {
                                cell_marketing_id.setCellType(Cell.CELL_TYPE_STRING);
                                String marketing_id = cell_marketing_id.getStringCellValue();
                                orderinit.setMarketing_id(marketing_id);
                            }

                            XSSFCell collect_name = row.getCell(9);//收集人员
                            if (collect_name != null) {
                                collect_name.setCellType(Cell.CELL_TYPE_STRING);
                                orderinit.setCollect_name(collect_name.getStringCellValue());
                            }

                            XSSFCell tel = row.getCell(10);//收集人员联系方式
                            if (tel != null) {
                                String collect_tel = dataFormatter.formatCellValue(tel);
                                orderinit.setCollect_tel(collect_tel);
                            }

                            /*XSSFCell entry_date = row.getCell(11);//录入日期
                            if (entry_date != null) {
                                orderinit.setEntry_date(HSSFDateUtil.getJavaDate(entry_date.getNumericCellValue()));
                            }*/


                            if (customer_name==null||customer_name.equals("")||customer_name.getStringCellValue().equals("")){

                                break ;
                            }
                            int temp=orderinitService.addOrderinit(orderinit);
                            if (temp==1){
                                num++;
                            }else {
                                num_have++;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        workbook.close();
                    }
                }
            }
        }
        json.put("code", 100);
        json.put("num", num);
        json.put("num_have", num_have);
        try {
            response.getWriter().print(json);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

