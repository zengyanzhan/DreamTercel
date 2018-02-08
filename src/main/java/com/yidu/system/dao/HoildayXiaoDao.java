package com.yidu.system.dao;

import java.util.List;
import java.util.Map;

import com.yidu.system.domain.HoildayXiao;

/**
 * 节假日xiaodao
 * @author XiaoYuJie
 * @date 2017年11月24日
 * @time 上午9:40:33
 */
public interface HoildayXiaoDao {
	/**
	 * 查询节假日
	 * @param date
	 * @return 返回一个List集合
	 */ 
	public List<HoildayXiao> selectHoildayXiao(Integer date);
	 /**
		 * 查询节假日
		 * @param date
		 * @return 返回一个List集合
		 */ 
	public List<HoildayXiao> selectHoildayBydate(String date);
	/**
	 * 增加一条节假日数据
	 * @param hoildayXiao
	 * @return i 返回1为增加成功
	 */
	public int insertHoildayXiao(Map  map);
	/**
	 * 删除一条节假日数据
	 * @param date
	 * @return i 返回1位删除成功
	 */
	public int deleteHoildayXiao(String date);
}
