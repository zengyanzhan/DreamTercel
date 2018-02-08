package com.yidu.transactionProcessing.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yidu.parameters.domain.CashAccount;
import com.yidu.parameters.domain.ExchangeRate;
import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.domain.Seat;
import com.yidu.parameters.service.BondService;
import com.yidu.parameters.service.ExchangeRateService;
import com.yidu.system.domain.HoildayXiao;
import com.yidu.system.domain.User;
import com.yidu.system.service.HoildayXiaoSerice;
import com.yidu.transactionProcessing.domain.DealData;
import com.yidu.transactionProcessing.service.DealDataService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;

/**
 * 交易数据控制器类
 * @author Wang
 * @date 2017年11月18日
 * @time 上午10:30:16
 */
@Controller
public class DealDataController {
	@Autowired
	AutoBianService autoBianHao;
	@Autowired
	DealDataService dealDataService;
	@Autowired
	ExchangeRateService exchangeRateService;
	@Autowired
	BondService bondService;
	@Autowired
	HoildayXiaoSerice hoildayXiaoSerice;
	/**
	 * 自动生成编号
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping("/autoCreateDealDataCode.action")
	protected String autoCreateDealDataCode(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//自动生成编号
		String seatCode=autoBianHao.getAutoBianhao("deal_data", "JYSJ", "deal_data_code", "deal_date", AllUtil.getDate(dealData.getStrDealDate()));
		return seatCode;
	}
	/**
	 * 查询交易数据信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return dealDataJson 交易数据json对象 
	 * @throws Exception 异常
	 */     
	@ResponseBody
	@RequestMapping(value="/selectDealData.action",produces="text/html;charset=UTF-8")
	protected String selectDealData(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//得到基金编号
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		Map<String, Object> dealDataMap= dealDataService.selectDealData(dealData,fund.getFundCode());
		//转json对象
		Gson gson=new Gson();
		String dealDataJson=gson.toJson(dealDataMap);
		return dealDataJson;
	}
	/**
	 * 计算债券利息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 债券利息
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectBondBySecurityCode.action",produces="text/html;charset=UTF-8")
	protected String selectBondBySecurityCode(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//计算债券利息
		Double securityFnterest=dealDataService.computeSecurityFnterest(dealData);
		return securityFnterest+"";
	}
	/**
	 * 查询现金账户
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 现金账户json对象
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectCashAccountSel.action",produces="text/html;charset=UTF-8")
	protected String selectCashAccountSel(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//查询现金账户
		List<CashAccount> cashAccountList=dealDataService.selectCashAccountSel();
		//转json对象
		Gson gson=new Gson();
		return gson.toJson(cashAccountList);
	}
	/**
	 * 添加交易数据信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 受影响行数
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertDealData.action",produces="text/html;charset=UTF-8")
	protected String insertDealData(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//得到基金编号
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		dealData.setFundCode(fund.getFundCode());
		//增加交易数据
		int rows=dealDataService.insertDealData(dealData);
		return rows+"";
	}
	/**
	 * 查询券商信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 席位信息
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectSeatByBroketCode.action",produces="text/html;charset=UTF-8")
	protected String selectSeatByBroketCode(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//通过券商编号查询此券商下的席位
		List<Seat> seatList=dealDataService.selectSeatByBorketCode(dealData.getBrokerCode());
		//转json对象
		Gson gson=new Gson();
		return gson.toJson(seatList);
	}
	/**
	 * 查询交易所信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 交易所品种费率json对象
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectExchangeRateByExchangeNameAndSecurityType.action",produces="text/html;charset=UTF-8")
	protected String selectExchangeRateByExchangeNameAndSecurityType(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		ExchangeRate exchangeRate=new ExchangeRate();
		exchangeRate.setExchangeName(dealData.getExchangeName());
		exchangeRate.setExchangeType(dealData.getSecurityType());
		//根据交易所名称和费率类型查询
		List<ExchangeRate> exchangeRateList=exchangeRateService.selectExchangeRateByExchangeNameAndSecurityType(exchangeRate);
		Gson gson=new Gson();
		return gson.toJson(exchangeRateList);
	}
	/**
	 * 查询管理人信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 用户信息json对象
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectMaragerSel.action",produces="text/html;charset=UTF-8")
	protected String selectMaragerSel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//查询管理人信息
		List<User> userList=dealDataService.selectMaragerSel();
		Gson gson=new Gson();
		return gson.toJson(userList);
	}
	/**
	 * 修改交易数据信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 受影响行数
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/updateDealData.action",produces="text/html;charset=UTF-8")
	protected String updateDealData(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//得到基金编号
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		dealData.setFundCode(fund.getFundCode());
		//修改交易数据
		int rows=dealDataService.updateDealData(dealData);
		return rows+"";
	}
	/**
	 * 删除交易数据信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 受影响行数
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/deleteDealData.action",produces="text/html;charset=UTF-8")
	protected String deleteDealData(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//删除交易数据
		int row=dealDataService.deleteDealData(dealData);
		return row+"";
	}
	/**
	 * 通过交易数据编号查询交易数据信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 交易数据对象
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectDealDataById.action",produces="text/html;charset=UTF-8")
	protected String selectDealDataById(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//通过交易数据编号查询交易数据信息
		List<DealData> dealDataList=dealDataService.selectDealDataById(dealData.getDealDataCode());
		Gson gson=new Gson();
		return gson.toJson(dealDataList);
	}
	/**
	 * 查询交易结算信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 交易数据
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectTradeSettle.action",produces="text/html;charset=UTF-8")
	protected String selectTradeSettle(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//得到基金编号
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		dealData.setFundCode(fund.getFundCode());
		//查询交易结算的数据
		Map<String, Object> dealDataMap=dealDataService.selectTradeSettle(dealData);
		Gson gson=new Gson();
		return gson.toJson(dealDataMap);
	}
	/**
	 * 点击结算交易数据
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param dealData 交易数据
	 * @return 受影响行数
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertTradeNotSettle.action",produces="text/html;charset=UTF-8")
	protected String insertTradeNotSettle(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//得到基金编号
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		dealData.setFundCode(fund.getFundCode());
		//进行交易结算
		int rows=dealDataService.insertTradeNotSettle(dealData);
		return rows+"";
	}
	/**
	 * 点击反结算交易数据
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param dealData 交易数据
	 * @return 是否反结算成功
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertTradeAlreadySettle.action",produces="text/html;charset=UTF-8")
	protected String insertTradeAlreadySettle(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//得到基金编号
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		dealData.setFundCode(fund.getFundCode());
		//进行交易反结算
		int rows=dealDataService.insertTradeAlreadySettle(dealData);
		return rows+"";
	}
	/**
	 * 根据日期去查找下一个工作日
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param dealData 交易数据
	 * @return 结算日期
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectHoildayByDradeDate.action",produces="text/html;charset=UTF-8")
	protected String selectHoildayByDradeDate(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//根据日期去查找下一个工作日
		List<HoildayXiao> hoildayXiaoList=null;
		String strDealDate=dealData.getStrDealDate();
		do {
			strDealDate=AllUtil.getStringDate(AllUtil.getDate(strDealDate, 1));
			hoildayXiaoList=hoildayXiaoSerice.selectHoildayBydate(strDealDate);
		} while (hoildayXiaoList.size()!=0);
		return strDealDate;
	}
	/**
	 * 上海过户库导入
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 是否导入成功
	 * @throws Exception 异常
	 */
	@RequestMapping(value="/imputShguk.action")
	protected ModelAndView imputShguk(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") DealData dealData) throws Exception {
		//文件上传，得到文件的绝对路径
		String fileName=autoBianHao.upload(request, response, "szInput");
		//得到基金编号
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		//得到操作用户
		User user=(User) session.getAttribute("user");
		//进行数据导入
		dealDataService.imputShangHaiGuoHu(fileName,fund.getFundCode(),user.getUserCode());
		return new ModelAndView("redirect:jsp/tradeData.jsp");
	}
}
