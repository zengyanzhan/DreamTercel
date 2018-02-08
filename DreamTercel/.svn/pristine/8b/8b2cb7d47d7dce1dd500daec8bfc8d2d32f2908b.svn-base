package com.yidu.system.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.system.domain.Role;
/**
 * 角色类的Dao
 * @author HeXiXian
 * @date   2017年11月14日
 * @time   上午9:53:35
 *
 */
@Repository
public interface RoleDao {
	/**
	 * 查询角色数据的方法
	 * @param map 
	 */ 
	public void selectRole(Map<String, Object> map);
	/**
	 * 增加角色数据的方法
	 * @param role 角色实体类
	 * @return int 增加返回的影响行数
	 */
	public int insertRole(Role role);
	/**
	 * 修改角色数据的方法
	 * @param role 角色实体类
	 * @return int 修改返回的影响行数
	 */
	public int updateRole(Role role);
	/**
	 * 删除角色数据的方法
	 * @param map
	 * @return int 删除返回影响的行数
	 */
	public int deleteRole(Role role);
	/**
	 * 通过编号查询数据
	 * @param role 包含编号的实体类
	 * @return 返回查询ID列的数据
	 */
	public Role selectOneRoleByCode(Role role);
}
