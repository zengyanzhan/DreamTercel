package com.yidu.reportManagement.controller;

import java.util.List;
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
import com.yidu.reportManagement.service.SeatDealDetailReportService;

/**
 * 席位成交明细报表控制器
 * @author ZengYanZhan
 * @date 2017年12月2日
 * @time 下午1:06:37
 */
@Controller
public class SeatDealDetailReportController {
	@Autowired
	private SeatDealDetailReportService seatDealDetailReportService;//自动装配席位成交明细业务处理

	/**
	 * 查询席位成交明细报表数据
	 * @return String 转为json对象数据
	 */
	@ResponseBody
	@RequestMapping(value="/selectSeatDealDetailReport.action",produces="text/html;charset=UTF-8")
	public String selectSeatDealDetailReport(@ModelAttribute() ReportParams reportParams,HttpServletRequest request){
		 //调用业务逻辑处理
		HttpSession session=request.getSession(false);//得到当前会话的基金信息
		if(session==null){
			session=request.getSession();
		}
		Fund fund=(Fund)session.getAttribute("fund");
		reportParams.setFundCode(fund.getFundCode());//得到当前基金代码
		//首次进入该界面 没有日期时，进入该方法设置开始以及结束日期
		if((reportParams.getFirstStrDate()==null || reportParams.getFirstStrDate().equals("")) && (reportParams.getSecondStrDate()==null || reportParams.getSecondStrDate().equals(""))){
			reportParams.setFirstStrDate("2017-11-01");
			reportParams.setSecondStrDate("2018-11-11");
		}
		List list=seatDealDetailReportService.selectSeatDealDetailReport(reportParams);
		Gson gson=new Gson(); //解析json对象
		return gson.toJson(list);
	}
}
