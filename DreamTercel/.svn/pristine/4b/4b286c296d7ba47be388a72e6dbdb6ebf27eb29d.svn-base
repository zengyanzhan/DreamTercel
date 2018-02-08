package com.yidu.parameters.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.parameters.domain.ExchangeRate;

/**
 * 交易品种费率数据库操作类
 * @author Wang
 * @date 2017年11月13日
 * @time 下午7:14:46
 */
@Repository
public interface ExchangeRateDao {
	/**
	 * 查询交易品种费率
	 * @param map 分页查询参数map
	 * @return 交易品种费率信息集合和总条数的map结合
	 */
	public void selectExchangeRate(Map<String, Object> map);
	/**
	 * 增加交易品种费率
	 * @param exchangeRate 交易品种费率实体
	 * @return 受影响行数
	 */
	public int insertExchangeRate(ExchangeRate exchangeRate);
	/**
	 * 修改交易品种费率
	 * @param exchangeRate 交易品种费率实体
	 * @return 受影响行数
	 */
	public int updateExchangeRate(ExchangeRate exchangeRate);
	/**
	 * 删除交易品种费率
	 * @param exchangeCode 交易品种费率编号
	 * @return 受影响行数
	 */
	public int deleteExchangeRate(ExchangeRate exchangeRate);
	/**
	 * 根据ID查询交易品种费率信息
	 * @param exchangeCode 交易品种费率编号
	 * @return 交易品种费率信息实体对象
	 */
	public List<ExchangeRate> selectExchangeRateById(String exchangeCode);
	/**
	 * 根据交易所名称和费率类型查询
	 * @param exchangeRate 交易品种费率信息实体对象
	 * @return 交易品种费率信息实体对象
	 */
	public List<ExchangeRate> selectExchangeRateByExchangeNameAndSecurityType(ExchangeRate exchangeRate);
	/**
	 * 查询交易所名称下拉列表
	 * @return 交易品种费率信息实体对象
	 */
	public List<ExchangeRate> selectExchangeNameSel(ExchangeRate exchangeRate);
}
