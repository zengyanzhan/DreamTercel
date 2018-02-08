package com.yidu.parameters.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.parameters.domain.Seat;

/**
 * 
 * 交易席位数据库操作类
 * @author Wang
 * @date 2017年11月16日
 * @time 下午6:12:57
 */
@Repository
public interface SeatDao {
	/**
	 * 查询所有信息
	 * @param map 条件查询的map
	 */
	public void selectSeat(Map<String, Object> map);
	/**
	 * 添加交易席位信息
	 * @param seat 交易席位实体对象
	 * @return 受影响行数
	 */
	public int insertSeat(Seat seat);
	/**
	 * 修改交易席位信息
	 * @param seat 交易席位实体对象
	 * @return 受影响行数
	 */
	public int updateSeat(Seat seat);
	/**
	 * 删除交易席位信息
	 * @param seat 交易席位实体对象
	 * @return 受影响行数  
	 */
	public int deleteSeat(Seat seat);
	/**
	 * 通过交易编号查询交易席位信息
	 * @param seatCode 交易席位编号
	 * @return 交易席位信息
	 */
	public List<Seat> selectSeatById(String seatCode);
	/**
	 * 通过券商编号查询交易席位信息
	 * @param borketCode 券商编号
	 * @return 交易席位信息
	 */
	public List<Seat> selectSeatByBorketCode(String borketCode);
}
