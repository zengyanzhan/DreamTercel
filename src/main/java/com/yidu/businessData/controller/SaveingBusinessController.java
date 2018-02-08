package com.yidu.businessData.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.businessData.dao.CashArapDao;
import com.yidu.businessData.domain.CashArap;
import com.yidu.businessData.domain.SaveingBusiness;
import com.yidu.businessData.service.SaveingBusinessService;
import com.yidu.cashManagement.dao.MoneyAllotDao;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.cashManagement.service.MoneyAllotService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;


/**
 * 存款业务表的控制器类
 * @author ChenJiaLong
 * @date 2017年11月20日
 * @time 上午11:26:57
 *
 */
@Controller
public class SaveingBusinessController {

	@Autowired
	SaveingBusinessService saveingBusinessService;
	@Autowired
	AutoBianService autoBianService;
	@Autowired
	MoneyAllotService moneyALlotService;
	@Autowired
	CashArapDao cashArapDao;
	@Autowired
	MoneyAllotDao moneyAllotDao;
	/**
	 * 查询存款业务数据
	 * @param response
	 * @param request
	 * @param saveingBusiness
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="selectSaveingBusiness.action",produces = "text/html;charset=UTF-8")
	public String selectSaveingBusiness(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")SaveingBusiness saveingBusiness) throws IOException  {
		HttpSession session=request.getSession(false);//得到一个会话
		if(session==null){
			session=request.getSession(true);
		}
		Fund fund=(Fund)session.getAttribute("fund");//得到基金实体类
		saveingBusiness.setFundCode(fund.getFundCode());
		System.err.println("这是查询存款业务表的方法="+saveingBusiness);
		Map<String, Object> map=saveingBusinessService.selectSaveingBusiness(saveingBusiness);
		HashMap<String, Object>  jsonMap = new HashMap<String,Object>();//创建HashMap

		List<SaveingBusiness> list=(List<SaveingBusiness>) map.get("cursor");//得到游标数据
		for(SaveingBusiness SaveingBusiness:list){//遍历list集合
			SaveingBusiness.setStrDate(SaveingBusiness.getBusinessDate().toString());//将日期改成String类型
			SaveingBusiness.setStrDateEnd(SaveingBusiness.getSavingEndDate().toString());//业务结束日期
		}

		System.err.println("aas="+map.get("cursor"));
		jsonMap.put("total", map.get("rowsTotal"));//
		jsonMap.put("rows",map.get("cursor"));//
		Gson gson = new Gson();//创建Json
		return gson.toJson(jsonMap);//返回 
	}

	/**
	 * 删除一条存款业务的表的数据
	 * @param cashStockdomain
	 * @return 被删除所选列的ID（String）
	 */
	@ResponseBody
	@RequestMapping(value="deleteSaveingBusiness.action",produces = "text/html;charset=UTF-8")
	public String deleteSaveingBusiness(@ModelAttribute("SpringWeb")SaveingBusiness saveingBusiness) throws IOException {
		String  [] code=saveingBusiness.getSavingCode().split(",");
		int flag=0;
		for (int i = 0; i < code.length; i++) {
			String cunkuancode="'"+code[i]+"'";//拼接逗号
			saveingBusiness.setSavingCode(cunkuancode);
			flag=saveingBusinessService.deleteSaveingBusiness(saveingBusiness);   //调用删除存款业务表数据的方法

			MoneyAllot moneyAllot=new MoneyAllot();
			moneyAllot.setBusinessCode(code[i]);//赋值业务编号
			System.err.println(saveingBusiness);
			int flag1=moneyAllotDao.deleteAllotCode(moneyAllot);//删除资金调拨

		}
		if(flag>0){
			return "删除成功";


		}else{
			return "删除失败";
		}

	}

	/**
	 * 新增一条存款业务表的数据
	 * @param cashStockdomain
	 * @return CashStock存款业务的实体类
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="insertSaveingBusiness.action",produces = "text/html;charset=UTF-8")
	public String insertSaveingBusiness(@ModelAttribute("SpringWeb")SaveingBusiness saveingBusiness,HttpServletRequest request) throws Exception {
		System.out.println("这是新增存款业务表的方法");
		Date businessDate=AllUtil.getDate(saveingBusiness.getStrDate());
		String code=autoBianService.getAutoBianhao("saveing_business", "CKYW", "saveing_business_code", "business_date", businessDate);
		
		saveingBusiness.setSavingCode(code);
		saveingBusiness.setBusinessDate(businessDate);
		saveingBusiness.setSavingEndDate(AllUtil.getDate(saveingBusiness.getStrDateEnd()));
		saveingBusiness.setFlag(1);//默认未办理
		int flag=saveingBusinessService.insertSaveingBusiness(saveingBusiness);//调用新增t的方法(返回结果)
		//添加到资金调拨
		MoneyAllot moneyAllot=new MoneyAllot();
		String moneyAllotCode=autoBianService.getAutoBianhao("fund_allot", "ZJDB", "fund_allot_code", "business_date", businessDate);
		System.err.println("moneyAllotCode="+moneyAllotCode);
		HttpSession session=request.getSession(false);//得到一个会话
		if(session==null){
			session=request.getSession(true);
		}
		Fund fund=(Fund)session.getAttribute("fund");//得到基金实体类
		moneyAllot.setFundCode(fund.getFundCode());
		moneyAllot.setCode(moneyAllotCode);
		moneyAllot.setMoney(saveingBusiness.getSavingMoney());
		moneyAllot.setAccountCode(saveingBusiness.getInCashAccountCode());
		moneyAllot.setDirection(1);
		moneyAllot.setBusinessDate(saveingBusiness.getBusinessDate());
		moneyAllot.setBusinessCode(code);
		moneyAllot.setDate(saveingBusiness.getBusinessDate());
		moneyAllot.setType(1);
		moneyAllot.setDesc("");
		moneyALlotService.insertMoneyAllot(moneyAllot);
		System.err.println("s="+AllUtil.getLocalhostAutoBianHao(moneyAllotCode));
		MoneyAllot twoMoneyAllot=new MoneyAllot();
		twoMoneyAllot.setFundCode(fund.getFundCode());
		twoMoneyAllot.setCode(AllUtil.getLocalhostAutoBianHao(moneyAllotCode));
		twoMoneyAllot.setMoney(saveingBusiness.getSavingMoney());
		twoMoneyAllot.setAccountCode(saveingBusiness.getOutCashAccountCode());
		twoMoneyAllot.setDirection(-1);
		twoMoneyAllot.setBusinessDate(saveingBusiness.getBusinessDate());
		twoMoneyAllot.setBusinessCode(code);
		twoMoneyAllot.setDate(saveingBusiness.getBusinessDate());
		twoMoneyAllot.setType(1);
		twoMoneyAllot.setDesc("");
		moneyALlotService.insertMoneyAllot(twoMoneyAllot);
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}


	}
	@ResponseBody
	@RequestMapping(value="selectDate.action",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	public String selectDate(@ModelAttribute("springWeb")SaveingBusiness saveingBusiness) throws Exception{
		System.err.println("进来了");
		String strDate=null;
		if(saveingBusiness.getStrDate()!=null&&!saveingBusiness.getStrDate().equals("")){
			Date endDate=AllUtil.getDate(saveingBusiness.getStrDate(), saveingBusiness.getBusinessType());
			strDate=AllUtil.getStringDate(endDate);

		}
		return strDate;
	}
	/**
	 * 通过ID列查询每行的数据 
	 * @param role 角色实体类
	 * @return 返回查询出来的数据
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="expire.action",produces="text/html;charset=UTF-8")
	public String expire(@ModelAttribute("springWeb")SaveingBusiness saveingBusiness,HttpServletRequest request) throws Exception{
		System.err.println("aa="+saveingBusiness.getSavingCode());
		HttpSession session=request.getSession(false);//得到一个会话
		if(session==null){
			session=request.getSession(true);
		}
		Date savindEndDada=AllUtil.getDate(saveingBusiness.getStrDate());
		saveingBusiness.setBusinessDate(AllUtil.getDate(saveingBusiness.getStrDate()));
		saveingBusiness.setSavingEndDate(AllUtil.getDate(saveingBusiness.getStrDateEnd()));
		Fund fund=(Fund)session.getAttribute("fund");//得到基金实体类
		Date date=new Date(System.currentTimeMillis());	//得到当前时间
		String code=autoBianService.getAutoBianhao("cash_arap", "XJYSYF", "cash_arap_code", "business_date", savindEndDada);//自动生成现金应收应付编号
		CashArap cashArap=new CashArap(code,saveingBusiness.getOutCashAccountCode(),fund.getFundCode(),3,-1,saveingBusiness.getSavingMoney(),savindEndDada,"");
		cashArapDao.insertCashArap(cashArap);//增加现金应付
		//添加到资金调拨
		MoneyAllot moneyAllot=new MoneyAllot();
		String moneyAllotCode=autoBianService.getAutoBianhao("fund_allot", "ZJDB", "fund_allot_code", "business_date", savindEndDada);
		System.err.println("moneyAllotCode="+moneyAllotCode);
		moneyAllot.setFundCode(fund.getFundCode());
		moneyAllot.setCode(moneyAllotCode);
		moneyAllot.setMoney(saveingBusiness.getSavingMoney());
		moneyAllot.setAccountCode(saveingBusiness.getInCashAccountCode());
		moneyAllot.setDirection(-1);
		moneyAllot.setBusinessDate(saveingBusiness.getBusinessDate());
		moneyAllot.setBusinessCode(code);
		moneyAllot.setDate(saveingBusiness.getSavingEndDate());
		moneyAllot.setType(1);
		moneyAllot.setDesc("");
		moneyALlotService.insertMoneyAllot(moneyAllot);
		MoneyAllot twoMoneyAllot=new MoneyAllot();
		System.err.println("1111="+AllUtil.getLocalhostAutoBianHao(moneyAllotCode));
		twoMoneyAllot.setFundCode(fund.getFundCode());
		twoMoneyAllot.setCode(AllUtil.getLocalhostAutoBianHao(moneyAllotCode));
		twoMoneyAllot.setMoney(saveingBusiness.getSavingMoney());
		twoMoneyAllot.setAccountCode(saveingBusiness.getOutCashAccountCode());
		twoMoneyAllot.setDirection(1);
		twoMoneyAllot.setBusinessDate(saveingBusiness.getBusinessDate());
		twoMoneyAllot.setBusinessCode(code);
		twoMoneyAllot.setDate(saveingBusiness.getSavingEndDate());
		twoMoneyAllot.setType(1);
		twoMoneyAllot.setDesc("");
		moneyALlotService.insertMoneyAllot(twoMoneyAllot);
		saveingBusiness.setFlag(2);//把未到期办理修改为到期办理
		int flag=saveingBusinessService.updateSaveingBusiness(saveingBusiness);//修改标志
		if(flag==1){
			return "到期办理成功";
		}else{
			return "到期办理失败";
		}
	}
}
