package com.better.wust.service.Impl;

import com.better.wust.dao.SaleOneYearDao;
import com.better.wust.dao.SubjectCourseDao;
import com.better.wust.entity.SaleOneYearFirst;
import com.better.wust.entity.SaleOneYearSecond;
import com.better.wust.entity.SaleOneYearThird;
import com.better.wust.entity.Subject;
import com.better.wust.service.SaleOneYearService;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SaleOneYearServiceImpl implements SaleOneYearService {

    @Autowired
    private SaleOneYearDao saleOneYearDao;

    @Autowired
    private SubjectCourseDao subjectCourseDao;

    //--------------------------销售数据 First
    @Override
    public void updateSaleOneYearFirst(String year,Integer campus_id) {
        //前台传回来一个年份  如2019
        String month;
        Double target_sale_money;
        Double actual_sale_money;
        Double proportion_sale_money;

        Double proportion_sign_up;
        Integer target_initorder_num;
        Integer actual_initorder_num;
        Integer sign_up_num;
        Double average_sale_money;

        Integer refund_num;
        Double refund_money;
        Double proportion_refund;
        SaleOneYearFirst saleOneYearFirst;

        for (int i=1;i<=12;i++){
            if (i<10){
                month=year+"-0"+i;
            }else{
                month=year+"-"+i;
            }


            target_sale_money=saleOneYearDao.statisTargetSaleMoneyByMonth(month,campus_id);
            if (target_sale_money==null){
                target_sale_money=0.0;
            }
            actual_sale_money=saleOneYearDao.statisActualSaleMoneyByMonth(month,campus_id);
            if (actual_sale_money==null){
                actual_sale_money=0.0;
            }


            if (target_sale_money!=0.0){
                proportion_sale_money=actual_sale_money/target_sale_money;
            }else{
                proportion_sale_money=0.0;
            }

            target_initorder_num=saleOneYearDao.statisTargetInitorderNumByMonth(month,campus_id);
            if (target_initorder_num==null){
                target_initorder_num=0;
            }
            actual_initorder_num=saleOneYearDao.statisActualInitorderNumByMonth(month,campus_id);
            if (actual_initorder_num==null){
                actual_initorder_num=0;
            }


            sign_up_num=saleOneYearDao.statisSignUpNumByMonth(month,campus_id);
            if (sign_up_num==null){
                sign_up_num=0;
            }


            if (actual_initorder_num!=0){
                proportion_sign_up=(double)sign_up_num/actual_initorder_num;
            }else{
                proportion_sign_up=0.0;
            }

            if (sign_up_num!=0){
                average_sale_money=actual_sale_money/sign_up_num;
            }else{
                average_sale_money=0.0;
            }

            refund_num=saleOneYearDao.statisRefoundNumByMonth(month,campus_id);
            if (refund_num==null){
                refund_num=0;
            }
            refund_money=saleOneYearDao.statisRefoundMoneyByMonth(month,campus_id);
            if (refund_money==null){
                refund_money=0.0;
            }


            if (sign_up_num!=0){
                proportion_refund=(double)refund_num/sign_up_num;
            }else{
                proportion_refund=0.0;
            }


            saleOneYearFirst=new SaleOneYearFirst();

            saleOneYearFirst.setCampus_id(campus_id);
            saleOneYearFirst.setMonth(month);
            saleOneYearFirst.setTarget_sale_money(target_sale_money);
            saleOneYearFirst.setActual_sale_money(actual_sale_money);
            saleOneYearFirst.setProportion_sale_money(proportion_sale_money);

            saleOneYearFirst.setProportion_sign_up(proportion_sign_up);
            saleOneYearFirst.setTarget_initorder_num(target_initorder_num);
            saleOneYearFirst.setActual_initorder_num(actual_initorder_num);
            saleOneYearFirst.setSign_up_num(sign_up_num);
            saleOneYearFirst.setAverage_sale_money(average_sale_money);

            saleOneYearFirst.setRefund_num(refund_num);
            saleOneYearFirst.setRefund_money(refund_money);
            saleOneYearFirst.setProportion_refund(proportion_refund);

            saleOneYearDao.updateSaleOneYearFirst(saleOneYearFirst);

        }
    }

    @Override
    public List<SaleOneYearFirst> findAllSaleOneYearFirstList(SelectEntity selectEntity) {
        return saleOneYearDao.findAllSaleOneYearFirstList(selectEntity);
    }

    @Override
    public int getAllSaleOneYearFirstNum(SelectEntity selectEntity) {
        return saleOneYearDao.getAllSaleOneYearFirstNum(selectEntity);
    }






    //----------------------------报名人数产出 Second

    @Override
    public void updateSaleOneYearSecond(String year,Integer campus_id) {
        List<Subject> list = subjectCourseDao.findAllSubject();

        for (Subject subject:list){
             Integer January_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-01",subject.getId(),campus_id);
             Double January_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-01",subject.getId(),campus_id);
             if (January_subject_sale_money==null){
                 January_subject_sale_money=0.0;
             }


             Integer February_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-02",subject.getId(),campus_id);
             Double February_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-02",subject.getId(),campus_id);
            if (February_subject_sale_money==null){
                February_subject_sale_money=0.0;
            }

             Integer March_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-03",subject.getId(),campus_id);
             Double March_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-03",subject.getId(),campus_id);
            if (March_subject_sale_money==null){
                March_subject_sale_money=0.0;
            }

             Integer April_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-04",subject.getId(),campus_id);
             Double April_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-04",subject.getId(),campus_id);
            if (April_subject_sale_money==null){
                April_subject_sale_money=0.0;
            }

             Integer May_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-05",subject.getId(),campus_id);
             Double May_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-05",subject.getId(),campus_id);
            if (May_subject_sale_money==null){
                May_subject_sale_money=0.0;
            }


             Integer June_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-06",subject.getId(),campus_id);
             Double June_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-06",subject.getId(),campus_id);
            if (June_subject_sale_money==null){
                June_subject_sale_money=0.0;
            }

             Integer July_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-07",subject.getId(),campus_id);
             Double July_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-07",subject.getId(),campus_id);
            if (July_subject_sale_money==null){
                July_subject_sale_money=0.0;
            }

             Integer August_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-08",subject.getId(),campus_id);
             Double August_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-08",subject.getId(),campus_id);
            if (August_subject_sale_money==null){
                August_subject_sale_money=0.0;
            }

             Integer September_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-09",subject.getId(),campus_id);
             Double September_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-09",subject.getId(),campus_id);
            if (September_subject_sale_money==null){
                September_subject_sale_money=0.0;
            }

             Integer October_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-10",subject.getId(),campus_id);
             Double October_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-10",subject.getId(),campus_id);
            if (October_subject_sale_money==null){
                October_subject_sale_money=0.0;
            }

             Integer November_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-11",subject.getId(),campus_id);
             Double November_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-11",subject.getId(),campus_id);
            if (November_subject_sale_money==null){
                November_subject_sale_money=0.0;
            }



            Integer December_subject_sale_num=saleOneYearDao.statisticSubjectSaleNumByMonth(year+"-12",subject.getId(),campus_id);
             Double December_subject_sale_money=saleOneYearDao.statisticSubjectSaleMoneyByMonth(year+"-12",subject.getId(),campus_id);
            if (December_subject_sale_money==null){
                December_subject_sale_money=0.0;
            }


             SaleOneYearSecond saleOneYearSecond=new SaleOneYearSecond();

             saleOneYearSecond.setSubject_id(subject.getId());
             saleOneYearSecond.setCampus_id(campus_id);

             saleOneYearSecond.setJanuary_subject_sale_num(January_subject_sale_num);
             saleOneYearSecond.setJanuary_subject_sale_money(January_subject_sale_money);
             saleOneYearSecond.setFebruary_subject_sale_num(February_subject_sale_num);
             saleOneYearSecond.setFebruary_subject_sale_money(February_subject_sale_money);
             saleOneYearSecond.setMarch_subject_sale_num(March_subject_sale_num);
             saleOneYearSecond.setMarch_subject_sale_money(March_subject_sale_money);
             saleOneYearSecond.setApril_subject_sale_num(April_subject_sale_num);
             saleOneYearSecond.setApril_subject_sale_money(April_subject_sale_money);
             saleOneYearSecond.setMay_subject_sale_num(May_subject_sale_num);
             saleOneYearSecond.setMay_subject_sale_money(May_subject_sale_money);
             saleOneYearSecond.setJune_subject_sale_num(June_subject_sale_num);
             saleOneYearSecond.setJune_subject_sale_money(June_subject_sale_money);
             saleOneYearSecond.setJuly_subject_sale_num(July_subject_sale_num);
             saleOneYearSecond.setJuly_subject_sale_money(July_subject_sale_money);
             saleOneYearSecond.setAugust_subject_sale_num(August_subject_sale_num);
             saleOneYearSecond.setAugust_subject_sale_money(August_subject_sale_money);
             saleOneYearSecond.setSeptember_subject_sale_num(September_subject_sale_num);
             saleOneYearSecond.setSeptember_subject_sale_money(September_subject_sale_money);
             saleOneYearSecond.setOctober_subject_sale_num(October_subject_sale_num);
             saleOneYearSecond.setOctober_subject_sale_money(October_subject_sale_money);
             saleOneYearSecond.setNovember_subject_sale_num(November_subject_sale_num);
             saleOneYearSecond.setNovember_subject_sale_money(November_subject_sale_money);
             saleOneYearSecond.setDecember_subject_sale_num(December_subject_sale_num);
             saleOneYearSecond.setDecember_subject_sale_money(December_subject_sale_money);

             SaleOneYearSecond isExit=saleOneYearDao.checkSubjectisExit(subject.getId(),campus_id);

             if (isExit!=null){
                 saleOneYearDao.updateSaleOneYearSecond(saleOneYearSecond);
             }else{
                 saleOneYearDao.insertSaleOneYearSecond(saleOneYearSecond);
             }

        }

    }



    @Override
    public List<SaleOneYearSecond> findAllSaleOneYearSecondList(SelectEntity selectEntity) {
        return saleOneYearDao.findAllSaleOneYearSecondList(selectEntity);
    }

    @Override
    public int getAllSaleOneYearSecondNum(SelectEntity selectEntity) {
        return saleOneYearDao.getAllSaleOneYearSecondNum(selectEntity);
    }





    //-------------------------------------年龄层人数及产出
    @Override
    public void updateSaleOneYearThird(String year,Integer campus_id) {
        String month;

        Integer four_five_num;
        Double four_five_sale_money;


        Integer six_seven_num;
        Double six_seven_sale_money;


        Integer eight_nine_num;
        Double eight_nine_sale_money;

        Integer ten_eleven_num;
        Double ten_eleven_sale_money;


        Integer twelve_more_num;
        Double twelve_more_sale_money;


        SaleOneYearThird saleOneYearThird;

        for (int i=1;i<=12;i++) {
            if (i < 10) {
                month = year + "-0" + i;
            } else {
                month = year + "-" + i;
            }

            four_five_num=saleOneYearDao.statisticStudentSignNumByYear(4,5,campus_id,month);
            four_five_sale_money=saleOneYearDao.statisticStudentSignMoneyByYear(4,5,campus_id,month);
            if (four_five_sale_money==null){
                four_five_sale_money=0.0;
            }
            six_seven_num=saleOneYearDao.statisticStudentSignNumByYear(6,7,campus_id,month);
            six_seven_sale_money=saleOneYearDao.statisticStudentSignMoneyByYear(6,7,campus_id,month);
            if (six_seven_sale_money==null){
                six_seven_sale_money=0.0;
            }
            eight_nine_num=saleOneYearDao.statisticStudentSignNumByYear(8,9,campus_id,month);
            eight_nine_sale_money=saleOneYearDao.statisticStudentSignMoneyByYear(8,9,campus_id,month);
            if (eight_nine_sale_money==null){
                eight_nine_sale_money=0.0;
            }

            ten_eleven_num=saleOneYearDao.statisticStudentSignNumByYear(10,11,campus_id,month);
            ten_eleven_sale_money=saleOneYearDao.statisticStudentSignMoneyByYear(10,11,campus_id,month);
            if (ten_eleven_sale_money==null){
                ten_eleven_sale_money=0.0;
            }
            twelve_more_num=saleOneYearDao.statisticStudentSignNumByYear(12,100,campus_id,month);
            twelve_more_sale_money=saleOneYearDao.statisticStudentSignMoneyByYear(12,100,campus_id,month);
            if (twelve_more_sale_money==null){
                twelve_more_sale_money=0.0;
            }
            saleOneYearThird=new SaleOneYearThird();


            saleOneYearThird.setMonth(month);
            saleOneYearThird.setCampus_id(campus_id);

            saleOneYearThird.setFour_five_num(four_five_num);
            saleOneYearThird.setFour_five_sale_money(four_five_sale_money);

            saleOneYearThird.setSix_seven_num(six_seven_num);
            saleOneYearThird.setSix_seven_sale_money(six_seven_sale_money);

            saleOneYearThird.setEight_nine_num(eight_nine_num);
            saleOneYearThird.setEight_nine_sale_money(eight_nine_sale_money);

            saleOneYearThird.setTen_eleven_num(ten_eleven_num);
            saleOneYearThird.setTen_eleven_sale_money(ten_eleven_sale_money);

            saleOneYearThird.setTwelve_more_num(twelve_more_num);
            saleOneYearThird.setTwelve_more_sale_money(twelve_more_sale_money);

            saleOneYearDao.updateSaleOneYearThird(saleOneYearThird);

        }
    }

    @Override
    public List<SaleOneYearThird> findAllSaleOneYearThirdList(SelectEntity selectEntity) {
        return saleOneYearDao.findAllSaleOneYearThirdList(selectEntity);
    }

    @Override
    public int getAllSaleOneYearThirdNum(SelectEntity selectEntity) {
        return saleOneYearDao.getAllSaleOneYearThirdNum(selectEntity);
    }
}
