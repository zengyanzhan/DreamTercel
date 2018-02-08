package com.yidu.dayEnd.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.yidu.dayEnd.domain.BondPay;
import com.yidu.dayEnd.service.BondPayService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;

/**
 * 债券支付控制器
 * @author 肖光宇
 * @date 2017年11月20日
 * @time 下午1:46:01
 *
 */
@Controller
public class BondPayController {
	Gson gson=new Gson();
	@Autowired
	BondPayService bondPayService;
	/**
	 * 查询债券支付数据
	 * @param bondPay 债券支付实体类
	 * @param request 请求对象
	 * @return json数据
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectBondPay.action",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	public String selectBondPay(@ModelAttribute("SpringWeb")BondPay bondPay,HttpServletRequest request) throws Exception{
		   HttpSession session=request.getSession(false);//得到一个会话
		    if(session==null){
		    	session=request.getSession(true);
		    }
		    Fund fund=(Fund)session.getAttribute("fund");//得到基金实体类
		    bondPay.setFundCode(fund.getFundCode());
		//查询债券支付数据
		List<BondPay>bondPayList= bondPayService.selectBondPay(bondPay);
		for (BondPay bondPays:bondPayList) {
			String strBusiness=AllUtil.getStringDate(bondPays.getBusinessDate());//把业务日期转为字符串
			bondPays.setStrBusiness(strBusiness);
		}
		//查询总记录数
		Integer rows=bondPayService.selectBondPayCount(bondPay);
		//创建一个哈希map
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("total", rows);
		map.put("rows", bondPayList);
		//转为json格式
		String bondPays=gson.toJson(map);
		return bondPays;
	}
	/**
	 * 统计债券支付
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param bondPay 债券支付
	 * @return 成功信息
	 */
	@ResponseBody
	@RequestMapping(value="/tongJiBondPay.action",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	public String tongJiBondPay(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("SpringWeb")BondPay bondPay){
		boolean flag=bondPayService.tongJiZhaiQuan(bondPay);
		String msg=null;
		if(flag){
			msg="统计成功";
		}
		return msg;
	}


}
