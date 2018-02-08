package com.yidu.transactionProcessing.service;

import java.util.List;
import java.util.Map;

import com.yidu.transactionProcessing.domain.Interests;


/**
 * 
 * @author XiaoYuJie
 * @date 2017年11月17日
 * @time 上午10:00:28
 */

public interface InterestsService {
	/**
	 * 查询未处理数据
	 * @return List 返回一个集合
	 */
	public Map<String, Object> selectInterests(String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle);
	
	/**
	 * 查询已处理数据
	 * @return List 返回一个集合
	 */
	public Map<String, Object> selectInterestsYi(String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle);
	/**
	 * 处理
	 * @param eqDataCode 权益id
	 * @param tip 权益状态
	 */
	public int updateInterests(String eqDataCode,String tip);
	
	
	/**
	 * 反处理
	 * @param eqDataCode 权益id
	 * @param tip 权益状态
	 */
	public int updateInterestsYi(String eqDataCode,String tip);
	
	/**
	 * 查询数据
	 * @return List 返回一个集合
	 */
	public List<Interests> selectInterestsEqDataCode(String eqDataCode);
	
	/**
	 * 查询条件
	 * @param interests
	 * @return
	 */
	public String buffwhere(Interests interests);
}
