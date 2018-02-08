package com.yidu.reportManagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yidu.reportManagement.domain.OffsetBalance;
import com.yidu.transactionProcessing.domain.DealData;
/**
 * 	成交清算轧差数据连接数据库操作接口类
 * @author 肖向恩
 *	@date 2017年12月6日
 * @time 上午10:39:41
 */

@Repository("offsetBalanceDao")
public interface OffsetBalanceDao {
	/**
	 * 	查询成交清算的轧差数据
	 * @param tradeData 交易数据实体类
	 * @return 成交清算的轧差数据集合
	 */
	public List<OffsetBalance> selectOffsetBalance(DealData dealData);
}
