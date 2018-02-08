package com.yidu.stockControl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yidu.parameters.domain.Fund;
import com.yidu.stockControl.domain.TaStock;
import com.yidu.stockControl.service.TaStockService;
import com.yidu.taManagement.domain.TaTradData;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;

 /**
  * ta库存的控制器类
  * @author  ZhouMuJiao
  * @date2017年11月14日
  * @time下午6:38:40
  */
@Controller
public class TaStockController{
	
	/**
	 * 查询
	 */
	@Autowired
	TaStockService taStockService;
	@Autowired
	AutoBianService autoBianService;
	@ResponseBody
	@RequestMapping(value="/selectTaStocks.action",produces="text/html;charset=UTF-8")
	public String selectTaStocks(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaStock taStock) throws Exception{
		//判断日期是否为空
			if(taStock.getStrDate()!=null && !taStock.getStrDate().equals("")){
				taStock.setStatisticDate(AllUtil.getDate(taStock.getStrDate()));
			}
			//得到一个会话
		HttpSession session=request.getSession();
		//得到基金实体类
		Fund fund=(Fund) session.getAttribute("fund");
		//通过基金实体类得到基金代码
		taStock.setFundCode(fund.getFundCode());
		String sqlWhere=taStockService.bufferWhere(taStock);
		String tableName="ta_stock";
		HashMap<String, Object> map=taStockService.selectTaStocks(tableName, sqlWhere, taStock.getPage(), taStock.getRows(), taStock.getRowsTotal(), taStock.getOrderColumn(), taStock.getOrderStyle());
		//格式化日期
		List<TaStock> list=(List<TaStock>) map.get("taStockList");
		for(TaStock taStocks:list){
			taStocks.setStrDate(taStocks.getStatisticDate().toString());	
		}
		//创建Gson
		Gson gson=new Gson();
		//创建一个HashMap集合，用于格式化成json对象
		HashMap<String,Object> jsonMap = new HashMap<String,Object>();
		//总记录数
		jsonMap.put("total", map.get("rowsTotal"));
		//数据集合
		jsonMap.put("rows", list);
		//集合转成gson对象
		return gson.toJson(jsonMap);
	}
	/**
	 * 删除
	 * @param response
	 * @param request
	 * @param taStock
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/deleteTaStockByTaStockId.action",produces="text/html;charset=UTF-8")
	public String deleteTaStockByTaStockId(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaStock taStock) throws Exception{
		int i = taStockService.deleteTaStockByTaStockId(taStock.getTaStockCode());
		if (i>0) {
			return "删除成功";
		}else{
			return "删除失败";
		}
	}
	/**
	 * 修改
	 * @param response
	 * @param request
	 * @param taStock
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/updateTaStock.action")
	public String updateTaStock(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaStock taStock)throws Exception{
		if(taStock.getStrDate()!=null && !taStock.getStrDate().equals("")){
			taStock.setStatisticDate(AllUtil.getDate(taStock.getStrDate()));
		}
		int size=taStockService.updateTaStock(taStock);
		if(size!=0){
			return "修改成功";
		}else{
			return "修改失败";
		}
	}
	/**
	 * 增加
	 * @param response
	 * @param request
	 * @param taStock
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/insertTaStock.action")
	public String insertTaStock(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaStock taStock)throws Exception{
		response.setCharacterEncoding("UTF-8");
		if(taStock.getStrDate()!=null && !taStock.getStrDate().equals("")){
			taStock.setStatisticDate(AllUtil.getDate(taStock.getStrDate()));
		}
		int size=taStockService.insertTaStock(taStock);
		if(size!=0){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 通过ID查询
	 * @param response
	 * @param request
	 * @param taStock
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/selectTaStockById.action")
	public TaStock selectTaStockById(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaStock taStock)throws Exception{
		TaStock stock= taStockService.selectTaStockById(taStock.getTaStockCode());
		
		if(stock.getStatisticDate()!=null && !stock.getStatisticDate().equals("")){
			stock.setStrDate(AllUtil.getStringDate(stock.getStatisticDate()));
		}
		return stock;
	}
	/**
	 * 自动增长
	 * @param response
	 * @param request
	 * @param taStock
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/ziDongShengCheng.action",produces="text/html;charset=utf-8")
	public void ziDongShengCheng(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaStock taStock)throws Exception{
		String taStockCode=autoBianService.getAutoBianhao("ta_stock", "TAKC", "ta_stock_code", "statistic_date", new Date(System.currentTimeMillis()));
		response.getWriter().print(taStockCode);
	}
	/**
	 * 查询基金编号
	 * @param response
	 * @param request
	 * @param taStock
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/taStockByFundId.action",produces="text/html;charset=UTF-8")
	public void taStockByFundId(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaStock taStock) throws Exception {
		HttpSession session=request.getSession(false);
		Fund fund=(Fund) session.getAttribute("fund");
		String fundCode=fund.getFundCode();
		response.getWriter().print(fundCode);
	}
}
