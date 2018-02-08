package com.yidu.reportManagement.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.reportManagement.domain.CashPositionReport;
import com.yidu.reportManagement.domain.ReportParams;

/**
 * 现金头寸报表
 * @author ZengYanZhan
 * @date 2017年12月2日
 * @time 下午8:12:00
 */
@Repository
public interface CashPositionReportDao {
	/**
	 * 查询现金余额的余额数据
	 * @param reportParams 参数
	 * @return  现金余额参数
	 */
   public List<CashPositionReport> selectCashBalance(ReportParams reportParams);
   
   /**
    * 查询证券清算款数据 
    * @param reportParams 参数
    * @return 证券清算款数据 
    */
   public List<CashPositionReport> selectSecurityBlance(ReportParams reportParams);
   
   /**
    * 查询申购赎回清算款数据
    * @param reportParams 参数
    * @return 申购赎回清算款数据
    */
   public List<CashPositionReport> selectTaBlance(ReportParams reportParams);
   }
