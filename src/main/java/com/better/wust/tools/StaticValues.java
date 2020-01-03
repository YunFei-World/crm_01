package com.better.wust.tools;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 静态数据
 * 
 * @author duoduo
 *
 */
public class StaticValues {

	/**
	 * 权限列表
	 */
	public static Map<String, Integer> powerMap = new HashMap<String, Integer>();
	/**
	 * 项目文件存放路径
	 */
	public static final String PROJECT_DISK = "D:/crm/";


	/**
	 *毛单模板路径
	 */
	public static final String ORDER_INIT_POSITION=PROJECT_DISK+"format/毛单模板.xlsx";

	/**
	 *市场活动模板路径
	 */
	public static final String MARKETING_POSITION=PROJECT_DISK+"format/活动模板.xlsx";


	/**
	 * 市场活动备用文件存放目录
	 */
	public static final String OPTOINS_DISK = PROJECT_DISK + "options/files/";
	
	/**
	 * 合同模板地址
	 */
	public static final String FOLLOW_SCREEN_DISK = PROJECT_DISK + "sale/follow/screenImages/";
	
	/**
	 * 职员文件地址
	 */
	public static final String STAFF_DISK = PROJECT_DISK + "staff/";

	/**
	 * 初始化文件夹
	 */
	static {
		File file=new File(OPTOINS_DISK);
		if (!file.exists()) {
			file.mkdirs();
		}
		file=new File(FOLLOW_SCREEN_DISK);
		if (!file.exists()) {
			file.mkdirs();
		}
		file=new File(STAFF_DISK);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * 获取权限列表
	 * 
	 * @return
	 */
	public static String getPowerMap() {
		String re = "";
		for (String string : powerMap.keySet()) {
			re += string + " ";
		}
		return re;
	}

}
