package com.better.wust.service.Impl;

import com.better.wust.dao.SubjectCourseDao;
import com.better.wust.entity.*;
import com.better.wust.service.SubjectCourseService;
import com.better.wust.tools.DigitalUtils;
import com.better.wust.tools.ToolDateTime;
import com.better.wust.tools.entity.SelectEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SubjectCourseServiceImpl implements SubjectCourseService {

    @Autowired
    private SubjectCourseDao subjectCourseDao;




    @Override
    public List<Subject> findAllSubject() {
        return subjectCourseDao.findAllSubject();
    }






    @Override
    public void updateSubjectStatisticsByTime(String timestart, String timeend, String campusid) {
        Integer campus_id=Integer.parseInt(campusid);

        Date timestart1 = null;
        Date timeend1 = null;
        try {
            timestart1 = new SimpleDateFormat("yyyy-MM").parse(timestart);
            timeend1 = new SimpleDateFormat("yyyy-MM").parse(timeend);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String time_start = simpleDateFormat.format(ToolDateTime.getFirstDateOfMonth(timestart1));
        String time_end = simpleDateFormat.format(ToolDateTime.getLastDateOfMonth(timeend1));

        //查找出所有要统计的科目  最底层科目
        List<Subject> list = subjectCourseDao.findAllSubject();

        for (Subject subject : list) {

            double subject_task_money;
            double subject_sale_money;
            int subject_signup_num;
            if (subjectCourseDao.statisticsSubjectSaleTaskByTime(timestart, timeend, subject.getId(), campus_id) != null) {
                subject_task_money = subjectCourseDao.statisticsSubjectSaleTaskByTime(timestart, timeend, subject.getId(), campus_id);
            } else {
                subject_task_money = 0;
            }

            if (subjectCourseDao.statisticsSubjectSaleMoneyByTime(time_start, time_end, subject.getId(), campus_id) != null) {
                subject_sale_money = subjectCourseDao.statisticsSubjectSaleMoneyByTime(time_start, time_end, subject.getId(), campus_id);
            } else {
                subject_sale_money = 0;
            }

            subject_signup_num = subjectCourseDao.statisticsSubjectSigUpNumByTime(time_start, time_end, subject.getId(), campus_id);


            double subject_finish_proportion;

            if (subject_task_money != 0) {
                subject_finish_proportion = (double) subject_sale_money / subject_task_money;
            } else {
                subject_finish_proportion = 0;
            }


            SubjectStatistics subjectStatistics = new SubjectStatistics();

            subjectStatistics.setSubject_id(subject.getId());
            subjectStatistics.setCampus_id(campus_id);

            subjectStatistics.setSubject_task_money(subject_task_money);
            subjectStatistics.setSubject_sale_money(subject_sale_money);
            subjectStatistics.setSubject_signup_num(subject_signup_num);
            subjectStatistics.setSubject_finish_proportion(subject_finish_proportion);

            subjectStatistics.setTime_start(timestart);
            subjectStatistics.setTime_end(timeend);

            SubjectStatistics isExit = subjectCourseDao.statisticsSubjectIsExist(subject.getId(), campus_id);

            if (isExit == null) {
                subjectCourseDao.insertSubjectStatistic(subjectStatistics);
            } else {
                subjectCourseDao.updateSubjectStatisticsByTime(subjectStatistics);
            }

        }
    }

    @Override
    public List<SubjectStatistics> findAllSubjectStatisticsList(SelectEntity selectEntity) {

        return subjectCourseDao.findAllSubjectStatisticsList(selectEntity);
    }

    @Override
    public int getAllSubjectStatisticsListNumber(SelectEntity selectEntity) {
        return subjectCourseDao.getAllSubjectStatisticsListNumber(selectEntity);
    }















//----------------------------课程任务分配-----------------------------







    @Override
    public void updateStatisticsByTime(String timestart, String timeend, String campus_id, String subject_id) {



        Date timestart1= null;
        Date timeend1=null;
        try {
            timestart1 = new SimpleDateFormat("yyyy-MM").parse(timestart);
            timeend1= new SimpleDateFormat("yyyy-MM").parse(timeend);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String time_start=simpleDateFormat.format(ToolDateTime.getFirstDateOfMonth(timestart1));
        String time_end=simpleDateFormat.format(ToolDateTime.getLastDateOfMonth(timeend1));

        //查找出所有要统计的科目
        //
        List<CourseStatistics> list = subjectCourseDao.findAllCourseStatistics(campus_id);




        for (CourseStatistics courseStatistics : list) {



            double course_task_money;
            double course_sale_money;
            int course_signup_num;
            if(subjectCourseDao.statisticsCourseSaleTaskByTime(time_start,time_end,courseStatistics.getCourse_id(),courseStatistics.getCampus_id())!=null){
                course_task_money=subjectCourseDao.statisticsCourseSaleTaskByTime(time_start,time_end,courseStatistics.getCourse_id(),courseStatistics.getCampus_id());
            }else{
                course_task_money=0;
            }

            if (subjectCourseDao.statisticsCourseSaleMoneyByTime(time_start,time_end,courseStatistics.getCourse_id(),courseStatistics.getCampus_id())!=null){
                course_sale_money =  subjectCourseDao.statisticsCourseSaleMoneyByTime(time_start,time_end,courseStatistics.getCourse_id(),courseStatistics.getCampus_id());
            }else{
                course_sale_money=0;
            }

            course_signup_num = subjectCourseDao.statisticsCourseSigUpNumByTime(time_start,time_end,courseStatistics.getCourse_id(),courseStatistics.getCampus_id());



            double course_finish_proportion;

            if (course_task_money != 0) {
                course_finish_proportion = (double) course_sale_money / course_task_money;
            } else {
                course_finish_proportion = 0;
            }


            courseStatistics.setCourse_task_money(course_task_money);
            courseStatistics.setCourse_sale_money(course_sale_money);
            courseStatistics.setCourse_signup_num(course_signup_num);
            courseStatistics.setCourse_finish_proportion(course_finish_proportion);

            courseStatistics.setTime_start(time_start);
            courseStatistics.setTime_end(time_end);

            subjectCourseDao.updateStatisticsByTime(courseStatistics);
        }
    }

    @Override
    public int getAllCourseStatisticsListNumber(SelectEntity selectEntity) {
        return subjectCourseDao.getAllCourseStatisticsListNumber(selectEntity);
    }

    @Override
    public List<CourseStatistics> findAllCourseStatisticsList(SelectEntity selectEntity) {

        return subjectCourseDao.findAllCourseStatisticsList(selectEntity);
    }


}
