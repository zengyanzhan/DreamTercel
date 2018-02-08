package com.yidu.parameters.controller;

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
import com.yidu.parameters.domain.ExchangeRate;
import com.yidu.parameters.service.ExchangeRateService;
import com.yidu.util.service.AutoBianService;

/**
 * 交易品种费率控控制器类
 * @author Wang
 * @date 2017年11月13日
 * @time 下午7:21:27
 */
@Controller
public class ExchangeRateController {
	@Autowired
	ExchangeRateService exchangeRateService;
	@Autowired
	AutoBianService autoBianHao;
	@ResponseBody
	@RequestMapping("/autoCreateCode.action")
	/**
	 * 自动生成编号
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	protected String autoCreateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String exchangeCode=autoBianHao.getAutoBianhao("exchange_breed_rate", "JYSPZFL", "exchange_code", null, null);
		System.out.println("bianhao="+exchangeCode);
		return exchangeCode;
	}
	/**
	 * 查询交易品种费率
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectExchangeRate.action",produces="text/html;charset=UTF-8")
	protected String selectExchangeRate(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")ExchangeRate exchangeRate) throws Exception {
		Map<String, Object> exchangeRateMap=exchangeRateService.selectExchangeRate(exchangeRate);
		Gson gson=new Gson();
		String exchangeRateJson=gson.toJson(exchangeRateMap);
		return exchangeRateJson;
	}
	/**
	 * 增加交易品种费率
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param exchangeRate 交易品种费率实体对象
	 * @return  是否增加成功标志
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertExchangeRate.action",produces="text/html;charset=UTF-8")
	protected String insertExchangeRate(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")ExchangeRate exchangeRate) throws Exception {
		System.err.println(exchangeRate);
		int rows=exchangeRateService.insertExchangeRate(exchangeRate);
		return rows+"";
	}
	/**
	 * 修改交易品种费率
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param exchangeRate 交易品种费率实体对象
	 * @return  是否修改成功标志
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping("/updateExchangeRate.action")
	protected String updateExchangeRate(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")ExchangeRate exchangeRate) throws Exception {
		System.err.println(exchangeRate);
		int rows=exchangeRateService.updateExchangeRate(exchangeRate);
		return rows+"";
	}
	/**
	 * 删除交易品种费率
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param exchangeRate 交易品种费率实体对象
	 * @return  是否删除标志
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping("/deleteExchangeRate.action")
	protected String deleteExchangeRate(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")ExchangeRate exchangeRate) throws Exception {
		System.out.println(exchangeRate.getExchangeCode());
		int rows=exchangeRateService.deleteExchangeRate(exchangeRate);
		System.out.println("rows"+rows);
		return rows+"";
	}
	@ResponseBody
	@RequestMapping("/selectExchangeRateById.action")
	protected String selectExchangeRateById(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")ExchangeRate exchangeRate) throws Exception {
		List<ExchangeRate> exchangeRateList=exchangeRateService.selectExchangeRateById(exchangeRate.getExchangeCode());
		Gson gson=new Gson();
		String exchangeRateJson=gson.toJson(exchangeRateList);
		return exchangeRateJson;
	}
	@ResponseBody
	@RequestMapping(value="/selectExchangeNameSelect.action",produces="text/html;charset=UTF-8")
	protected String selectExchangeNameSelect(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")ExchangeRate exchangeRate) throws Exception {
		System.err.println(exchangeRate);
		String flag=null;
		List<ExchangeRate> exchangeRateList=exchangeRateService.selectExchangeNameSel(exchangeRate);
		if(exchangeRateList.size()!=0){
			flag="存在";
		}else{
			flag="不存在";
		}
		return flag;
	}
}
