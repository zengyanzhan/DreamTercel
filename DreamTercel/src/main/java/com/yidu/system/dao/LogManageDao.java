package com.yidu.system.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.system.domain.LogManage;


/**
 * 日志Dao
 * @author HeXiXian 
 * @date   2017年11月22日
 * @time   下午2:56:22
 *
 */
@Repository
public interface LogManageDao {
	/**
	 * 日志管理查询
	 * @param map
	 */
	public Map<String, Object> selectLogManage(Map<String, Object> map);
	/**
	 * 日志管理删除
	 * @param logManage  日志实体类
	 * @return
	 */
	public int deleteLogManage(LogManage logManage);
	/**
	 * 增加日志管理
	 * @param logManage 日志实体类
	 * @return
	 */
	public int insertLogManage(LogManage logManage);
	/**
	 * 修改日志
	 * @param logManage  日志实体类
	 * @return
	 */
	public int updateLogManage(LogManage logManage);
	/**
	 * 通过ID查询日志
	 * @param logManage 日志实体类
	 * @return
	 */
	public LogManage selectOneByCodeLogManage(LogManage logManage);
}
