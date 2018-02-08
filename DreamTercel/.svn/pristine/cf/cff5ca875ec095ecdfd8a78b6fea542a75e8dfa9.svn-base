package com.yidu.stockControl.service;

import java.util.HashMap;

import com.yidu.stockControl.domain.SecurityArapStock;

/**
 *  证券应收应付库存  service
 * @author 肖向恩
 *
 */

public interface SecurityArapStockService {
	/**
	 * 查询债劵信息数据
	 * @param tableName 表名
	 * @param qualification 条件
	 * @param page 页数
	 * @param rows 行数
	 * @param rowsTotal 总行数
	 * @param orderColumn 排序的列
	 * @param orderStyle 排序的方式
	 * @return map集合
	 */
	public HashMap<String,Object> selectSecurityArapStock(SecurityArapStock securityArapStock);
	/**
	 * 按条件删除证券应收应付库存
	 * @param securityArapStockCode	主键列  债劵id
	 * @return	受影响的行数
	 */
	public int deleteSecurityArapStockId(String securityArapStockCode);
	/**
	 * 添加证券应收应付库存
	 * @return	证券应收应付库存集合
	 */
	public int insertSecurityArapStock(SecurityArapStock securityArapStock);
	/**
	 * 通过id查询证券应收应付库存
	 * @param securityArapStockCode	证券应收应付库存id
	 * @return	证券应收应付对象
	 */
	public SecurityArapStock selectSecurityArapStockIds(String securityArapStockCode);
	
	
	/**
	 * 修改证券应收应付库存
	 * @param bond	证券应收应付对象
	 */
	public int updateSecurityArapStock(SecurityArapStock securityArapStock);
}
