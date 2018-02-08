package com.yidu.transactionProcessing.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.transactionProcessing.domain.Interests;

/**
 * 权益处理的dao
 * @author XiaoYuJie
 * @date 2017年11月16日
 * @time 下午4:09:59
 */
@Repository
public interface InterestsDao {
	/**
	 * 查询未处理数据
	 * @return List 返回一个集合
	 */
	public void selectInterests(Map<String,Object> map);
	
	/**
	 * 查询处理数据
	 * @return List 返回一个集合
	 */
	public void selectInterestsYi(Map<String,Object> map);
	
	/**
	 * 处理
	 * @param eqDataCode 权益id
	 * @param tip 权益状态
	 */
	public int updateInterests(Map<String,Object> map);
	
	/**
	 * 反处理处理
	 * @param eqDataCode 权益id
	 * @param tip 权益状态
	 */
	public int updateInterestsYi(Map<String,Object> map);
	
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
