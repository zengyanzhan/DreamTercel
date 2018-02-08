package com.yidu.reportManagement.controller;

import java.io.PrintWriter;
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
import com.yidu.reportManagement.domain.StockFluctuate;
import com.yidu.reportManagement.service.StockFluctuateService;
import com.yidu.util.AllUtil;

/**
 * 股票价格波动控制器
 * @author HeXiXian
 * @date   2017年12月6日
 * @time   上午10:51:19
 *
 */
@Controller
public class StockFluctuateController {
		@Autowired
		StockFluctuateService stockFluctuateService;
		@ResponseBody
		@RequestMapping(value="stockFluctuate.action",produces="text/html;charset=UTF-8")
		public String selectStockFluctuate(@ModelAttribute("springmvc")StockFluctuate stockFluctuate)throws Exception{
			System.err.println("股票价格波动表");
			Map<String, Object> map=stockFluctuateService.selectFluctuateService(stockFluctuate);
			List<StockFluctuate> stockFluctuatelist=(List) map.get("cursor");
			for (StockFluctuate stockFluctuates:stockFluctuatelist) {
				String createDates=AllUtil.getStringDate(stockFluctuates.getEnteringDate());
				stockFluctuates.setStrEnteringDate(createDates);
				System.err.println(createDates);
			}
			System.out.println("实体类="+stockFluctuate);
			for (int i = 0; i < stockFluctuatelist.size(); i++) {
				StockFluctuate data=stockFluctuatelist.get(i);
				Double mun=AllUtil.getRoundUp((data.getClosingPrice()-data.getOpeningPrice())/data.getOpeningPrice()*100,2);
				System.out.println("四舍五入"+mun);
				System.out.println(mun);
				data.setPricelimit(mun);
			}
			Integer rows=(Integer) map.get("rowsTotal");
			HashMap<String, Object> maps=new HashMap<String,Object>();
			maps.put("total", rows);
			maps.put("rows", stockFluctuatelist);
			Gson gson=new Gson();
			String priceDatagson=gson.toJson(maps);
			return priceDatagson;
		}
		@ResponseBody
		@RequestMapping(value="stockFluctuateImage.action",produces="text/html;charset=UTF-8")
		public String stockFluctuateImage(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("springmvc")StockFluctuate stockFluctuate)throws Exception{
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			System.err.println("进来了生成图表");
			stockFluctuate.setPage(1);
			stockFluctuate.setRows(10);
			stockFluctuate.setSortOrder("asc");
			Map<String, Object> map=stockFluctuateService.selectFluctuateService(stockFluctuate);
			List<StockFluctuate> stockFluctuatelist=(List) map.get("cursor");
			System.out.println("===="+stockFluctuatelist);
			for (StockFluctuate stockFluctuates:stockFluctuatelist) {
				String createDates=AllUtil.getStringDate(stockFluctuates.getEnteringDate());
				stockFluctuates.setStrEnteringDate(createDates);
				System.err.println("createDates"+createDates);
				System.err.println(stockFluctuates.getStrEnteringDate());
			}
			Gson gson=new  Gson();
			String fundli=gson.toJson(stockFluctuatelist);
			out.print(fundli);
			return null;
		}
		
}
