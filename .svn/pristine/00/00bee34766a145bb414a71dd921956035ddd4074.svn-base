package com.yidu.stockControl.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.stockControl.domain.TaStock;

/**
 * TA库存链接数据库的操作类
 * @author  ZhouMuJiao
 * @date2017年11月14日
 * @time下午6:27:40
 */
@Repository
public interface TaStockDao {
	/**
	 * 查询
	 * @param map 封装所有条件
	 */
	public void selectTaStocks(Map<String, Object> map);
	/**
	 * 条件拼接
	 * @param taStock ta库存对象
	 * @return 封装好的条件
	 */
	public String bufferWhere(TaStock taStock);
	/**
	 * 删除
	 * @param taStockCode Ta库存ID
	 */
	public int deleteTaStockByTaStockId(String taStockCode);
	/**
	 * 修改
	 * @param taStock
	 * @return
	 */
	public int updateTaStock(TaStock taStock);
	/**
	 * 根据Id查询
	 * @param taStockCode
	 * @return
	 */
	public TaStock selectTaStockById(String taStockCode);
	/**
	 * 增加
	 * @param taStock 的
	 * @return 受影响的行数
	 */
	public int insertTaStock(TaStock taStock);
}
