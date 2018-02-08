package com.yidu.parameters.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.parameters.domain.StockPlate;
import com.yidu.parameters.service.StockPlateService;

/**
 * 股票信息的控制器类
 * @author 杨丽
 * @date 2017年11月16日	
 * @time 下午3:55:54
 *
 */
@Controller
public class StockPlateController {
	@Autowired
	StockPlateService stockPlateService;
	/**
	 * 查询的方法
	 * @param response	响应对象
	 * @param request	请求对象
	 * @return	返回一个map
	 * @throws IOException	IO异常
	 */
	@ResponseBody
	@RequestMapping(value="selectStockPlates.action")
	public Map selectStockPlates(HttpServletResponse response,HttpServletRequest request) throws IOException{
		//得到股票板块编号
		String stockBlateCode=request.getParameter("stockBlateCode");
		//得到股票板块名称
		String stockBlateName=request.getParameter("stockBlateName");
		//得到父功能id
		StockPlate stockPlate=new StockPlate();
		//set得到股票编号，名称值
		stockPlate.setStockBlockCode(stockBlateCode);
		stockPlate.setStockBlockName(stockBlateName);
		//调用查询股票的方法
		List<StockPlate> stockPlates=stockPlateService.selectStockPlates(stockPlate);
		//循环遍历股票板块集合
		for (StockPlate stock : stockPlates) {
			List<StockPlate> stockPlatesList=stockPlateService.selectStockPlatesById(stock.getStockBlockCode());
			stock.setChildren(stockPlatesList);
		}
		//new一个map
		HashMap map=new HashMap();
		map.put("total", 100);
		map.put("rows", stockPlates);
		return map;
	}
	/**
	 * 自动生成id
	 * @param response	响应参数
	 * @param request	请求参数
	 */
	@RequestMapping(value="autoId.action")
	public void autoId(HttpServletResponse response,HttpServletRequest request){
		//得到股票板块id
		String stockBlockCode=request.getParameter("stockBlockCode");
		//调用自动生成id方法
		String autoId = stockPlateService.autoId(stockBlockCode);
		try {
			//输出股票id
			response.getWriter().print(autoId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查询出父功能id的方法
	 * @param response	响应对象
	 * @param request	请求对象
	 * @return	集合list
	 */
	@ResponseBody
	@RequestMapping(value="selectFIds.action")
	public List<StockPlate> selectFIds(HttpServletResponse response,HttpServletRequest request){
		//股票板块实体类
		StockPlate stockPlate=new StockPlate();
		//创建集合调用查询股票板块的方法
		List<StockPlate> list=stockPlateService.selectStockPlates(stockPlate);
		
		return list;
	}
	/**
	 * 增加股票板块信息的方法
	 * @param response	响应对象
	 * @param request	请求对象
	 * @param stockPlate	股票板块信息对象
	 * @return	返回0 增加失败	返回1增加成功
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="insertStockPlate.action")
	public String insertStockPlate(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("PringWeb")StockPlate stockPlate)throws Exception{
		//定义变量 调用增加股票板块的方法
		int flag=stockPlateService.insertStockPlate(stockPlate);
		if(flag!=0){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 通过id删除的方法
	 * @param response	响应对象
	 * @param request	请求对象
	 * @param stockPlate	股票板块信息对象
	 * @throws Exception	抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="deleteStockPlateByIds.action")
	public String deleteStockPlateByIds(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")StockPlate stockPlate)throws Exception{
		String stockCodeIds=null;
		//调用通过id删除股票板块的方法
		stockPlateService.deleteStockPlateByIds(stockPlate.getStockBlockCode());
		
		return null;
		
	}
	/**
	 * 修改的方法
	 * @throws Exception	抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="updateStockPlateByIds.action")
	public StockPlate updateStockPlateByIds(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")StockPlate stockPlate)throws Exception{
		//得到id  调用修改股票板块的方法
		stockPlate=stockPlateService.updateStockPlateByIds(stockPlate.getStockBlockCode());
		return stockPlate;
	} 
	@RequestMapping(value="updateStockPlate.action")
	public void updateStockPlate(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")StockPlate stockPlate){
		//调用修改股票板块的方法
		stockPlateService.updateStockPlate(stockPlate);
		
	}
}
