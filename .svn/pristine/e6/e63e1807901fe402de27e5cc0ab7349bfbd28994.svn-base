package com.yidu.dayEnd.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yidu.businessData.domain.SecurityArap;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.dayEnd.domain.BondPay;
/**
 * 债券支付持久层
 * @author 肖光宇
 * @date 2017年12月22日
 * @time 上午8:44:10
 *
 */
@Repository
public interface BondPayDao {
	/**
	 * 查询债券支付
	 * @param bondPay 债券支付实体类
	 * @return 债券集合
	 */
	public List<BondPay> selectBondPay(HashMap<String, Object> map);
	/**
	 * 查询债券记录数
	 * @return 债券记录数
	 */
	public Integer selectBondPayCount(BondPay bondPay);
	/**
	 * 统计
	 * @param bondPay 债券实体类
	 */
	public void tongJiZhaiQuan(BondPay bondPay);
	
	/**
	 * 查询证券应收应付编号
	 * @param bondPay
	 * @return
	 */
	public String selectSecurityarapCode(BondPay bondPay);
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
