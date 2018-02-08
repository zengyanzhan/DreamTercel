package com.yidu.cashManagement.controller;


import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileSystemView;

import org.aspectj.apache.bcel.util.SyntheticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.cashManagement.domain.AppropriationOrder;
import com.yidu.cashManagement.domain.ExcelUtil;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.cashManagement.service.AppropriationOrderService;
import com.yidu.cashManagement.service.MoneyAllotService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 划款指令控制器
 * @author 肖光宇
 * @date 2017年12月8日
 * @time 上午10:39:01
 *
 */
@Controller
public class ApproController {
	Gson gson=new Gson();
	@Autowired
	AutoBianService autoBianService;
	@Autowired
	AppropriationOrderService approService;
	@Autowired
	MoneyAllotService moneyAllotService;
	/**
	 * 查询划款指令
	 * @param appropriationOrder  划款指令
	 * @return   Json数据
	 * @throws Exception  异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectAppropriationOrder.action",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	public String selectAppropriationOrder(@ModelAttribute("SpringWeb")AppropriationOrder appropriationOrder) throws Exception{
		HashMap<String, Object>map=approService.selectAppripriationOrder(appropriationOrder);//查询划款指令
		List<AppropriationOrder> approList=(List<AppropriationOrder>) map.get("cursor");//得到划款指令数据
		for (AppropriationOrder appro:approList) {
			String strDate=AllUtil.getStringDate(appro.getOrderDate());//把指令日期转换为字符串
			String strToDate=AllUtil.getStringDate(appro.getToAccountDate());//把到款日期转换为字符串
			appro.setStrOrderDate(strDate);
			appro.setStrToDate(strToDate);
		}
		Integer rows=(Integer) map.get("rowsTotal");//得到条数
		HashMap<String, Object> maps=new 	HashMap<String, Object>();//创建一个hashmap
		maps.put("total", rows);
		maps.put("rows", approList);
		String appros=gson.toJson(maps);//转为json格式
		return appros;

	}
	/**
	 * 增加划款指令
	 * @param appropriationOrder 划款指令
	 * @return  返回值 1 成功 否则失败
	 * @throws Exception  异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertApproOrder.action",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	public String insertApproOrder(@ModelAttribute("SpringWeb")AppropriationOrder appropriationOrder) throws Exception{
		String payName=new String(appropriationOrder.getPayName().getBytes("ISO8859-1"),"UTF-8");
		String payBank=new String(appropriationOrder.getPayBank().getBytes("ISO8859-1"),"UTF-8");
		String cashName=new String(appropriationOrder.getCashName().getBytes("ISO8859-1"),"UTF-8");
		String cashBank=new String(appropriationOrder.getCashBank().getBytes("ISO8859-1"),"UTF-8");
		appropriationOrder.setPayName(payName);
		appropriationOrder.setPayBank(payBank);
		appropriationOrder.setCashName(cashName);
		appropriationOrder.setCashBank(cashBank);
		Date orderDate= AllUtil.getDate(appropriationOrder.getStrOrderDate());//指令日期转为字符串
		Date toDate=AllUtil.getDate(appropriationOrder.getStrToDate());//到款日期转为字符串
		appropriationOrder.setOrderDate(orderDate);
		appropriationOrder.setToAccountDate(toDate);
		int flag=approService.insertApproOrder(appropriationOrder);//调用增加划款指令的方法
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 修改划款指令
	 * @param appropriationOrder  划款指令
	 * @return 1 修改成功 否则失败
	 * @throws Exception  异常
	 */
	@ResponseBody
	@RequestMapping(value="/updateApproOrder.action",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	public String updateApproOrder(@ModelAttribute("SpringWeb")AppropriationOrder appropriationOrder) throws Exception{
		Date orderDate= AllUtil.getDate(appropriationOrder.getStrOrderDate());//字符串转为指令日期
		Date toDate=AllUtil.getDate(appropriationOrder.getStrToDate());//字符串转为到款日期
		appropriationOrder.setOrderDate(orderDate);
		appropriationOrder.setToAccountDate(toDate);
		int flag=approService.updateApproOrder(appropriationOrder);//修改增加划款指令的方法
		if(flag==1){
			return "修改成功";
		}else{
			return "修改失败";
		}
	}
	/**
	 * 自动生成编号
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/autoApproCode",produces="text/html;charset=UTF-8")
	public String autoBianHao() throws Exception{
		Date date=new Date(System.currentTimeMillis());	//得到当前时间
		String code=autoBianService.getAutoBianhao("appropriationOrder", "HK", "appropriationOrderCode", "orderDate", date);
		return code;

	}
	/**
	 * 通过编号查询划款指令
	 * @param appropriationOrder 划款指令
	 * @return  划款指令实体类
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectApproCode.action",produces="text/html;charset=UTF-8")
	public String selectApproCode(@ModelAttribute("SpringWeb")AppropriationOrder appropriationOrder) throws Exception{
		AppropriationOrder appropriationOrders=approService.selectApproCode(appropriationOrder.getCode());
		String  strOrderDate=AllUtil.getStringDate( appropriationOrders.getOrderDate());//指令日期转字符串
		String  strDate=AllUtil.getStringDate( appropriationOrders.getToAccountDate());//调拨日期转字符串
		appropriationOrders.setStrOrderDate(strOrderDate);
		appropriationOrders.setStrToDate(strDate);
		String appr=gson.toJson(appropriationOrders);
		return appr;

	}
     /**
      * 删除划款指令
      * @param appropriationOrder  划款指令
      * @return 1成功 否则失败
      * @throws Exception 异常
      */
	@ResponseBody
	@RequestMapping(value="/deleteAppro",produces="text/html;charset=UTF-8")
	public String deleteAppro(@ModelAttribute("SpringWeb")AppropriationOrder appropriationOrder) throws Exception{
		int flag=approService.deleteApproOrder(appropriationOrder);
		if(flag==1){
			return "删除成功";
		}else{
			return "删除失败";
		}

	}
  /**
   * 生成划款指令
   * @param appropriationOrder 划款指令
   * @param request 请求对象
   * @return 字符串
   * @throws Exception  异常
   */
	@ResponseBody
	@RequestMapping(value="/createMoneyAllot.action",produces="text/html;charset=UTF-8")
	public String createMoneyAllot(@ModelAttribute("SpringWeb")AppropriationOrder appropriationOrder,HttpServletRequest request) throws Exception{
		MoneyAllot  moneyAllot=new MoneyAllot();//创建一个资金调拨
		HttpSession session=request.getSession(false);//得到一个会话
		if(session==null){
			session=request.getSession(true);
		}
		Fund fund=(Fund)session.getAttribute("fund");//得到基金实体类
		moneyAllot.setFundCode(fund.getFundCode());
		Date orderDate= AllUtil.getDate(appropriationOrder.getStrOrderDate());//字符串转指令日期
		Date toDate=AllUtil.getDate(appropriationOrder.getStrToDate());//字符串转到款日期转
		appropriationOrder.setOrderDate(orderDate);
		appropriationOrder.setToAccountDate(toDate);
		Date date=new Date(System.currentTimeMillis());	//得到当前时间
		String code=autoBianService.getAutoBianhao("fund_allot", "ZJDB", "fund_allot_code", "business_date", orderDate);//自动生成资金调拨编号
		System.err.println("code="+code);
		moneyAllot.setCode(code);
		moneyAllot.setMoney(appropriationOrder.getMoney());
		moneyAllot.setAccountCode(appropriationOrder.getCashCode());
		moneyAllot.setDirection(1);
		moneyAllot.setBusinessDate(appropriationOrder.getOrderDate());
		moneyAllot.setDate(appropriationOrder.getToAccountDate());
		moneyAllot.setBusinessCode(appropriationOrder.getCode());
		moneyAllot.setType(1);
		moneyAllot.setDesc("");
		int flag=moneyAllotService.insertMoneyAllot(moneyAllot);
		System.err.println("flag===="+flag);
		MoneyAllot  moneyAllots=new MoneyAllot();//创建一个资金调拨
		System.err.println("aa="+AllUtil.getLocalhostAutoBianHao(code));
		System.err.println("appropriationOrder="+appropriationOrder);
		moneyAllots.setCode(AllUtil.getLocalhostAutoBianHao(code));
		moneyAllots.setMoney(appropriationOrder.getMoney());
		moneyAllots.setFundCode(fund.getFundCode());
		moneyAllots.setAccountCode(appropriationOrder.getPayCode());
		moneyAllots.setDirection(-1);
		moneyAllots.setBusinessDate(appropriationOrder.getOrderDate());
		moneyAllots.setDate(appropriationOrder.getToAccountDate());
		moneyAllots.setBusinessCode(appropriationOrder.getCode());
		moneyAllots.setType(1);
		moneyAllots.setDesc("");
		int flag1=moneyAllotService.insertMoneyAllot(moneyAllots);
		appropriationOrder.setAllotFlag(2);
		approService.updateApproOrder(appropriationOrder);
		if(flag==1&&flag1==1){
			return "生成资金调拨成功";
		}else{
			return "生成资金调拨失败";
		}

	}
	/**
	 * 导出划款指令
	 * @param appropriationOrder 划款指令
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 字符串
	 * @throws Exception  异常
	 */
	@ResponseBody
	@RequestMapping(value="/exportExcel.action",produces="text/html;charset=UTF-8")
	public String exportExcel(@ModelAttribute("SpringWeb")AppropriationOrder appropriationOrder,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try{
			//通过编号查询划款指令
			AppropriationOrder appro=approService.selectApproCode(appropriationOrder.getCode());
			//创建导出对象
			ExcelUtil excelUtil=new ExcelUtil();
			//设置页面类型
			response.setContentType("octets/stream");
			System.err.println("appro="+appro);
			//得到应用上下文路径
			String strPath=request.getServletContext().getRealPath("/")+"xlsx\\基金划款指令书模板.xlsx";
			//得到工作表
			excelUtil.getSheet(strPath,appro);
			
			//得到文件保存的目录
			String realpath = request.getSession().getServletContext().getRealPath("/xlsx");
			
			//创建每天的文件夹
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			//路径拼接
			realpath =realpath +"\\appro"+format.format(new java.util.Date(System.currentTimeMillis()))+".xlsx";
			//创建一个文件
			File pathFile = new File(realpath);
			excelUtil.exportToNewFile(realpath);//导出
			//下载
			autoBianService.downLoad(realpath, request, response);
			return "导出成功";
		}
		catch(Exception e){
			return "导出失败";
		}


	}

}
