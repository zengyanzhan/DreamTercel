package com.yidu.dayEnd.service;

import java.util.List;
import java.util.Map;

import com.yidu.dayEnd.domain.Stock;

/**
 * 库存统计业务逻辑处理接口类
 * @author ZengYanZhan
 * @date 2017年11月15日
 * @time 下午4:05:59
 */
public interface StockService {
	/**
	 * 查询库存管理下面的所有库存
	 * @return Map 库存数据
	 */
	public  Map<String, Object> selectStock(Stock stock);
	
	/**
	 * 证券库存统计
	 * @param stock 实体类参数
	 * @return List 统计库存之后返回的数据
	 */
	public Stock securityStockStatistics(Stock stock) throws Exception;
	/**
	 * 现金库存统计
	 * @param stock 实体类参数
	 * @return List 统计库存之后返回的数据
	 */
	public Stock cashStockStatistics(Stock stock) throws Exception;
	/**
	 * 证券应收应付库存统计
	 * @param stock 实体类参数
	 * @return List 统计库存之后返回的数据
	 */
	public Stock securityArapStockStatistics(Stock stock) throws Exception;
	/**
	 * 现金应收应付库存统计
	 * @param stock 实体类参数
	 * @return List 统计库存之后返回的数据
	 */
	public Stock cashArapStockStatistics(Stock stock) throws Exception;
	/**
	 * TA库存统计
	 * @param stock 实体类参数
	 * @return List 统计库存之后返回的数据
	 */
	public Stock taStockStatistics(Stock stock) throws Exception;
}
