package com.yidu.taManagement.service;

import java.util.HashMap;
import com.yidu.taManagement.domain.TaTradeSettle;

public interface TaTradeSettleService {
	/**
	 * 查询所有ta交易数据
	 * @param tableName 表名
	 * @param page 页数
	 * @param rows 行数
	 * @param rowsTotal 总行数
	 * @param orderColumn 排序的列
	 * @param orderStyle 排序的方式
	 * @return map集合
	 */
	public HashMap<String,Object> selectTaTradData(
			String tableName,
			String qualification,
			Integer page,
			Integer rows,
			String orderColumn, 
			String orderStyle
			);
	/**
	 * 条件拼接
	 * @param taTradData ta交易数据实体对象
	 * @return 拼接好的条件
	 */
	public String bufferWhere(TaTradeSettle taTradeSettle);

}
