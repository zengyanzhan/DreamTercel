package com.yidu.dayEnd.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yidu.businessData.domain.PriceData;
import com.yidu.dayEnd.domain.NetValue;
import com.yidu.dayEnd.service.AssetValuationService;
import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.service.FundService;
import com.yidu.parameters.domain.Fund;
import com.yidu.system.domain.HoildayXiao;
import com.yidu.system.domain.Holiday;
import com.yidu.system.service.HoildayXiaoSerice;
import com.yidu.system.service.HolidayService;
import com.yidu.util.AllUtil;
import com.yidu.util.dao.UtilDao;

/**
 * 资产估值controller
 * @author Lee
 * @date 2017年11月13日
 * @time 上午10:29:52
 */
@Controller
public class AssetValuationController{
	@Autowired
	private AssetValuationService assetValuationService;

	@RequestMapping(value="assetValuationSelect.action")
	public ModelAndView assetValuationSelect(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {

		String appraisementMoney=null;
		String clearingModelMoney=null;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//输出流
		PrintWriter out=response.getWriter();
		//得到session
		
		HttpSession session = request.getSession(false);
		//判读session为空
		if(session==null)
		{
			//创建新的session
			session=request.getSession();
		}

		//得到估值日期
		String appraisementDate=request.getParameter("appraisementDate");
		//得到估值类型
		String appraisementType=request.getParameter("appraisementType");
		//得到基金代码id
		Fund fund = (Fund) session.getAttribute("fund");
		String strFundId=fund.getFundCode();
		//以“,”切割
		String [] appraisementTypes=appraisementType.split(",");
		//判断数组的长度
		if(appraisementTypes.length==1){
			String oneType=appraisementTypes[0];
			//判断估值的类型
			if(oneType.equals("1")){
				appraisementMoney=this.assetValuationService.appraisement(appraisementDate, strFundId);
			}else{
				clearingModelMoney=this.assetValuationService.clearingModel(appraisementDate, strFundId);
			}
		}else{
			appraisementMoney=this.assetValuationService.appraisement(appraisementDate, strFundId);
			clearingModelMoney=this.assetValuationService.clearingModel(appraisementDate, strFundId);
		}
		out.print(clearingModelMoney+","+appraisementMoney);
		out.flush();
		out.close();
		return null;
	}
	@RequestMapping(value="enddayhoildaySelect.action")
	public ModelAndView hoildaySelect(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String appraisementDate=request.getParameter("appraisementDate");
		List<HoildayXiao> list=this.assetValuationService.selectHoildayBydate(appraisementDate);
		if(list.size()!=0){
			out.print("flase");
		}else{
			out.print("true");
		}
		return null;
	}
}
