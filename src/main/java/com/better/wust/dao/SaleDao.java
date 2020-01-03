package com.better.wust.dao;

import com.better.wust.entity.*;
import com.better.wust.tools.entity.SelectEntity;
import jxl.write.DateTime;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SaleDao {

    /**
     * 搜索销售表单
     * @param selectEntity
     * @return
     */
    public List<Sale> selectAllSales(SelectEntity selectEntity);

    public int selectSaleNumber(SelectEntity selectEntity);

    /**
     * 更新
     * @param sale
     */
    public void updateSale(Sale sale);

    public void insertFollow(FollowUp followUp);

    public void updateOrderinitChannelStaff(Sale sale);

    public List<FollowUp> selectAllFollows(SelectEntity selectEntity);

    public int selectFollowNumber(SelectEntity selectEntity);

    public List<Sale> selectAllSalesById(SelectEntity selectEntity);

    public int selectSaleNumberById(SelectEntity selectEntity);

    public Sale selectSaleById(String sale_id);

    public FollowUp selectLastFollowById(FollowUp followUp);

    public String selectLastFollow();

    public void updateScreen_Image(FollowUp followUp);

    public void updateSaleByFollow(@Param("param1") Date next_time_up,
                                   @Param("param2")String judge_up, @Param("param3")String sale_stage_up,
                                   @Param("param4")String sale_id,@Param("param5")String false_reason,
                                   @Param("param6")String is_coming,@Param("param7") Date arrive_time,
                                    @Param("param8")String other_reason);




    public void updateSaleBySign(@Param("relation") String relation, @Param("stu_name")String stu_name,
                                 @Param("sign_id")String sign_id);


    public void updateOrderinitBySign(@Param("param1")String customer_name, @Param("param2")String customer_contact,
                                      @Param("param3")String stu_name,@Param("param4")String sign_id);



    //更新回访表 --统计回访有效

    public void updateFollow(FollowUp followUp);








    //预约到店
    public List<Sale> findAllComeToShopSaleById(SelectEntity selectEntity);

    public int getAllComeToShopSaleNumberById(SelectEntity selectEntity);

    public List<Sale> findNotComeToShopSaleById(SelectEntity selectEntity);

    public int getNotComeToShopSaleNumberById(SelectEntity selectEntity);

    public List<Sale> findHaveComeToShopSaleById(SelectEntity selectEntity);

    public int getHaveComeToShopSaleNumberById(SelectEntity selectEntity);




    //退课显示

    public List<StudentClass> findAllStudentRefund(SelectEntity selectEntity);

    public int getAllStudentRefundNumber(SelectEntity selectEntity);

    public void finishStudentRefund(@Param("param1") int id);



    //转校
    public List<StudentClass> findAllStudentUpdateCampus(SelectEntity selectEntity);

    public int getAllStudentUpdateCampusNumber(SelectEntity selectEntity);

    public Student findStudentById(@Param("param1")int student_id);

    public double getStudentAllRealBalance(@Param("param1")int student_id);

    public void updateStudentByUpdateCampus(Student student);

    public void finishStudentUpdateCampus(@Param("param1")int student_id);


    public  void cleanStudentCourse(String student_id);

    public void cleanStudentRefundCourse(@Param("param1")String student_id, @Param("param2")String new_course_id);

    public List<Sale> findHaveComeToShopSaleUnSignById(SelectEntity selectEntity);

    public int getHaveComeToShopSaleUnSignNumberById(SelectEntity selectEntity);
}
