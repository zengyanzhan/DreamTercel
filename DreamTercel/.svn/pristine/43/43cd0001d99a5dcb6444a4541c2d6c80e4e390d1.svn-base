package com.yidu.dayEnd.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yidu.businessData.domain.CashArap;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.dayEnd.domain.BondPay;
import com.yidu.dayEnd.domain.CashPay;
/**
 * 现金支付和两费接口
 * @author 肖光宇
 * @date 2017年11月22日
 * @time 上午11:41:08
 *
 */
@Repository
public interface CashPayDao {
	/**
	 * 查询现金利息收入集合
	 * @param map  
	 * @return 现金利息收入集合
	 */
	public List<CashPay> selectCashPay(HashMap<String,Object > map);
	/**
	 * 查询现金账户总条数
	 * @return 现金账户总条数
	 */
	public Integer selectnCashPayCount(CashPay cashPay);
	
	/**
	 * 删除资金调拨
	 * @param cashPay  现金利息实体类
	 * @return  1代表成功 否则失败
	 */
	public Integer deleteMoneys(MoneyAllot moneyAllot);
	/**
	 * 查询现金应收应付编号
	 * @return  现金应收应付编号
	 */
	public String selectCashArapCode(CashPay cashPay);
	/**
	 * 删除现金应收应付
	 * @param cashPay  cashPay  现金利息实体类
	 * @return 1代表成功 否则失败
	 */
	public Integer deleteCashAraps(CashArap cashArap);
	/**
	 * 查询两费支付集合
	 * @param cashPay 现金利息实体类
	 * @return 现金利息实体类
	 */
	public List<CashPay> selectTwoMoney(HashMap<String,Object > map);
	/**
	 * 查询两费总条数
	 * @param cashPay  现金利息实体类
	 * @return 两费记录数
	 */
	public Integer selectTwoMoneyCount(CashPay cashPay);
	/**
	 * 查询唯一的两费编号
	 * @param cashPay
	 * @return
	 */
	public String  selectTwoMoneyCode(CashPay cashPay);

}
