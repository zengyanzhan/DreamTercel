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
import com.yidu.reportManagement.domain.DealSettleAccounts;
import com.yidu.reportManagement.service.DealSettleAccountsService;

/**
 * 交易成交日报表控制器类
 * @author Wang
 * @date 2017年12月7日
 * @time 下午4:19:09
 */
@Controller
public class DealSettleAccountsController {
	@Autowired
	DealSettleAccountsService dealSettleAccountsService;
	/**
	 * 查询交易成交日报表
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 交易成交日报表数据
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="selectDealSettleAccounts.action",produces="text/html;charset=UTF-8")
	protected String selectDealSettleAccounts(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealSettleAccounts dealSettleAccounts) throws Exception {
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		Map<String, Object> map=dealSettleAccountsService.selectDealSettleAccounts(dealSettleAccounts, fund.getFundCode());
		Gson gson=new Gson();
		return gson.toJson(map);
	}
}
