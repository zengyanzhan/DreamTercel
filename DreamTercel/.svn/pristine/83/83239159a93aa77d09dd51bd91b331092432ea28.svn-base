package com.yidu.cashManagement.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.dayEnd.domain.CashPay;

/**
 * 资金调拨的dao类
 * @author 肖光宇
 * @date 2017年11月13日
 * @time 下午2:50:16
 *
 */
@Repository
public interface MoneyAllotDao {
	/**
	 * 查询
	 * @return 资金调拨集合
	 */
	public HashMap<String,Object> selectMoneyAllot(HashMap<String, Object> map);
	/**
	 * 增加资金调拨
	 * @param MoneyAllot 资金调拨
	 * @return 1代表增加成功 否则失败
	 */
	public int insertMoneyAllot(MoneyAllot moneyAllot);
	/**
	 * 修改资金调拨
	 * @param MoneyAllot 资金调拨
	 * @return 1代表修改成功 否则失败
	 */
	public int updateMoneyAllot(MoneyAllot moneyAllot);
	/**
	 * 删除资金调拨
	 * @param code 资金编号
	 * @return 1代表删除成功 否则失败
	 */
	public int deleteMoneyAllot(MoneyAllot moneyAllot);
	/**
	 * 通过编号查询资金调拨
	 * @param code 资金编号
	 */
	public MoneyAllot  selectMoneyAllotByCode(String code);
	
	/**
	 * 删除资金调拨
	 * @param cashPay  现金利息实体类
	 * @return  1代表成功 否则失败
	 */
	public Integer deleteAllotCode(MoneyAllot moneyAllot);
	
	
	
	
}
