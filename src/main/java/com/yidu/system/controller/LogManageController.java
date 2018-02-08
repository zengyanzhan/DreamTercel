package com.yidu.system.controller;

import java.lang.reflect.Field;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.apache.bcel.classfile.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.system.domain.LogManage;
import com.yidu.system.domain.User;
import com.yidu.system.service.LogManageService;
import com.yidu.util.AllUtil;
import com.yidu.util.ReadProperties;
import com.yidu.util.SysContent;
import com.yidu.util.service.AutoBianService;

/**
 * 日志控制器
 * @author HeXiXian
 * @date   2017年11月22日
 * @time   下午2:55:22
 *
 */
@Aspect
@Component
@Controller
public class LogManageController {
	public static String userName="";
	public static String ip="";
	@Autowired
	LogManageService logManageService;
	@Autowired
	AutoBianService autoBianService;
	/**
	 * 查询日志
	 * @param logManage 实体类
	 * @param request 请求对象
	 * @return
	 * @throws Exception异常处理
	 */
	@ResponseBody
	@RequestMapping(value="selectLogManage.action",produces="text/html;charset=UTF-8")
	public String selectLogManage(@ModelAttribute("springmvc")LogManage logManage,HttpServletRequest request)throws Exception{
		System.err.println("LogManage="+logManage);

		ip=request.getRemoteAddr();
		HttpSession session=request.getSession(false);
		if(session==null){
			session=request.getSession();
		}
		User user=(User)session.getAttribute("user");
		userName =user.getUserName();
		//userName=(String)session.getAttribute("user");
		Map<String,Object>map=logManageService.selectLogManage(logManage);
		@SuppressWarnings("unchecked")
		List<LogManage> logManagelist=(List<LogManage>) map.get("cursor");
		HashMap<String, Object> jsonMap= new HashMap<String,Object>();
		jsonMap.put("total", map.get("rowsTotal"));
		jsonMap.put("rows", logManagelist);
		Gson gson=new Gson();
		return gson.toJson(jsonMap);
	}
	/**
	 * 删除日志
	 * @param logManage 日志实体类
	 * @return
	 * @throws Exception 异常处理
	 */
	@ResponseBody
	@RequestMapping(value="deleteLogManage",produces="text/html;charset=UTF-8")
	public String deleteLogManage(@ModelAttribute("springmvc")LogManage logManage)throws Exception{
		int flag=logManageService.deleteLogManage(logManage);
		System.out.println("flag="+flag);
		if (flag!=0) {
			return "删除成功";
		}else{
			return "删除失败";
		}
	}
	/**
	 * 添加日志
	 * @param logManage 实体类
	 * @return
	 * @throws Exception 异常处理
	 */
	@ResponseBody
	@RequestMapping(value="insertLogManage",produces="text/html;charset=UTF-8")
	public String insertLogManage(@ModelAttribute("springmvc")LogManage logManage)throws Exception{
		System.err.println("logManage="+logManage);
		int flag=logManageService.insertLogManage(logManage);

		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 修改日志
	 * @param logManage 日志实体类
	 * @return
	 * @throws Exception 异常处理
	 */
	@ResponseBody
	@RequestMapping(value="updateLogManage",produces="text/html;charset=UTF-8")
	public String updateLogManage(@ModelAttribute("springmvc")LogManage logManage)throws Exception{
		int flag=logManageService.updateLogManage(logManage);
		System.err.println("实体类="+logManage);
		System.err.println("falg="+flag);
		if(flag==1){
			return "修改成功";
		}else {
			return "修改失败";
		}
	}
	/**
	 * 通过ID查询日志
	 * @param logManage
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="selectOneByCodeLogManage",produces="text/html;charset=UTF-8")
	public String selectOneByCodeLogManage(@ModelAttribute("springmvc")LogManage logManage)throws Exception{
		LogManage jsonlogManage=logManageService.selectOneByCodeLogManage(logManage);
		System.err.println("实体类="+jsonlogManage);
		Gson gson=new Gson();
		return gson.toJson(jsonlogManage);
	}

	@Pointcut("execution(* com.yidu.*.dao..*.*(..))")
	public void myPointCut(){
		System.err.println("进入切入点");
	}
	@Before("myPointCut()")
	public void myBefore(){
		System.out.println("前置通知");
	}
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.err.println("环绕开始");
		Object obj=proceedingJoinPoint.proceed();
		System.err.println("环绕结束");
		return obj;

	}

	@After("myPointCut()")
	public void myAfter(JoinPoint joinPoint){
		System.out.println("最终通知");
		HttpServletRequest request = SysContent.getRequest();
		HttpSession session = SysContent.getSession();
		ip=request.getLocalAddr();
		User user=(User)session.getAttribute("user");
		if(user!=null){
			userName=user.getUserName();
		}
		String methodName=joinPoint.getSignature().getName().toLowerCase();
		String className=joinPoint.getSignature().getDeclaringTypeName().toLowerCase();
		System.err.println(methodName+","+className+"."+userName+"."+ip);
		if(!className.contains("logmanage") && !className.contains("util")&&!className.contains("report") && !className.contains("android") && userName!=null  &&!userName.equals("") && !ip.equals("")){
			int first=className.indexOf("yidu.");
			int second=className.indexOf(".dao");
			String classNameStr=className.substring(first+5, second);
			//得到操作用户
			java.util.Date date=new java.util.Date();
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr=simpleDateFormat.format(date);
			 
			String str=className.substring(className.indexOf("dao."));
			String tableName=new ReadProperties().readProperties(str.substring(4,str.length()-3),"/LogManageTable.properties");//得到表名
			System.err.println("表名="+tableName+",str="+str);
			String subFunction=tableName.substring(0, tableName.length()-1);//得到模块的子功能名称
			String modelName=new ReadProperties().readProperties(classNameStr,"/LogManageTable.properties");//得到模块名称
			System.err.println(userName+","+ip);
			if(methodName.contains("select")){
				LogManage logManage=new LogManage();//创建一个实体类
				logManage.setUserCode(userName);
				logManage.setDailyDate(dateStr);//得到操作的日期
				logManage.setDailyIp(ip);//得到操作的用户
				logManage.setRightDesc("");
				logManage.setDailyTable(tableName);//得到了操作的表名
				try {
					logManage.setDailyCode(AllUtil.daliyCode());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//自动生成的日志编号
				//返回的所有的记录数\
				logManage.setDailyType(userName+"操作"+modelName+"的"+subFunction+"功能的"+methodName+"方法,查询了"+tableName);
				logManageService.insertLogManage(logManage);
			}if(methodName.contains("insert")){
				LogManage logManage=new LogManage();//创建一个实体类
				logManage.setUserCode(userName);
				logManage.setDailyDate(dateStr);//得到操作的日期
				logManage.setDailyIp(ip);//得到操作的用户
				logManage.setRightDesc("");
				logManage.setDailyTable(tableName);//得到操作的表名
				try {
					logManage.setDailyCode(AllUtil.daliyCode());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				logManage.setDailyType(userName+"操作"+modelName+"的"+subFunction+"功能的"+methodName+"方法,新增"+tableName);
				logManageService.insertLogManage(logManage);
			}if(methodName.contains("delete")){
				LogManage logManage=new LogManage();//创建一个实体类
				logManage.setUserCode(userName);
				logManage.setDailyDate(dateStr);//得到操作的日期
				logManage.setDailyIp(ip);//得到操作的用户
				logManage.setRightDesc("");
				logManage.setDailyTable(tableName);//得到操作的表名
				try {
					logManage.setDailyCode(AllUtil.daliyCode());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				logManage.setDailyType(userName+"操作"+modelName+"的"+subFunction+"功能的"+methodName+"方法,删除"+tableName);
				logManageService.insertLogManage(logManage);
			}if(methodName.contains("update")){
				LogManage logManage=new LogManage();//创建一个实体类
				logManage.setUserCode(userName);
				logManage.setDailyDate(dateStr);//得到操作的日期
				logManage.setDailyIp(ip);//得到操作的用户
				logManage.setRightDesc("");
				logManage.setDailyTable(tableName);//得到操作的表名
				try {
					logManage.setDailyCode(AllUtil.daliyCode());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				logManage.setDailyType(userName+"操作"+modelName+"的"+subFunction+"功能的"+methodName+"方法,修改"+tableName);
				logManageService.insertLogManage(logManage);
			}
		}  

	}
	/**
	 * 自动生成编号
	 * @return 自动生成编号
	 * @throws Exception  异常处理
	 */
	@ResponseBody
	@RequestMapping(value="autoBianhaoLogManage",produces="text/html;charset=UTF-8")
	public String autoBianhao () throws Exception{
		//logManage.setDailyCode(AllUtil.daliyCode());
		return AllUtil.daliyCode();
	}

}
