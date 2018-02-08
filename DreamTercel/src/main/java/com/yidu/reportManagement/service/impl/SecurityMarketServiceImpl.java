package com.yidu.reportManagement.service.impl;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.reportManagement.dao.SecurityMarketDao;
import com.yidu.reportManagement.domain.SecurityMarket;
import com.yidu.reportManagement.service.SecurityMarketService;
/**
 * 证券市值变动表实现类
 * @author 邓涛
 * @date 2017年12月8日
 * @time 下午12:16:24
 */
@Transactional
@Service
public class SecurityMarketServiceImpl implements SecurityMarketService{
	@Autowired
	SecurityMarketDao securityMarketDao;
	@Override
	public Map<String,Object> selectSecurityMarket(SecurityMarket securityMarket) {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		StringBuffer buffer=new StringBuffer("");
		if(securityMarket.getBusinessDateWhere()!=null && ! securityMarket.getBusinessDateWhere().equals("")){
			buffer.append(" and statistic_date=  to_date(' "+securityMarket.getBusinessDateWhere()+"','yy-MM-dd')");
		}
		String tableName="(select se.security_code as securityCode,"
				+ "se.security_name as securityName, "
				+ "nvl(ss.security_quantity,0) as securityQuantity,"
				+ "ss.security_util_cost as securityUnitCost,"
				+ "nvl((ss.security_quantity*ss.security_util_cost),0) as securityCosting,"
				+ "nvl(nv.price,0) as price, "
				+ "nvl((ss.security_quantity*nv.price),0) as marketValue,"
				+ "nv.fund_code as fundCode,nv.statistic_date as statisticDate "
				+ "from security se join (select * from security_stock) ss "
				+ "on se.security_code=ss.security_code "
				+ "join (select * from net_value) nv "
				+ "on ss.fund_code=nv.fund_code "
				+ "and ss.security_statistics_date=nv.statistic_date "+buffer.toString()+") ";
		System.out.println(tableName);
		map.put("tableName", tableName);
		map.put("qualification","");
		map.put("page",1);
		map.put("rows",5);
		map.put("rowsTotal",30);
		map.put("orderStyle","");
		securityMarketDao.selectSecurityMarket(map);
		map.get("securityMarketList");
		System.err.println("map================="+map);
		return map;
	}
	@Override
	public SecurityMarket selectNetValue(SecurityMarket securityMarket) {
		return securityMarketDao.selectNetValue(securityMarket);
	}

}
