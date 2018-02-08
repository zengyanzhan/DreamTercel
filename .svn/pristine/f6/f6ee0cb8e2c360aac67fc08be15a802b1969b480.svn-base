package com.yidu.stockControl.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.stockControl.domain.CashArapStock;

/**
 * 现金应收应付库存链接数据库的操作类
 * @author 向燕春
 * @date 2017年11月14日
 * @time 上午10:03:05
 *
 */
@Repository
public interface CashArapStockDao {
	/**
	 * 查询所有的现金应收应付库存的数据
	 * @return 现金应收应付库存的所有数据集合
	 */
	public void selectCashArapStocks(Map<String, Object> map);
	/**
	 * 条件拼接
	 * @param cashArapStock 现金应收应付库存对象
	 * @return 拼接好的条件
	 */
	public String bufferWhere(CashArapStock cashArapStock);
	/**
	 * 根据id删除
	 * @param cashArapStockCodes 现金应收应付库存编号
	 * @return 删除的条数
	 */
	public int deleteCashArapStock(String cashArapStockCodes);
	/**
	 * 增加现金应收应付库存
	 * @param cashArapStock 现金应收应付库存对象
	 * @return 增加的条数
	 */
	public int insertCashArapStock(CashArapStock cashArapStock);
	/**
	 * 修改现金应收应付库存
	 * @param cashArapStock 现金应收应付库存对象
	 * @return 修改的条数
	 */
	public int updateCashArapStock(CashArapStock cashArapStock);
	/**
	 * 根据id查询
	 * @param cashArapStockCode 现金应收应付库存编号
	 * @return 现金应收应付库存实体对象
	 */
	public CashArapStock selectCashArapStockById(String cashArapStockCode);
	
}
