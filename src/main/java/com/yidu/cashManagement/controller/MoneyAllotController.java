package com.yidu.cashManagement.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.cashManagement.service.MoneyAllotService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;

/**
 * 资金调拨的控制器
 * @author 肖光宇
 * @date 2017年11月13日
 * @time 下午7:07:22
 *
 */
@Controller
public class MoneyAllotController {
	Gson gson=new Gson();
	@Autowired
	AutoBianService autoBianService;
	@Autowired
	MoneyAllotService moneyAllotService;
	/**
	 * 查询资金调拨
	 * @param moneyAllot 资金调拨实体类
	 * @param request 请求对象
	 * @return json数据
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectMoneyAllot",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	public String selectMonayAllot(@ModelAttribute("SpringWeb") MoneyAllot moneyAllot,HttpServletRequest request) throws Exception  {
		HttpSession session=request.getSession(false);//得到一个会话
		if(session==null){
			session=request.getSession(true);
		}
		Fund fund=(Fund)session.getAttribute("fund");//得到基金实体类
		moneyAllot.setFundCode(fund.getFundCode());
		HashMap<String, Object>map=moneyAllotService.selectMoneyAllot(moneyAllot);
		List<MoneyAllot> moneyAllotList=(List<MoneyAllot>) map.get("cursor");//得到资金调拨的数据
		for (MoneyAllot money:moneyAllotList) {//循环遍历
			String strDate=AllUtil.getStringDate(money.getDate());//把调拨日期转换为字符串
			String strBusinessDate=AllUtil.getStringDate(money.getBusinessDate());//把业务日期转换为字符串
			money.setStrDate(strDate);
			money.setStrBusinessDate(strBusinessDate);
		}
		Integer rows=(Integer) map.get("rowsTotal");
		HashMap<String, Object> maps=new HashMap<String, Object>();
		maps.put("total", rows);
		maps.put("rows", moneyAllotList);
		String moneyAllo=gson.toJson(maps);  //转为json格 式
		System.out.println(moneyAllo);
		return moneyAllo;  
	}
     /**
      * 增加资金调拨
      * @param moneyAllot  资金调拨
      * @return  1代表成功  否则失败
      * @throws Exception  异常
      */
	@ResponseBody
	@RequestMapping(value="/insertMoneyAllot",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	public String insertMoneyAllot(@ModelAttribute("SpringWeb") MoneyAllot moneyAllot) throws Exception{
		Date date=AllUtil.getDate(moneyAllot.getStrDate());//调拨字符串转date
		moneyAllot.setDate(date);
		Date businessDate=AllUtil.getDate(moneyAllot.getStrBusinessDate());//业务字符串转date
		moneyAllot.setBusinessDate(businessDate);
		int flag=moneyAllotService.insertMoneyAllot(moneyAllot);//增加
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}

	}
	/**
	 * 修改资金调拨
	 * @param moneyAllot  资金调拨
	 * @return 1代表成功 否则失败
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/updateMoneyAllot",produces="text/html;charset=UTF-8")
	public String updateMoneyAllot(@ModelAttribute("SpringWeb") MoneyAllot moneyAllot) throws Exception{
		Date date=AllUtil.getDate(moneyAllot.getStrDate());//字符串转date
		moneyAllot.setDate(date);
		Date businessDate=AllUtil.getDate(moneyAllot.getStrBusinessDate());//字符串转date
		moneyAllot.setBusinessDate(businessDate);
		int flag= moneyAllotService.updateMoneyAllot(moneyAllot);  //修改
		System.out.println("moneyAllot="+moneyAllot);
		if(flag==1){
			return "修改成功";
		}else{
			return "修改失败";
		}
	}
	/**
	 * 通过编号查询资金调拨
	 * @param moneyAllot  资金调拨
	 * @return  资金调拨编号
	 * @throws Exception  异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectMoneyAllotByCode",produces="text/html;charset=UTF-8")
	public String selectMoneyAllotByCode(@ModelAttribute("SpringWeb") MoneyAllot moneyAllot) throws Exception{
		//通过编号查询资金调拨
		MoneyAllot  moneyAllotEntity=moneyAllotService.selectMoneyAllotByCode(moneyAllot.getCode());
		//调拨日期转为字符串
		String strDate=AllUtil.getStringDate(moneyAllotEntity.getDate());
		//业务日期转为字符串
		String strBusinessDate=AllUtil.getStringDate(moneyAllotEntity.getBusinessDate());
		System.out.println("strBusinessDate="+strBusinessDate);
		moneyAllotEntity.setStrDate(strDate);//赋值
		moneyAllotEntity.setStrBusinessDate(strBusinessDate);//赋值
		System.out.println("moneyAllotEntity="+moneyAllotEntity);
		return  gson.toJson(moneyAllotEntity);
	}
    /**
     * 删除资金调拨
     * @param moneyAllot 资金调拨实体类
     * @return 1代表成功 否则失败
     */
	@ResponseBody
	@RequestMapping(value="/deleteMoneyAllot",produces="text/html;charset=UTF-8")
	public String deleteMoneyAllot(@ModelAttribute("SpringWeb") MoneyAllot moneyAllot){
		int flag=moneyAllotService.deleteMoneyAllot(moneyAllot);
		if(flag==1){
			return "删除成功";
		}else{
			return "删除失败";
		}
	}
	/**
	 * 自动生成资金调拨
	 * @param moneyAllot 资金调拨
	 * @return 资金调拨编号
	 */
	@ResponseBody
	@RequestMapping(value="/autoBianHao",produces="text/html;charset=UTF-8")
	public String autoBianHao(@ModelAttribute("SpringWeb") MoneyAllot moneyAllot) throws Exception{
		
		Date businessDate=AllUtil.getDate(moneyAllot.getStrBusinessDate());//业务字符串转date
		//自动生成编号
		String code=autoBianService.getAutoBianhao("fund_allot", "ZJDB", "fund_allot_code", "business_date", businessDate);
		return code;

	}


}
