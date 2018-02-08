package com.yidu.businessData.service;
import java.sql.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yidu.businessData.domain.CashArap;
/**
 * 现金应收应付业务逻辑类
 * @author 邓涛
 * @date 2017年11月14日
 * @time 下午3:57:04
 */
public interface CashArapService {
	/**
	 * 增加的方法
	 * @param cashArap 现金应收应付实体类
	 * @return boolean为true则增加
	 */
	public int insertCashArap(CashArap cashArap);
	/**
	 * 删除的方法
	 * @param cashArapCode 现金应付应收编号
	 * @return 整型
	 */
	public int deleteCashArap(CashArap cashArap);
	/**
	 * 修改的方法
	 * @param cashArapCode 现金应付应收编号
	 * @return 整型
	 */
	public int updateCashArap(CashArap cashArap);
	/**
	 * 查询的方法
	 * @param cashArap 现金应收应付实体类
	 * @return HashMap集合
	 */
	public Map<String, Object>selectCashArap(CashArap cashArap);
	/**
	 * 通过编号查询
	 * @param cashArapCode 现金应收应付编号
	 * @return CashArap现金应收应付实体类
	 */
	public CashArap selectCashArapById(String cashArapCode);
	/**
	 * 通过账户编号 统计时间删除的方法
	 * @param cashAccountCode 账户编号
	 * @param businessDate 统计时间
	 * @return
	 */
	public int deleteSqlWhereCashArap(String cashAccountCode, Date businessDate,String fundCode,Integer cashArapType);
}
