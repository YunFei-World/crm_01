package com.better.wust.service.Impl;

import com.better.wust.dao.StaffDao;
import com.better.wust.dao.StaffStatisticsDao;
import com.better.wust.entity.*;
import com.better.wust.service.StaffStatisticsService;
import com.better.wust.tools.DateUtils;
import com.better.wust.tools.DigitalUtils;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffStatisticsServiceImpl implements StaffStatisticsService {

    @Autowired
    private StaffStatisticsDao staffStatisticsDao;

    @Autowired
    private StaffDao staffDao;

    private static String[] week = {"第一周", "第二周", "第三周", "第四周", "第五周", "第六周"};




    //时间段
    @Override
    public List<StaffStatisticsTime> findAllStaffTimeStatisticsList(SelectEntity selectEntity) {
        return staffStatisticsDao.findAllStaffTimeStatisticsList(selectEntity);
    }

    @Override
    public int getAllStaffTimeStatisticsNumber(SelectEntity selectEntity) {
        return staffStatisticsDao.getAllStaffTimeStatisticsNumber(selectEntity);
    }


    @Override
    public void updateStatisticsByTime(String time_start, String time_end,String staff_id ,String campus_id) {

        List<Staff> list = staffDao.selectAllSaleStaffs(staff_id, campus_id);
        time_end=time_end+" 23:59:59";
        for (Staff staff:list){
            int sum_num=staffStatisticsDao.statisticsSumNumByTime(time_start,time_end,staff.getStaff_id());
            int tel_num=staffStatisticsDao.statisticsTelNumByTime(time_start,time_end,staff.getStaff_id());
            int effective=staffStatisticsDao.statisticsEffectiveNumByTime(time_start,time_end,staff.getStaff_id());
            int follow_up_effective=staffStatisticsDao.statisticsFollowUpEffectiveNumByTime(time_start,time_end,staff.getStaff_id());
            int direct_shop=staffStatisticsDao.statisticsDirectShopNumByTime(time_start,time_end,staff.getStaff_id());
            int brought_shop=staffStatisticsDao.statisticsBroughtShopNumByTime(time_start,time_end,staff.getStaff_id());
            int invitation_shop=staffStatisticsDao.statisticsInvitationShopNumByTime(time_start,time_end,staff.getStaff_id());
            int actual_shop=staffStatisticsDao.statisticsActualShopNumByTime(time_start,time_end,staff.getStaff_id());
            int sign_up=staffStatisticsDao.statisticsSignUpNumByTime(time_start,time_end,staff.getStaff_id());

            double tel_effective_proportion;
            double to_shop_proportion;
            double to_shop_to_sign_proportion;
            if (tel_num!=0){
                tel_effective_proportion=(double) effective/tel_num;
            }else {
                tel_effective_proportion=0;
            }

            if (invitation_shop!=0){
                to_shop_proportion=(double) actual_shop/invitation_shop;
            }else {
                to_shop_proportion=0;
            }

            if ((direct_shop+brought_shop+actual_shop)!=0){
                to_shop_to_sign_proportion=(double) sign_up/(direct_shop+brought_shop+actual_shop);
            }else {
                to_shop_to_sign_proportion=0;
            }

            StaffStatisticsTime staffStatisticsTime=new StaffStatisticsTime();

            staffStatisticsTime.setStaff_id(staff.getStaff_id());
            staffStatisticsTime.setCampus_id(staff.getCampus_id());

            staffStatisticsTime.setSum_num(sum_num);
            staffStatisticsTime.setTel_num(tel_num);
            staffStatisticsTime.setEffective(effective);
            staffStatisticsTime.setFollow_up_effective(follow_up_effective);
            staffStatisticsTime.setDirect_shop(direct_shop);
            staffStatisticsTime.setBrought_shop(brought_shop);
            staffStatisticsTime.setInvitation_shop(invitation_shop);
            staffStatisticsTime.setActual_shop(actual_shop);
            staffStatisticsTime.setSign_up(sign_up);

            staffStatisticsTime.setTel_effective_proportion(tel_effective_proportion);
            staffStatisticsTime.setTo_shop_proportion(to_shop_proportion);
            staffStatisticsTime.setTo_shop_to_sign_proportion(to_shop_to_sign_proportion);

            staffStatisticsTime.setTime_start(time_start);
            staffStatisticsTime.setTime_end(time_end);

            StaffStatisticsTime isExit=staffStatisticsDao.statisticsTimeIsExist(staff.getStaff_id(),staff.getCampus_id());

            if (isExit!=null){
                staffStatisticsDao.updateStatisticsByTime(staffStatisticsTime);
            }else{
                staffStatisticsDao.insertStatisticByTime(staffStatisticsTime);
            }

        }


    }
    //时间段  end


    //月-周统计
    @Override
    public int statisticsStaffMonth(StaffStatisticsMonth staffStatisticsMonth) {
        String month=staffStatisticsMonth.getMonth();
        String week_date[] = DateUtils.countWeekToDate(month);
        /*
        //计算周数对应该月的日期
        int weeks = staffStatisticsMonth.getWeeks() - 1;
        if (weeks * 2 >= week_date.length) {
            return 101;
        }*/
        int weekone=0;
        int weektwo=1;
        int weekthree=2;
        int weekfour=3;
        int weekfive=4;
        int weeksix=5;




        String time_start_one = week_date[weekone * 2];
        String time_end_one = week_date[weekone * 2 + 1];


        String time_start_two = week_date[weektwo * 2];
        String time_end_two = week_date[weektwo * 2 + 1];

        String time_start_three = week_date[weekthree * 2];
        String time_end_three = week_date[weekthree * 2 + 1];

        String time_start_four = week_date[weekfour * 2];
        String time_end_four = week_date[weekfour * 2 + 1];




        String time_start_five="";
        String time_end_five="";
        if (week_date.length>=10){
            time_start_five= week_date[weekfive * 2];
            time_end_five= week_date[weekfive * 2 + 1];
        }



        String time_start_six="";
        String time_end_six="";
        if (week_date.length>10){
             time_start_six = week_date[weeksix * 2];
             time_end_six = week_date[weeksix * 2 + 1];
        }


        String campus_id = staffStatisticsMonth.getCampus_id() + "";
        if ("-1".equals(campus_id)) {
            campus_id = "";
        }
        //查找该校区所有员工
        List<Staff> list = staffDao.selectAllSaleStaffs(staffStatisticsMonth.getStaff_id(), campus_id);

        for (Staff staff : list) {
            String staff_id = staff.getStaff_id();
            staffStatisticsMonth.setStaff_id(staff_id);

            //用于判断此员工 此月 是不是已经统计过 即统计表中有没有此条件数据
            StaffStatisticsMonth isExist=staffStatisticsDao.statisticsMonthIsExist(staffStatisticsMonth.getMonth(),staff_id);

            //此统计为一个月的时间
            int sum_num=staffStatisticsDao.statisticsSumNumByMonth(month,staff_id);
            int tel_num=staffStatisticsDao.statisticsTelNumByMonth(month,staff_id);
            int effective=staffStatisticsDao.statisticsEffectiveNumByMonth(month,staff_id);
            int follow_up_effective=staffStatisticsDao.statisticsFollowUpEffectiveNumByMonth(month,staff_id);
            int direct_shop=staffStatisticsDao.statisticsDirectShopNumByMonth(month,staff_id);
            int brought_shop=staffStatisticsDao.statisticsBroughtShopNumByMonth(month,staff_id);
            int invitation_shop=staffStatisticsDao.statisticsInvitationShopNumByMonth(month,staff_id);
            int actual_shop=staffStatisticsDao.statisticsActualShopNumByMonth(month,staff_id);
            int sign_up=staffStatisticsDao.statisticsSignUpNumByMonth(month,staff_id);

            double tel_effective_proportion;
            double to_shop_proportion;
            double to_shop_to_sign_proportion;
            if (tel_num!=0){
                tel_effective_proportion=(double) effective/tel_num;
            }else {
                tel_effective_proportion=0;
            }

            if (invitation_shop!=0){
                to_shop_proportion=(double) actual_shop/invitation_shop;
            }else {
                to_shop_proportion=0;
            }

            if ((direct_shop+brought_shop+actual_shop)!=0){
                to_shop_to_sign_proportion=(double) sign_up/(direct_shop+brought_shop+actual_shop);
            }else {
                to_shop_to_sign_proportion=0;
            }

            double week_one_actual;
            double week_two_actual;
            double week_three_actual;
            double week_four_actual;
            double week_five_actual=0;
            double week_six_actual=0;

            if (staffStatisticsDao.statisticsSaleMoneyByTime(time_start_one, time_end_one,staff_id )!=null){
                week_one_actual =  staffStatisticsDao.statisticsSaleMoneyByTime(time_start_one, time_end_one,staff_id );
            }else{
                week_one_actual=0;
            }

            if (staffStatisticsDao.statisticsSaleMoneyByTime(time_start_two, time_end_two,staff_id )!=null){
                week_two_actual =  staffStatisticsDao.statisticsSaleMoneyByTime(time_start_two, time_end_two,staff_id );
            }else{
                week_two_actual=0;
            }

            if (staffStatisticsDao.statisticsSaleMoneyByTime(time_start_three, time_end_three,staff_id )!=null){
                week_three_actual =  staffStatisticsDao.statisticsSaleMoneyByTime(time_start_three, time_end_three,staff_id );
            }else{
                week_three_actual=0;
            }

            if (staffStatisticsDao.statisticsSaleMoneyByTime(time_start_four, time_end_four,staff_id )!=null){
                week_four_actual =  staffStatisticsDao.statisticsSaleMoneyByTime(time_start_four, time_end_four,staff_id );
            }else{
                week_four_actual=0;
            }

            if (week_date.length>=10){
                if (staffStatisticsDao.statisticsSaleMoneyByTime(time_start_five, time_end_five,staff_id )!=null){
                    week_five_actual =  staffStatisticsDao.statisticsSaleMoneyByTime(time_start_five, time_end_five,staff_id );
                }else{
                    week_five_actual=0;
                }
            }

            if (week_date.length>10){
                if (staffStatisticsDao.statisticsSaleMoneyByTime(time_start_six, time_end_six,staff_id )!=null){
                    week_six_actual =  staffStatisticsDao.statisticsSaleMoneyByTime(time_start_six, time_end_six,staff_id );
                }else{
                    week_six_actual=0;
                }
            }




            double month_task;
            double month_actual;
            double month_proportion;
            double week_one;
            double week_two;
            double week_three;
            double week_four;
            double week_five;
            double week_six;

            SaleTask saleTask=staffStatisticsDao.findSaleTaskByMonth(month,staff_id);

            if (staffStatisticsDao.statisticsSaleMoneyByMonth(month,staff_id )!=null){
                month_actual =  staffStatisticsDao.statisticsSaleMoneyByMonth(month,staff_id );
            }else{
                month_actual=0;
            }

            if (saleTask!=null){
                if (saleTask.getMonth_task()!=null){
                    month_task=saleTask.getMonth_task();
                }else{
                    month_task=0;
                }

                if (saleTask.getWeek_one()!=null){
                    week_one=saleTask.getWeek_one();
                }else{
                    week_one=0;
                }

                if (saleTask.getWeek_two()!=null){
                    week_two=saleTask.getWeek_two();
                }else{
                    week_two=0;
                }
                if (saleTask.getWeek_three()!=null){
                    week_three=saleTask.getWeek_three();
                }else{
                    week_three=0;
                }
                if (saleTask.getWeek_four()!=null){
                    week_four=saleTask.getWeek_four();
                }else{
                    week_four=0;
                }
                if (saleTask.getWeek_five()!=null){
                    week_five=saleTask.getWeek_five();
                }else{
                    week_five=0;
                }
                if (saleTask.getWeek_six()!=null){
                    week_six=saleTask.getWeek_six();
                }else{
                    week_six=0;
                }
            }else{
                month_task=0;
                week_one=0;
                week_two=0;
                week_three=0;
                week_four=0;
                week_five=0;
                week_six=0;
            }

            if (month_task!=0){
                month_proportion=(double) month_actual/month_task;
            }else {
                month_proportion=0;
            }

            double average_sale;

            if (sign_up!=0){
                average_sale=month_actual/sign_up;
            }else{
                average_sale=0;
            }


            staffStatisticsMonth.setSum_num(sum_num);
            staffStatisticsMonth.setTel_num(tel_num);
            staffStatisticsMonth.setEffective(effective);
            staffStatisticsMonth.setFollow_up_effective(follow_up_effective);
            staffStatisticsMonth.setDirect_shop(direct_shop);
            staffStatisticsMonth.setBrought_shop(brought_shop);
            staffStatisticsMonth.setInvitation_shop(invitation_shop);
            staffStatisticsMonth.setActual_shop(actual_shop);
            staffStatisticsMonth.setSign_up(sign_up);

            staffStatisticsMonth.setTel_effective_proportion(tel_effective_proportion);
            staffStatisticsMonth.setTo_shop_proportion(to_shop_proportion);
            staffStatisticsMonth.setTo_shop_to_sign_proportion(to_shop_to_sign_proportion);

            staffStatisticsMonth.setMonth_task(month_task);
            staffStatisticsMonth.setMonth_actual(month_actual);
            staffStatisticsMonth.setMonth_proportion(month_proportion);

            staffStatisticsMonth.setWeek_one(week_one);
            staffStatisticsMonth.setWeek_two(week_two);
            staffStatisticsMonth.setWeek_three(week_three);
            staffStatisticsMonth.setWeek_four(week_four);
            staffStatisticsMonth.setWeek_five(week_five);
            staffStatisticsMonth.setWeek_six(week_six);


            staffStatisticsMonth.setWeek_one_actual(week_one_actual);
            staffStatisticsMonth.setWeek_two_actual(week_two_actual);
            staffStatisticsMonth.setWeek_three_actual(week_three_actual);
            staffStatisticsMonth.setWeek_four_actual(week_four_actual);
            staffStatisticsMonth.setWeek_five_actual(week_five_actual);
            staffStatisticsMonth.setWeek_six_actual(week_six_actual);

            staffStatisticsMonth.setAverage_sale(average_sale);

           /* //此月的开始时间和结束时间
            staffStatisticsMonth.setStart_date(time_start);
            staffStatisticsMonth.setEnd_date(time_end);*/

            if (isExist != null) {
                staffStatisticsDao.updateStatisticsByMonth(staffStatisticsMonth);
            } else {
                staffStatisticsDao.insertStaffStatisticsMonth(staffStatisticsMonth);
            }
        }
        return 100;
    }

    @Override
    public List<StaffStatisticsMonth> getStatisticsStaffMonth(SelectEntity selectEntity) {
        return staffStatisticsDao.selectStaffStatisticsMonth(selectEntity);
    }

    @Override
    public int getStatisticsStaffMonthNumber(SelectEntity selectEntity) {
        return staffStatisticsDao.selectStaffStatisticsMonthNumber(selectEntity);
    }
    //月-周统计 end




}
