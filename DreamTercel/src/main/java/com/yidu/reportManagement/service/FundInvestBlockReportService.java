package com.yidu.reportManagement.service;


import java.util.List;

import com.yidu.reportManagement.domain.FundInvestBlockReport;


/**
 * 基金投资板块表的链接数据库的操作类
 * @author 杨丽
 * @date 2017年12月7日	
 * @time 上午11:41:39
 *
 *
 */
public interface FundInvestBlockReportService {
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
	public List<FundInvestBlockReport> selectFundInvestGroups(
		
			FundInvestBlockReport fundInvestBlockReport
			);
	/**
	 * 
	 * @param fundInvestBlockReport 基金投资板块
	 * @return
	 */
	public String bufferWhere(FundInvestBlockReport fundInvestBlockReport);
}
