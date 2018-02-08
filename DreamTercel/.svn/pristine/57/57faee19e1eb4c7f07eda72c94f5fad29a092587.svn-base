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
import com.yidu.parameters.domain.Broket;
import com.yidu.parameters.service.BroketService;
import com.yidu.util.service.AutoBianService;

/**
 * 券商信息控制器类
 * @author Wang
 * @date 2017年11月16日
 * @time 上午10:55:55
 */
@Controller
public class BroketController {
	@Autowired
	BroketService broketService;
	@Autowired
	AutoBianService autoBianHao;
	/**
	 * 自动生成编号
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/autoCreateBrokerCode.action",produces="text/html;charset=UTF-8")
	protected String autoCreateBrokerCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String brokerCode=autoBianHao.getAutoBianhao("broker", "QS", "broker_code", null, null);
		System.out.println("bianhao="+brokerCode);
		return brokerCode;
	}

	/**
	 * 查询券商信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectBorket.action",produces="text/html;charset=UTF-8")
	protected String selectBorket(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")Broket broket) throws Exception {
		System.out.println("dsadsads");
		Map<String, Object> broketListMap=broketService.selectBorket(broket);
		System.out.println(broketListMap);
		Gson gson=new Gson();
		String broketListJson=gson.toJson(broketListMap);
		return broketListJson;
	}
	/**
	 * 增加券商信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertBorket.action",produces="text/html;charset=UTF-8")
	protected String insertBorket(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")Broket broket) throws Exception {
		System.err.println(broket);
		int rows=broketService.insertBroket(broket);
		return rows+"";
	}
	/**
	 * 修改券商信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/updateBorket.action",produces="text/html;charset=UTF-8")
	protected String updateBorket(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")Broket broket) throws Exception {
		int rows=broketService.updateBroket(broket);
		return rows+"";
	}
	/**
	 * 删除券商信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/deleteBorket.action",produces="text/html;charset=UTF-8")
	protected String deleteBorket(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")Broket broket) throws Exception {
		System.err.println(broket.getBrokerCode());
		int rows=broketService.deleteBroket(broket);
		return rows+"";
	}
	/**
	 * 通过券商编号查询券商信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectBorketById.action",produces="text/html;charset=UTF-8")
	protected String selectBorketById(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb")Broket broket) throws Exception {
		List<Broket> broketList=broketService.selectBroketById(broket.getBrokerCode());
		Gson gson=new Gson();
		return gson.toJson(broketList);
	}
}
