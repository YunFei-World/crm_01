package com.better.wust.tools;

import java.security.MessageDigest;

public class ToolMD5 {
    /**
     * 对字符串MD5加密（小写+字母）
     * @param s  要加密的字符串
     * @return  MD5加密后的字符串
     */
    public final static String getMD5(String s) {

        //十六进制下数字到字符的映射数组
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            //创建具有指定算法名称的信息摘要
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            //计算MD5函数
            mdTemp.update(strTemp);
            //获得密文
            byte[] md = mdTemp.digest();
            //将密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
	public static void main(String[] args) {

        /*String ss="1996-16-15";
        System.out.println(ss.length());
        System.out.println(ss.replace("-",""));
        System.out.println(ss.length());

        String sss="";
        for (int i=0;i<ss.length();i++){
            if (ss.charAt(i)!='-'){
                sss=sss+ss.charAt(i);
            }
        }
        System.out.println("sss"+sss);
        System.out.println(sss.length());
        System.out.println("19961615".length());
       System.out.println(getMD5("19961615"));
        System.out.println(getMD5("ss"));
        System.out.println(getMD5("sss"));*/



        String satff_id_str = "20191210001";

        String before=satff_id_str.substring(0,6);
        String after=satff_id_str.substring(6,satff_id_str.length());


        int num=(Integer.parseInt(after))+1;
        System.out.println(before);
        System.out.println(after);
        String numString=num+"";
        while(numString.length()<4){
            numString=0+numString;
        }
        System.out.println(numString);
        System.out.println(before+numString);



	}
}