package com.better.wust.dao;


import com.better.wust.entity.SaleOneYearFirst;
import com.better.wust.entity.SaleOneYearSecond;
import com.better.wust.entity.SaleOneYearThird;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleOneYearDao {

    //销售数据 First
    public Double statisTargetSaleMoneyByMonth(String month,Integer campus_id);

    public Double statisActualSaleMoneyByMonth(String month,Integer campus_id);

    public Integer statisTargetInitorderNumByMonth(String month,Integer campus_id);

    public Integer statisActualInitorderNumByMonth(String month,Integer campus_id);

    public Integer statisSignUpNumByMonth(String month,Integer campus_id);

    public Integer  statisRefoundNumByMonth(String month,Integer campus_id);

    public Double statisRefoundMoneyByMonth(String month,Integer campus_id);

    public void updateSaleOneYearFirst(SaleOneYearFirst saleOneYearFirst);

    public List<SaleOneYearFirst> findAllSaleOneYearFirstList(SelectEntity selectEntity);

    public Integer getAllSaleOneYearFirstNum(SelectEntity selectEntity);


    //报名人数产出 Second

    public Integer statisticSubjectSaleNumByMonth(String month,Integer subject_id,Integer campus_id);

    public Double statisticSubjectSaleMoneyByMonth(String month,Integer subject_id,Integer campus_id);

    public SaleOneYearSecond checkSubjectisExit(Integer subject_id,Integer campus_id);

    public void updateSaleOneYearSecond(SaleOneYearSecond saleOneYearSecond);

    public void insertSaleOneYearSecond(SaleOneYearSecond saleOneYearSecond);

    public List<SaleOneYearSecond> findAllSaleOneYearSecondList(SelectEntity selectEntity);

    public Integer getAllSaleOneYearSecondNum(SelectEntity selectEntity);

    //年龄层人数及产出

    public Integer statisticStudentSignNumByYear(@Param("param1") Integer start_year, @Param("param2")Integer end_year, @Param("param3")Integer campus_id, @Param("param4")String month);

    public Double statisticStudentSignMoneyByYear(@Param("param1") Integer start_year, @Param("param2")Integer end_year, @Param("param3")Integer campus_id, @Param("param4")String month);

    public void updateSaleOneYearThird(SaleOneYearThird saleOneYearThird);

    public List<SaleOneYearThird> findAllSaleOneYearThirdList(SelectEntity selectEntity);

    public Integer getAllSaleOneYearThirdNum(SelectEntity selectEntity);
}
