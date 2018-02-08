package com.yidu.reportManagement.controller;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
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
import com.yidu.reportManagement.domain.SecurityMarket;
import com.yidu.reportManagement.service.SecurityMarketService;
import com.yidu.util.AllUtil;

/**
 * 证券市值变动控制器
 * @author 邓涛
 * @date 2017年12月8日
 * @time 下午1:49:03
 */
@Controller
public class SecurityMarketController {
	@Autowired
	SecurityMarketService securityMarketService;
	@ResponseBody
	@RequestMapping(value="/selectSecurityMarket.action",produces="text/html;charset=UTF-8")
	public String selectSecurityMarket(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")SecurityMarket securityMarket) throws Exception{
		System.err.println("得到的日期是==="+securityMarket);
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		//给基金赋值
		securityMarket.setFundCode(fund.getFundCode());
		HashMap<String, Object> map=(HashMap<String, Object>) securityMarketService.selectSecurityMarket(securityMarket);
		List<SecurityMarket> list=(List<SecurityMarket>) map.get("securityMarketList");
		for(SecurityMarket securityMarketEntity:list){
			securityMarketEntity.setProjectName("资产净值");
			securityMarketEntity.setBusinessDateWhere(securityMarket.getBusinessDateWhere());
			SecurityMarket projectCode=securityMarketService.selectNetValue(securityMarketEntity);
			
			//得到查询的项目代码(资产净值)
			Double ziChanJingZhi=projectCode.getProjectCode();
			System.out.println("得到的数量是:"+securityMarketEntity.getSecurityQuantity());
			System.out.println("得到的行情价格是"+securityMarketEntity.getPrice());
			System.out.println("得到的资产净值是="+ziChanJingZhi);
			System.out.println("得到的单位成本是="+securityMarketEntity.getSecurityUnitCost());
			Double money=AllUtil.getRoundUp((securityMarketEntity.getSecurityQuantity()*securityMarketEntity.getPrice())/ziChanJingZhi,3);
			securityMarketEntity.setMarketNetWorth(money);
			//Double money1=AllUtil.getRoundUp((securityMarketEntity.getSecurityQuantity()*securityMarketEntity.getSecurityUnitCost())/((securityMarketEntity.getPrice()*securityMarketEntity.getSecurityUnitCost())), 3);
			//securityMarketEntity.setMarketChange(money1);
			System.out.println("实体类日期为========"+securityMarketEntity.getStatisticDate());
			securityMarketEntity.setStrStatisticDate(AllUtil.getStringDate(securityMarketEntity.getStatisticDate()));
			System.out.println("1111111111111="+securityMarketEntity);
		}
		Gson gson=new Gson();
		HashMap<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", map.get("rowsTotal"));
		jsonMap.put("rows", list);
		return gson.toJson(jsonMap);
	}
}
