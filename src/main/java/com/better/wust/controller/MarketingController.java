package com.better.wust.controller;

import com.better.wust.entity.Channel;
import com.better.wust.entity.Marketing;
import com.better.wust.entity.Orderinit;
import com.better.wust.service.MarketingService;
import com.better.wust.tools.JsonUtils;
import com.better.wust.tools.StaticValues;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("marketing")
public class MarketingController {

    @Autowired
    private MarketingService marketingService;


    @RequestMapping(value = "updateMarketingStatistics", method = RequestMethod.GET)
    public void updateMarketingStatistics(HttpServletResponse response, HttpServletRequest request) {
        JSONObject json = new JSONObject();
        int code = 0;
        response.setCharacterEncoding("UTF-8");
        marketingService.updateMarketingStatistics();
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "findAllMarketingStatisticsList", method = RequestMethod.GET)
    public void findAllMarketingStatisticsList(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                              String field, String order, String key, String[] filter,String staff_id,String campus_id,String channel_id) {

        //在管理员界面----活动表中包含了需要统计的属性  查询表单前  先自动统计一遍所有活动各自有效数量
        marketingService.updateMarketingStatistics();

        String sql = "";

        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(marketing_id,'')";
        }
        if (campus_id == "") {
            if (key == null) {
                if(channel_id==""){
                    key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and state=0 and channel_id IN (SELECT channel_id FROM channel WHERE campus_id='"+campus_id+"')";

                }else{
                    key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and state=0 and channel_id='"+channel_id+"'";

                }
            } else {
                if (channel_id==""){
                    key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and state=0 and channel_id IN (SELECT channel_id FROM channel WHERE campus_id='"+campus_id+"')";
                }else{
                    key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and state=0 and channel_id='"+channel_id+"'";
                }
            }
        } else {
            if (key == null) {
                if (channel_id==""){
                    key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and state=0 and channel_id IN (SELECT channel_id FROM channel WHERE campus_id='"+campus_id+"')";
                }else{
                    key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and state=0 and channel_id='"+channel_id+"'";
                }

            } else {
                if (channel_id==""){
                    key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and state=0 and channel_id IN (SELECT channel_id FROM channel WHERE campus_id='"+campus_id+"')";
                }else {
                    key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and state=0 and channel_id='"+channel_id+"'";
                }
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
            field = "marketing_id";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<Marketing> list = marketingService.findAllMarketingList(selectEntity);
        int num = marketingService.getAllMarketingNumber(selectEntity);
        JSONObject json = new JSONObject();
        JsonConfig jsonConfig = JsonUtils.jsonIntAndDouble();
        JSONArray data = JSONArray.fromObject(list,jsonConfig);
        json.put("code", 0);
        json.put("count", num);
        json.put("data", data);

        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(value = "findAllMarketingNameByChannel", method = RequestMethod.GET)
    public void findAllMarketingNameByChannel(HttpServletResponse response, HttpServletRequest request, String channel_id) {
        JSONObject json = new JSONObject();
        int code = 100;
        response.setCharacterEncoding("UTF-8");
        List<Marketing> list = marketingService.findAllMarketingNameByChannel(channel_id);
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", code);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //在营销界面显示
    //在管理界面显示
    @RequestMapping(value = "findMyMarketingList", method = RequestMethod.GET)
    public void findMyMarketingList(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                              String field, String order, String key, String[] filter,String staff_id,String campus_id) {
        String sql = "";

        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(marketing_id,'')";
        }
        if (campus_id==null) {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM staff WHERE staff_id = '" + staff_id + "') and state=0";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM staff WHERE staff_id = '" + staff_id + "') and state=0";
            }
        } else {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and state=0";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and state=0";
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
            field = "marketing_date asc ,marketing_id ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<Marketing> list = marketingService.findAllMarketingList(selectEntity);
        int num = marketingService.getAllMarketingNumber(selectEntity);
        JSONObject json = new JSONObject();
        JsonConfig jsonConfig = JsonUtils.jsonIntAndDouble();
        JSONArray data = JSONArray.fromObject(list,jsonConfig);
        json.put("code", 0);
        json.put("count", num);
        json.put("data", data);

        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //在管理界面显示
    @RequestMapping(value = "findAllMarketingList", method = RequestMethod.GET)
    public void findAllStaffs(HttpServletRequest request, HttpServletResponse response, int page, int limit,
                              String field, String order, String key, String[] filter,String staff_id,String campus_id) {
        String sql = "";

        if (filter != null) {
            for (int i = 0; i < filter.length; i++) {
                filter[i] = "IFNULL(" + filter[i] + ",'')";
            }
            sql = String.join(",", filter);
        } else {
            sql = "IFNULL(marketing_id,'')";
        }
        if (campus_id == "") {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and state=0";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id IN (SELECT campus_id FROM campus_manage WHERE staff_id = '" + staff_id + "') and state=0";
            }
        } else {
            if (key == null) {
                key = "concat(concat('%%'))" + " and campus_id  = '" + campus_id + "' and state=0";
            } else {
                key = "concat(concat('%" + key + "%'))" + " and campus_id  = '" + campus_id + "' and state=0";
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
            field = "marketing_date asc ,marketing_id ";
            order = "asc";
        }
        selectEntity.setField(field);
        selectEntity.setOrder(order);
        // 执行查询
        List<Marketing> list = marketingService.findAllMarketingList(selectEntity);
        int num = marketingService.getAllMarketingNumber(selectEntity);
        JSONObject json = new JSONObject();
        JsonConfig jsonConfig = JsonUtils.jsonIntAndDouble();
        JSONArray data = JSONArray.fromObject(list,jsonConfig);
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
     * 添加一个新市场活动
     *
     * @param response
     * @param request
     * @param marketing
     */
    @RequestMapping(value = "addMarketing", method = RequestMethod.POST)
    public void addMarketing(HttpServletResponse response, HttpServletRequest request, Marketing marketing) {
        JSONObject json = new JSONObject();
        int code = 100;
        String id = "";
        id = marketingService.addMarketing(marketing);
        json.put("id", id);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新市场活动
     *
     * @param response
     * @param request
     * @param marketing
     */
    @RequestMapping(value = "updateMarketing", method = RequestMethod.POST)
    public void updateMarketing(HttpServletResponse response, HttpServletRequest request, Marketing marketing ) {
        JSONObject json = new JSONObject();
        int code = 100;
        String marketing_id = "";
        marketing_id = marketing.getMarketing_id();
        marketingService.modifyMarketing(marketing);

        json.put("marketing_id",marketing_id);
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param response
     * @param request
     * @param ids
     */
    @RequestMapping(value = "delMarketing", method = RequestMethod.POST)
    public void delAddress(HttpServletResponse response, HttpServletRequest request, String[] ids) {
        JSONObject json = new JSONObject();
        int code = 100;
        try {
            for (String id : ids) {
                marketingService.removeMarketing(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            code = 101;
        }
        json.put("code", code);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传备用文件
     *
     * @param response
     * @param request
     * @param marketing
     */
    @RequestMapping(value = "uploadOption", method = RequestMethod.POST)
    public void uploadContract(HttpServletResponse response, HttpServletRequest request, Marketing marketing, String name) {
        JSONObject json = new JSONObject();
        response.setCharacterEncoding("UTF-8");
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
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    try {
                        myFileName = new String(myFileName.getBytes("ISO-8859-1"), "UTF-8");
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        // 定义上传路径
                        try {
                            File file2 = new File(StaticValues.OPTOINS_DISK + marketing.getMarketing_id());
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            String fileName = (new Date()).getTime() + "."
                                    + myFileName.substring(myFileName.lastIndexOf(".") + 1);
                            String path = StaticValues.OPTOINS_DISK + marketing.getMarketing_id() + "/" + fileName;
                            marketing.setUrl_first(path);
                            // 存文件
                            File localFile = new File(path);
                            file.transferTo(localFile);
                            if (name.compareTo("option_first") == 0) {
                                marketing.setUrl_first(path);
                                marketingService.modifyUrl_first(marketing);
                            } else if (name.compareTo("option_second") == 0) {
                                marketing.setUrl_second(path);
                                marketingService.modifyUrl_second(marketing);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

        }
        json.put("code", 100);
        try {
            response.getWriter().print(json);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 更新职员基本信息
     *
     * @param response
     * @param request
     */
    @RequestMapping(value = "findAllMarketingName", method = RequestMethod.GET)
    public void findAllSaleStaff(HttpServletResponse response, HttpServletRequest request) {
        JSONObject json = new JSONObject();
        int code = 100;
        response.setCharacterEncoding("UTF-8");
        List<Marketing> list = marketingService.findAllMarketingNames();
        JSONArray data = JSONArray.fromObject(list);
        json.put("code", code);
        json.put("data", data);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


















    //活动批量导入
    @RequestMapping(value = "importMarketing", method = RequestMethod.POST)
    public void importMarketing(HttpServletResponse response, HttpServletRequest request) throws Exception {
        XSSFWorkbook workbook = null;
        JSONObject json = new JSONObject();
        response.setCharacterEncoding("UTF-8");
        //数字格式设计1.325->13256856464
        DataFormatter dataFormatter = new DataFormatter();
        dataFormatter.addFormat("###########", null);

        Marketing marketing= new Marketing();
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
                    XSSFSheet sheet = workbook.getSheet("活动表");
                    //获取sheet中第一行行号
                    int firstRowNum = sheet.getFirstRowNum();
                    //获取sheet中最后一行行号
                    int lastRowNum = sheet.getLastRowNum();


                    try {
                        for (int i = firstRowNum + 5; i <= lastRowNum; i++) {
                            marketing=new Marketing();



                            XSSFRow row = sheet.getRow(i);

                            XSSFCell marketing_name = row.getCell(1);//活动名称
                            if (marketing_name != null) {
                                marketing_name.setCellType(Cell.CELL_TYPE_STRING);
                                marketing.setMarketing_name(marketing_name.getStringCellValue());
                            }

                            XSSFCell marketing_place = row.getCell(2);//活动地点
                            if (marketing_place != null) {
                                marketing_place.setCellType(Cell.CELL_TYPE_STRING);
                                marketing.setMarketing_place(marketing_place.getStringCellValue());
                            }

                            XSSFCell channel_id = row.getCell(3);//渠道id
                            if (channel_id != null) {
                                channel_id.setCellType(Cell.CELL_TYPE_STRING);
                                marketing.setChannel_id(channel_id.getStringCellValue());
                            }

                            XSSFCell marketing_staff = row.getCell(4);//参与人员
                            if (marketing_staff != null) {
                                marketing_staff.setCellType(Cell.CELL_TYPE_STRING);
                                marketing.setMarketing_staff(marketing_staff.getStringCellValue());
                            }

                            XSSFCell marketing_content = row.getCell(5);//活动内容
                            if (marketing_content != null) {
                                marketing_content.setCellType(Cell.CELL_TYPE_STRING);
                                marketing.setMarketing_content(marketing_content.getStringCellValue());
                            }

                            XSSFCell marketing_node = row.getCell(6);//活动节点
                            if (marketing_node != null) {
                                marketing_node.setCellType(Cell.CELL_TYPE_STRING);
                                marketing.setMarketing_node(marketing_node.getStringCellValue());
                            }

                            XSSFCell marketing_fee = row.getCell(7);//活动费用
                            if (marketing_fee != null) {
                                marketing_fee.setCellType(Cell.CELL_TYPE_STRING);
                                marketing.setMarketing_fee(Double.parseDouble(marketing_fee.getStringCellValue()));
                            }

                            XSSFCell marketing_date = row.getCell(8);//活动时间
                            if (marketing_date != null) {
                                marketing.setMarketing_date(HSSFDateUtil.getJavaDate(marketing_date.getNumericCellValue()));
                            }

                            if (marketing_name==null||marketing_name.equals("")||marketing_name.getStringCellValue().equals("")){
                                break ;
                            }

                            //如果这个活动已经存在活动列表中
                           marketingService.addMarketing(marketing);
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
        try {
            response.getWriter().print(json);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }




}
