package com.yidu.reportManagement.controller;

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
import com.yidu.reportManagement.domain.StockeQuity;
import com.yidu.reportManagement.service.StockeQuityService;
import com.yidu.transactionProcessing.domain.Interests;
import com.yidu.util.AllUtil;

/**
 * 股票权益报表
 * @author XiaoYuJie
 * @date 2017年12月6日
 * @time 下午7:24:55
 */
@Controller
public class StockeQuityController {
	@Autowired
	StockeQuityService stockeQuityService;
	@ResponseBody
	@RequestMapping(value="/selectStockeQuity.action",produces="text/html;charset=UTF-8")
	public String selectStockeQuity(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("springWeb")StockeQuity stockeQuity) throws Exception {
		System.out.println("查询");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.err.println("stockeQuity"+stockeQuity);
		String sqlWhere=stockeQuityService.buffwhere(stockeQuity);
		Map<String,Object> selectMap=stockeQuityService.selectStockeQuity(stockeQuity.getTableName(),sqlWhere,stockeQuity.getPage(), stockeQuity.getRows(), stockeQuity.getRowsTotal(), stockeQuity.getOrderColumn(), stockeQuity.getOrderStyle());
		List<StockeQuity> stockeQuitysDataList=(List<StockeQuity>) selectMap.get("cursor");
		//加强for循环 将查出来的date型转为String型在界面上显示出来
		System.err.println("stockeQuitysDataList"+stockeQuitysDataList);
		for(StockeQuity stockeQuitys:stockeQuitysDataList){
			try {
				stockeQuitys.setStrDate(AllUtil.getStringDate(stockeQuitys.getExRights()));		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	 
		Map listMap=new HashMap();
		listMap.put("total", selectMap.get("rowsTotal"));
		listMap.put("rows", stockeQuitysDataList);
		System.out.println("listMap"+listMap);
		Gson gson=new Gson();
		return gson.toJson(listMap);
	}
}
