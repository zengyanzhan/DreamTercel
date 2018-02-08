package com.yidu.parameters.service;

import java.util.List;
import java.util.Map;

import com.yidu.parameters.domain.Seat;
/**
 * 交易席位信息业务逻辑处理类
 * @author Wang
 * @date 2017年11月16日
 * @time 下午6:24:33
 */
public interface SeatService {
	/**
	 * 查询交易信息
	 * @param seat 交易席位实体对象  
	 * @return 交易席位实体对象信息和总条数map
	 */
	public Map<String, Object> selectSeat(Seat seat);   
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
	
}
