package com.yidu.stockControl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yidu.stockControl.domain.CashStock;
import com.yidu.system.domain.Role;

/**
 * 
 * @author ChenJiaLong
 * @date 2017年11月15日
 * @time 上午10:09:21
 *
 */
public interface CashStockService {
   
	/**
	 * 增加一条现金库存数据
	 * @param cashStockdomain 现金库存的实体类 
	 * @return int i 
	 */
	public int insertCashStock(CashStock cashStockdomain);
	/**
	 * 删除一条现金库存数据
	 * @param cashStockdomain 权益数据的id
	 * @return int i 
	 */
	public int deleteCashStock(String CashStockCode);
	/**
	 * 查询现金库存数据
	 * @return List 返回一个集合
	 */
	public Map<String,Object> selectCashStock(CashStock cashStockdomain);
	/**
	 * 修改现金库存数据
	 * @param cashStockdomain 
	 * @return 返回 int i 
	 */
	public int updateCashStock(CashStock cashStockdomain );
	
	/**
	 * 通过编号查询一条数据
	 * @param role
	 * @return
	 */
	public CashStock selectOneByCode(String CashStockCode);
}
