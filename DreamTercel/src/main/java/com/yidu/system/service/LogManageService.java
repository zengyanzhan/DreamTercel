package com.yidu.system.service;

import java.util.List;
import java.util.Map;

import com.yidu.system.domain.LogManage;

/**
 * 日志服务类
 * @author HeXiXian
 * @date   2017年11月22日
 * @time   下午2:56:58
 *
 */
public interface LogManageService {
		/**
		 * 日志查询
		 * @param logManage 日志实体类
		 * @return 
		 */
		public Map<String, Object> selectLogManage(LogManage logManage);
		/**
		 * 删除日志
		 * @param logManage 日志实体类
		 * @return
		 */
		public Integer deleteLogManage(LogManage logManage);
		/**
		 * 增加
		 * @param logManage 日志实体类
		 * @return
		 */
		public Integer insertLogManage(LogManage logManage);
		/**
		 * 修改
		 * @param logManage 日志实体类
		 * @return
		 */
		public Integer updateLogManage(LogManage logManage);
		/**
		 * 通过ID查询数据
		 * @param logManage 日志实体类
		 * @return
		 */
		public LogManage selectOneByCodeLogManage(LogManage logManage);
}
