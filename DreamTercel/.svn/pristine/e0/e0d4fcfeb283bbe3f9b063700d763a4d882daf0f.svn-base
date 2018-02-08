package com.yidu.reportManagement.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.reportManagement.domain.DifferenceReport;

/**
 * 轧差表数据库操作类
 * @author Wang
 * @date 2017年12月12日
 * @time 上午8:57:43
 */
@Repository
public interface DifferenceReportDao {
	/**
	 * 查询轧差信息
	 * @param map 查询条件
	 * @return 轧差信息
	 */
	public  List<DifferenceReport> selectDifferenceReport(Map<String, Object> map);
	/**
	 * 查询数据总条数
	 * @param map 查询条件
	 * @return 数据总条数
	 */
	public Integer selectDifferenceReportCount(Map<String, Object> map);
}
