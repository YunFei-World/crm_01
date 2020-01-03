package com.better.wust.service;

import com.better.wust.entity.*;
import com.better.wust.tools.entity.SelectEntity;

import java.util.List;

public interface SaleService {

    public List<Sale> findAllSales(SelectEntity selectEntity);

    public int getSaleNumber(SelectEntity selectEntity);

    public int modifySale(Sale sale);

    public String addFollow(FollowUp followUp);





    public List<FollowUp> findAllFollow(SelectEntity selectEntity);

    public int getFollowNumber(SelectEntity selectEntity);

    public List<Sale> findAllSalesById(SelectEntity selectEntity);

    public int getSaleNumberById(SelectEntity selectEntity);

    public Sale findSaleById(String sale_id);

    public FollowUp findLastFollowById(FollowUp followUp);

    public String findLastFollow();

    public void modifyScreen_Image(FollowUp followUp);



    public void addInitAndSaleByComeToShop(Orderinit orderinit);



    public List<Sale> findAllComeToShopSaleById(SelectEntity selectEntity);

    public int getAllComeToShopSaleNumberById(SelectEntity selectEntity);

    public List<Sale> findNotComeToShopSaleById(SelectEntity selectEntity);

    public int getNotComeToShopSaleNumberById(SelectEntity selectEntity);

    public List<Sale> findHaveComeToShopSaleById(SelectEntity selectEntity);

    public int getHaveComeToShopSaleNumberById(SelectEntity selectEntity);





    public String addComeToShopFollow(FollowUp followUp);



    public List<StudentClass> findAllStudentRefund(SelectEntity selectEntity);

    public int getAllStudentRefundNumber(SelectEntity selectEntity);

    public void finishStudentRefund(int id,int student_id,int course_id);



    public List<StudentClass> findAllStudentUpdateCampus(SelectEntity selectEntity);

    public int getAllStudentUpdateCampusNumber(SelectEntity selectEntity);

    public double getStudentAllRealBalance(int student_id);

    public void finishStudentUpdateCampus(int student_id);


    public Student findStudentById(int student_id);


    public void cleanStudentCourse(String student_id);

    public  void updateStudentByUpdateCampus(Student student);

    public List<Sale> findHaveComeToShopSaleUnSignById(SelectEntity selectEntity);

    public int getHaveComeToShopSaleUnSignNumberById(SelectEntity selectEntity);
}
