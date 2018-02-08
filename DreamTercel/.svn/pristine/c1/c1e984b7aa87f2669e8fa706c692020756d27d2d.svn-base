package com.yidu.reportManagement.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.reportManagement.dao.StockFluctuateDao;
import com.yidu.reportManagement.domain.StockFluctuate;
import com.yidu.reportManagement.service.StockFluctuateService;
/**
 * 股票波动实现类
 * @author HeXiXian
 * @date   2017年12月6日
 * @time   下午4:06:11
 *
 */
@Transactional
@Service
public class StockFluctuateImpl implements StockFluctuateService{
	@Autowired
	StockFluctuateDao stockFluctuateDao;
	@Override
	public Map<String, Object> selectFluctuateService(StockFluctuate stockFluctuate) {
		//创建一个StringBuffer类
		StringBuffer swrWhere=new StringBuffer("");
		//判断时间不为null 不为 空字符
		if(stockFluctuate.getStartEnteringDate()!=null&&!stockFluctuate.getStartEnteringDate().equals("")&&stockFluctuate.getEndEnteringDate()!=null&&!stockFluctuate.getEndEnteringDate().equals("")){
			swrWhere.append(" and  t.pd_enteringDate between to_date(' "+stockFluctuate.getStartEnteringDate()+"  ','yyyy-MM-dd')  and to_date(' "+stockFluctuate.getEndEnteringDate()+" ','yyyy-MM-dd')");	
		}
		if(stockFluctuate.getStartEnteringDate()!=null&&!stockFluctuate.getStartEnteringDate().equals("")&&(stockFluctuate.getEndEnteringDate()==null||stockFluctuate.getEndEnteringDate().equals(""))){
			swrWhere.append(" and t.pd_enteringDate >= to_date(' "+stockFluctuate.getStartEnteringDate()+" ','yyyy-MM-dd')");
		}
		if(stockFluctuate.getEndEnteringDate()!=null&&!stockFluctuate.getEndEnteringDate().equals("")&&(stockFluctuate.getStartEnteringDate()==null||stockFluctuate.getStartEnteringDate().equals(""))){
			swrWhere.append(" and t.pd_enteringDate <= to_date(' "+stockFluctuate.getEndEnteringDate()+" ','yyyy-MM-dd') ");
		}
		System.err.println(swrWhere);
		//创建一个hashMap的集合
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("tableName", "(select * from priceData pd join security se on pd.pd_securityCode=se.security_code) t");//put的表名
		map.put("qualification", swrWhere.toString());//条件
		map.put("page", stockFluctuate.getPage());//列
		map.put("rows", stockFluctuate.getRows());//行
		map.put("orderColumn", "t.pd_priceDataCode");//行情数据ID
		map.put("orderStyle", stockFluctuate.getSortOrder());//排序方式
		stockFluctuateDao.selectStockFluctuateDao(map);
		System.err.println("map"+map);
		return map;
	}

}
