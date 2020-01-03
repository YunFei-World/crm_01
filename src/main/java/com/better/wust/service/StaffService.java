package com.better.wust.service;

import com.better.wust.entity.SaleTask;
import com.better.wust.entity.Staff;
import com.better.wust.entity.SteamStatisticsMonth;
import com.better.wust.entity.SubjectTask;
import com.better.wust.tools.entity.SelectEntity;

import java.util.List;

public interface StaffService {
    public List<Staff> findAllStaffs(SelectEntity selectEntity);

    public Staff findStaffById(String id);

    public String addStaff(Staff staff);

    public int getStaffNumber(SelectEntity selectEntity);

    public String getLastStaffNumber();

    public void modifyStaff(Staff staff);

    public List<Staff> findAllSaleStaffs(String staff_id,String campus_id);

    public List<Staff> findAllCampusById(String staff_id,String campus_id);

    public int verification(Staff staff);

    public String findPowerById(Staff staff);

    public Staff getStaffData(String id);

    public void addSaleTask(SaleTask saleTask);

    public SaleTask checkedTask(String satff_id, String month);

    public List<SaleTask> getAllSaleTask(SelectEntity selectEntity);

    public int getAllSaleTaskNumber(SelectEntity selectEntity);

    public void modifySaleTask(SaleTask saleTask);

    public List<SaleTask> getSaleTaskById(SelectEntity selectEntity);

    public int getSaleTaskByIdNumber(SelectEntity selectEntity);


    public void deleteStaff(String staff_id);



    //--------------------课程任务分配 月-------------------------------------------

    public SteamStatisticsMonth checkedTaskCourse(String campus_id, String month, String subject_id, String course_id);

    public void insertSaleTaskCourse(SteamStatisticsMonth steamStatisticsMonth);

    public List<SteamStatisticsMonth> findAllSaleTaskCourseList(SelectEntity selectEntity);

    public int getAllSaleTaskCourseNumber(SelectEntity selectEntity);

    public void updateSaleTaskCourse(SteamStatisticsMonth steamStatisticsMonth);




    //-----------------------科目任务分配---------------------------------------
    public int insertSaleTaskSubject(Integer ids[], SubjectTask subjectTask);

    public List<SubjectTask> findAllSaleTaskSubjectList(SelectEntity selectEntity);

    public int getAllSaleTaskSubjectNumber(SelectEntity selectEntity);

    public void updateSaleTaskCampus(SubjectTask subjectTask);


    public Staff updateStaffByMyself(Staff staff);

    public int checkOldPwd(String staff_id, String oldpwd);

    public void updateStaffOwnPassword(String staff_id, String newpwd);
}
