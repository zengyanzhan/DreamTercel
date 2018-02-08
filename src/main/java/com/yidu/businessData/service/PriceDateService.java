package com.yidu.businessData.service;

import java.util.List;
import java.util.Map;

import com.yidu.businessData.domain.PriceData;
import com.yidu.parameters.domain.Fund;
/**
 * 
 * @author YiWenQi
 *    
 * @date 2017年11月17日
 * @time 上午11:37:39
 */
public interface PriceDateService {
	
	Map<String, Object>  selectPriceData(PriceData priceDatas);

	/**
	 * 新增
	 * @param fund 基金信息实体类
	 * @return
	 */
	public Integer insertPrice(PriceData priceDatas);
	/**
	 * 修改
	 * @param fund 基金信息实体类
	 * @return
	 */
	public Integer updatePrice(PriceData priceDatas);
	/**
	 * 删除
	 * @param fund 基金信息实体类
	 * @return
	 */
	public Integer deletePrrice(PriceData priceDatas); 
	/**
	 * 通过编号查询数据
	 * @param fund 包含编号的实体类
	 * @return
	 */
	public PriceData selectPriceDataByCode(PriceData priceDatas);
	/**
	 *接口的行情shuju
	 * @param fileName
	 * @return
	 */
	public int imputShangHai(String fileName);
	/**
	 * 先删除在增加
	 * @param priceDatas 行情数据
	 * @return
	 */
	public int deletePriceByDate(PriceData priceDatas);
}
