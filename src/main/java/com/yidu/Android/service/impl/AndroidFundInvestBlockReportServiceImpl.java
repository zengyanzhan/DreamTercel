package com.yidu.Android.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.Android.dao.AndroidFundInvestBlockReportDao;
import com.yidu.Android.domain.AndroidFundInvestBlockReport;
import com.yidu.Android.service.AndroidFundInvestBlockReportService;

/**
 * 
 * @author 杨丽
 * @date 2017年12月7日	
 * @time 上午11:43:39
 */
@Transactional
@Service
public class AndroidFundInvestBlockReportServiceImpl implements AndroidFundInvestBlockReportService{
	@Autowired
	AndroidFundInvestBlockReportDao fundInvestBlockReportDao;
	
	@Override
	public HashMap<String, Object> selectFundInvestGroups(String tableName, String qualification, Integer page,
			Integer rows, Integer rowsTotal, String orderColumn, String orderStyle) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map=new HashMap<String,Object>();
		tableName="(select distinct sb.stock_block_name as stockBlockName, "
				+ "ss.security_quantity as assecurityQuantity, "
				+ "pd.pd_closingPrice*ss.security_quantity as marketValue, "
				+ "nv.project_code as projectCode,"
				+ "nv.fund_code as fundCode,nv.statistic_date as statisticDate "
				+ "from security se join "
				+ "(select * from stock_block)sb on  "
				+ "sb.stock_block_father_code=se.stock_plate_code "
				+ "join (select * from security_stock) ss "
				+ "on se.security_code=ss.security_code "
				+ "join (select * from priceData) pd "
				+ "on pd.pd_securityCode=ss.security_code "
				+ "join (select * from net_value where project_name='资产净值')nv  "
				+ "on ss.fund_code=nv.fund_code   "
				+ "and ss.security_statistics_date=nv.statistic_date  "
				+ "and  ss.fund_code=nv.fund_code )tab";
		map.put("tableName",tableName);
		map.put("qualification",qualification);
		map.put("page",page);
		map.put("rows",rows);
		map.put("rowsTotal",rowsTotal);
		map.put("orderColumn","" );
		map.put("orderStyle","" );
		fundInvestBlockReportDao.selectFundInvestBlocks(map);
		map.get("list");
		
		return map;
	}

	@Override
	public String bufferWhere(AndroidFundInvestBlockReport fundInvestBlockReport) {
		StringBuffer buffer=new StringBuffer("");
		//判断基金代码是否为空
		if(fundInvestBlockReport.getFundCode()!=null&&!fundInvestBlockReport.getFundCode().equals("")){
			buffer=buffer.append(" and tab.fundCode='"+fundInvestBlockReport.getFundCode()+"'");
		}
		//判断业务日期是否为空select * from cash_arap_stock where  business_date   = to_date('2017-11-10','yy-MM-dd');
		if(fundInvestBlockReport.getStatisticDateWhere()!=null&&!fundInvestBlockReport.getStatisticDateWhere().equals("")){
			buffer =buffer.append("	  and  tab.statisticDate= to_date(' "+fundInvestBlockReport.getStatisticDateWhere()+"','yy-MM-dd')");
		}
		String flag=buffer.toString();
		return flag;	
		}
}
