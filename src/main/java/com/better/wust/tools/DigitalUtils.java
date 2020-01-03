package com.better.wust.tools;

import java.text.NumberFormat;

public class DigitalUtils {

    /**
     * 小数转换成百分数
     */
    public static String decimalToPercentage(double ratio){
        NumberFormat nf = NumberFormat.getPercentInstance();
        //这个1的意识是保存结果到小数点后几位，但是特别声明：这个结果已经先＊100了。
        nf.setMaximumFractionDigits(0);
        //自动四舍五入。
        return nf.format(ratio + 0.00000001);
    }
}
