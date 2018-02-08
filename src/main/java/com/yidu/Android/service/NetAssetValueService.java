package com.yidu.Android.service;

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
 * @time 上午9:52:45
 */

public interface NetAssetValueService {
	/**
	 * 查询所有基金
	 * @return 基金集合
	 */
	public List<Fund> selectAllFund();
	/**
	 * 查询资产净值大小集合
	 * @param fundCode  基金代码
	 * @return 资产净值集合
	 */
public List<NetValue>selectNetAssetValue(String fundCode );
/**
 * 查询单位净值大小
 * @param fundCode 基金代码
 * @return 单位净值集合
 */
public List<NetValue>selectUnitNet(String fundCode );
/**
 * 券商成交量统计表
 * @param fundCode
 * @return 券商成交量集合
 */
public List selectStockTrading( );	
/**
 * 一段时间内的券商成交量统计表
 * @param Map map集合 2个时间
 * @return 券商成交量集合
 */
public List selectStockTradingByDate(Map hashMap );	
/**
 * 席位成交量统计表
 * @param fundCode
 * @return 席位成交量集合
 */
public List selectVolumeStatistics( );	
/**一段时间内的
 * 席位成交量统计表
 * @param hashMap map集合 2个时间
 * @return 席位成交量集合
 */
public List selectVolumeStatisticsByDate(Map hashMap);	
/**
 * 查询所有的股票
 * @return 股票集合
 */
public List<Security> selectStockAll( );	
/**
 * 查询行情数据
 * @param id 股票ID
 * @return 行情数据集合
 */
public List<PriceData> selectHangQingChaAll(String id);
/**
 * 通过证券名字差证券ID
 * @param name 证券名字
 * @return 证券集合
 */
public List<Security> selectSecurityCode(String name);
/**
 * 查询所有证券市值
 * @param date
 * @return 净值统计集合
 */
public List<NetValue> selectNetValueChaAlls();
/**查询所有消息
 * @return 消息集合
 */

public List<Message> selectAllMessage();
/**
 * 证券市值变动表
 * @return 证券市值集合
 */
public List<SecurityMarket> selectSecurityMarket();
/**
 * 查询所有证券库存
 * @return 证券库存集合
 */
public List<SecurityStock> selectAllSecurity();
/**
 * 通过代码查证券库存
 * @param code 基金代码
 * @return	证券库存集合
 */
public List<SecurityStock> selectAllSecurityByCode( String code);
/**
 * 查询行情数据
 * @param id  代码
 * @param date 时间
 * @return	行情数据集合
 */
public List<PriceData> selectHangQingChaByDateAndId(String id,String date);
/**
 * 查询所有证券
 * @param date 日期
 * @return 证券库存集合
 */
public List<SecurityStock> selectSecurityMarketByDate(String code, String openDate,String endDate);
/**
 * 查询一段时间内的行行情
 * @param date 日期
 * @return 行情数据集合
 */
public List<PriceData> selectHangQingByDate(String code, String openDate,String endDate);
/**
 * 通过一段日期查询净值
 * @param date
 * @return	净值统计集合
 */
public List<NetValue> selectNetValueChaAllsByDate(String openDate ,String endDate);
/**
 * 通过基金ID查名字
 * @param date
 * @return 基金集合
 */
public List<Fund> selectFundNameByCode(String code);
/**
 * 查询一段时间所有证券
 * @param date 日期
 * @return 证券库存集合
 */
public List<SecurityStock> 	selectAllSecurityByDate( String openDate ,String endDate);
/**
 * 查询用户
 * @return  返回用户集合
 */
public List<User> selectUserByNameAndPwd(String name,String pwd);

}
