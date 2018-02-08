package com.yidu.dayEnd.service;

import java.util.List;
import java.util.Map;

import com.yidu.businessData.domain.PriceData;
import com.yidu.dayEnd.domain.NetValue;
import com.yidu.parameters.domain.Fund;
import com.yidu.system.domain.HoildayXiao;

/**
 * 资产估值Service
 * @author Lee
 * @date 2017年11月14日
 * @time 上午9:41:37
 */
public interface AssetValuationService {
	/**
	 * 证券估值增值
	 * @param guZhiDate  估值的日期
	 * @param fundId 基金代码
	 * @return
	 */
	public String appraisement(String guZhiDate,String fundId);
	/**
	 * 清算款
	 * @param guZhiDate 估值日期
	 * @param fundId
	 * @return
	 */
	public String  clearingModel(String guZhiDate,String fundId);
	/**
	 * 查询节假日
	 * @return
	 */
	public List<HoildayXiao> selectHoildayBydate(String guZhiDate);
}
