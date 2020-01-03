package com.better.wust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


@RequestMapping("file")
@Controller
public class FileController {
    /**
     * 下载文件
     *
     * @param path
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "downLoadFile", method = RequestMethod.GET)
    public void downLoadFile(String path, String fileName, String remark, HttpServletResponse response) throws Exception {
        File f = new File(path);
        if (fileName == null) {
            fileName = f.getName();
        } else {
            fileName += "-" + remark;
            fileName += "." + f.getName().substring(f.getName().lastIndexOf(".") + 1);
        }
        InputStream inStream = new FileInputStream(f);
        response.reset();
        response.setContentType("bin");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查看文件
     * @param response
     * @param path
     * @throws Exception
     */
    @RequestMapping(value = "getFile", method = RequestMethod.GET)
    public static void getPhoto(HttpServletResponse response, String path) throws Exception {
        String type = "";
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        if (fileType.equals("png") || fileType.equals("Png") || fileType.equals("PNG") || fileType.equals("Jpg")
                || fileType.equals("jpg") || fileType.equals("JPG")) {
            type="image/"+fileType;
        }else if (fileType.equals("pdf")){
            type="application/pdf";
        }
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fis;
            fis = new FileInputStream(file);
            long size = file.length();
            byte[] temp = new byte[(int) size];
            fis.read(temp, 0, (int) size);
            fis.close();
            byte[] data = temp;
            response.setContentType(type);
            OutputStream out = response.getOutputStream();
            out.write(data);
            out.flush();
            out.close();
        }else {
            response.getWriter().println("找不到文件");
        }
    }
}
