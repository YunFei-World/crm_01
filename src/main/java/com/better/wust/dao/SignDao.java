package com.better.wust.dao;

import com.better.wust.entity.*;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SignDao {

    public List<SignSql> selectSignsById(SelectEntity selectEntity);

    public int selectSignNumberById(SelectEntity selectEntity);



    public void updateSign(SignSql sign);



    public String selectLastSign();

    public void insertSign(@Param("sign_up") String sign_up, @Param("sale_id")String sale_id);



    //用于管理员  部分订单查询
    public List<SignSql> selectAllSigns(SelectEntity selectEntity);

    public int selectSignNumber(SelectEntity selectEntity);


    //查找校区所有课程
    public List<Course> selectAllCourseNames(@Param("param1") int campus_id);


    public int selectSignNumById(String sale_id);



    //订单生成--对应学生和学生课程表添加
    public String getStudentLastId();

    public String findSaleIdBySign(String sign_id);

    public Sale findSaleById(String sale_id);

    public Student studentISExist(@Param("param1") String student_name, @Param("param2") Date student_birthday);


    public void updateStudentContent(Student student);

    public void insertStudent(Student student);

    //学生课程
    public Integer findIdByStudentId(String student_id);

    public Course findCourseById(@Param("param1") Integer course_id);

    public void insertStudentCourse(@Param("sc_student_id") Integer sc_student_id, @Param("sc_course_id") Integer sc_course_id,@Param("sc_is_retire") Integer sc_is_retire,
                                    @Param("sc_is_placement") Integer sc_is_placement, @Param("sc_order_course_num") Integer sc_order_course_num,
                                    @Param("sc_remain_course_num") Integer sc_remain_course_num, @Param("sc_actual_price") Double sc_actual_price,
                                    @Param("sc_deal_price") Double sc_deal_price, @Param("sc_deal_unit_price") Double sc_deal_unit_price,
                                    @Param("sc_real_balance") Double sc_real_balance, @Param("sc_reward_balance") Double sc_reward_balance,
                                    @Param("create_time") Date create_time);


    public void insertSignCourse(@Param("param1")String sign_id, @Param("param2")Integer sc_course_id,
                                 @Param("param3")String student_id, @Param("param4")Date create_time);

    public String findStudentAllCourseByStudentId(String student_id);

    public void updateStudentAllCourse(@Param("param1")String all_course, @Param("param2")String student_id);

    public StudentClass findStudentClassByID(@Param("param1")int student_id, @Param("param2")int id, @Param("param3")int i);



    public List<SignCourse> findAllSignCourseBySignId(String  sign_id);


    public SignSql findSignBySignId(String sign_id);

    public Staff findStaffByStaffId(String staff_id);

    public Campus findCampusByCampusId(@Param("param1") int campus_id);
}
