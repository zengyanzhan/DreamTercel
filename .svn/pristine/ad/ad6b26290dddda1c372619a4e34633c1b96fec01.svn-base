package com.yidu.businessData.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.businessData.domain.EquityData;


/**
 * 权益数据的dao
 * @author XiaoYuJie
 * @date 2017年11月14日
 * @time 上午9:39:13
 */
@Repository
public interface EquityDataDao {
	/**
	 * 增加一条权益数据
	 * @param EquityData权益数据实体类
	 * @return int i 成功与否 成功就返回1 失败就返回0
	 */
	public int  insertEquityData(EquityData equityData);

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
	public void selectEquityData(Map map);
	/**
	 * 修改数据
	 * @param equityData 
	 * @return 返回 int i 成功与否 成功就返回1 失败就返回0
	 */
	public int updateEquityData(EquityData equityData );
	/**
	 * 通过Id查询数据
	 * @param eqDataCode
	 * @return 返回一个实体类 equityData
	 */
	public List<EquityData> selectEquityDataCode(String eqDataCode);

}
