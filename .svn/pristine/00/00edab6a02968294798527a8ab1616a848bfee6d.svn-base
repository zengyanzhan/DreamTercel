package com.yidu.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.system.dao.RoleRightDao;
import com.yidu.system.domain.RoleRight;
import com.yidu.system.service.RoleRightService;
/**
 * 角色权限的业务处理接口实现类
 * @author ZouJianwen
 * @data  2017年11月17日
 * @time  下午1:38:27
 *
 */
@Transactional
@Service
public class RoleRightServiceImpl implements RoleRightService {
	@Autowired
	RoleRightDao roleRightDao;
	@Override
	public Integer insertRoleRight(RoleRight roleRight) {
		// TODO Auto-generated method stub
		return roleRightDao.insertRoleRight(roleRight);
	}

	@Override
	public Integer deleteRoleRight(RoleRight roleRight) {
		// TODO Auto-generated method stub
		return roleRightDao.deleteRoleRight(roleRight);
	}

}
