package com.yidu.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.yidu.dayEnd.domain.NetValue;

/**
 * 工具类
 * @author ZouJianwen
 * @data  2017年11月14日
 * @time  上午11:02:05
 *
 */
public class AllUtil {
	public static int count=0;//日志编号记录标志
	/**
	 * 四舍五入的方法  
	 * @param num  四舍五入的目标对象
	 * @param digit 要舍的位数（小数点后的数位）
	 * @return 四舍五入后的数字
	 */
	public static Double getRoundUp(Double num,Integer digit){
		BigDecimal   bigDecimal = new BigDecimal(num);
		double f1 = bigDecimal.setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();  
		return f1;
	}
	/**
	 * 四舍五入两位的方法
	 * @param num 要舍的位数（小数点后的数位）
	 * @return 四舍五入后的数字
	 */
	public static Double getRoundUp(Double num){
		BigDecimal   bigDecimal = new BigDecimal(num);
		double f1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		return f1;
	}

	/**
	 * 将字符串转sql.Date 的方法 并可进行时间计算 
	 * @param strDate 字符串的时间
	 * @param numDay 要推算的时间  正数 为时间后推  负数 为往前推
	 * @return 经过计算后的时间
	 * @throws Exception
	 */
	public static Date getDate(String strDate,Integer numDay)throws Exception {
		//创建时间的格式化类
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//将字符时间转为util的时间格式
		java.util.Date date= format.parse(strDate);
		Date sqlDate =null;
		//如果传的数字为0即得到当前时间的sql格式
		if(numDay==0){
			sqlDate=new Date(date.getTime());

		}else{
			//创建一个高丽日历  
			GregorianCalendar gregorianCalendar=new GregorianCalendar();
			//赋值为当前时间
			gregorianCalendar.setTime(date);
			//时间计算
			gregorianCalendar.add(Calendar.DATE, numDay);
			//转sql的时间
			sqlDate=new Date(gregorianCalendar.getTime().getTime());
		}

		return sqlDate;
	}
	/**
	 * 得到所传的字符时间的sql格式
	 * @param strDate 字符串的时间
	 * @return 经过转换后的时间
	 * @throws Exception
	 */
	public static Date getDate(String strDate)throws Exception {
		//创建时间的格式化类
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//将字符时间转为util的时间格式
		java.util.Date date= format.parse(strDate);
		
		Date sqlDate =null;
		//转sql的时间
		sqlDate=new Date(date.getTime());

		return sqlDate;
	}
	/**
	 * 将日期转为字符串
	 * @param date sql的时间
	 * @param formatStr 转换的格式
	 * @return 转换之后的字符时间
	 * @throws Exception
	 */
	public static String getStringDate(Date date,String formatStr) throws Exception{

		//创建时间的格式化类
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		/*java.util.Date utilDate =new java.util.Date(date.getTime());*/
		String strDate=format.format(date);
		return strDate;
	}
	/**
	 * 将日期转为字符串
	 * @param date sql的时间 
	 * @return 转换之后的日期
	 * @throws Exception
	 */
	public static String getStringDate(Date date) throws Exception{

		//创建时间的格式化类
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		/*java.util.Date utilDate =new java.util.Date(date.getTime());*/
		String strDate=format.format(date);
		return strDate;
	}
	
	
	public static NetValue getNetValue(NetValue netValue){
		String treeId="";
		//树形Class
		String treeClass="";
		//证券
		if(netValue.getProjectName().equals("证券")){
			treeId="JZTJ01";
			treeClass="F";
		}else if(netValue.getProjectName().equals("股票")){
			treeId="gp";
			treeClass="JZTJ01";
		}else if(netValue.getProjectName().equals("债券")){
			treeId="zq";
			treeClass="JZTJ01";
		}else if(netValue.getProjectName().equals("债券利息")){
			treeId="zqlx";
			treeClass="zq";
		}else{
			if(netValue.getTreeFatherCode()!=null && netValue.getTreeFatherCode().equals("gp")){
				StringBuilder sb = new StringBuilder("gp");
				treeId=sb.append(netValue.getProjectCode()).toString();
				treeClass="gp";
			}else if(netValue.getTreeFatherCode()!=null &&  netValue.getTreeFatherCode().equals("zq")){
				StringBuilder sb = new StringBuilder("zq");
				treeId=sb.append(netValue.getProjectCode()).toString();
				treeClass="zq";
			}
		}
		//现金
		if(netValue.getProjectName().equals("现金")){
			treeId="JZTJ02";
			treeClass="F";
		}else if(netValue.getProjectName().equals("存款利息")){
			treeId="cklx";

		}else if(netValue.getProjectName().equals("托管费")){
			treeId="tg";
		}else if(netValue.getProjectName().equals("管理费")){
			treeId="gl";
		}else if(netValue.getProjectName().equals("TA清算款")){
			treeId="taqsk";
		}else if(netValue.getProjectName().equals("证券清算款")){
			treeId="zqqsk";
		}else{
			//如果是现金下的第二级
			if(netValue.getTreeFatherCode()!=null && netValue.getTreeFatherCode().equals("JZTJ02")){
				StringBuilder sb = new StringBuilder("xj");
				treeId=sb.append(netValue.getProjectCode()).toString();
				treeClass="JZTJ02";
			}
		}
		//合计
		if(netValue.getProjectName().equals("合计")){
			treeId="JZTJ03";
			treeClass="F";
		}else if(netValue.getProjectName().equals("资产合计")){
			treeId="zchj";
			treeClass="JZTJ03";
		}else if(netValue.getProjectName().equals("负债")){
			treeId="fz";
			treeClass="JZTJ03";
		}else if(netValue.getProjectName().equals("资产净值")){
			treeId="zcjz";
			treeClass="JZTJ03";
		}else if(netValue.getProjectName().equals("基金总份额")){
			treeId="jjzfe";
			treeClass="JZTJ03";
		}else if(netValue.getProjectName().equals("单位资产净值")){
			treeId="dwzcjz";
			treeClass="JZTJ03";
		}
		netValue.setTreeCode(treeId);
		netValue.setTreeFatherCode(treeClass);

		return netValue;
	}
	/**
	 * 计算两个时间之间的天数差
	 * @param oneTime 第一个时间
	 * @param twoTime 第二个时间
	 * @return 天数差
	 * @throws Exception
	 */
	public static Integer  getTimeDiference(String  oneTime,String twoTime) throws Exception{
		java.util.Date oneDate = new java.util.Date(AllUtil.getDate(oneTime).getTime());
		java.util.Date twoDate = new java.util.Date(AllUtil.getDate(twoTime).getTime());
		java.util.Date startDate =null;
		java.util.Date endDate=null;
		if(oneDate.getTime()>twoDate.getTime()){
			startDate=oneDate;
			endDate =twoDate;
		}else{
			startDate=twoDate;
			endDate =oneDate;
		}
		Long longs = new Long(((startDate.getTime()-endDate.getTime())/60/1000/60/24));
		return longs.intValue();
	}
	
	
	
	/**
	 * 得到交易日期存在于那个付息期间
	 * @param timeList 付息日的集合
	 * @return 时间差
	 */
	public static Long getMinTime(List<Long> timeList){
		Long minTime=null;
		Long timeArray[] = new Long[timeList.size()];
		for (int i = 0; i < timeArray.length; i++) {
			timeArray[i]=timeList.get(i);
		}
		for(int i=0;i<timeArray.length-1;i++){
				for (int j = 0; j < timeArray.length-i-1; j++) {
					
					if(timeArray[i]>timeArray[i+1]){
						Long temp=timeArray[i];
						timeArray[i]=timeArray[i+1];
						timeArray[i+1]=temp;
					}
				}
		}
		for (int i = 0; i < timeArray.length; i++) {
			minTime=timeArray[timeArray.length-1];
		}
		
		System.err.println(timeArray);
		return minTime;
	}
	/**
	 * 自动生成日志编号
	 * @return 编号
	 */
	public static String daliyCode(){
		String daliyCode="RZ";
		//格式化日期
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String[] strDate=simple.format(date).split("-");
		for(int i=0;i<strDate.length;i++){
			daliyCode+=strDate[i];
		}
		count++;
		if(count<=9){
			daliyCode=daliyCode+"0"+count;
		}else if(count<=99){
			daliyCode=daliyCode+count;
		} else {
			daliyCode=daliyCode+count;
			
		}
		System.err.println(daliyCode);
		return daliyCode;
	}
	
	/**
	 * 当进行批量生成编号时  用此方法  
	 * @param maxBianHao 从数据库查询的最大编号
	 * @return 增长之后的编号
	 * 
	 */

	public static String  getLocalhostAutoBianHao(String maxBianHao){
		String bianhao ="";
		int num=Integer.parseInt(maxBianHao.substring(maxBianHao.length()-3));
		num++;
		if(num<=9){
			bianhao=maxBianHao.substring(0,maxBianHao.length()-3)+"00"+num;
		}else if(num<=99){
			bianhao=maxBianHao.substring(0,maxBianHao.length()-3)+"0"+num;

		}else if(num<=999){
			bianhao=maxBianHao.substring(0,maxBianHao.length()-3)+num;

		}

		return bianhao;

	}
	/**
	 * 将科学计数法的double转为字符串
	 * @param doubles 要转的数字
	 * @return 
	 */
	public static String scientificCountintMethedToNumber(Double doubles){
		
		
		BigDecimal bd=new BigDecimal(doubles);
		bd=bd.setScale(3, BigDecimal.ROUND_HALF_UP);
		NumberFormat  nf  =  NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		nf.setMinimumFractionDigits(3);
		return nf.format(bd);
	}
public static String scientificCountintMethedToNumber(Double doubles,int weishu){
		
		
		BigDecimal bd=new BigDecimal(doubles);
		bd=bd.setScale(3, BigDecimal.ROUND_HALF_UP);
		NumberFormat  nf  =  NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		nf.setMinimumFractionDigits(weishu);
		return nf.format(bd);
	}
	
	
	
}
