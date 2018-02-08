package com.yidu.dayEnd.service;
import java.util.List;

import com.yidu.dayEnd.dao.TwoCostDao;
import com.yidu.dayEnd.domain.TwoCost;
import com.yidu.parameters.domain.Fund;
/**
 * 两费逻辑类
 * @author 邓涛
 * @date 2017年12月5日
 * @time 上午12:25:23
 */
public interface TwoCostService {
	/**
	 * 查询两费
	 * @param List 集合
	 */
	public List selectTwoCost(TwoCost twoCost);
	/**
	 * 通过现金账户id进行查询
	 * @param cashAccountCode 现金账户
	 * @return
	 */
	public List<TwoCostDao> selectByIdTwoCost(String cashAccountCode);
}
