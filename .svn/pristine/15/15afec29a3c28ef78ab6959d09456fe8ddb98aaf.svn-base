package com.yidu.parameters.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.parameters.dao.ManagerDao;
import com.yidu.parameters.domain.Manager;
import com.yidu.parameters.service.ManagerService;

/**
* @author YiWenQi 
* @version 创建时间：2017年11月20日 上午11:08:40
* 管理人的实现类
*/
@Transactional
@Service
public class ManagerServiceImpl implements ManagerService{
	@Autowired
	ManagerDao managerDao;
	@Override
	public Map<String, Object> selectManagerRow(Manager manager) {
		//得到manager的名字
		String managerName=manager.getManagerName();
		//创建字符串的包装类
		StringBuffer strWhere = new StringBuffer("");
		//判断管理人的ID是否空
		if(manager.getManagerCode()!=null && !manager.getManagerCode().equals("")){
			
			strWhere.append(" and manager_code like '%"+manager.getManagerCode()+"%'");
		}
		//判断的管理人的姓名是否为空
		if(manager.getManagerName()!=null && !manager.getManagerName().equals("")){
			try {
				managerName=new String(managerName.getBytes("iso8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			strWhere.append(" and manager_name like '%"+managerName+"%'");
		}
		System.err.println(strWhere);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tableName", "manager");
		map.put("qualification",strWhere.toString());
		map.put("page",manager.getPage());
		map.put("rows",manager.getRows());
		map.put("orderColumn", "manager_code");
		map.put("orderStyle", manager.getSortOrder());
		managerDao.selectManagerRow(map);
		return map;
	}

	@Override
	public Integer insertManager(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.insertManager(manager);
	}

	@Override
	public Integer updateManager(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.updateManager(manager);
	}

	@Override
	public Integer deleteManager(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.deleteManager(manager);
	}

	@Override
	public Manager selectManagerByCode(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.selectManagerByCode(manager);
	}

}
