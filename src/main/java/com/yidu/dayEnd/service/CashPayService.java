package com.yidu.dayEnd.service;

import java.util.List;

import com.yidu.businessData.domain.CashArap;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.dayEnd.domain.CashPay;

public interface CashPayService {
	/**
	 * 查询现金利息收入集合
	 * @param cashPay 现金利息
 	 * @return 现金利息收入集合
	 */
	public List<CashPay> selectCashPay(CashPay cashPay);
	/**
	 * 查询现金账户总条数
	 * @return 现金账户总条数
	 */
	public Integer selectnCashPayCount(CashPay cashPay);
	/**
	 * 统计现金利息收入
	 * @param cashPay
	 * @return
	 */
	public boolean tongJiXianJin(CashPay cashPay);
	/**
	 * 删除现金应收应付
	 * @param cashPay 金利息实体类
	 * @return 1代表成功 0代表失败
	 */
	public Integer deleteCashAraps(CashArap cashArap);
	
	/**
	 * 删除资金调拨
	 * @param bondPay  现金利息实体类
	 * @return 1代表成功 0代表失败
	 */
	public Integer deleteMoneys(MoneyAllot moneyAllot);
	/**
	 * 查询现金应收应付编号
	 * @return  现金应收应付编号
	 */
	public String selectCashArapCode(CashPay cashPay);
	/**
	 * 查询两费支付集合
	 * @param cashPay 现金利息实体类
	 * @return 现金利息实体类
	 */
	public List<CashPay> selectTwoMoney(CashPay cashPay);
	/**
	 * 查询两费总条数
	 * @param cashPay  现金利息实体类
	 * @return 两费记录数
	 */
	public Integer selectTwoMoneyCount(CashPay cashPay);
	/**
	 * 统计两费
	 * @param cashPay 现金利息实体类
	 * @return  true 代表统计成功  否则失败
	 */
	public boolean tongJiTwoMoney(CashPay cashPay);
	/**
	 * 查询唯一的两费编号
	 * @param cashPay
	 * @return
	 */
	public String  selectTwoMoneyCode(CashPay cashPay);
	

}
