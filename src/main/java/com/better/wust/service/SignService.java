package com.better.wust.service;

import com.better.wust.entity.*;
import com.better.wust.tools.entity.SelectEntity;

import java.util.List;

public interface SignService {

    public List<SignSql> findSignsById(SelectEntity selectEntity);

    public int getSignNumberById(SelectEntity selectEntity);




    public Student addStudent(Sign sign);

    public int addStudentCourse(Sign sign,String student_id);

    public int modifySign(SignSql sign);



    public List<SignSql> findAllSigns(SelectEntity selectEntity);

    public int getSignNumber(SelectEntity selectEntity);





    public List<Course> findAllCourseNames(String campus_id);

    public int selectSignNumById(String sale_id);


    public Course findCourseById(int id);

    public StudentClass findStudentClassByID(int student_id, int id, int i);




    public List<SignCourse> findAllSignCourseBySignId(String  sign_id);



    public String selectLastSign();

    public void insertSign(String sign_id, String sale_id);

    public SignSql findSignBySignId(String sign_id);

    public Staff findStaffByStaffId(String staff_id);

    public Campus findCampusByCampusId(String campus_id);
}
