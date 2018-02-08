package com.yidu.businessData.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.google.gson.Gson;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.yidu.businessData.domain.EquityData;
import com.yidu.businessData.service.EquityDataService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 权益数据的增删改查
 * @author XiaoYuJie
 * @date 2017年11月14日
 * @time 上午11:00:22
 */
@Controller
public class EquityDataController {
	@Autowired
	EquityDataService  equityDataService;
	@Autowired
	AutoBianService autoBianHao;
	
	/**
	 * 增加一条数据
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param equityData 实体类
	 * @throws Exception 抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertEquityData.action",produces="text/html;charset=UTF-8")
	public String insertEquityData(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("springWeb")EquityData  equityData) throws Exception {
		System.out.println("增加");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println(equityData);
		//调用一个增加的方法 返回一个int
		int i=equityDataService.insertEquityData(equityData);
		if(i!=0){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 通过id删除数据 
	 * @param request 请求对象
	 * @param response  响应对象
	 * @param equityData 实体类
	 * @throws Exception 抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="/delectEquityData.action",produces="text/html;charset=UTF-8")
	public String delectEquityData(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("springWeb")EquityData  equityData) throws Exception {
		System.out.println("删除");
		System.err.println("equityData.getEqDataCode()"+equityData.getEqDataCode());
		//调用删除的方法 返回一个int
		int i=equityDataService.deleteEquityData(equityData);
		if(i!=0){
			return "删除成功";
		}else{
			return "删除失败";
		}
		
	}
	/**
	 * 分页条件查询
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param equityData 实体类
	 * @return
	 * @throws Exception 抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectEquityData.action",produces="text/html;charset=UTF-8")
	public String selectEquityData(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("springWeb")EquityData  equityData) throws Exception {
		System.out.println("查询");
		System.err.println("equityData"+equityData);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//得到登录的基金ID
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		equityData.setFundCode(fund.getFundCode());
		//调用查询的方法 返回一个map
		Map selectMap=equityDataService.selectEquityData(equityData);
		Gson gson=new Gson();
		//将map装换成gson对象
		String castlist=gson.toJson(selectMap);
		return castlist;
	}
	/**
	 * 通过id修改
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param equityData 实体类
	 * @throws Exception 抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="/updateEquityData.action",produces="text/html;charset=UTF-8")
	public String updateEquityData(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("springWeb")EquityData  equityData) throws Exception {
		System.out.println("修改");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.err.println(equityData);
		//调用修改的方法 返回一个int
		int i=equityDataService.updateEquityData(equityData);
		if(i>0){
			return "修改成功";
		}else{
			return "修改失败";
		}
		
	}
	/**
	 * 通过id查询
	 * @param request 得到请求
	 * @param response 响应对象
	 * @param equityData 实体对象
	 * @return 
	 * @throws Exception 抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectEquityDataCode.action",produces="text/html;charset=UTF-8")
	public String selectEquityDataCode(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("springWeb")EquityData  equityData) throws Exception {
		System.out.println("根据id查询");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println(equityData);
		//通过id查询
		List<EquityData>  equityDataList=equityDataService.selectEquityDataCode(equityData.getEqDataCode());
		Gson gson=new Gson();
		//将查询结果转成json对象
		String equityDataJson=gson.toJson(equityDataList);
		System.err.println("exchangeRateJson"+equityDataJson);
		return equityDataJson;
	}
	/**
	 * 自动生成编号
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/ziDongEquityDataCode.action",produces="text/html;charset=UTF-8")
	protected String autoCreateCode(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")EquityData  equityData) throws Exception {
		System.err.println("equityData.getEqRegisterDay()+"+equityData.getEqRegisterDay());
		String exchangeCode=autoBianHao.getAutoBianhao("equity_data", "QYSJ", "equity_data_code", "register_day", equityData.getEqRegisterDay());
		System.err.println("bianhao="+exchangeCode);
		return exchangeCode;
	}
	
	/**
	 * 导入
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/inputEquityDataCode.action",produces="text/html;charset=UTF-8")
	protected String upCreateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path=autoBianHao.upload(request, response, "szInput");
		int i=equityDataService.input(path);
		
		if(i>0){
			return "导入成功";
		}else{
			return "导入失败";
		}
	}
}
