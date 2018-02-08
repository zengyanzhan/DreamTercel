package com.yidu.reportManagement.service;

import java.util.List;
import java.util.Map;

import com.yidu.reportManagement.domain.CashPositionReport;
import com.yidu.reportManagement.domain.ReportParams;

/**
 * 现金头寸报表业务处理服务类
 * @author ZengYanZhan
 * @date 2017年12月2日
 * @time 下午8:06:08
 */
public interface CashPositionReportService {

	/**
	 * 统计现金头寸的数据
	 * @param reportParams 参数
	 * @return Map 统计数据
	 */
	public List<CashPositionReport> selectCashPositionReport(ReportParams reportParams);
}
