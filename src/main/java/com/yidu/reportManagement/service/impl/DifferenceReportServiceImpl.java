package com.yidu.reportManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.reportManagement.dao.DifferenceReportDao;
import com.yidu.reportManagement.domain.DifferenceReport;
import com.yidu.reportManagement.service.DifferenceReportService;
import com.yidu.util.AllUtil;
/**
 * 轧差表实现类
 * @author Wang
 * @date 2017年12月12日
 * @time 上午9:06:35
 */
@Service
public class DifferenceReportServiceImpl implements DifferenceReportService{
	@Autowired
	DifferenceReportDao differenceReportDao;
	@Override
	public Map<String, Object> selectDifferenceReport(DifferenceReport differenceReport,String fundCode) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("fundCode", fundCode);
		map.put("strDealDate", differenceReport.getStrDealDate());
		List<DifferenceReport> differenceReportList=differenceReportDao.selectDifferenceReport(map);
		
		for (DifferenceReport report:differenceReportList) {
			String strSecurityType="";
			if(report.getExchangeName()==1){
				strSecurityType=strSecurityType+"上海";
			}else if(report.getExchangeName()==2){
				strSecurityType=strSecurityType+"深圳";
			}
			if(report.getSecurityType()==1){
				strSecurityType=strSecurityType+"股票";
			}else if(report.getSecurityType()==2){
				strSecurityType=strSecurityType+"债券";
			}
			report.setStrSecurityType(strSecurityType);
		}
		double stampDuty=0;
		double transferFee=0;
		double managementFee=0;
		double brokerageFee=0;
		double commissionFee=0;
		double securityInterest=0;
		double settleMoney=0;
		double lcTotalPrice=0;
		double lrTotalPrice=0;
		double shiJiMoney=0;
		System.err.println(differenceReportList);
		for (DifferenceReport report:differenceReportList) {
			stampDuty=AllUtil.getRoundUp(stampDuty+report.getStampDuty());
			transferFee=AllUtil.getRoundUp(transferFee+report.getTransferFee());
			managementFee=AllUtil.getRoundUp(managementFee+report.getManagementFee());
			brokerageFee=AllUtil.getRoundUp(brokerageFee+report.getBrokerageFee());
			commissionFee=AllUtil.getRoundUp(commissionFee+report.getCommissionFee());
			securityInterest=AllUtil.getRoundUp(securityInterest+report.getSecurityInterest());
			settleMoney=AllUtil.getRoundUp(settleMoney+report.getSettleMoney());
			lcTotalPrice=AllUtil.getRoundUp(lcTotalPrice+report.getLcTotalPrice());
			lrTotalPrice=AllUtil.getRoundUp(lrTotalPrice+report.getLrTotalPrice());
			shiJiMoney=AllUtil.getRoundUp(shiJiMoney+report.getShiJiMoney());
		}
		DifferenceReport report=new DifferenceReport(1, "两地合计", 1, stampDuty, transferFee, managementFee, brokerageFee, commissionFee, securityInterest, settleMoney, lcTotalPrice, lrTotalPrice, shiJiMoney);
		differenceReportList.add(report);
		Integer count=differenceReportDao.selectDifferenceReportCount(map);
		Map<String, Object> mapjie=new HashMap<String, Object>();
		mapjie.put("rows", differenceReportList);
		mapjie.put("total", count);
		return mapjie;
	}

}
