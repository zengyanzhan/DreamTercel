package com.yidu.Android.service;

import java.util.HashMap;

import com.yidu.Android.domain.AndroidFundInvestBlockReport;

/**
 * 基金投资板块表的链接数据库的操作类
 * @author 杨丽
 * @date 2017年12月7日	
 * @time 上午11:41:39
 *
 *
 */
public interface AndroidFundInvestBlockReportService {
	/**
	 * 查询基金投资板块的数据
	 * @param tableName 表名
	 * @param qualification 条件
	 * @param page 页数
	 * @param rows 行数
	 * @param rowsTotal 总行数
	 * @param orderColumn 排序的列
	 * @param orderStyle 排序的方式
	 * @return map集合
	 */
	public HashMap<String,Object> selectFundInvestGroups(
			String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle
			);
	/**
	 * 
	 * @param fundInvestBlockReport 基金投资板块
	 * @return
	 */
	public String bufferWhere(AndroidFundInvestBlockReport fundInvestBlockReport);
}
