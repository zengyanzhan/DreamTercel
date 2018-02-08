package com.yidu.stockControl.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.stockControl.domain.CashStock;
import com.yidu.stockControl.service.CashStockService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;

/**
 * 现金库存表的控制器类
 * @author ChenJiaLong
 * @date 2017年11月15日
 * @time 上午11:43:28
 *
 */
@Controller
public class CashStockController {
	@Autowired 
	CashStockService cashStockService;
	@Autowired
	AutoBianService autoBianService;
	/**
	 * 查询现金库存表的数据
	 * @param cashStockdomain
	 * @return 现金库存的实体类
	 */
	@ResponseBody
	@RequestMapping(value="selectCashStock.action",produces = "text/html;charset=UTF-8")
	public String selectCashStock(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")CashStock cashStockdomain) throws IOException  {
		System.err.println("这是查询现金库存表的方法");
		Map<String, Object> map=cashStockService.selectCashStock(cashStockdomain);
		HashMap<String, Object>  jsonMap = new HashMap<String,Object>();//创建HashMap
		
		List<CashStock> list=(List<com.yidu.stockControl.domain.CashStock>) map.get("cursor");
		for(CashStock cashStocks:list){//遍历list集合
			cashStocks.setStrDate(cashStocks.getStatisticDate().toString());//将日期改成String类型
		}
		
		System.out.println(map);
		System.out.println(map.get("cursor"));
		jsonMap.put("total", map.get("rowsTotal"));//
		jsonMap.put("rows",map.get("cursor"));//
		Gson gson = new Gson();//创建Json 
		return gson.toJson(jsonMap);//返回 
	}
	
	/**
	 * 删除一条现金库存的表的数据
	 * @param cashStockdomain
	 * @return 被删除所选列的ID（String）
	 */
	@ResponseBody
	@RequestMapping(value="deleteCashStock.action",produces = "text/html;charset=UTF-8")
	public String deleteCashStock(@ModelAttribute("SpringWeb")CashStock cashStockdomain) throws IOException {
		System.err.println("这是删除现金库存表的方法");
		int flag=cashStockService.deleteCashStock(cashStockdomain.getCashStockCode());//调用service当中删除现金库存表的方法
		
		System.err.println(flag);
		if(flag>0){
			return "操作成功";


		}else{
			return "操作失败";
		}
		
	}
	
	/**
	 * 修改一条现金库存表的数据
	 * @param CashStockCode
	 * @return 修改后的表格数据CashStockdomain的实体类
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="updateCashStock.action",produces = "text/html;charset=UTF-8")
	public String updateCashStock(@ModelAttribute("SpringWeb")CashStock cashStockdomain) throws Exception {
		System.out.println("这是修改现金库存表的方法");
		cashStockdomain.setStatisticDate(AllUtil.getDate(cashStockdomain.getStrDate()));
		int flag=cashStockService.updateCashStock(cashStockdomain);//调用修改的方法(返回结果)
		if(flag==1){
			return "修改成功";
		}else{
			return "修改失败";
		}
		
		
	}
	
	/**
	 * 新增一条现金库存表的数据
	 * @param cashStockdomain
	 * @return CashStock现金库存的实体类
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="insertCashStock.action",produces = "text/html;charset=UTF-8")
	public String insertCashStock(@ModelAttribute("SpringWeb")CashStock cashStockdomain) throws Exception {
		System.out.println("这是新增现金库存表的方法");

		cashStockdomain.setStatisticDate(AllUtil.getDate(cashStockdomain.getStrDate()));
		int flag=cashStockService.insertCashStock(cashStockdomain);//调用新增的方法(返回结果)
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}		
		
	}
	/**
	 * 自动生成编号
	 * @param response
	 * @param request
	 * @param cashArapStock
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="autoBianhao.action",produces="text/html;charset=utf-8")
	public void CashStock(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")CashStock cashStockdomain)throws Exception{
		String cashStockCode=autoBianService.getAutoBianhao("cash_stock", "XJKC", "cash_stock_code", "cash_statistic_date", new Date(System.currentTimeMillis()));
		response.getWriter().print(cashStockCode);
	}
	
	/**
	 * 通过ID列查询每行的数据
	 * @param role 角色实体类
	 * @return 返回查询出来的数据
	 */
	@ResponseBody
	@RequestMapping(value="selectOneByCode.action",produces="text/html;charset=UTF-8")
	public String selectOneByCode(@ModelAttribute("springWeb")CashStock cashStockdomain){
		CashStock jsonCashStock = cashStockService.selectOneByCode(cashStockdomain.getCashStockCode());
		jsonCashStock.setStrDate(jsonCashStock.getStatisticDate().toString());
		Gson gson = new Gson();
		return gson.toJson(jsonCashStock);
	}
}
