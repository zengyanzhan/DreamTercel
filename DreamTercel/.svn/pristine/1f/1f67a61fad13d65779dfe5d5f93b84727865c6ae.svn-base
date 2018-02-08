package com.yidu.system.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.yidu.system.domain.Role;
/**
 * 角色服务类
 * @author HeXiXian
 * @date   2017年11月14日
 * @time   上午9:35:30
 *
 */
public interface RoleService {
	/**
	 * 查询
	 * @param role 角色实体类
	 * @return Map<String, Object> 角色类的集合
	 * @throws UnsupportedEncodingException 
	 */
	public Map<String, Object> selectRole(Role role) throws UnsupportedEncodingException;
	/**
	 * 增加
	 * @param role 角色实体类
	 * @return 返回一行增加的数据
	 */
	public Integer insertRole(Role role);
	/**
	 * 修改
	 * @param role 角色实体类
	 * @return 返回修改后的数据
	 */
	public Integer updateRole(Role role);
	/**
	 * 删除
	 * @param arrIds  所有ID的拼接数组
	 * @return 通过ID删除每行
	 */
	public Integer deleteRole(Role role);
	/**
	 * 通过编号查询数据
	 * @param role 包含编号的实体类
	 * @return  查询出选中的ID列的数据
	 */
	public Role selectOneRoleByCode(Role role);
	
}
