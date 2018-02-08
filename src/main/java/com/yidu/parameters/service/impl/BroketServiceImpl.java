package com.yidu.parameters.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.parameters.dao.BroketDao;
import com.yidu.parameters.domain.Broket;
import com.yidu.parameters.domain.ExchangeRate;
import com.yidu.parameters.service.BroketService;

/**
 * 券商信息业务逻辑处理实现类
 * @author Wang
 * @date 2017年11月16日
 * @time 上午11:08:17
 */
@Service
public class BroketServiceImpl  implements  BroketService{
	@Autowired
	BroketDao broketDao;
	@Override
	public Map<String, Object> selectBorket(Broket broket) {
		String brokerName=broket.getBrokerName();
		StringBuffer qualification=new StringBuffer("");
		if(brokerName!=null&&!brokerName.equals("")){
				try {
					brokerName=new String(brokerName.getBytes("iso8859-1"),"UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			qualification.append(" and broker_name like '%"+brokerName+"%'");
		}
		System.err.println(qualification.toString());
		//分页查询条件map
		Map<String, Object> map=new HashMap<String, Object>();
		//分页条件查询的条件
		map.put("tableName", "broker");
		map.put("qualification", qualification.toString());
		map.put("page", broket.getPage());
		map.put("rows", broket.getRows());
		map.put("orderColumn", "broker_code");
		map.put("orderStyle", broket.getSortOrder());
		//执行查询方法
		broketDao.selectBroket(map);
		//得到交易费率数据的集合
		List<ExchangeRate> broketList=(List<ExchangeRate>) map.get("cursor");
		//得到查询总条数
		int rowsTotal=(int) map.get("rowsTotal");
		//分页集合map
		Map<String, Object> exchangeRateMap=new HashMap<String, Object>();
		exchangeRateMap.put("total", rowsTotal);
		exchangeRateMap.put("rows", broketList);
		return exchangeRateMap;
	}
	@Override
	public int insertBroket(Broket broket) {
		// TODO Auto-generated method stub
		return broketDao.insertBroket(broket);
	}
	@Override
	public int updateBroket(Broket broket) {
		// TODO Auto-generated method stub
		return broketDao.updateBroket(broket);
	}
	@Override
	public int deleteBroket(Broket broket) {
		// TODO Auto-generated method stub
		return broketDao.deleteBroket(broket);
	}
	@Override
	public List<Broket> selectBroketById(String broketCode) {
		// TODO Auto-generated method stub
		return broketDao.selectBroketById(broketCode);
	}

}
