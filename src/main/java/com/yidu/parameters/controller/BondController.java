package com.yidu.parameters.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.parameters.domain.Bond;
import com.yidu.parameters.domain.Security;
import com.yidu.parameters.service.BondService;
import com.yidu.parameters.service.SecurityService;
import com.yidu.util.AllUtil;

/**
 * 债劵信息的控制器类
 * @author 杨丽
 * @date 2017年11月14日	
 * @time 下午4:37:33
 *
 */
@Controller
public class BondController {
	@Autowired
	BondService bondService;
	/**
	 * 查询所有债劵信息
	 * @param response	响应参数
	 * @param request	请求参数
	 * @param bond	债劵信息对象
	 * @return	返回一个json对象
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="selectBonds.action")
	public HashMap<String,Object> selectBonds(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")Bond bond) throws Exception{
		//判断计息起始日不为空
		if(bond.getStrInterestStarDate()!=null && !bond.getStrInterestStarDate().equals("")){
				bond.setInterestStarDate(AllUtil.getDate(bond.getStrInterestStarDate()));	
		}
		//调用多条件拼接方法
		String sqlWhere=bondService.bufferWhere(bond);
		//new一个hashmap
		HashMap<String,Object> map=bondService.selectBonds(bond.getTableName(), sqlWhere,bond.getPage(),bond.getRows(),bond.getRowsTotal(),bond.getOrderColumn(),bond.getOrderStyle());
		//创建一个list集合
		List<Bond> list=(List<Bond>) map.get("bondList");
		//循环遍历集合 将计息起始日与结束日set到页面时间
		for(Bond bonds:list){
			bonds.setStrInterestStarDate(bonds.getInterestStarDate().toString());
			bonds.setStrInterestEndDate(bonds.getInterestEndDate().toString());
		}
		//new一个hashmap
		HashMap<String,Object> jsonMap=new HashMap<String,Object>();
		//put行 和list
		jsonMap.put("total",map.get("rowsTotal"));
		jsonMap.put("rows",list);
		
		return jsonMap;
	}
	/**
	 * 通过债劵id删除的方法
	 * @param response	响应参数
	 * @param request	请求参数
	 * @param bond	债劵信息对象
	 * @return	返回0 删除失败 返回大于0 删除成功
	 * @throws Exception	抛出异常	
	 */
	@ResponseBody
	@RequestMapping(value="deleteBondByBondIds.action")
	public String deleteBondByBondIds(HttpServletResponse response,HttpServletRequest request)throws Exception{
		//得到债劵id
		String bondCode=request.getParameter("bondCode");
		//创建数组
		String [] arr=bondCode.split(",");
		//定义变量
		int size=0;
		//循环遍历数组
		for (int i = 0; i < arr.length; i++) {
			size=bondService.deleteBondByBondIds(arr[i]); 
		}
		if(size!=0){
			return "删除成功";
		}else{
			return "删除失败";
		}
		
	}
	/**
	 * 增加债劵信息的方法
	 * @param response	响应参数
	 * @param request	请求参数
	 * @param bond	债劵信息对象
	 * @return	返回1	增加成功 返回0	增加失败
	 * @throws Exception	抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="insertBond.action")
	public String insertBond(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")Bond bond)throws Exception{
		//判断计息起始日与结束日不为空
		if(bond.getStrInterestStarDate()!=null && !bond.getStrInterestStarDate().equals("")){
			bond.setInterestStarDate(AllUtil.getDate(bond.getStrInterestStarDate()));	
		}
		if(bond.getStrInterestEndDate()!=null && !bond.getStrInterestEndDate().equals("")){
			bond.setInterestEndDate(AllUtil.getDate(bond.getStrInterestEndDate()));	
		}
		System.out.println(bond);
		//调用增加的方法
		int flag=bondService.insertBond(bond);
		if(flag!=0){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}	
	
	/**
	 *修改债劵信息的方法 
	 * @param response	响应参数
	 * @param request	请求参数
	 * @throws Exception	抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="updateBond.action")
	public void updateBond(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")Bond bond)throws Exception{
		//判断计息起始日与结束日不为空
		if(bond.getStrInterestStarDate()!=null && !bond.getStrInterestStarDate().equals("")){
			bond.setInterestStarDate(AllUtil.getDate(bond.getStrInterestStarDate()));	
		}
		if(bond.getStrInterestEndDate()!=null && !bond.getStrInterestEndDate().equals("")){
			bond.setInterestEndDate(AllUtil.getDate(bond.getStrInterestEndDate()));	
		}
		//调用修改的方法
		bondService.updateBond(bond);
	}
	/**
	 * 通过id查询债劵信息
	 * @param response	响应对象
	 * @param request	请求对象
	 * @param bond	债劵信息对象
	 * @throws Exception	抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="selectBondByIds.action")
	public Bond selectBondByIds(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")Bond bond)throws Exception{
		//调用通过id查询的方法
		bond=bondService.selectBondByIds(bond.getBondCode());
		//判断计息起始日与结束日不为空
		if(bond.getInterestStarDate()!=null && !bond.getInterestStarDate().equals("")){
			bond.setStrInterestStarDate(AllUtil.getStringDate(bond.getInterestStarDate()));	
		}
		if(bond.getInterestEndDate()!=null && !bond.getInterestEndDate().equals("")){
			bond.setStrInterestEndDate(AllUtil.getStringDate(bond.getInterestEndDate()));	
		}
		return bond;
	}
	/**
	 * 查询证劵信息id
	 * @param response	响应对象
	 * @param request	请求对象
	 * @param bond	债劵信息对象
	 * @throws Exception	抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="selectSecurityTypes.action")
	public String selectSecurityTypes(HttpServletResponse response,HttpServletRequest request,Security security)throws Exception{
		//调用通过类型查询证券id的方法
		List<Bond> bondList=bondService.selectSecurityTypes(security.getSecurityType());
		System.out.println(bondList.size());
		System.out.println("证券id"+security.getSecurityCode());
		//循环遍历集合大小
		if(bondList.size()==0){
			return "0";
		}else{
		//创建gson 
		Gson gson =new Gson();
		return gson.toJson(bondList);//转json
		}
	}
}
