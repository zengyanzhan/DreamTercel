package com.yidu.reportManagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.reportManagement.dao.CashPositionReportDao;
import com.yidu.reportManagement.domain.CashPositionReport;
import com.yidu.reportManagement.domain.ReportParams;
import com.yidu.reportManagement.service.CashPositionReportService;

/**
 * 现金头寸报表统计业务处理实现类
 * @author ZengYanZhan
 * @date 2017年12月2日
 * @time 下午8:10:13
 */
@Service
public class CashPositionReportServiceImpl implements CashPositionReportService{
	@Autowired
	private CashPositionReportDao cashPositionReportDao;//自动装配现金头寸

	@Override
	public List<CashPositionReport> selectCashPositionReport(ReportParams reportParams) {
		// TODO Auto-generated method stub
		//创建集合存贮数据 现金寸头数据
		List<CashPositionReport> cashPositionReportList=new ArrayList<CashPositionReport>();
		double money=0;
		double moneySecuritys=0;
		double moneySecurityz=0;
		double moneyTotal=0;
		//添加现金余额数据
		List<CashPositionReport> cashPositionBlance=cashPositionReportDao.selectCashBalance(reportParams);
		String str=cashPositionBlance.toString().substring(1, cashPositionBlance.toString().length()-1);//切割字符串
		if(cashPositionBlance.size()==0 || str.equals("null")){//如果没有现金数据 默认为0
			CashPositionReport cashPositionEntity=new CashPositionReport();
			cashPositionEntity.setProjectId("XJCT001");
			cashPositionEntity.setProjectName("现金余额");
			cashPositionEntity.setProjectPrice(0d);
			money=cashPositionEntity.getProjectPrice();
			cashPositionReportList.add(cashPositionEntity);
		}else{
			for(CashPositionReport cashPosition:cashPositionBlance){ //得到现金余额 添加到list集合
				cashPosition.setProjectId("XJCT001");
				cashPosition.setProjectName("现金余额");
				money=cashPosition.getProjectPrice();
				cashPositionReportList.add(cashPosition);
			}
		}
		//添加证券清算款   
		reportParams.setExchangeCode(1);//设置交易所标志为1的 代表上交所
		List<CashPositionReport> cashPositionReport=cashPositionReportDao.selectSecurityBlance(reportParams);
		if(cashPositionReport.size()==0){//如果没有上交所清算款数据 默认为0 
			CashPositionReport cashPositionEntity=new CashPositionReport();
			cashPositionEntity.setProjectId("XJCT002");
			cashPositionEntity.setProjectName("上交所清算款");
			cashPositionEntity.setProjectPrice(0d);
			moneySecuritys=cashPositionEntity.getProjectPrice();
			cashPositionReportList.add(cashPositionEntity);
		}
		for(CashPositionReport cashPosition:cashPositionReport){//得到上交所清算款数据 添加到list集合
			cashPosition.setProjectId("XJCT002");
			cashPosition.setProjectName("上交所清算款");
			moneySecuritys=cashPosition.getProjectPrice();
			cashPositionReportList.add(cashPosition);
		}
		//添加深交所清算款
		reportParams.setExchangeCode(2); //设置交易场所标志为2的 代表深交所
		List<CashPositionReport> cashPositionReports=cashPositionReportDao.selectSecurityBlance(reportParams);
		if(cashPositionReports.size()==0){//如果没有申购赎回清算款数据 则默认为0
			CashPositionReport cashPositionEntity=new CashPositionReport();
			cashPositionEntity.setProjectId("XJCT003");
			cashPositionEntity.setProjectName("深交所清算款");
			cashPositionEntity.setProjectPrice(0d);
			moneySecurityz=cashPositionEntity.getProjectPrice();
			cashPositionReportList.add(cashPositionEntity);
		}
		for(CashPositionReport cashPosition:cashPositionReports){//得到深交所清算款数据
			cashPosition.setProjectId("XJCT003");
			cashPosition.setProjectName("深交所清算款");
			moneySecurityz=cashPosition.getProjectPrice();
			cashPositionReportList.add(cashPosition);
		}

		//添加申购赎回请算款
		List<CashPositionReport> cashPositionMoney=cashPositionReportDao.selectTaBlance(reportParams);
		if(cashPositionMoney.size()==0){//如果没有申购赎回清算款数据 则默认为0
			CashPositionReport cashPositionEntity=new CashPositionReport();
			cashPositionEntity.setProjectId("XJCT004");
			cashPositionEntity.setProjectName("申购赎回请算款");
			cashPositionEntity.setProjectPrice(0d);
			moneyTotal=cashPositionEntity.getProjectPrice();
			cashPositionReportList.add(cashPositionEntity);
		}
		for(CashPositionReport cashPosition:cashPositionMoney){ //得到申购赎回清算款的数据 并添加到list集合
			cashPosition.setProjectId("XJCT004");
			cashPosition.setProjectName("申购赎回请算款");
			moneyTotal=cashPosition.getProjectPrice();
			cashPositionReportList.add(cashPosition);
		}
		//银行存款 包括现金余额以及存款利息的总和
		cashPositionReportList.add(new CashPositionReport(null, "银行存款总计", money, null, null));
		CashPositionReport cashPositionTotal=new CashPositionReport(null, "清算款", moneySecuritys+moneySecurityz+moneyTotal, null, null);
		//清算款包括申购赎回的清算款
		cashPositionReportList.add(cashPositionTotal);
		//可用现金寸头通过存款和清算款得到两者之差
		cashPositionReportList.add(new CashPositionReport(null, "可以现金寸头", money-cashPositionTotal.getProjectPrice(), null, null));
		return cashPositionReportList;
	}

}
