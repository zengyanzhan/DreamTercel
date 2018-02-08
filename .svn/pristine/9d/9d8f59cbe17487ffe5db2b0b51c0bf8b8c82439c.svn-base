package com.yidu.reportManagement.service;

import java.util.Map;

import com.yidu.reportManagement.domain.StockeQuity;

/**
 * 股票处理service
 * @author XiaoYuJie
 * @date 2017年12月6日
 * @time 下午7:48:12
 */
public interface StockeQuityService {
	/**
	 * 查询股票处理数据
	 * @return Map 返回一个map
	 */
	public Map<String, Object> selectStockeQuity(String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle);
	/**
	 * 查询条件
	 * @param stockeQuity
	 * @return
	 */
	public String buffwhere(StockeQuity stockeQuity);
	
}
