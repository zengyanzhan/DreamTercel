package com.yidu.businessData.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yidu.businessData.domain.PriceData;

@Repository
public interface PriceDateDao {
	/**
	 * 分页查询 行情数据
	 * @param map
	 */
	public void selectPriceData(Map<String, Object> map);
	/**
	 * 
	 * @param fund 实体类
	 * @return int 修改返回的影响行数
	 */
	public int insertPrice(PriceData priceDatas); 
	/**
	 * 修改角色数据的方法
	 * @param PriceData 角色实体类
	 * @return int 修改返回的影响行数
	 */
	public int updatePrice(PriceData priceDatas);
	/**
	 * 删除角色数据的方法
	 * @param priceDatas
	 * @return int 删除返回影响的行数
	 */
	public int deletePrrice(PriceData priceDatas);
	/**
	 * 通过编号查询数据
	 * @param priceDatas 
	 * @return
	 */
	public PriceData selectPriceDataByCode(PriceData priceDatas);
	/**
	 * 先删除在增加
	 * @return
	 */
	public int deletePriceByDate(@Param("enteringDate")Date enteringDate);
	
}
