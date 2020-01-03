package com.better.wust.service;

import com.better.wust.entity.*;
import com.better.wust.tools.entity.SelectEntity;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;
import java.util.List;

public interface SubjectCourseService {

    public List<Subject> findAllSubject();


    //科目统计
    public void updateSubjectStatisticsByTime(String time_start, String time_end, String  campus_id);

    public List<SubjectStatistics> findAllSubjectStatisticsList(SelectEntity selectEntity);

    public int getAllSubjectStatisticsListNumber(SelectEntity selectEntity);


    //课程统计

    public List<CourseStatistics> findAllCourseStatisticsList(SelectEntity selectEntity);

    public int getAllCourseStatisticsListNumber(SelectEntity selectEntity);

    public void updateStatisticsByTime(String time_start, String time_end, String campus_id, String subject_id);


}
