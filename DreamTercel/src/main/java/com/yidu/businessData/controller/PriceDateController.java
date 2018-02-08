package com.yidu.businessData.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yidu.businessData.domain.CashArap;
import com.yidu.businessData.domain.PriceData;
import com.yidu.businessData.service.PriceDateService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;

/**
* @author YiWenQi 
* @version 创建时间：2017年11月17日 上午11:47:24
* 行情数据
*/
@Controller
@RequestMapping(value="/priceDates")
public class PriceDateController {
	@Autowired
	AutoBianService autoBianHao;
	@Autowired
	AutoBianService autoBianService;
	@Autowired
	PriceDateService priceDateServices;
	@ResponseBody
	@RequestMapping(value="/selectPriceData.action",produces="text/html;charset=UTF-8")
	public String selectPriceData(@ModelAttribute("spring")PriceData priceDatas) throws Exception{
		//map的行情数据的服务类得到查询的方法
		Map<String, Object>map=priceDateServices.selectPriceData(priceDatas);
		//集合 得到查询条件c
		
		List<PriceData> priceDataList=(List) map.get("cursor");
		for(PriceData entity:priceDataList){
			//sql的 时间日期
			Date date= entity.getEnteringDate();
			//用一个字符串 接受工具中的日期转格式
			String string= AllUtil.getStringDate(date);
			//给格式日期赋值
			entity.setStrEnteringDate(string);
		}
		//int包装类 map 得到 总行数
		Integer rows=(Integer) map.get("rowsTotal");
		//hash的集合
		HashMap<String, Object> maps=new HashMap<String, Object>();
		maps.put("total", rows);
		maps.put("rows", priceDataList);
		//创建的一个gson
		Gson gson=new Gson();
		//用字符串接受gson的to方法
		String priceDataGson=gson.toJson(maps);
		return priceDataGson;
	}
	/**
	 * 自动生成编号
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/autoBianhao",produces="text/html;charset=UTF-8")
	public String autoBianhao (@ModelAttribute("springWeb")PriceData priceDatas) throws Exception{
		return autoBianService.getAutoBianhao("priceData", "HXSJ", "PD_PRICEDATACODE", "pd_enteringDate",AllUtil.getDate(priceDatas.getStrEnteringDate()));
		

	}
	
	/**
	 * 新增
	 * @param fund
	 * @return 
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/insertPrice.action",produces="text/html;charset=UTF-8")
	public String insertPrice(@ModelAttribute("springWeb")PriceData priceDatas) throws Exception{
		System.out.println(priceDatas);
		//给数据库的时间日期转格式 工具类得到 字符串格式日期
		priceDatas.setEnteringDate(AllUtil.getDate(priceDatas.getStrEnteringDate()));
		//定义 变量 = 服务类和增加的方法
		int flag=priceDateServices.insertPrice(priceDatas);
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	
	/**
	 * 查询
	 * @param priceDatas
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectPriceDataByCode",produces="text/html;charset=UTF-8")
	public String selectPriceDataByCode(@ModelAttribute("springWeb")PriceData priceDatas)throws Exception{
		System.out.println("进了查询了");
		//行情数据的服务类 查询行情数据的方法
		PriceData jsonFund = priceDateServices.selectPriceDataByCode(priceDatas);
		//给转格式日期转成Date的日期格式
		jsonFund.setStrEnteringDate(AllUtil.getStringDate(jsonFund.getEnteringDate()));
		
		Gson gson = new Gson();
		return gson.toJson(jsonFund);
		
	}
	/**
	 * 这是删除
	 * @param priceDatas
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/deletePrrice.action",produces="text/html;charset=UTF-8")
	public String deletePrrice(@ModelAttribute("springWeb")PriceData priceDatas) throws Exception{
		System.err.println(priceDatas.getPriceDataCode());
		int flag=priceDateServices.deletePrrice(priceDatas);
		System.err.println(flag);
		if(flag!=0){
			return "成功删除"+flag+"条数据";


		}else{
			return "操作失败";
		}
	}
	@ResponseBody
	@RequestMapping(value="/updatePrice.action",produces="text/html;charset=UTF-8")
	public String updatePrice(@ModelAttribute("springWeb")PriceData priceDatas) throws Exception{
		System.err.println(priceDatas);
		priceDatas.setEnteringDate(AllUtil.getDate(priceDatas.getStrEnteringDate()));
		int flag=priceDateServices.updatePrice(priceDatas);
		if(flag==1){
			return "修改成功";
		}else{
			return "修改失败";
		}
		
	}

	/**
	 * 上海过户库导入
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 是否导入成功
	 * @throws Exception 异常
	 */
	@RequestMapping(value="/imputShangHai.action")
	protected ModelAndView imputShangHai(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileName=autoBianHao.upload(request, response, "shangHai");
		System.err.println(fileName);
		/*String auotoBianHao=autoBianService.getAutoBianhao("priceData", "HXSJ", "PD_PRICEDATACODE", null, null);*/
		
		priceDateServices.imputShangHai(fileName);	
		return new ModelAndView("redirect:/jsp/priceData.jsp");
		}
	
	
}
