package com.yidu.reportManagement.dao;
import java.util.HashMap;
import java.util.Map;

import com.yidu.reportManagement.domain.SecurityMarket;
/**
 * 证券市场变动表接口类
 * @author 邓涛
 * @date 2017年12月8日
 * @time 下午12:05:34
 */
public interface SecurityMarketDao {
	/**
	 * 查询的方法
	 * @param map 
	 * @return HashMap集合
	 */
	public Map<String, Object>selectSecurityMarket(HashMap<String, Object> map);
	/**
	 * 查询净值统计表的数据
	 * @param securityMarket 证券市值变动表实体类
	 * @return
	 */
	public SecurityMarket selectNetValue(SecurityMarket securityMarket);
}
