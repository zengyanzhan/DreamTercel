package com.yidu.reportManagement.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.reportManagement.domain.DealSettleAccounts;

/**
 * 成交日清算报表数据库操作类
 * @author Wang
 * @date 2017年12月7日
 * @time 下午6:37:04
 */
@Repository
public interface DealSetterReportDao {
	/**
	 * 查询成交日清算报表数据
	 * @param map
	 * @return
	 */
	public List<DealSettleAccounts> selectDealSettleAccounts(Map<String,Object> map);
	public int selectCount(Map<String,Object> map);
}
