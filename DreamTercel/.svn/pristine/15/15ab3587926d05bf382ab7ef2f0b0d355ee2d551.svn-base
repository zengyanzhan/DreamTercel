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
import com.yidu.businessData.domain.SecurityArap;
import com.yidu.businessData.service.SecurityArapService;
import com.yidu.dayEnd.domain.BondAccrual;
import com.yidu.dayEnd.service.BondAccrualService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 债券计息控制器
 * @author 邓涛
 * @date 2017年11月26日
 * @time 下午6:36:55
 */
@Controller 
public class BondAccrualController {
	@Autowired
	BondAccrualService bondAccrualService;
	@Autowired
	AutoBianService autoBianService;
	@Autowired
	SecurityArapService securityArapService;
	/**
	 * 查询的方法
	 * @param bondAccrual 债券计息实体类
	 * @return json数组传到js
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="selectBondAccrual.action",produces="text/html;charset=utf-8")
	public String selectBondAccrual(HttpServletRequest request,@ModelAttribute("SpringWeb")BondAccrual bondAccrual) throws Exception  {
		//得到一个会话
		HttpSession session=request.getSession(false);
		//如果session为空 创建一个session
		if(session==null){
			session=request.getSession();
		}
		System.err.println("进入了查询的action");
		//得到基金实体类
		Fund fund=(Fund)session.getAttribute("fund");
		//得到基金id
		String fundCode=fund.getFundCode();
		//把基金赋值到现金计息基金
		bondAccrual.setFundCode(fundCode);
		//得到行
		String pages=request.getParameter("page");
		//得到页
		String rowss=request.getParameter("rows");
		Integer page=Integer.parseInt(pages);
		Integer rows=Integer.parseInt(rowss);
		//调用查询的方法
		List<BondAccrual> bondAccrualList=bondAccrualService.selectBondAccrual(bondAccrual,page,rows);
		//增强for循环
		for(BondAccrual bondAccrualEntity:bondAccrualList){
			//将日期转为字符串类型
			bondAccrualEntity.setStrStarDate(AllUtil.getStringDate(bondAccrualEntity.getInterestStarDate()));
			//将日期转为字符串类型
			bondAccrualEntity.setStrEndDate(AllUtil.getStringDate(bondAccrualEntity.getInterestEndDate()));
			//将日期转为字符串类型
			bondAccrualEntity.setStrSecurityStatisticsDate(AllUtil.getStringDate(bondAccrualEntity.getSecurityStatisticsDate()));
		}
		//调用查询总条数的方法
		int size=bondAccrualService.selectSize();
		//创建gson
		Gson gson=new Gson();
		//创建map集合 里面放的是 总条数 和集合
		HashMap<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",size);
		jsonMap.put("rows", bondAccrualList);
		//将json传到js
		return gson.toJson(jsonMap);
	}
	/**
	 * 增加的方法
	 * @param response 响应对象
	 * @param request  得到对象
	 * @param bondAccrual 证券应收应付实体类
	 * @param businessDateWhere 日期条件
	 * @param cashAccountCode 现金账户
	 * @return falg 大于0则统计成功
	 * @throws Exception  异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertBondAccrual.action",produces="text/html;charset=UTF-8")
	public String insertBondAccrual(HttpServletResponse response,HttpServletRequest request,
			@ModelAttribute("SpringWeb")BondAccrual bondAccrual,
			@RequestParam("businessDateWhere") String businessDateWhere,
			@RequestParam("cashAccountCode")String cashAccountCode) throws Exception{
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
			//把基金赋值到债券计息基金
			bondAccrual.setFundCode(fundCode);
			//日期为空
			Date dates=null;
			try {
				//将字符串类型转为日期类型
				dates = AllUtil.getDate(businessDateWhere,0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//将日期赋值到统计日期
			bondAccrual.setSecurityStatisticsDate(dates);
			//将债券代码赋值到证券应收应付债券代码
			bondAccrual.setBondCode(bondAccrual.getBondCode());
			//调用通过债券id查询的方法
			List bondAccrualList=bondAccrualService.selectByIdBondAccrual(bondAccrual.getBondCode());
			//for循环遍历集合
			for(int i=0; i<bondAccrualList.size();i++){
				bondAccrual=(BondAccrual) bondAccrualList.get(i);
			}
			//调用自动生成编号的方法
			String securityArapCode=autoBianService.getAutoBianhao("security_arap", "ZJYSYF", "SECURITY_ARAP_CODE", "business_date",dates);
			//如果付息次数等于1的时候 赋值为360天  否则为180天
			Integer paymentCount=null;
			if(bondAccrual.getPaymentCount()==1){
				paymentCount=360;
			}else if(bondAccrual.getPaymentCount()==2){
				paymentCount=180;
			}
			//调用四舍五入的方法
			Double money=AllUtil.getRoundUp((bondAccrual.getSecurityQuantity()*bondAccrual.getCouponMoney()*bondAccrual.getCouponRate())/paymentCount, 3);
			//调用证券应收应付增加的方法
			SecurityArap securityArap=new SecurityArap(securityArapCode, bondAccrual.getCashAccountCode(), fundCode, bondAccrual.getBondCode(), 3, 1, money,dates,"");
			//调用删除的方法
			securityArapService.deleteSqlWhereSecurityArap(cashAccountCode, dates, fundCode, 3);
			//调用增加的方法
			int flag=securityArapService.insertSecurityArap(securityArap);
			//如果flag大于0 则统计成功 否则统计失败
			if(flag>0){
				return "统计成功";
			}else{
				return "统计失败";
			}
	}
}
