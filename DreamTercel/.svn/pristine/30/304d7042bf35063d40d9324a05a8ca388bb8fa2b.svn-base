package com.yidu.Android.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yidu.Android.domain.JsonData;
import com.yidu.Android.domain.Message;
import com.yidu.Android.domain.NetValueEntity;
import com.yidu.Android.domain.SecurityMarket;
import com.yidu.Android.domain.StockTrading;
import com.yidu.Android.domain.TestlineData;
import com.yidu.Android.service.NetAssetValueService;
import com.yidu.businessData.domain.PriceData;
import com.yidu.dayEnd.domain.NetValue;
import com.yidu.dayEnd.service.AssetValuationService;
import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.domain.Security;
import com.yidu.stockControl.domain.SecurityStock;
import com.yidu.system.domain.User;
import com.yidu.util.AllUtil;

/**
 * 
 * @author Lee
 * @date 2017年12月5日
 * @time 上午9:51:02
 * 安卓报表
 */
@Controller
public class NetAssetValueController {
	@Autowired
	private NetAssetValueService netAssetValueService;

	@RequestMapping(value="AndroidselectNetValueChaAll.action")
	/**
	 * 基金资产净值统计表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView selectNetValueChaAll(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//设置字符编码
		response.setCharacterEncoding("UTF-8");
		//设置字符编码
		request.setCharacterEncoding("UTF-8");
		//得到输出流
		PrintWriter out=response.getWriter();
		//得到基金代码
		String strSecurityId=request.getParameter("fundCode");
		//创建净值对象
		NetValue netValue=new NetValue();
		//创建净值对象
		NetValue netValuedanwei=new NetValue();
		//查询所有资产净值
		List<NetValue> netAssetValueList=this.netAssetValueService.selectNetAssetValue(strSecurityId);
		System.out.println("资产净值集合大小"+netAssetValueList.size());
		//查询所有单位净值
		List<NetValue> unitNetList=this.netAssetValueService.selectUnitNet(strSecurityId);
		System.out.println("单位净值集合大小"+unitNetList.size());
		//		创建一个净值对象集合
		List<NetValueEntity> netValueEntityList=new ArrayList<>();
		//		循环
		for (int i = 0; i < netAssetValueList.size(); i++) {
			//	创建一个净值对象
			NetValueEntity netValueEntity=new NetValueEntity();
			//	得到资产净值数据
			netValue=netAssetValueList.get(i);
			//	得到单位净值数据
			netValuedanwei=unitNetList.get(i);
			//	日期转码
			String strdate=AllUtil.getStringDate(netValue.getStatisticDate());
			//	set赋值日期
			netValueEntity.setDate(strdate);
			//	set赋值证券代码
			netValueEntity.setFundCode(strSecurityId);
			//	st资产赋值名字
			netValueEntity.setNetAssetValue(netValue.getProjectName());
			//	set资产赋值金额
			netValueEntity.setNetAssetValueMoney(netValue.getProjectCode());
			//set单位净值赋值名字
			netValueEntity.setUnitNet(netValuedanwei.getProjectName());
			//set单位赋值金额
			netValueEntity.setUnitNetMoney(netValuedanwei.getProjectCode());
			//添加进集合
			netValueEntityList.add(netValueEntity);
		}
		//创建GSON
		Gson gson=new  Gson();
		//转数据格式
		String fundli=gson.toJson(netValueEntityList);
		//输出
		out.print(fundli);
		out.flush();
		out.close();
		return null;
	}@RequestMapping(value="AndroidselectStockTrading.action")
	/**
	 * 券商成交量统计表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView selectStockTrading(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {

		//设置字符编码
		response.setCharacterEncoding("UTF-8");
		//设置字符编码
		request.setCharacterEncoding("UTF-8");
		//创建输出流
		PrintWriter out=response.getWriter();
		System.out.println("券商成交量统计表");
		//得到开始时间
		String openDates=request.getParameter("openDate");
		//得到结束时间
		String endDates=request.getParameter("endDate");
		//当2个时间为空时
		if((openDates==null||openDates.equals(""))&&(endDates==null||endDates.equals(""))){
			//就查询所有
			List<StockTrading> selectStockList=this.netAssetValueService.selectStockTrading();
			//
			System.out.println(selectStockList.get(0));
			//创建GSON
			Gson gson=new  Gson();
			//转数据格式
			String fundli=gson.toJson(selectStockList);
			//输出
			out.print(fundli);
		}else{
			//创建Map
			Map map=new HashMap<>();
			//赋值开始时间
			map.put("openDate", openDates);
			//赋值结束时间
			map.put("endDate", endDates);
			//通过时间查询
			List selectStockList=this.netAssetValueService.selectVolumeStatisticsByDate(map);
			//创建GSon
			Gson gson=new  Gson();
			//转数据格式
			String fundli=gson.toJson(selectStockList);
			//输出3连
			out.print(fundli);
			out.flush();
			out.close();

		}
		return null;
	}
	/**
	 * 席位成交量统计表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="AndroidselectVolumeStatistics.action")
	public ModelAndView selectVolumeStatistics(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//		设置字符编码
		response.setCharacterEncoding("UTF-8");
		//		设置字符编码
		request.setCharacterEncoding("UTF-8");
		//		得到输出流
		PrintWriter out=response.getWriter();
		//		得到开始日期
		String openDates=request.getParameter("openDate");
		//		得到结束日期
		String endDates=request.getParameter("endDate");
		//		
		System.err.println(openDates+endDates);
		//		当2种日期为空时
		if((openDates==null||openDates.equals(""))&&(endDates==null||endDates.equals(""))){
			//			就查询所有
			List<StockTrading> selectStockList=this.netAssetValueService.selectVolumeStatistics();
			//			
			System.out.println(selectStockList.get(0));
			//			创建GSON
			Gson gson=new  Gson();
			//			转码
			String fundli=gson.toJson(selectStockList);
			//			输出
			out.print(fundli);
		}else{
			//			创建Map
			Map map=new HashMap<>();
			//			赋值开始时间
			map.put("openDate", openDates);
			//			赋值结束时间
			map.put("endDate", endDates);
			//			通过日期查询
			List selectStockList=this.netAssetValueService.selectVolumeStatisticsByDate(map);
			//			创建GSON
			Gson gson=new  Gson();
			//			转码
			String fundli=gson.toJson(selectStockList);
			//			输出
			out.print(fundli);

		}
		out.flush();
		out.close();
		return null;
	}
	/**
	 * 查询所有证券名称
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="AndroidselectStock.action")
	public ModelAndView selectStock(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//		设置字符编码
		response.setCharacterEncoding("UTF-8");
		//		设置字符编码
		request.setCharacterEncoding("UTF-8");
		//		得到输出流
		PrintWriter out=response.getWriter();
		//		查询所有证券
		List<Security> securityList=this.netAssetValueService.selectStockAll();
		//		创建GSON
		Gson gson=new  Gson();
		//		转码
		String fundli=gson.toJson(securityList);
		//		输出3连
		out.print(fundli);
		out.flush();
		out.close();
		return null;
	}
	/**
	 * 股票价格波动表
	 * @param request 请求对象
	 * @param response 返回对象
	 * @return
	 * @throws Exception 异常
	 */
	@RequestMapping(value="AndroidselectHangQingChaAll.action")
	public ModelAndView selectHangQingChaAll(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//		设置字符编码
		response.setCharacterEncoding("UTF-8");
		//			设置字符编码
		request.setCharacterEncoding("UTF-8");
		//		得到输出流
		PrintWriter out=response.getWriter();
		//		得到证券代码
		String strStockName=request.getParameter("Stock");
		//		
		System.out.println("Stock"+strStockName);
		System.out.println("查询所有hangqing");
		//通过证券代码查询他的行情

		List<PriceData> funList=this.netAssetValueService.selectHangQingChaAll(strStockName);
		//		循环遍历
		for (int i = 0; i < funList.size(); i++) {
			//			得到行情实体类
			PriceData priceData=funList.get(i);
			//			得到日期转啊
			String strdate=AllUtil.getStringDate(priceData.getEnteringDate());
			//			set赋值日期
			priceData.setStrenteringDatesss(strdate);
		}
		//		
		System.out.println("asda"+funList.size());
		//		创建GSON
		Gson gson=new  Gson();
		//		转数据格式
		String fundli=gson.toJson(funList);
		//		输出三连
		out.print(fundli);
		out.flush();
		out.close();
		return null;
	}
	@RequestMapping(value="AndroidselectNetValueChaAlls.action")
	/**
	 * 查询所有的净值
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	public List selectNetValueChaAlls(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {

		//			设置字符编码
		response.setCharacterEncoding("UTF-8");
		//			设置字符编码
		request.setCharacterEncoding("UTF-8");
		//		得到开始日期的日期
		String openDate=request.getParameter("openDate");
		//	//得到结束日期
		String endDate=request.getParameter("endDate");

		System.out.println(openDate+"=strSecurityId");
		System.out.println("查询所有净值");
		//创建一个资产净值集合
		List<NetValue> netAssetValueList=new ArrayList<>();
		if(openDate!=null&&endDate!=null){
			//			查询前一天的所有净值
			netAssetValueList=this.netAssetValueService.selectNetValueChaAllsByDate(openDate, endDate);
		}else{ 
			//			查询所有净值
			netAssetValueList=this.netAssetValueService.selectNetValueChaAlls();
		}
		//		创建净值实体类
		NetValue netValue=new NetValue();

		System.out.println("资产净值集合大小"+netAssetValueList.size());
		//		创建一个净值集合
		List<NetValueEntity> netValueEntityList=new ArrayList<>();
		//		循环遍历
		for (int i = 0; i < netAssetValueList.size(); i++) {

			//		创建一个净值实体类	
			NetValueEntity netValueEntity=new NetValueEntity();
			//	得到数据		
			netValue=netAssetValueList.get(i);
			System.out.println(netValue.getFundCode());
			//查询基金名字
			List<Fund> fundList=this.netAssetValueService.selectFundNameByCode(netValue.getFundCode());
			System.out.println(fundList.size());
			//			set赋值基金Code
			netValueEntity.setFundCode(fundList.get(0).getFundName());
			//			set资产净值名字
			netValueEntity.setNetAssetValue(netValue.getProjectName());
			//			set赋值金额
			netValueEntity.setUnitNetMoney(netValue.getProjectCode());
			//	set赋值日期
			netValueEntity.setDate(AllUtil.getStringDate(netValue.getStatisticDate()));
			//添加进集合
			netValueEntityList.add(netValueEntity);
		}
		return netValueEntityList;
	}
	/**
	 * 查询所有消息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="AndroidselectAllMessage.action")
	public ModelAndView selectAllMessage(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//		设置字符编码
		response.setCharacterEncoding("UTF-8");
		//		设置字符编码
		request.setCharacterEncoding("UTF-8");
		//		得到输出流
		PrintWriter out=response.getWriter();
		//		
		System.out.println("查询所有消息");
		//	查询所有消息
		List<Message> messageList=this.netAssetValueService.selectAllMessage();
		//		循环遍历
		for (int i = 0; i < messageList.size(); i++) {
			//		得到消息数据	
			Message message=messageList.get(i);
			//			得到日期转成String
			String date =AllUtil.getStringDate(message.getMessageDate());
			//			set赋值日期
			message.setStrDate(date);
		}
		//		创建GSON
		Gson gson=new  Gson();
		//		转码
		String fundli=gson.toJson(messageList);
		//		输出三连
		out.print(fundli);
		out.flush();
		out.close();
		return null;
	}
	/**
	 * 证券市值变动表 通过Code
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="AndroidselectSecurityMarket.action")
	public ModelAndView selectSecurityMarket(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//设置字符编码
		response.setCharacterEncoding("UTF-8");
		//		设置字符编码
		request.setCharacterEncoding("UTF-8");
		//		得到输出流
		PrintWriter out=response.getWriter();
		//		得到证券代码
		String code=request.getParameter("Stock");
		//证券市值实体类集合
		List<JsonData> jsonDataList=new ArrayList<>();
		//		通过证券Code查询
		List<SecurityStock> securityStockList=this.netAssetValueService.selectAllSecurityByCode(code);
		//		循环遍历
		for (int i = 0; i < securityStockList.size(); i++) {
			//			得到证券库存
			SecurityStock securityStock=securityStockList.get(i);
			//			得到证券Code
			String securitycode=securityStock.getSecurityCode();
			//			得到日期专转成String
			String date=AllUtil.getStringDate(securityStock.getDatetimeInner());
			//			得到数量
			Double quantity=securityStock.getSecurityQuantity();
			//			通过证券代码查询行情数据
			List<PriceData> priceList=this.netAssetValueService.selectHangQingChaByDateAndId(securitycode, date);
			//	得到行情数据
			PriceData priceData=priceList.get(0);
			//	证券市值实体
			JsonData jsonData=new JsonData();
			//	set赋值金额
			jsonData.setMoney(quantity*priceData.getClosingPrice());
			//	set赋值日期
			jsonData.setStrDate(date);
			//	添加进集和
			jsonDataList.add(jsonData);
		}

		System.out.println("证券市值变动表");
		//	得到GSON
		Gson gson=new Gson();
		//	转成
		String strjsonDataList=gson.toJson(jsonDataList);
		//	out3连
		out.print(strjsonDataList);
		//	
		out.flush();
		//	
		out.close();

		return null;
	}
	/**
	 * 查询所有证券
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="AndroidselectAllSecurity.action")
	public ModelAndView selectAllSecurity(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//		设置字符编码
		response.setCharacterEncoding("UTF-8");
		//	设置字符编码
		request.setCharacterEncoding("UTF-8");
		//	得到输出留
		PrintWriter out=response.getWriter();
		//	
		System.out.println("查询所有证券");
		//	查询所有证券
		List<SecurityStock> StockList=this.netAssetValueService.selectAllSecurity();
		//	创建GSON
		Gson gson=new Gson();
		//	转成
		String strStockList=gson.toJson(StockList);
		//	OUT3连
		out.print(strStockList);
		out.flush();
		out.close();

		return null;
	}/**
	 * 证券市值变动表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="AndroidselectSecurityMarketByDate.action")
	public ModelAndView selectSecurityMarketByDate(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//	设置字符编码
		response.setCharacterEncoding("UTF-8");
		//	设置字符编码
		request.setCharacterEncoding("UTF-8");
		//	得到输出流
		PrintWriter out=response.getWriter();
		//	得到证券代码
		String code=request.getParameter("Stock");
		//	得到开始日期
		String openDate=request.getParameter("openDate");
		//	得到结束日期
		String endDate=request.getParameter("endDate");
		//	创建一个LIst
		List<JsonData> jsonDataList=new ArrayList<>();
		//	证券库存实体类集合
		List<SecurityStock> securityStockList=null;
		System.out.println(openDate+endDate);
		System.out.println(code);
		//	日过开始和结束日期==null
		if(openDate==null&&endDate==null){
			//	只通过Code查询
			securityStockList=this.netAssetValueService.selectAllSecurityByCode(code);
		}
		else{
			//	通过Code 开始结束日期查询
			securityStockList=this.netAssetValueService.selectSecurityMarketByDate(code, openDate, endDate);
		}
		System.out.println(securityStockList.size());
		//	循环遍历
		for (int i = 0; i < securityStockList.size(); i++) {
			//	得到这个证券库存
			SecurityStock securityStock=securityStockList.get(i);
			//	得到这个证券代码
			String securitycode=securityStock.getSecurityCode();
			//	得到SQL日期转成String
			String date=AllUtil.getStringDate(securityStock.getDatetimeInner());
			//	得到数量
			Double quantity=securityStock.getSecurityQuantity();
			//	行情集合=证券Code  日期
			List<PriceData> priceList=this.netAssetValueService.selectHangQingChaByDateAndId(securitycode, date);
			//	得到行情
			PriceData priceData=priceList.get(0);
			//	创建证券市值
			JsonData jsonData=new JsonData();
			//	金额set赋值
			jsonData.setMoney(quantity*priceData.getClosingPrice());
			//	日期set赋值
			jsonData.setStrDate(date);
			//	添加进集合
			jsonDataList.add(jsonData);
		}
		System.out.println("证券市值变动表");
		//	创建GSO
		Gson gson=new Gson();
		//	转成
		String strjsonDataList=gson.toJson(jsonDataList);
		//	out3连
		out.print(strjsonDataList);
		//	
		out.flush();
		//			
		out.close();

		return null;
	}
	/**
	 * 通过日期查询行情 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="AndroidselectHangQingByDate.action")
	public ModelAndView selectHangQingByDate(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//	设置字符编码
		response.setCharacterEncoding("UTF-8");
		//	设置字符编码
		request.setCharacterEncoding("UTF-8");
		//	得到输出流
		PrintWriter out=response.getWriter();
		//	得到股票代码
		String strStockName=request.getParameter("Stock");
		//	得到开始日期
		String openDate=request.getParameter("openDate");
		//	得到结束日期
		String endDate=request.getParameter("endDate");
		//	
		System.out.println(openDate+endDate);
		//	
		System.out.println("Stock"+strStockName);
		//	
		System.out.println("查询所有行情 通过日期");
		//	通过股票代码 开始日期 结束日期去查询行情数据
		List<PriceData> funList=this.netAssetValueService.selectHangQingByDate(strStockName, openDate, endDate);
		//	循环遍历
		for (int i = 0; i < funList.size(); i++) {
			//	得到这个行情数据
			PriceData priceData=funList.get(i);
			//	将SQL时间转成String日期
			String strdate=AllUtil.getStringDate(priceData.getEnteringDate());
			//	set赋值
			priceData.setStrenteringDatesss(strdate);
		}
		System.out.println("asda"+funList.size());
		//	得到GSON
		Gson gson=new  Gson();
		//	转换
		String fundli=gson.toJson(funList);
		//	out3连
		out.print(fundli);
		out.flush();
		out.close();
		return null;
	}
	/**
	 * 多折线图证券市值变动
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="Androidselectzhengquan.action")
	public List selectzhengquan(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//	设置字符编码
		response.setCharacterEncoding("UTF-8");
		//	设置字符编码
		request.setCharacterEncoding("UTF-8");
		// 得到开始日期
		String openDate=request.getParameter("openDate");
		// 得到结束日期
		String endDate=request.getParameter("endDate");
		//创建一个证券库存集合
		List<SecurityStock> StockList=new ArrayList<>();
		//创建一个集合
		List jsonDataList=new ArrayList<>();
		//如果2个日期不为空 就通过日期查询
		if(openDate!=null&&endDate!=null){
			StockList=this.netAssetValueService.selectAllSecurityByDate(openDate, endDate);
			System.out.println(StockList.size());
		}else{
			//查询所有证券
			StockList=this.netAssetValueService.selectAllSecurity();

		}
		//循环遍历
		for (int i = 0; i < StockList.size(); i++) {
			//得到证券库存
			SecurityStock securityStock=StockList.get(i);
			//得到证券代码
			String securityStockCode=securityStock.getSecurityCode();
			//得到的时间转成String
			String securityStockDate=AllUtil.getStringDate(securityStock.getDatetimeInner());
			//得到数量
			Double securityQuantity=securityStock.getSecurityQuantity();
			//	行情集合=证券Code  日期
			List<PriceData> priceList=this.netAssetValueService.selectHangQingChaByDateAndId(securityStockCode, securityStockDate);	
			//循环里边
			for (int j = 0; j < priceList.size(); j++) {
				//得到行情数据
				PriceData priceData=priceList.get(j);
				//得到收盘价
				Double shoupanPrice=priceData.getClosingPrice();
				//创建一个证券市值实体类
				JsonData jsonData= new JsonData();
				//set赋值名字
				jsonData.setName(securityStock.getSecurityName());
				//set赋值金额
				jsonData.setMoney(shoupanPrice*securityQuantity);
				//set赋值日期
				jsonData.setStrDate(AllUtil.getStringDate(priceData.getEnteringDate()));
				//添加进集合
				jsonDataList.add(jsonData);
			}
		} 

		//返回
		return jsonDataList;
	}
	/**
	 * 查询所有基金
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="AndroidLogin.action")
	public ModelAndView AndroidLogin(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//设置字符编码
		response.setCharacterEncoding("UTF-8");
		//设置字符编码
		request.setCharacterEncoding("UTF-8");
		//得到输出流
		PrintWriter out=response.getWriter();
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		
		System.out.println("查询所有用户");
		//查询所有用户
		List<User> funList=this.netAssetValueService.selectUserByNameAndPwd(name, pwd);
		if(funList.size()!=0){
			out.print("true");
		}else{
			out.print("false");
		}
		//输出三连
		out.flush();
		out.close();
		return null;
	}
	/**
	 * 登录action
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="AndroidselectAllfund.action")
	public ModelAndView selectAllfund(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		//设置字符编码
		response.setCharacterEncoding("UTF-8");
		//设置字符编码
		request.setCharacterEncoding("UTF-8");
		//得到输出流
		PrintWriter out=response.getWriter();
		System.out.println("查询所有基金");
		//查询所有基金
		List<Fund> funList=this.netAssetValueService.selectAllFund();
		//创建GSON
		Gson gson=new  Gson();
		//转数据格式
		String fundli=gson.toJson(funList);
		//输出三连
		out.print(fundli);
		out.flush();
		out.close();
		return null;
	}
}
