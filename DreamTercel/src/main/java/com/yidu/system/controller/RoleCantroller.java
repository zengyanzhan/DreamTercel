package com.yidu.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.system.domain.Role;
import com.yidu.system.service.RoleService;
import com.yidu.util.service.AutoBianService;
/**
 * 角色管理控制器
 * @author HeXiXian
 * @date   2017年11月14日
 * @time   上午10:52:26
 *
 */
@Controller
public class RoleCantroller {
	@Autowired
	RoleService roleService;//角色服务类
	@Autowired
	AutoBianService autoBianService;//自动生成编号
	/**
	 * 查询角色控制器
	 * @param role 	角色实体类
	 * @return 返回Json格式后的字符串 
	 * @throws Exception 异常处理
	 */
	@ResponseBody
	@RequestMapping(value="selectRole.action",produces="text/html;charset=UTF-8")
	public String selectRole(@ModelAttribute("springMvc")Role  role) throws Exception{
		//调用业务逻辑处理层
		Map<String, Object> map=roleService.selectRole(role);
		HashMap<String, Object>  jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", map.get("rowsTotal"));
		jsonMap.put("rows", map.get("cursor"));
		Gson gson = new Gson();
		return gson.toJson(jsonMap);
	} 
	/**
	 * 增加角色控制器
	 * @param role 角色实体类
	 * @return 返回增加的
	 */
	@ResponseBody
	@RequestMapping(value="insertRole",produces="text/html;charset=UTF-8")
	public String insertRole(@ModelAttribute("springmvc")Role role){
		//调用业务逻辑处理层得到数据
		int flag=roleService.insertRole(role);
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 自动生成编号
	 * @return 自动生成编号
	 * @throws Exception  异常处理
	 */
	@ResponseBody
	@RequestMapping(value="autoBianhaoRole",produces="text/html;charset=UTF-8")
	public String autoBianhao () throws Exception{
		//得到自动生成编号方法
		return autoBianService.getAutoBianhao("role", "JS", "ROLE_CODE", null, null);
	}
	/**
	 * 通过ID列查询每行的数据
	 * @param role 角色实体类
	 * @return 返回查询出来的数据
	 */
	@ResponseBody
	@RequestMapping(value="selectOneRoleByCode",produces="text/html;charset=UTF-8")
	public String selectOneRoleByCode(@ModelAttribute("springWeb")Role role){
		//调用业务逻辑处理层
		Role jsonRole = roleService.selectOneRoleByCode(role);
		Gson gson = new Gson();
		return gson.toJson(jsonRole);
	}
	/**
	 * 修改角色控制器
	 * @param role 角色实体类
	 * @return  返回修改后的数据
	 * @throws Exception 异常处理
	 */
	@ResponseBody
	@RequestMapping(value="updateRole",produces="text/html;charset=UTF-8")
	public String updateRole(@ModelAttribute("springWeb")Role role) throws Exception{
		//调用业务逻辑处理层得到数据
		int flag=roleService.updateRole(role);
		if(flag==1){
			return "修改成功";
		}else{
			return "修改失败";
		}
	}
	/**
	 * 删除角色控制器
	 * @param role 角色实体类
	 * @return 通过ID列删除每行数据
	 * @throws Exception 异常处理
	 */
	@ResponseBody
	@RequestMapping(value="deleteRole",produces="text/html;charset=UTF-8")
	public String deleteRole(@ModelAttribute("springmvc")Role role) throws Exception{
		//调用业务逻辑处理层得到数据
		int flag=roleService.deleteRole(role);
		if(flag!=0){
			return "成功删除"+flag+"条数据";
		}else{
			return "操作失败";
		}
	}
	
}
