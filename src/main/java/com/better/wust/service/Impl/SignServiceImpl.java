package com.better.wust.service.Impl;

import com.better.wust.dao.SaleDao;
import com.better.wust.dao.SignDao;
import com.better.wust.entity.*;
import com.better.wust.service.SignService;
import com.better.wust.tools.ToolDateTime;
import com.better.wust.tools.ToolMD5;
import com.better.wust.tools.entity.SelectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SignServiceImpl implements SignService {




    @Autowired
    private SignDao signDao;

    @Autowired
    private SaleDao saleDao;


    public int selectSignNumById(String sale_id) {
        return signDao.selectSignNumById(sale_id);
    }


    @Override
    public List<SignSql> findSignsById(SelectEntity selectEntity) {

        return signDao.selectAllSigns(selectEntity);
    }

    @Override
    public int getSignNumberById(SelectEntity selectEntity) {
        return signDao.selectSignNumberById(selectEntity);
    }


    @Override
    public Student addStudent(Sign sign) {
        //共3步  1-2-3
        //---------------1.此时订单表中 购买课程已经生成  生成对应的  学生表
        String student_id;
        String sale_id;
        String userpassword;
        String user_password="";
        String student_education;
        Integer campus_id;
        String contact_name_one;
        String contact_tel_one;
        String student_address;

        String student_name;
        Date student_birthday;
        String student_sex;
        String student_phone;
        Double reward_balance;
        Integer course_id;
        Integer order_course_num;
        Double final_price;


        //根据订单id中sign_id查找sale_id 查到之前录入的学生信息
        sale_id=signDao.findSaleIdBySign(sign.getSign_id());
        sign.setSale_id(sale_id);
        Sale sale_student=signDao.findSaleById(sale_id);

        student_id = signDao.getStudentLastId();//得到学生表中最后一个学生的ID


        //获取当前年月
        String yearmonth= ToolDateTime.getCurYearMonth();//201912
        //学号
        if (student_id == null) {
            student_id = yearmonth+"0001";
        } else {
            String before=yearmonth;
            String after=student_id.substring(6,student_id.length());
            int num=(Integer.parseInt(after))+1;
            String numString=num+"";
            while(numString.length()<4){
                numString=0+numString;
            }
            student_id = before+numString;
        }

        //密码
        userpassword=sign.getStudent_birthday_str();
        for (int i=0;i<userpassword.length();i++){
            if (userpassword.charAt(i)!='-'){
                user_password=user_password+userpassword.charAt(i);
            }
        }

        //密码md5加密
        user_password= ToolMD5.getMD5(user_password);

        student_address=sale_student.getAddress();
        student_education=sale_student.getStu_grade();
        campus_id=sale_student.getCampus_id();
        contact_name_one=sale_student.getCustomer_name();
        contact_tel_one=sale_student.getCustomer_contact();

        student_name=sign.getStu_name();
        student_sex=sign.getStudent_sex();
        student_birthday=sign.getStudent_birthday();
        student_phone=sign.getStudent_phone();
        reward_balance=sign.getReward_balance();
        course_id=sign.getCourse_id();
        order_course_num=sign.getOrder_course_num();
        final_price=sign.getFinal_price();


        //查找该学生是否已经存在在学生表中
        Student isstudent=signDao.studentISExist(sign.getStu_name(),sign.getStudent_birthday());

        Student student=new Student();

        student.setStudent_id(student_id);
        student.setUser_password(user_password);
        student.setStudent_name(student_name);
        student.setStudent_address(student_address);
        student.setStudent_education(student_education);
        student.setStudent_state(0);
        student.setCampus_id(campus_id);
        student.setContact_name_one(contact_name_one);
        student.setContact_tel_one(contact_tel_one);

        student.setStudent_birthday(student_birthday);
        student.setStudent_sex(student_sex);
        student.setStudent_phone(student_phone);




        Date date=new Date();
        if (isstudent!=null){
            //此学生已经有学号   更改为以前的学号(并且把学生状态变为0  无论之前此学生账户是否停用或者使用  都变为0使用)
            student.setStudent_id(isstudent.getStudent_id());
            student.setCourse_id(isstudent.getCourse_id());
            //时间
            student.setUpdate_time(new Timestamp(date.getTime()));
            signDao.updateStudentContent(student);
        }else{
            student.setCreate_time(new Timestamp(date.getTime()));
            signDao.insertStudent(student);
        }

        return student;
    }

    @Override
    public int addStudentCourse(Sign sign,String student_id) {

        Integer sc_student_id;//这里不能用student_id   因为这个中间表的student_id不是学号 而是主键id
        Integer sc_course_id;
        Integer sc_is_retire;
        Integer sc_is_placement;

        Integer sc_order_course_num;
        Integer sc_remain_course_num;

        Double sc_actual_price;
        Double sc_deal_price;
        Double sc_deal_unit_price;

        Double sc_real_balance;
        Double sc_reward_balance;
        Date create_time=new Date();

        //通过学号查找得到学生表中的主键id
        sc_student_id=signDao.findIdByStudentId(student_id);
        sc_course_id=sign.getCourse_id();
        sc_is_placement=1;
        sc_is_retire=0;
        //通过course_id 查询购买的课程是期  还是课次
        Course course=signDao.findCourseById(sc_course_id);
        if (course.getChargetype()==0){//0为按期  1为按次
            sc_order_course_num=course.getLessonNum();
            sc_remain_course_num=course.getLessonNum();
            //如果是按期计费  即使Order_course_num中填入数据  也会将其设置为一期的课次数
            sign.setOrder_course_num(course.getLessonNum());

        }else{
            sc_order_course_num=sign.getOrder_course_num();
            sc_remain_course_num=sign.getOrder_course_num();
        }

        sc_actual_price=sign.getOrder_course_num()*course.getUNIT_PRICE();
        //sc_actual_price=course.getTotalPrice();
        sc_deal_price=sign.getFinal_price();
        if (sign.getOrder_course_num()!=0){
            sc_deal_unit_price=sc_deal_price/sign.getOrder_course_num();
        }else{
            sc_deal_unit_price=0.00;
        }

        sc_real_balance=sign.getFinal_price();
        sc_reward_balance=sign.getReward_balance();

        //1.将信息添加学生课程表 2.并且将这单对应课程加入订单-课程表中  3.将新的课程加入学生表中的课程表


        String all_Course=signDao.findStudentAllCourseByStudentId(student_id);

        if (all_Course==null){
            all_Course=sc_course_id+"";
        }else{
            all_Course=all_Course+"|"+sc_course_id;
        }


        try {
            signDao.insertStudentCourse(sc_student_id,sc_course_id,sc_is_retire,sc_is_placement,sc_order_course_num,sc_remain_course_num,
                    sc_actual_price,sc_deal_price,sc_deal_unit_price,sc_real_balance,sc_reward_balance,create_time);
        }catch (Exception e){
            e.printStackTrace();
            return 101;//该学生已经选过此门课程
        }

        signDao.insertSignCourse(sign.getSign_id(),sc_course_id,student_id,create_time);
        signDao.updateStudentAllCourse(all_Course,student_id);

        return 100;

    }

    @Override
    public int modifySign(SignSql sign) {

        sign.setLoad_time(new Date());

        saleDao.updateOrderinitBySign(sign.getCustomer_name(),sign.getCustomer_contact(),sign.getStu_name(),sign.getSign_id());
        saleDao.updateSaleBySign(sign.getRelation(),sign.getStu_name(),sign.getSign_id());
        signDao.updateSign(sign);

        return 100;//成功
    }

    @Override
    public StudentClass findStudentClassByID(int student_id, int id,int i) {
        return signDao.findStudentClassByID(student_id,id,i);
    }






    @Override
    public List<SignSql> findAllSigns(SelectEntity selectEntity) {
        return signDao.selectAllSigns(selectEntity);
    }

    @Override
    public int getSignNumber(SelectEntity selectEntity) {
        return signDao.selectSignNumber(selectEntity);
    }

    @Override
    public List<Course> findAllCourseNames(String campus_id) {
        return signDao.selectAllCourseNames(Integer.parseInt(campus_id));
    }


    @Override
    public Course findCourseById(int id) {
        return signDao.findCourseById(id);
    }


    @Override
    public List<SignCourse> findAllSignCourseBySignId(String sign_id) {
        return signDao.findAllSignCourseBySignId(sign_id);
    }


    @Override
    public String selectLastSign() {
        return signDao.selectLastSign();
    }

    @Override
    public void insertSign(String sign_id, String sale_id) {
        signDao.insertSign(sign_id,sale_id);
    }


    @Override
    public SignSql findSignBySignId(String sign_id) {
        return signDao.findSignBySignId(sign_id);
    }


    @Override
    public Staff findStaffByStaffId(String staff_id) {
        return signDao.findStaffByStaffId(staff_id);
    }

    @Override
    public Campus findCampusByCampusId(String campus_id) {
        return signDao.findCampusByCampusId(Integer.parseInt(campus_id));
    }
}
