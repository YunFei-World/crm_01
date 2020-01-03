package com.better.wust.service.Impl;

import com.better.wust.dao.StaffDao;
import com.better.wust.entity.SaleTask;
import com.better.wust.entity.Staff;
import com.better.wust.entity.SteamStatisticsMonth;
import com.better.wust.entity.SubjectTask;
import com.better.wust.service.StaffService;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;


    //员工表显现
    public List<Staff> findAllStaffs(SelectEntity selectEntity) throws RuntimeException {
        return staffDao.selectAllStaffs(selectEntity);
    }

    public int getStaffNumber(SelectEntity selectEntity) throws RuntimeException {
        return staffDao.selectStaffNumber(selectEntity);
    }



    @Override
    public Staff findStaffById(String id) throws RuntimeException {
        return staffDao.selectStaffById(id);
    }


    //添加员工
    @Override
    public String addStaff(Staff staff) throws RuntimeException {
        String satff_id_str = getLastStaffNumber();
        String num_str=satff_id_str.substring(4,satff_id_str.length());
        int num=(Integer.parseInt(num_str))+1;
        String mid = "";
        if (num < 10) {
            mid = "000";
        } else if (num < 100) {
            mid = "00";
        } else if (num < 1000) {
            mid = "0";
        }
        String id = "nncq" + mid + num;
        staff.setStaff_id(id);
        staffDao.insertStaff(staff);
        if ("营销部".equals(staff.getStaff_depart())) {
            staff.setPower("gotoJsp?jsp=staff/orderInit/myOrderinit");
        } else if ("销售部".equals(staff.getStaff_depart())) {
            staff.setPower("gotoJsp?jsp=staff/myInitSale");
        } else {
            staff.setPower("gotoJsp?jsp=staffManage");
        }
        if("管理员".equals(staff.getStaff_post())){
            staffDao.insertCampusManage(staff);
        }
        staffDao.insertLogin(staff);
        return id;
    }


    //更新员工信息
    @Override
    public void modifyStaff(Staff staff) throws RuntimeException {
        staffDao.updateStaff(staff);
        staffDao.updateLogin(staff);
    }

    @Override
    public void deleteStaff(String staff_id) {

        //如果是管理员  还需要删除对应的校区管理权限
        Staff staff=staffDao.selectStaffById(staff_id);

        if (staff.getStaff_post().equals("管理员")){
            staffDao.deleteCampusManage(staff_id);
        }

        staffDao.deleteStaff(staff_id);
        staffDao.deleteLogin(staff_id);
    }

    @Override
    public String getLastStaffNumber() throws RuntimeException {
        return staffDao.selectLastStaffNumber();
    }


    //查找所有销售部  员工
    @Override
    public List<Staff> findAllSaleStaffs(String staff_id,String campus_id) throws RuntimeException {
        return staffDao.selectAllSaleStaffs(staff_id,campus_id);
    }

    @Override
    public List<Staff> findAllCampusById(String staff_id,String campus_id) {
        return staffDao.selectAllCampusById(staff_id,campus_id);
    }

    @Override
    public int verification(Staff staff) {
        return staffDao.verification(staff);
    }

    @Override
    public String findPowerById(Staff staff) {
        return staffDao.selectPowerById(staff);
    }


    @Override
    public Staff getStaffData(String id) {
        return staffDao.selectStaffData(id);
    }



    //查询所有员工月任务
    @Override
    public List<SaleTask> getSaleTaskById(SelectEntity selectEntity) {
        return staffDao.getSaleTaskById(selectEntity);
    }

    @Override
    public int getSaleTaskByIdNumber(SelectEntity selectEntity) {
        return staffDao.getSaleTaskByIdNumber(selectEntity);
    }




    //--------------------员工销售任务分配 月-------------------------------------------

    @Override
    public SaleTask checkedTask(String satff_id, String month) {
        return staffDao.checkedTask(satff_id,month);
    }

    @Override
    public void addSaleTask(SaleTask saleTask) {
        saleTask.setLoad_time(new Date());
        staffDao.insertSaleTask(saleTask);
    }

    @Override
    public List<SaleTask> getAllSaleTask(SelectEntity selectEntity) {
        return staffDao.getAllSaleTask(selectEntity);
    }

    @Override
    public int getAllSaleTaskNumber(SelectEntity selectEntity) {
        return staffDao.getAllSaleTaskNumber(selectEntity);
    }

    @Override
    public void modifySaleTask(SaleTask saleTask) {
        saleTask.setLoad_time(new Date());
        staffDao.updateSaleTask(saleTask);
    }






    //--------------------课程任务分配 月-------------------------------------------

    @Override
    public SteamStatisticsMonth checkedTaskCourse(String campus_id, String month, String subject_id, String course_id) {
        return staffDao.checkedTaskCourse(campus_id,
                month,subject_id,course_id);
    }

    @Override
    public void insertSaleTaskCourse(SteamStatisticsMonth steamStatisticsMonth) {
        steamStatisticsMonth.setLoad_time(new Date());
        staffDao.insertSaleTaskCourse(steamStatisticsMonth);
    }

    @Override
    public List<SteamStatisticsMonth> findAllSaleTaskCourseList(SelectEntity selectEntity) {
        return staffDao.findAllSaleTaskCourseList(selectEntity);
    }

    @Override
    public int getAllSaleTaskCourseNumber(SelectEntity selectEntity) {
        return staffDao.getAllSaleTaskCourseNumber(selectEntity);
    }

    @Override
    public void updateSaleTaskCourse(SteamStatisticsMonth steamStatisticsMonth) {
        steamStatisticsMonth.setLoad_time(new Date());
        staffDao.updateSaleTaskCourse(steamStatisticsMonth);
    }


    //--------------------科目任务分配 月-------------------------------------------
    @Override
    public int insertSaleTaskSubject(Integer ids[], SubjectTask subjectTask) {
        for (Integer campus_id : ids) {
            SubjectTask isExit = staffDao.checkedTaskSubjectIsExit( subjectTask.getMonth(),subjectTask.getSubject_id(),campus_id);

            subjectTask.setCampus_id(campus_id);
            subjectTask.setLoad_time(new Date());
            if (isExit == null) {
                staffDao.insertSaleTaskSubject(subjectTask);
                return 100;
            } else {
                /*staffDao.updateSaleTaskSubject(subjectTask);*/
                return 101;
            }
        }

        return 102;
    }

    @Override
    public List<SubjectTask> findAllSaleTaskSubjectList(SelectEntity selectEntity) {
        return staffDao.findAllSaleTaskSubjectList(selectEntity);
    }

    @Override
    public int getAllSaleTaskSubjectNumber(SelectEntity selectEntity) {
        return staffDao.getAllSaleTaskSubjectNumber(selectEntity);
    }

    @Override
    public void updateSaleTaskCampus(SubjectTask subjectTask) {
        subjectTask.setLoad_time(new Date());
        staffDao.updateSaleTaskSubject(subjectTask);
    }


    @Override
    public Staff updateStaffByMyself(Staff staff) {
        staffDao.updateStaffByMyself(staff);

        return staffDao.selectStaffById(staff.getStaff_id());
    }

    @Override
    public int checkOldPwd(String staff_id, String oldpwd) {
        return staffDao.checkOldPwd(staff_id,oldpwd);
    }

    @Override
    public void updateStaffOwnPassword(String staff_id, String newpwd) {
        staffDao.updateStaffOwnPassword(staff_id,newpwd);
    }
}
