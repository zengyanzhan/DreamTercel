package com.yidu.reportManagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.metamodel.SetAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.reportManagement.dao.SeatTradeReportDao;
import com.yidu.reportManagement.domain.ReportParams;
import com.yidu.reportManagement.domain.SeatTradeReport;
import com.yidu.reportManagement.service.SeatTradeReportService;

/**
 * 席位交易量统计业务处理实现类
 * @author ZengYanZhan
 * @date 20d17年12月1日
 * @time 下午7:42:53
 */
@Service
public class SeatTradeReportServiceImpl implements SeatTradeReportService {
	@Autowired
	private SeatTradeReportDao seatTradeReportDao;//自动装配席位交易\

	public static Double sumTotalMoney=0d;//总金额记录数据

	@Override
	public List<Object> selectSeatTradeReport(ReportParams reportParams) {
		//进行业务逻辑处理
		Double totalMoney=0d;//合计金额
		Double percent=0d;//两地交易量比例
		Double inputPlate=0d;
		Double outputPlate=0d;
		Double inputBond=0d;
		Double outputBond=0d;
		List<Object> outList=new ArrayList<Object>();//list集合用来存贮map数据
	
		//两地合计
		Double totalMoneys=0d;//合计金额
		Double percents=0d;//两地交易量比例
		Double money=0d;
		Double inputPlates=0d;
		Double outputPlates=0d;
		Double inputBonds=0d;
		Double outputBonds=0d;
		//Map<String,Object> totalMap=new HashMap<String,Object>();//创建map集合用来存贮两地合计的数据
		List<SeatTradeReport> totalList=new ArrayList<SeatTradeReport>();//创建list集合形成父子关系
		totalList.add(new SeatTradeReport(null, 0, 0,0, 0,0,0, "两地合计", 0, 0, 0,0, null,null));
		for(SeatTradeReport seatTradeReport:totalList){
			Map<String,Object> map=new HashMap<String,Object>();
			//查询统计两地合计的数据
			SeatTradeReport seatTradeReportTotal=seatTradeReportDao.selectTotalData(reportParams);
			inputPlates=seatTradeReportTotal.getInputPlate();
			outputPlates=seatTradeReportTotal.getOutputPlate();
			inputBonds=seatTradeReportTotal.getInputBond();
			outputBonds=seatTradeReportTotal.getOutputBond();
			totalMoneys=inputPlates+outputPlates+inputBonds+outputBonds;
			sumTotalMoney=totalMoneys;
			map.put("seatName", seatTradeReport.getSeatName());//得到券商名称
			map.put("inputPlate", inputPlates);//得到买入股票
			map.put("outputPlate",outputPlates);//得到卖出股票
			map.put("inputBond",inputBonds);//得到买入债券
			map.put("outputBond",outputBonds);//得到卖出债券
			map.put("totalMoney",totalMoneys);//得到合计金额
			map.put("tradeMeasure",100);//交易量比例
			List<SeatTradeReport> exchangeList=new ArrayList<SeatTradeReport>();//创建交易所集合
			exchangeList.add(new SeatTradeReport(null, 0, 0,0, 0, 0, 0, "上海合计", 0, 0, 0,0, null, 1));//创建上交所
			exchangeList.add(new SeatTradeReport(null, 0, 0,0, 0, 0,0, "深圳合计", 0, 0, 0, 0, null, 2));//创建深交所
			List<Object> list=new ArrayList<Object>();
			for(SeatTradeReport seatTradeReportEntity:exchangeList){
				reportParams.setExchangeCode(seatTradeReportEntity.getExchangeCode());//得到交易所
				List<SeatTradeReport> seatTradeReportExchangeList=seatTradeReportDao.selectSeatTradeExchange(reportParams);//存贮上交所 和深交所数据
				Map<String,Object> innerMap=new HashMap<String,Object>();
				innerMap.put("seatName", seatTradeReportEntity.getSeatName());//得到券商名称
				for(SeatTradeReport seatTradeReprotExchange:seatTradeReportExchangeList){
					inputPlates=seatTradeReprotExchange.getInputPlate();
					outputPlates=seatTradeReprotExchange.getOutputPlate();
					inputBonds=seatTradeReprotExchange.getInputBond();
					outputBonds=seatTradeReprotExchange.getOutputBond();
				}
				innerMap.put("inputPlate", inputPlates);//得到买入股票
				innerMap.put("outputPlate",outputPlates);//得到卖出股票
				innerMap.put("inputBond",inputBonds );//得到买入债券
				innerMap.put("outputBond",outputBonds);//得到卖出债券
				money=(inputPlates+outputPlates+inputBonds+outputBonds);
				percents=(money/totalMoneys)*100;//计算不同交易所比例
				innerMap.put("totalMoney",money);//得到合计金额
				innerMap.put("tradeMeasure",percents);//交易量比例
				list.add(innerMap);
			}
			map.put("children", list);
			outList.add(map);
		}
		List<SeatTradeReport> brokerReportList=seatTradeReportDao.selectBrokerReport(reportParams);//查询券商
		for(SeatTradeReport seatTradeReport:brokerReportList){//遍历券商
			Map<String,Object> map=new HashMap<String,Object>();//map集合存贮父子关系数据
			//SeatTradeReport seatTradeReportEntity=new SeatTradeReport();//创建实体类
			inputPlate=seatTradeReport.getInputPlate();
			outputPlate=seatTradeReport.getOutputPlate();
			inputBond=seatTradeReport.getInputBond();
			outputBond= seatTradeReport.getOutputBond();
			//得到该券商的总金额
			totalMoney=inputPlate+outputPlate+inputBond+outputBond;
			percent=(totalMoney/sumTotalMoney)*100;
			map.put("seatName", seatTradeReport.getSeatName());//得到券商名称
			map.put("inputPlate", inputPlate);//得到买入股票
			map.put("outputPlate", outputPlate);//得到卖出股票
			map.put("inputBond", inputBond);//得到买入债券
			map.put("outputBond",outputBond);//得到卖出债券
			map.put("totalMoney",totalMoney);//得到合计金额
			map.put("tradeMeasure",percent);//交易量比例
			List<SeatTradeReport> exchangeList=new ArrayList<SeatTradeReport>();//创建交易所集合
			exchangeList.add(new SeatTradeReport(null, 0, 0, 0, 0,0, 0, "上交所", 0,0, 0, 0, null, 1));//创建上交所
			exchangeList.add(new SeatTradeReport(null, 0, 0, 0, 0, 0, 0, "深交所", 0, 0, 0,0, null, 2));//创建深交所
			List<Object> list=new ArrayList<Object>();//创建list集合存贮数据
			for(SeatTradeReport seatTradeReportInner:exchangeList){
				Map<String,Object> innerMap=new HashMap<String,Object>();//创建map集合存贮席位数据
				innerMap.put("seatName", seatTradeReportInner.getSeatName());//得到席位名称
				innerMap.put("inputPlate", 0);//得到买入股票
				innerMap.put("outputPlate", 0);//得到卖出股票
				innerMap.put("inputBond", 0);//得到买入债券
				innerMap.put("outputBond",0);//得到卖出债券
				innerMap.put("totalMoney",0);//得到合计金额
				innerMap.put("tradeMeasure",0);//交易量比例
				reportParams.setExchangeCode(seatTradeReportInner.getExchangeCode());//得到交易所编号
				reportParams.setBrokerCode(seatTradeReport.getBorkerCode());//得到券商编号
				List<SeatTradeReport> seatReportList=seatTradeReportDao.selectSeatTradeReport(reportParams);//得到该券商下的所有席位
				for(SeatTradeReport seatTradeReportEntity:seatReportList){//遍历席位计算总金额 以及交易量比例
					money=seatTradeReportEntity.getInputPlate()+seatTradeReportEntity.getInputBond()+seatTradeReportEntity.getOutputPlate()+seatTradeReportEntity.getOutputBond();
					Double dealPercent=(money/sumTotalMoney)*100;//不同交易所不同的交易比例
					seatTradeReportEntity.setTotalMoney(money);
					seatTradeReportEntity.setTradeMeasure(dealPercent);
				}
				innerMap.put("children", seatReportList);
				list.add(innerMap);//添加到list
			}
			map.put("children", list);
			outList.add(map);
		}
		return outList;
	}

}
