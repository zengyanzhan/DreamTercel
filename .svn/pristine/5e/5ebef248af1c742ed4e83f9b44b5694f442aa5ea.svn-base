package com.yidu.parameters.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.parameters.dao.ExchangeRateDao;
import com.yidu.parameters.domain.ExchangeRate;
import com.yidu.parameters.service.ExchangeRateService;

/**
 * 交易品种费率业务处理层实现类
 * @author Wang
 * @date 2017年11月13日
 * @time 下午7:17:02
 */
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{
	@Autowired
	ExchangeRateDao exchangeRateDao;
	@Override
	public Map<String, Object> selectExchangeRate(ExchangeRate exchangeRate) {
		//条件拼接
		StringBuffer qualification=new StringBuffer("");
		//根据交易所名称模糊查询
		if(exchangeRate.getExchangeName()!=null&&!exchangeRate.getExchangeName().equals("")){
			qualification.append("   and  exchange_name  like '%"+exchangeRate.getExchangeName()+"%'");
		}
		//根据费率类型查询
		if(exchangeRate.getExchangeType()!=null&&!exchangeRate.getExchangeType().equals("")){
			qualification.append("  and exchange_type = "+exchangeRate.getExchangeType());
		}
		//分页查询条件map
		Map<String, Object> map=new HashMap<String, Object>();
		//分页条件查询的条件
		map.put("tableName", "exchange_breed_rate");
		map.put("qualification", qualification.toString());
		map.put("page", exchangeRate.getPage());
		map.put("rows", exchangeRate.getRows());
		map.put("orderColumn", "exchange_code");
		map.put("orderStyle", exchangeRate.getSortOrder());
		//执行查询方法
		exchangeRateDao.selectExchangeRate(map);
		//得到交易费率数据的集合
		List<ExchangeRate> exchangeRateList=(List<ExchangeRate>) map.get("cursor");
		//得到查询总条数
		int rowsTotal=(int) map.get("rowsTotal");
		//分页集合map
		Map<String, Object> exchangeRateMap=new HashMap<String, Object>();
		exchangeRateMap.put("total", rowsTotal);
		exchangeRateMap.put("rows", exchangeRateList);
		return exchangeRateMap;
	}
	@Override
	public int insertExchangeRate(ExchangeRate exchangeRate) {
		
		return exchangeRateDao.insertExchangeRate(exchangeRate);
	}
	@Override
	public int updateExchangeRate(ExchangeRate exchangeRate) {
		// TODO Auto-generated method stub
		return exchangeRateDao.updateExchangeRate(exchangeRate);
	}
	@Override
	public int deleteExchangeRate(ExchangeRate exchangeRate) {
		// TODO Auto-generated method stub
		return exchangeRateDao.deleteExchangeRate(exchangeRate);
	}
	@Override
	public List<ExchangeRate> selectExchangeRateById(String exchangeCode) {
		// TODO Auto-generated method stub
		return exchangeRateDao.selectExchangeRateById(exchangeCode);
	}
	@Override
	public List<ExchangeRate> selectExchangeRateByExchangeNameAndSecurityType(ExchangeRate exchangeRate) {
		
		return exchangeRateDao.selectExchangeRateByExchangeNameAndSecurityType(exchangeRate);
	}
	@Override
	public List<ExchangeRate> selectExchangeNameSel(ExchangeRate exchangeRate) {
		// TODO Auto-generated method stub
		List<ExchangeRate> exchangeRateList=exchangeRateDao.selectExchangeNameSel(exchangeRate);
				
		return exchangeRateList;
	}

}
