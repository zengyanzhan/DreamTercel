package com.yidu.cashManagement.service;

import java.util.HashMap;

import org.springframework.transaction.annotation.Transactional;

import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.dayEnd.domain.CashPay;
/**
 * 资金调拨的服务类
 * @author 肖光宇
 * @date 2017年11月13日
 * @time 下午2:52:55
 *
 */

public interface MoneyAllotService {
	/**
	 * 查询
	 * @return 资金调拨集合
	 */
	public HashMap<String,Object> selectMoneyAllot(MoneyAllot moneyAllot);
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
	 * @param code 基金标号
	 * @return 1代表删除成功 否则失败
	 */
	public int deleteMoneyAllot(MoneyAllot moneyAllot);
	/**
	 * 通过编号查询资金调拨数据
	 * @param code 资金调拨编号
	 * @return 资金调拨集合
	 */
	public MoneyAllot selectMoneyAllotByCode(String code);
}
