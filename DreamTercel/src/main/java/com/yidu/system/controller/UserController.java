package com.yidu.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yidu.parameters.dao.FundDao;
import com.yidu.parameters.domain.Fund;
import com.yidu.system.dao.RoleDao;
import com.yidu.system.domain.Role;
import com.yidu.system.domain.User;

import com.yidu.system.service.UserService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;

/**
 * 用户的控制器
 * @author HeXiXian
 * @data  2017年11月14日
 * @time  上午9:33:54
 *
 */
@Controller
public class UserController {
	@Autowired
	UserService userService;//注入用户的业务处理层
	@Autowired
	AutoBianService autoBianService;//注入自动生成编号的业务处理层
	@Autowired
	FundDao fundDao;//注入基金信息业务处理层
	@Autowired
	RoleDao roleDao;//注入角色管理的业务处理层
	@ResponseBody	
	@RequestMapping(value="/checkLogin.action")
	public String checkLogin(@ModelAttribute("springMvc")User user,HttpServletRequest request) throws Exception {
		System.out.println(user);
		 user=userService.checkLogin(user);//登录验证
		String loginFlag ="";
		if(user!=null){//判断登录标志不等于0 即登录成功
			//创建 session对象
			HttpSession session =request.getSession(false);
			if(session!=null){
				request.getSession(true);
			}
			//将登录的用户信息添加到作用域
			session.setAttribute("user", user);
			//得到登录的基金编号
			String fundCode=request.getParameter("fundCode");
			System.err.println("fundCode="+fundCode);
			//判断基金编号是否为空
			if(fundCode==null||fundCode.equals("")){
				//得到角色编号
				String roleCode=user.getRoleCode();
				//创建一个实体
				Role role = new Role();
				role.setRoleCode(roleCode);
				//得到查询的方法
				role=roleDao.selectOneRoleByCode(role);
				if(role.getRoleName().equals("admin")){
					user.setUserFlag(-1);
					//将登录的用户信息添加到作用域
					session.setAttribute("user", user);
					loginFlag ="1";
				}else{
					session.removeAttribute("user");
					return "请用管理员账户登录该系统";
				}
			}else{
				Fund fund = new Fund();
				fund.setFundCode(fundCode);
				fund=fundDao.selectFundByCode(fund);
				session.setAttribute("fund", fund);
				loginFlag ="1";
			}
		}else{
			loginFlag ="0";
		}

		return ""+loginFlag;
	}
	/**
	 * 查询用户
	 * @param user 用户实体类
	 * @return
	 * @throws Exception 异常处理
	 */
	@ResponseBody
	@RequestMapping(value="/selectUser.action",produces="text/html;charset=UTF-8")
	public String selectUser(@ModelAttribute("springMvc")User user)throws Exception{
		System.out.print("user="+user);
		//得到查询的方法
		Map<String, Object>map=userService.selectUser(user);
		@SuppressWarnings("unchecked")
		//得到查询用户的集合
		List<User> userList=(List<User>) map.get("cursor");
		//循环
		for (User users:userList) {
			//时间转字符型
			String createDates=AllUtil.getStringDate(users.getUserCreateDate());
			users.setCreateDate(createDates);
		}
		HashMap<String, Object> jsonMap=new HashMap<String,Object>();
		jsonMap.put("total", map.get("rowsTotal"));
		jsonMap.put("rows", userList);
		Gson gson=new Gson();
		return gson.toJson(jsonMap);
	}
	/**
	 * 添加用户
	 * @param user 用户实体类
	 * @return
	 * @throws Exception 异常处理
	 */
	@ResponseBody
	@RequestMapping(value="insertUser",produces="text/html;charset=UTF-8")
	public String insertUser(@ModelAttribute("springmvc")User user) throws Exception{
		//时间转字符串
		user.setUserCreateDate(AllUtil.getDate(user.getCreateDate()));
		//调用业务逻辑处理层
		int flag=userService.insertUser(user);
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 删除用户
	 * @param user 用户实体类
	 * @return
	 * @throws Exception 异常处理
	 */
	@ResponseBody                         
	@RequestMapping(value="deleteUser",produces="text/html;charset=UTF-8")
	public String deleteUser(@ModelAttribute("springMvc")User user)throws Exception{
		//调用业务逻辑处理层得到数据
		int flag=userService.deleteUser(user);
		if(flag!=0){
			return "成功删除"+flag+"条数据";
		}else{
			return "操作失败";
		}
	}
	/**
	 * 自动生成编号
	 * @return 自动生成编号
	 * @throws Exception  异常处理
	 */
	@ResponseBody
	@RequestMapping(value="autoUserBianhao",produces="text/html;charset=UTF-8")
	public String autoBianhao () throws Exception{
		//得到自动生成编号方法
		return autoBianService.getAutoBianhao("users", "YH", "user_code ", null, null);
	}
	/**
	 * 通过编号查询数据
	 * @param user 用户实体类
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/selectOneUserByCode",produces="text/html;charset=UTF-8")
	public String selectOneByCode(@ModelAttribute("springMvc")User user) throws Exception{
		//调用业务逻辑处理层
		User  jsonUser=userService.selectOneByCode(user);
		//日期转字符串
		jsonUser.setCreateDate(AllUtil.getStringDate(jsonUser.getUserCreateDate()));
		Gson gson=new Gson();
		return gson.toJson(jsonUser);
	}
	/**
	 * 修改用户
	 * @param user  用户实体类
	 * @return
	 * @throws Exception 异常处理
	 */
	@ResponseBody
	@RequestMapping(value="updateUser",produces="text/html;charset=UTF-8")
	public String updateUser(@ModelAttribute("spingmvc")User user) throws Exception{
		//日期转字符串
		user.setUserCreateDate(AllUtil.getDate(user.getCreateDate()));
		//调用业务逻辑处理层得到数据
		int flag=userService.updateUser(user);
		if(flag==1){
			return "修改成功";
		}else{
			return "修改失败";
		}
	}
	@RequestMapping(value="logOffUser")
	public ModelAndView logOffUser(HttpServletRequest request)throws Exception{
		HttpSession session=request.getSession(false);
		if(session==null){
			session=request.getSession(true);
		}
		User user =(User)session.getAttribute("user");
		if(user!=null){
			session.removeAttribute("user");
		}
		Role role =(Role)session.getAttribute("role");
		if(role!=null){
			session.removeAttribute("role");
		}
		return new ModelAndView("redirect:index.jsp");
	}  
}
