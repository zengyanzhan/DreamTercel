package com.yidu.reportManagement.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.dayEnd.domain.NetValue;
import com.yidu.reportManagement.dao.FundInvestBlockReportDao;
import com.yidu.reportManagement.domain.FundInvestBlockReport;
import com.yidu.reportManagement.service.FundInvestBlockReportService;

/**
 * 
 * @author 杨丽
 * @date 2017年12月7日	
 * @time 上午11:43:39
 */
@Transactional
@Service
public class FundInvestBlockReportServiceImpl implements FundInvestBlockReportService{
	@Autowired
	FundInvestBlockReportDao fundInvestBlockReportDao;
	
	@Override
	public List<FundInvestBlockReport> selectFundInvestGroups(FundInvestBlockReport fundInvestBlockReport) {
		//调用通过基金编号查询的方法
		List<FundInvestBlockReport> list=fundInvestBlockReportDao.selectFundInvestBlocks(fundInvestBlockReport.getFundCode(),fundInvestBlockReport.getStatisticDateWhere());
	
		
		return list;
	}

	@Override
	public String bufferWhere(FundInvestBlockReport fundInvestBlockReport) {
		StringBuffer buffer=new StringBuffer("");
		//判断基金代码是否为空
		if(fundInvestBlockReport.getFundCode()!=null&&!fundInvestBlockReport.getFundCode().equals("")){
			buffer=buffer.append(" and tab.fundCode='"+fundInvestBlockReport.getFundCode()+"'");
		}
		//判断业务日期是否为空select * from cash_arap_stock where  business_date   = to_date('2017-11-10','yy-MM-dd');
		System.out.println("shij =="+fundInvestBlockReport.getStatisticDateWhere().toString());
		if(fundInvestBlockReport.getStatisticDateWhere()!=null&&!fundInvestBlockReport.getStatisticDateWhere().equals("")){
			buffer =buffer.append("	  and  tab.statisticDate= to_date(' "+fundInvestBlockReport.getStatisticDateWhere().toString()+"','yyyy-MM-dd')");
		}
		String flag=buffer.toString();
		return flag;	
		}
}
