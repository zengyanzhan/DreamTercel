package com.yidu.dayEnd.controller;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.yidu.businessData.domain.CashArap;
import com.yidu.businessData.service.CashArapService;
import com.yidu.dayEnd.domain.CashAccrual;
import com.yidu.dayEnd.service.CashAccrualService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 现金计息控制器
 * @author 邓涛
 * @date 2017年11月23日
 * @time 下午1:37:37
 */
@Controller
public class CashAccrualController {
	@Autowired
	CashAccrualService cashAccrualService;
	@Autowired
	AutoBianService autoBianService;
	@Autowired
	CashArapService cashArapService;
	/**
	 * 查询的方法
	 * @param response 响应对象
	 * @param request 请求对象
	 * @param cashAccrual 现金计息实体类
	 * @return json数组传到js
	 */
	@ResponseBody
	@RequestMapping(value="/selectCashAccrual.action",produces="text/html;charset=UTF-8")
	public String selectCashAccrual(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")CashAccrual cashAccrual) throws Exception{
		//得到一个会话
		HttpSession session=request.getSession(false);
		//如果session为空 创建一个session
		if(session==null){
			session=request.getSession();
		}
		//得到基金实体类
		Fund fund=(Fund)session.getAttribute("fund");
		//得到基金的id
		String fundCode=fund.getFundCode();
		//把基金赋值到现金计息基金
		cashAccrual.setFundCode(fundCode);
		//调用查询的方法
		HashMap<String, Object> map=cashAccrualService.selectCashAccrual(cashAccrual);
		//得到游标
		List<CashAccrual> list=(List<CashAccrual>) map.get("cashAccrualList");
		//增强for循环
		for(CashAccrual cashAccrualEntity:list){
			//将日期类型转为字符串类型
			cashAccrualEntity.setStrDate(AllUtil.getStringDate(cashAccrualEntity.getCashStatisticDate()));
		}
		//创建gson
		Gson gson=new Gson();
		//创建map集合   里面放的是总条数 和 集合
		HashMap<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", map.get("rowsTotal"));
		jsonMap.put("rows", list);
		//转为json传到js
		return gson.toJson(jsonMap);
	}
	/**
	 * 增加的方法
	 * @param response  响应对象
	 * @param request	请求对象
	 * @param cashAccrual 现金计息实体类
	 * @param cashAccountCode 现金账户
	 * @param businessDateWhere 日期条件
	 * @param cashAccountBankCard 银行卡号
	 * @param cashAccountDepositType 业务类型
	 * @return flag大于0则统计成功
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertCashAccrual.action",produces="text/html;charset=UTF-8")
	public String insertCashAccrual(HttpServletResponse response,HttpServletRequest request,
			@ModelAttribute()CashAccrual cashAccrual,@RequestParam("cashAccountCode")String cashAccountCode
			,@RequestParam("businessDateWhere") String businessDateWhere,
			@RequestParam("cashAccountBankCard") String cashAccountBankCard,
			@RequestParam("cashAccountDepositType") Integer cashAccountDepositType) throws Exception{
		//得到一个会话
		HttpSession session=request.getSession(false);
		//如果session为空 创建一个session
		if(session==null){
			session=request.getSession();
		}
		//得到基金实体类
		Fund fund=(Fund)session.getAttribute("fund");
		//得到基金id
		String fundCode=fund.getFundCode();
		//把基金赋值到现金计息基金
		cashAccrual.setFundCode(fundCode);
		//设置日期为空
		Date dates=null;
		try {
			//将字符串转为日期类型
			dates = AllUtil.getDate(businessDateWhere,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//把日期赋值到现金计息统计日期
		cashAccrual.setCashStatisticDate(dates);
		//把现金账户赋值到现金计息现金账户
		cashAccrual.setCashAccountCode(cashAccountCode);
		//把银行卡号赋值到现金计息银行卡号
		cashAccrual.setCashAccountBankCard(cashAccountBankCard);
		//把业务类型赋值到现金计息业务类型
		cashAccrual.setCashAccountDepositType(cashAccountDepositType);
		//调用通过id查询的方法
		List cashAccrualList=cashAccrualService.selectByIdCashAccrual(businessDateWhere,cashAccountCode);
		//for遍历
		for(int i=0; i<cashAccrualList.size();i++){
			cashAccrual=(CashAccrual) cashAccrualList.get(i);
		}
		//调用自动生成编号的方法
		String cashArapCode=autoBianService.getAutoBianhao("cash_arap", "XJYSYF", "CASH_ARAp_CODE", "business_date",dates);
		//设置变量
		int CashAccountInterestPeriod=0;
		//如果计息期间为1   变量为360
		if(cashAccrual.getCashAccountInterestPeriod()==1){
			CashAccountInterestPeriod=360;
		//如果计息期间为2   变量为365	
		}else if(cashAccrual.getCashAccountInterestPeriod()==2){
			CashAccountInterestPeriod=365;
		//如果计息期间为3   变量为366
		}else {
			CashAccountInterestPeriod=366;
		}
		//调用四舍五入的方法
		Double money=AllUtil.getRoundUp((cashAccrual.getCashBlance()*cashAccrual.getCashAccountCardRate())/CashAccountInterestPeriod, 3);
		//调用现金应收应付增加的方法
		CashArap cashArap=new CashArap(cashArapCode,cashAccrual.getCashAccountCode(),fundCode,3,1,money,cashAccrual.getCashStatisticDate(),"");
		//调用删除的方法
		cashArapService.deleteSqlWhereCashArap(cashAccountCode, dates, fundCode, 3);
		//增加的方法
		int flag=cashArapService.insertCashArap(cashArap);
		if(flag>0){
			return "统计成功";
		}else{
			return "统计失败";
		}
	}
}