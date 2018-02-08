package com.yidu.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.system.dao.LogManageDao;
import com.yidu.system.domain.LogManage;
import com.yidu.system.service.LogManageService;

/**
 * 日志实现类
 * @author HeXiXian
 * @date   2017年11月22日                                                                                                                                                                                                           
 * @time   下午2:57:18
 *
 */
@Transactional
@Service
public class LogManageImpl implements LogManageService{
	@Autowired
	LogManageDao logManageDao;
	
	@Override
	public Map<String, Object> selectLogManage(LogManage logManage) {
			// TODO Auto-generated method stub
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("tableName", "daily_record");//表名
		map.put("qualification", "");//条件
		map.put("page", logManage.getPage());//当前的页
		map.put("rows", logManage.getRows());//当前页显示的行数
		map.put("orderColumn", "daily_code");//排序的列
		map.put("orderStyle", logManage.getSortOrder());//排序的方式
		System.err.println("进来了=");

		logManageDao.selectLogManage(map);
		System.err.println("进来了=23222131231231232131231");
		return  map;
	}

	@Override
	public Integer deleteLogManage(LogManage logManage) {
		// TODO Auto-generated method stub
		return logManageDao.deleteLogManage(logManage);
	}

	@Override
	public Integer insertLogManage(LogManage logManage) {
		System.err.println(logManage);
		// TODO Auto-generated method stub
		return logManageDao.insertLogManage(logManage);
	}

	@Override
	public Integer updateLogManage(LogManage logManage) {
		// TODO Auto-generated method stub
		return logManageDao.updateLogManage(logManage);
	}

	@Override
	public LogManage selectOneByCodeLogManage(LogManage logManage) {
		// TODO Auto-generated method stub
		return logManageDao.selectOneByCodeLogManage(logManage);
	}

}
                                   