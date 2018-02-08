package com.yidu.Android.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.google.gson.Gson;
import com.yidu.Android.domain.AndroidFundInvestBlockReport;
import com.yidu.Android.service.AndroidFundInvestBlockReportService;
import com.yidu.util.AllUtil;
@Controller
public class AndroidFundInvestBlockReportController {
	
	@Autowired
	AndroidFundInvestBlockReportService fundInvestBlockReportService;
	@RequestMapping(value="AndroidfundInvestBlocksImage.action")
	public String fundInvestBlocksImage(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("SpringWeb")AndroidFundInvestBlockReport fundInvestBlockReport) throws IOException{
		System.err.println("进来了生成图表");
		PrintWriter out=response.getWriter();
		fundInvestBlockReport.setPage(1);
		fundInvestBlockReport.setRows(10);
		fundInvestBlockReport.setRowsTotal(10);
		String sqlWhere=fundInvestBlockReportService.bufferWhere(fundInvestBlockReport);
		HashMap<String, Object> map=fundInvestBlockReportService.selectFundInvestGroups(fundInvestBlockReport.getTableName(),sqlWhere, fundInvestBlockReport.getPage(), fundInvestBlockReport.getRows(), fundInvestBlockReport.getRowsTotal(), fundInvestBlockReport.getOrderColumn(), fundInvestBlockReport.getOrderStyle());
		List<AndroidFundInvestBlockReport> list=(List<AndroidFundInvestBlockReport>) map.get("list");
		System.out.println("sssssssssssssss"+list.size());
		System.err.println("有数据嘛"+fundInvestBlockReport.getStockBlockName()+","+fundInvestBlockReport.getAssecurityQuantity());
		//创建Gson
		Gson gson=new Gson();
		String fundList=gson.toJson(list);
		out.print(fundList);
		
		return null;
	}

}
