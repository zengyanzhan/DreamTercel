package com.yidu.parameters.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import com.yidu.parameters.domain.Trustee;
import com.yidu.parameters.service.TrusteeService;
import com.yidu.util.service.AutoBianService;

/**
* @author YiWenQi 
* @version 创建时间：2017年11月22日 下午2:10:48
* 托管人的控制器(类说明)
*/

@Controller
@RequestMapping(value="/trustee")
public class TrusteeController {
	@Autowired
	TrusteeService trusteeService;
	@Autowired
	AutoBianService autoBianService;
	@ResponseBody
	@RequestMapping(value="/selectTrusteeRow.action",produces="text/html;charset=UTF-8")
	public String selectTrusteeRow(@ModelAttribute("spring")Trustee trustee) throws Exception{
		System.out.println("进了");
		System.out.println(trustee.getPage());
		Map<String , Object> map=trusteeService.selectTrusteeRow(trustee);
		Map<String , Object> hashMap=new HashMap<String , Object>();
		hashMap.put("total", map.get("rowsTotal"));
		hashMap.put("rows", map.get("cursor"));
		Gson gson=new Gson();
		return gson.toJson(hashMap);
	}
	/**
	 * 新增
	 * @param trustee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertTrustee.action",produces="text/html;charset=UTF-8")
	public String insertTrustee(@ModelAttribute("springWeb")Trustee trustee){
		System.out.println("天堂"+trustee);
		//托管信息服务得到增加的方法
		int flag=trusteeService.insertTrustee(trustee);
		//判断定义的变量
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 修改
	 * @param trustee
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/updateTrustee.action",produces="text/html;charset=UTF-8")
	public String updateTrustee(@ModelAttribute("springWeb")Trustee trustee) throws Exception{
		System.err.println(trustee);
		//托管信息服务得到修改的方法
		int flag=trusteeService.updateTrustee(trustee);
		if(flag==1){
			return "修改成功";
		}else{
			return "修改失败";
		}
		
	}
	/**
	 * 删除
	 * @param trustee
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/deleteTrustee.action",produces="text/html;charset=UTF-8")
	public String deleteTrustee(@ModelAttribute("springWeb")Trustee trustee) throws Exception{
		System.err.println(trustee.getTrusteeCode());
		//托管信息服务得到删除的方法
		int flag=trusteeService.deleteTrustee(trustee);
		
		System.err.println(flag);
		if(flag!=0){
			return "成功删除"+flag+"条数据";


		}else{
			return "操作失败";
		}
	}
	/**
	 * 自动增长
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="autoBianhao",produces="text/html;charset=UTF-8")
	public String autoBianhao () throws Exception{
		return autoBianService.getAutoBianhao("trustee", "TGR", "TRUSTEE_CODE", null, null);

	}
	@ResponseBody
	@RequestMapping(value="selecTrusteeByCode",produces="text/html;charset=UTF-8")
	/**
	 * 查询
	 * @param trustee
	 * @return
	 */
	public String selectTrusteeByCode(@ModelAttribute("springWeb")Trustee trustee){
		System.out.println("进了查询了");
		Trustee jsonFund = trusteeService.selectTrusteeByCode(trustee);
		Gson gson = new Gson();
		return gson.toJson(jsonFund);
		
	}
	
}
