package com.yidu.transactionProcessing.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.transactionProcessing.domain.DealData;
import com.yidu.transactionProcessing.domain.Interests;

/**
 * 交易数据数据库操作类
 * @author Wang
 * @date 2017年11月18日
 * @time 上午10:29:24
 */
@Repository
public interface DealDataDao {
	/**
	 * 查询交易数据
	 * @param map 条件查询、分页map
	 * @return 交易数据和总条数map
	 */
	public Map<String,Object> selectDealData(Map<String, Object> map);
	/**
	 * 添加交易数据
	 * @param dealData 交易数据实体对象
	 * @return 受影响行数
	 */
	public int insertDealData(DealData dealData);
	/**
	 * 修改交易数据
	 * @param dealData 交易数据实体对象
	 * @return 受影响行数
	 */
	public int updateDealData(DealData dealData);
	/**
	 * 删除交易数据
	 * @param dealData 交易数据实体对象
	 * @return 受影响行数
	 */
	public int deleteDealData(DealData dealData);
	/**
	 * 通过交易数据编号查询交易数据
	 * @param dealDataCode 交易数据编号
	 * @return 交易数据实体集合
	 */
	public List<DealData> selectDealDataById(String dealDataCode);
	/**
	 * 查询交易结算的数据信息
	 * @param 查询条件
	 * @return 未结算的数据信息
	 */
	public Map<String, Object>selectTradeSettle(Map<String, Object> map);
	/**
	 * 修改状态
	 * @param map 状态
	 * @return 是否修改成功
	 */ 
	public int updateDealStatus(Map<String, Object> map);
	
	/**
	 * 获得交易单子号
	 * @param dealData 交易数据实体对象
	 * @return 交易数据实体集合
	 */
	public List<DealData> selectDealDataCode(Map<String, Object> map);
	
}
