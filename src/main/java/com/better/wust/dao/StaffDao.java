package com.better.wust.dao;

import com.better.wust.entity.SaleTask;
import com.better.wust.entity.Staff;
import com.better.wust.entity.SteamStatisticsMonth;
import com.better.wust.entity.SubjectTask;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffDao {

    /**
     * 添加一个员工
     * @param staff
     */
    public void insertStaff(Staff staff);

    /**
     * 搜索员工
     * @param selectEntity
     * @return
     */
    public List<Staff> selectAllStaffs(SelectEntity selectEntity);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    public Staff selectStaffById(String id);

    /**
     * 获取员工数
     * @return
     */
    public int selectStaffNumber(SelectEntity selectEntity);

    /**
     * 获取最后一个员工的工号
     * @return
     */
    public String selectLastStaffNumber();

    /**
     * 更新员工信息
     * @param staff
     */
    public void updateStaff(Staff staff);

    /**
     * 搜索销售部员工
     * @return
     */
    public List<Staff> selectAllSaleStaffs(@Param("staff_id") String staff_id,@Param("campus_id") String campus_id);

    public List<Staff> selectAllCampusById(@Param("staff_id") String staff_id,@Param("campus_id") String campus_id);

    public int verification(Staff staff);

    public String selectPowerById(Staff staff);

    public Staff selectStaffData(String id);

    /**
     * 添加一个登录
     * @param staff
     */
    public void insertLogin(Staff staff);

    /**
     * 更新登录信息
     * @param staff
     */
    public void updateLogin(Staff staff);


    public void deleteStaff(String staff_id);

    public void deleteLogin(String staff_id);

    public void deleteCampusManage(String staff_id);

    //--------------------员工销售任务分配 月-------------------------------------------
    public SaleTask checkedTask(@Param("staff_id") String staff_id, @Param("month") String month);

    //添加销售员工月销售任务
    public void insertSaleTask(SaleTask saleTask);
    //查询所有销售月任务
    public List<SaleTask> getAllSaleTask(SelectEntity selectEntity);
    //对应表单count
    public int getAllSaleTaskNumber(SelectEntity selectEntity);
    //更新销售表单
    public void updateSaleTask(SaleTask saleTask);



    public List<SaleTask> getSaleTaskById(SelectEntity selectEntity);

    public int getSaleTaskByIdNumber(SelectEntity selectEntity);

    public void insertCampusManage(Staff staff);


    //--------------------课程任务分配 月-------------------------------------------
    //查询在 课程任务分配  中是否已经分配了此课程任务
    public SteamStatisticsMonth checkedTaskCourse(@Param("param1") String campus_id, @Param("param2") String month,
                                                  @Param("param3") String subject_id, @Param("param4") String course_id);

    //添加--给课程分配月销售任务
    public void insertSaleTaskCourse(SteamStatisticsMonth steamStatisticsMonth);


    //查询得到课程任务分配
    public List<SteamStatisticsMonth> findAllSaleTaskCourseList(SelectEntity selectEntity);

    //查询得到的数量 表单中的count
    public int getAllSaleTaskCourseNumber(SelectEntity selectEntity);

    //更新任务分配表单
    public void updateSaleTaskCourse(SteamStatisticsMonth steamStatisticsMonth);



    //---------------------科目任务分配-----------------
    public SubjectTask checkedTaskSubjectIsExit(@Param("param1")String month,@Param("param2") Integer subject_id,
                                                @Param("param3") Integer campus_id);


    public void insertSaleTaskSubject(SubjectTask subjectTask);

    public void updateSaleTaskSubject(SubjectTask subjectTask);

    public List<SubjectTask> findAllSaleTaskSubjectList(SelectEntity selectEntity);

    public int getAllSaleTaskSubjectNumber(SelectEntity selectEntity);


    public void updateStaffByMyself(Staff staff);

    public void updateStaffOwnPassword(@Param("param1")String staff_id,@Param("param2")String newpwd);

    public int checkOldPwd(@Param("param1") String staff_id, @Param("param2")String oldpwd);
}