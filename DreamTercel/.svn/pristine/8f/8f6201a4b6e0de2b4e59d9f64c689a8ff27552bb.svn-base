package com.yidu.reportManagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.parameters.domain.Fund;
import com.yidu.reportManagement.domain.ReportParams;
import com.yidu.reportManagement.domain.SeatTradeReport;
import com.yidu.reportManagement.service.SeatTradeReportService;

/**
 * 席位交易量控制器
 * @author ZengYanZhan
 * @date 2017年12月1日
 * @time 下午7:38:40
 */
@Controller
public class SeatTradeReportController {
	@Autowired
	private SeatTradeReportService seatTradeReportService;//自动装配席位交易

	/**
	 * 查询席位交易量方法
	 * @return 字符串 
	 */
	@ResponseBody
	@RequestMapping(value="/selectSeatTradeReport.action",produces="text/html;charset=UTF-8")
	public String selectSeatTradeReport(HttpServletRequest request,@ModelAttribute() ReportParams reportParams){
		//通过当前会话得到基金代码
		HttpSession session=request.getSession(false);
		if(session==null){
			session=request.getSession();
		}
		Fund fund=(Fund)session.getAttribute("fund");//得到会话
		reportParams.setFundCode(fund.getFundCode());//得到会话的基金代码
		//首次进入该界面 没有日期时，进入该方法设置开始以及结束日期
		if((reportParams.getFirstStrDate()==null || reportParams.getFirstStrDate().equals("")) && (reportParams.getSecondStrDate()==null || reportParams.getSecondStrDate().equals(""))){
			reportParams.setFirstStrDate("2017-11-01");
			reportParams.setSecondStrDate("2018-11-11");
		}
		//调用业务逻辑处理
		List<Object> list=seatTradeReportService.selectSeatTradeReport(reportParams);
		Gson gson=new Gson();//解析json对象
		return gson.toJson(list);
	}


	/**
	 * 查询图表数据
	 * @param reportParams 参数
	 * @return 两地合计数据
	 */
	@ResponseBody
	@RequestMapping(value="/selectSeatTradeReportChart.action",produces="text/html;charset=UTF-8")
	public String selectSeatTradeReportChart(@ModelAttribute() ReportParams reportParams,HttpServletRequest request){
		HttpSession session=request.getSession(false);
		if(session==null){
			session=request.getSession();
		}
		Fund fund=(Fund)session.getAttribute("fund");//得到会话
		reportParams.setFundCode(fund.getFundCode());//得到会话的基金代码
		//首次进入该界面 没有日期时，进入该方法设置开始以及结束日期
		if((reportParams.getFirstStrDate()==null || reportParams.getFirstStrDate().equals("")) && (reportParams.getSecondStrDate()==null || reportParams.getSecondStrDate().equals(""))){
			reportParams.setFirstStrDate("2017-11-01");
			reportParams.setSecondStrDate("2018-11-11");
		}
		List<Object> list=seatTradeReportService.selectSeatTradeReport(reportParams);
		Gson gson=new Gson();
		return gson.toJson(list);
	}

}
