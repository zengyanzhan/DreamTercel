package com.yidu.businessData.controller;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.yidu.businessData.domain.CashArap;
import com.yidu.businessData.service.CashArapService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 现金应收应付控制器
 * @author 邓涛
 * @date 2017年11月14日
 * @time 下午3:53:53
 */
@Controller 
public class CashArapController {
	@Autowired
	CashArapService cashArapService;
	@Autowired
	AutoBianService autoBianService;
	/**
	 * 查询的方法
	 * @param cashArap 现金应收应付实体类
	 * @return gson数据传到js
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="selectCashArap.action",produces="text/html;charset=utf-8")
	public String selectCashArap(@ModelAttribute("SpringWeb")CashArap cashArap,HttpServletRequest request) throws Exception  {
		//得到一个会话
		HttpSession session=request.getSession(false);
		if(session==null){
			session=request.getSession(true);
		}
		//得到基金实体类
		Fund fund=(Fund)session.getAttribute("fund");
		//把基金表基金放入现金应收应付基金
		cashArap.setFundCode(fund.getFundCode());
		//给基金赋值
		session.setAttribute("fundCode",fund.getFundCode());
		//调用查询的方法
		Map<String, Object>map=cashArapService.selectCashArap(cashArap);
		//得到游标集合
		List<CashArap> cashArapList=(List) map.get("cursor");
		//遍历集合
		for(CashArap cashArapEntity:cashArapList){
			//将日期转换为字符串
			cashArapEntity.setStrDate(AllUtil.getStringDate(cashArapEntity.getBusinessDate()));
		}
		//得到总条数
		Integer rows=(Integer) map.get("rowsTotal");
		//创建一个Map集合   里面装的是总条数 和集合
		HashMap<String, Object> maps=new HashMap<String, Object>();
		maps.put("total", rows);
		maps.put("rows", cashArapList);
		//创建一个gson
		Gson gson=new Gson();
		//gson转为json
		String cashArapGson=gson.toJson(maps);
		return cashArapGson;
	}
	/**
	 * 删除的方法
	 * @param cashArap 现金应收应付实体类
	 * @return flag 为1则删除成功 
	 */
	@ResponseBody
	@RequestMapping(value="deleteCashArap.action",produces="text/html;charset=UTF-8")
	public String deleteCashArap(@ModelAttribute("SpringWeb")CashArap cashArap){
		//调用删除的方法
		int flag=cashArapService.deleteCashArap(cashArap);
		if(flag==1){
			return "删除成功";
		}else{
			return "删除失败";
		}
	}
	/**
	 * 增加的方法
	 * @param cashArap 现金应收应付实体类
	 * @return flag 为1则增加成功
	 * @throws Exception  异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertCashArap.action",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	public String insertCashArap(@ModelAttribute("SpringWeb") CashArap cashArap) throws Exception{
		//把字符串日期转换为Date类型
		cashArap.setBusinessDate(AllUtil.getDate(cashArap.getStrDate()));
		//调用增加的方法
		int flag=cashArapService.insertCashArap(cashArap);
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 修改的方法
	 * @param cashArap 实体类
	 * @return flag为1则修改成功
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/updateCashArap",produces="text/html;charset=UTF-8")
	public String updateCashArap(@ModelAttribute("SpringWeb") CashArap cashArap) throws Exception{
		//将界面上的字符串日期转为date
		cashArap.setBusinessDate(AllUtil.getDate(cashArap.getStrDate()));
		//调用修改的方法
		int flag= cashArapService.updateCashArap(cashArap);
		if(flag==1){
			return "修改成功";
		}else{
			return "修改失败";
		}
	}
	/**
	 * 通过id查询
	 * @param cashArap 实体类
	 * @return gson数据传到js
	 * @throws Exception  异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectCashArapById",produces="text/html;charset=UTF-8")
	public String selectCashArapById(@ModelAttribute("SpringWeb") CashArap cashArap) throws Exception{
		//调用通过code查询的方法
		CashArap  cashArapEntity=cashArapService.selectCashArapById(cashArap.getCashArapCode());
		//把date日期转化为字符串
		cashArapEntity.setStrDate(AllUtil.getStringDate(cashArapEntity.getBusinessDate()));
		//创建gson
		Gson gson=new Gson();
		//gson转json
		return gson.toJson(cashArapEntity);
	}
	/**
	 * 调用自动生成编号
	 * @return cash_arap 表名 XJYSYF生成编号前缀  CASH_ACCOUNT_CODE字段名 business_date字段名
	 */
	@ResponseBody
	@RequestMapping(value="/autoCashArapBianhao",produces="text/html;charset=UTF-8")
	public String autoCashArapBianhao() throws Exception{
		return autoBianService.getAutoBianhao("cash_arap", "XJYSYF", "CASH_ARAp_CODE",  "business_date",new Date(System.currentTimeMillis()));
	}
}
