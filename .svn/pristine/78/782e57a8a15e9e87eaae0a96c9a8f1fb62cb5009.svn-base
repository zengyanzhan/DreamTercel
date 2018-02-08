package com.yidu.businessData.service;


import java.util.List;
import java.util.Map;

import com.yidu.businessData.domain.EquityData;
/**
 * 
 * @author XiaoYuJie
 * @date 2017年11月14日
 * @time 上午11:45:38
 */
public interface EquityDataService {
	/**
	 * 增加一条权益数据
	 * @param EquityData权益数据实体类
	 * @return int i 成功与否 成功就返回1 失败就返回0
	 */
	public int insertEquityData(EquityData equityData);
	/**
	 * 删除一条权益数据
	 * @param eqDataCode 权益数据的id
	 * @return int i 成功与否 成功就返回1 失败就返回0
	 */
	public int deleteEquityData(EquityData equityData);
	/**
	 * 查询数据
	 * @return List 返回一个集合
	 */
	public Map<String, Object> selectEquityData(EquityData equityData);
	/**
	 * 修改数据
	 * @param equityData 
	 * @return 返回 int i 成功与否 成功就返回1 失败就返回0
	 */
	public int updateEquityData(EquityData equityData );
	/**
	 * 通过Id查询数据
	 * @param eqDataCode
	 * @return 返回一个集合 List
	 */
	public List<EquityData> selectEquityDataCode(String eqDataCode);
	
	public int input(String path);

}
