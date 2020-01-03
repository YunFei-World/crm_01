package com.better.wust.dao;

import com.better.wust.entity.*;
import com.better.wust.tools.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface SubjectCourseDao {
    public List<Subject> findAllSubject();

    //目前项目只用了科目统计

    //课程统计
    public Double statisticsCourseSaleTaskByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")Integer course_id,@Param("param4")Integer  campus_id);

    public Double statisticsCourseSaleMoneyByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3")Integer course_id,@Param("param4")Integer  campus_id);

    public int statisticsCourseSigUpNumByTime(@Param("param1")String time_start,@Param("param2")String time_end,@Param("param3") Integer course_id,@Param("param4")Integer campus_id);

    public void updateStatisticsByTime(CourseStatistics courseStatistics);

    public List<CourseStatistics> findAllCourseStatistics(@Param("param1")String campus_id);

    public List<CourseStatistics> findAllCourseStatisticsList(SelectEntity selectEntity);

    public int getAllCourseStatisticsListNumber(SelectEntity selectEntity);



    //科目统计


    public Double statisticsSubjectSaleTaskByTime(@Param("param1")String time_start, @Param("param2")String time_end, @Param("param3")Integer subject_id, @Param("param4")Integer campus_id);


    public Double statisticsSubjectSaleMoneyByTime(@Param("param1")String time_start, @Param("param2")String time_end, @Param("param3")Integer subject_id, @Param("param4")Integer campus_id);

    public int statisticsSubjectSigUpNumByTime(@Param("param1")String time_start, @Param("param2")String time_end, @Param("param3")Integer subject_id, @Param("param4")Integer campus_id);

    public SubjectStatistics statisticsSubjectIsExist(@Param("param1")Integer subject_id, @Param("param2")Integer campus_id);

    public void insertSubjectStatistic(SubjectStatistics subjectStatistics);

    public void updateSubjectStatisticsByTime(SubjectStatistics subjectStatistics);

    public List<SubjectStatistics> findAllSubjectStatisticsList(SelectEntity selectEntity);

    public int getAllSubjectStatisticsListNumber(SelectEntity selectEntity);
}
