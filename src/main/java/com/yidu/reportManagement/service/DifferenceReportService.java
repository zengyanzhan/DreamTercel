package com.yidu.reportManagement.service;

import java.util.Map;

import com.yidu.reportManagement.domain.DifferenceReport;

/**
 * 轧差表业务处理层
 * @author Wang
 * @date 2017年12月12日
 * @time 上午9:03:21
 */
public interface DifferenceReportService {
	/**
	 * 查询轧差表的信息
	 * @param differenceReport 
	 * @return
	 */
	public Map<String, Object> selectDifferenceReport(DifferenceReport differenceReport,String fundCode);
	
}
