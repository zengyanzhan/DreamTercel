package com.yidu.stockControl.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.parameters.domain.Bond;
import com.yidu.stockControl.domain.SecurityArapStock;



/**
 *  证券应收应付库存  业务处理层
 * @author 肖向恩
 *
 */
@Repository
public interface SecurityArapStockDao {
	/**
	 * 查询证券应收应付库存
	 * 
	 */
	public void selectSecurityArapStock(Map<String, Object> map);
	
	/**
	 * 删除证券应收应付库存
	 * @param bondCode	主键列 债劵id
	 */
	public int deleteSecurityArapStockId(String securityArapStockCode);
	/**
	 * 添加证券应收应付库存
	 * @return	证券应收应付库存集合
	 */
	public Integer insertSecurityArapStock(SecurityArapStock securityArapStock);
	/**
	 * 通过id查询证券应收应付库存
	 * @param bondCode	证券应收应付库存id
	 * @return	证券应收应付对象
	 */
	public SecurityArapStock selectSecurityArapStockIds(String securityArapStockCode);
	
	/**
	 *	修改证券应收应付库存
	 */
	public int updateSecurityArapStock(SecurityArapStock securityArapStock);
}
