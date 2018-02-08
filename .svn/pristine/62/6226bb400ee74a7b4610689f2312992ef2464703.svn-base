package com.yidu.parameters.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.domain.Manager;
import com.yidu.parameters.service.ManagerService;
import com.yidu.util.service.AutoBianService;

/**
* @author YiWenQi 
* @version 创建时间：2017年11月20日 上午11:23:11
* 管理人信息表的控制器
*/
@Controller
@RequestMapping(value="/manager")
public class ManagerController {
	@Autowired 
	ManagerService managerService;
	@Autowired
	AutoBianService autoBianService;
	@ResponseBody
	@RequestMapping(value="/selectManagerRow.action",produces="text/html;charset=UTF-8")
	public String selectManagerRow(@ModelAttribute("spring")Manager manager) throws Exception{
		System.out.println("进了");
		System.out.println(manager.getPage());
		
		Map<String , Object> map=managerService.selectManagerRow(manager);
		Map<String , Object> hashMap=new HashMap<String , Object>();
		hashMap.put("total", map.get("rowsTotal"));
		hashMap.put("rows", map.get("cursor"));
		Gson gson=new Gson();
		return gson.toJson(hashMap);
	}
	/**
	 * 自动增长
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="autoBianhao",produces="text/html;charset=UTF-8")
	public String autoBianhao () throws Exception{
		return autoBianService.getAutoBianhao("manager", "GLR", "MANAGER_CODE", null, null);

	}
	@ResponseBody
	@RequestMapping(value="/insertManager.action",produces="text/html;charset=UTF-8")
	public String insertManager(@ModelAttribute("springWeb")Manager manager){
		System.out.println(manager);
		int flag=managerService.insertManager(manager);
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	@ResponseBody
	@RequestMapping(value="/updateManager.action",produces="text/html;charset=UTF-8")
	public String updateManager(@ModelAttribute("springWeb")Manager manager) throws Exception{
		System.err.println(manager);
		int flag=managerService.updateManager(manager);
		if(flag==1){
			return "修改成功";
		}else{
			return "修改失败";
		}
		
	}
	@ResponseBody
	@RequestMapping(value="/deleteManager.action",produces="text/html;charset=UTF-8")
	public String deleteManager(@ModelAttribute("springWeb")Manager manager) throws Exception{
		System.err.println(manager.getManagerCode());
		int flag=managerService.deleteManager(manager);
		
		System.err.println(flag);
		if(flag!=0){
			return "成功删除"+flag+"条数据";


		}else{
			return "操作失败";
		}
	}
	@ResponseBody
	@RequestMapping(value="selectManagerByCode",produces="text/html;charset=UTF-8")
	/**
	 * 查询
	 * @param role
	 * @return
	 */
	public String selectManagerByCode(@ModelAttribute("springWeb")Manager manager){
		System.out.println("进了查询了");
		Manager jsonFund = managerService.selectManagerByCode(manager);
		Gson gson = new Gson();
		return gson.toJson(jsonFund);
		
	}
}
