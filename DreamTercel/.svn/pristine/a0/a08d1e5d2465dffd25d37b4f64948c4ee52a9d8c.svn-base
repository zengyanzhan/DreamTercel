package com.yidu.taManagement.controller;

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
import com.yidu.taManagement.domain.TaTradData;
import com.yidu.taManagement.domain.TaTradeSettle;
import com.yidu.taManagement.service.TaTradeSettleService;
import com.yidu.util.AllUtil;

/**
 * TA交易结算的控制类
 * @author  ZhouMuJiao
 * @date2017年11月23日
 * @time上午10:44:14
 */
@Controller
public class TaTradeSettleController {
	/**
	 * 查询
	 */
	@Autowired
	 TaTradeSettleService taTradeSettleService;
	/*@Autowired
	AutoBianService autoBianService;*/
/*	@Autowired
	FundService fundService;*/
	@ResponseBody
	@RequestMapping(value="/selectTaTradeSettleData.action")
	public String selectTaTradData(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb") TaTradeSettle taTradeSettle) throws Exception{
		System.err.println("状态是==="+taTradeSettle);
		String bufferWhere = taTradeSettleService.bufferWhere(taTradeSettle);
//		HttpSession session=request.getSession();
//		Fund fund=(Fund) session.getAttribute("fund");
//		taTradeSettle.setFundCode(fund.getFundCode());
//		String sqlWhere=taTradeSettleService.bufferWhere(taTradeSettle);
		String tableName="(select * from ta_trad_data ta join fund fd on ta.fund_code=fd.fund_code)";
		HashMap<String, Object> map=taTradeSettleService.selectTaTradData(tableName, bufferWhere, 
				taTradeSettle.getPage(), taTradeSettle.getRows(),"","");
		@SuppressWarnings("unchecked")
		List<TaTradeSettle> taTaTradSettleList=(List<TaTradeSettle>) map.get("taTaTradSettleList");
		/*for (TaTradeSettle taTradeSettleEntity:taTaTradSettleList) {
			taTradeSettleEntity.setTaTradeDates(AllUtil.getStringDate(taTradeSettleEntity.getTaTradeDate()));//交易日期
			
			System.err.println(taTradeSettleEntity);
		}*/
	
		//创建Gson
		Gson gson=new Gson();
		HashMap<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", map.get("rowsTotal"));
		jsonMap.put("rows", map.get("taTaTradSettleList"));
		System.out.println(map.get("taTaTradSettleList"));
		System.err.println("数据是你吗卖批==？"+jsonMap);
		return gson.toJson(jsonMap);
		
	}
}
