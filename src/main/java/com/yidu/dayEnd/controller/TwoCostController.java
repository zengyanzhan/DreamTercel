package com.yidu.dayEnd.controller;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.yidu.businessData.domain.CashArap;
import com.yidu.businessData.service.CashArapService;
import com.yidu.businessData.service.SecurityArapService;
import com.yidu.dayEnd.domain.TwoCost;
import com.yidu.dayEnd.service.TwoCostService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 两费控制器
 * @author 邓涛
 * @date 2017年12月5日
 * @time 上午12:32:32
 */
@Controller 
public class TwoCostController {
	@Autowired
	TwoCostService twoCostService;
	@Autowired
	CashArapService cashArapservice;
	@Autowired 
	AutoBianService autoBianService;
	@Autowired
	SecurityArapService securityArapService;
	/**
	 * 查询的方法
	 * @param request 请求对象
	 * @param twoCost 两费实体类
	 * @return json数组传到js
	 */
	@ResponseBody
	@RequestMapping(value="selectTwoCost.action",produces="text/html;charset=utf-8")
	public String selectTwoCost(HttpServletRequest request,@ModelAttribute("SpringWeb")TwoCost twoCost) throws Exception  {
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
		//把基金id赋值到两费的基金id
		twoCost.setFundCode(fundCode);
		//调用日期减1的方法 赋值到统计日期
		twoCost.setStatisticDate(AllUtil.getDate(twoCost.getBusinessDateWhere(),-1));
		//调用查询的方法
		List<TwoCost> twoCostList=twoCostService.selectTwoCost(twoCost);
		//创建gson
		Gson gson=new Gson();
		//for循环
		for (int i = 0; i < twoCostList.size(); i++) {
			//得到统计日期
			Date date = twoCostList.get(i).getStatisticDate();
			//将日期转为字符串
			twoCostList.get(i).setStrstatisticDate(AllUtil.getStringDate(date));
		}
		//创建map集合 里面放的是总条数 和集合
		HashMap<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", twoCostList.size());
		jsonMap.put("rows", twoCostList);
		return gson.toJson(jsonMap);
	}
	/**
	 * 两费统计的方法
	 * @param response 响应对象
	 * @param request  请求对象
	 * @param twoCost  两费实体类
	 * @param feePeriodDay 计息天数
	 * @param cashAccountCode 现金账 户
	 * @param manageRate 管理人费率
	 * @param projectCode 资产净值
	 * @param statisticDate 统计日期
	 * @param trusteeRate 托管人费率
	 * @param cashAccountBankCard 银行卡号
	 * @param cashAccountDepositType 类型
	 * @return flag大于0则统计成功
	 */
	@ResponseBody
	@RequestMapping(value="/insertTwoCost.action",produces="text/html;charset=UTF-8")
	public void insertTwoCost(HttpServletResponse response,HttpServletRequest request,
			@ModelAttribute("SpringWeb")TwoCost twoCost,@RequestParam("feePeriodDay") int feePeriodDay
			,@RequestParam("cashAccountCode")String cashAccountCode,@RequestParam("manageRate")Double manageRate,
			@RequestParam("projectCode")Double projectCode,@RequestParam("statisticDate")Date statisticDate,
			@RequestParam("trusteeRate")Double trusteeRate,
			@RequestParam("cashAccountBankCard")String cashAccountBankCard,
			@RequestParam("cashAccountDepositType")Integer cashAccountDepositType) throws Exception{
		//得到一个会话
		HttpSession session=request.getSession(false);
		//如果session等于空 创建一个session 
		if(session==null){
			session=request.getSession();
		}
		//得到基金实体类
		Fund fund=(Fund)session.getAttribute("fund");
		//得到基金id
		String fundCode=fund.getFundCode();
		//把基金id赋值到两费基金
		twoCost.setFundCode(fundCode);
		//类型赋值到两费类型
		twoCost.setCashAccountDepositType(cashAccountDepositType);
		//调用通过id查询的方法
		List TwoCostList=twoCostService.selectByIdTwoCost(twoCost.getCashAccountCode());
		//字符串转date类型
		Date dates=AllUtil.getDate(twoCost.getBusinessDateWhere());
		//调用自动生成编号的方法
		String  cashArapCodeId=autoBianService.getAutoBianhao("cash_arap", "XJYSYF", "cash_arap_code", "business_date", dates);
		//定义一个变量
		Integer feePeriodDaySize=null;
		//如果计息天数等于1 变量为360
		if(feePeriodDay==1){
			feePeriodDaySize=360;
		//如果计息天数等于2 变量为365
		}else if(feePeriodDay==2){
			feePeriodDaySize=365;
		//如果计息天数等于3 变量为366
		}else if(feePeriodDay==3){
			feePeriodDaySize=366;
		}
		//调用四舍五入的方法(计算基金管理人的费率)公式：(管理人费率*资产净值)/计息天数
		Double money1=AllUtil.getRoundUp((manageRate*projectCode)/feePeriodDay,3);
		//创建现金应收应付实体类
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//创建应收应付实体类
		CashArap cashArap=new CashArap(cashArapCodeId, twoCost.getCashAccountCode(),twoCost.getFundCode() ,1,1, money1,dates, "");
		//调用删除的方法  
		cashArapservice.deleteSqlWhereCashArap(cashAccountCode, dates,fundCode, 1);
		//调用增加的方法
		int flag=cashArapservice.insertCashArap(cashArap);
		if(flag>0){
			response.getWriter().print("统计成功");
			//调用自动生成编号的方法
			String  cashArapCodeIds=autoBianService.getAutoBianhao("cash_arap", "XJYSYF", "CASH_ARAp_CODE", "business_date", dates);
			//调用四舍五入的方法(计算基金托管人的费率)  公式：(托管人费率*资产净值)/计息天数
			Double money2=AllUtil.getRoundUp((trusteeRate*projectCode)/feePeriodDay, 3);
			//创建现金应收应付实体类
			CashArap cashAraps=new CashArap(cashArapCodeIds, twoCost.getCashAccountCode(),twoCost.getFundCode() ,2,1, money2,dates, "");
			//调用删除的方法
			cashArapservice.deleteSqlWhereCashArap(cashAccountCode, dates,fundCode, 2);
			//增加的方法
			cashArapservice.insertCashArap(cashAraps);
		}else{
			response.getWriter().print("统计失败");
		}
	}
}
