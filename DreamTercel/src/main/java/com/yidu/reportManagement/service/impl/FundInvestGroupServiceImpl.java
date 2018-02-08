package com.yidu.reportManagement.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.reportManagement.dao.FundInvestGroupReportDao;
import com.yidu.reportManagement.domain.FundInvestGroup;
import com.yidu.reportManagement.service.FundInvestGroupService;
/**
 * 基金投资组合表的业务逻辑层的实现类
 * @author 向燕春
 * @date 2017年12月6日
 * @time 上午2:18:08
 *
 */
@Transactional
@Service
public class FundInvestGroupServiceImpl implements FundInvestGroupService {
	@Autowired
	FundInvestGroupReportDao fundInvestGroupDao;
	@Override
	public HashMap<String, Object> selectFundInvestGroups(
											String tableName, 
											String qualification, 
											Integer page,
											Integer rows, 
											Integer rowsTotal, 
											String orderColumn, 
											String orderStyle) {
		//创建一个map集合
		HashMap<String,Object> map = new HashMap<String,Object>();
		tableName="(select se.security_code as securityCode,"
				+ "se.security_name as securityName, "
				+ "nvl(ss.security_quantity,0) as securityQuantity,"
				+ "ss.security_util_cost as securityUnitCost,"
				+ "nvl((ss.security_quantity*ss.security_util_cost),0) as securityCosting,"
				+ "nvl(nv.price,0) as price, "
				+ "nvl((ss.security_quantity*nv.price),0) as marketValue,"
				+ "nv.fund_code as fundCode,nv.statistic_date as statisticDdate "
				+ "from security se join (select * from security_stock) ss "
				+ "on se.security_code=ss.security_code "
				+ "join (select * from net_value) nv "
				+ "on ss.fund_code=nv.fund_code "
				+ "and ss.security_code=nv.project_code "
				+ "and ss.security_statistics_date=nv.statistic_date) tabs";
		map.put("tableName", tableName);
		map.put("qualification",qualification);
		map.put("page",page);
		map.put("rows", rows);
		map.put("rowsTotal",rowsTotal );
		map.put("orderColumn","" );
		map.put("orderStyle","" );
		//调用查询基金投资组合的方法
		fundInvestGroupDao.selectFundInvestGroups(map);
		map.get("list");
		return map;
	}

	@Override
	public String bufferWhere(FundInvestGroup fundInvestGroup) {
		StringBuffer buffer=new StringBuffer("");
		//判断基金代码是否为空
		if(fundInvestGroup.getFundCode()!=null&&!fundInvestGroup.getFundCode().equals("")){
			buffer=buffer.append(" and tabs.fundCode='"+fundInvestGroup.getFundCode()+"'");
		}
		//判断统计日期是否为空
		if(fundInvestGroup.getStatisticDateWhere()!=null&&!fundInvestGroup.getStatisticDateWhere().equals("")){
			buffer =buffer.append("	  and  tabs.statisticDdate  =  to_date(' "+fundInvestGroup.getStatisticDateWhere()+"','yy-MM-dd')");
		}
		String flag=buffer.toString();
		return flag;
	}

	@Override
	public FundInvestGroup selectNetValue(FundInvestGroup fundInvestGroup) {
		return fundInvestGroupDao.selectNetValue(fundInvestGroup);
	}
	@Override
	public FundInvestGroup selectSecurity(FundInvestGroup fundInvestGroup) {
		return fundInvestGroupDao.selectSecurity(fundInvestGroup);
	}

}
