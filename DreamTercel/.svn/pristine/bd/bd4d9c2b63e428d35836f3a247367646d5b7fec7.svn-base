package com.yidu.dayEnd.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.dayEnd.domain.CashPay;
import com.yidu.dayEnd.service.CashPayService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;

@Controller
/**
 * 现金账户支付控制器
 * @author 肖光宇
 * @date 2017年11月22日
 * @time 下午2:44:16
 *
 */
public class CashPayController {
	Gson gson=new Gson();
	@Autowired
	CashPayService cashPayService;
	/**
	 * 现金账户支付
	 * @param cashPay 现金账户支付实体类
	 * @param request 请求对象
	 * @return json数据
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectCashPay.action",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	public String selectCashPay(@ModelAttribute("SpringWeb")CashPay cashPay,HttpServletRequest request) throws Exception{
		 HttpSession session=request.getSession(false);//得到一个会话
		    if(session==null){
		    	session=request.getSession(true);
		    }
		    Fund fund=(Fund)session.getAttribute("fund");//得到基金实体类
		    cashPay.setFundCode(fund.getFundCode());
		//查询现金账户支付数据
		List<CashPay> cashPayList= cashPayService.selectCashPay(cashPay);
		for (CashPay cashs:cashPayList) {
			String strBusiness= AllUtil.getStringDate(cashs.getBusinessDate());//把业务日期转为字符串
			cashs.setStrBusiness(strBusiness);
		}
		//查询现金账户支付总条数
		Integer rows=cashPayService.selectnCashPayCount(cashPay);
		//创建一个hashMap
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("rows", cashPayList);
		map.put("total", rows);
		String cashpa=gson.toJson(map);
		return cashpa;
	}
	/**
	 * 统计现金账户支付
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param bondPay 现金支付
	 * @return 成功信息
	 */
	@ResponseBody
	@RequestMapping(value="/tongJiMoney.action",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	public String tongJiMoney(@ModelAttribute("SpringWeb")CashPay cashPay){
		boolean flag=cashPayService.tongJiXianJin(cashPay);//统计现金
		String  msg=null;
		if(flag){
			msg="统计成功";
		}
		return msg;


	}
	/**
	 * 两费支付
	 * @param cashPay 两费支付实体类
	 * @param request 请求对象
	 * @return json数据
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectTwoMoney.action",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	public String selectTwoMoney(@ModelAttribute("SpringWeb")CashPay cashPay,HttpServletRequest request) throws Exception{
		 HttpSession session=request.getSession(false);//得到一个会话
		    if(session==null){
		    	session=request.getSession(true);
		    }
		    Fund fund=(Fund)session.getAttribute("fund");//得到基金实体类
		    cashPay.setFundCode(fund.getFundCode());
		List<CashPay> towMoneyList=cashPayService.selectTwoMoney(cashPay);//查询两费集合
		for (CashPay cashs:towMoneyList) {
			String strBusiness= AllUtil.getStringDate(cashs.getBusinessDate());//业务日期转字符串
			cashs.setStrBusiness(strBusiness);
		}
		Integer rows=cashPayService.selectTwoMoneyCount(cashPay);//查询两费数量
		//创建一个hashMap
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("rows", towMoneyList);
		map.put("total", rows);
		String twoMoney=gson.toJson(map);
		return twoMoney;
	}
	/**
	 * 统计两费支付
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param bondPay 两费支付实体类
	 * @return 成功信息
	 */
	@ResponseBody
	@RequestMapping(value="/tongJiTwoMoney.action",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	public String tongJiTwoMoney(@ModelAttribute("SpringWeb")CashPay cashPay){
		boolean flag=cashPayService.tongJiTwoMoney(cashPay);//统计两费
		String  msg=null;
		if(flag){
			msg="统计成功";
		}
		return msg;
	}

}
