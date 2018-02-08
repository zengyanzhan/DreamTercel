package com.yidu.stockControl.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.parameters.domain.Fund;
import com.yidu.stockControl.domain.CashArapStock;
import com.yidu.stockControl.service.CashArapStockService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 现金应收应付库存的控制器类
 * @author 向燕春
 * @date 2017年11月14日
 * @time 下午2:36:48
 *
 */
@Controller
public class CashArapStockController{
	@Autowired
	CashArapStockService cashArapStockService;
	@Autowired
	AutoBianService autoBianService;
	
	/**
	 * 查询现金应收应付库存数据
	 * @param request 请求对象
	 * @param cashArapStock 现金应收应付库存实体对象
	 * @return json格式的现金应收应付库存数据
	 * @throws IOException io异常
	 */
	@ResponseBody
	@RequestMapping(value="selectCashArapStocks.action",produces="text/html;charset=UTF-8")
	public String selectCashArapStocks(HttpServletRequest request,@ModelAttribute("SpringWeb")CashArapStock cashArapStock) throws IOException{
		//创建一个session会话
		HttpSession session=request.getSession();
		//得到基金
		Fund fund=(Fund) session.getAttribute("fund");
		//给基金代码赋值
		cashArapStock.setFundCode(fund.getFundCode());
		//调用拼接条件的方法
		String sqlWhere=cashArapStockService.bufferWhere(cashArapStock);
		//调用查询现金应收应付库存的方法
		HashMap<String, Object> map=cashArapStockService.selectCashArapStocks(cashArapStock.getTableName(), sqlWhere, cashArapStock.getPage(), cashArapStock.getRows(), cashArapStock.getRowsTotal(), cashArapStock.getOrderColumn(), cashArapStock.getOrderStyle());
		//得到游标集合
		List<CashArapStock> list=(List<CashArapStock>) map.get("cashArapStockList");
		//循环将日期格式类型进行转换
		for(CashArapStock cashArapStocks:list){
			cashArapStocks.setStrDate(cashArapStocks.getBusinessDate().toString());
		}
		//创建Gson
		Gson gson=new Gson();
		//创建一个map集合
		HashMap<String,Object> jsonMap = new HashMap<String,Object>();
		//将总条数和行数添加到集合
		jsonMap.put("total", map.get("rowsTotal"));
		jsonMap.put("rows", list);
		//集合转成gson对象
		return gson.toJson(jsonMap);

	}
	/**
	 * 删除现金应收应付库存
	 * @param request 请求对象
	 * @param cashArapStock 现金应收应付库存
	 * @return 是否删除成功
	 * @throws IOException io异常
	 */
	@ResponseBody
	@RequestMapping(value="deleteCashArapStock.action",produces="text/html;charset=UTF-8")
	public String deleteCashArapStock(HttpServletRequest request) throws IOException{
		//得到要删除的编号
		String ids=request.getParameter("ids");
		//将编号进行切割
		String [] arr=ids.split(",");
		int size=0;
		for (int i = 0; i < arr.length; i++) {
			//调用删除的方法
			size=cashArapStockService.deleteCashArapStock(arr[i]); 
		}
		if(size!=0){
			return "删除成功";
		}else{
			return "删除失败";
		}
	}
	/**
	 * 增加现金应收应付库存
	 * @param response 响应对象
	 * @param cashArapStock 现金应收应付库存对象
	 * @return 是否添加成功
	 * @throws Exception 所有异常
	 */
	@ResponseBody
	@RequestMapping(value="insertCashArapStock.action",produces="text/html;charset=UTF-8")
	public String insertCashArapStock(@ModelAttribute("SpringWeb")CashArapStock cashArapStock) throws Exception{
		//将日期转换格式
		cashArapStock.setBusinessDate(AllUtil.getDate(cashArapStock.getStrDate()));
		//调用增加的方法
		int size=cashArapStockService.insertCashArapStock(cashArapStock);
		if(size!=0){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 修改现金应收应付库存
	 * @param cashArapStock 现金应收应付库存库存
	 * @return 是否修改成功
	 * @throws Exception 所有异常
	 */
	@ResponseBody
	@RequestMapping(value="updateCashArapStock.action",produces="text/html;charset=UTF-8")
	public String updateCashArapStock(@ModelAttribute("SpringWeb")CashArapStock cashArapStock) throws Exception{
		//将日期转换格式
		cashArapStock.setBusinessDate(AllUtil.getDate(cashArapStock.getStrDate()));
		//调用修改的方法
		int size=cashArapStockService.updateCashArapStock(cashArapStock);
		if(size!=0){
			return "修改成功";
		}else{
			return "修改失败";
		}
	} 
	/**
	 * 根据id查询现金应收应付库存
	 * @param cashArapStock 现金应收应付库存对象
	 * @return 现金应收应付库存对象
	 * @throws Exception 所有异常
	 */
	@ResponseBody
	@RequestMapping(value="selectCashArapStockById.action")
	public CashArapStock selectCashArapStockById(@ModelAttribute("SpringWeb")CashArapStock cashArapStock) throws Exception{
		//调用根据Id查询的方法
		CashArapStock cashArapStocks=cashArapStockService.selectCashArapStockById(cashArapStock.getCashArapStockCode());
		//将日期转换格式
		cashArapStocks.setStrDate(AllUtil.getStringDate(cashArapStocks.getBusinessDate()));
		return cashArapStocks;
	}
	/**
	 * 自动生成编号
	 * @return 编号
	 * @throws Exception 所有异常
	 */
	@ResponseBody
	@RequestMapping(value="ziDongShengChengCode.action",produces="text/html;charset=utf-8")
	public String ziDongShengChengCode()throws Exception{
		//得到自动生成编号
		String cashArapStockCode=autoBianService.getAutoBianhao("cash_arap_stock", "XJYSYFKC", "cash_arap_stock_code", "business_date", new Date(System.currentTimeMillis()));
		return cashArapStockCode;
	}
}
