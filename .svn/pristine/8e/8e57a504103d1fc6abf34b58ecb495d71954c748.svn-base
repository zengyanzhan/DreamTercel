package com.yidu.dayEnd.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.dayEnd.domain.DateParams;
import com.yidu.dayEnd.domain.Stock;
import com.yidu.parameters.domain.Fund;
import com.yidu.stockControl.domain.CashArapStock;
import com.yidu.stockControl.domain.CashStock;
import com.yidu.stockControl.domain.SecurityArapStock;
import com.yidu.stockControl.domain.SecurityStock;
import com.yidu.stockControl.domain.TaStock;
import com.yidu.transactionProcessing.domain.DealData;

/**
 * 库存统计dao层接口类
 * @author ZengYanZhan
 * @date 2017年11月15日
 * @time 下午4:04:44
 */
@Repository
public interface StockDao {
	/**
	 * 查询库存管理下面的所有库存
	 * @return Map 库存数据
	 */
	public Map<String, Object> selectStock(Map<String, Object> map);

	/**
	 * 通过基金代码 查询该基金的所有详细信息
	 * @param fundCode 基金代码
	 * @return Fund 基金实体类
	 */
	public Fund selectFund(String fundCode);
	
	/**
	 * 查询证券库存数据 
	 * @param dateParams 参数
	 * @return List 证券库存数据集
	 */
	public List<SecurityStock> selectSecurityStock(DateParams dateParams);

	/**
	 * 查询交易数据集
	 * @param dateParams 参数实体类
	 * @return List 交易数据
	 */
	public List<DealData> selectTradeData(DateParams dateParams);

	/**
	 * 删除昨日证券库存
	 * @param dateParams 参数包括统计日期
	 */
	public void deleteSecurityStock(DateParams dateParams);

	/**
	 * 查询现金库存昨日库存 期初数据 
	 * @param dateParams 参数
	 * @return List 现金库存数据
	 */
	public List<CashStock> selectCashStock(DateParams dateParams);

	/**
	 * 查询资金调拨流入和流出数据
	 * @param dateParams 参数
	 * @return List 资金调拨现金数据
	 */
	public List<MoneyAllot> selectMoneyAllot(DateParams dateParams);

	/**
	 * 删除现金库存数据根据统计日期
	 * @param dateParams 参数
	 * @return int 是否删除成功
	 */
	public int deleteCashStock(DateParams dateParams);

	/**
	 * 查询Ta库存数据 根据统计日期以及基金代码
	 * @param dateParams 参数
	 * @return int Ta库存数据
	 */
	public int selectTaStock(DateParams dateParams);

	/**
	 * 删除Ta库存数据 根据统计日期以及基金代码
	 * @param dateParams 参数
	 * @return int 影响行数
	 */
	public int deleteTaStock(DateParams dateParams);

	/**
	 * 统计TA昨日以及今日库存之后的集合
	 * @param dateParams 参数
	 * @return List 数据
	 */
	public List<TaStock> selectTaTradeData(DateParams dateParams);

	/**
	 * 查询现金应收应付库存昨日库存
	 * @param dateParams 参数
	 * @return int 现金应收应付库存实体类数据
	 */
	public int selectCashArapStock(DateParams dateParams);

	/**
	 * 统计现金应收应付库存数据
	 * @param dateParams 参数
	 * @return List 现金应收应付库存统计之后的数据
	 */
	public List<CashArapStock> selectCashArapStockData(DateParams dateParams);

	/**
	 * 删除现金应收应付库存昨日数据
	 * @param dateParams 参数
	 * @return int 删除影响行数
	 */
	public int deleteCashArapStock(DateParams dateParams);

	/**
	 * 查询证券应收应付库存昨日数据
	 * @param dateParams 参数
	 * @return int 证券应收应付库存数据
	 */
	public int selectSecurityArapStock(DateParams dateParams);

	/**
	 * 统计证券应收应付库存数据
	 * @param dateParams 参数
	 * @return List 统计之后的数据
	 */
	public List<SecurityArapStock> selectSecurityArapStockData(DateParams dateParams);

	/**
	 * 删除证券应收应付库存昨日库存
	 * @param dateParams 参数
	 * @return int 删除行数
	 */
	public int deleteSecurityArapStock(DateParams dateParams);

	/**
	 * 增加证券应收应付库存
	 * @param securityArapStock 参数
	 * @return int 影响的行数
	 */
	public int insertSecurityArapStock(SecurityArapStock securityArapStock);
} 

