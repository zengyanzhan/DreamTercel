package com.yidu.taManagement.dao;

import java.util.Map;
import com.yidu.taManagement.domain.TaTradeSettle;

public interface TaTradeSettleDao {
	/**
	 * 查询
	 * @param map 封装所有条件
	 */                
	public void selectTaTradeSettle(Map<String, Object> map);
	/**
	 * 条件拼接
	 * @param taStock ta库存对象
	 * @return 封装好的条件
	 */
	public String bufferWhere( TaTradeSettle  taTradeSettle);
}
