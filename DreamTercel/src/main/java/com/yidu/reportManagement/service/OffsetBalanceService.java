package com.yidu.reportManagement.service;

import java.util.List;

import com.yidu.reportManagement.domain.OffsetBalance;
import com.yidu.transactionProcessing.domain.DealData;

/**
 * 	成交清算轧差数据业务处理接口类
 * @author 肖恩
 *	@date 2017年12月6日
 * @time 上午10:29:06
 */
public interface OffsetBalanceService {
	/**
	 * 查询成交清算的轧差数据
	 * @param tradeData 交易数据实体类
	 * @return 成交清算的轧差数据集合
	 */
	public List<OffsetBalance> selectOffsetBalance(DealData dealData);
}
