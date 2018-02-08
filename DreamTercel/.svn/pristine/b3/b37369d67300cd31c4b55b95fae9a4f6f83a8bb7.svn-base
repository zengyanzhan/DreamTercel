package com.yidu.stockControl.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yidu.parameters.domain.Security;
import com.yidu.stockControl.domain.SecurityStock;

/**
 * 证券库存业务逻辑处理层接口类
 * @author ZengYanZhan
 * @date 2017年11月13日
 * @time 上午10:30:11
 */

public interface SecurityStockService {
	/**
	 * 查询证券库存数据的方法
	 * @return Map 分页之后的证券库存数据
	 * @throws Exception 
	 */
	public Map<String,Object> selectSecurityStock(SecurityStock securityStock) throws Exception;
	
	/**
	 * 删除证券库存数据方法
	 * @param code 证券库存编号
	 * @return int 返回的影响行数
	 */
	public int deleteSecurityStock(String code);
	
	/**
	 * 增加证券库存数据的方法
	 * @param securityStock 证券库存实体类
	 * @return int 增加返回的影响行数
	 */
	public int insertSecurityStock(SecurityStock securityStock);
	
	/**
	 * 修改证券库存数据的方法
	 * @param securityStock 证券库存实体类
	 * @return int 修改返回的影响行数
	 */
	public int updateSecurityStock(SecurityStock securityStock);
	
	/**
	 * 该查询方法用于 当点击修改某行数据时，需要得到该数据的所有信息
	 * 返回一个实体类
	 * @param code 证券库存编号
	 * @return SecurityStock 返回一个实体类
	 */
	public SecurityStock selectSecurityStockByCode(String code);
	
}
