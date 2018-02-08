package com.yidu.system.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.system.dao.RoleDao;
import com.yidu.system.domain.Role;
import com.yidu.system.service.RoleService;
/**
 * 角色的实现类
 * @author HeXiXian
 * @date   2017年11月14日
 * @time   上午9:36:04
 *
 */
@Transactional
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDao roleDao;//角色Dao类
	@Override
	/**
	 * 查询角色
	 */
	public Map<String, Object> selectRole(Role role) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer strWhere=new StringBuffer();
		String names=role.getRoleName();
		String name=null;
		if(names!=null){
			 name=new String(names.getBytes("iso8859-1"),"UTF-8");
		}
		if(name!=null&&!name.equals("")){
			strWhere.append(" and role_name like '%"+name+"%'");
			
		}if(role.getRoleFlag()!=null){
			strWhere.append(" and role_flag ="+role.getRoleFlag());
		}
		System.err.println(strWhere);
		map.put("tableName", "role");//表名
		map.put("qualification", strWhere.toString());//条件
		map.put("page", role.getPage());//当前的页
		map.put("rows", role.getRows());//当前页显示的行数
		map.put("orderColumn", "role_code");//排序的列
		map.put("orderStyle", role.getSortOrder());//排序的方式
		roleDao.selectRole(map);
		// TODO Auto-generated method stub
		return map;
	}
	/**
	 * 增加
	 */
	@Override
	public Integer insertRole(Role role) {
		// TODO Auto-generated method stub
		return roleDao.insertRole(role);
	}
	/**
	 * 修改
	 */
	@Override
	public Integer updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleDao.updateRole(role);
	}
	/**
	 * 删除
	 */
	@Override
	public Integer deleteRole(Role role) {
		// TODO Auto-generated method stub
		return roleDao.deleteRole(role);
	}
	/**
	 * 按ID查询
	 */
	@Override
	public Role selectOneRoleByCode(Role role) {
		// TODO Auto-generated method stub
		return roleDao.selectOneRoleByCode(role);
	}
}
