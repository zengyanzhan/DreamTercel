package com.yidu.stockControl.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runners.AllTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.domain.Security;
import com.yidu.stockControl.domain.SecurityStock;
import com.yidu.stockControl.service.SecurityStockService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;

/**
 * 证券库存控制器
 * @author ZengYanZhan
 * @date 2017年11月13日
 * @time 上午10:10:36
 */
@Controller
public class SecurityStockController {
	@Autowired
	private SecurityStockService securityStockService; //自动装配证券库存接口类
	@Autowired
	private AutoBianService autoBianService;//自动装配自动生成编号服务类

	/**
	 * 查询证券库存
	 * @return String 字符串
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/selectSecurityStock.action",produces="text/html;charset=UTF-8")
	public String selectSecurityStock(@ModelAttribute("SpringWeb") SecurityStock securityStock,HttpServletRequest request) throws Exception{
	    HttpSession session=request.getSession(false);//得到一个会话
	    if(session==null){
	    	session=request.getSession(true);
	    }
	    Fund fund=(Fund)session.getAttribute("fund");//得到基金实体类
	    securityStock.setFundCode(fund.getFundCode()); //通过基金实体类得到基金代码
		Map<String,Object> cursorMap= securityStockService.selectSecurityStock(securityStock);//得到dao层返回的数据
		List<SecurityStock> list=(List<SecurityStock>)cursorMap.get("cursor");//格式化日期
		for(SecurityStock seStock:list){
			seStock.setStaticticsDate(seStock.getDatetimeInner().toString());
			seStock.setFundName(fund.getFundName());
		}
		Map<String,Object> map=new HashMap<String,Object>();//创建map集合，用于格式化成json对象
		map.put("total", cursorMap.get("rowsTotal")); //总记录数
		map.put("rows",list); //数据集合
		Gson   gson   = new Gson();
		return gson.toJson(map);//返回map集合到界面
	}

	/**
	 * 增加证券库存数据的方法
	 * @return 字符串 判断是否增加成功并且返回到界面显示
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/insertSecurityStock.action",produces = "text/html;charset=UTF-8")
	public String insertSecurityStock(@ModelAttribute("SpringWeb") SecurityStock securityStock) throws Exception{
		securityStock.setDatetimeInner(AllUtil.getDate(securityStock.getStaticticsDate()));
		int rows=securityStockService.insertSecurityStock(securityStock);
		if(rows>0){
			return "增加成功";
		}
		return "增加失败";
	}

	/**
	 * 修改证券库存数据的方法
	 * @return String 字符串返回是否修改成功标志到界面
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/updateSecurityStock.action",produces = "text/html;charset=UTF-8")
	public String updateSecurityStock(@ModelAttribute("SpringWeb") SecurityStock securityStock) throws Exception{
		securityStock.setDatetimeInner(AllUtil.getDate(securityStock.getStaticticsDate()));
		int rows=securityStockService.updateSecurityStock(securityStock);
		if(rows>0){
			return "修改成功";
		}
		return "修改失败";
	}

	/** 
	 * 删除证券库存数据方法
	 * @return String 返回删除是否成功的标志到界面
	 */
	@ResponseBody
	@RequestMapping(value="/deleteSecurityStock.action",produces = "text/html;charset=UTF-8")
	public String deleteSecurityStock(@RequestParam String code){
		int rows=securityStockService.deleteSecurityStock(code);
		if(rows>0){
			return "删除成功";
		}
		return "删除失败";
	}

	/**
	 * 通过code查询该行记录并且返回到修改框赋值显示
	 * @param code
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/selectSecurityStockByCode.action",produces = "text/html;charset=UTF-8")
	public String selectSecurityStockByCode(@RequestParam String code) throws Exception{
		SecurityStock scStock=securityStockService.selectSecurityStockByCode(code);
		scStock.setStaticticsDate(AllUtil.getStringDate(scStock.getDatetimeInner()));
		Gson gson=new Gson();
		return gson.toJson(scStock);
	}

	/**
	 * 查询并且自动生成证券库存编号
	 * @return String 证券库存编号
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/selectSecurityStockCode.action",produces="text/html;charset=UTF-8")
	public String selectSecurityStockCode(@RequestParam String staticticsDate) throws Exception{
		//调用自动生成编号的服务方法 并返回一个字符串
		String code="";
		if(staticticsDate != null && !staticticsDate.equals("")){
			Date date=AllUtil.getDate(staticticsDate);	//得到界面传过来的参数
			code=autoBianService.getAutoBianhao("security_stock", "ZJKC", "security_stock_code", "security_statistics_date", date);
		}
		return code;
	}
}
