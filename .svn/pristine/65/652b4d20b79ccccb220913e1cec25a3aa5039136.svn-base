package com.yidu.reportManagement.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;
/**
 * 基金投资组合表的链接数据库的操作类
 * @author 向燕春
 * @date 2017年12月6日
 * @time 上午2:18:08
 *
 */

import com.yidu.reportManagement.domain.FundInvestGroup;
@Repository
public interface FundInvestGroupReportDao {
	/**
	 * 查询基金投资组合的数据
	 * @param map 集合
	 */
	public void selectFundInvestGroups(Map<String, Object> map);
	/**
	 * 查询净值统计表的数据，资产净值、资产合计、负债
	 * @param fundInvestGroup 基金投资组合表报对象
	 * @return 基金投资组合表报的实体类
	 */
	public FundInvestGroup selectNetValue(FundInvestGroup fundInvestGroup);
	/**
	 * 查询证券库存的总金额
	 * @param fundInvestGroup 基金投资组合表报对象
	 * @return 基金投资组合表报的实体类
	 */
	public FundInvestGroup selectSecurity(FundInvestGroup fundInvestGroup);
}
