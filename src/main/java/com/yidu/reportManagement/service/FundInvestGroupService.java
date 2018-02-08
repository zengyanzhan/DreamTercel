package com.yidu.reportManagement.service;

import java.util.HashMap;

import com.yidu.reportManagement.domain.FundInvestGroup;
/**
 * 基金投资组合表的业务逻辑层
 * @author 向燕春
 * @date 2017年12月6日
 * @time 上午2:18:08
 *
 */
public interface FundInvestGroupService {
	/**
	 * 查询基金投资组合的数据
	 * @param tableName 表名
	 * @param qualification 条件
	 * @param page 页数
	 * @param rows 行数
	 * @param rowsTotal 总行数
	 * @param orderColumn 排序的列
	 * @param orderStyle 排序的方式
	 * @return map集合
	 */
	public HashMap<String,Object> selectFundInvestGroups(
			String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle
			);
	/**
	 * 条件拼接
	 * @param fundInvestGroup 基金投资组合实体对象
	 * @return 拼接完成的条件
	 */
	public String bufferWhere(FundInvestGroup fundInvestGroup);
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
