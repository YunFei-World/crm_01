package com.better.wust.service;

import com.better.wust.entity.SaleOneYearFirst;
import com.better.wust.entity.SaleOneYearSecond;
import com.better.wust.entity.SaleOneYearThird;
import com.better.wust.tools.entity.SelectEntity;

import java.util.List;

public interface SaleOneYearService {
    //销售数据 First
    public void updateSaleOneYearFirst(String year,Integer campus_id);

    public List<SaleOneYearFirst> findAllSaleOneYearFirstList(SelectEntity selectEntity);

    public int getAllSaleOneYearFirstNum(SelectEntity selectEntity);





    //报名人数产出 Second

    public void updateSaleOneYearSecond(String year,Integer campus_id);

    public List<SaleOneYearSecond> findAllSaleOneYearSecondList(SelectEntity selectEntity);

    public int getAllSaleOneYearSecondNum(SelectEntity selectEntity);


    //年龄层人数及产出
    public void updateSaleOneYearThird(String year,Integer campus_id);

    public List<SaleOneYearThird> findAllSaleOneYearThirdList(SelectEntity selectEntity);

    public int getAllSaleOneYearThirdNum(SelectEntity selectEntity);

}
