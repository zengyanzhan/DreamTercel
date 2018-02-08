package com.yidu.stockControl.service;

import java.util.HashMap;
import com.yidu.stockControl.domain.TaStock;

/**
 * TA库存的业务逻辑层
 * @author  ZhouMuJiao
 * @date2017年11月14日
 * @time下午6:30:43
 */
public interface TaStockService {
	/**
	 * 查询所有ta库存数据
	 * @param tableName 表名
	 * @param qualification 条件
	 * @param page 页数
	 * @param rows 行数
	 * @param rowsTotal 总行数
	 * @param orderColumn 排序的列
	 * @param orderStyle 排序的方式
	 * @return map集合
	 */
	public HashMap<String,Object> selectTaStocks(
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
	 * @param taStock ta库存实体对象
	 * @return 拼接好的条件
	 */
	public String bufferWhere(TaStock taStock);
	/**
	 * 按条件删除
	 * @param taStockCode TA库存ID
	 * @return 受影响的行数
	 */
	public int deleteTaStockByTaStockId(String taStockCode);
	/**
	 * 修改
	 * @param taStock
	 * @return
	 */
	public int updateTaStock(TaStock taStock);
	/**
	 * 根据ID查询
	 * @param taStockCode
	 * @return
	 */
	public TaStock selectTaStockById(String taStockCode);
	/**
	 * 增加
	 * @param taStock
	 * @return
	 */
	public int insertTaStock(TaStock taStock);

}
