package com.yidu.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yidu.system.domain.Right;
import com.yidu.system.domain.Role;
import com.yidu.system.domain.RoleRight;
import com.yidu.system.service.RoleRightService;

/**
 * 角色权限的控制器
 * @author ZouJianwen
 * @data  2017年11月17日
 * @time  下午1:51:03
 *
 */
@Controller
public class RoleRightController {

	@Autowired
	RoleRightService roleRightService;
	/**
	 * 权限的增加
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/insertRoleRight.action",produces="text/html;charset=utf-8")
	public String insertRoleRight(HttpServletRequest request)throws Exception{
		//设置字符编码
		request.setCharacterEncoding("UTF-8");
		//得到会话
		HttpSession session=request.getSession(false);
		if(session==null){
			session=request.getSession(true);
		}
		//得到角色对象
		Role role=(Role)session.getAttribute("role");
		//JSON对象
		String strRightRole = request.getParameter("roleRight");
		Gson gson = new Gson(); 
		//将JSON对象转集合
		List<RoleRight> roleRightList= gson.fromJson(strRightRole, new TypeToken<List<RoleRight>>(){}.getType());
		//创建权限对象
		RoleRight deleteRoleRight = new RoleRight();
		//设置角色变编号
		deleteRoleRight.setRoleCode(role.getRoleCode());
		//删除该角色的所有权限
		roleRightService.deleteRoleRight(deleteRoleRight);
		//循环添加权限
		for (int i = 0; i < roleRightList.size(); i++) {
			//得到每个权限对象
			RoleRight roleRight = roleRightList.get(i);
			//设置角色
			roleRight.setRoleCode(role.getRoleCode());
			//增加
			roleRightService.insertRoleRight(roleRight);
		}	
		return "修改成功";
	}
}
