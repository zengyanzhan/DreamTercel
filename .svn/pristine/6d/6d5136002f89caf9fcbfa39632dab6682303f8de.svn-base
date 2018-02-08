package com.yidu.reportManagement.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.parameters.domain.Fund;
import com.yidu.reportManagement.domain.DifferenceReport;
import com.yidu.reportManagement.service.DifferenceReportService;

/**
 * 轧差表控制器类
 * @author Wang
 * @date 2017年12月12日
 * @time 上午8:55:36
 */
@Controller
public class DifferenceReportContoller {
	@Autowired
	DifferenceReportService differenceReportService;
	@ResponseBody
	@RequestMapping(value="selectDifferenceReport.action",produces="text/html;charset=UTF-8")
	protected String selectDifferenceReport(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DifferenceReport differenceReport) throws Exception {
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		Map<String, Object> map=differenceReportService.selectDifferenceReport(differenceReport, fund.getFundCode());
		Gson gson=new Gson();
		return gson.toJson(map);	
	}
}
