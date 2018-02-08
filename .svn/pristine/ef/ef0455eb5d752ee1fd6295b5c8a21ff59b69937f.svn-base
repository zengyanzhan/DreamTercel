package com.yidu.reportManagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.reportManagement.dao.SeatDealDetailReportDao;
import com.yidu.reportManagement.dao.SeatTradeReportDao;
import com.yidu.reportManagement.domain.ReportParams;
import com.yidu.reportManagement.domain.SeatDealDetailReport;
import com.yidu.reportManagement.domain.SeatTradeReport;
import com.yidu.reportManagement.service.SeatDealDetailReportService;

/**
 * 席位成交明细报表业务处理实现类
 * @author ZengYanZhan
 * @date 2017年12月1日
 * @time 下午8:11:02
 */
@Service
public class SeatDealDetailReportServiceImpl implements SeatDealDetailReportService{
	@Autowired
	private SeatDealDetailReportDao seatDealDetailReportDao;//自动装配席位成交明细模型
	@Autowired
	private SeatTradeReportDao seatTradeReportDao;//自动装配席位交易

	@Override
	public List<Object> selectSeatDealDetailReport(ReportParams reportParams) {
		// TODO Auto-generated method stub
		 //进行业务逻辑处理
		List<Object> outList=new ArrayList<Object>();//list集合用来存贮map数据
		List<SeatTradeReport> brokerReportList=seatTradeReportDao.selectBrokerReport(reportParams);//查询券商
		for(SeatTradeReport seatTradeReport:brokerReportList){//遍历券商
			Map<String,Object> map=new HashMap<String,Object>();//map集合存贮父子关系数据
			//SeatTradeReport seatTradeReportEntity=new SeatTradeReport();//创建实体类
			map.put("seatName", seatTradeReport.getSeatName());//得到席位名称
			map.put("securityCode","");//得到证券代码
			map.put("securityName","");//得到证券名称
			map.put("dealQuantity", "");//得到证券交易数量
			map.put("dealTotalPrice","");//得到证券总金额
			map.put("brokerage","");//得到佣金费用（券商）   
			map.put("stamps","");//印花税（国家）
			map.put("handleFee","");//经手费（交易所）
			map.put("transferFee","");//过户费（交易所）
			map.put("manageFee","");//征管费（国家）
			List<SeatTradeReport> exchangeList=new ArrayList<SeatTradeReport>();//创建交易所集合 来构建上下级关系
			exchangeList.add(new SeatTradeReport(null, 0, 0, 0, 0, 0, 0, "上交所", 0,0, 0, 0, null, 1));//创建上交所
			exchangeList.add(new SeatTradeReport(null, 0, 0, 0, 0,0, 0, "深交所", 0, 0, 0, 0, null, 2));//创建深交所
			List<Object> list=new ArrayList<Object>();//创建list集合存贮数据
			for(SeatTradeReport seatTradeReportInner:exchangeList){
				Map<String,Object> innerMap=new HashMap<String,Object>();//创建map集合存贮席位数据
				innerMap.put("seatName", seatTradeReportInner.getSeatName());//得到席位名称
				innerMap.put("securityCode","");//得到证券代码
				innerMap.put("securityName","");//得到证券名称
				innerMap.put("dealQuantity", "");//得到证券交易数量
				innerMap.put("dealTotalPrice","");//得到证券总金额
				innerMap.put("brokerage","");//得到佣金费用（券商）   
				innerMap.put("stamps","");//印花税（国家）
				innerMap.put("handleFee","");//经手费（交易所）
				innerMap.put("transferFee","");//过户费（交易所）
				innerMap.put("manageFee","");//征管费（国家）
				reportParams.setExchangeCode(seatTradeReportInner.getExchangeCode());//得到交易所编号
				//System.err.println(reportParams);
				List<Object> innerList=new ArrayList<Object>();//创建list集合用来存贮交易所下面的证券
				List<SeatDealDetailReport> securityTypeList=new ArrayList<SeatDealDetailReport>();//创建集合 存贮证券的类型 股票或者是债券
				securityTypeList.add(new SeatDealDetailReport(null, null, "股票", 0, 0, 0, 0, 0, 0, 0, 0, 1));
				securityTypeList.add(new SeatDealDetailReport(null, null, "债券", 0, 0, 0, 0, 0, 0, 0, 0, 2));
				for(SeatDealDetailReport seatDealDetailReprot:securityTypeList){
					Map<String,Object> securityMap=new HashMap<String,Object>();//创建map集合存贮席位数据
					securityMap.put("seatName", seatDealDetailReprot.getSecurityName());//得到席位名称
					securityMap.put("securityCode","");//得到证券代码
					securityMap.put("securityName","");//得到证券名称
					securityMap.put("dealQuantity", "");//得到证券交易数量
					securityMap.put("dealTotalPrice","");//得到证券总金额
					securityMap.put("brokerage","");//得到佣金费用（券商）   
					securityMap.put("stamps","");//印花税（国家）
					securityMap.put("handleFee","");//经手费（交易所）
					securityMap.put("transferFee","");//过户费（交易所）
					securityMap.put("manageFee","");//征管费（国家）
					reportParams.setSecurityType(seatDealDetailReprot.getSecrityType());//得到证券类型
					List<SeatDealDetailReport> seatDealDetailReportList=seatDealDetailReportDao.selectSeatDealDetailReport(reportParams);//得到该券商下的所有席位具体费用
					securityMap.put("children", seatDealDetailReportList);//添加到map 形参父子关系
					innerList.add(securityMap);
				}
				innerMap.put("children", innerList);
				list.add(innerMap);//添加到list
			}
			map.put("children", list);
			outList.add(map);
		}
		return outList;
	}



}
