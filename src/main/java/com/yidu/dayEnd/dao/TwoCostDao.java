package com.yidu.dayEnd.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.dayEnd.domain.TwoCost;

/**
 * 两费接口
 * @author 邓涛
 * @date 2017年12月5日
 * @time 上午12:21:52
 */
@Repository
public interface TwoCostDao {
	/**
	 * 查询两费
	 * @param List 集合
	 */
	public List selectTwoCost(Map<Object, Object> map);
	/**
	 * 通过现金账户id进行查询
	 * @param cashAccountCode 现金账户
	 * @return
	 */
	public List<TwoCostDao> selectByIdTwoCost(Map<String, Object> map);
}
