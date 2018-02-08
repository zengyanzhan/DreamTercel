package com.yidu.dayEnd.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yidu.businessData.domain.PriceData;
import com.yidu.dayEnd.domain.NetValue;
import com.yidu.parameters.domain.CashAccount;
import com.yidu.parameters.domain.Fund;
import com.yidu.stockControl.domain.CashArapStock;
import com.yidu.stockControl.domain.SecurityArapStock;
import com.yidu.stockControl.domain.SecurityStock;
import com.yidu.system.domain.HoildayXiao;
import com.yidu.system.domain.Holiday;
import com.yidu.transactionProcessing.domain.DealData;

/**
 * 资产估值Dao
 * @author Lee
 * @date 2017年11月13日
 * @time 上午10:30:29
 */
public interface AssetValuationDao {
	/**
	 * 证券估值增值
	 * @param guZhiDate  估值的日期
	 * @param fundId 基金代码
	 * @return
	 */
	public String appraisement(String guZhiDate,String fundId);
	/**
	 * 清算款
	 * @param guZhiDate 估值日期
	 * @param fundId 基金代码
	 * @return
	 */
	public String  clearingModel(String guZhiDate,String fundId);
	/**
	 * 删除证券应收应付库存的数据  
	 * @param hashmap  哈希集合  有基金编号 当天日期  
	 */
	public  void deleteSecurityStockByFunCode(Map hashmap);
	/**
	 * 删除证券应收应付库存的数据  
	 * @param hashmap  哈希集合  有基金编号 当天日期  
	 */
	public  void deleteSecurityStockByFunCodeqingsuan(Map hashmap);
	
	/**
	 * 删除证券应收应付的数据  
	 * @param hashmap  哈希集合  有基金编号 当天日期  
	 */
	public int deleteSecurityArapData(Map hashmap);
	/**
	 * 查询证券应收应付库存的数据
	 * @param hashmap哈希集合  有基金编号 当天日期   证券代码  账号
	 * @return
	 */
	public List<SecurityStock> selectSecurityArapStockYSYFKuCun(Map hashmap);
	/**
	 * 查询当天是否为节假日
	 * @param guZhiDate
	 * @return
	 */
	public List<HoildayXiao> selectHolidayList(String guZhiDate);
	/**
	 * 查询当天是否为节假日
	 * @param guZhiDate
	 * @return
	 */
	public List<HoildayXiao> selectHolidayList(Date guZhiDate);
	/**
	 * 查询行情数据
	 * @param hashmap
	 * @return
	 */
	public List<PriceData> selectHangQingCha(Map hashmap);
	 
	/**
	 * 删除证券应收应付
	 * @param hashmap
	 * @return
	 */
	public  int deleteSecurityArapYSYF(Map hashmap);
	/**
	 * 删除现金应收应付
	 * @param hashmap
	 * @return
	 */
	public  int deleteCashArapXanJin(Map hashmap);
	/**
	 * 根据ta统计日期进行查询申购、赎回数据
	 * @param hashmap
	 * @return
	 */
	public List selectTaTradeDataRiQi(Map hashmap);
	/**
	 * 根据现金账户卡号查询得到账号ID
	 * @param cashAccountId
	 * @return
	 */
	public List<CashAccount> selectCashAccountID(String  cashAccountId);
	/**
	 * 查询证券库存的数据
	 * @param hashmap哈希集合  有基金编号 当天日期   证券代码  账号
	 * @return
	 */
	public List<SecurityStock> selectSecurityStockKuCun(Map hashmap);
	
	/**
	 * 插入现金应收应付库存表
	 * @param 现金应收应付库存表实体类
	 * @return
	 */
	public void insertCashArapStock(CashArapStock cashArapStock);
	/**
	 * 插入证券应收应付库存表
	 * @param 现金应收应付库存表实体类
	 * @return
	 */
	public void insertSecurityArapStock(SecurityArapStock securityArapStock);
	/**
	 * 查询交易数据
	 * @param hashmap
	 * @return
	 */
	public List<DealData> selectDealData(Map hashmap);
	
	public List<NetValue> selectNetValueChaAll(String hashmap);
}
