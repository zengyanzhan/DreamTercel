package com.yidu.stockControl.service;

import java.util.HashMap;
import com.yidu.stockControl.domain.CashArapStock;

/**
 * 现金应收应付库存业务逻辑层的处理类
 * @author 向燕春
 * @date 2017年11月14日
 * @time 上午10:03:05
 *
 */
public interface CashArapStockService {
	/**
	 * 查询所有的现金应收应付库存的数据
	 * @param tableName 表名
	 * @param qualification 条件
	 * @param page 页数
	 * @param rows 行数
	 * @param rowsTotal 总行数
	 * @param orderColumn 排序的列
	 * @param orderStyle 排序的方式
	 * @return map集合
	 */
	public HashMap<String,Object> selectCashArapStocks(
			String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle
			);
	/**
	 * 条件拼接
	 * @param cashArapStock 现金应收应付对象
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
