package com.yidu.reportManagement.controller;

import java.sql.Date;
import java.util.HashMap;

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
import com.yidu.reportManagement.service.CashPositionReportService;
import com.yidu.util.AllUtil;

/**
 * 现金头寸报表控制器
 * @author ZengYanZhan
 * @date 2017年12月2日
 * @time 下午8:04:50
 */
@Controller
public class CashPositionReportController {
	@Autowired
	private CashPositionReportService cashPositionReportService;//自动装配现金寸处理层

	/**
	 * 查询现金寸头数据
	 * @param reportParams 封装参数
	 * @return 现金寸头数据
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/selectCashPositionReport.action",produces="text/html;charset=UTF-8")
	public String selectCashPositionReport(@ModelAttribute() ReportParams reportParams,HttpServletRequest request) throws Exception{
		//调用业务逻辑处理层
		HttpSession session=request.getSession(false);
		if(session==null){
			session=request.getSession();
		}
		Fund fund=(Fund)session.getAttribute("fund");//基金信息
		reportParams.setFundCode(fund.getFundCode());//通过当前会话得到基金代码
		if(reportParams.getFirstStrDate()==null || reportParams.getFirstStrDate().equals("")){//判断日期 
			Date date=new Date(System.currentTimeMillis());//得到当前时间
			reportParams.setFirstStrDate(AllUtil.getStringDate(date));//设置到参数中
		}
		Date secondStr=AllUtil.getDate(reportParams.getFirstStrDate(), 1);//得到明天日期
		reportParams.setSecondStrDate(AllUtil.getStringDate(secondStr)); //设置并赋值
		Gson gson=new Gson();//解析为json对象
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("total", 7);
		map.put("rows", cashPositionReportService.selectCashPositionReport(reportParams));
		return gson.toJson(map);
	}
}
