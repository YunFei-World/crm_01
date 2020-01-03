package com.better.wust.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Zhao
 */
public class DateUtils {

    /**
     * 日期转换成字符串
     */
    public static String dateToString(Date date,String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 字符串转换成日期
     */
    public static Date stringToDate(String str,String patt) throws ParseException {
        return new SimpleDateFormat(patt).parse(str);
    }

    /**
     * 计算每月每周对应日期
     */
    public static String[] countWeekToDate(String month_string) {
        int year = Integer.parseInt(month_string.split("-")[0]);
        int month = Integer.parseInt(month_string.split("-")[1]);
        int days = getDaysByYearMonth(year, month);
        int weeks = getWeeksByYearMonth(year, month);
        int date = dateToWeek(year, month);
        String[] weeksDate = new String[weeks * 2];
        String str;
        int weekNum = 1;

        if (month < 10) {
            str = "-0";
        } else {
            str = "-";
        }
        //year-month-week
        String weekStart = year + str + month + "-0" + weekNum;
        weeksDate[0] = weekStart;
        weekNum = 7 - date + weekNum;
        String weekEnd = year + str + month + "-0" + weekNum;
        weeksDate[1] = weekEnd;

        for (int i = 1; i < weeks; i++) {
            weekNum = weekNum + 1;
            if (weekNum < 10) {
                weekStart = year + str + month + "-0" + weekNum;
            } else {
                weekStart = year + str + month + "-" + weekNum;
            }
            weeksDate[2 * i] = weekStart;
            weekNum += 6;
            if (weekNum <= days) {
                if (weekNum < 10) {
                    weekEnd = year + str + month + "-0" + weekNum;
                } else {
                    weekEnd = year + str + month + "-" + weekNum;
                }
            } else {
                weekNum = days;
                weekEnd = year + str + month + "-" + weekNum;
            }
            weeksDate[2 * i + 1] = weekEnd;
        }
        return weeksDate;
    }

    /**
     * 根据年月获取对应的月份的天数
     */
    public static int getDaysByYearMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days;
    }

    /**
     * 根据年月获取对应的月份的周数
     */
    public static int getWeeksByYearMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        int weeks = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
        return weeks;
    }

    /**
     * 根据日期获取对应的星期数
     */
    public static int dateToWeek(int year, int month) {
        int[] date = { 7, 1, 2, 3, 4, 5, 6 };
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0) {
            w = 0;
        }
        return date[w];
    }

}
