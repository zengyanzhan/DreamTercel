package com.yidu.reportManagement.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.reportManagement.domain.ReportParams;
import com.yidu.reportManagement.domain.SeatTradeReport;

/**
 * 席位交易量统计dao层
 * @author ZengYanZhan
 * @date 2017年12月1日
 * @time 下午7:35:21
 */
@Repository
public interface SeatTradeReportDao {
	/**
	 * 查询席位交易统计之后的数据
	 * @param reportParams 参数
	 * @return List 席位数据
	 */
     public List<SeatTradeReport> selectSeatTradeReport(ReportParams reportParams);
     
     /**
      * 查询券商统计数据
      * @param reportParams 参数
      * @return List 券商数据
      */
     public List<SeatTradeReport> selectBrokerReport(ReportParams reportParams);
     
     /**
      * 根据交易所统计 该交易所的股票以及债券的金额数量
      * @param reportParams 参数
      * @return  交易所统计数据
      */
     public List<SeatTradeReport> selectSeatTradeExchange(ReportParams reportParams);
     
     /**
      * 统计交易所的所有股票以及债券的数量 不分场所
      * @param reportParams 参数
      * @return  两地合计数据
      */
     public SeatTradeReport selectTotalData(ReportParams reportParams);
}
