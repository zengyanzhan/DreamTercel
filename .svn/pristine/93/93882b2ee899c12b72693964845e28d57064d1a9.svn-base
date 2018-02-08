package com.yidu.dayEnd.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.yidu.businessData.domain.SecurityArap;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.dayEnd.domain.BondPay;

public interface BondPayService {
	/**
	 * 查询债券支付
	 * @param bondPay 债券支付实体类
	 * @return 债券集合
	 */
	public List<BondPay> selectBondPay(BondPay bondPay);
	/**
	 * 查询债券记录数
	 * @return 债券记录数
	 */
	public Integer selectBondPayCount(BondPay bondPay);
	/**
	 * 统计债券
	 * @param bondPay
	 * @return
	 */
	public boolean tongJiZhaiQuan(BondPay bondPay);
	
	
	/**
	 * 查询证券编号
	 * @return 证券编号
	 */
	public String securityarapCode(BondPay bondPay);
	/**
	 * 删除证券应收应付
	 * @param bondPay 债券实体类
	 * @return 1代表成功 否则失败
	 */
	public Integer deleteSecurityaraps(SecurityArap securityArap);
	/**
	 * 删除资金调拨
	 * @param bondPay  债券实体类
	 * @return
	 */
	public Integer deleteMoneys(MoneyAllot moneyAllot);
}
