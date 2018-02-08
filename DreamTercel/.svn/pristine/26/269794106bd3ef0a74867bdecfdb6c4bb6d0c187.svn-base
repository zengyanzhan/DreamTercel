package com.yidu.reportManagement.controller;

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
import com.yidu.dayEnd.domain.NetValue;
import com.yidu.parameters.domain.Fund;
import com.yidu.reportManagement.domain.FundInvestBlockReport;
import com.yidu.reportManagement.service.FundInvestBlockReportService;
import com.yidu.util.AllUtil;

/**
 *基金投资板块表控制器类 
 * @author 杨丽
 * @date 2017年12月14日	
 * @time 上午9:09:00
 *
 */
@Controller
public class FundInvestBlockReportController {
	@Autowired
	FundInvestBlockReportService fundInvestBlockReportService;
	@ResponseBody
	@RequestMapping(value="selectFundInvestBlocks.action",produces="text/html;charset=UTF-8")
	public String selectFundInvestBlocks(HttpServletRequest request,@ModelAttribute("SpringWeb")FundInvestBlockReport fundInvestBlockReport) throws IOException{
		System.err.println("进来了");
		//得到session
		HttpSession session=request.getSession();
		//得到基金编号
		Fund fund=(Fund) session.getAttribute("fund");
		//给基金赋值
		fundInvestBlockReport.setFundCode(fund.getFundCode());
		
		//调用查询基金id的方法 加入集合
		List<FundInvestBlockReport> list=fundInvestBlockReportService.selectFundInvestGroups(fundInvestBlockReport);

		
		//创建Gson
		Gson gson=new Gson();
		//new一个map
		HashMap<String,Object> jsonMap = new HashMap<String,Object>();
		//put集合
		jsonMap.put("rows", list);
		//集合转成json对象
		return gson.toJson(jsonMap);

	}
	@ResponseBody
	@RequestMapping(value="fundInvestBlocksImage.action",produces="text/html;charset=UTF-8")
	public String fundInvestBlocksImage(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("SpringWeb")FundInvestBlockReport fundInvestBlockReport) throws IOException{
		response.setCharacterEncoding("UTF-8");
		//输出流
		PrintWriter out=response.getWriter();
		//得到基金编号
		Fund fund=(Fund) request.getSession().getAttribute("fund");
		//给基金赋值
		fundInvestBlockReport.setFundCode(fund.getFundCode());
		//得到页数 行数
		fundInvestBlockReport.setPage(fundInvestBlockReport.getPage());
		fundInvestBlockReport.setRows(fundInvestBlockReport.getRows());
		fundInvestBlockReport.setRowsTotal(fundInvestBlockReport.getRowsTotal());
		//调用拼接条件
		String sqlWhere=fundInvestBlockReportService.bufferWhere(fundInvestBlockReport);
		//调用基金编号查询方法
		List<FundInvestBlockReport> list=fundInvestBlockReportService.selectFundInvestGroups(fundInvestBlockReport);
		//new一个map
		HashMap<String,Object> map = new HashMap<String,Object>();
		//创建Gson
		Gson gson=new Gson();
		
		map.put("rows", list);
		//集合转成gson对象
		String obj=gson.toJson(list);
		//输出
		out.print(obj);
		
		return null;
	}

}
