package com.yidu.system.service;

import com.yidu.system.domain.RoleRight;

/**
 * 角色权限的业务处理层接口
 * @author ZouJianwen 
 * @data  2017年11月17日
 * @time  下午1:35:11
 *
 */
public interface RoleRightService {

	/**
	 * 增加角色权限
	 * @param roleRight 角色权限的对象
	 * @return 增加的条数
	 */
	public Integer insertRoleRight(RoleRight roleRight);
	/**
	 * 删除角色权限
	 * @param roleRight  角色权限的对象
	 * @return 删除的条数
	 */
	public Integer deleteRoleRight(RoleRight roleRight); 
}
