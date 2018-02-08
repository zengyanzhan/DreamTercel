package com.yidu.Android.dao;

import java.util.List;
import java.util.Map;

import com.yidu.Android.domain.Message;
import com.yidu.Android.domain.NetValueEntity;
import com.yidu.Android.domain.SecurityMarket;
import com.yidu.businessData.domain.PriceData;
import com.yidu.dayEnd.domain.NetValue;
import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.domain.Security;
import com.yidu.stockControl.domain.SecurityStock;
import com.yidu.system.domain.User;

/**
 * 
 * @author Lee
 * @date 2017年12月5日
 * @time 上午9:52:06
 * 安卓单位净值报表Dao
 * 
 */

public interface NetAssetValueDao {
	/**
	 * 
	 * @param fundCode
	 * @return
	 */
	public List<NetValue>selectNetAssetValue(String fundCode );
	/**
	 * 
	 * @param fundCode
	 * @return
	 */
	public List<NetValue>selectUnitNet(String fundCode );
	/**
	 * 券商成交量统计表
	 * @param fundCode
	 * @return
	 */
	public List selectStockTrading();	
	/**
	 * 券商成交量统计表
	 * @param fundCode
	 * @return
	 */
	public List selectStockTradingByDate(Map hashMap);
	/**
	 * 席位成交量统计表
	 * @param fundCode
	 * @return
	 */
	public List selectVolumeStatistics();
	/**
	 * 席位成交量统计表
	 * @param fundCode
	 * @return
	 */
	public List selectVolumeStatisticsByDate(Map hashMap);	
	/**
	 * 查询所有证券
	 * @return
	 */
	public List<Security>  selectStockAll();	
	/**
	 * 查询行情数据
	 * @param hashmap
	 * @return
	 */
	public List<PriceData> selectHangQingChaAll(String id);
	/**
	 * 查询证券ID
	 * @param name
	 * @return
	 */
	public List<Security> selectSecurityCode(String name);
	/**
	 * 查询净值通过编号
	 * @param date
	 * @return
	 */
	public List<NetValue> selectNetValueChaAlls();
	/**
	 * 查询所有消息
	 * @return
	 */

	public List<Message> selectAllMessage();
	/**
	 * 证券市值变动表
	 * @param date 日期
	 * @return
	 */
	public List<SecurityMarket> selectSecurityMarket();
	/**
	 * 查询所有证券
	 * @param date 日期
	 * @return
	 */
	public List<SecurityStock> selectAllSecurity();
	
	/**
	 * 查询所有证券
	 * @param date 日期
	 * @return
	 */
	public List<SecurityStock> selectAllSecurityByCode( String code);
	/**
	 * 查询行情数据
	 * @param hashmap
	 * @return
	 */
	public List<PriceData> selectHangQingChaByDateAndId(String id,String date);
	/**
	 * 查询所有证券
	 * @param date 日期
	 * @return
	 */
	public List<SecurityStock> selectSecurityMarketByDate(String code, String openDate,String endDate);
	/**
	 * 查询一段时间内的行行情
	 * @param date 日期
	 * @return
	 */
	public List<PriceData> selectHangQingByDate(String code, String openDate,String endDate);
	/**
	 * 通过一段日期查询净值
	 * @param date
	 * @return
	 */
	public List<NetValue> selectNetValueChaAllsByDate(String openDate ,String endDate);
	/**
	 * 通过基金ID查名字
	 * @param date
	 * @return
	 */
	public List<Fund> selectFundNameByCode(String code);
	/**
	 * 查询一段时间所有证券
	 * @param date 日期
	 * @return
	 */
	public List<SecurityStock> 	selectAllSecurityByDate( String openDate ,String endDate);
	/**
	 * 查询所有基金
	 * @return 基金集合
	 */
	public List<Fund> selectAllFund();
	/**
	 * 查询用户
	 * @return  返回用户集合
	 */
	public List<User> selectUserByNameAndPwd(String name,String pwd);
}
