package com.yidu.reportManagement.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.yidu.reportManagement.domain.ReportParams;
import com.yidu.reportManagement.domain.SeatDealDetailReport;

/**
 * 席位成交明细
 * @author ZengYanZhan
 * @date 2017年12月1日
 * @time 下午8:04:49
 */
@Repository
public interface SeatDealDetailReportDao {
	/**
	 * 查询席位成交量的统计数据
	 * @param reportParams 参数
	 * @return List 查询之后的数据
	 */
	public List<SeatDealDetailReport> selectSeatDealDetailReport(ReportParams reportParams);
}
